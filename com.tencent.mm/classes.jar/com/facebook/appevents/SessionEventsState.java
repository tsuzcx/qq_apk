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
    AppMethodBeat.i(72018);
    this.accumulatedEvents = new ArrayList();
    this.inFlightEvents = new ArrayList();
    this.MAX_ACCUMULATED_LOG_EVENTS = 1000;
    this.attributionIdentifiers = paramAttributionIdentifiers;
    this.anonymousAppDeviceGUID = paramString;
    AppMethodBeat.o(72018);
  }
  
  private void populateRequest(GraphRequest paramGraphRequest, Context paramContext, int paramInt, JSONArray paramJSONArray, boolean paramBoolean)
  {
    AppMethodBeat.i(72025);
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
    AppMethodBeat.o(72025);
  }
  
  public void accumulatePersistedEvents(List<AppEvent> paramList)
  {
    try
    {
      AppMethodBeat.i(72024);
      this.accumulatedEvents.addAll(paramList);
      AppMethodBeat.o(72024);
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
    //   2: ldc 119
    //   4: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 32	com/facebook/appevents/SessionEventsState:accumulatedEvents	Ljava/util/List;
    //   11: invokeinterface 123 1 0
    //   16: aload_0
    //   17: getfield 34	com/facebook/appevents/SessionEventsState:inFlightEvents	Ljava/util/List;
    //   20: invokeinterface 123 1 0
    //   25: iadd
    //   26: sipush 1000
    //   29: if_icmplt +21 -> 50
    //   32: aload_0
    //   33: aload_0
    //   34: getfield 63	com/facebook/appevents/SessionEventsState:numSkippedEventsDueToFullBuffer	I
    //   37: iconst_1
    //   38: iadd
    //   39: putfield 63	com/facebook/appevents/SessionEventsState:numSkippedEventsDueToFullBuffer	I
    //   42: ldc 119
    //   44: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: aload_0
    //   48: monitorexit
    //   49: return
    //   50: aload_0
    //   51: getfield 32	com/facebook/appevents/SessionEventsState:accumulatedEvents	Ljava/util/List;
    //   54: aload_1
    //   55: invokeinterface 127 2 0
    //   60: pop
    //   61: ldc 119
    //   63: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: goto -19 -> 47
    //   69: astore_1
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	SessionEventsState
    //   0	74	1	paramAppEvent	AppEvent
    // Exception table:
    //   from	to	target	type
    //   2	47	69	finally
    //   50	66	69	finally
  }
  
  public void clearInFlightAndStats(boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(72021);
      if (paramBoolean) {
        this.accumulatedEvents.addAll(this.inFlightEvents);
      }
      this.inFlightEvents.clear();
      this.numSkippedEventsDueToFullBuffer = 0;
      AppMethodBeat.o(72021);
      return;
    }
    finally {}
  }
  
  public int getAccumulatedEventCount()
  {
    try
    {
      AppMethodBeat.i(72020);
      int i = this.accumulatedEvents.size();
      AppMethodBeat.o(72020);
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
      AppMethodBeat.i(72023);
      List localList = this.accumulatedEvents;
      this.accumulatedEvents = new ArrayList();
      AppMethodBeat.o(72023);
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
    AppMethodBeat.i(72022);
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
        AppMethodBeat.o(72022);
      }
    }
    if (localJSONArray.length() == 0)
    {
      AppMethodBeat.o(72022);
      return 0;
    }
    populateRequest(paramGraphRequest, paramContext, i, localJSONArray, paramBoolean2);
    int i = localJSONArray.length();
    AppMethodBeat.o(72022);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.appevents.SessionEventsState
 * JD-Core Version:    0.7.0.1
 */