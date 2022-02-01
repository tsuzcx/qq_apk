package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.f;

public final class t
  extends s
{
  c.a lXA;
  r lXi;
  
  t(f paramf)
  {
    super(paramf);
  }
  
  public final void X(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(138214);
    if (this.lXi != null) {
      this.lXi.bGH();
    }
    if ((paramAppBrandRuntime != null) && (this.lXA != null)) {
      paramAppBrandRuntime.kAH.b(this.lXA);
    }
    this.lXi = null;
    this.lXA = null;
    this.lXv = null;
    AppMethodBeat.o(138214);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.t
 * JD-Core Version:    0.7.0.1
 */