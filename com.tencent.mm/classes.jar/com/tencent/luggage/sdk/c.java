package com.tencent.luggage.sdk;

import com.tencent.luggage.bridge.a.a.a;
import com.tencent.luggage.bridge.a.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.jsapi.t.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.t.a.j;
import com.tencent.mm.plugin.appbrand.s.q.a;
import com.tencent.mm.plugin.appbrand.ui.s;

public class c
  extends com.tencent.luggage.bridge.impl.a
{
  public void a(a.a parama)
  {
    AppMethodBeat.i(114300);
    super.a(parama);
    AppMethodBeat.o(114300);
  }
  
  public void a(a.c paramc)
  {
    AppMethodBeat.i(114299);
    super.a(paramc);
    paramc.a(s.class, new com.tencent.luggage.sdk.customize.impl.a());
    paramc.a(q.a.class, new com.tencent.luggage.sdk.customize.impl.b());
    paramc.a(com.tencent.luggage.c.a.a.class, new com.tencent.luggage.c.a.a.a());
    paramc.a(n.class, com.tencent.mm.plugin.appbrand.appcache.c.gTP);
    paramc.a(e.class, new j());
    paramc.a(com.tencent.mm.plugin.appbrand.jsapi.t.c.class, new com.tencent.mm.plugin.appbrand.jsapi.t.b());
    AppMethodBeat.o(114299);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.c
 * JD-Core Version:    0.7.0.1
 */