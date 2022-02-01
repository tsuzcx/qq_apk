package com.tencent.luggage.game.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsruntime.q;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/luggage/game/boot/JsThreadHandler;", "Lcom/tencent/magicbrush/handler/IJsThreadHandler;", "impl", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddonJsThread;", "(Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddonJsThread;)V", "getImpl", "()Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddonJsThread;", "getExecutingTaskNameForDebug", "", "isJsThreadCurrent", "", "post", "", "r", "Ljava/lang/Runnable;", "ignorePause", "luggage-wxa-game-ext_release"})
final class a
  implements com.tencent.magicbrush.handler.a
{
  private final q cii;
  
  public a(q paramq)
  {
    AppMethodBeat.i(130731);
    this.cii = paramq;
    AppMethodBeat.o(130731);
  }
  
  public final boolean Ct()
  {
    AppMethodBeat.i(130730);
    boolean bool = this.cii.Ct();
    AppMethodBeat.o(130730);
    return bool;
  }
  
  public final String Cu()
  {
    AppMethodBeat.i(184694);
    String str = this.cii.Cu();
    AppMethodBeat.o(184694);
    return str;
  }
  
  public final void a(Runnable paramRunnable, boolean paramBoolean)
  {
    AppMethodBeat.i(190395);
    p.h(paramRunnable, "r");
    this.cii.a(paramRunnable, paramBoolean);
    AppMethodBeat.o(190395);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.game.a.a
 * JD-Core Version:    0.7.0.1
 */