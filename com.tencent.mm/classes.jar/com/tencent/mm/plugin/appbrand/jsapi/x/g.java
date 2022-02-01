package com.tencent.mm.plugin.appbrand.jsapi.x;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.networking.d;
import com.tencent.mm.plugin.appbrand.networking.e;
import d.g.b.p;
import d.l;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetNetworkTypeWxa;", "Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetNetworkType;", "Lcom/tencent/mm/plugin/appbrand/networking/IOnNetworkStateChanged;", "()V", "mCached", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetNetworkType$NetworkType;", "mCanUseCache", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mNetworkServiceInitialized", "getNetworkType", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "onNetworkStateChanged", "", "Companion", "luggage-wxa-app_release"})
public final class g
  extends f
  implements e
{
  @Deprecated
  public static final a lns;
  private final AtomicReference<f.c> lnp;
  private final AtomicBoolean lnq;
  private final AtomicBoolean lnr;
  
  static
  {
    AppMethodBeat.i(135580);
    lns = new a((byte)0);
    AppMethodBeat.o(135580);
  }
  
  public g()
  {
    AppMethodBeat.i(135579);
    this.lnp = new AtomicReference(null);
    this.lnq = new AtomicBoolean(false);
    this.lnr = new AtomicBoolean(false);
    AppMethodBeat.o(135579);
  }
  
  protected final f.c C(c paramc)
  {
    AppMethodBeat.i(135577);
    p.h(paramc, "component");
    Object localObject;
    if (!this.lnq.getAndSet(true))
    {
      localObject = (d)paramc.K(d.class);
      if (localObject != null)
      {
        ((d)localObject).a((e)this);
        this.lnr.set(true);
      }
    }
    if (this.lnr.get())
    {
      f.c localc = (f.c)this.lnp.get();
      localObject = localc;
      if (localc == null)
      {
        paramc = super.C(paramc);
        this.lnp.set(paramc);
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
  
  public final void bno()
  {
    AppMethodBeat.i(135578);
    this.lnp.set(null);
    AppMethodBeat.o(135578);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetNetworkTypeWxa$Companion;", "", "()V", "TAG", "", "luggage-wxa-app_release"})
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.x.g
 * JD-Core Version:    0.7.0.1
 */