package com.tencent.luggage.game.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.q;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/luggage/game/boot/JsThreadHandler;", "Lcom/tencent/magicbrush/handler/IJsThreadHandler;", "impl", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddonJsThread;", "(Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddonJsThread;)V", "getImpl", "()Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddonJsThread;", "doInnerLoopTask", "", "getExecutingTaskNameForDebug", "", "isJsThreadCurrent", "post", "", "r", "Ljava/lang/Runnable;", "ignorePause", "resumeLoopTasks", "luggage-wxa-game-ext_release"})
final class a
  implements com.tencent.magicbrush.handler.a
{
  private final q cud;
  
  public a(q paramq)
  {
    AppMethodBeat.i(130731);
    this.cud = paramq;
    AppMethodBeat.o(130731);
  }
  
  public final boolean LO()
  {
    AppMethodBeat.i(130730);
    boolean bool = this.cud.LO();
    AppMethodBeat.o(130730);
    return bool;
  }
  
  public final String LP()
  {
    AppMethodBeat.i(184694);
    String str = this.cud.LP();
    AppMethodBeat.o(184694);
    return str;
  }
  
  public final void a(Runnable paramRunnable, boolean paramBoolean)
  {
    AppMethodBeat.i(222894);
    p.h(paramRunnable, "r");
    this.cud.a(paramRunnable, paramBoolean);
    AppMethodBeat.o(222894);
  }
  
  public final boolean doInnerLoopTask()
  {
    AppMethodBeat.i(222896);
    boolean bool = this.cud.doInnerLoopTask();
    AppMethodBeat.o(222896);
    return bool;
  }
  
  public final void resumeLoopTasks()
  {
    AppMethodBeat.i(222895);
    this.cud.resumeLoopTasks();
    AppMethodBeat.o(222895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.game.a.a
 * JD-Core Version:    0.7.0.1
 */