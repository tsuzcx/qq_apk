package com.tencent.luggage.game.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.q;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/game/boot/JsThreadHandler;", "Lcom/tencent/magicbrush/handler/IJsThreadHandler;", "impl", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddonJsThread;", "(Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddonJsThread;)V", "getImpl", "()Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddonJsThread;", "doInnerLoopTask", "", "getExecutingTaskNameForDebug", "", "isJsThreadCurrent", "post", "", "r", "Ljava/lang/Runnable;", "ignorePause", "resumeLoopTasks", "luggage-wxa-game-ext_release"})
final class a
  implements com.tencent.magicbrush.handler.a
{
  private final q csi;
  
  public a(q paramq)
  {
    AppMethodBeat.i(130731);
    this.csi = paramq;
    AppMethodBeat.o(130731);
  }
  
  public final boolean OF()
  {
    AppMethodBeat.i(130730);
    boolean bool = this.csi.OF();
    AppMethodBeat.o(130730);
    return bool;
  }
  
  public final String OG()
  {
    AppMethodBeat.i(184694);
    String str = this.csi.OG();
    AppMethodBeat.o(184694);
    return str;
  }
  
  public final void a(Runnable paramRunnable, boolean paramBoolean)
  {
    AppMethodBeat.i(246812);
    p.k(paramRunnable, "r");
    this.csi.a(paramRunnable, paramBoolean);
    AppMethodBeat.o(246812);
  }
  
  public final boolean doInnerLoopTask()
  {
    AppMethodBeat.i(246816);
    boolean bool = this.csi.doInnerLoopTask();
    AppMethodBeat.o(246816);
    return bool;
  }
  
  public final void resumeLoopTasks()
  {
    AppMethodBeat.i(246815);
    this.csi.resumeLoopTasks();
    AppMethodBeat.o(246815);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.a.a
 * JD-Core Version:    0.7.0.1
 */