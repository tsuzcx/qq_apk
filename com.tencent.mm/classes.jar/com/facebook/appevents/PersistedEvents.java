package com.facebook.appevents;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

class PersistedEvents
  implements Serializable
{
  private static final long serialVersionUID = 20160629001L;
  private HashMap<AccessTokenAppIdPair, List<AppEvent>> events;
  
  public PersistedEvents()
  {
    AppMethodBeat.i(17447);
    this.events = new HashMap();
    AppMethodBeat.o(17447);
  }
  
  public PersistedEvents(HashMap<AccessTokenAppIdPair, List<AppEvent>> paramHashMap)
  {
    AppMethodBeat.i(17448);
    this.events = new HashMap();
    this.events.putAll(paramHashMap);
    AppMethodBeat.o(17448);
  }
  
  private Object writeReplace()
  {
    AppMethodBeat.i(17453);
    SerializationProxyV1 localSerializationProxyV1 = new SerializationProxyV1(this.events, null);
    AppMethodBeat.o(17453);
    return localSerializationProxyV1;
  }
  
  public void addEvents(AccessTokenAppIdPair paramAccessTokenAppIdPair, List<AppEvent> paramList)
  {
    AppMethodBeat.i(17452);
    if (!this.events.containsKey(paramAccessTokenAppIdPair))
    {
      this.events.put(paramAccessTokenAppIdPair, paramList);
      AppMethodBeat.o(17452);
      return;
    }
    ((List)this.events.get(paramAccessTokenAppIdPair)).addAll(paramList);
    AppMethodBeat.o(17452);
  }
  
  public boolean containsKey(AccessTokenAppIdPair paramAccessTokenAppIdPair)
  {
    AppMethodBeat.i(17451);
    boolean bool = this.events.containsKey(paramAccessTokenAppIdPair);
    AppMethodBeat.o(17451);
    return bool;
  }
  
  public List<AppEvent> get(AccessTokenAppIdPair paramAccessTokenAppIdPair)
  {
    AppMethodBeat.i(17450);
    paramAccessTokenAppIdPair = (List)this.events.get(paramAccessTokenAppIdPair);
    AppMethodBeat.o(17450);
    return paramAccessTokenAppIdPair;
  }
  
  public Set<AccessTokenAppIdPair> keySet()
  {
    AppMethodBeat.i(17449);
    Set localSet = this.events.keySet();
    AppMethodBeat.o(17449);
    return localSet;
  }
  
  static class SerializationProxyV1
    implements Serializable
  {
    private static final long serialVersionUID = 20160629001L;
    private final HashMap<AccessTokenAppIdPair, List<AppEvent>> proxyEvents;
    
    private SerializationProxyV1(HashMap<AccessTokenAppIdPair, List<AppEvent>> paramHashMap)
    {
      this.proxyEvents = paramHashMap;
    }
    
    private Object readResolve()
    {
      AppMethodBeat.i(17446);
      PersistedEvents localPersistedEvents = new PersistedEvents(this.proxyEvents);
      AppMethodBeat.o(17446);
      return localPersistedEvents;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.appevents.PersistedEvents
 * JD-Core Version:    0.7.0.1
 */