package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.a;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.bc;
import com.tencent.mm.plugin.appbrand.appcache.bg;
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
  final AppBrandLaunchReferrer cmv;
  final int dJQ;
  final int enterScene;
  final int hQh;
  final String jCN;
  final AppBrandLaunchFromNotifyReferrer jCZ;
  final QualitySession jXD;
  final String lFL;
  final ICommLibReader lLs;
  final String userName;
  
  bj(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, AppBrandLaunchReferrer paramAppBrandLaunchReferrer, String paramString3, ICommLibReader paramICommLibReader, QualitySession paramQualitySession, String paramString4, AppBrandLaunchFromNotifyReferrer paramAppBrandLaunchFromNotifyReferrer)
  {
    AppMethodBeat.i(188637);
    this.appId = paramString1;
    this.hQh = paramInt1;
    this.dJQ = paramInt2;
    this.enterScene = paramInt3;
    this.jCN = paramString2;
    this.cmv = paramAppBrandLaunchReferrer;
    this.lFL = paramString3;
    this.userName = paramString4;
    this.jCZ = paramAppBrandLaunchFromNotifyReferrer;
    paramString1 = j.aYX().a(paramString1, paramInt1, new String[] { "version" });
    if (paramString1 == null) {}
    for (paramInt1 = 0;; paramInt1 = paramString1.field_version)
    {
      this.aDD = paramInt1;
      this.lLs = paramICommLibReader;
      this.jXD = paramQualitySession;
      AppMethodBeat.o(188637);
      return;
    }
  }
  
  public static boolean b(ax paramax)
  {
    return (paramax != null) && (paramax.field_jsapiInfo != null);
  }
  
  public static boolean um(int paramInt)
  {
    AppMethodBeat.i(47351);
    int[] arrayOfInt = AppBrandGlobalSystemConfig.bdT().jWB;
    if ((arrayOfInt != null) && (a.contains(arrayOfInt, paramInt)))
    {
      AppMethodBeat.o(47351);
      return true;
    }
    AppMethodBeat.o(47351);
    return false;
  }
  
  void aXo() {}
  
  final String getTag()
  {
    return "MicroMsg.AppBrand.PrepareStepCheckLaunchInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.bj
 * JD-Core Version:    0.7.0.1
 */