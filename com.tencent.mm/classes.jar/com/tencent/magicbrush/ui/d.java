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

@l(gfx={1, 1, 13}, gfy={""}, gfz={"Lcom/tencent/magicbrush/ui/ChoreographerInMainThreadAFHandler;", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "jsThreadHandler", "Lcom/tencent/magicbrush/handler/MBJsThreadHandler;", "(Lcom/tencent/magicbrush/MBRuntime;Lcom/tencent/magicbrush/handler/MBJsThreadHandler;)V", "bridge", "Lcom/tencent/magicbrush/ui/ChoreographerInMainThreadAFHandler$MainThreadChoreographerBridge;", "getBridge", "()Lcom/tencent/magicbrush/ui/ChoreographerInMainThreadAFHandler$MainThreadChoreographerBridge;", "choreographer", "Landroid/view/Choreographer;", "getChoreographer", "()Landroid/view/Choreographer;", "setChoreographer", "(Landroid/view/Choreographer;)V", "latency", "Lcom/tencent/magicbrush/ui/LatencyCalculator;", "strategy", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getStrategy", "()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getLatency", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Latency;", "onCreate", "", "onDestroy", "onPause", "onResume", "MainThreadChoreographerBridge", "lib-magicbrush-nano_release"})
final class d
  extends a
{
  volatile Choreographer choreographer;
  private final f czR;
  private final a.b czT;
  final a czV;
  
  public d(MBRuntime paramMBRuntime, c paramc)
  {
    super(paramMBRuntime, paramc);
    AppMethodBeat.i(215125);
    this.czR = new f();
    this.czT = a.b.czM;
    this.czV = new a();
    AppMethodBeat.o(215125);
  }
  
  public final a.b HE()
  {
    return this.czT;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(140218);
    com.tencent.magicbrush.utils.f localf = com.tencent.magicbrush.utils.f.cAP;
    com.tencent.magicbrush.utils.f.d((d.g.a.a)new b(this));
    AppMethodBeat.o(140218);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(140220);
    if (this.choreographer != null)
    {
      Choreographer localChoreographer = this.choreographer;
      if (localChoreographer == null) {
        p.gfZ();
      }
      localChoreographer.removeFrameCallback((Choreographer.FrameCallback)this.czV);
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
        p.gfZ();
      }
      localChoreographer.removeFrameCallback((Choreographer.FrameCallback)this.czV);
      localChoreographer = this.choreographer;
      if (localChoreographer == null) {
        p.gfZ();
      }
      localChoreographer.postFrameCallback((Choreographer.FrameCallback)this.czV);
    }
    AppMethodBeat.o(140219);
  }
  
  @l(gfx={1, 1, 13}, gfy={""}, gfz={"Lcom/tencent/magicbrush/ui/ChoreographerInMainThreadAFHandler$MainThreadChoreographerBridge;", "Landroid/view/Choreographer$FrameCallback;", "Ljava/lang/Runnable;", "(Lcom/tencent/magicbrush/ui/ChoreographerInMainThreadAFHandler;)V", "frameTimeNanos", "", "getFrameTimeNanos", "()J", "setFrameTimeNanos", "(J)V", "doFrame", "", "run", "lib-magicbrush-nano_release"})
  final class a
    implements Choreographer.FrameCallback, Runnable
  {
    private long czW;
    
    public final void doFrame(long paramLong)
    {
      AppMethodBeat.i(140215);
      this.czW = paramLong;
      d.a(this.czX);
      this.czX.czJ.post((Runnable)this.czX.czV);
      AppMethodBeat.o(140215);
    }
    
    public final void run()
    {
      AppMethodBeat.i(140216);
      if (this.czX.isRunning) {}
      synchronized (this.czX.czI)
      {
        Object localObject2 = this.czX.choreographer;
        if (localObject2 != null)
        {
          ((Choreographer)localObject2).postFrameCallback((Choreographer.FrameCallback)this.czX.czV);
          localObject2 = z.MKo;
        }
        this.czX.g(this.czW / 1000000.0D);
        AppMethodBeat.o(140216);
        return;
      }
    }
  }
  
  @l(gfx={1, 1, 13}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.ui.d
 * JD-Core Version:    0.7.0.1
 */