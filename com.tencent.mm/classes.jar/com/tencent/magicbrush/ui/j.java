package com.tencent.magicbrush.ui;

import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.a.c.c;
import com.tencent.magicbrush.handler.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/magicbrush/ui/NativeAFHandler;", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler;", "Ljava/lang/Runnable;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "jsThreadHandler", "Lcom/tencent/magicbrush/handler/MBJsThreadHandler;", "(Lcom/tencent/magicbrush/MBRuntime;Lcom/tencent/magicbrush/handler/MBJsThreadHandler;)V", "strategy", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getStrategy", "()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "onCreate", "", "onDestroy", "onPause", "onResume", "run", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 16})
final class j
  extends a
  implements Runnable
{
  public j(MBRuntime paramMBRuntime, c paramc)
  {
    super(paramMBRuntime, paramc);
    AppMethodBeat.i(229029);
    AppMethodBeat.o(229029);
  }
  
  public final a.b avR()
  {
    return a.b.eKw;
  }
  
  public final void onCreate() {}
  
  public final void onPause()
  {
    AppMethodBeat.i(229040);
    this.eKq.post((Runnable)new a(this));
    AppMethodBeat.o(229040);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(229036);
    this.eKq.post((Runnable)this);
    AppMethodBeat.o(229036);
  }
  
  public final void run()
  {
    AppMethodBeat.i(229045);
    c.c.i("AnimationFrameHandler", "hy: start native raf looper", new Object[0]);
    this.eGN.avn();
    AppMethodBeat.o(229045);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
  static final class a
    implements Runnable
  {
    a(j paramj) {}
    
    public final void run()
    {
      AppMethodBeat.i(229015);
      this.eLg.eGN.avo();
      AppMethodBeat.o(229015);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.magicbrush.ui.j
 * JD-Core Version:    0.7.0.1
 */