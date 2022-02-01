package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.af.o.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.u;
import com.tencent.mm.plugin.appbrand.utils.l;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class n
{
  private static final n tPM;
  public String appId;
  public int appVersion;
  public int apptype;
  public long costTime;
  public long hTS;
  public int hzw;
  public String hzx;
  public String hzy;
  public int icZ;
  public String ida;
  public String networkType;
  public int qYn;
  public AppBrandRuntime qwG;
  public long sXL;
  public int scene;
  public String sessionId;
  public int tOj;
  public String tOk;
  private final boolean tPL;
  boolean tPN = false;
  public String tPO;
  public int tPP;
  public String tPQ;
  public int tPR;
  public int tPS;
  public String tPT;
  public String tPU;
  public long tPV;
  private final j tfT;
  
  static
  {
    AppMethodBeat.i(48141);
    tPM = new n(true, null);
    AppMethodBeat.o(48141);
  }
  
  private n(boolean paramBoolean, j paramj)
  {
    this.tPL = paramBoolean;
    this.tfT = paramj;
  }
  
  public static n a(w paramw, String paramString, j paramj)
  {
    AppMethodBeat.i(48136);
    paramj = new n(false, paramj);
    paramj.sessionId = paramString;
    paramString = paramw.asA().epn;
    paramj.scene = paramString.scene;
    paramj.hzx = paramString.hzx;
    paramj.appId = paramw.mAppId;
    paramj.qwG = paramw;
    paramj.hzw = (paramw.getInitConfig().eul + 1);
    paramj.appVersion = paramw.getInitConfig().appVersion;
    paramj.tOj = paramString.tOj;
    paramj.icZ = paramString.icZ;
    paramj.ida = paramString.ida;
    AppMethodBeat.o(48136);
    return paramj;
  }
  
  public static n cIU()
  {
    return tPM;
  }
  
  final void report()
  {
    AppMethodBeat.i(48140);
    if (this.tPL)
    {
      AppMethodBeat.o(48140);
      return;
    }
    n.1 local1 = new n.1(this, new Object[] { Integer.valueOf(this.scene), this.hzx, this.sessionId, this.appId, Integer.valueOf(this.appVersion), Integer.valueOf(this.hzw), Integer.valueOf(this.tOj), this.hzy, this.networkType, Long.valueOf(this.costTime), Long.valueOf(this.hTS), this.tPO, Integer.valueOf(this.tPP), this.tPQ, Long.valueOf(this.sXL), Integer.valueOf(this.tPR), Integer.valueOf(this.icZ), this.ida, Integer.valueOf(this.tPS), this.tPT, Integer.valueOf(this.apptype), Integer.valueOf(this.qYn), this.tPU, this.tOk, Long.valueOf(this.tPV) });
    if (this.tPN)
    {
      local1.run();
      try
      {
        KVCommCrossProcessReceiver.gNR();
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
    l.cNm().postToWorker(localException);
    AppMethodBeat.o(48140);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(48139);
    String str = "kv_13536{scene=" + this.scene + ", sceneNote='" + this.hzx + '\'' + ", sessionId='" + this.sessionId + '\'' + ", appId='" + this.appId + '\'' + ", appVersion=" + this.appVersion + ", appState=" + this.hzw + ", usedState=" + this.tOj + ", pagePath='" + this.hzy + '\'' + ", networkType='" + this.networkType + '\'' + ", costTime=" + this.costTime + ", stayTime=" + this.hTS + ", referPagePath='" + this.tPO + '\'' + ", targetAction=" + this.tPP + ", targetPagePath='" + this.tPQ + '\'' + ", clickTimestamp=" + this.sXL + ", publicLibVersion=" + this.tPR + ", preScene=" + this.icZ + ", preSceneNote='" + this.ida + '\'' + ", isEntrance=" + this.tPS + ", apptype=" + this.apptype + ", systemRecentsReason=" + this.qYn + ", referAction=" + this.tPU + ", manufacturerAppId=" + this.tOk + ", stayTimeFuncPageStart=" + this.tPV + '}';
    AppMethodBeat.o(48139);
    return str;
  }
  
  public final void v(ah paramah)
  {
    AppMethodBeat.i(48137);
    w(paramah);
    report();
    AppMethodBeat.o(48137);
  }
  
  final void w(ah paramah)
  {
    Object localObject3 = null;
    AppMethodBeat.i(48138);
    Object localObject1 = paramah.getRuntime().ccM();
    if (localObject1 != null) {
      this.appVersion = ((com.tencent.mm.plugin.appbrand.config.n)localObject1).qYY.pkgVersion;
    }
    localObject1 = paramah.cbl();
    if (localObject1 != null) {
      this.tPR = ((ICommLibReader)localObject1).cfG();
    }
    this.sXL = paramah.txQ.tPh;
    this.costTime = paramah.txQ.cII();
    this.hTS = paramah.txQ.cIJ();
    this.tPV = paramah.txQ.cIw();
    label125:
    label254:
    Object localObject2;
    label259:
    int i;
    if (paramah.getRuntime().aqJ()) {
      if (paramah.txQ.tNR == null)
      {
        localObject1 = paramah.cgR();
        this.hzy = ((String)localObject1);
        this.tPT = paramah.cEE();
        this.networkType = com.tencent.mm.plugin.appbrand.report.j.getNetworkType(MMApplicationContext.getContext());
        this.tOj = paramah.getRuntime().asA().epn.tOj;
        localObject1 = this.tfT.s(paramah);
        if (localObject1 != null) {
          break label472;
        }
        if ((paramah.getRuntime() == null) || (!paramah.getRuntime().ccV)) {
          break label445;
        }
        localObject1 = com.tencent.mm.plugin.appbrand.k.Uo(paramah.getAppId());
        Log.i("MicroMsg.AppBrand.Report.kv_13536", "visitNode (%s) not found, runtime.isFinishing=TRUE, pauseType=%s, maybe closed by user in LoadingSplash", new Object[] { paramah.cEE(), localObject1 });
        switch (2.qLA[localObject1.ordinal()])
        {
        default: 
          localObject1 = null;
          localObject2 = localObject1;
          localObject1 = null;
          if (localObject2 == null)
          {
            i = 0;
            label266:
            this.tPP = i;
            if (localObject2 != null) {
              break label495;
            }
            localObject2 = null;
            label279:
            this.tPQ = ((String)localObject2);
            if (localObject1 != null) {
              break label505;
            }
            localObject1 = null;
            label291:
            this.tPO = ((String)localObject1);
            if (!this.tfT.afT(this.tPT)) {
              break label513;
            }
            i = 1;
            label314:
            this.tPS = i;
            localObject1 = paramah.getRuntime();
            if (localObject1 != null) {
              break label518;
            }
            localObject1 = localObject3;
            label331:
            if (localObject1 == null) {
              break label526;
            }
            this.apptype = ((AppBrandInitConfigWC)localObject1).appServiceType;
          }
          break;
        }
      }
    }
    for (;;)
    {
      this.apptype += 1000;
      this.qYn = paramah.getRuntime().getInitConfig().qYn;
      paramah = u.Ux(paramah.getAppId()).qvg;
      if (!Util.isNullOrNil(paramah)) {
        this.tPU = paramah;
      }
      AppMethodBeat.o(48138);
      return;
      localObject1 = paramah.txQ.tNR;
      break;
      this.hzy = paramah.cgR();
      break label125;
      localObject1 = new j.c(4);
      break label254;
      localObject1 = new j.c(5);
      break label254;
      label445:
      Log.e("MicroMsg.AppBrand.Report.kv_13536", "visitNode (%s) not found, maybe page switching to quickly", new Object[] { paramah.cEE() });
      localObject2 = null;
      localObject1 = null;
      break label259;
      label472:
      localObject2 = ((j.a)localObject1).tPy;
      localObject1 = ((j.a)localObject1).tPz;
      break label259;
      i = ((j.c)localObject2).type;
      break label266;
      label495:
      localObject2 = ((j.c)localObject2).path;
      break label279;
      label505:
      localObject1 = ((j.b)localObject1).path;
      break label291;
      label513:
      i = 0;
      break label314;
      label518:
      localObject1 = ((w)localObject1).getInitConfig();
      break label331;
      label526:
      this.apptype = com.tencent.mm.plugin.appbrand.report.k.afP(this.appId);
      Log.i("MicroMsg.AppBrand.Report.kv_13536", "prepareCommonFields null = initConfig! apptype:%s", new Object[] { Integer.valueOf(this.apptype) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.n
 * JD-Core Version:    0.7.0.1
 */