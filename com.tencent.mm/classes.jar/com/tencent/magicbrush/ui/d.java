package com.tencent.magicbrush.ui;

import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.handler.c;
import com.tencent.magicbrush.utils.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/magicbrush/ui/ChoreographerInMainThreadAFHandler;", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "jsThreadHandler", "Lcom/tencent/magicbrush/handler/MBJsThreadHandler;", "(Lcom/tencent/magicbrush/MBRuntime;Lcom/tencent/magicbrush/handler/MBJsThreadHandler;)V", "bridge", "Lcom/tencent/magicbrush/ui/ChoreographerInMainThreadAFHandler$MainThreadChoreographerBridge;", "getBridge", "()Lcom/tencent/magicbrush/ui/ChoreographerInMainThreadAFHandler$MainThreadChoreographerBridge;", "choreographer", "Landroid/view/Choreographer;", "getChoreographer", "()Landroid/view/Choreographer;", "setChoreographer", "(Landroid/view/Choreographer;)V", "latency", "Lcom/tencent/magicbrush/ui/LatencyCalculator;", "strategy", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getStrategy", "()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getLatency", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Latency;", "onCreate", "", "onDestroy", "onPause", "onResume", "MainThreadChoreographerBridge", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 16})
final class d
  extends a
{
  volatile Choreographer choreographer;
  private final a.b eKA;
  final a eKC;
  private final f eKy;
  
  public d(MBRuntime paramMBRuntime, c paramc)
  {
    super(paramMBRuntime, paramc);
    AppMethodBeat.i(229023);
    this.eKy = new f();
    this.eKA = a.b.eKt;
    this.eKC = new a();
    AppMethodBeat.o(229023);
  }
  
  public final a.b avR()
  {
    return this.eKA;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(140218);
    g localg = g.eLt;
    g.w((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(140218);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(140220);
    if (this.choreographer != null)
    {
      Choreographer localChoreographer = this.choreographer;
      if (localChoreographer == null) {
        s.klw();
      }
      localChoreographer.removeFrameCallback((Choreographer.FrameCallback)this.eKC);
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
        s.klw();
      }
      localChoreographer.removeFrameCallback((Choreographer.FrameCallback)this.eKC);
      localChoreographer = this.choreographer;
      if (localChoreographer == null) {
        s.klw();
      }
      localChoreographer.postFrameCallback((Choreographer.FrameCallback)this.eKC);
    }
    AppMethodBeat.o(140219);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/magicbrush/ui/ChoreographerInMainThreadAFHandler$MainThreadChoreographerBridge;", "Landroid/view/Choreographer$FrameCallback;", "Ljava/lang/Runnable;", "(Lcom/tencent/magicbrush/ui/ChoreographerInMainThreadAFHandler;)V", "frameTimeNanos", "", "getFrameTimeNanos", "()J", "setFrameTimeNanos", "(J)V", "doFrame", "", "run", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 16})
  final class a
    implements Choreographer.FrameCallback, Runnable
  {
    private long eKD;
    
    public final void doFrame(long paramLong)
    {
      AppMethodBeat.i(140215);
      this.eKD = paramLong;
      d.a(this.eKE);
      this.eKE.eKq.post((Runnable)this.eKE.eKC);
      AppMethodBeat.o(140215);
    }
    
    public final void run()
    {
      AppMethodBeat.i(140216);
      if (this.eKE.Uz) {}
      synchronized (this.eKE.eKp)
      {
        Object localObject2 = this.eKE.choreographer;
        if (localObject2 != null)
        {
          ((Choreographer)localObject2).postFrameCallback((Choreographer.FrameCallback)this.eKE.eKC);
          localObject2 = ah.aiuX;
        }
        this.eKE.x(this.eKD / 1000000.0D);
        AppMethodBeat.o(140216);
        return;
      }
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.magicbrush.ui.d
 * JD-Core Version:    0.7.0.1
 */