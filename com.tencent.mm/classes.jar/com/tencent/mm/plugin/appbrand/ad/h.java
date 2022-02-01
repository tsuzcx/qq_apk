package com.tencent.mm.plugin.appbrand.ad;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime.b;

public final class h
  extends AppBrandRuntime.b
{
  public boolean bWM = false;
  
  public final void BI()
  {
    AppMethodBeat.i(187963);
    super.BI();
    this.bWM = true;
    AppMethodBeat.o(187963);
  }
  
  public final void prepare()
  {
    this.bWM = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.h
 * JD-Core Version:    0.7.0.1
 */