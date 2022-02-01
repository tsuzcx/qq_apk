package com.tencent.magicbrush.ui;

import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.a.c.c;
import com.tencent.magicbrush.handler.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/magicbrush/ui/NativeAFHandler;", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler;", "Ljava/lang/Runnable;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "jsThreadHandler", "Lcom/tencent/magicbrush/handler/MBJsThreadHandler;", "(Lcom/tencent/magicbrush/MBRuntime;Lcom/tencent/magicbrush/handler/MBJsThreadHandler;)V", "strategy", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getStrategy", "()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "onCreate", "", "onDestroy", "onPause", "onResume", "run", "lib-magicbrush-nano_release"})
final class j
  extends a
  implements Runnable
{
  public j(MBRuntime paramMBRuntime, c paramc)
  {
    super(paramMBRuntime, paramc);
    AppMethodBeat.i(205957);
    AppMethodBeat.o(205957);
  }
  
  public final a.b Vo()
  {
    return a.b.cPr;
  }
  
  public final void onCreate() {}
  
  public final void onPause()
  {
    AppMethodBeat.i(205952);
    this.cPl.post((Runnable)new a(this));
    AppMethodBeat.o(205952);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(205950);
    this.cPl.post((Runnable)this);
    AppMethodBeat.o(205950);
  }
  
  public final void run()
  {
    AppMethodBeat.i(205954);
    c.c.i("AnimationFrameHandler", "hy: start native raf looper", new Object[0]);
    this.cLt.UK();
    AppMethodBeat.o(205954);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(j paramj) {}
    
    public final void run()
    {
      AppMethodBeat.i(205926);
      this.cQb.cLt.UL();
      AppMethodBeat.o(205926);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.magicbrush.ui.j
 * JD-Core Version:    0.7.0.1
 */