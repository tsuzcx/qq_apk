package com.tencent.magicbrush.ui;

import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.handler.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/magicbrush/ui/SchedulerLockerAnimationFrameHandler;", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler;", "Ljava/lang/Runnable;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "jsThreadHandler", "Lcom/tencent/magicbrush/handler/MBJsThreadHandler;", "(Lcom/tencent/magicbrush/MBRuntime;Lcom/tencent/magicbrush/handler/MBJsThreadHandler;)V", "frameIntervalNanos", "", "frameRefreshRate", "", "frameTimeNanos", "latency", "com/tencent/magicbrush/ui/SchedulerLockerAnimationFrameHandler$latency$1", "Lcom/tencent/magicbrush/ui/SchedulerLockerAnimationFrameHandler$latency$1;", "skippedFrameCount", "strategy", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getStrategy", "()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getLatency", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Latency;", "onCreate", "", "onDestroy", "onPause", "onResume", "run", "lib-magicbrush-nano_release"})
final class k
  extends a
  implements Runnable
{
  private final a.b cPv;
  private long cPy;
  private final int cQc;
  private final long cQd;
  private int cQe;
  private final a cQf;
  
  public k(MBRuntime paramMBRuntime, c paramc)
  {
    super(paramMBRuntime, paramc);
    AppMethodBeat.i(206020);
    this.cQc = 60;
    this.cQd = (1000000000L / this.cQc);
    this.cQf = new a();
    this.cPv = a.b.cPq;
    AppMethodBeat.o(206020);
  }
  
  public final a.b Vo()
  {
    return this.cPv;
  }
  
  public final void onCreate() {}
  
  public final void onPause()
  {
    this.cPy = 0L;
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(140280);
    this.cPy = 0L;
    this.cPl.post((Runnable)this);
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
    if (this.cPy == 0L) {
      this.cPy = System.nanoTime();
    }
    long l1 = System.nanoTime();
    long l2 = l1 - this.cPy;
    if (l2 >= this.cQd)
    {
      this.cQe = ((int)(l2 / this.cQd));
      this.cPy = (l1 - l2 % this.cQd);
    }
    h(this.cPy / 1000000.0D);
    l1 = System.nanoTime();
    l2 = this.cPy;
    this.cPy += this.cQd;
    while ((l1 - l2 < this.cQd) && (System.nanoTime() < this.cPy)) {}
    this.cPl.post((Runnable)this);
    AppMethodBeat.o(140281);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/magicbrush/ui/SchedulerLockerAnimationFrameHandler$latency$1", "Lcom/tencent/magicbrush/ui/LatencyCalculator;", "now", "", "lib-magicbrush-nano_release"})
  public static final class a
    extends f
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.magicbrush.ui.k
 * JD-Core Version:    0.7.0.1
 */