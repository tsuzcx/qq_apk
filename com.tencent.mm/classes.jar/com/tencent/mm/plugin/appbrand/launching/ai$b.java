package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.g;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.as.a;
import com.tencent.mm.plugin.appbrand.appcache.at;
import com.tencent.mm.plugin.appbrand.appcache.ay;
import com.tencent.mm.plugin.appbrand.appcache.ba;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

final class ai$b
  implements Callable<WxaPkgWrappingInfo>
{
  private final int imE;
  
  private ai$b(ai paramai, int paramInt)
  {
    this.imE = paramInt;
  }
  
  public final WxaPkgWrappingInfo azY()
  {
    AppMethodBeat.i(131965);
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    Object localObject = new j();
    ai.b.1 local1 = new ai.b.1(this, this.imC.hcr, (j)localObject, localCountDownLatch);
    ab.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "tryDownload, not incremental before start appId(%s), type(%d), pkgVersion(%d)", new Object[] { this.imC.appId, Integer.valueOf(this.imC.hcr), Integer.valueOf(this.imE) });
    if (j.a.kQ(this.imC.hcr))
    {
      at localat = g.auM().a(this.imC.appId, this.imC.hcr, new String[] { "versionMd5", "downloadURL" });
      if ((localat == null) || (bo.isNullOrNil(localat.field_downloadURL)))
      {
        ab.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "tryDownload, get EMPTY url appId(%s), type(%d), record(%s)", new Object[] { this.imC.appId, Integer.valueOf(this.imC.hcr), localat });
        this.imC.a(as.a.gWt);
        AppMethodBeat.o(131965);
        return null;
      }
      this.imC.hqd = localat.field_downloadURL;
      if (!ba.a(this.imC.appId, this.imC.hcr, this.imC.hqd, local1, new ai.b.2(this, localat)))
      {
        ab.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "tryDownload, not incremental FATAL ERROR appId(%s), type(%d), pkgVersion(%d)", new Object[] { this.imC.appId, Integer.valueOf(this.imC.hcr), Integer.valueOf(this.imE) });
        this.imC.a(as.a.gWx);
        AppMethodBeat.o(131965);
        return null;
      }
    }
    else if (!ba.a(this.imC.appId, this.imC.hcr, this.imE, this.imC.hjJ.hkh, this.imC.hqd, local1))
    {
      ab.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "tryDownload, not incremental FATAL ERROR appId(%s), type(%d), pkgVersion(%d)", new Object[] { this.imC.appId, Integer.valueOf(this.imC.hcr), Integer.valueOf(this.imE) });
      this.imC.a(as.a.gWx);
      AppMethodBeat.o(131965);
      return null;
    }
    try
    {
      localCountDownLatch.await();
      localObject = (WxaPkgWrappingInfo)((j)localObject).value;
      AppMethodBeat.o(131965);
      return localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.AppBrand.PrepareStepCheckAppPkg", localException, "downloadNonIncremental semaphore exp ", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ai.b
 * JD-Core Version:    0.7.0.1
 */