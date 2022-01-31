package com.facebook.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.d;
import com.facebook.appevents.AppEventsLogger;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Set;

public class BoltsMeasurementEventListener
  extends BroadcastReceiver
{
  private static final String BOLTS_MEASUREMENT_EVENT_PREFIX = "bf_";
  private static final String MEASUREMENT_EVENT_ARGS_KEY = "event_args";
  private static final String MEASUREMENT_EVENT_NAME_KEY = "event_name";
  private static final String MEASUREMENT_EVENT_NOTIFICATION_NAME = "com.parse.bolts.measurement_event";
  private static BoltsMeasurementEventListener _instance;
  private Context applicationContext;
  
  private BoltsMeasurementEventListener(Context paramContext)
  {
    AppMethodBeat.i(72244);
    this.applicationContext = paramContext.getApplicationContext();
    AppMethodBeat.o(72244);
  }
  
  private void close()
  {
    AppMethodBeat.i(72246);
    d.R(this.applicationContext).unregisterReceiver(this);
    AppMethodBeat.o(72246);
  }
  
  public static BoltsMeasurementEventListener getInstance(Context paramContext)
  {
    AppMethodBeat.i(72247);
    if (_instance != null)
    {
      paramContext = _instance;
      AppMethodBeat.o(72247);
      return paramContext;
    }
    paramContext = new BoltsMeasurementEventListener(paramContext);
    _instance = paramContext;
    paramContext.open();
    paramContext = _instance;
    AppMethodBeat.o(72247);
    return paramContext;
  }
  
  private void open()
  {
    AppMethodBeat.i(72245);
    d.R(this.applicationContext).a(this, new IntentFilter("com.parse.bolts.measurement_event"));
    AppMethodBeat.o(72245);
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(72248);
    try
    {
      close();
      return;
    }
    finally
    {
      super.finalize();
      AppMethodBeat.o(72248);
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(72249);
    paramContext = AppEventsLogger.newLogger(paramContext);
    String str1 = "bf_" + paramIntent.getStringExtra("event_name");
    paramIntent = paramIntent.getBundleExtra("event_args");
    Bundle localBundle = new Bundle();
    Iterator localIterator = paramIntent.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      localBundle.putString(str2.replaceAll("[^0-9a-zA-Z _-]", "-").replaceAll("^[ -]*", "").replaceAll("[ -]*$", ""), (String)paramIntent.get(str2));
    }
    paramContext.logEvent(str1, localBundle);
    AppMethodBeat.o(72249);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.internal.BoltsMeasurementEventListener
 * JD-Core Version:    0.7.0.1
 */