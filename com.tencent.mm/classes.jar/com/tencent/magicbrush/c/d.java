package com.tencent.magicbrush.c;

import a.f.b.j;
import a.l;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/magicbrush/ui/ChoreographerInMainThreadAFHandler;", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "jsThreadHandler", "Lcom/tencent/magicbrush/handler/IJsThreadHandler;", "(Lcom/tencent/magicbrush/MBRuntime;Lcom/tencent/magicbrush/handler/IJsThreadHandler;)V", "bridge", "Lcom/tencent/magicbrush/ui/ChoreographerInMainThreadAFHandler$MainThreadChoreographerBridge;", "getBridge", "()Lcom/tencent/magicbrush/ui/ChoreographerInMainThreadAFHandler$MainThreadChoreographerBridge;", "choreographer", "Landroid/view/Choreographer;", "getChoreographer", "()Landroid/view/Choreographer;", "setChoreographer", "(Landroid/view/Choreographer;)V", "latency", "Lcom/tencent/magicbrush/ui/LatencyCalculator;", "strategy", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getStrategy", "()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getLatency", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Latency;", "onCreate", "", "onDestroy", "onPause", "onResume", "MainThreadChoreographerBridge", "lib-magicbrush-nano_release"})
final class d
  extends a
{
  private final f bLu;
  private final a.b bLw;
  final d.a bLy;
  volatile Choreographer choreographer;
  
  public d(MBRuntime paramMBRuntime, com.tencent.magicbrush.handler.a parama)
  {
    super(paramMBRuntime, parama);
    AppMethodBeat.i(151500);
    this.bLu = new f();
    this.bLw = a.b.bLq;
    this.bLy = new d.a(this);
    AppMethodBeat.o(151500);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(151497);
    c localc = c.bLK;
    c.a((a.f.a.a)new d.b(this));
    AppMethodBeat.o(151497);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(151499);
    if (this.choreographer != null)
    {
      Choreographer localChoreographer = this.choreographer;
      if (localChoreographer == null) {
        j.ebi();
      }
      localChoreographer.removeFrameCallback((Choreographer.FrameCallback)this.bLy);
    }
    AppMethodBeat.o(151499);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(151498);
    if (this.choreographer != null)
    {
      Choreographer localChoreographer = this.choreographer;
      if (localChoreographer == null) {
        j.ebi();
      }
      localChoreographer.removeFrameCallback((Choreographer.FrameCallback)this.bLy);
      localChoreographer = this.choreographer;
      if (localChoreographer == null) {
        j.ebi();
      }
      localChoreographer.postFrameCallback((Choreographer.FrameCallback)this.bLy);
    }
    AppMethodBeat.o(151498);
  }
  
  public final a.b yx()
  {
    return this.bLw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.magicbrush.c.d
 * JD-Core Version:    0.7.0.1
 */