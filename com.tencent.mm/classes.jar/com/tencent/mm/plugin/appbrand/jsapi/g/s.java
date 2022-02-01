package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.c.a;

public final class s
  extends r
{
  q kSc;
  c.a kSu;
  
  s(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    super(paramc);
  }
  
  public final void W(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(138214);
    if (this.kSc != null) {
      this.kSc.bll();
    }
    if ((paramAppBrandRuntime != null) && (this.kSu != null)) {
      paramAppBrandRuntime.jzQ.b(this.kSu);
    }
    this.kSc = null;
    this.kSu = null;
    this.kSp = null;
    AppMethodBeat.o(138214);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.s
 * JD-Core Version:    0.7.0.1
 */