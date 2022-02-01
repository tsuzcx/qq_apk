package com.facebook.appevents;

import android.content.Context;
import android.os.Bundle;
import com.facebook.GraphRequest;
import com.facebook.appevents.internal.AppEventsLoggerUtility;
import com.facebook.appevents.internal.AppEventsLoggerUtility.GraphAPIActivityType;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class SessionEventsState
{
  private final int MAX_ACCUMULATED_LOG_EVENTS;
  private List<AppEvent> accumulatedEvents;
  private String anonymousAppDeviceGUID;
  private AttributionIdentifiers attributionIdentifiers;
  private List<AppEvent> inFlightEvents;
  private int numSkippedEventsDueToFullBuffer;
  
  public SessionEventsState(AttributionIdentifiers paramAttributionIdentifiers, String paramString)
  {
    AppMethodBeat.i(17454);
    this.accumulatedEvents = new ArrayList();
    this.inFlightEvents = new ArrayList();
    this.MAX_ACCUMULATED_LOG_EVENTS = 1000;
    this.attributionIdentifiers = paramAttributionIdentifiers;
    this.anonymousAppDeviceGUID = paramString;
    AppMethodBeat.o(17454);
  }
  
  private void populateRequest(GraphRequest paramGraphRequest, Context paramContext, int paramInt, JSONArray paramJSONArray, boolean paramBoolean)
  {
    AppMethodBeat.i(17461);
    try
    {
      localObject = AppEventsLoggerUtility.getJSONObjectForGraphAPICall(AppEventsLoggerUtility.GraphAPIActivityType.CUSTOM_APP_EVENTS, this.attributionIdentifiers, this.anonymousAppDeviceGUID, paramBoolean, paramContext);
      paramContext = (Context)localObject;
      if (this.numSkippedEventsDueToFullBuffer > 0)
      {
        ((JSONObject)localObject).put("num_skipped_events", paramInt);
        paramContext = (Context)localObject;
      }
    }
    catch (JSONException paramContext)
    {
      for (;;)
      {
        Object localObject;
        paramContext = new JSONObject();
      }
    }
    paramGraphRequest.setGraphObject(paramContext);
    localObject = paramGraphRequest.getParameters();
    paramContext = (Context)localObject;
    if (localObject == null) {
      paramContext = new Bundle();
    }
    paramJSONArray = paramJSONArray.toString();
    if (paramJSONArray != null)
    {
      paramContext.putString("custom_events", paramJSONArray);
      paramGraphRequest.setTag(paramJSONArray);
    }
    paramGraphRequest.setParameters(paramContext);
    AppMethodBeat.o(17461);
  }
  
  public void accumulatePersistedEvents(List<AppEvent> paramList)
  {
    try
    {
      AppMethodBeat.i(17460);
      this.accumulatedEvents.addAll(paramList);
      AppMethodBeat.o(17460);
      return;
    }
    finally
    {
      paramList = finally;
      throw paramList;
    }
  }
  
  /* Error */
  public void addEvent(AppEvent paramAppEvent)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 17455
    //   5: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 31	com/facebook/appevents/SessionEventsState:accumulatedEvents	Ljava/util/List;
    //   12: invokeinterface 119 1 0
    //   17: aload_0
    //   18: getfield 33	com/facebook/appevents/SessionEventsState:inFlightEvents	Ljava/util/List;
    //   21: invokeinterface 119 1 0
    //   26: iadd
    //   27: sipush 1000
    //   30: if_icmplt +22 -> 52
    //   33: aload_0
    //   34: aload_0
    //   35: getfield 61	com/facebook/appevents/SessionEventsState:numSkippedEventsDueToFullBuffer	I
    //   38: iconst_1
    //   39: iadd
    //   40: putfield 61	com/facebook/appevents/SessionEventsState:numSkippedEventsDueToFullBuffer	I
    //   43: sipush 17455
    //   46: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: aload_0
    //   50: monitorexit
    //   51: return
    //   52: aload_0
    //   53: getfield 31	com/facebook/appevents/SessionEventsState:accumulatedEvents	Ljava/util/List;
    //   56: aload_1
    //   57: invokeinterface 123 2 0
    //   62: pop
    //   63: sipush 17455
    //   66: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: goto -20 -> 49
    //   72: astore_1
    //   73: aload_0
    //   74: monitorexit
    //   75: aload_1
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	SessionEventsState
    //   0	77	1	paramAppEvent	AppEvent
    // Exception table:
    //   from	to	target	type
    //   2	49	72	finally
    //   52	69	72	finally
  }
  
  public void clearInFlightAndStats(boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(17457);
      if (paramBoolean) {
        this.accumulatedEvents.addAll(this.inFlightEvents);
      }
      this.inFlightEvents.clear();
      this.numSkippedEventsDueToFullBuffer = 0;
      AppMethodBeat.o(17457);
      return;
    }
    finally {}
  }
  
  public int getAccumulatedEventCount()
  {
    try
    {
      AppMethodBeat.i(17456);
      int i = this.accumulatedEvents.size();
      AppMethodBeat.o(17456);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public List<AppEvent> getEventsToPersist()
  {
    try
    {
      AppMethodBeat.i(17459);
      List localList = this.accumulatedEvents;
      this.accumulatedEvents = new ArrayList();
      AppMethodBeat.o(17459);
      return localList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int populateRequest(GraphRequest paramGraphRequest, Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(17458);
    JSONArray localJSONArray;
    for (;;)
    {
      try
      {
        i = this.numSkippedEventsDueToFullBuffer;
        this.inFlightEvents.addAll(this.accumulatedEvents);
        this.accumulatedEvents.clear();
        localJSONArray = new JSONArray();
        Iterator localIterator = this.inFlightEvents.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        AppEvent localAppEvent = (AppEvent)localIterator.next();
        if (localAppEvent.isChecksumValid())
        {
          if ((paramBoolean1) || (!localAppEvent.getIsImplicit())) {
            localJSONArray.put(localAppEvent.getJSONObject());
          }
        }
        else {
          Utility.logd("Event with invalid checksum: %s", localAppEvent.toString());
        }
      }
      finally
      {
        AppMethodBeat.o(17458);
      }
    }
    if (localJSONArray.length() == 0)
    {
      AppMethodBeat.o(17458);
      return 0;
    }
    populateRequest(paramGraphRequest, paramContext, i, localJSONArray, paramBoolean2);
    int i = localJSONArray.length();
    AppMethodBeat.o(17458);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.appevents.SessionEventsState
 * JD-Core Version:    0.7.0.1
 */