package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;

final class ai$b$1
  extends u
{
  ai$b$1(ai.b paramb, int paramInt, j paramj, CountDownLatch paramCountDownLatch)
  {
    super(paramInt);
  }
  
  final String aGZ()
  {
    AppMethodBeat.i(131961);
    String str = String.format(Locale.US, "NonIncremental %d", new Object[] { Integer.valueOf(ai.b.a(this.imF)) });
    AppMethodBeat.o(131961);
    return str;
  }
  
  protected final void b(WxaPkgLoadProgress paramWxaPkgLoadProgress)
  {
    AppMethodBeat.i(131963);
    ab.d("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "hy: onPkgUpdateProgress %s", new Object[] { paramWxaPkgLoadProgress.toString() });
    if (paramWxaPkgLoadProgress.progress >= 100)
    {
      AppMethodBeat.o(131963);
      return;
    }
    this.imF.imC.onDownloadProgress(paramWxaPkgLoadProgress.progress);
    AppMethodBeat.o(131963);
  }
  
  final void c(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
  {
    AppMethodBeat.i(131962);
    this.hqf.value = paramWxaPkgWrappingInfo;
    this.fuC.countDown();
    AppMethodBeat.o(131962);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ai.b.1
 * JD-Core Version:    0.7.0.1
 */