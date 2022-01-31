package com.tencent.mm.plugin.appbrand.luggage;

import com.tencent.luggage.bridge.a.a.a;
import com.tencent.luggage.bridge.a.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.e;
import com.tencent.mm.plugin.appbrand.jsapi.e.m;
import com.tencent.mm.plugin.appbrand.m.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class a
  extends com.tencent.luggage.bridge.impl.a
{
  private static e hoj;
  
  static
  {
    AppMethodBeat.i(132090);
    hoj = new com.tencent.mm.plugin.appbrand.luggage.a.c();
    AppMethodBeat.o(132090);
  }
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(132089);
    ab.i("MicroMsg.LuggageInitDelegateWxImpl", "onInitComponent %s", new Object[] { ah.getProcessName() });
    super.a(parama);
    AppMethodBeat.o(132089);
  }
  
  public final void a(a.c paramc)
  {
    AppMethodBeat.i(132088);
    ab.i("MicroMsg.LuggageInitDelegateWxImpl", "onInitialize %s", new Object[] { ah.getProcessName() });
    super.a(paramc);
    paramc.a(e.class, hoj);
    paramc.a(o.class, new com.tencent.mm.plugin.appbrand.luggage.c.c());
    paramc.a(com.tencent.mm.plugin.appbrand.t.b.a.class, new m());
    AppMethodBeat.o(132088);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.a
 * JD-Core Version:    0.7.0.1
 */