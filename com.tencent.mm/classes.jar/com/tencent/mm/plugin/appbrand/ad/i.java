package com.tencent.mm.plugin.appbrand.ad;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime.b;

public final class i
  extends AppBrandRuntime.b
{
  public boolean nAV = false;
  
  public final void NO()
  {
    AppMethodBeat.i(254044);
    super.NO();
    this.nAV = true;
    AppMethodBeat.o(254044);
  }
  
  public final void prepare()
  {
    this.nAV = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.i
 * JD-Core Version:    0.7.0.1
 */