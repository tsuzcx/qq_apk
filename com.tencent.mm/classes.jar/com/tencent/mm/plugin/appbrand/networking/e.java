package com.tencent.mm.plugin.appbrand.networking;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.v.a;
import com.tencent.mm.plugin.appbrand.q;
import d.l;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/networking/NetworkServiceImpl;", "Lcom/tencent/mm/plugin/appbrand/networking/INetworkService;", "Lcom/tencent/mm/kernel/service/IServiceLifeCycle;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "mListeners", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lcom/tencent/mm/plugin/appbrand/networking/IOnNetworkStateChanged;", "mRuntime", "getMRuntime", "()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "addListener", "", "l", "notifyNetworkStateChanged", "onRegister", "onUnregister", "removeListener", "luggage-wxa-app_release"})
public class e
  implements com.tencent.mm.kernel.c.b, b
{
  final AppBrandRuntime iGV;
  @TargetApi(21)
  private final ConcurrentLinkedDeque<c> kWj;
  
  public e(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(135591);
    this.iGV = paramAppBrandRuntime;
    this.kWj = new ConcurrentLinkedDeque();
    AppMethodBeat.o(135591);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(135590);
    this.kWj.add(paramc);
    AppMethodBeat.o(135590);
  }
  
  public void agv()
  {
    AppMethodBeat.i(135587);
    a((c)new a(this));
    AppMethodBeat.o(135587);
  }
  
  public void agw()
  {
    AppMethodBeat.i(135588);
    this.kWj.clear();
    AppMethodBeat.o(135588);
  }
  
  public final void biD()
  {
    AppMethodBeat.i(135589);
    Object localObject = this.iGV.Du();
    if (localObject != null)
    {
      if (((q)localObject).isRunning() == true)
      {
        localObject = this.kWj.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((c)((Iterator)localObject).next()).bbY();
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
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "onNetworkStateChanged"})
  static final class a
    implements c
  {
    a(e parame) {}
    
    public final void bbY()
    {
      AppMethodBeat.i(135586);
      a.m((com.tencent.mm.plugin.appbrand.jsapi.c)this.kWk.iGV.Du());
      AppMethodBeat.o(135586);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.networking.e
 * JD-Core Version:    0.7.0.1
 */