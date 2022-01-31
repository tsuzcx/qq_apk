package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.am.a;
import com.tencent.mm.plugin.appbrand.appcache.ar;
import com.tencent.mm.plugin.appbrand.appcache.at;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.d;
import com.tencent.mm.plugin.appbrand.u.k;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

final class y$b
  implements Callable<WxaPkgWrappingInfo>
{
  private final int gLn;
  
  private y$b(y paramy, int paramInt)
  {
    this.gLn = paramInt;
  }
  
  public final WxaPkgWrappingInfo aft()
  {
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    k localk = new k();
    y.b.1 local1 = new y.b.1(this, this.gLl.fJy, localk, localCountDownLatch);
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "tryDownload, not incremental before start appId(%s), type(%d), pkgVersion(%d)", new Object[] { this.gLl.appId, Integer.valueOf(this.gLl.fJy), Integer.valueOf(this.gLn) });
    if (this.gLl.fJy != 0)
    {
      this.gLl.fWD = e.abb().aj(this.gLl.appId, this.gLl.fJy);
      if (bk.bl(this.gLl.fWD))
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "tryDownload, get EMPTY url appId(%s), type(%d)", new Object[] { this.gLl.appId, Integer.valueOf(this.gLl.fJy) });
        this.gLl.a(am.a.fEd);
        return null;
      }
    }
    if (!at.a(this.gLl.appId, this.gLl.fJy, this.gLn, this.gLl.fQY.fRt, this.gLl.fWD, local1))
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "tryDownload, not incremental FATAL ERROR appId(%s), type(%d), pkgVersion(%d)", new Object[] { this.gLl.appId, Integer.valueOf(this.gLl.fJy), Integer.valueOf(this.gLn) });
      this.gLl.a(am.a.fEh);
      return null;
    }
    try
    {
      localCountDownLatch.await();
      return (WxaPkgWrappingInfo)localk.value;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.AppBrand.PrepareStepCheckAppPkg", localException, "downloadNonIncremental semaphore exp ", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.y.b
 * JD-Core Version:    0.7.0.1
 */