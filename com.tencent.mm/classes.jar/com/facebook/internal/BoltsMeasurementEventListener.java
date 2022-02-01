package com.facebook.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.h.a.a;
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
    AppMethodBeat.i(17680);
    this.applicationContext = paramContext.getApplicationContext();
    AppMethodBeat.o(17680);
  }
  
  private void close()
  {
    AppMethodBeat.i(17682);
    a.V(this.applicationContext).unregisterReceiver(this);
    AppMethodBeat.o(17682);
  }
  
  public static BoltsMeasurementEventListener getInstance(Context paramContext)
  {
    AppMethodBeat.i(17683);
    if (_instance != null)
    {
      paramContext = _instance;
      AppMethodBeat.o(17683);
      return paramContext;
    }
    paramContext = new BoltsMeasurementEventListener(paramContext);
    _instance = paramContext;
    paramContext.open();
    paramContext = _instance;
    AppMethodBeat.o(17683);
    return paramContext;
  }
  
  private void open()
  {
    AppMethodBeat.i(17681);
    a.V(this.applicationContext).a(this, new IntentFilter("com.parse.bolts.measurement_event"));
    AppMethodBeat.o(17681);
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(17684);
    try
    {
      close();
      return;
    }
    finally
    {
      super.finalize();
      AppMethodBeat.o(17684);
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(17685);
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
    AppMethodBeat.o(17685);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.internal.BoltsMeasurementEventListener
 * JD-Core Version:    0.7.0.1
 */