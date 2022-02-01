package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.u;
import com.tencent.mm.vending.e.a;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public final class bi
  implements u
{
  final Set<a> qyA;
  
  public bi()
  {
    AppMethodBeat.i(176540);
    this.qyA = new CopyOnWriteArraySet();
    AppMethodBeat.o(176540);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(176542);
    if (parama != null) {
      this.qyA.remove(parama);
    }
    AppMethodBeat.o(176542);
  }
  
  public final void keep(a parama)
  {
    AppMethodBeat.i(176541);
    if (parama != null) {
      this.qyA.add(parama);
    }
    AppMethodBeat.o(176541);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.bi
 * JD-Core Version:    0.7.0.1
 */