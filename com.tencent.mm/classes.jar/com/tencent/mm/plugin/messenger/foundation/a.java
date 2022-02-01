package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.plugin.messenger.foundation.a.b;
import com.tencent.mm.storage.cc;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
  implements b
{
  private ConcurrentHashMap<Integer, com.tencent.mm.plugin.messenger.foundation.a.a> KQl;
  
  public a()
  {
    AppMethodBeat.i(288640);
    this.KQl = new ConcurrentHashMap();
    AppMethodBeat.o(288640);
  }
  
  public final void a(g.a parama, cc paramcc, Map<String, String> paramMap)
  {
    AppMethodBeat.i(288652);
    com.tencent.mm.plugin.messenger.foundation.a.a locala = (com.tencent.mm.plugin.messenger.foundation.a.a)this.KQl.get(Integer.valueOf(paramcc.getType()));
    if (locala != null) {
      locala.a(parama, paramcc, paramMap);
    }
    AppMethodBeat.o(288652);
  }
  
  public final void a(com.tencent.mm.plugin.messenger.foundation.a.a parama)
  {
    AppMethodBeat.i(288643);
    if (!this.KQl.contains(Integer.valueOf(1075839025))) {
      this.KQl.put(Integer.valueOf(1075839025), parama);
    }
    AppMethodBeat.o(288643);
  }
  
  public final boolean b(g.a parama, cc paramcc, Map<String, String> paramMap)
  {
    AppMethodBeat.i(288648);
    com.tencent.mm.plugin.messenger.foundation.a.a locala = (com.tencent.mm.plugin.messenger.foundation.a.a)this.KQl.get(Integer.valueOf(paramcc.getType()));
    if (locala != null) {}
    for (boolean bool = locala.b(parama, paramcc, paramMap);; bool = true)
    {
      AppMethodBeat.o(288648);
      return bool;
    }
  }
  
  public final void gaS()
  {
    AppMethodBeat.i(288646);
    this.KQl.remove(Integer.valueOf(1075839025));
    AppMethodBeat.o(288646);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.a
 * JD-Core Version:    0.7.0.1
 */