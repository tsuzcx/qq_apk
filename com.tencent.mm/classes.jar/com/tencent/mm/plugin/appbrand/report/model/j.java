package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.page.s;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.d;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class j
{
  private static final j gYO = new j(true, null);
  public String appId;
  public int apptype;
  public int bFu;
  public String bFv;
  public String bFw;
  public String bIB;
  public int caB;
  public String caC;
  public int cau;
  public com.tencent.mm.plugin.appbrand.i fzT;
  public int gXG;
  public long gYL;
  private final boolean gYN;
  private final h gYP;
  boolean gYQ = false;
  public String gYR;
  public long gYS;
  public String gYT;
  public int gYU;
  public String gYV;
  public long gYW;
  public int gYX;
  public int gYY;
  public String gYZ;
  public int scene;
  
  private j(boolean paramBoolean, h paramh)
  {
    this.gYN = paramBoolean;
    this.gYP = paramh;
  }
  
  public static j a(n paramn, String paramString, h paramh)
  {
    paramh = new j(false, paramh);
    paramh.bIB = paramString;
    paramString = paramn.aab();
    paramh.scene = paramString.scene;
    paramh.bFv = paramString.bFv;
    paramh.appId = paramn.mAppId;
    paramh.fzT = paramn;
    paramh.bFu = (paramn.aaa().fPS.fEM + 1);
    paramh.cau = paramn.aaa().fPS.fEN;
    paramh.gXG = paramString.gXG;
    paramh.caB = paramString.caB;
    paramh.caC = paramString.caC;
    return paramh;
  }
  
  public static j aor()
  {
    return gYO;
  }
  
  final void i(s params)
  {
    Object localObject = params.getRuntime().aaa();
    if (localObject != null)
    {
      this.cau = ((com.tencent.mm.plugin.appbrand.config.i)localObject).fPS.fEN;
      this.gYX = WxaCommLibRuntimeReader.abQ().fEN;
    }
    this.gYW = params.gUj.gYk;
    this.gYL = Math.max(0L, params.gUj.gYl);
    localObject = params.gUj;
    long l1 = ((c)localObject).gYi.gXN;
    long l2 = ((c)localObject).gYk;
    long l3 = ((c)localObject).gYl;
    label243:
    int i;
    if (l1 <= 0L)
    {
      y.i("MicroMsg.AppBrandPageViewStatistics", "foregroundMs invalid(%d), loadStart %d, loadCost %d, [%s/%s]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), ((c)localObject).mAppId, ((c)localObject).gYj });
      if ((l2 > 0L) && (l3 > 0L) && (l1 == 0L))
      {
        l1 = bk.UY() - l2;
        this.gYS = l1;
        this.bFw = params.getURL();
        this.gYZ = params.ahc();
        this.gYR = com.tencent.mm.plugin.appbrand.report.c.cv(ae.getContext());
        localObject = this.gYP.g(params);
        if (localObject != null) {
          break label337;
        }
        y.e("MicroMsg.AppBrand.Report.kv_13536", "visitNode (%s) not found, maybe page switching to quickly", new Object[] { params.ahc() });
        localObject = null;
        if (localObject != null) {
          break label347;
        }
        i = 0;
        label250:
        this.gYU = i;
        if (localObject != null) {
          break label356;
        }
        localObject = null;
        label263:
        this.gYV = ((String)localObject);
        if (!this.gYP.wd(this.gYZ)) {
          break label366;
        }
        i = 1;
        label287:
        this.gYY = i;
        params = params.getRuntime();
        if (params != null) {
          break label371;
        }
        params = null;
        label303:
        if (params == null) {
          break label379;
        }
        this.apptype = params.bFB;
      }
    }
    for (;;)
    {
      this.apptype += 1000;
      return;
      l1 = Math.max(0L, l1);
      break;
      label337:
      localObject = ((h.a)localObject).gYB;
      break label243;
      label347:
      i = ((h.c)localObject).type;
      break label250;
      label356:
      localObject = ((h.c)localObject).path;
      break label263;
      label366:
      i = 0;
      break label287;
      label371:
      params = params.ZA();
      break label303;
      label379:
      this.apptype = d.vZ(this.appId);
      y.i("MicroMsg.AppBrand.Report.kv_13536", "prepareCommonFields null = initConfig! apptype:%s", new Object[] { Integer.valueOf(this.apptype) });
    }
  }
  
  public final String toString()
  {
    return "kv_13536{scene=" + this.scene + ", sceneNote='" + this.bFv + '\'' + ", sessionId='" + this.bIB + '\'' + ", appId='" + this.appId + '\'' + ", appVersion=" + this.cau + ", appState=" + this.bFu + ", usedState=" + this.gXG + ", pagePath='" + this.bFw + '\'' + ", networkType='" + this.gYR + '\'' + ", costTime=" + this.gYL + ", stayTime=" + this.gYS + ", referPagePath='" + this.gYT + '\'' + ", targetAction=" + this.gYU + ", targetPagePath='" + this.gYV + '\'' + ", clickTimestamp=" + this.gYW + ", publicLibVersion=" + this.gYX + ", preScene=" + this.caB + ", preSceneNote='" + this.caC + '\'' + ", isEntrance=" + this.gYY + ", apptype=" + this.apptype + '}';
  }
  
  final void wn()
  {
    if (this.gYN) {
      return;
    }
    y.i("MicroMsg.AppBrand.Report.kv_13536", "report " + toString());
    j.1 local1 = new j.1(this, new Object[] { Integer.valueOf(this.scene), this.bFv, this.bIB, this.appId, Integer.valueOf(this.cau), Integer.valueOf(this.bFu), Integer.valueOf(this.gXG), this.bFw, this.gYR, Long.valueOf(this.gYL), Long.valueOf(this.gYS), this.gYT, Integer.valueOf(this.gYU), this.gYV, Long.valueOf(this.gYW), Integer.valueOf(this.gYX), Integer.valueOf(this.caB), this.caC, Integer.valueOf(this.gYY), this.gYZ, Integer.valueOf(this.apptype) });
    if (this.gYQ)
    {
      local1.run();
      try
      {
        KVCommCrossProcessReceiver.bwU();
        return;
      }
      catch (Exception localException)
      {
        y.printErrStackTrace("MicroMsg.AppBrand.Report.kv_13536", localException, "sendKV", new Object[0]);
        return;
      }
    }
    com.tencent.mm.plugin.appbrand.v.c.DS().O(localException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.j
 * JD-Core Version:    0.7.0.1
 */