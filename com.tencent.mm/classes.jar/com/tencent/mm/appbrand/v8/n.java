package com.tencent.mm.appbrand.v8;

import com.eclipsesource.mmv8.MultiContextV8;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.concurrent.Future;

final class n
{
  final MultiContextV8 hlG;
  final IJSRuntime hnh;
  Future<?> hni;
  final Runnable hnj;
  
  public n(MultiContextV8 paramMultiContextV8, IJSRuntime paramIJSRuntime)
  {
    AppMethodBeat.i(144072);
    this.hnj = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144070);
        n.this.hlG.debuggerMessageLoop();
        AppMethodBeat.o(144070);
      }
    };
    this.hlG = paramMultiContextV8;
    this.hnh = paramIJSRuntime;
    AppMethodBeat.o(144072);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.n
 * JD-Core Version:    0.7.0.1
 */