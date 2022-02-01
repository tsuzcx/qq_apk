package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.a;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;

public class bg
  extends bb<au>
{
  final int aBM;
  final String appId;
  final AppBrandLaunchReferrer cce;
  final int dxE;
  final int enterScene;
  final int hxM;
  final QualitySession jDH;
  final String jjf;
  final AppBrandLaunchFromNotifyReferrer jjr;
  final String liG;
  final ICommLibReader loa;
  final String userName;
  
  bg(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, AppBrandLaunchReferrer paramAppBrandLaunchReferrer, String paramString3, ICommLibReader paramICommLibReader, QualitySession paramQualitySession, String paramString4, AppBrandLaunchFromNotifyReferrer paramAppBrandLaunchFromNotifyReferrer)
  {
    AppMethodBeat.i(186855);
    this.appId = paramString1;
    this.hxM = paramInt1;
    this.dxE = paramInt2;
    this.enterScene = paramInt3;
    this.jjf = paramString2;
    this.cce = paramAppBrandLaunchReferrer;
    this.liG = paramString3;
    this.userName = paramString4;
    this.jjr = paramAppBrandLaunchFromNotifyReferrer;
    paramString1 = j.aVC().a(paramString1, paramInt1, new String[] { "version" });
    if (paramString1 == null) {}
    for (paramInt1 = 0;; paramInt1 = paramString1.field_version)
    {
      this.aBM = paramInt1;
      this.loa = paramICommLibReader;
      this.jDH = paramQualitySession;
      AppMethodBeat.o(186855);
      return;
    }
  }
  
  public static boolean b(au paramau)
  {
    return paramau.field_jsapiInfo != null;
  }
  
  public static boolean tI(int paramInt)
  {
    AppMethodBeat.i(47351);
    if (1055 == paramInt)
    {
      AppMethodBeat.o(47351);
      return true;
    }
    if (1037 == paramInt)
    {
      AppMethodBeat.o(47351);
      return true;
    }
    int[] arrayOfInt = AppBrandGlobalSystemConfig.bat().jCF;
    if ((arrayOfInt != null) && (a.contains(arrayOfInt, paramInt)))
    {
      AppMethodBeat.o(47351);
      return true;
    }
    AppMethodBeat.o(47351);
    return false;
  }
  
  void aUg() {}
  
  final String getTag()
  {
    return "MicroMsg.AppBrand.PrepareStepCheckLaunchInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.bg
 * JD-Core Version:    0.7.0.1
 */