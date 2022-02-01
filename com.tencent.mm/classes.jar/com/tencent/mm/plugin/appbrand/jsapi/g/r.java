package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.c.a;

public final class r
  extends q
{
  p kOA;
  c.a kOM;
  
  r(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    super(paramc);
  }
  
  public final void X(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(138214);
    if (this.kOA != null) {
      this.kOA.bkB();
    }
    if ((paramAppBrandRuntime != null) && (this.kOM != null)) {
      paramAppBrandRuntime.jwS.b(this.kOM);
    }
    this.kOA = null;
    this.kOM = null;
    this.kOH = null;
    AppMethodBeat.o(138214);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.r
 * JD-Core Version:    0.7.0.1
 */