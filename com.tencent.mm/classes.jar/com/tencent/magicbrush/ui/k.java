package com.tencent.magicbrush.ui;

import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.handler.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 13}, gfy={""}, gfz={"Lcom/tencent/magicbrush/ui/SchedulerLockerAnimationFrameHandler;", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler;", "Ljava/lang/Runnable;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "jsThreadHandler", "Lcom/tencent/magicbrush/handler/MBJsThreadHandler;", "(Lcom/tencent/magicbrush/MBRuntime;Lcom/tencent/magicbrush/handler/MBJsThreadHandler;)V", "frameIntervalNanos", "", "frameRefreshRate", "", "frameTimeNanos", "latency", "com/tencent/magicbrush/ui/SchedulerLockerAnimationFrameHandler$latency$1", "Lcom/tencent/magicbrush/ui/SchedulerLockerAnimationFrameHandler$latency$1;", "skippedFrameCount", "strategy", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getStrategy", "()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getLatency", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Latency;", "onCreate", "", "onDestroy", "onPause", "onResume", "run", "lib-magicbrush-nano_release"})
final class k
  extends a
  implements Runnable
{
  private int cAA;
  private final a cAB;
  private final int cAy;
  private final long cAz;
  private final a.b czT;
  private long czW;
  
  public k(MBRuntime paramMBRuntime, c paramc)
  {
    super(paramMBRuntime, paramc);
    AppMethodBeat.i(215137);
    this.cAy = 60;
    this.cAz = (1000000000L / this.cAy);
    this.cAB = new a();
    this.czT = a.b.czO;
    AppMethodBeat.o(215137);
  }
  
  public final a.b HE()
  {
    return this.czT;
  }
  
  public final void onCreate() {}
  
  public final void onPause()
  {
    this.czW = 0L;
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(140280);
    this.czW = 0L;
    this.czJ.post((Runnable)this);
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
    if (this.czW == 0L) {
      this.czW = System.nanoTime();
    }
    long l1 = System.nanoTime();
    long l2 = l1 - this.czW;
    if (l2 >= this.cAz)
    {
      this.cAA = ((int)(l2 / this.cAz));
      this.czW = (l1 - l2 % this.cAz);
    }
    g(this.czW / 1000000.0D);
    l1 = System.nanoTime();
    l2 = this.czW;
    this.czW += this.cAz;
    while ((l1 - l2 < this.cAz) && (System.nanoTime() < this.czW)) {}
    this.czJ.post((Runnable)this);
    AppMethodBeat.o(140281);
  }
  
  @l(gfx={1, 1, 13}, gfy={""}, gfz={"com/tencent/magicbrush/ui/SchedulerLockerAnimationFrameHandler$latency$1", "Lcom/tencent/magicbrush/ui/LatencyCalculator;", "now", "", "lib-magicbrush-nano_release"})
  public static final class a
    extends f
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.ui.k
 * JD-Core Version:    0.7.0.1
 */