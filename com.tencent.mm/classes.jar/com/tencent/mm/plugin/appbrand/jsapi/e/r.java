package com.tencent.mm.plugin.appbrand.jsapi.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.b.c.a;

public final class r
  extends q
{
  c.a jSE;
  p jSs;
  
  r(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    super(paramc);
  }
  
  public final void ad(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(138214);
    if (this.jSs != null) {
      this.jSs.bad();
    }
    if ((paramAppBrandRuntime != null) && (this.jSE != null)) {
      paramAppBrandRuntime.iDK.b(this.jSE);
    }
    this.jSs = null;
    this.jSE = null;
    this.jSz = null;
    AppMethodBeat.o(138214);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.e.r
 * JD-Core Version:    0.7.0.1
 */