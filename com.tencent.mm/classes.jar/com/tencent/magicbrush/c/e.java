package com.tencent.magicbrush.c;

import a.l;
import android.os.SystemClock;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/magicbrush/ui/EglSurfaceSwapLockerAFHandler;", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler;", "Ljava/lang/Runnable;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "jsThreadHandler", "Lcom/tencent/magicbrush/handler/IJsThreadHandler;", "(Lcom/tencent/magicbrush/MBRuntime;Lcom/tencent/magicbrush/handler/IJsThreadHandler;)V", "frameTimeMillis", "", "strategy", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getStrategy", "()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "onCreate", "", "onDestroy", "onPause", "onResume", "run", "lib-magicbrush-nano_release"})
final class e
  extends a
  implements Runnable
{
  private double bLB;
  private final a.b bLw;
  
  public e(MBRuntime paramMBRuntime, com.tencent.magicbrush.handler.a parama)
  {
    super(paramMBRuntime, parama);
    AppMethodBeat.i(151503);
    this.bLw = a.b.bLr;
    AppMethodBeat.o(151503);
  }
  
  public final void onCreate() {}
  
  public final void onPause()
  {
    this.bLB = 0.0D;
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(151501);
    this.bLm.post((Runnable)this);
    AppMethodBeat.o(151501);
  }
  
  public final void run()
  {
    AppMethodBeat.i(151502);
    if (this.isRunning)
    {
      this.bLm.post((Runnable)this);
      if (this.bLB == 0.0D) {
        this.bLB = SystemClock.elapsedRealtime();
      }
      notifyAnimationFrame(this.bLB);
      this.bLB = SystemClock.elapsedRealtime();
    }
    AppMethodBeat.o(151502);
  }
  
  public final a.b yx()
  {
    return this.bLw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.c.e
 * JD-Core Version:    0.7.0.1
 */