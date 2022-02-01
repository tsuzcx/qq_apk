package com.tencent.mm.plugin.appbrand.jsapi.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.e;

public final class u
  extends t
{
  s oUT;
  c.a oVn;
  
  u(e parame)
  {
    super(parame);
  }
  
  public final void Y(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(138214);
    if (this.oUT != null) {
      this.oUT.bSn();
    }
    if ((paramAppBrandRuntime != null) && (this.oVn != null)) {
      paramAppBrandRuntime.ntR.b(this.oVn);
    }
    this.oUT = null;
    this.oVn = null;
    this.oVi = null;
    AppMethodBeat.o(138214);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.u
 * JD-Core Version:    0.7.0.1
 */