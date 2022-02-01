package com.tencent.mm.appbrand.v8;

import com.eclipsesource.v8.MultiContextV8;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

public class y
  extends a
{
  private MultiContextV8 cYm;
  
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
  
  final MultiContextV8 Ng()
  {
    AppMethodBeat.i(144127);
    this.cYm = MultiContextV8.createMultiContextV8(this.cYu, this.cYs, this.cYt);
    this.cYt = null;
    MultiContextV8 localMultiContextV8 = this.cYm;
    AppMethodBeat.o(144127);
    return localMultiContextV8;
  }
  
  c Nh()
  {
    AppMethodBeat.i(144128);
    z localz = z.ck(this.cYA.cYL);
    AppMethodBeat.o(144128);
    return localz;
  }
  
  final void Ni()
  {
    AppMethodBeat.i(144129);
    try
    {
      this.cYm.release();
      AppMethodBeat.o(144129);
      return;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.V8JSRuntime", "commonCleanUp exp = %s", new Object[] { localException });
      AppMethodBeat.o(144129);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.y
 * JD-Core Version:    0.7.0.1
 */