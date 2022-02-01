package com.tencent.luggage.sdk;

import com.tencent.luggage.bridge.a.a.c;
import com.tencent.luggage.sdk.a.a;
import com.tencent.luggage.sdk.b.a.c.b.a;
import com.tencent.luggage.sdk.b.a.c.d;
import com.tencent.luggage.sdk.b.a.c.i;
import com.tencent.luggage.sdk.customize.impl.FullSdkExternalToolsHelper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.plugin.appbrand.page.bb.a;
import com.tencent.mm.plugin.appbrand.widget.input.al.a;
import com.tencent.mm.plugin.appbrand.y.p.a;
import com.tencent.mm.sdk.platformtools.ae;

public class b
  extends c
{
  protected void DY()
  {
    AppMethodBeat.i(146682);
    ae.i("Luggage.FullSdkLuggageInitDelegate", "hy: trigger registerServiceLogicImp");
    d.EW().a(new b.a(), com.tencent.luggage.sdk.b.a.c.b.class);
    d.EW().a(i.cpb, i.class);
    AppMethodBeat.o(146682);
  }
  
  public void a(final a.c paramc)
  {
    AppMethodBeat.i(146681);
    com.tencent.luggage.sdk.g.c.a("NanoSdkLuggageInitDelegate", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146679);
        b.a(b.this, paramc);
        AppMethodBeat.o(146679);
      }
    });
    com.tencent.luggage.sdk.g.c.a("FullSdkLuggageInitDelegate", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146680);
        paramc.a(ac.class, new FullSdkExternalToolsHelper());
        paramc.a(p.a.class, new a());
        paramc.a(bb.a.class, new al.a());
        b.this.DY();
        AppMethodBeat.o(146680);
      }
    });
    AppMethodBeat.o(146681);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.b
 * JD-Core Version:    0.7.0.1
 */