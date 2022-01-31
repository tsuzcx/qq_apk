package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.page.s;
import com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.c;
import com.tencent.mm.protocal.c.cmf;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class l
{
  private static final l gZr = new l(true, h.gYz);
  public String appId;
  public int bFu;
  public String bFv;
  public String bFw;
  public String bIB;
  public int caB;
  public String caC;
  public int gXG;
  private final boolean gYN;
  private final h gYP;
  public String gYT;
  public int gYY;
  public int scene;
  
  private l(boolean paramBoolean, h paramh)
  {
    this.gYN = paramBoolean;
    this.gYP = paramh;
  }
  
  public static l aos()
  {
    return gZr;
  }
  
  public static l b(n paramn, String paramString, h paramh)
  {
    paramh = new l(false, paramh);
    paramh.bIB = paramString;
    paramh.appId = paramn.mAppId;
    paramString = paramn.aab();
    paramh.scene = paramString.scene;
    paramh.bFv = paramString.bFv;
    paramh.caB = paramString.caB;
    paramh.caC = paramString.caC;
    paramh.gXG = paramString.gXG;
    paramh.bFu = (paramn.aaa().fPS.fEM + 1);
    return paramh;
  }
  
  public final void j(s params)
  {
    this.bFw = params.ahc();
    params = this.gYP.g(params);
    if ((params != null) && (params.gYC != null))
    {
      params = params.gYC.path;
      this.gYT = params;
      if (!this.gYP.wd(this.bFw)) {
        break label242;
      }
    }
    label242:
    for (int i = 1;; i = 0)
    {
      this.gYY = i;
      if (!this.gYN)
      {
        params = new cmf();
        params.hQR = 1;
        params.euK = this.appId;
        params.tZb = this.bFw;
        params.nFi = 0;
        params.jxx = ((int)bk.UX());
        params.nFj = 1;
        params.tZc = "";
        params.tZd = this.bFu;
        params.sxe = this.bIB;
        params.tZe = c.cv(ae.getContext());
        params.qZN = this.scene;
        params.tZf = this.gXG;
        params.tZg = this.bFv;
        params.gYT = this.gYT;
        params.caB = this.caB;
        params.caC = this.caC;
        params.gYY = this.gYY;
        AppBrandIDKeyBatchReport.a(params);
        y.i("MicroMsg.AppBrand.Report.kv_14004", "report " + toString());
      }
      return;
      params = null;
      break;
    }
  }
  
  public final String toString()
  {
    return "kv_14004{appId='" + this.appId + '\'' + ", sessionId='" + this.bIB + '\'' + ", scene=" + this.scene + ", sceneNote='" + this.bFv + '\'' + ", preScene=" + this.caB + ", preSceneNote='" + this.caC + '\'' + ", pagePath='" + this.bFw + '\'' + ", usedState=" + this.gXG + ", appState=" + this.bFu + ", referPagePath='" + this.gYT + '\'' + ", isEntrance=" + this.gYY + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.l
 * JD-Core Version:    0.7.0.1
 */