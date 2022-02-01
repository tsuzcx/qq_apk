package com.tencent.mm.appbrand.v8;

import com.eclipsesource.mmv8.MultiContextV8;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Future;

final class n
{
  final MultiContextV8 fhw;
  final IJSRuntime fiU;
  Future<?> fiV;
  final Runnable fiW;
  
  public n(MultiContextV8 paramMultiContextV8, IJSRuntime paramIJSRuntime)
  {
    AppMethodBeat.i(144072);
    this.fiW = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144070);
        n.this.fhw.debuggerMessageLoop();
        AppMethodBeat.o(144070);
      }
    };
    this.fhw = paramMultiContextV8;
    this.fiU = paramIJSRuntime;
    AppMethodBeat.o(144072);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.n
 * JD-Core Version:    0.7.0.1
 */