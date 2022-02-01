package com.tencent.magicbrush.ui;

import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.handler.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/magicbrush/ui/SchedulerLockerAnimationFrameHandler;", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler;", "Ljava/lang/Runnable;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "jsThreadHandler", "Lcom/tencent/magicbrush/handler/MBJsThreadHandler;", "(Lcom/tencent/magicbrush/MBRuntime;Lcom/tencent/magicbrush/handler/MBJsThreadHandler;)V", "frameIntervalNanos", "", "frameRefreshRate", "", "frameTimeNanos", "latency", "com/tencent/magicbrush/ui/SchedulerLockerAnimationFrameHandler$latency$1", "Lcom/tencent/magicbrush/ui/SchedulerLockerAnimationFrameHandler$latency$1;", "skippedFrameCount", "strategy", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getStrategy", "()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getLatency", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Latency;", "onCreate", "", "onDestroy", "onPause", "onResume", "run", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 16})
final class k
  extends a
  implements Runnable
{
  private final a.b eKA;
  private long eKD;
  private final int eLh;
  private final long eLi;
  private int eLj;
  private final a eLk;
  
  public k(MBRuntime paramMBRuntime, c paramc)
  {
    super(paramMBRuntime, paramc);
    AppMethodBeat.i(229032);
    this.eLh = 60;
    this.eLi = (1000000000L / this.eLh);
    this.eLk = new a();
    this.eKA = a.b.eKv;
    AppMethodBeat.o(229032);
  }
  
  public final a.b avR()
  {
    return this.eKA;
  }
  
  public final void onCreate() {}
  
  public final void onPause()
  {
    this.eKD = 0L;
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(140280);
    this.eKD = 0L;
    this.eKq.post((Runnable)this);
    AppMethodBeat.o(140280);
  }
  
  public final void run()
  {
    AppMethodBeat.i(140281);
    if (!this.Uz)
    {
      AppMethodBeat.o(140281);
      return;
    }
    if (this.eKD == 0L) {
      this.eKD = System.nanoTime();
    }
    long l1 = System.nanoTime();
    long l2 = l1 - this.eKD;
    if (l2 >= this.eLi)
    {
      this.eLj = ((int)(l2 / this.eLi));
      this.eKD = (l1 - l2 % this.eLi);
    }
    x(this.eKD / 1000000.0D);
    l1 = System.nanoTime();
    l2 = this.eKD;
    this.eKD += this.eLi;
    while ((l1 - l2 < this.eLi) && (System.nanoTime() < this.eKD)) {}
    this.eKq.post((Runnable)this);
    AppMethodBeat.o(140281);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/magicbrush/ui/SchedulerLockerAnimationFrameHandler$latency$1", "Lcom/tencent/magicbrush/ui/LatencyCalculator;", "now", "", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 16})
  public static final class a
    extends f
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.magicbrush.ui.k
 * JD-Core Version:    0.7.0.1
 */