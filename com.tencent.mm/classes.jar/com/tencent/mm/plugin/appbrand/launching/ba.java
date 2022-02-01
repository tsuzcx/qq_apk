package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.luggage.sdk.launching.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.aa;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.keylogger.c;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class ba
  extends aw<WxaPkgWrappingInfo>
{
  private final String appId;
  private final int iOo;
  private final acc mSK;
  final w mWN;
  private final QualitySession mWO;
  private volatile boolean mWP;
  
  ba(String paramString1, int paramInt1, String paramString2, int paramInt2, WxaAttributes.WxaVersionInfo paramWxaVersionInfo, boolean paramBoolean1, ICommLibReader paramICommLibReader, QualitySession paramQualitySession, b paramb, boolean paramBoolean2)
  {
    AppMethodBeat.i(227104);
    this.mWP = false;
    this.appId = paramString1;
    this.iOo = paramInt1;
    this.mWO = paramQualitySession;
    this.mSK = new acc();
    this.mSK.dUS = paramInt2;
    acc localacc = this.mSK;
    boolean bool;
    if (b.cBC == paramb)
    {
      bool = true;
      localacc.LmF = bool;
      paramb = this.mSK;
      if (!paramBoolean2) {
        break label152;
      }
    }
    label152:
    for (paramInt2 = 102;; paramInt2 = 101)
    {
      paramb.LmG = paramInt2;
      if (j.a.vP(paramInt1)) {
        n.buL().a(paramString1, paramWxaVersionInfo);
      }
      this.mWN = new ae(paramString1, paramInt1, paramBoolean1, paramString2, paramWxaVersionInfo, paramICommLibReader, paramQualitySession, this.mSK)
      {
        public final void bNi()
        {
          AppMethodBeat.i(47334);
          super.bNi();
          ba.this.bNi();
          AppMethodBeat.o(47334);
        }
        
        public final void onDownloadProgress(int paramAnonymousInt)
        {
          AppMethodBeat.i(47336);
          super.onDownloadProgress(paramAnonymousInt);
          ba.this.onDownloadProgress(paramAnonymousInt);
          AppMethodBeat.o(47336);
        }
      };
      AppMethodBeat.o(227104);
      return;
      bool = false;
      break;
    }
  }
  
  public final WxaPkgWrappingInfo bCi()
  {
    AppMethodBeat.i(227106);
    long l1 = Util.nowMilliSecond();
    WxaPkgWrappingInfo localWxaPkgWrappingInfo = (WxaPkgWrappingInfo)this.mWN.call();
    long l2 = Util.nowMilliSecond();
    if (localWxaPkgWrappingInfo != null) {
      if (this.mWP) {
        c.a(this.appId, KSProcessWeAppLaunch.stepPrepareResourceSubProcessCodePkg_Download, "", l1, l2);
      }
    }
    for (;;)
    {
      try
      {
        String str = this.mWO.kEY;
        if (localWxaPkgWrappingInfo == null) {
          continue;
        }
        bool = true;
        an.b.b(str, bool, l2 - l1);
      }
      catch (Throwable localThrowable)
      {
        boolean bool;
        Log.e("MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper", "call() reportUpdateResultAfterVersionFallbackIfNeed get exception %s", new Object[] { localThrowable });
        continue;
      }
      AppMethodBeat.o(227106);
      return localWxaPkgWrappingInfo;
      c.a(this.appId, KSProcessWeAppLaunch.stepPrepareResourceSubProcessCodePkg_DB, "", l1, l2);
      continue;
      if (this.mWP)
      {
        c.a(this.appId, KSProcessWeAppLaunch.stepPrepareResourceSubProcessCodePkg_Download, "", "", l1, l2);
      }
      else
      {
        c.a(this.appId, KSProcessWeAppLaunch.stepPrepareResourceSubProcessCodePkg_DB, "", "", l1, l2);
        continue;
        bool = false;
      }
    }
  }
  
  public void bNi()
  {
    AppMethodBeat.i(227105);
    this.mWP = true;
    if (j.a.vP(this.iOo)) {
      aa.bvL();
    }
    AppMethodBeat.o(227105);
  }
  
  final String getTag()
  {
    return "MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper";
  }
  
  public final void hX(boolean paramBoolean)
  {
    AppMethodBeat.i(180313);
    super.hX(paramBoolean);
    if ((this.mWN instanceof w.a))
    {
      ((w.a)this.mWN).hX(paramBoolean);
      AppMethodBeat.o(180313);
      return;
    }
    if ((this.mWN instanceof aw)) {
      ((aw)this.mWN).hX(paramBoolean);
    }
    AppMethodBeat.o(180313);
  }
  
  public void onDownloadProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ba
 * JD-Core Version:    0.7.0.1
 */