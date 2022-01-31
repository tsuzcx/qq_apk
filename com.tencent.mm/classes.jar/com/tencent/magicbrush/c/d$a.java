package com.tencent.magicbrush.c;

import a.l;
import a.y;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/magicbrush/ui/ChoreographerInMainThreadAFHandler$MainThreadChoreographerBridge;", "Landroid/view/Choreographer$FrameCallback;", "Ljava/lang/Runnable;", "(Lcom/tencent/magicbrush/ui/ChoreographerInMainThreadAFHandler;)V", "frameTimeNanos", "", "getFrameTimeNanos", "()J", "setFrameTimeNanos", "(J)V", "doFrame", "", "run", "lib-magicbrush-nano_release"})
final class d$a
  implements Choreographer.FrameCallback, Runnable
{
  private long bLz;
  
  public final void doFrame(long paramLong)
  {
    AppMethodBeat.i(151494);
    this.bLz = paramLong;
    synchronized (this.bLA.bLl)
    {
      if (this.bLA.isRunning)
      {
        localObject2 = this.bLA.choreographer;
        if (localObject2 != null) {
          ((Choreographer)localObject2).postFrameCallback((Choreographer.FrameCallback)this.bLA.bLy);
        }
      }
      Object localObject2 = y.BMg;
      d.a(this.bLA);
      this.bLA.bLm.post((Runnable)this.bLA.bLy);
      AppMethodBeat.o(151494);
      return;
    }
  }
  
  public final void run()
  {
    AppMethodBeat.i(151495);
    if (this.bLA.isRunning) {
      this.bLA.notifyAnimationFrame(this.bLz / 1000000.0D);
    }
    AppMethodBeat.o(151495);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.magicbrush.c.d.a
 * JD-Core Version:    0.7.0.1
 */