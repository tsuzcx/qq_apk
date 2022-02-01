package com.tencent.magicbrush.ui;

import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/magicbrush/ui/ChoreographerInJsThreadAFHandler;", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler;", "Landroid/view/Choreographer$FrameCallback;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "jsThreadHandler", "Lcom/tencent/magicbrush/handler/MBJsThreadHandler;", "(Lcom/tencent/magicbrush/MBRuntime;Lcom/tencent/magicbrush/handler/MBJsThreadHandler;)V", "choreographer", "Landroid/view/Choreographer;", "latency", "Lcom/tencent/magicbrush/ui/LatencyCalculator;", "strategy", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getStrategy", "()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "tryGetTimes", "", "doFrame", "", "frameTimeNanos", "", "getLatency", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Latency;", "onCreate", "onDestroy", "onPause", "onResume", "tryGetChoreographer", "tryLaterIfFailed", "", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 16})
final class c
  extends a
  implements Choreographer.FrameCallback
{
  private Choreographer choreographer;
  private final a.b eKA;
  private final f eKy;
  private int eKz;
  
  public c(MBRuntime paramMBRuntime, com.tencent.magicbrush.handler.c paramc)
  {
    super(paramMBRuntime, paramc);
    AppMethodBeat.i(229025);
    this.eKy = new f();
    this.eKA = a.b.eKs;
    AppMethodBeat.o(229025);
  }
  
  private final Choreographer avS()
  {
    AppMethodBeat.i(140209);
    Choreographer localChoreographer;
    if (this.choreographer != null)
    {
      localChoreographer = this.choreographer;
      AppMethodBeat.o(140209);
      return localChoreographer;
    }
    this.eKz += 1;
    try
    {
      localChoreographer = Choreographer.getInstance();
      if (localChoreographer != null)
      {
        if (localChoreographer != null) {
          this.choreographer = localChoreographer;
        }
        AppMethodBeat.o(140209);
        return localChoreographer;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if ((this.eKz == 1) || (this.eKz % 100000 == 0)) {
          c.c.printStackTrace("AnimationFrameHandler", (Throwable)localException, "get choreographer failed [" + this.eKz + "] times. but it's ok, i will try it later if needed. " + localException, new Object[0]);
        }
        Object localObject = null;
      }
      this.eKq.post((Runnable)new a(this));
      AppMethodBeat.o(140209);
    }
    return null;
  }
  
  public final a.b avR()
  {
    return this.eKA;
  }
  
  public final void doFrame(long paramLong)
  {
    AppMethodBeat.i(140212);
    if (this.Uz)
    {
      Choreographer localChoreographer = this.choreographer;
      if (localChoreographer != null) {
        localChoreographer.postFrameCallback((Choreographer.FrameCallback)this);
      }
      x(paramLong / 1000000.0D);
    }
    AppMethodBeat.o(140212);
  }
  
  public final void onCreate() {}
  
  public final void onPause()
  {
    AppMethodBeat.i(140211);
    Choreographer localChoreographer = this.choreographer;
    if (localChoreographer != null)
    {
      localChoreographer.removeFrameCallback((Choreographer.FrameCallback)this);
      AppMethodBeat.o(140211);
      return;
    }
    AppMethodBeat.o(140211);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(140210);
    Choreographer localChoreographer = avS();
    if (localChoreographer != null) {
      localChoreographer.removeFrameCallback((Choreographer.FrameCallback)this);
    }
    if (localChoreographer != null)
    {
      localChoreographer.postFrameCallback((Choreographer.FrameCallback)this);
      AppMethodBeat.o(140210);
      return;
    }
    AppMethodBeat.o(140210);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
  static final class a
    implements Runnable
  {
    a(c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(140208);
      if (!this.eKB.Uz)
      {
        AppMethodBeat.o(140208);
        return;
      }
      Choreographer localChoreographer = c.a(this.eKB);
      if (localChoreographer == null)
      {
        AppMethodBeat.o(140208);
        return;
      }
      localChoreographer.removeFrameCallback((Choreographer.FrameCallback)this.eKB);
      localChoreographer.postFrameCallback((Choreographer.FrameCallback)this.eKB);
      c.c.i("AnimationFrameHandler", "Aha! we get a choreographer after try [" + c.b(this.eKB) + "] times ", new Object[0]);
      AppMethodBeat.o(140208);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.magicbrush.ui.c
 * JD-Core Version:    0.7.0.1
 */