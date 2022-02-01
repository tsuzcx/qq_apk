package com.tencent.magicbrush.ui;

import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.handler.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 13}, gka={""}, gkb={"Lcom/tencent/magicbrush/ui/SchedulerLockerAnimationFrameHandler;", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler;", "Ljava/lang/Runnable;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "jsThreadHandler", "Lcom/tencent/magicbrush/handler/MBJsThreadHandler;", "(Lcom/tencent/magicbrush/MBRuntime;Lcom/tencent/magicbrush/handler/MBJsThreadHandler;)V", "frameIntervalNanos", "", "frameRefreshRate", "", "frameTimeNanos", "latency", "com/tencent/magicbrush/ui/SchedulerLockerAnimationFrameHandler$latency$1", "Lcom/tencent/magicbrush/ui/SchedulerLockerAnimationFrameHandler$latency$1;", "skippedFrameCount", "strategy", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getStrategy", "()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getLatency", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Latency;", "onCreate", "", "onDestroy", "onPause", "onResume", "run", "lib-magicbrush-nano_release"})
final class k
  extends a
  implements Runnable
{
  private final a.b cAA;
  private long cAD;
  private final int cBf;
  private final long cBg;
  private int cBh;
  private final a cBi;
  
  public k(MBRuntime paramMBRuntime, c paramc)
  {
    super(paramMBRuntime, paramc);
    AppMethodBeat.i(213381);
    this.cBf = 60;
    this.cBg = (1000000000L / this.cBf);
    this.cBi = new a();
    this.cAA = a.b.cAv;
    AppMethodBeat.o(213381);
  }
  
  public final a.b HM()
  {
    return this.cAA;
  }
  
  public final void onCreate() {}
  
  public final void onPause()
  {
    this.cAD = 0L;
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(140280);
    this.cAD = 0L;
    this.cAq.post((Runnable)this);
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
    if (this.cAD == 0L) {
      this.cAD = System.nanoTime();
    }
    long l1 = System.nanoTime();
    long l2 = l1 - this.cAD;
    if (l2 >= this.cBg)
    {
      this.cBh = ((int)(l2 / this.cBg));
      this.cAD = (l1 - l2 % this.cBg);
    }
    g(this.cAD / 1000000.0D);
    l1 = System.nanoTime();
    l2 = this.cAD;
    this.cAD += this.cBg;
    while ((l1 - l2 < this.cBg) && (System.nanoTime() < this.cAD)) {}
    this.cAq.post((Runnable)this);
    AppMethodBeat.o(140281);
  }
  
  @l(gjZ={1, 1, 13}, gka={""}, gkb={"com/tencent/magicbrush/ui/SchedulerLockerAnimationFrameHandler$latency$1", "Lcom/tencent/magicbrush/ui/LatencyCalculator;", "now", "", "lib-magicbrush-nano_release"})
  public static final class a
    extends f
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.ui.k
 * JD-Core Version:    0.7.0.1
 */