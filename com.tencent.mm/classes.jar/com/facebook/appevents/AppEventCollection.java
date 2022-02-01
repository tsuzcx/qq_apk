package com.facebook.appevents;

import android.content.Context;
import com.facebook.FacebookSdk;
import com.facebook.internal.AttributionIdentifiers;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class AppEventCollection
{
  private final HashMap<AccessTokenAppIdPair, SessionEventsState> stateMap;
  
  public AppEventCollection()
  {
    AppMethodBeat.i(17313);
    this.stateMap = new HashMap();
    AppMethodBeat.o(17313);
  }
  
  private SessionEventsState getSessionEventsState(AccessTokenAppIdPair paramAccessTokenAppIdPair)
  {
    try
    {
      AppMethodBeat.i(17319);
      SessionEventsState localSessionEventsState = (SessionEventsState)this.stateMap.get(paramAccessTokenAppIdPair);
      Object localObject = localSessionEventsState;
      if (localSessionEventsState == null)
      {
        localObject = FacebookSdk.getApplicationContext();
        localObject = new SessionEventsState(AttributionIdentifiers.getAttributionIdentifiers((Context)localObject), AppEventsLogger.getAnonymousAppDeviceGUID((Context)localObject));
      }
      this.stateMap.put(paramAccessTokenAppIdPair, localObject);
      AppMethodBeat.o(17319);
      return localObject;
    }
    finally {}
  }
  
  public void addEvent(AccessTokenAppIdPair paramAccessTokenAppIdPair, AppEvent paramAppEvent)
  {
    try
    {
      AppMethodBeat.i(17315);
      getSessionEventsState(paramAccessTokenAppIdPair).addEvent(paramAppEvent);
      AppMethodBeat.o(17315);
      return;
    }
    finally
    {
      paramAccessTokenAppIdPair = finally;
      throw paramAccessTokenAppIdPair;
    }
  }
  
  public void addPersistedEvents(PersistedEvents paramPersistedEvents)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(17314);
        if (paramPersistedEvents == null)
        {
          AppMethodBeat.o(17314);
          return;
        }
        Iterator localIterator = paramPersistedEvents.keySet().iterator();
        if (localIterator.hasNext())
        {
          Object localObject = (AccessTokenAppIdPair)localIterator.next();
          SessionEventsState localSessionEventsState = getSessionEventsState((AccessTokenAppIdPair)localObject);
          localObject = paramPersistedEvents.get((AccessTokenAppIdPair)localObject).iterator();
          if (((Iterator)localObject).hasNext()) {
            localSessionEventsState.addEvent((AppEvent)((Iterator)localObject).next());
          }
        }
        else
        {
          AppMethodBeat.o(17314);
        }
      }
      finally {}
    }
  }
  
  public SessionEventsState get(AccessTokenAppIdPair paramAccessTokenAppIdPair)
  {
    try
    {
      AppMethodBeat.i(17317);
      paramAccessTokenAppIdPair = (SessionEventsState)this.stateMap.get(paramAccessTokenAppIdPair);
      AppMethodBeat.o(17317);
      return paramAccessTokenAppIdPair;
    }
    finally
    {
      paramAccessTokenAppIdPair = finally;
      throw paramAccessTokenAppIdPair;
    }
  }
  
  public int getEventCount()
  {
    try
    {
      AppMethodBeat.i(17318);
      Iterator localIterator = this.stateMap.values().iterator();
      for (int i = 0; localIterator.hasNext(); i = ((SessionEventsState)localIterator.next()).getAccumulatedEventCount() + i) {}
      AppMethodBeat.o(17318);
      return i;
    }
    finally {}
  }
  
  public Set<AccessTokenAppIdPair> keySet()
  {
    try
    {
      AppMethodBeat.i(17316);
      Set localSet = this.stateMap.keySet();
      AppMethodBeat.o(17316);
      return localSet;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.appevents.AppEventCollection
 * JD-Core Version:    0.7.0.1
 */