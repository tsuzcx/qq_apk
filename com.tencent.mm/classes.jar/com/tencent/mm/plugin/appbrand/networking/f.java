package com.tencent.mm.plugin.appbrand.networking;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.x.a;
import com.tencent.mm.plugin.appbrand.q;
import d.l;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/networking/NetworkServiceImpl;", "Lcom/tencent/mm/plugin/appbrand/networking/INetworkService;", "Lcom/tencent/mm/kernel/service/IServiceLifeCycle;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "mListeners", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lcom/tencent/mm/plugin/appbrand/networking/IOnNetworkStateChanged;", "mRuntime", "getMRuntime", "()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "addListener", "", "l", "notifyNetworkStateChanged", "onRegister", "onUnregister", "removeListener", "luggage-wxa-app_release"})
public class f
  implements b, c
{
  final AppBrandRuntime jzY;
  @TargetApi(21)
  private final ConcurrentLinkedDeque<d> lXl;
  
  public f(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(135591);
    this.jzY = paramAppBrandRuntime;
    this.lXl = new ConcurrentLinkedDeque();
    AppMethodBeat.o(135591);
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(135590);
    this.lXl.add(paramd);
    AppMethodBeat.o(135590);
  }
  
  public void akx()
  {
    AppMethodBeat.i(135587);
    a((d)new a(this));
    AppMethodBeat.o(135587);
  }
  
  public void aky()
  {
    AppMethodBeat.i(135588);
    this.lXl.clear();
    AppMethodBeat.o(135588);
  }
  
  public final void btw()
  {
    AppMethodBeat.i(135589);
    Object localObject = this.jzY.Ew();
    if (localObject != null)
    {
      if (((q)localObject).isRunning() == true)
      {
        localObject = this.lXl.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((d)((Iterator)localObject).next()).bmF();
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "onNetworkStateChanged"})
  static final class a
    implements d
  {
    a(f paramf) {}
    
    public final void bmF()
    {
      AppMethodBeat.i(135586);
      a.m((com.tencent.mm.plugin.appbrand.jsapi.c)this.lXm.jzY.Ew());
      AppMethodBeat.o(135586);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.networking.f
 * JD-Core Version:    0.7.0.1
 */