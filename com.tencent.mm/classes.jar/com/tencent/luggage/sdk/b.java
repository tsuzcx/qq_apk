package com.tencent.luggage.sdk;

import com.tencent.luggage.bridge.a.a.c;
import com.tencent.luggage.sdk.a.a;
import com.tencent.luggage.sdk.b.a.d.c.a;
import com.tencent.luggage.sdk.b.a.d.e;
import com.tencent.luggage.sdk.b.a.d.k;
import com.tencent.luggage.sdk.customize.impl.FullSdkExternalToolsHelper;
import com.tencent.luggage.sdk.h.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.f;
import com.tencent.mm.plugin.appbrand.af.h;
import com.tencent.mm.plugin.appbrand.af.r.a;
import com.tencent.mm.plugin.appbrand.jsapi.aj;
import com.tencent.mm.plugin.appbrand.page.bh.a;
import com.tencent.mm.plugin.appbrand.widget.input.aq.a;
import com.tencent.mm.sdk.platformtools.Log;

public class b
  extends c
{
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
        paramc.a(aj.class, new FullSdkExternalToolsHelper());
        paramc.a(r.a.class, new a());
        paramc.a(bh.a.class, new aq.a());
        paramc.a(h.class, new f());
        b.this.aqz();
        AppMethodBeat.o(146680);
      }
    });
    AppMethodBeat.o(146681);
  }
  
  protected void aqz()
  {
    AppMethodBeat.i(146682);
    Log.i("Luggage.FullSdkLuggageInitDelegate", "hy: trigger registerServiceLogicImp");
    e.arL().a(new c.a(), com.tencent.luggage.sdk.b.a.d.c.class);
    e.arL().a(k.esX, k.class);
    AppMethodBeat.o(146682);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.sdk.b
 * JD-Core Version:    0.7.0.1
 */