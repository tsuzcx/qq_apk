package com.tencent.mm.plugin.appbrand.ad;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime.b;

public final class i
  extends AppBrandRuntime.b
{
  public boolean chu = false;
  
  public final void KY()
  {
    AppMethodBeat.i(226278);
    super.KY();
    this.chu = true;
    AppMethodBeat.o(226278);
  }
  
  public final void prepare()
  {
    this.chu = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.i
 * JD-Core Version:    0.7.0.1
 */