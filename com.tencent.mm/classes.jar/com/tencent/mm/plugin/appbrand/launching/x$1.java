package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;

final class x$1
  extends u
{
  x$1(x paramx, int paramInt)
  {
    super(paramInt);
  }
  
  final String aGZ()
  {
    AppMethodBeat.i(131896);
    String str = this.ilP.aHc();
    AppMethodBeat.o(131896);
    return str;
  }
  
  protected final void b(WxaPkgLoadProgress paramWxaPkgLoadProgress)
  {
    AppMethodBeat.i(131898);
    super.b(paramWxaPkgLoadProgress);
    this.ilP.c(paramWxaPkgLoadProgress);
    AppMethodBeat.o(131898);
  }
  
  final void c(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
  {
    AppMethodBeat.i(131897);
    this.ilP.d(paramWxaPkgWrappingInfo);
    this.ilP.e(paramWxaPkgWrappingInfo);
    AppMethodBeat.o(131897);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.x.1
 * JD-Core Version:    0.7.0.1
 */