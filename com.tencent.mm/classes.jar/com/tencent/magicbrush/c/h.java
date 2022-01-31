package com.tencent.magicbrush.c;

import a.l;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/magicbrush/ui/SchedulerLockerAnimationFrameHandler;", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler;", "Ljava/lang/Runnable;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "jsThreadHandler", "Lcom/tencent/magicbrush/handler/IJsThreadHandler;", "(Lcom/tencent/magicbrush/MBRuntime;Lcom/tencent/magicbrush/handler/IJsThreadHandler;)V", "frameIntervalNanos", "", "frameRefreshRate", "", "frameTimeNanos", "latency", "com/tencent/magicbrush/ui/SchedulerLockerAnimationFrameHandler$latency$1", "Lcom/tencent/magicbrush/ui/SchedulerLockerAnimationFrameHandler$latency$1;", "skippedFrameCount", "strategy", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getStrategy", "()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getLatency", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Latency;", "onCreate", "", "onDestroy", "onPause", "onResume", "run", "lib-magicbrush-nano_release"})
final class h
  extends a
  implements Runnable
{
  private final int bLE;
  private final long bLF;
  private int bLG;
  private final a bLH;
  private final a.b bLw;
  private long bLz;
  
  public h(MBRuntime paramMBRuntime, com.tencent.magicbrush.handler.a parama)
  {
    super(paramMBRuntime, parama);
    AppMethodBeat.i(151506);
    this.bLE = 60;
    this.bLF = (1000000000L / this.bLE);
    this.bLH = new a();
    this.bLw = a.b.bLs;
    AppMethodBeat.o(151506);
  }
  
  public final void onCreate() {}
  
  public final void onPause()
  {
    this.bLz = 0L;
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(151504);
    this.bLz = 0L;
    this.bLm.post((Runnable)this);
    AppMethodBeat.o(151504);
  }
  
  public final void run()
  {
    AppMethodBeat.i(151505);
    if (!this.isRunning)
    {
      AppMethodBeat.o(151505);
      return;
    }
    if (this.bLz == 0L) {
      this.bLz = System.nanoTime();
    }
    long l1 = System.nanoTime();
    long l2 = l1 - this.bLz;
    if (l2 >= this.bLF)
    {
      this.bLG = ((int)(l2 / this.bLF));
      this.bLz = (l1 - l2 % this.bLF);
    }
    notifyAnimationFrame(this.bLz / 1000000.0D);
    l1 = System.nanoTime();
    l2 = this.bLz;
    this.bLz += this.bLF;
    while ((l1 - l2 < this.bLF) && (System.nanoTime() < this.bLz)) {}
    this.bLm.post((Runnable)this);
    AppMethodBeat.o(151505);
  }
  
  public final a.b yx()
  {
    return this.bLw;
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/magicbrush/ui/SchedulerLockerAnimationFrameHandler$latency$1", "Lcom/tencent/magicbrush/ui/LatencyCalculator;", "now", "", "lib-magicbrush-nano_release"})
  public static final class a
    extends f
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.magicbrush.c.h
 * JD-Core Version:    0.7.0.1
 */