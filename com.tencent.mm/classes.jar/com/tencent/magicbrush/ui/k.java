package com.tencent.magicbrush.ui;

import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.handler.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/magicbrush/ui/SchedulerLockerAnimationFrameHandler;", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler;", "Ljava/lang/Runnable;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "jsThreadHandler", "Lcom/tencent/magicbrush/handler/MBJsThreadHandler;", "(Lcom/tencent/magicbrush/MBRuntime;Lcom/tencent/magicbrush/handler/MBJsThreadHandler;)V", "frameIntervalNanos", "", "frameRefreshRate", "", "frameTimeNanos", "latency", "com/tencent/magicbrush/ui/SchedulerLockerAnimationFrameHandler$latency$1", "Lcom/tencent/magicbrush/ui/SchedulerLockerAnimationFrameHandler$latency$1;", "skippedFrameCount", "strategy", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getStrategy", "()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getLatency", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Latency;", "onCreate", "", "onDestroy", "onPause", "onResume", "run", "lib-magicbrush-nano_release"})
final class k
  extends a
  implements Runnable
{
  private final a.b cOG;
  private long cOJ;
  private final int cPl;
  private final long cPm;
  private int cPn;
  private final a cPo;
  
  public k(MBRuntime paramMBRuntime, c paramc)
  {
    super(paramMBRuntime, paramc);
    AppMethodBeat.i(206887);
    this.cPl = 60;
    this.cPm = (1000000000L / this.cPl);
    this.cPo = new a();
    this.cOG = a.b.cOB;
    AppMethodBeat.o(206887);
  }
  
  public final a.b RB()
  {
    return this.cOG;
  }
  
  public final void onCreate() {}
  
  public final void onPause()
  {
    this.cOJ = 0L;
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(140280);
    this.cOJ = 0L;
    this.cOw.post((Runnable)this);
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
    if (this.cOJ == 0L) {
      this.cOJ = System.nanoTime();
    }
    long l1 = System.nanoTime();
    long l2 = l1 - this.cOJ;
    if (l2 >= this.cPm)
    {
      this.cPn = ((int)(l2 / this.cPm));
      this.cOJ = (l1 - l2 % this.cPm);
    }
    h(this.cOJ / 1000000.0D);
    l1 = System.nanoTime();
    l2 = this.cOJ;
    this.cOJ += this.cPm;
    while ((l1 - l2 < this.cPm) && (System.nanoTime() < this.cOJ)) {}
    this.cOw.post((Runnable)this);
    AppMethodBeat.o(140281);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/magicbrush/ui/SchedulerLockerAnimationFrameHandler$latency$1", "Lcom/tencent/magicbrush/ui/LatencyCalculator;", "now", "", "lib-magicbrush-nano_release"})
  public static final class a
    extends f
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.magicbrush.ui.k
 * JD-Core Version:    0.7.0.1
 */