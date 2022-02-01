package com.tencent.mm.appbrand.v8;

import com.eclipsesource.v8.MultiContextV8;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public class y
  extends a
{
  private MultiContextV8 cOG;
  
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
  
  final MultiContextV8 LF()
  {
    AppMethodBeat.i(144127);
    this.cOG = MultiContextV8.createMultiContextV8(this.cOM, this.cON);
    this.cON = null;
    MultiContextV8 localMultiContextV8 = this.cOG;
    AppMethodBeat.o(144127);
    return localMultiContextV8;
  }
  
  c LG()
  {
    AppMethodBeat.i(144128);
    z localz = z.ch(this.cOT.cPd);
    AppMethodBeat.o(144128);
    return localz;
  }
  
  final void LH()
  {
    AppMethodBeat.i(144129);
    try
    {
      this.cOG.release();
      AppMethodBeat.o(144129);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.V8JSRuntime", "commonCleanUp exp = %s", new Object[] { localException });
      AppMethodBeat.o(144129);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.y
 * JD-Core Version:    0.7.0.1
 */