package com.tencent.mm.appbrand.v8;

import com.eclipsesource.v8.MultiContextV8;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Timer;
import java.util.TimerTask;

final class n
{
  final MultiContextV8 cYm;
  final IJSRuntime cZJ;
  Timer cZK;
  final Runnable cZL;
  
  public n(MultiContextV8 paramMultiContextV8, IJSRuntime paramIJSRuntime)
  {
    AppMethodBeat.i(144072);
    this.cZL = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144070);
        n.this.cYm.debuggerMessageLoop();
        AppMethodBeat.o(144070);
      }
    };
    this.cYm = paramMultiContextV8;
    this.cZJ = paramIJSRuntime;
    AppMethodBeat.o(144072);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.n
 * JD-Core Version:    0.7.0.1
 */