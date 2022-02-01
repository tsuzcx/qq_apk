package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.m.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class k
{
  private static final k qLf;
  public String appId;
  public int appVersion;
  public int apptype;
  public long costTime;
  public long fOa;
  public int fXa;
  public String fXb;
  public int fvc;
  public String fvd;
  public String fve;
  public int nYl;
  public String networkType;
  public AppBrandRuntime nxs;
  public long pSM;
  public int qJF;
  public String qJG;
  private final boolean qLe;
  boolean qLg = false;
  public String qLh;
  public int qLi;
  public String qLj;
  public int qLk;
  public int qLl;
  public String qLm;
  public String qLn;
  public long qLo;
  private final h qaN;
  public int scene;
  public String sessionId;
  
  static
  {
    AppMethodBeat.i(48141);
    qLf = new k(true, null);
    AppMethodBeat.o(48141);
  }
  
  private k(boolean paramBoolean, h paramh)
  {
    this.qLe = paramBoolean;
    this.qaN = paramh;
  }
  
  public static k a(t paramt, String paramString, h paramh)
  {
    AppMethodBeat.i(48136);
    paramh = new k(false, paramh);
    paramh.sessionId = paramString;
    paramString = paramt.Sk().cxf;
    paramh.scene = paramString.scene;
    paramh.fvd = paramString.fvd;
    paramh.appId = paramt.mAppId;
    paramh.nxs = paramt;
    paramh.fvc = (paramt.bDy().cBI + 1);
    paramh.appVersion = paramt.bDy().appVersion;
    paramh.qJF = paramString.qJF;
    paramh.fXa = paramString.fXa;
    paramh.fXb = paramString.fXb;
    AppMethodBeat.o(48136);
    return paramh;
  }
  
  public static k chX()
  {
    return qLf;
  }
  
  final void report()
  {
    AppMethodBeat.i(48140);
    if (this.qLe)
    {
      AppMethodBeat.o(48140);
      return;
    }
    k.1 local1 = new k.1(this, new Object[] { Integer.valueOf(this.scene), this.fvd, this.sessionId, this.appId, Integer.valueOf(this.appVersion), Integer.valueOf(this.fvc), Integer.valueOf(this.qJF), this.fve, this.networkType, Long.valueOf(this.costTime), Long.valueOf(this.fOa), this.qLh, Integer.valueOf(this.qLi), this.qLj, Long.valueOf(this.pSM), Integer.valueOf(this.qLk), Integer.valueOf(this.fXa), this.fXb, Integer.valueOf(this.qLl), this.qLm, Integer.valueOf(this.apptype), Integer.valueOf(this.nYl), this.qLn, this.qJG, Long.valueOf(this.qLo) });
    if (this.qLg)
    {
      local1.run();
      try
      {
        KVCommCrossProcessReceiver.fBy();
        AppMethodBeat.o(48140);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.AppBrand.Report.kv_13536", localException, "sendKV", new Object[0]);
        AppMethodBeat.o(48140);
        return;
      }
    }
    com.tencent.mm.plugin.appbrand.utils.h.clV().postToWorker(localException);
    AppMethodBeat.o(48140);
  }
  
  public final void t(ah paramah)
  {
    AppMethodBeat.i(48137);
    u(paramah);
    report();
    AppMethodBeat.o(48137);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(48139);
    String str = "kv_13536{scene=" + this.scene + ", sceneNote='" + this.fvd + '\'' + ", sessionId='" + this.sessionId + '\'' + ", appId='" + this.appId + '\'' + ", appVersion=" + this.appVersion + ", appState=" + this.fvc + ", usedState=" + this.qJF + ", pagePath='" + this.fve + '\'' + ", networkType='" + this.networkType + '\'' + ", costTime=" + this.costTime + ", stayTime=" + this.fOa + ", referPagePath='" + this.qLh + '\'' + ", targetAction=" + this.qLi + ", targetPagePath='" + this.qLj + '\'' + ", clickTimestamp=" + this.pSM + ", publicLibVersion=" + this.qLk + ", preScene=" + this.fXa + ", preSceneNote='" + this.fXb + '\'' + ", isEntrance=" + this.qLl + ", apptype=" + this.apptype + ", systemRecentsReason=" + this.nYl + ", referAction=" + this.qLn + ", manufacturerAppId=" + this.qJG + ", stayTimeFuncPageStart=" + this.qLo + '}';
    AppMethodBeat.o(48139);
    return str;
  }
  
  final void u(ah paramah)
  {
    Object localObject3 = null;
    AppMethodBeat.i(48138);
    Object localObject1 = paramah.getRuntime().bDx();
    if (localObject1 != null) {
      this.appVersion = ((l)localObject1).nYR.pkgVersion;
    }
    localObject1 = paramah.bBP();
    if (localObject1 != null) {
      this.qLk = ((ICommLibReader)localObject1).bGi();
    }
    this.pSM = paramah.qtk.qKE;
    this.costTime = paramah.qtk.chN();
    this.fOa = paramah.qtk.chO();
    this.qLo = paramah.qtk.chC();
    label125:
    label254:
    Object localObject2;
    label259:
    int i;
    if (paramah.getRuntime().Qv()) {
      if (paramah.qtk.qJo == null)
      {
        localObject1 = paramah.oxe;
        this.fve = ((String)localObject1);
        this.qLm = paramah.qoI;
        this.networkType = j.getNetworkType(MMApplicationContext.getContext());
        this.qJF = paramah.getRuntime().Sk().cxf.qJF;
        localObject1 = this.qaN.q(paramah);
        if (localObject1 != null) {
          break label472;
        }
        if ((paramah.getRuntime() == null) || (!paramah.getRuntime().aol)) {
          break label445;
        }
        localObject1 = com.tencent.mm.plugin.appbrand.k.abM(paramah.getAppId());
        Log.i("MicroMsg.AppBrand.Report.kv_13536", "visitNode (%s) not found, runtime.isFinishing=TRUE, pauseType=%s, maybe closed by user in LoadingSplash", new Object[] { paramah.qoI, localObject1 });
        switch (2.nLM[localObject1.ordinal()])
        {
        default: 
          localObject1 = null;
          localObject2 = localObject1;
          localObject1 = null;
          if (localObject2 == null)
          {
            i = 0;
            label266:
            this.qLi = i;
            if (localObject2 != null) {
              break label495;
            }
            localObject2 = null;
            label279:
            this.qLj = ((String)localObject2);
            if (localObject1 != null) {
              break label505;
            }
            localObject1 = null;
            label291:
            this.qLh = ((String)localObject1);
            if (!this.qaN.amH(this.qLm)) {
              break label513;
            }
            i = 1;
            label314:
            this.qLl = i;
            localObject1 = paramah.getRuntime();
            if (localObject1 != null) {
              break label518;
            }
            localObject1 = localObject3;
            label331:
            if (localObject1 == null) {
              break label526;
            }
            this.apptype = ((AppBrandInitConfigWC)localObject1).cwR;
          }
          break;
        }
      }
    }
    for (;;)
    {
      this.apptype += 1000;
      this.nYl = paramah.getRuntime().bDy().nYl;
      paramah = s.abV(paramah.getAppId()).nwj;
      if (!Util.isNullOrNil(paramah)) {
        this.qLn = paramah;
      }
      AppMethodBeat.o(48138);
      return;
      localObject1 = paramah.qtk.qJo;
      break;
      this.fve = paramah.oxe;
      break label125;
      localObject1 = new h.c(4);
      break label254;
      localObject1 = new h.c(5);
      break label254;
      label445:
      Log.e("MicroMsg.AppBrand.Report.kv_13536", "visitNode (%s) not found, maybe page switching to quickly", new Object[] { paramah.qoI });
      localObject2 = null;
      localObject1 = null;
      break label259;
      label472:
      localObject2 = ((h.a)localObject1).qKT;
      localObject1 = ((h.a)localObject1).qKU;
      break label259;
      i = ((h.c)localObject2).type;
      break label266;
      label495:
      localObject2 = ((h.c)localObject2).path;
      break label279;
      label505:
      localObject1 = ((h.b)localObject1).path;
      break label291;
      label513:
      i = 0;
      break label314;
      label518:
      localObject1 = ((t)localObject1).bDy();
      break label331;
      label526:
      this.apptype = com.tencent.mm.plugin.appbrand.report.k.amD(this.appId);
      Log.i("MicroMsg.AppBrand.Report.kv_13536", "prepareCommonFields null = initConfig! apptype:%s", new Object[] { Integer.valueOf(this.apptype) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.k
 * JD-Core Version:    0.7.0.1
 */