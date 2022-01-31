package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.t.a;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.page.s;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.d;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.LinkedList;

public final class o
{
  private static final o gZL = new o(true);
  public String appId;
  public int apptype;
  public int bFu;
  public String bFv;
  public String bFw;
  public String bIB;
  public int caB;
  public String caC;
  public int cau;
  public n fzW;
  public int gXG;
  private final boolean gYN;
  boolean gYQ = false;
  public String gYR;
  public String gYT;
  public int gYU;
  public String gYV;
  public long gYW;
  public int gYX;
  public int gYY;
  public String gYZ;
  String gZM = "";
  public final LinkedList<String> gZN = new LinkedList();
  public String gZO;
  public boolean gZP = true;
  public int scene;
  
  private o(boolean paramBoolean)
  {
    this.gYN = paramBoolean;
  }
  
  public static o a(n paramn, String paramString, LinkedList<String> paramLinkedList)
  {
    o localo = new o(false);
    localo.bIB = paramString;
    paramString = paramn.aab();
    localo.scene = paramString.scene;
    localo.bFv = paramString.bFv;
    localo.appId = paramn.mAppId;
    localo.fzW = paramn;
    localo.bFu = (paramn.aaa().fPS.fEM + 1);
    localo.cau = paramn.aaa().fPS.fEN;
    localo.gXG = paramString.gXG;
    localo.caB = paramString.caB;
    localo.caC = paramString.caC;
    localo.gZN.addAll(paramLinkedList);
    return localo;
  }
  
  public static o aou()
  {
    return gZL;
  }
  
  public final void a(s params, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 7)
    {
      this.gYU = i;
      String str = (String)this.gZN.pollFirst();
      this.gYV = str;
      this.gYT = str;
      if (!paramBoolean) {
        this.gYV = this.gZM;
      }
      k(params);
      return;
    }
  }
  
  public final void k(s params)
  {
    Object localObject1 = params.ans();
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = params.getRuntime().ZB();
    if (localObject2 != null)
    {
      this.cau = ((com.tencent.mm.plugin.appbrand.config.i)localObject2).fPS.fEN;
      this.gYX = WxaCommLibRuntimeReader.abQ().fEN;
    }
    this.gYW = System.currentTimeMillis();
    localObject2 = ((a)localObject1).getWebView().getUrl();
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.gZO = com.tencent.mm.compatible.util.q.encode((String)localObject1);
    this.bFw = params.getURL();
    this.gYZ = params.ahc();
    this.gYR = com.tencent.mm.plugin.appbrand.report.c.cv(ae.getContext());
    int i;
    if (this.gZP)
    {
      i = 1;
      label116:
      this.gYY = i;
      this.gZP = false;
      params = params.getRuntime();
      if (params != null) {
        break label427;
      }
      params = null;
      label137:
      if (params == null) {
        break label435;
      }
      this.apptype = params.bFB;
    }
    for (;;)
    {
      this.apptype += 1000;
      if (this.gYN) {
        break;
      }
      y.i("MicroMsg.AppBrand.Report.kv_14992", "report " + toString());
      params = new o.1(this, new Object[] { Integer.valueOf(this.scene), this.bFv, this.bIB, this.appId, Integer.valueOf(this.cau), Integer.valueOf(this.bFu), Integer.valueOf(this.gXG), this.bFw, this.gZO, this.gYR, this.gYT, Integer.valueOf(this.gYU), this.gYV, Long.valueOf(this.gYW), Integer.valueOf(this.gYX), Integer.valueOf(this.caB), this.caC, Integer.valueOf(this.gYY), this.gYZ, Integer.valueOf(this.apptype) });
      if (!this.gYQ) {
        break label471;
      }
      params.run();
      try
      {
        KVCommCrossProcessReceiver.bwU();
        return;
      }
      catch (Exception params)
      {
        y.printErrStackTrace("MicroMsg.AppBrand.Report.kv_14992", params, "sendKV", new Object[0]);
        return;
      }
      i = 0;
      break label116;
      label427:
      params = params.ZA();
      break label137;
      label435:
      this.apptype = d.vZ(this.appId);
      y.i("MicroMsg.AppBrand.Report.kv_14992", "prepareCommonFields null = initConfig! apptype:%s", new Object[] { Integer.valueOf(this.apptype) });
    }
    label471:
    com.tencent.mm.plugin.appbrand.v.c.DS().O(params);
  }
  
  public final String toString()
  {
    return "kv_4992{scene=" + this.scene + ", sceneNote='" + this.bFv + '\'' + ", sessionId='" + this.bIB + '\'' + ", appId='" + this.appId + '\'' + ", appVersion=" + this.cau + ", appState=" + this.bFu + ", usedState=" + this.gXG + ", pagePath='" + this.bFw + '\'' + ", currentUrl='" + this.gZO + '\'' + ", networkType='" + this.gYR + '\'' + ", referPagePath='" + this.gYT + '\'' + ", targetAction=" + this.gYU + ", targetPagePath='" + this.gYV + '\'' + ", clickTimestamp=" + this.gYW + ", publicLibVersion=" + this.gYX + ", preScene=" + this.caB + ", preSceneNote='" + this.caC + '\'' + ", isEntrance=" + this.gYY + ", apptype=" + this.apptype + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.o
 * JD-Core Version:    0.7.0.1
 */