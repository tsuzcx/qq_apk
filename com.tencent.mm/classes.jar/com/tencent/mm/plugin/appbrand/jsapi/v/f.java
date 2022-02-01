package com.tencent.mm.plugin.appbrand.jsapi.v;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.networking.b;
import d.g.b.k;
import d.l;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetNetworkTypeWxa;", "Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetNetworkType;", "Lcom/tencent/mm/plugin/appbrand/networking/IOnNetworkStateChanged;", "()V", "mCached", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetNetworkType$NetworkType;", "mCanUseCache", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mNetworkServiceInitialized", "getNetworkType", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "onNetworkStateChanged", "", "Companion", "luggage-wxa-app_release"})
public final class f
  extends e
  implements com.tencent.mm.plugin.appbrand.networking.c
{
  @Deprecated
  public static final a klK;
  private final AtomicReference<e.c> klH;
  private final AtomicBoolean klI;
  private final AtomicBoolean klJ;
  
  static
  {
    AppMethodBeat.i(135580);
    klK = new a((byte)0);
    AppMethodBeat.o(135580);
  }
  
  public f()
  {
    AppMethodBeat.i(135579);
    this.klH = new AtomicReference(null);
    this.klI = new AtomicBoolean(false);
    this.klJ = new AtomicBoolean(false);
    AppMethodBeat.o(135579);
  }
  
  protected final e.c C(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    AppMethodBeat.i(135577);
    k.h(paramc, "component");
    Object localObject;
    if (!this.klI.getAndSet(true))
    {
      localObject = (b)paramc.K(b.class);
      if (localObject != null)
      {
        ((b)localObject).a((com.tencent.mm.plugin.appbrand.networking.c)this);
        this.klJ.set(true);
      }
    }
    if (this.klJ.get())
    {
      e.c localc = (e.c)this.klH.get();
      localObject = localc;
      if (localc == null)
      {
        paramc = super.C(paramc);
        this.klH.set(paramc);
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
  
  public final void bbY()
  {
    AppMethodBeat.i(135578);
    this.klH.set(null);
    AppMethodBeat.o(135578);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetNetworkTypeWxa$Companion;", "", "()V", "TAG", "", "luggage-wxa-app_release"})
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v.f
 * JD-Core Version:    0.7.0.1
 */