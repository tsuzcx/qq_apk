package com.tencent.mm.appbrand.v8;

import com.eclipsesource.v8.MultiContextV8;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Timer;
import java.util.TimerTask;

final class n
{
  final MultiContextV8 cOG;
  final IJSRuntime cQa;
  Timer cQb;
  final Runnable cQc;
  
  public n(MultiContextV8 paramMultiContextV8, IJSRuntime paramIJSRuntime)
  {
    AppMethodBeat.i(144072);
    this.cQc = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144070);
        n.this.cOG.debuggerMessageLoop();
        AppMethodBeat.o(144070);
      }
    };
    this.cOG = paramMultiContextV8;
    this.cQa = paramIJSRuntime;
    AppMethodBeat.o(144072);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.n
 * JD-Core Version:    0.7.0.1
 */