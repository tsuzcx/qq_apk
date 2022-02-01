package com.tencent.magicbrush.ui;

import android.os.SystemClock;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.handler.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 13}, gka={""}, gkb={"Lcom/tencent/magicbrush/ui/EglSurfaceSwapLockerAFHandler;", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler;", "Ljava/lang/Runnable;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "jsThreadHandler", "Lcom/tencent/magicbrush/handler/MBJsThreadHandler;", "(Lcom/tencent/magicbrush/MBRuntime;Lcom/tencent/magicbrush/handler/MBJsThreadHandler;)V", "frameTimeMillis", "", "strategy", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getStrategy", "()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "onCreate", "", "onDestroy", "onPause", "onResume", "run", "lib-magicbrush-nano_release"})
final class e
  extends a
  implements Runnable
{
  private final a.b cAA;
  private double cAF;
  
  public e(MBRuntime paramMBRuntime, c paramc)
  {
    super(paramMBRuntime, paramc);
    AppMethodBeat.i(213370);
    this.cAA = a.b.cAu;
    AppMethodBeat.o(213370);
  }
  
  public final a.b HM()
  {
    return this.cAA;
  }
  
  public final void onCreate() {}
  
  public final void onPause()
  {
    this.cAF = 0.0D;
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(140222);
    this.cAq.post((Runnable)this);
    AppMethodBeat.o(140222);
  }
  
  public final void run()
  {
    AppMethodBeat.i(140223);
    if (this.isRunning)
    {
      this.cAq.post((Runnable)this);
      if (this.cAF == 0.0D) {
        this.cAF = SystemClock.elapsedRealtime();
      }
      g(this.cAF);
      this.cAF = SystemClock.elapsedRealtime();
    }
    AppMethodBeat.o(140223);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.ui.e
 * JD-Core Version:    0.7.0.1
 */