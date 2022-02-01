package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.luggage.sdk.launching.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.compatible.loader.a;
import com.tencent.mm.plugin.appbrand.appcache.k.a;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.launching.report.AppBrandRuntimeReloadReportBundle;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.protobuf.dgu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public class bb
  extends aw<Pair<ak, dgu>>
{
  final String appId;
  final int appVersion;
  final int enterScene;
  final AppBrandLaunchReferrer eoV;
  final e epm;
  final int euz;
  final int icZ;
  final int launchMode;
  final String qAF;
  final AppBrandLaunchFromNotifyReferrer qAQ;
  final QualitySession qYm;
  final AppBrandRuntimeReloadReportBundle qYu;
  final String sXS;
  private final String sXh;
  final ICommLibReader tca;
  final String userName;
  
  bb(String paramString1, int paramInt1, WxaAttributes.WxaVersionInfo paramWxaVersionInfo, int paramInt2, int paramInt3, String paramString2, AppBrandLaunchReferrer paramAppBrandLaunchReferrer, String paramString3, ICommLibReader paramICommLibReader, QualitySession paramQualitySession, String paramString4, AppBrandLaunchFromNotifyReferrer paramAppBrandLaunchFromNotifyReferrer, String paramString5, e parame, int paramInt4, AppBrandRuntimeReloadReportBundle paramAppBrandRuntimeReloadReportBundle)
  {
    AppMethodBeat.i(320733);
    this.appId = paramString1;
    this.euz = paramInt1;
    if (k.a.zn(paramInt1)) {}
    for (paramInt1 = paramWxaVersionInfo.appVersion;; paramInt1 = 0)
    {
      this.appVersion = paramInt1;
      this.icZ = paramInt2;
      this.enterScene = paramInt3;
      this.qAF = paramString2;
      this.eoV = paramAppBrandLaunchReferrer;
      this.sXS = paramString3;
      this.userName = paramString4;
      this.qAQ = paramAppBrandLaunchFromNotifyReferrer;
      this.sXh = paramString5;
      this.epm = parame;
      this.launchMode = paramInt4;
      this.qYu = paramAppBrandRuntimeReloadReportBundle;
      this.tca = paramICommLibReader;
      this.qYm = paramQualitySession;
      AppMethodBeat.o(320733);
      return;
    }
  }
  
  public static boolean Ca(int paramInt)
  {
    AppMethodBeat.i(47351);
    int[] arrayOfInt = AppBrandGlobalSystemConfig.ckD().qWS;
    if ((arrayOfInt != null) && (a.contains(arrayOfInt, paramInt)))
    {
      AppMethodBeat.o(47351);
      return true;
    }
    AppMethodBeat.o(47351);
    return false;
  }
  
  public static boolean b(ak paramak)
  {
    return (paramak != null) && (paramak.field_jsapiInfo != null);
  }
  
  private boolean cAv()
  {
    AppMethodBeat.i(320742);
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    long l = Util.currentTicks();
    PBool localPBool = new PBool();
    new PrepareStepCheckLaunchInfo.2(this, f.hfK, l, localPBool, localCountDownLatch).alive();
    try
    {
      localCountDownLatch.await();
      boolean bool = localPBool.value;
      AppMethodBeat.o(320742);
      return bool;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.AppBrand.PrepareStepCheckLaunchInfo", "waitForCommLibUpdated get exception:%s", new Object[] { localException });
      AppMethodBeat.o(320742);
    }
    return true;
  }
  
  void cda() {}
  
  final String getTag()
  {
    return "MicroMsg.AppBrand.PrepareStepCheckLaunchInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.bb
 * JD-Core Version:    0.7.0.1
 */