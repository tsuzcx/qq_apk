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
    AppMethodBeat.i(72011);
    this.events = new HashMap();
    AppMethodBeat.o(72011);
  }
  
  public PersistedEvents(HashMap<AccessTokenAppIdPair, List<AppEvent>> paramHashMap)
  {
    AppMethodBeat.i(72012);
    this.events = new HashMap();
    this.events.putAll(paramHashMap);
    AppMethodBeat.o(72012);
  }
  
  private Object writeReplace()
  {
    AppMethodBeat.i(72017);
    PersistedEvents.SerializationProxyV1 localSerializationProxyV1 = new PersistedEvents.SerializationProxyV1(this.events, null);
    AppMethodBeat.o(72017);
    return localSerializationProxyV1;
  }
  
  public void addEvents(AccessTokenAppIdPair paramAccessTokenAppIdPair, List<AppEvent> paramList)
  {
    AppMethodBeat.i(72016);
    if (!this.events.containsKey(paramAccessTokenAppIdPair))
    {
      this.events.put(paramAccessTokenAppIdPair, paramList);
      AppMethodBeat.o(72016);
      return;
    }
    ((List)this.events.get(paramAccessTokenAppIdPair)).addAll(paramList);
    AppMethodBeat.o(72016);
  }
  
  public boolean containsKey(AccessTokenAppIdPair paramAccessTokenAppIdPair)
  {
    AppMethodBeat.i(72015);
    boolean bool = this.events.containsKey(paramAccessTokenAppIdPair);
    AppMethodBeat.o(72015);
    return bool;
  }
  
  public List<AppEvent> get(AccessTokenAppIdPair paramAccessTokenAppIdPair)
  {
    AppMethodBeat.i(72014);
    paramAccessTokenAppIdPair = (List)this.events.get(paramAccessTokenAppIdPair);
    AppMethodBeat.o(72014);
    return paramAccessTokenAppIdPair;
  }
  
  public Set<AccessTokenAppIdPair> keySet()
  {
    AppMethodBeat.i(72013);
    Set localSet = this.events.keySet();
    AppMethodBeat.o(72013);
    return localSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.facebook.appevents.PersistedEvents
 * JD-Core Version:    0.7.0.1
 */