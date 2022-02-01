package com.tencent.mm.plugin.appbrand.jsapi.ae;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.networking.d;
import com.tencent.mm.plugin.appbrand.networking.e;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetNetworkTypeWxa;", "Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetNetworkType;", "Lcom/tencent/mm/plugin/appbrand/networking/IOnNetworkStateChanged;", "()V", "mCached", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetNetworkType$NetworkType;", "mCanUseCache", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mNetworkServiceInitialized", "getNetworkType", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "onNetworkStateChanged", "", "Companion", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends k
  implements e
{
  private static final l.a swS;
  private final AtomicReference<k.c> swT;
  private final AtomicBoolean swU;
  private final AtomicBoolean swV;
  
  static
  {
    AppMethodBeat.i(135580);
    swS = new l.a((byte)0);
    AppMethodBeat.o(135580);
  }
  
  public l()
  {
    AppMethodBeat.i(135579);
    this.swT = new AtomicReference(null);
    this.swU = new AtomicBoolean(false);
    this.swV = new AtomicBoolean(false);
    AppMethodBeat.o(135579);
  }
  
  protected final k.c I(f paramf)
  {
    AppMethodBeat.i(135577);
    s.u(paramf, "component");
    Object localObject;
    if (!this.swU.getAndSet(true))
    {
      localObject = (d)paramf.T(d.class);
      if (localObject != null)
      {
        ((d)localObject).a((e)this);
        this.swV.set(true);
      }
    }
    if (this.swV.get())
    {
      k.c localc = (k.c)this.swT.get();
      localObject = localc;
      if (localc == null)
      {
        localObject = super.I(paramf);
        this.swT.set(localObject);
      }
      s.s(localObject, "{\n            mCached.ge…t(fromSystem) }\n        }");
      AppMethodBeat.o(135577);
      return localObject;
    }
    paramf = super.I(paramf);
    s.s(paramf, "{\n            super.getN…Type(component)\n        }");
    AppMethodBeat.o(135577);
    return paramf;
  }
  
  public final void onNetworkStateChanged()
  {
    AppMethodBeat.i(135578);
    this.swT.set(null);
    AppMethodBeat.o(135578);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ae.l
 * JD-Core Version:    0.7.0.1
 */