package com.tencent.magicbrush.ui;

import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.handler.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/magicbrush/ui/ChoreographerInMainThreadAFHandler;", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "jsThreadHandler", "Lcom/tencent/magicbrush/handler/MBJsThreadHandler;", "(Lcom/tencent/magicbrush/MBRuntime;Lcom/tencent/magicbrush/handler/MBJsThreadHandler;)V", "bridge", "Lcom/tencent/magicbrush/ui/ChoreographerInMainThreadAFHandler$MainThreadChoreographerBridge;", "getBridge", "()Lcom/tencent/magicbrush/ui/ChoreographerInMainThreadAFHandler$MainThreadChoreographerBridge;", "choreographer", "Landroid/view/Choreographer;", "getChoreographer", "()Landroid/view/Choreographer;", "setChoreographer", "(Landroid/view/Choreographer;)V", "latency", "Lcom/tencent/magicbrush/ui/LatencyCalculator;", "strategy", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getStrategy", "()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getLatency", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Latency;", "onCreate", "", "onDestroy", "onPause", "onResume", "MainThreadChoreographerBridge", "lib-magicbrush-nano_release"})
final class d
  extends a
{
  private final f cOE;
  private final a.b cOG;
  final a cOI;
  volatile Choreographer choreographer;
  
  public d(MBRuntime paramMBRuntime, c paramc)
  {
    super(paramMBRuntime, paramc);
    AppMethodBeat.i(206870);
    this.cOE = new f();
    this.cOG = a.b.cOz;
    this.cOI = new a();
    AppMethodBeat.o(206870);
  }
  
  public final a.b RB()
  {
    return this.cOG;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(140218);
    com.tencent.magicbrush.utils.f localf = com.tencent.magicbrush.utils.f.cPx;
    com.tencent.magicbrush.utils.f.e((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(140218);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(140220);
    if (this.choreographer != null)
    {
      Choreographer localChoreographer = this.choreographer;
      if (localChoreographer == null) {
        p.hyc();
      }
      localChoreographer.removeFrameCallback((Choreographer.FrameCallback)this.cOI);
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
        p.hyc();
      }
      localChoreographer.removeFrameCallback((Choreographer.FrameCallback)this.cOI);
      localChoreographer = this.choreographer;
      if (localChoreographer == null) {
        p.hyc();
      }
      localChoreographer.postFrameCallback((Choreographer.FrameCallback)this.cOI);
    }
    AppMethodBeat.o(140219);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/magicbrush/ui/ChoreographerInMainThreadAFHandler$MainThreadChoreographerBridge;", "Landroid/view/Choreographer$FrameCallback;", "Ljava/lang/Runnable;", "(Lcom/tencent/magicbrush/ui/ChoreographerInMainThreadAFHandler;)V", "frameTimeNanos", "", "getFrameTimeNanos", "()J", "setFrameTimeNanos", "(J)V", "doFrame", "", "run", "lib-magicbrush-nano_release"})
  final class a
    implements Choreographer.FrameCallback, Runnable
  {
    private long cOJ;
    
    public final void doFrame(long paramLong)
    {
      AppMethodBeat.i(140215);
      this.cOJ = paramLong;
      d.a(this.cOK);
      this.cOK.cOw.post((Runnable)this.cOK.cOI);
      AppMethodBeat.o(140215);
    }
    
    public final void run()
    {
      AppMethodBeat.i(140216);
      if (this.cOK.isRunning) {}
      synchronized (this.cOK.cOv)
      {
        Object localObject2 = this.cOK.choreographer;
        if (localObject2 != null)
        {
          ((Choreographer)localObject2).postFrameCallback((Choreographer.FrameCallback)this.cOK.cOI);
          localObject2 = x.SXb;
        }
        this.cOK.h(this.cOJ / 1000000.0D);
        AppMethodBeat.o(140216);
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.magicbrush.ui.d
 * JD-Core Version:    0.7.0.1
 */