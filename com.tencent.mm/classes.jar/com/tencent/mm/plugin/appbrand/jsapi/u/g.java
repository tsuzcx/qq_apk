package com.tencent.mm.plugin.appbrand.jsapi.u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.networking.b;
import d.g.b.k;
import d.l;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetNetworkTypeWxa;", "Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetNetworkType;", "Lcom/tencent/mm/plugin/appbrand/networking/IOnNetworkStateChanged;", "()V", "mCached", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetNetworkType$NetworkType;", "mCanUseCache", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mNetworkServiceInitialized", "getNetworkType", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "onNetworkStateChanged", "", "Companion", "luggage-wxa-app_release"})
public final class g
  extends f
  implements com.tencent.mm.plugin.appbrand.networking.c
{
  @Deprecated
  public static final a kNc;
  private final AtomicReference<f.c> kMZ;
  private final AtomicBoolean kNa;
  private final AtomicBoolean kNb;
  
  static
  {
    AppMethodBeat.i(135580);
    kNc = new a((byte)0);
    AppMethodBeat.o(135580);
  }
  
  public g()
  {
    AppMethodBeat.i(135579);
    this.kMZ = new AtomicReference(null);
    this.kNa = new AtomicBoolean(false);
    this.kNb = new AtomicBoolean(false);
    AppMethodBeat.o(135579);
  }
  
  protected final f.c C(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    AppMethodBeat.i(135577);
    k.h(paramc, "component");
    Object localObject;
    if (!this.kNa.getAndSet(true))
    {
      localObject = (b)paramc.K(b.class);
      if (localObject != null)
      {
        ((b)localObject).a((com.tencent.mm.plugin.appbrand.networking.c)this);
        this.kNb.set(true);
      }
    }
    if (this.kNb.get())
    {
      f.c localc = (f.c)this.kMZ.get();
      localObject = localc;
      if (localc == null)
      {
        paramc = super.C(paramc);
        this.kMZ.set(paramc);
        k.g(paramc, "super.getNetworkType(com…mCached.set(fromSystem) }");
        AppMethodBeat.o(135577);
        return paramc;
      }
    }
    else
    {
      localObject = super.C(paramc);
      k.g(localObject, "super.getNetworkType(component)");
    }
    AppMethodBeat.o(135577);
    return localObject;
  }
  
  public final void biT()
  {
    AppMethodBeat.i(135578);
    this.kMZ.set(null);
    AppMethodBeat.o(135578);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetNetworkTypeWxa$Companion;", "", "()V", "TAG", "", "luggage-wxa-app_release"})
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.g
 * JD-Core Version:    0.7.0.1
 */