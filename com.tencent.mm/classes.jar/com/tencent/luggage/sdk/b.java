package com.tencent.luggage.sdk;

import com.tencent.luggage.bridge.a.a.c;
import com.tencent.luggage.sdk.a.a;
import com.tencent.luggage.sdk.b.a.c.b.a;
import com.tencent.luggage.sdk.b.a.c.g;
import com.tencent.luggage.sdk.customize.impl.FullSdkExternalToolsHelper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.x;
import com.tencent.mm.plugin.appbrand.page.as.a;
import com.tencent.mm.plugin.appbrand.s.q.a;
import com.tencent.mm.plugin.appbrand.widget.input.al.a;

public class b
  extends c
{
  public void a(a.c paramc)
  {
    AppMethodBeat.i(140675);
    super.a(paramc);
    paramc.a(x.class, new FullSdkExternalToolsHelper());
    paramc.a(q.a.class, new a());
    paramc.a(as.a.class, new al.a());
    vU();
    AppMethodBeat.o(140675);
  }
  
  protected void vU()
  {
    AppMethodBeat.i(140676);
    com.tencent.luggage.g.d.i("Luggage.FullSdkLuggageInitDelegate", "hy: trigger registerServiceLogicImp");
    com.tencent.luggage.sdk.b.a.c.d.wL().a(new b.a(), com.tencent.luggage.sdk.b.a.c.b.class);
    com.tencent.luggage.sdk.b.a.c.d.wL().a(g.bEQ, g.class);
    AppMethodBeat.o(140676);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.sdk.b
 * JD-Core Version:    0.7.0.1
 */