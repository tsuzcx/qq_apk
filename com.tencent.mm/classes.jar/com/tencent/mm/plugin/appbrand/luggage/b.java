package com.tencent.mm.plugin.appbrand.luggage;

import com.tencent.luggage.bridge.a.a.a;
import com.tencent.luggage.bridge.a.a.c;
import com.tencent.luggage.bridge.impl.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.e;
import com.tencent.mm.plugin.appbrand.jsapi.base.g;
import com.tencent.mm.plugin.appbrand.luggage.b.p;

public final class b
  extends a
{
  private final g lNY;
  
  public b()
  {
    AppMethodBeat.i(121605);
    this.lNY = new p();
    AppMethodBeat.o(121605);
  }
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(121607);
    super.a(parama);
    parama.a(g.class, this.lNY);
    AppMethodBeat.o(121607);
  }
  
  public final void a(a.c paramc)
  {
    AppMethodBeat.i(121606);
    super.a(paramc);
    paramc.a(g.class, this.lNY);
    paramc.a(e.class, com.tencent.mm.plugin.appbrand.dynamic.b.b.bfW());
    AppMethodBeat.o(121606);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b
 * JD-Core Version:    0.7.0.1
 */