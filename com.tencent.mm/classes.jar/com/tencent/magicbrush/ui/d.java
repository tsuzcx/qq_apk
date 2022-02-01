package com.tencent.magicbrush.ui;

import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.handler.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gjZ={1, 1, 13}, gka={""}, gkb={"Lcom/tencent/magicbrush/ui/ChoreographerInMainThreadAFHandler;", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "jsThreadHandler", "Lcom/tencent/magicbrush/handler/MBJsThreadHandler;", "(Lcom/tencent/magicbrush/MBRuntime;Lcom/tencent/magicbrush/handler/MBJsThreadHandler;)V", "bridge", "Lcom/tencent/magicbrush/ui/ChoreographerInMainThreadAFHandler$MainThreadChoreographerBridge;", "getBridge", "()Lcom/tencent/magicbrush/ui/ChoreographerInMainThreadAFHandler$MainThreadChoreographerBridge;", "choreographer", "Landroid/view/Choreographer;", "getChoreographer", "()Landroid/view/Choreographer;", "setChoreographer", "(Landroid/view/Choreographer;)V", "latency", "Lcom/tencent/magicbrush/ui/LatencyCalculator;", "strategy", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getStrategy", "()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getLatency", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Latency;", "onCreate", "", "onDestroy", "onPause", "onResume", "MainThreadChoreographerBridge", "lib-magicbrush-nano_release"})
final class d
  extends a
{
  private final a.b cAA;
  final a cAC;
  private final f cAy;
  volatile Choreographer choreographer;
  
  public d(MBRuntime paramMBRuntime, c paramc)
  {
    super(paramMBRuntime, paramc);
    AppMethodBeat.i(213369);
    this.cAy = new f();
    this.cAA = a.b.cAt;
    this.cAC = new a();
    AppMethodBeat.o(213369);
  }
  
  public final a.b HM()
  {
    return this.cAA;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(140218);
    com.tencent.magicbrush.utils.f localf = com.tencent.magicbrush.utils.f.cBw;
    com.tencent.magicbrush.utils.f.e((d.g.a.a)new b(this));
    AppMethodBeat.o(140218);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(140220);
    if (this.choreographer != null)
    {
      Choreographer localChoreographer = this.choreographer;
      if (localChoreographer == null) {
        p.gkB();
      }
      localChoreographer.removeFrameCallback((Choreographer.FrameCallback)this.cAC);
    }
    AppMethodBeat.o(140220);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(140219);
    if (this.choreographer != null)
    {
      Choreographer localChoreographer = this.choreographer;
      if (localChoreographer == null) {
        p.gkB();
      }
      localChoreographer.removeFrameCallback((Choreographer.FrameCallback)this.cAC);
      localChoreographer = this.choreographer;
      if (localChoreographer == null) {
        p.gkB();
      }
      localChoreographer.postFrameCallback((Choreographer.FrameCallback)this.cAC);
    }
    AppMethodBeat.o(140219);
  }
  
  @l(gjZ={1, 1, 13}, gka={""}, gkb={"Lcom/tencent/magicbrush/ui/ChoreographerInMainThreadAFHandler$MainThreadChoreographerBridge;", "Landroid/view/Choreographer$FrameCallback;", "Ljava/lang/Runnable;", "(Lcom/tencent/magicbrush/ui/ChoreographerInMainThreadAFHandler;)V", "frameTimeNanos", "", "getFrameTimeNanos", "()J", "setFrameTimeNanos", "(J)V", "doFrame", "", "run", "lib-magicbrush-nano_release"})
  final class a
    implements Choreographer.FrameCallback, Runnable
  {
    private long cAD;
    
    public final void doFrame(long paramLong)
    {
      AppMethodBeat.i(140215);
      this.cAD = paramLong;
      d.a(this.cAE);
      this.cAE.cAq.post((Runnable)this.cAE.cAC);
      AppMethodBeat.o(140215);
    }
    
    public final void run()
    {
      AppMethodBeat.i(140216);
      if (this.cAE.isRunning) {}
      synchronized (this.cAE.cAp)
      {
        Object localObject2 = this.cAE.choreographer;
        if (localObject2 != null)
        {
          ((Choreographer)localObject2).postFrameCallback((Choreographer.FrameCallback)this.cAE.cAC);
          localObject2 = z.Nhr;
        }
        this.cAE.g(this.cAD / 1000000.0D);
        AppMethodBeat.o(140216);
        return;
      }
    }
  }
  
  @l(gjZ={1, 1, 13}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<z>
  {
    b(d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.ui.d
 * JD-Core Version:    0.7.0.1
 */