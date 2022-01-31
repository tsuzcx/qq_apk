package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.u.k;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;

final class y$b$1
  extends n
{
  y$b$1(y.b paramb, int paramInt, k paramk, CountDownLatch paramCountDownLatch)
  {
    super(paramInt);
  }
  
  final String alJ()
  {
    return String.format(Locale.US, "NonIncremental %d", new Object[] { Integer.valueOf(y.b.a(this.gLo)) });
  }
  
  protected final void b(WxaPkgLoadProgress paramWxaPkgLoadProgress)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "hy: onPkgUpdateProgress %s", new Object[] { paramWxaPkgLoadProgress.toString() });
    if (paramWxaPkgLoadProgress.progress >= 100) {
      return;
    }
    this.gLo.gLl.onDownloadProgress(paramWxaPkgLoadProgress.progress);
  }
  
  final void c(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
  {
    this.fWF.value = paramWxaPkgWrappingInfo;
    this.eeA.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.y.b.1
 * JD-Core Version:    0.7.0.1
 */