package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.luggage.sdk.launching.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.a;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.protobuf.cqa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public class az
  extends au<Pair<aj, cqa>>
{
  final String appId;
  final int appVersion;
  final int cBU;
  final AppBrandLaunchReferrer cwV;
  final b cxe;
  final int enterScene;
  final int fXa;
  final int launchMode;
  final AppBrandLaunchFromNotifyReferrer nBB;
  final String nBq;
  final QualitySession nYk;
  final String pST;
  private final String pSf;
  final ICommLibReader pXk;
  final String userName;
  
  az(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, AppBrandLaunchReferrer paramAppBrandLaunchReferrer, String paramString3, ICommLibReader paramICommLibReader, QualitySession paramQualitySession, String paramString4, AppBrandLaunchFromNotifyReferrer paramAppBrandLaunchFromNotifyReferrer, String paramString5, b paramb, int paramInt4)
  {
    AppMethodBeat.i(250675);
    this.appId = paramString1;
    this.cBU = paramInt1;
    this.fXa = paramInt2;
    this.enterScene = paramInt3;
    this.nBq = paramString2;
    this.cwV = paramAppBrandLaunchReferrer;
    this.pST = paramString3;
    this.userName = paramString4;
    this.nBB = paramAppBrandLaunchFromNotifyReferrer;
    this.pSf = paramString5;
    this.cxe = paramb;
    this.launchMode = paramInt4;
    paramString1 = m.bFP().c(paramString1, paramInt1, new String[] { "version" });
    if (paramString1 == null) {}
    for (paramInt1 = 0;; paramInt1 = paramString1.field_version)
    {
      this.appVersion = paramInt1;
      this.pXk = paramICommLibReader;
      this.nYk = paramQualitySession;
      AppMethodBeat.o(250675);
      return;
    }
  }
  
  public static boolean BL(int paramInt)
  {
    AppMethodBeat.i(47351);
    int[] arrayOfInt = AppBrandGlobalSystemConfig.bLe().nXc;
    if ((arrayOfInt != null) && (a.contains(arrayOfInt, paramInt)))
    {
      AppMethodBeat.o(47351);
      return true;
    }
    AppMethodBeat.o(47351);
    return false;
  }
  
  public static boolean b(aj paramaj)
  {
    return (paramaj != null) && (paramaj.field_jsapiInfo != null);
  }
  
  private boolean cah()
  {
    AppMethodBeat.i(250676);
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    long l = Util.currentTicks();
    PBool localPBool = new PBool();
    new az.2(this, l, localPBool, localCountDownLatch).alive();
    try
    {
      localCountDownLatch.await();
      boolean bool = localPBool.value;
      AppMethodBeat.o(250676);
      return bool;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.AppBrand.PrepareStepCheckLaunchInfo", "waitForCommLibUpdated get exception:%s", new Object[] { localException });
      AppMethodBeat.o(250676);
    }
    return true;
  }
  
  void bDN() {}
  
  final String getTag()
  {
    return "MicroMsg.AppBrand.PrepareStepCheckLaunchInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.az
 * JD-Core Version:    0.7.0.1
 */