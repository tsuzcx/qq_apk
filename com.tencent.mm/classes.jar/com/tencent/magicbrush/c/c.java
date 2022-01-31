package com.tencent.magicbrush.c;

import a.l;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/magicbrush/ui/ChoreographerInJsThreadAFHandler;", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler;", "Landroid/view/Choreographer$FrameCallback;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "jsThreadHandler", "Lcom/tencent/magicbrush/handler/IJsThreadHandler;", "(Lcom/tencent/magicbrush/MBRuntime;Lcom/tencent/magicbrush/handler/IJsThreadHandler;)V", "choreographer", "Landroid/view/Choreographer;", "latency", "Lcom/tencent/magicbrush/ui/LatencyCalculator;", "strategy", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getStrategy", "()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "tryGetTimes", "", "doFrame", "", "frameTimeNanos", "", "getLatency", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Latency;", "onCreate", "onDestroy", "onPause", "onResume", "tryGetChoreographer", "tryLaterIfFailed", "", "lib-magicbrush-nano_release"})
final class c
  extends a
  implements Choreographer.FrameCallback
{
  private final f bLu;
  private int bLv;
  private final a.b bLw;
  private Choreographer choreographer;
  
  public c(MBRuntime paramMBRuntime, com.tencent.magicbrush.handler.a parama)
  {
    super(paramMBRuntime, parama);
    AppMethodBeat.i(151493);
    this.bLu = new f();
    this.bLw = a.b.bLp;
    AppMethodBeat.o(151493);
  }
  
  private final Choreographer yy()
  {
    AppMethodBeat.i(154376);
    Choreographer localChoreographer;
    if (this.choreographer != null)
    {
      localChoreographer = this.choreographer;
      AppMethodBeat.o(154376);
      return localChoreographer;
    }
    this.bLv += 1;
    try
    {
      localChoreographer = Choreographer.getInstance();
      if (localChoreographer != null)
      {
        if (localChoreographer != null) {
          this.choreographer = localChoreographer;
        }
        AppMethodBeat.o(154376);
        return localChoreographer;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if ((this.bLv == 1) || (this.bLv % 100000 == 0)) {
          c.c.printStackTrace("AnimationFrameHandler", (Throwable)localException, "get choreographer failed [" + this.bLv + "] times. but it's ok, i will try it later if needed. " + localException, new Object[0]);
        }
        Object localObject = null;
      }
      this.bLm.post((Runnable)new c.a(this));
      AppMethodBeat.o(154376);
    }
    return null;
  }
  
  public final void doFrame(long paramLong)
  {
    AppMethodBeat.i(151492);
    if (this.isRunning)
    {
      Choreographer localChoreographer = this.choreographer;
      if (localChoreographer != null) {
        localChoreographer.postFrameCallback((Choreographer.FrameCallback)this);
      }
      notifyAnimationFrame(paramLong / 1000000.0D);
    }
    AppMethodBeat.o(151492);
  }
  
  public final void onCreate() {}
  
  public final void onPause()
  {
    AppMethodBeat.i(151491);
    Choreographer localChoreographer = this.choreographer;
    if (localChoreographer != null)
    {
      localChoreographer.removeFrameCallback((Choreographer.FrameCallback)this);
      AppMethodBeat.o(151491);
      return;
    }
    AppMethodBeat.o(151491);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(151490);
    Choreographer localChoreographer = yy();
    if (localChoreographer != null) {
      localChoreographer.removeFrameCallback((Choreographer.FrameCallback)this);
    }
    if (localChoreographer != null)
    {
      localChoreographer.postFrameCallback((Choreographer.FrameCallback)this);
      AppMethodBeat.o(151490);
      return;
    }
    AppMethodBeat.o(151490);
  }
  
  public final a.b yx()
  {
    return this.bLw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.magicbrush.c.c
 * JD-Core Version:    0.7.0.1
 */