package com.tencent.mm.plugin.appbrand.networking;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.ae.a;
import com.tencent.mm.plugin.appbrand.jsapi.ae.k;
import com.tencent.mm.plugin.appbrand.jsapi.ae.k.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/networking/NetworkServiceImpl;", "Lcom/tencent/mm/plugin/appbrand/networking/INetworkService;", "Lcom/tencent/mm/kernel/service/IServiceLifeCycle;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "mListeners", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lcom/tencent/mm/plugin/appbrand/networking/IOnNetworkStateChanged;", "mRuntime", "getMRuntime", "()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "addListener", "", "l", "notifyNetworkStateChanged", "onRegister", "onUnregister", "removeListener", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public class g
  implements b, d
{
  private final AppBrandRuntime qwG;
  private final ConcurrentLinkedDeque<e> tpY;
  
  public g(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(135591);
    this.qwG = paramAppBrandRuntime;
    this.tpY = new ConcurrentLinkedDeque();
    AppMethodBeat.o(135591);
  }
  
  private static final void a(g paramg)
  {
    AppMethodBeat.i(317263);
    kotlin.g.b.s.u(paramg, "this$0");
    paramg = (f)paramg.qwG.ari();
    HashMap localHashMap = new HashMap();
    MMApplicationContext.getContext();
    k.c localc = k.cuM();
    if (localc != k.c.swK) {}
    for (boolean bool = true;; bool = false)
    {
      localHashMap.put("isConnected", Boolean.valueOf(bool));
      localHashMap.put("networkType", localc.value);
      Log.i("MicroMsg.AppBrandOnNetworkStatusChangeEvent", "networkType = %s", new Object[] { localc.value });
      new a().h(paramg).K(localHashMap).cpV();
      AppMethodBeat.o(317263);
      return;
    }
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(135590);
    if (parame != null) {
      this.tpY.add(parame);
    }
    AppMethodBeat.o(135590);
  }
  
  public void bbB()
  {
    AppMethodBeat.i(135587);
    a(new g..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(135587);
  }
  
  public void bbC()
  {
    AppMethodBeat.i(135588);
    this.tpY.clear();
    AppMethodBeat.o(135588);
  }
  
  public final void cCS()
  {
    int i = 1;
    AppMethodBeat.i(135589);
    Object localObject = this.qwG.ari();
    if ((localObject != null) && (((y)localObject).isRunning() == true)) {}
    while (i != 0)
    {
      localObject = this.tpY.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((e)((Iterator)localObject).next()).onNetworkStateChanged();
      }
      i = 0;
    }
    AppMethodBeat.o(135589);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.networking.g
 * JD-Core Version:    0.7.0.1
 */