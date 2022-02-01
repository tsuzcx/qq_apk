package com.tencent.magicbrush.ui;

import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.handler.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/magicbrush/ui/ChoreographerInMainThreadAFHandler;", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "jsThreadHandler", "Lcom/tencent/magicbrush/handler/MBJsThreadHandler;", "(Lcom/tencent/magicbrush/MBRuntime;Lcom/tencent/magicbrush/handler/MBJsThreadHandler;)V", "bridge", "Lcom/tencent/magicbrush/ui/ChoreographerInMainThreadAFHandler$MainThreadChoreographerBridge;", "getBridge", "()Lcom/tencent/magicbrush/ui/ChoreographerInMainThreadAFHandler$MainThreadChoreographerBridge;", "choreographer", "Landroid/view/Choreographer;", "getChoreographer", "()Landroid/view/Choreographer;", "setChoreographer", "(Landroid/view/Choreographer;)V", "latency", "Lcom/tencent/magicbrush/ui/LatencyCalculator;", "strategy", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getStrategy", "()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getLatency", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Latency;", "onCreate", "", "onDestroy", "onPause", "onResume", "MainThreadChoreographerBridge", "lib-magicbrush-nano_release"})
final class d
  extends a
{
  volatile Choreographer choreographer;
  private final f crT;
  private final a.b crV;
  final a crX;
  
  public d(MBRuntime paramMBRuntime, c paramc)
  {
    super(paramMBRuntime, paramc);
    AppMethodBeat.i(193575);
    this.crT = new f();
    this.crV = a.b.crP;
    this.crX = new a();
    AppMethodBeat.o(193575);
  }
  
  public final a.b Gx()
  {
    return this.crV;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(140218);
    com.tencent.magicbrush.utils.f localf = com.tencent.magicbrush.utils.f.csP;
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
        k.fvU();
      }
      localChoreographer.removeFrameCallback((Choreographer.FrameCallback)this.crX);
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
        k.fvU();
      }
      localChoreographer.removeFrameCallback((Choreographer.FrameCallback)this.crX);
      localChoreographer = this.choreographer;
      if (localChoreographer == null) {
        k.fvU();
      }
      localChoreographer.postFrameCallback((Choreographer.FrameCallback)this.crX);
    }
    AppMethodBeat.o(140219);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/magicbrush/ui/ChoreographerInMainThreadAFHandler$MainThreadChoreographerBridge;", "Landroid/view/Choreographer$FrameCallback;", "Ljava/lang/Runnable;", "(Lcom/tencent/magicbrush/ui/ChoreographerInMainThreadAFHandler;)V", "frameTimeNanos", "", "getFrameTimeNanos", "()J", "setFrameTimeNanos", "(J)V", "doFrame", "", "run", "lib-magicbrush-nano_release"})
  final class a
    implements Choreographer.FrameCallback, Runnable
  {
    private long crY;
    
    public final void doFrame(long paramLong)
    {
      AppMethodBeat.i(140215);
      this.crY = paramLong;
      synchronized (this.crZ.crL)
      {
        if (this.crZ.isRunning)
        {
          localObject2 = this.crZ.choreographer;
          if (localObject2 != null) {
            ((Choreographer)localObject2).postFrameCallback((Choreographer.FrameCallback)this.crZ.crX);
          }
        }
        Object localObject2 = y.JfV;
        d.a(this.crZ);
        this.crZ.crM.post((Runnable)this.crZ.crX);
        AppMethodBeat.o(140215);
        return;
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(140216);
      if (this.crZ.isRunning) {
        this.crZ.g(this.crY / 1000000.0D);
      }
      AppMethodBeat.o(140216);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.ui.d
 * JD-Core Version:    0.7.0.1
 */