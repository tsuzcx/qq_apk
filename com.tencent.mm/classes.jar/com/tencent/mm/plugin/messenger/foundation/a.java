package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.b;
import com.tencent.mm.storage.ca;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
  implements b
{
  private ConcurrentHashMap<Integer, com.tencent.mm.plugin.messenger.foundation.a.a> EUM;
  
  public a()
  {
    AppMethodBeat.i(187699);
    this.EUM = new ConcurrentHashMap();
    AppMethodBeat.o(187699);
  }
  
  public final void a(h.a parama, ca paramca, Map<String, String> paramMap)
  {
    AppMethodBeat.i(187708);
    com.tencent.mm.plugin.messenger.foundation.a.a locala = (com.tencent.mm.plugin.messenger.foundation.a.a)this.EUM.get(Integer.valueOf(paramca.getType()));
    if (locala != null) {
      locala.a(parama, paramca, paramMap);
    }
    AppMethodBeat.o(187708);
  }
  
  public final void a(com.tencent.mm.plugin.messenger.foundation.a.a parama)
  {
    AppMethodBeat.i(187701);
    if (!this.EUM.contains(Integer.valueOf(1075839025))) {
      this.EUM.put(Integer.valueOf(1075839025), parama);
    }
    AppMethodBeat.o(187701);
  }
  
  public final boolean b(h.a parama, ca paramca, Map<String, String> paramMap)
  {
    AppMethodBeat.i(187705);
    com.tencent.mm.plugin.messenger.foundation.a.a locala = (com.tencent.mm.plugin.messenger.foundation.a.a)this.EUM.get(Integer.valueOf(paramca.getType()));
    if (locala != null) {}
    for (boolean bool = locala.b(parama, paramca, paramMap);; bool = true)
    {
      AppMethodBeat.o(187705);
      return bool;
    }
  }
  
  public final void eRX()
  {
    AppMethodBeat.i(187703);
    this.EUM.remove(Integer.valueOf(1075839025));
    AppMethodBeat.o(187703);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.a
 * JD-Core Version:    0.7.0.1
 */