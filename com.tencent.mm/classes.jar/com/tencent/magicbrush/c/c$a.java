package com.tencent.magicbrush.c;

import a.l;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.magicbrush.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class c$a
  implements Runnable
{
  c$a(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(154375);
    if (!this.bLx.isRunning)
    {
      AppMethodBeat.o(154375);
      return;
    }
    Choreographer localChoreographer = c.a(this.bLx);
    if (localChoreographer == null)
    {
      AppMethodBeat.o(154375);
      return;
    }
    localChoreographer.removeFrameCallback((Choreographer.FrameCallback)this.bLx);
    localChoreographer.postFrameCallback((Choreographer.FrameCallback)this.bLx);
    c.c.i("AnimationFrameHandler", "Aha! we get a choreographer after try [" + c.b(this.bLx) + "] times ", new Object[0]);
    AppMethodBeat.o(154375);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.magicbrush.c.c.a
 * JD-Core Version:    0.7.0.1
 */