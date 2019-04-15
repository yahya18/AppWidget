package com.example.yahya.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.widget.RemoteViews;

/**
 * Implementation of App Widget functionality.
 */
public class NewAppWidget extends AppWidgetProvider {

    public static final String TOGGLE_SENTER = "TOGGLE_SENTER";

    public static boolean NYALA = false;


    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int id : appWidgetIds) {
            Intent toggleIntent = new Intent(context, NewAppWidget.class);
            toggleIntent.setAction(TOGGLE_SENTER);
            PendingIntent pendingToggleIntent = PendingIntent.getBroadcast(context, 0,
                    toggleIntent, 0);
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.new_app_widget);
            views.setOnClickPendingIntent(R.id.tombol, pendingToggleIntent);
            appWidgetManager.updateAppWidget(id, views);
        }
    }

    @Override
    public void onReceive(@NonNull Context context, @NonNull Intent intent) {
        super.onReceive(context, intent);
        if (intent.getAction().equals(TOGGLE_SENTER)) {
            NYALA = !NYALA;
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.new_app_widget);
            int iconBaru = NYALA ? R.drawable.lampu_on: R.drawable.lampu_off;
            if (NYALA) {
                nyalakanSenter();
            } else {
                matikanSenter();
            }
            views.setInt(R.id.tombol, "setImageResource", iconBaru);
            appWidgetManager.updateAppWidget(new ComponentName(context, NewAppWidget.class), views);
        }
    }

    public void nyalakanSenter() {

    }

    public void matikanSenter() {

    }

}

