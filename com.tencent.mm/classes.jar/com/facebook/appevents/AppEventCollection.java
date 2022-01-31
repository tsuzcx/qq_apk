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
    AppMethodBeat.i(71877);
    this.stateMap = new HashMap();
    AppMethodBeat.o(71877);
  }
  
  private SessionEventsState getSessionEventsState(AccessTokenAppIdPair paramAccessTokenAppIdPair)
  {
    try
    {
      AppMethodBeat.i(71883);
      SessionEventsState localSessionEventsState = (SessionEventsState)this.stateMap.get(paramAccessTokenAppIdPair);
      Object localObject = localSessionEventsState;
      if (localSessionEventsState == null)
      {
        localObject = FacebookSdk.getApplicationContext();
        localObject = new SessionEventsState(AttributionIdentifiers.getAttributionIdentifiers((Context)localObject), AppEventsLogger.getAnonymousAppDeviceGUID((Context)localObject));
      }
      this.stateMap.put(paramAccessTokenAppIdPair, localObject);
      AppMethodBeat.o(71883);
      return localObject;
    }
    finally {}
  }
  
  public void addEvent(AccessTokenAppIdPair paramAccessTokenAppIdPair, AppEvent paramAppEvent)
  {
    try
    {
      AppMethodBeat.i(71879);
      getSessionEventsState(paramAccessTokenAppIdPair).addEvent(paramAppEvent);
      AppMethodBeat.o(71879);
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
        AppMethodBeat.i(71878);
        if (paramPersistedEvents == null)
        {
          AppMethodBeat.o(71878);
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
          AppMethodBeat.o(71878);
        }
      }
      finally {}
    }
  }
  
  public SessionEventsState get(AccessTokenAppIdPair paramAccessTokenAppIdPair)
  {
    try
    {
      AppMethodBeat.i(71881);
      paramAccessTokenAppIdPair = (SessionEventsState)this.stateMap.get(paramAccessTokenAppIdPair);
      AppMethodBeat.o(71881);
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
      AppMethodBeat.i(71882);
      Iterator localIterator = this.stateMap.values().iterator();
      for (int i = 0; localIterator.hasNext(); i = ((SessionEventsState)localIterator.next()).getAccumulatedEventCount() + i) {}
      AppMethodBeat.o(71882);
      return i;
    }
    finally {}
  }
  
  public Set<AccessTokenAppIdPair> keySet()
  {
    try
    {
      AppMethodBeat.i(71880);
      Set localSet = this.stateMap.keySet();
      AppMethodBeat.o(71880);
      return localSet;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.facebook.appevents.AppEventCollection
 * JD-Core Version:    0.7.0.1
 */