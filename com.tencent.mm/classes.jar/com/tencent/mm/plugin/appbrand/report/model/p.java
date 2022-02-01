package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.m.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.jsapi.webview.g.c;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.appbrand.report.k;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.appbrand.utils.h;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.LinkedList;

public final class p
{
  private static final p qMm;
  public String appId;
  public int appVersion;
  public int apptype;
  public int fXa;
  public String fXb;
  public int fvc;
  public String fvd;
  public String fve;
  public String networkType;
  public t nuJ;
  public String pHO;
  public long pSM;
  public int qJF;
  private final boolean qLe;
  boolean qLg;
  public String qLh;
  public int qLi;
  public String qLj;
  public int qLk;
  public int qLl;
  public String qLm;
  private String qMn;
  final LinkedList<String> qMo;
  public boolean qMp;
  public int scene;
  public String sessionId;
  
  static
  {
    AppMethodBeat.i(48183);
    qMm = new p(true);
    AppMethodBeat.o(48183);
  }
  
  private p(boolean paramBoolean)
  {
    AppMethodBeat.i(48175);
    this.qMn = "";
    this.qMo = new LinkedList();
    this.qLg = false;
    this.qMp = true;
    this.qLe = paramBoolean;
    AppMethodBeat.o(48175);
  }
  
  public static p a(t paramt, String paramString, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(48176);
    p localp = new p(false);
    localp.sessionId = paramString;
    paramString = paramt.Sk().cxf;
    localp.scene = paramString.scene;
    localp.fvd = paramString.fvd;
    localp.appId = paramt.mAppId;
    localp.nuJ = paramt;
    if (paramt.bDx() == null) {
      localp.fvc = (paramt.ntz.cBI + 1);
    }
    for (localp.appVersion = paramt.bDy().appVersion;; localp.appVersion = paramt.bDx().nYR.pkgVersion)
    {
      localp.qJF = paramString.qJF;
      localp.fXa = paramString.fXa;
      localp.fXb = paramString.fXb;
      localp.qMo.addAll(paramLinkedList);
      AppMethodBeat.o(48176);
      return localp;
      localp.fvc = (paramt.bDx().nYR.nHY + 1);
    }
  }
  
  private void b(ah paramah, g.c paramc)
  {
    AppMethodBeat.i(266830);
    Object localObject = paramah.getRuntime().bDx();
    if (localObject != null) {
      this.appVersion = ((l)localObject).nYR.pkgVersion;
    }
    localObject = paramah.bBP();
    if (localObject != null) {
      this.qLk = ((ICommLibReader)localObject).bGi();
    }
    this.pSM = System.currentTimeMillis();
    localObject = paramc.getWebView().getUrl();
    paramc = (g.c)localObject;
    if (localObject == null) {
      paramc = "";
    }
    this.pHO = q.aT(paramc);
    this.fve = paramah.oxe;
    this.qLm = paramah.qoI;
    this.networkType = j.getNetworkType(MMApplicationContext.getContext());
    int i;
    if (this.qMp)
    {
      i = 1;
      this.qLl = i;
      this.qMp = false;
      paramah = paramah.getRuntime();
      if (paramah != null) {
        break label181;
      }
      paramah = null;
      label146:
      if (paramah == null) {
        break label189;
      }
      this.apptype = paramah.cwR;
    }
    for (;;)
    {
      this.apptype += 1000;
      AppMethodBeat.o(266830);
      return;
      i = 0;
      break;
      label181:
      paramah = paramah.bDy();
      break label146;
      label189:
      this.apptype = k.amD(this.appId);
      Log.i("MicroMsg.AppBrand.Report.kv_14992", "prepareCommonFields null = initConfig! apptype:%s", new Object[] { Integer.valueOf(this.apptype) });
    }
  }
  
  public static p cih()
  {
    return qMm;
  }
  
  private void report()
  {
    AppMethodBeat.i(48182);
    if (this.qLe)
    {
      AppMethodBeat.o(48182);
      return;
    }
    Log.i("MicroMsg.AppBrand.Report.kv_14992", "report " + toString());
    p.1 local1 = new p.1(this, new Object[] { Integer.valueOf(this.scene), this.fvd, this.sessionId, this.appId, Integer.valueOf(this.appVersion), Integer.valueOf(this.fvc), Integer.valueOf(this.qJF), this.fve, this.pHO, this.networkType, this.qLh, Integer.valueOf(this.qLi), this.qLj, Long.valueOf(this.pSM), Integer.valueOf(this.qLk), Integer.valueOf(this.fXa), this.fXb, Integer.valueOf(this.qLl), this.qLm, Integer.valueOf(this.apptype) });
    if (this.qLg)
    {
      local1.run();
      try
      {
        KVCommCrossProcessReceiver.fBy();
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
    h.clV().postToWorker(localException);
    AppMethodBeat.o(48182);
  }
  
  public final void a(ah paramah, String paramString)
  {
    AppMethodBeat.i(48177);
    this.qLh = ((String)this.qMo.peekFirst());
    this.qLi = 2;
    this.qLj = paramString;
    this.qMo.push(paramah.oxe);
    this.qMn = paramah.oxe;
    w(paramah);
    AppMethodBeat.o(48177);
  }
  
  public final void a(ah paramah, String paramString1, String paramString2)
  {
    AppMethodBeat.i(266828);
    this.qLh = ((String)this.qMo.peekFirst());
    this.qLi = 2;
    this.qLj = paramString2;
    this.qMo.push(paramString1);
    w(paramah);
    AppMethodBeat.o(266828);
  }
  
  public final void a(ah paramah, boolean paramBoolean)
  {
    AppMethodBeat.i(48178);
    if (paramBoolean) {}
    for (int i = 1;; i = 7)
    {
      this.qLi = i;
      String str = (String)this.qMo.pollFirst();
      this.qLj = str;
      this.qLh = str;
      if (!paramBoolean) {
        this.qLj = this.qMn;
      }
      w(paramah);
      AppMethodBeat.o(48178);
      return;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(48181);
    String str = "kv_4992{scene=" + this.scene + ", sceneNote='" + this.fvd + '\'' + ", sessionId='" + this.sessionId + '\'' + ", appId='" + this.appId + '\'' + ", appVersion=" + this.appVersion + ", appState=" + this.fvc + ", usedState=" + this.qJF + ", pagePath='" + this.fve + '\'' + ", currentUrl='" + this.pHO + '\'' + ", networkType='" + this.networkType + '\'' + ", referPagePath='" + this.qLh + '\'' + ", targetAction=" + this.qLi + ", targetPagePath='" + this.qLj + '\'' + ", clickTimestamp=" + this.pSM + ", publicLibVersion=" + this.qLk + ", preScene=" + this.fXa + ", preSceneNote='" + this.fXb + '\'' + ", isEntrance=" + this.qLl + ", apptype=" + this.apptype + '}';
    AppMethodBeat.o(48181);
    return str;
  }
  
  final void w(ah paramah)
  {
    AppMethodBeat.i(48179);
    g.c localc = paramah.ceE();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.p
 * JD-Core Version:    0.7.0.1
 */