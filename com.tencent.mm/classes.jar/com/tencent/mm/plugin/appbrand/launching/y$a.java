package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.j;
import com.tencent.mm.plugin.appbrand.u.k;
import com.tencent.mm.protocal.c.ane;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

final class y$a
  implements Callable<WxaPkgWrappingInfo>
{
  private final int gLi;
  private final int gLj;
  private final ane gLk;
  
  private y$a(y paramy, int paramInt1, int paramInt2, ane paramane)
  {
    this.gLi = paramInt1;
    this.gLj = paramInt2;
    this.gLk = paramane;
  }
  
  private WxaPkgWrappingInfo alO()
  {
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    k localk = new k();
    y.a.1 local1 = new y.a.1(this, this.gLl.fJy, localk, localCountDownLatch);
    if (!j.a(this.gLl.appId, this.gLi, this.gLj, this.gLk.bQC, local1)) {
      return null;
    }
    try
    {
      localCountDownLatch.await();
      return (WxaPkgWrappingInfo)localk.value;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.AppBrand.PrepareStepCheckAppPkg", localInterruptedException, "downloadIncremental semaphore exp ", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.y.a
 * JD-Core Version:    0.7.0.1
 */