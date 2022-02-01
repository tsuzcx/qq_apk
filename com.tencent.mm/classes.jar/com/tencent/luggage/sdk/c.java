package com.tencent.luggage.sdk;

import com.tencent.luggage.bridge.a.a.a;
import com.tencent.luggage.bridge.a.a.c;
import com.tencent.luggage.sdk.customize.impl.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.p.a;
import com.tencent.mm.plugin.appbrand.jsapi.af.b;
import com.tencent.mm.plugin.appbrand.ui.ah;

public class c
  extends com.tencent.luggage.bridge.impl.a
{
  public void a(a.a parama)
  {
    AppMethodBeat.i(139818);
    super.a(parama);
    AppMethodBeat.o(139818);
  }
  
  public void a(a.c paramc)
  {
    AppMethodBeat.i(139817);
    super.a(paramc);
    paramc.a(ah.class, new d());
    paramc.a(p.a.class, new com.tencent.luggage.sdk.customize.impl.e());
    paramc.a(com.tencent.luggage.c.a.a.class, new com.tencent.luggage.c.a.a.a());
    paramc.a(com.tencent.mm.plugin.appbrand.jsapi.af.a.c.class, new com.tencent.mm.plugin.appbrand.jsapi.af.a.e());
    paramc.a(b.class, new com.tencent.mm.plugin.appbrand.jsapi.af.a());
    AppMethodBeat.o(139817);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.c
 * JD-Core Version:    0.7.0.1
 */