package com.tencent.luggage.game.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.n.q;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/game/boot/JsThreadHandler;", "Lcom/tencent/magicbrush/handler/IJsThreadHandler;", "impl", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddonJsThread;", "(Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddonJsThread;)V", "getImpl", "()Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddonJsThread;", "doInnerLoopTask", "", "getExecutingTaskNameForDebug", "", "isJsThreadCurrent", "post", "", "r", "Ljava/lang/Runnable;", "ignorePause", "resumeLoopTasks", "luggage-wxa-game-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
final class a
  implements com.tencent.magicbrush.handler.a
{
  private final q ekd;
  
  public a(q paramq)
  {
    AppMethodBeat.i(130731);
    this.ekd = paramq;
    AppMethodBeat.o(130731);
  }
  
  public final void a(Runnable paramRunnable, boolean paramBoolean)
  {
    AppMethodBeat.i(220112);
    s.u(paramRunnable, "r");
    this.ekd.a(paramRunnable, paramBoolean);
    AppMethodBeat.o(220112);
  }
  
  public final boolean aoN()
  {
    AppMethodBeat.i(130730);
    boolean bool = this.ekd.aoN();
    AppMethodBeat.o(130730);
    return bool;
  }
  
  public final String aoO()
  {
    AppMethodBeat.i(184694);
    String str = this.ekd.aoO();
    AppMethodBeat.o(184694);
    return str;
  }
  
  public final boolean doInnerLoopTask()
  {
    AppMethodBeat.i(220119);
    boolean bool = this.ekd.doInnerLoopTask();
    AppMethodBeat.o(220119);
    return bool;
  }
  
  public final void resumeLoopTasks()
  {
    AppMethodBeat.i(220117);
    this.ekd.resumeLoopTasks();
    AppMethodBeat.o(220117);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.game.a.a
 * JD-Core Version:    0.7.0.1
 */