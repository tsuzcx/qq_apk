package com.tencent.magicbrush.ui;

import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.handler.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.y;

@d.l(fNY={1, 1, 13}, fNZ={""}, fOa={"Lcom/tencent/magicbrush/ui/ChoreographerInMainThreadAFHandler;", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "jsThreadHandler", "Lcom/tencent/magicbrush/handler/MBJsThreadHandler;", "(Lcom/tencent/magicbrush/MBRuntime;Lcom/tencent/magicbrush/handler/MBJsThreadHandler;)V", "bridge", "Lcom/tencent/magicbrush/ui/ChoreographerInMainThreadAFHandler$MainThreadChoreographerBridge;", "getBridge", "()Lcom/tencent/magicbrush/ui/ChoreographerInMainThreadAFHandler$MainThreadChoreographerBridge;", "choreographer", "Landroid/view/Choreographer;", "getChoreographer", "()Landroid/view/Choreographer;", "setChoreographer", "(Landroid/view/Choreographer;)V", "latency", "Lcom/tencent/magicbrush/ui/LatencyCalculator;", "strategy", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getStrategy", "()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getLatency", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Latency;", "onCreate", "", "onDestroy", "onPause", "onResume", "MainThreadChoreographerBridge", "lib-magicbrush-nano_release"})
final class d
  extends a
{
  volatile Choreographer choreographer;
  private final f cpa;
  private final a.b cpc;
  final a cpe;
  
  public d(MBRuntime paramMBRuntime, c paramc)
  {
    super(paramMBRuntime, paramc);
    AppMethodBeat.i(190935);
    this.cpa = new f();
    this.cpc = a.b.coV;
    this.cpe = new a();
    AppMethodBeat.o(190935);
  }
  
  public final a.b Gj()
  {
    return this.cpc;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(140218);
    com.tencent.magicbrush.utils.f localf = com.tencent.magicbrush.utils.f.cpX;
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
        k.fOy();
      }
      localChoreographer.removeFrameCallback((Choreographer.FrameCallback)this.cpe);
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
        k.fOy();
      }
      localChoreographer.removeFrameCallback((Choreographer.FrameCallback)this.cpe);
      localChoreographer = this.choreographer;
      if (localChoreographer == null) {
        k.fOy();
      }
      localChoreographer.postFrameCallback((Choreographer.FrameCallback)this.cpe);
    }
    AppMethodBeat.o(140219);
  }
  
  @d.l(fNY={1, 1, 13}, fNZ={""}, fOa={"Lcom/tencent/magicbrush/ui/ChoreographerInMainThreadAFHandler$MainThreadChoreographerBridge;", "Landroid/view/Choreographer$FrameCallback;", "Ljava/lang/Runnable;", "(Lcom/tencent/magicbrush/ui/ChoreographerInMainThreadAFHandler;)V", "frameTimeNanos", "", "getFrameTimeNanos", "()J", "setFrameTimeNanos", "(J)V", "doFrame", "", "run", "lib-magicbrush-nano_release"})
  final class a
    implements Choreographer.FrameCallback, Runnable
  {
    private long cpf;
    
    public final void doFrame(long paramLong)
    {
      AppMethodBeat.i(140215);
      this.cpf = paramLong;
      d.a(this.cpg);
      this.cpg.coS.post((Runnable)this.cpg.cpe);
      AppMethodBeat.o(140215);
    }
    
    public final void run()
    {
      AppMethodBeat.i(140216);
      if (this.cpg.isRunning) {}
      synchronized (this.cpg.coR)
      {
        Object localObject2 = this.cpg.choreographer;
        if (localObject2 != null)
        {
          ((Choreographer)localObject2).postFrameCallback((Choreographer.FrameCallback)this.cpg.cpe);
          localObject2 = y.KTp;
        }
        this.cpg.g(this.cpf / 1000000.0D);
        AppMethodBeat.o(140216);
        return;
      }
    }
  }
  
  @d.l(fNY={1, 1, 13}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
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