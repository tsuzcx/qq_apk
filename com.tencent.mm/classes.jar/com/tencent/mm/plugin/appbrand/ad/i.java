package com.tencent.mm.plugin.appbrand.ad;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime.b;

public final class i
  extends AppBrandRuntime.b
{
  public boolean ewf = false;
  
  public final void prepare()
  {
    this.ewf = false;
  }
  
  public final void ready()
  {
    AppMethodBeat.i(321262);
    super.ready();
    this.ewf = true;
    AppMethodBeat.o(321262);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.i
 * JD-Core Version:    0.7.0.1
 */