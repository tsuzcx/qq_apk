package com.tencent.luggage.game.a;

import com.tencent.magicbrush.handler.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsruntime.q;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/luggage/game/boot/JsThreadHandler;", "Lcom/tencent/magicbrush/handler/IJsThreadHandler;", "impl", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddonJsThread;", "(Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddonJsThread;)V", "getImpl", "()Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddonJsThread;", "doInnerLoopTask", "", "getExecutingTaskNameForDebug", "", "isJsThreadCurrent", "post", "", "r", "Ljava/lang/Runnable;", "ignorePause", "resumeLoopTasks", "luggage-wxa-game-ext_release"})
final class c
  implements a
{
  private final q cik;
  
  public c(q paramq)
  {
    AppMethodBeat.i(130731);
    this.cik = paramq;
    AppMethodBeat.o(130731);
  }
  
  public final boolean Cw()
  {
    AppMethodBeat.i(130730);
    boolean bool = this.cik.Cw();
    AppMethodBeat.o(130730);
    return bool;
  }
  
  public final String Cx()
  {
    AppMethodBeat.i(184694);
    String str = this.cik.Cx();
    AppMethodBeat.o(184694);
    return str;
  }
  
  public final void a(Runnable paramRunnable, boolean paramBoolean)
  {
    AppMethodBeat.i(220742);
    p.h(paramRunnable, "r");
    this.cik.a(paramRunnable, paramBoolean);
    AppMethodBeat.o(220742);
  }
  
  public final boolean doInnerLoopTask()
  {
    AppMethodBeat.i(220744);
    boolean bool = this.cik.doInnerLoopTask();
    AppMethodBeat.o(220744);
    return bool;
  }
  
  public final void resumeLoopTasks()
  {
    AppMethodBeat.i(220743);
    this.cik.resumeLoopTasks();
    AppMethodBeat.o(220743);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.game.a.c
 * JD-Core Version:    0.7.0.1
 */