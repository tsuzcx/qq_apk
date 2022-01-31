package com.tencent.mm.plugin.appbrand.jsapi.r;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.networking.b;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetNetworkTypeWxa;", "Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetNetworkType;", "Lcom/tencent/mm/plugin/appbrand/networking/IOnNetworkStateChanged;", "()V", "mCached", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetNetworkType$NetworkType;", "mCanUseCache", "", "getNetworkType", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "onNetworkStateChanged", "", "onRegistered", "onUnregistered", "Companion", "luggage-wxa-app_release"})
public final class e
  extends d
  implements com.tencent.mm.plugin.appbrand.networking.c
{
  @Deprecated
  public static final e.a iaS;
  private final AtomicReference<d.a> iaQ;
  private boolean iaR;
  
  static
  {
    AppMethodBeat.i(87579);
    iaS = new e.a((byte)0);
    AppMethodBeat.o(87579);
  }
  
  public e()
  {
    AppMethodBeat.i(87578);
    this.iaQ = new AtomicReference(null);
    AppMethodBeat.o(87578);
  }
  
  public final void aEI()
  {
    AppMethodBeat.i(87575);
    this.iaQ.set(null);
    AppMethodBeat.o(87575);
  }
  
  public final void g(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    AppMethodBeat.i(87576);
    j.q(paramc, "component");
    paramc = (b)paramc.q(b.class);
    if (paramc != null)
    {
      paramc.a((com.tencent.mm.plugin.appbrand.networking.c)this);
      this.iaR = true;
      AppMethodBeat.o(87576);
      return;
    }
    AppMethodBeat.o(87576);
  }
  
  public final void h(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    AppMethodBeat.i(87577);
    j.q(paramc, "component");
    paramc = (b)paramc.q(b.class);
    if (paramc != null)
    {
      paramc.b((com.tencent.mm.plugin.appbrand.networking.c)this);
      AppMethodBeat.o(87577);
      return;
    }
    AppMethodBeat.o(87577);
  }
  
  protected final d.a x(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    AppMethodBeat.i(87574);
    j.q(paramc, "component");
    long l = System.nanoTime();
    d.a locala1;
    if (this.iaR)
    {
      d.a locala2 = (d.a)this.iaQ.get();
      locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = super.x(paramc);
        this.iaQ.set(locala1);
      }
    }
    for (;;)
    {
      l = System.nanoTime() - l;
      com.tencent.luggage.g.d.v("Luggage.Wxa.JsApiGetNetworkTypeWxa", "getNetworkType cost[ %d ns, %d ms] ret[%s]", new Object[] { Long.valueOf(l), Long.valueOf(TimeUnit.NANOSECONDS.toMillis(l)), locala1.value });
      j.p(locala1, "type");
      AppMethodBeat.o(87574);
      return locala1;
      locala1 = super.x(paramc);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.r.e
 * JD-Core Version:    0.7.0.1
 */