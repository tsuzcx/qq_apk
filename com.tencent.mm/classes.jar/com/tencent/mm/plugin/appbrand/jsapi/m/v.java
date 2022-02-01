package com.tencent.mm.plugin.appbrand.jsapi.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.b.c;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.f;

public final class v
  extends u
{
  c.a saD;
  s sag;
  
  v(f paramf)
  {
    super(paramf);
  }
  
  public final void am(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(138214);
    if (this.sag != null) {
      this.sag.css();
    }
    if ((paramAppBrandRuntime != null) && (this.saD != null)) {
      paramAppBrandRuntime.qsB.b(this.saD);
    }
    this.sag = null;
    this.saD = null;
    this.say = null;
    AppMethodBeat.o(138214);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.v
 * JD-Core Version:    0.7.0.1
 */