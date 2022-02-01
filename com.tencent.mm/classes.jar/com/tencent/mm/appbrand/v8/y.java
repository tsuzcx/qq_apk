package com.tencent.mm.appbrand.v8;

import com.eclipsesource.v8.MultiContextV8;
import com.eclipsesource.v8.V8;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class y
  extends a
{
  private MultiContextV8 doQ;
  
  y(IJSRuntime.Config paramConfig)
  {
    super(paramConfig);
  }
  
  static y f(IJSRuntime.Config paramConfig)
  {
    AppMethodBeat.i(144126);
    paramConfig = new y(paramConfig);
    AppMethodBeat.o(144126);
    return paramConfig;
  }
  
  final MultiContextV8 Xs()
  {
    AppMethodBeat.i(144127);
    this.doQ = MultiContextV8.createMultiContextV8(this.doZ, this.doX, this.doY);
    this.doY = null;
    MultiContextV8 localMultiContextV8 = this.doQ;
    AppMethodBeat.o(144127);
    return localMultiContextV8;
  }
  
  c Xt()
  {
    AppMethodBeat.i(144128);
    ab localab = ab.a(new ab.a()
    {
      public final void XP()
      {
        AppMethodBeat.i(216925);
        y.a(y.this).getV8().pumpMessageLoopDirect();
        AppMethodBeat.o(216925);
      }
    }, this.dpf.dpp);
    AppMethodBeat.o(144128);
    return localab;
  }
  
  final void Xu()
  {
    AppMethodBeat.i(144129);
    try
    {
      this.doQ.release();
      AppMethodBeat.o(144129);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.V8JSRuntime", "commonCleanUp exp = %s", new Object[] { localException });
      AppMethodBeat.o(144129);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.y
 * JD-Core Version:    0.7.0.1
 */