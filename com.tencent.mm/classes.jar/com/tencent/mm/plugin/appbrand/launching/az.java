package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.luggage.sdk.h.d;
import com.tencent.luggage.sdk.launching.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ac;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.plugin.appbrand.appcache.bm.1;
import com.tencent.mm.plugin.appbrand.appcache.bm.2;
import com.tencent.mm.plugin.appbrand.appcache.bw;
import com.tencent.mm.plugin.appbrand.appcache.k.a;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.protocal.protobuf.aeo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Objects;

public class az
  extends aw<WxaPkgWrappingInfo>
{
  private final String appId;
  private final int euz;
  private final WxaAttributes.WxaVersionInfo rbC;
  private final aeo sYL;
  private final x tbV;
  private final QualitySession tbW;
  private volatile boolean tbX;
  
  az(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, WxaAttributes.WxaVersionInfo paramWxaVersionInfo, boolean paramBoolean1, ICommLibReader paramICommLibReader, QualitySession paramQualitySession, e parame, boolean paramBoolean2)
  {
    AppMethodBeat.i(320747);
    this.tbX = false;
    this.appId = paramString1;
    this.euz = paramInt1;
    this.tbW = paramQualitySession;
    this.rbC = paramWxaVersionInfo;
    this.sYL = new aeo();
    this.sYL.hUn = paramInt2;
    aeo localaeo = this.sYL;
    if (paramBoolean2) {}
    for (paramInt2 = 102;; paramInt2 = 101)
    {
      localaeo.ZmB = paramInt2;
      parame.a(this.sYL);
      this.tbV = new ad(paramString1, paramInt1, paramBoolean1, paramString2, paramString3, paramWxaVersionInfo, paramICommLibReader, paramQualitySession, this.sYL)
      {
        public final void czK()
        {
          AppMethodBeat.i(47334);
          super.czK();
          az.this.czK();
          AppMethodBeat.o(47334);
        }
        
        public final void onDownloadProgress(int paramAnonymousInt)
        {
          AppMethodBeat.i(47336);
          super.onDownloadProgress(paramAnonymousInt);
          az.this.onDownloadProgress(paramAnonymousInt);
          AppMethodBeat.o(47336);
        }
      };
      AppMethodBeat.o(320747);
      return;
    }
  }
  
  public static boolean cAu()
  {
    AppMethodBeat.i(320752);
    if (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yPm, 1) > 0)
    {
      AppMethodBeat.o(320752);
      return true;
    }
    AppMethodBeat.o(320752);
    return false;
  }
  
  public final WxaPkgWrappingInfo cnT()
  {
    AppMethodBeat.i(320766);
    long l1 = Util.nowMilliSecond();
    String str;
    if (k.a.zn(this.euz))
    {
      if (!cAu())
      {
        localObject1 = n.cfm();
        str = this.appId;
        bm.1 local1 = new bm.1((bm)localObject1, str, this.rbC);
        ((Boolean)Objects.requireNonNull((Boolean)d.b("flushWxaAppVersionInfoV2 ".concat(String.valueOf(str)), new bm.2((bm)localObject1, local1)))).booleanValue();
      }
      if ((this.rbC.rcA >= 0L) && (this.rbC.appVersion > 0)) {
        ((bw)n.ag(bw.class)).b(this.appId, this.rbC.appVersion, this.rbC.rcA);
      }
    }
    Object localObject1 = (WxaPkgWrappingInfo)this.tbV.call();
    long l2 = Util.nowMilliSecond();
    if (localObject1 != null) {
      if (this.tbX) {
        com.tencent.mm.plugin.appbrand.keylogger.c.a(this.appId, KSProcessWeAppLaunch.stepPrepareResourceSubProcessCodePkg_Download, "", l1, l2);
      }
    }
    for (;;)
    {
      try
      {
        str = this.tbW.eup;
        if (localObject1 == null) {
          continue;
        }
        bool = true;
        ai.b.b(str, bool, l2 - l1);
      }
      finally
      {
        boolean bool;
        Log.e("MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper", "call() reportUpdateResultAfterVersionFallbackIfNeed get exception %s", new Object[] { localObject2 });
        continue;
      }
      AppMethodBeat.o(320766);
      return localObject1;
      com.tencent.mm.plugin.appbrand.keylogger.c.a(this.appId, KSProcessWeAppLaunch.stepPrepareResourceSubProcessCodePkg_DB, "", l1, l2);
      continue;
      if (this.tbX)
      {
        com.tencent.mm.plugin.appbrand.keylogger.c.a(this.appId, KSProcessWeAppLaunch.stepPrepareResourceSubProcessCodePkg_Download, "", "", l1, l2);
      }
      else
      {
        com.tencent.mm.plugin.appbrand.keylogger.c.a(this.appId, KSProcessWeAppLaunch.stepPrepareResourceSubProcessCodePkg_DB, "", "", l1, l2);
        continue;
        bool = false;
      }
    }
  }
  
  public void czK()
  {
    AppMethodBeat.i(320761);
    this.tbX = true;
    if (k.a.zn(this.euz)) {
      ac.cgo();
    }
    AppMethodBeat.o(320761);
  }
  
  final String getTag()
  {
    return "MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper";
  }
  
  public final void jY(boolean paramBoolean)
  {
    AppMethodBeat.i(180313);
    super.jY(paramBoolean);
    if ((this.tbV instanceof x.a))
    {
      ((x.a)this.tbV).jY(paramBoolean);
      AppMethodBeat.o(180313);
      return;
    }
    if ((this.tbV instanceof aw)) {
      ((aw)this.tbV).jY(paramBoolean);
    }
    AppMethodBeat.o(180313);
  }
  
  public final void jZ(boolean paramBoolean)
  {
    if ((this.tbV instanceof ad)) {
      ((ad)this.tbV).sXU = paramBoolean;
    }
  }
  
  public void onDownloadProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.az
 * JD-Core Version:    0.7.0.1
 */