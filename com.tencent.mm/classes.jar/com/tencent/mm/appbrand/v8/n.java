package com.tencent.mm.appbrand.v8;

import com.eclipsesource.v8.MultiContextV8;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Timer;
import java.util.TimerTask;

final class n
{
  final MultiContextV8 doQ;
  final IJSRuntime dqn;
  Timer dqo;
  final Runnable dqp;
  
  public n(MultiContextV8 paramMultiContextV8, IJSRuntime paramIJSRuntime)
  {
    AppMethodBeat.i(144072);
    this.dqp = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144070);
        n.this.doQ.debuggerMessageLoop();
        AppMethodBeat.o(144070);
      }
    };
    this.doQ = paramMultiContextV8;
    this.dqn = paramIJSRuntime;
    AppMethodBeat.o(144072);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.n
 * JD-Core Version:    0.7.0.1
 */