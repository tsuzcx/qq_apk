package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.o;
import com.tencent.mm.vending.e.a;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public final class an
  implements o
{
  final Set<a> jia;
  
  public an()
  {
    AppMethodBeat.i(176540);
    this.jia = new CopyOnWriteArraySet();
    AppMethodBeat.o(176540);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(176542);
    if (parama != null) {
      this.jia.remove(parama);
    }
    AppMethodBeat.o(176542);
  }
  
  public final void keep(a parama)
  {
    AppMethodBeat.i(176541);
    if (parama != null) {
      this.jia.add(parama);
    }
    AppMethodBeat.o(176541);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.an
 * JD-Core Version:    0.7.0.1
 */