package com.tencent.magicbrush.ui;

import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.handler.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 13}, fNZ={""}, fOa={"Lcom/tencent/magicbrush/ui/SchedulerLockerAnimationFrameHandler;", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler;", "Ljava/lang/Runnable;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "jsThreadHandler", "Lcom/tencent/magicbrush/handler/MBJsThreadHandler;", "(Lcom/tencent/magicbrush/MBRuntime;Lcom/tencent/magicbrush/handler/MBJsThreadHandler;)V", "frameIntervalNanos", "", "frameRefreshRate", "", "frameTimeNanos", "latency", "com/tencent/magicbrush/ui/SchedulerLockerAnimationFrameHandler$latency$1", "Lcom/tencent/magicbrush/ui/SchedulerLockerAnimationFrameHandler$latency$1;", "skippedFrameCount", "strategy", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getStrategy", "()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getLatency", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Latency;", "onCreate", "", "onDestroy", "onPause", "onResume", "run", "lib-magicbrush-nano_release"})
final class k
  extends a
  implements Runnable
{
  private final int cpH;
  private final long cpI;
  private int cpJ;
  private final a cpK;
  private final a.b cpc;
  private long cpf;
  
  public k(MBRuntime paramMBRuntime, c paramc)
  {
    super(paramMBRuntime, paramc);
    AppMethodBeat.i(190947);
    this.cpH = 60;
    this.cpI = (1000000000L / this.cpH);
    this.cpK = new a();
    this.cpc = a.b.coX;
    AppMethodBeat.o(190947);
  }
  
  public final a.b Gj()
  {
    return this.cpc;
  }
  
  public final void onCreate() {}
  
  public final void onPause()
  {
    this.cpf = 0L;
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(140280);
    this.cpf = 0L;
    this.coS.post((Runnable)this);
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
    if (this.cpf == 0L) {
      this.cpf = System.nanoTime();
    }
    long l1 = System.nanoTime();
    long l2 = l1 - this.cpf;
    if (l2 >= this.cpI)
    {
      this.cpJ = ((int)(l2 / this.cpI));
      this.cpf = (l1 - l2 % this.cpI);
    }
    g(this.cpf / 1000000.0D);
    l1 = System.nanoTime();
    l2 = this.cpf;
    this.cpf += this.cpI;
    while ((l1 - l2 < this.cpI) && (System.nanoTime() < this.cpf)) {}
    this.coS.post((Runnable)this);
    AppMethodBeat.o(140281);
  }
  
  @l(fNY={1, 1, 13}, fNZ={""}, fOa={"com/tencent/magicbrush/ui/SchedulerLockerAnimationFrameHandler$latency$1", "Lcom/tencent/magicbrush/ui/LatencyCalculator;", "now", "", "lib-magicbrush-nano_release"})
  public static final class a
    extends f
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.ui.k
 * JD-Core Version:    0.7.0.1
 */