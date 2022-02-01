package com.tencent.mm.plugin.appbrand.jsapi.ab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.networking.d;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetNetworkTypeWxa;", "Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetNetworkType;", "Lcom/tencent/mm/plugin/appbrand/networking/IOnNetworkStateChanged;", "()V", "mCached", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetNetworkType$NetworkType;", "mCanUseCache", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mNetworkServiceInitialized", "getNetworkType", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "onNetworkStateChanged", "", "Companion", "luggage-wxa-app_release"})
public final class h
  extends g
  implements com.tencent.mm.plugin.appbrand.networking.e
{
  @Deprecated
  public static final h.a psh;
  private final AtomicReference<g.c> pse;
  private final AtomicBoolean psf;
  private final AtomicBoolean psg;
  
  static
  {
    AppMethodBeat.i(135580);
    psh = new h.a((byte)0);
    AppMethodBeat.o(135580);
  }
  
  public h()
  {
    AppMethodBeat.i(135579);
    this.pse = new AtomicReference(null);
    this.psf = new AtomicBoolean(false);
    this.psg = new AtomicBoolean(false);
    AppMethodBeat.o(135579);
  }
  
  protected final g.c G(com.tencent.mm.plugin.appbrand.jsapi.e parame)
  {
    AppMethodBeat.i(135577);
    p.k(parame, "component");
    Object localObject;
    if (!this.psf.getAndSet(true))
    {
      localObject = (d)parame.K(d.class);
      if (localObject != null)
      {
        ((d)localObject).a((com.tencent.mm.plugin.appbrand.networking.e)this);
        this.psg.set(true);
      }
    }
    if (this.psg.get())
    {
      g.c localc = (g.c)this.pse.get();
      localObject = localc;
      if (localc == null)
      {
        parame = super.G(parame);
        this.pse.set(parame);
        p.j(parame, "super.getNetworkType(com…mCached.set(fromSystem) }");
        AppMethodBeat.o(135577);
        return parame;
      }
    }
    else
    {
      localObject = super.G(parame);
      p.j(localObject, "super.getNetworkType(component)");
    }
    AppMethodBeat.o(135577);
    return localObject;
  }
  
  public final void bUB()
  {
    AppMethodBeat.i(135578);
    this.pse.set(null);
    AppMethodBeat.o(135578);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ab.h
 * JD-Core Version:    0.7.0.1
 */