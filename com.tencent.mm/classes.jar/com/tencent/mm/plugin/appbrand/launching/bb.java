package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.luggage.sdk.launching.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.a;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import java.util.concurrent.Callable;

public class bb
  extends aw<ap>
{
  final String appId;
  final int appVersion;
  final AppBrandLaunchReferrer cys;
  final b cyz;
  final int ecU;
  final int enterScene;
  final int iOo;
  final AppBrandLaunchFromNotifyReferrer kHI;
  final String kHw;
  final QualitySession ldW;
  final String mRZ;
  private final String mRk;
  final ICommLibReader mWR;
  final String userName;
  
  bb(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, AppBrandLaunchReferrer paramAppBrandLaunchReferrer, String paramString3, ICommLibReader paramICommLibReader, QualitySession paramQualitySession, String paramString4, AppBrandLaunchFromNotifyReferrer paramAppBrandLaunchFromNotifyReferrer, String paramString5, b paramb)
  {
    AppMethodBeat.i(227109);
    this.appId = paramString1;
    this.iOo = paramInt1;
    this.ecU = paramInt2;
    this.enterScene = paramInt3;
    this.kHw = paramString2;
    this.cys = paramAppBrandLaunchReferrer;
    this.mRZ = paramString3;
    this.userName = paramString4;
    this.kHI = paramAppBrandLaunchFromNotifyReferrer;
    this.mRk = paramString5;
    this.cyz = paramb;
    paramString1 = n.buL().a(paramString1, paramInt1, new String[] { "version" });
    if (paramString1 == null) {}
    for (paramInt1 = 0;; paramInt1 = paramString1.field_version)
    {
      this.appVersion = paramInt1;
      this.mWR = paramICommLibReader;
      this.ldW = paramQualitySession;
      AppMethodBeat.o(227109);
      return;
    }
  }
  
  public static boolean b(ap paramap)
  {
    return (paramap != null) && (paramap.field_jsapiInfo != null);
  }
  
  public static boolean yl(int paramInt)
  {
    AppMethodBeat.i(47351);
    int[] arrayOfInt = AppBrandGlobalSystemConfig.bzP().lcT;
    if ((arrayOfInt != null) && (a.contains(arrayOfInt, paramInt)))
    {
      AppMethodBeat.o(47351);
      return true;
    }
    AppMethodBeat.o(47351);
    return false;
  }
  
  void bsQ() {}
  
  final String getTag()
  {
    return "MicroMsg.AppBrand.PrepareStepCheckLaunchInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.bb
 * JD-Core Version:    0.7.0.1
 */