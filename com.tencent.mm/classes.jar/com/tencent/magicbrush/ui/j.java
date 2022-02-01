package com.tencent.magicbrush.ui;

import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.handler.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/magicbrush/ui/SchedulerLockerAnimationFrameHandler;", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler;", "Ljava/lang/Runnable;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "jsThreadHandler", "Lcom/tencent/magicbrush/handler/MBJsThreadHandler;", "(Lcom/tencent/magicbrush/MBRuntime;Lcom/tencent/magicbrush/handler/MBJsThreadHandler;)V", "frameIntervalNanos", "", "frameRefreshRate", "", "frameTimeNanos", "latency", "com/tencent/magicbrush/ui/SchedulerLockerAnimationFrameHandler$latency$1", "Lcom/tencent/magicbrush/ui/SchedulerLockerAnimationFrameHandler$latency$1;", "skippedFrameCount", "strategy", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getStrategy", "()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getLatency", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Latency;", "onCreate", "", "onDestroy", "onPause", "onResume", "run", "lib-magicbrush-nano_release"})
final class j
  extends a
  implements Runnable
{
  private final a.b crV;
  private long crY;
  private final long csA;
  private int csB;
  private final a csC;
  private final int csz;
  
  public j(MBRuntime paramMBRuntime, c paramc)
  {
    super(paramMBRuntime, paramc);
    AppMethodBeat.i(193577);
    this.csz = 60;
    this.csA = (1000000000L / this.csz);
    this.csC = new a();
    this.crV = a.b.crR;
    AppMethodBeat.o(193577);
  }
  
  public final a.b Gx()
  {
    return this.crV;
  }
  
  public final void onCreate() {}
  
  public final void onPause()
  {
    this.crY = 0L;
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(140280);
    this.crY = 0L;
    this.crM.post((Runnable)this);
    AppMethodBeat.o(140280);
  }
  
  public final void run()
  {
    AppMethodBeat.i(140281);
    if (!this.isRunning)
    {
      AppMethodBeat.o(140281);
      return;
    }
    if (this.crY == 0L) {
      this.crY = System.nanoTime();
    }
    long l1 = System.nanoTime();
    long l2 = l1 - this.crY;
    if (l2 >= this.csA)
    {
      this.csB = ((int)(l2 / this.csA));
      this.crY = (l1 - l2 % this.csA);
    }
    g(this.crY / 1000000.0D);
    l1 = System.nanoTime();
    l2 = this.crY;
    this.crY += this.csA;
    while ((l1 - l2 < this.csA) && (System.nanoTime() < this.crY)) {}
    this.crM.post((Runnable)this);
    AppMethodBeat.o(140281);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/magicbrush/ui/SchedulerLockerAnimationFrameHandler$latency$1", "Lcom/tencent/magicbrush/ui/LatencyCalculator;", "now", "", "lib-magicbrush-nano_release"})
  public static final class a
    extends f
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.ui.j
 * JD-Core Version:    0.7.0.1
 */