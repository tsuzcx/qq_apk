package com.tencent.mm.plugin.appbrand.jsapi.z;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.networking.d;
import com.tencent.mm.plugin.appbrand.networking.e;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetNetworkTypeWxa;", "Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetNetworkType;", "Lcom/tencent/mm/plugin/appbrand/networking/IOnNetworkStateChanged;", "()V", "mCached", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetNetworkType$NetworkType;", "mCanUseCache", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mNetworkServiceInitialized", "getNetworkType", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "onNetworkStateChanged", "", "Companion", "luggage-wxa-app_release"})
public final class g
  extends f
  implements e
{
  @Deprecated
  public static final a mtW;
  private final AtomicReference<f.c> mtT;
  private final AtomicBoolean mtU;
  private final AtomicBoolean mtV;
  
  static
  {
    AppMethodBeat.i(135580);
    mtW = new a((byte)0);
    AppMethodBeat.o(135580);
  }
  
  public g()
  {
    AppMethodBeat.i(135579);
    this.mtT = new AtomicReference(null);
    this.mtU = new AtomicBoolean(false);
    this.mtV = new AtomicBoolean(false);
    AppMethodBeat.o(135579);
  }
  
  protected final f.c D(com.tencent.mm.plugin.appbrand.jsapi.f paramf)
  {
    AppMethodBeat.i(135577);
    p.h(paramf, "component");
    Object localObject;
    if (!this.mtU.getAndSet(true))
    {
      localObject = (d)paramf.M(d.class);
      if (localObject != null)
      {
        ((d)localObject).a((e)this);
        this.mtV.set(true);
      }
    }
    if (this.mtV.get())
    {
      f.c localc = (f.c)this.mtT.get();
      localObject = localc;
      if (localc == null)
      {
        paramf = super.D(paramf);
        this.mtT.set(paramf);
        p.g(paramf, "super.getNetworkType(com…mCached.set(fromSystem) }");
        AppMethodBeat.o(135577);
        return paramf;
      }
    }
    else
    {
      localObject = super.D(paramf);
      p.g(localObject, "super.getNetworkType(component)");
    }
    AppMethodBeat.o(135577);
    return localObject;
  }
  
  public final void bIS()
  {
    AppMethodBeat.i(135578);
    this.mtT.set(null);
    AppMethodBeat.o(135578);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetNetworkTypeWxa$Companion;", "", "()V", "TAG", "", "luggage-wxa-app_release"})
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.z.g
 * JD-Core Version:    0.7.0.1
 */