package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.b.c.a;

public final class r
  extends q
{
  p kte;
  c.a ktq;
  
  r(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    super(paramc);
  }
  
  public final void ad(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(138214);
    if (this.kte != null) {
      this.kte.bgW();
    }
    if ((paramAppBrandRuntime != null) && (this.ktq != null)) {
      paramAppBrandRuntime.jdK.b(this.ktq);
    }
    this.kte = null;
    this.ktq = null;
    this.ktl = null;
    AppMethodBeat.o(138214);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.d.r
 * JD-Core Version:    0.7.0.1
 */