package com.tencent.luggage.game.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsruntime.q;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/luggage/game/boot/JsThreadHandler;", "Lcom/tencent/magicbrush/handler/IJsThreadHandler;", "impl", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddonJsThread;", "(Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddonJsThread;)V", "getImpl", "()Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddonJsThread;", "getExecutingTaskNameForDebug", "", "isJsThreadCurrent", "", "post", "", "r", "Ljava/lang/Runnable;", "ignorePause", "luggage-wxa-game-ext_release"})
final class a
  implements com.tencent.magicbrush.handler.a
{
  private final q bXQ;
  
  public a(q paramq)
  {
    AppMethodBeat.i(130731);
    this.bXQ = paramq;
    AppMethodBeat.o(130731);
  }
  
  public final boolean AU()
  {
    AppMethodBeat.i(130730);
    boolean bool = this.bXQ.AU();
    AppMethodBeat.o(130730);
    return bool;
  }
  
  public final String AV()
  {
    AppMethodBeat.i(184694);
    String str = this.bXQ.AV();
    AppMethodBeat.o(184694);
    return str;
  }
  
  public final void a(Runnable paramRunnable, boolean paramBoolean)
  {
    AppMethodBeat.i(206111);
    k.h(paramRunnable, "r");
    this.bXQ.a(paramRunnable, paramBoolean);
    AppMethodBeat.o(206111);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.game.a.a
 * JD-Core Version:    0.7.0.1
 */