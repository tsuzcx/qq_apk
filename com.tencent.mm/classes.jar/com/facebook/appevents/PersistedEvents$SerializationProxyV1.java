package com.facebook.appevents;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

class PersistedEvents$SerializationProxyV1
  implements Serializable
{
  private static final long serialVersionUID = 20160629001L;
  private final HashMap<AccessTokenAppIdPair, List<AppEvent>> proxyEvents;
  
  private PersistedEvents$SerializationProxyV1(HashMap<AccessTokenAppIdPair, List<AppEvent>> paramHashMap)
  {
    this.proxyEvents = paramHashMap;
  }
  
  private Object readResolve()
  {
    AppMethodBeat.i(72010);
    PersistedEvents localPersistedEvents = new PersistedEvents(this.proxyEvents);
    AppMethodBeat.o(72010);
    return localPersistedEvents;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.appevents.PersistedEvents.SerializationProxyV1
 * JD-Core Version:    0.7.0.1
 */