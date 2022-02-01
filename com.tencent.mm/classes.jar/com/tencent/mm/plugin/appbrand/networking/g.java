package com.tencent.mm.plugin.appbrand.networking;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.ab.a;
import com.tencent.mm.plugin.appbrand.v;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/networking/NetworkServiceImpl;", "Lcom/tencent/mm/plugin/appbrand/networking/INetworkService;", "Lcom/tencent/mm/kernel/service/IServiceLifeCycle;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "mListeners", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lcom/tencent/mm/plugin/appbrand/networking/IOnNetworkStateChanged;", "mRuntime", "getMRuntime", "()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "addListener", "", "l", "notifyNetworkStateChanged", "onRegister", "onUnregister", "removeListener", "luggage-wxa-app_release"})
public class g
  implements b, d
{
  final AppBrandRuntime nxs;
  @TargetApi(21)
  private final ConcurrentLinkedDeque<e> qlb;
  
  public g(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(135591);
    this.nxs = paramAppBrandRuntime;
    this.qlb = new ConcurrentLinkedDeque();
    AppMethodBeat.o(135591);
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(135590);
    this.qlb.add(parame);
    AppMethodBeat.o(135590);
  }
  
  public void aIF()
  {
    AppMethodBeat.i(135587);
    a((e)new a(this));
    AppMethodBeat.o(135587);
  }
  
  public void aIG()
  {
    AppMethodBeat.i(135588);
    this.qlb.clear();
    AppMethodBeat.o(135588);
  }
  
  public final void ccw()
  {
    AppMethodBeat.i(135589);
    Object localObject = this.nxs.QW();
    if (localObject != null)
    {
      if (((v)localObject).isRunning() == true)
      {
        localObject = this.qlb.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((e)((Iterator)localObject).next()).bUB();
        }
      }
    }
    else
    {
      AppMethodBeat.o(135589);
      return;
    }
    AppMethodBeat.o(135589);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onNetworkStateChanged"})
  static final class a
    implements e
  {
    a(g paramg) {}
    
    public final void bUB()
    {
      AppMethodBeat.i(135586);
      a.o((com.tencent.mm.plugin.appbrand.jsapi.e)this.qlc.nxs.QW());
      AppMethodBeat.o(135586);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.networking.g
 * JD-Core Version:    0.7.0.1
 */