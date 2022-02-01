package com.tencent.mm.plugin.appbrand.ad;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime.b;

public final class i
  extends AppBrandRuntime.b
{
  public boolean bWM = false;
  
  public final void BJ()
  {
    AppMethodBeat.i(222076);
    super.BJ();
    this.bWM = true;
    AppMethodBeat.o(222076);
  }
  
  public final void prepare()
  {
    this.bWM = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.i
 * JD-Core Version:    0.7.0.1
 */