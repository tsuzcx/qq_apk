package com.tencent.mm.plugin.appbrand.networking;

import a.l;
import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.r;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/networking/NetworkServiceImpl;", "Lcom/tencent/mm/plugin/appbrand/networking/INetworkService;", "Lcom/tencent/mm/kernel/service/IServiceLifeCycle;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "mListeners", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lcom/tencent/mm/plugin/appbrand/networking/IOnNetworkStateChanged;", "mRuntime", "getMRuntime", "()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "addListener", "", "l", "notifyNetworkStateChanged", "onRegister", "onUnregister", "removeListener", "luggage-wxa-app_release"})
public class e
  implements com.tencent.mm.kernel.c.b, b
{
  final i gRG;
  @TargetApi(21)
  private final ConcurrentLinkedDeque<c> itP;
  
  public e(i parami)
  {
    AppMethodBeat.i(87591);
    this.gRG = parami;
    this.itP = new ConcurrentLinkedDeque();
    AppMethodBeat.o(87591);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(87589);
    this.itP.add(paramc);
    AppMethodBeat.o(87589);
  }
  
  public final void aIx()
  {
    AppMethodBeat.i(87588);
    Object localObject = this.gRG.ws();
    if (localObject != null)
    {
      if (((r)localObject).isRunning() == true)
      {
        localObject = this.itP.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((c)((Iterator)localObject).next()).aEI();
        }
      }
    }
    else
    {
      AppMethodBeat.o(87588);
      return;
    }
    AppMethodBeat.o(87588);
  }
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(87590);
    this.itP.remove(paramc);
    AppMethodBeat.o(87590);
  }
  
  public void xM()
  {
    AppMethodBeat.i(87586);
    a((c)new e.a(this));
    AppMethodBeat.o(87586);
  }
  
  public void xN()
  {
    AppMethodBeat.i(87587);
    this.itP.clear();
    AppMethodBeat.o(87587);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.networking.e
 * JD-Core Version:    0.7.0.1
 */