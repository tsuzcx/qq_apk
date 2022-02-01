package com.tencent.mm.plugin.appbrand.networking;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.x.a;
import com.tencent.mm.plugin.appbrand.r;
import d.l;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/networking/NetworkServiceImpl;", "Lcom/tencent/mm/plugin/appbrand/networking/INetworkService;", "Lcom/tencent/mm/kernel/service/IServiceLifeCycle;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "mListeners", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lcom/tencent/mm/plugin/appbrand/networking/IOnNetworkStateChanged;", "mRuntime", "getMRuntime", "()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "addListener", "", "l", "notifyNetworkStateChanged", "onRegister", "onUnregister", "removeListener", "luggage-wxa-app_release"})
public class g
  implements b, d
{
  final AppBrandRuntime jDb;
  @TargetApi(21)
  private final ConcurrentLinkedDeque<e> mbS;
  
  public g(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(135591);
    this.jDb = paramAppBrandRuntime;
    this.mbS = new ConcurrentLinkedDeque();
    AppMethodBeat.o(135591);
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(135590);
    this.mbS.add(parame);
    AppMethodBeat.o(135590);
  }
  
  public void akM()
  {
    AppMethodBeat.i(135587);
    a((e)new a(this));
    AppMethodBeat.o(135587);
  }
  
  public void akN()
  {
    AppMethodBeat.i(135588);
    this.mbS.clear();
    AppMethodBeat.o(135588);
  }
  
  public final void buh()
  {
    AppMethodBeat.i(135589);
    Object localObject = this.jDb.Ey();
    if (localObject != null)
    {
      if (((r)localObject).isRunning() == true)
      {
        localObject = this.mbS.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((e)((Iterator)localObject).next()).bno();
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "onNetworkStateChanged"})
  static final class a
    implements e
  {
    a(g paramg) {}
    
    public final void bno()
    {
      AppMethodBeat.i(135586);
      a.m((c)this.mbT.jDb.Ey());
      AppMethodBeat.o(135586);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.networking.g
 * JD-Core Version:    0.7.0.1
 */