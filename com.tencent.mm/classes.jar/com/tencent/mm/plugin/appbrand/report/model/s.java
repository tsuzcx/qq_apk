package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.r;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.af.o.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.n;
import com.tencent.mm.plugin.appbrand.jsapi.webview.g.c;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.appbrand.report.k;
import com.tencent.mm.plugin.appbrand.utils.l;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.LinkedList;

public final class s
{
  private static final s tQW;
  public String appId;
  public int appVersion;
  public int apptype;
  public int hzw;
  public String hzx;
  public String hzy;
  public int icZ;
  public String ida;
  public String networkType;
  public w qts;
  public String sML;
  public long sXL;
  public int scene;
  public String sessionId;
  public int tOj;
  private final boolean tPL;
  boolean tPN;
  public String tPO;
  public int tPP;
  public String tPQ;
  public int tPR;
  public int tPS;
  public String tPT;
  private String tQX;
  final LinkedList<String> tQY;
  public boolean tQZ;
  
  static
  {
    AppMethodBeat.i(48183);
    tQW = new s(true);
    AppMethodBeat.o(48183);
  }
  
  private s(boolean paramBoolean)
  {
    AppMethodBeat.i(48175);
    this.tQX = "";
    this.tQY = new LinkedList();
    this.tPN = false;
    this.tQZ = true;
    this.tPL = paramBoolean;
    AppMethodBeat.o(48175);
  }
  
  public static s a(w paramw, String paramString, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(48176);
    s locals = new s(false);
    locals.sessionId = paramString;
    paramString = paramw.asA().epn;
    locals.scene = paramString.scene;
    locals.hzx = paramString.hzx;
    locals.appId = paramw.mAppId;
    locals.qts = paramw;
    if (paramw.ccM() == null) {
      locals.hzw = (paramw.qsh.eul + 1);
    }
    for (locals.appVersion = paramw.getInitConfig().appVersion;; locals.appVersion = paramw.ccM().qYY.pkgVersion)
    {
      locals.tOj = paramString.tOj;
      locals.icZ = paramString.icZ;
      locals.ida = paramString.ida;
      locals.tQY.addAll(paramLinkedList);
      AppMethodBeat.o(48176);
      return locals;
      locals.hzw = (paramw.ccM().qYY.qHO + 1);
    }
  }
  
  private void b(ah paramah, g.c paramc)
  {
    AppMethodBeat.i(321506);
    Object localObject = paramah.getRuntime().ccM();
    if (localObject != null) {
      this.appVersion = ((n)localObject).qYY.pkgVersion;
    }
    localObject = paramah.cbl();
    if (localObject != null) {
      this.tPR = ((ICommLibReader)localObject).cfG();
    }
    this.sXL = System.currentTimeMillis();
    localObject = paramc.getWebView().getUrl();
    paramc = (g.c)localObject;
    if (localObject == null) {
      paramc = "";
    }
    this.sML = r.cg(paramc);
    this.hzy = paramah.cgR();
    this.tPT = paramah.cEE();
    this.networkType = j.getNetworkType(MMApplicationContext.getContext());
    int i;
    if (this.tQZ)
    {
      i = 1;
      this.tPS = i;
      this.tQZ = false;
      paramah = paramah.getRuntime();
      if (paramah != null) {
        break label181;
      }
      paramah = null;
      label146:
      if (paramah == null) {
        break label189;
      }
      this.apptype = paramah.appServiceType;
    }
    for (;;)
    {
      this.apptype += 1000;
      AppMethodBeat.o(321506);
      return;
      i = 0;
      break;
      label181:
      paramah = paramah.getInitConfig();
      break label146;
      label189:
      this.apptype = k.afP(this.appId);
      Log.i("MicroMsg.AppBrand.Report.kv_14992", "prepareCommonFields null = initConfig! apptype:%s", new Object[] { Integer.valueOf(this.apptype) });
    }
  }
  
  public static s cIY()
  {
    return tQW;
  }
  
  private void report()
  {
    AppMethodBeat.i(48182);
    if (this.tPL)
    {
      AppMethodBeat.o(48182);
      return;
    }
    Log.i("MicroMsg.AppBrand.Report.kv_14992", "report " + toString());
    s.1 local1 = new s.1(this, new Object[] { Integer.valueOf(this.scene), this.hzx, this.sessionId, this.appId, Integer.valueOf(this.appVersion), Integer.valueOf(this.hzw), Integer.valueOf(this.tOj), this.hzy, this.sML, this.networkType, this.tPO, Integer.valueOf(this.tPP), this.tPQ, Long.valueOf(this.sXL), Integer.valueOf(this.tPR), Integer.valueOf(this.icZ), this.ida, Integer.valueOf(this.tPS), this.tPT, Integer.valueOf(this.apptype) });
    if (this.tPN)
    {
      local1.run();
      try
      {
        KVCommCrossProcessReceiver.gNR();
        AppMethodBeat.o(48182);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.AppBrand.Report.kv_14992", localException, "sendKV", new Object[0]);
        AppMethodBeat.o(48182);
        return;
      }
    }
    l.cNm().postToWorker(localException);
    AppMethodBeat.o(48182);
  }
  
  public final void a(ah paramah, String paramString1, String paramString2)
  {
    AppMethodBeat.i(321519);
    this.tPO = ((String)this.tQY.peekFirst());
    this.tPP = 2;
    this.tPQ = paramString2;
    this.tQY.push(paramString1);
    y(paramah);
    AppMethodBeat.o(321519);
  }
  
  public final void a(ah paramah, boolean paramBoolean)
  {
    AppMethodBeat.i(48178);
    if (paramBoolean) {}
    for (int i = 1;; i = 7)
    {
      this.tPP = i;
      String str = (String)this.tQY.pollFirst();
      this.tPQ = str;
      this.tPO = str;
      if (!paramBoolean) {
        this.tPQ = this.tQX;
      }
      y(paramah);
      AppMethodBeat.o(48178);
      return;
    }
  }
  
  public final void b(ah paramah, String paramString)
  {
    AppMethodBeat.i(48177);
    this.tPO = ((String)this.tQY.peekFirst());
    this.tPP = 2;
    this.tPQ = paramString;
    this.tQY.push(paramah.cgR());
    this.tQX = paramah.cgR();
    y(paramah);
    AppMethodBeat.o(48177);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(48181);
    String str = "kv_4992{scene=" + this.scene + ", sceneNote='" + this.hzx + '\'' + ", sessionId='" + this.sessionId + '\'' + ", appId='" + this.appId + '\'' + ", appVersion=" + this.appVersion + ", appState=" + this.hzw + ", usedState=" + this.tOj + ", pagePath='" + this.hzy + '\'' + ", currentUrl='" + this.sML + '\'' + ", networkType='" + this.networkType + '\'' + ", referPagePath='" + this.tPO + '\'' + ", targetAction=" + this.tPP + ", targetPagePath='" + this.tPQ + '\'' + ", clickTimestamp=" + this.sXL + ", publicLibVersion=" + this.tPR + ", preScene=" + this.icZ + ", preSceneNote='" + this.ida + '\'' + ", isEntrance=" + this.tPS + ", apptype=" + this.apptype + '}';
    AppMethodBeat.o(48181);
    return str;
  }
  
  final void y(ah paramah)
  {
    AppMethodBeat.i(48179);
    g.c localc = paramah.cFg();
    if (localc == null)
    {
      AppMethodBeat.o(48179);
      return;
    }
    b(paramah, localc);
    report();
    AppMethodBeat.o(48179);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.s
 * JD-Core Version:    0.7.0.1
 */