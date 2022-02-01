package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.luggage.sdk.launching.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ab;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.plugin.appbrand.appcache.bx;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.keylogger.c;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.protocal.protobuf.ack;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class ax
  extends au<WxaPkgWrappingInfo>
{
  private final String appId;
  private final int cBU;
  private final ack pTH;
  private final v pXf;
  private final QualitySession pXg;
  private volatile boolean pXh;
  
  ax(String paramString1, int paramInt1, String paramString2, int paramInt2, WxaAttributes.WxaVersionInfo paramWxaVersionInfo, boolean paramBoolean1, ICommLibReader paramICommLibReader, QualitySession paramQualitySession, b paramb, boolean paramBoolean2)
  {
    AppMethodBeat.i(277285);
    this.pXh = false;
    this.appId = paramString1;
    this.cBU = paramInt1;
    this.pXg = paramQualitySession;
    this.pTH = new ack();
    this.pTH.fOu = paramInt2;
    ack localack = this.pTH;
    boolean bool;
    if (b.cBf == paramb)
    {
      bool = true;
      localack.SnY = bool;
      paramb = this.pTH;
      if (!paramBoolean2) {
        break label193;
      }
    }
    label193:
    for (paramInt2 = 102;; paramInt2 = 101)
    {
      paramb.SnZ = paramInt2;
      if (j.a.za(paramInt1))
      {
        m.bFP().a(paramString1, paramWxaVersionInfo);
        if ((paramWxaVersionInfo.obN >= 0L) && (paramWxaVersionInfo.appVersion > 0)) {
          ((bx)m.W(bx.class)).b(paramString1, paramWxaVersionInfo.appVersion, paramWxaVersionInfo.obN);
        }
      }
      this.pXf = new ac(paramString1, paramInt1, paramBoolean1, paramString2, paramWxaVersionInfo, paramICommLibReader, paramQualitySession, this.pTH)
      {
        public final void bZz()
        {
          AppMethodBeat.i(47334);
          super.bZz();
          ax.this.bZz();
          AppMethodBeat.o(47334);
        }
        
        public final void onDownloadProgress(int paramAnonymousInt)
        {
          AppMethodBeat.i(47336);
          super.onDownloadProgress(paramAnonymousInt);
          ax.this.onDownloadProgress(paramAnonymousInt);
          AppMethodBeat.o(47336);
        }
      };
      AppMethodBeat.o(277285);
      return;
      bool = false;
      break;
    }
  }
  
  public final WxaPkgWrappingInfo bNE()
  {
    AppMethodBeat.i(277287);
    long l1 = Util.nowMilliSecond();
    WxaPkgWrappingInfo localWxaPkgWrappingInfo = (WxaPkgWrappingInfo)this.pXf.call();
    long l2 = Util.nowMilliSecond();
    if (localWxaPkgWrappingInfo != null) {
      if (this.pXh) {
        c.a(this.appId, KSProcessWeAppLaunch.stepPrepareResourceSubProcessCodePkg_Download, "", l1, l2);
      }
    }
    for (;;)
    {
      try
      {
        String str = this.pXg.cBH;
        if (localWxaPkgWrappingInfo == null) {
          continue;
        }
        bool = true;
        ah.b.b(str, bool, l2 - l1);
      }
      catch (Throwable localThrowable)
      {
        boolean bool;
        Log.e("MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper", "call() reportUpdateResultAfterVersionFallbackIfNeed get exception %s", new Object[] { localThrowable });
        continue;
      }
      AppMethodBeat.o(277287);
      return localWxaPkgWrappingInfo;
      c.a(this.appId, KSProcessWeAppLaunch.stepPrepareResourceSubProcessCodePkg_DB, "", l1, l2);
      continue;
      if (this.pXh)
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
  
  public void bZz()
  {
    AppMethodBeat.i(277286);
    this.pXh = true;
    if (j.a.za(this.cBU)) {
      ab.bGS();
    }
    AppMethodBeat.o(277286);
  }
  
  final String getTag()
  {
    return "MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper";
  }
  
  public final void iR(boolean paramBoolean)
  {
    AppMethodBeat.i(180313);
    super.iR(paramBoolean);
    if ((this.pXf instanceof v.a))
    {
      ((v.a)this.pXf).iR(paramBoolean);
      AppMethodBeat.o(180313);
      return;
    }
    if ((this.pXf instanceof au)) {
      ((au)this.pXf).iR(paramBoolean);
    }
    AppMethodBeat.o(180313);
  }
  
  public final void iS(boolean paramBoolean)
  {
    if ((this.pXf instanceof ac)) {
      ((ac)this.pXf).pSU = paramBoolean;
    }
  }
  
  public void onDownloadProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ax
 * JD-Core Version:    0.7.0.1
 */