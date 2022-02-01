package com.tencent.mm.plugin.appbrand.networking;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.z.a;
import com.tencent.mm.plugin.appbrand.s;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/networking/NetworkServiceImpl;", "Lcom/tencent/mm/plugin/appbrand/networking/INetworkService;", "Lcom/tencent/mm/kernel/service/IServiceLifeCycle;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "mListeners", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lcom/tencent/mm/plugin/appbrand/networking/IOnNetworkStateChanged;", "mRuntime", "getMRuntime", "()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "addListener", "", "l", "notifyNetworkStateChanged", "onRegister", "onUnregister", "removeListener", "luggage-wxa-app_release"})
public class g
  implements b, d
{
  final AppBrandRuntime kEc;
  @TargetApi(21)
  private final ConcurrentLinkedDeque<e> njD;
  
  public g(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(135591);
    this.kEc = paramAppBrandRuntime;
    this.njD = new ConcurrentLinkedDeque();
    AppMethodBeat.o(135591);
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(135590);
    this.njD.add(parame);
    AppMethodBeat.o(135590);
  }
  
  public void aBc()
  {
    AppMethodBeat.i(135587);
    a((e)new a(this));
    AppMethodBeat.o(135587);
  }
  
  public void aBd()
  {
    AppMethodBeat.i(135588);
    this.njD.clear();
    AppMethodBeat.o(135588);
  }
  
  public final void bPO()
  {
    AppMethodBeat.i(135589);
    Object localObject = this.kEc.NY();
    if (localObject != null)
    {
      if (((s)localObject).isRunning() == true)
      {
        localObject = this.njD.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((e)((Iterator)localObject).next()).bIS();
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onNetworkStateChanged"})
  static final class a
    implements e
  {
    a(g paramg) {}
    
    public final void bIS()
    {
      AppMethodBeat.i(135586);
      a.m((f)this.njE.kEc.NY());
      AppMethodBeat.o(135586);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.networking.g
 * JD-Core Version:    0.7.0.1
 */