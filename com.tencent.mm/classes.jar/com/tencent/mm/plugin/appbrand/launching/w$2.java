package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;

final class w$2
  extends u
{
  w$2(w paramw)
  {
    super(0);
  }
  
  final String aGZ()
  {
    AppMethodBeat.i(131887);
    String str = this.ilN.aHc();
    AppMethodBeat.o(131887);
    return str;
  }
  
  protected final void b(WxaPkgLoadProgress paramWxaPkgLoadProgress)
  {
    AppMethodBeat.i(131889);
    this.ilN.c(paramWxaPkgLoadProgress);
    AppMethodBeat.o(131889);
  }
  
  final void c(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
  {
    AppMethodBeat.i(131888);
    this.ilN.d(paramWxaPkgWrappingInfo);
    this.ilN.e(paramWxaPkgWrappingInfo);
    AppMethodBeat.o(131888);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.w.2
 * JD-Core Version:    0.7.0.1
 */