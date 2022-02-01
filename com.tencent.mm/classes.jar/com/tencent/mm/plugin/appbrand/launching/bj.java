package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.a;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import java.util.concurrent.Callable;

public class bj
  extends be<ax>
{
  final int aDD;
  final String appId;
  final AppBrandLaunchReferrer cmx;
  final int dLf;
  final int enterScene;
  final int hSZ;
  final String jFL;
  final AppBrandLaunchFromNotifyReferrer jFX;
  final QualitySession kaS;
  final String lKk;
  final ICommLibReader lPS;
  final String userName;
  
  bj(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, AppBrandLaunchReferrer paramAppBrandLaunchReferrer, String paramString3, ICommLibReader paramICommLibReader, QualitySession paramQualitySession, String paramString4, AppBrandLaunchFromNotifyReferrer paramAppBrandLaunchFromNotifyReferrer)
  {
    AppMethodBeat.i(222796);
    this.appId = paramString1;
    this.hSZ = paramInt1;
    this.dLf = paramInt2;
    this.enterScene = paramInt3;
    this.jFL = paramString2;
    this.cmx = paramAppBrandLaunchReferrer;
    this.lKk = paramString3;
    this.userName = paramString4;
    this.jFX = paramAppBrandLaunchFromNotifyReferrer;
    paramString1 = j.aZu().a(paramString1, paramInt1, new String[] { "version" });
    if (paramString1 == null) {}
    for (paramInt1 = 0;; paramInt1 = paramString1.field_version)
    {
      this.aDD = paramInt1;
      this.lPS = paramICommLibReader;
      this.kaS = paramQualitySession;
      AppMethodBeat.o(222796);
      return;
    }
  }
  
  public static boolean b(ax paramax)
  {
    return (paramax != null) && (paramax.field_jsapiInfo != null);
  }
  
  public static boolean us(int paramInt)
  {
    AppMethodBeat.i(47351);
    int[] arrayOfInt = AppBrandGlobalSystemConfig.bez().jZQ;
    if ((arrayOfInt != null) && (a.contains(arrayOfInt, paramInt)))
    {
      AppMethodBeat.o(47351);
      return true;
    }
    AppMethodBeat.o(47351);
    return false;
  }
  
  void aXJ() {}
  
  final String getTag()
  {
    return "MicroMsg.AppBrand.PrepareStepCheckLaunchInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.bj
 * JD-Core Version:    0.7.0.1
 */