package com.tencent.magicbrush.ui;

import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.a.c.c;
import com.tencent.magicbrush.handler.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 13}, gfy={""}, gfz={"Lcom/tencent/magicbrush/ui/NativeAFHandler;", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler;", "Ljava/lang/Runnable;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "jsThreadHandler", "Lcom/tencent/magicbrush/handler/MBJsThreadHandler;", "(Lcom/tencent/magicbrush/MBRuntime;Lcom/tencent/magicbrush/handler/MBJsThreadHandler;)V", "strategy", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getStrategy", "()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "onCreate", "", "onDestroy", "onPause", "onResume", "run", "lib-magicbrush-nano_release"})
final class j
  extends a
  implements Runnable
{
  public j(MBRuntime paramMBRuntime, c paramc)
  {
    super(paramMBRuntime, paramc);
    AppMethodBeat.i(215136);
    AppMethodBeat.o(215136);
  }
  
  public final a.b HE()
  {
    return a.b.czP;
  }
  
  public final void onCreate() {}
  
  public final void onPause()
  {
    AppMethodBeat.i(215134);
    this.czJ.post((Runnable)new a(this));
    AppMethodBeat.o(215134);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(215133);
    this.czJ.post((Runnable)this);
    AppMethodBeat.o(215133);
  }
  
  public final void run()
  {
    AppMethodBeat.i(215135);
    c.c.i("AnimationFrameHandler", "hy: start native raf looper", new Object[0]);
    this.cvY.Hf();
    AppMethodBeat.o(215135);
  }
  
  @l(gfx={1, 1, 13}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(j paramj) {}
    
    public final void run()
    {
      AppMethodBeat.i(215132);
      this.cAx.cvY.Hg();
      AppMethodBeat.o(215132);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.ui.j
 * JD-Core Version:    0.7.0.1
 */