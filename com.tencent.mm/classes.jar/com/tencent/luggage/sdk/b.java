package com.tencent.luggage.sdk;

import com.tencent.luggage.bridge.a.a.c;
import com.tencent.luggage.sdk.a.a;
import com.tencent.luggage.sdk.b.a.c.c.a;
import com.tencent.luggage.sdk.b.a.c.e;
import com.tencent.luggage.sdk.b.a.c.k;
import com.tencent.luggage.sdk.customize.impl.FullSdkExternalToolsHelper;
import com.tencent.luggage.sdk.h.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.p.a;
import com.tencent.mm.plugin.appbrand.jsapi.ag;
import com.tencent.mm.plugin.appbrand.page.bh.a;
import com.tencent.mm.plugin.appbrand.widget.input.aq.a;
import com.tencent.mm.sdk.platformtools.Log;

public class b
  extends c
{
  protected void Qp()
  {
    AppMethodBeat.i(146682);
    Log.i("Luggage.FullSdkLuggageInitDelegate", "hy: trigger registerServiceLogicImp");
    e.Rx().a(new c.a(), com.tencent.luggage.sdk.b.a.c.c.class);
    e.Rx().a(k.cAC, k.class);
    AppMethodBeat.o(146682);
  }
  
  public void a(final a.c paramc)
  {
    AppMethodBeat.i(146681);
    d.a("NanoSdkLuggageInitDelegate", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146679);
        b.a(b.this, paramc);
        AppMethodBeat.o(146679);
      }
    });
    d.a("FullSdkLuggageInitDelegate", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146680);
        paramc.a(ag.class, new FullSdkExternalToolsHelper());
        paramc.a(p.a.class, new a());
        paramc.a(bh.a.class, new aq.a());
        b.this.Qp();
        AppMethodBeat.o(146680);
      }
    });
    AppMethodBeat.o(146681);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.b
 * JD-Core Version:    0.7.0.1
 */