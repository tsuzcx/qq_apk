package com.tencent.mm.plugin.appbrand.jsapi.x;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.networking.d;
import d.g.b.p;
import d.l;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetNetworkTypeWxa;", "Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetNetworkType;", "Lcom/tencent/mm/plugin/appbrand/networking/IOnNetworkStateChanged;", "()V", "mCached", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetNetworkType$NetworkType;", "mCanUseCache", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mNetworkServiceInitialized", "getNetworkType", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "onNetworkStateChanged", "", "Companion", "luggage-wxa-app_release"})
public final class g
  extends f
  implements d
{
  @Deprecated
  public static final g.a ljF;
  private final AtomicReference<f.c> ljC;
  private final AtomicBoolean ljD;
  private final AtomicBoolean ljE;
  
  static
  {
    AppMethodBeat.i(135580);
    ljF = new g.a((byte)0);
    AppMethodBeat.o(135580);
  }
  
  public g()
  {
    AppMethodBeat.i(135579);
    this.ljC = new AtomicReference(null);
    this.ljD = new AtomicBoolean(false);
    this.ljE = new AtomicBoolean(false);
    AppMethodBeat.o(135579);
  }
  
  protected final f.c C(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    AppMethodBeat.i(135577);
    p.h(paramc, "component");
    Object localObject;
    if (!this.ljD.getAndSet(true))
    {
      localObject = (com.tencent.mm.plugin.appbrand.networking.c)paramc.K(com.tencent.mm.plugin.appbrand.networking.c.class);
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.appbrand.networking.c)localObject).a((d)this);
        this.ljE.set(true);
      }
    }
    if (this.ljE.get())
    {
      f.c localc = (f.c)this.ljC.get();
      localObject = localc;
      if (localc == null)
      {
        paramc = super.C(paramc);
        this.ljC.set(paramc);
        p.g(paramc, "super.getNetworkType(com…mCached.set(fromSystem) }");
        AppMethodBeat.o(135577);
        return paramc;
      }
    }
    else
    {
      localObject = super.C(paramc);
      p.g(localObject, "super.getNetworkType(component)");
    }
    AppMethodBeat.o(135577);
    return localObject;
  }
  
  public final void bmF()
  {
    AppMethodBeat.i(135578);
    this.ljC.set(null);
    AppMethodBeat.o(135578);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.x.g
 * JD-Core Version:    0.7.0.1
 */