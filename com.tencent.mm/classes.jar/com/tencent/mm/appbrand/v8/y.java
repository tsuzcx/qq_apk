package com.tencent.mm.appbrand.v8;

import com.eclipsesource.mmv8.MultiContextV8;
import com.eclipsesource.mmv8.V8;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class y
  extends a
{
  private MultiContextV8 hlG;
  
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
  
  final MultiContextV8 aDT()
  {
    AppMethodBeat.i(144127);
    this.hlG = MultiContextV8.createMultiContextV8(this.hlP, this.hlN, this.hlO);
    this.hlO = null;
    MultiContextV8 localMultiContextV8 = this.hlG;
    AppMethodBeat.o(144127);
    return localMultiContextV8;
  }
  
  c aDU()
  {
    AppMethodBeat.i(144128);
    ab localab = ab.a(new ab.a()
    {
      public final void aEv()
      {
        AppMethodBeat.i(238670);
        y.a(y.this).getV8().pumpMessageLoopDirect();
        AppMethodBeat.o(238670);
      }
    }, aDS().hmh);
    AppMethodBeat.o(144128);
    return localab;
  }
  
  final void aDV()
  {
    AppMethodBeat.i(144129);
    try
    {
      this.hlG.release();
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