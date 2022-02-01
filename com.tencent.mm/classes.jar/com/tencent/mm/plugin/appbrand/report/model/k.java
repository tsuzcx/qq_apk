package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.utils.e;
import com.tencent.mm.plugin.appbrand.z.m.a;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

public final class k
{
  private static final k msT;
  public int aDD;
  public String appId;
  public int apptype;
  public long dBD;
  public int dJQ;
  public String dJR;
  public int dkg;
  public String dkh;
  public String dki;
  public int jXE;
  public AppBrandRuntime jzY;
  public long lFE;
  private final h lOw;
  public int mrx;
  public String mry;
  public long msQ;
  private final boolean msS;
  boolean msU = false;
  public String msV;
  public String msW;
  public int msX;
  public String msY;
  public int msZ;
  public int mta;
  public String mtb;
  public String mtc;
  public long mtd;
  public int scene;
  public String sessionId;
  
  static
  {
    AppMethodBeat.i(48141);
    msT = new k(true, null);
    AppMethodBeat.o(48141);
  }
  
  private k(boolean paramBoolean, h paramh)
  {
    this.msS = paramBoolean;
    this.lOw = paramh;
  }
  
  public static k a(o paramo, String paramString, h paramh)
  {
    AppMethodBeat.i(48136);
    paramh = new k(false, paramh);
    paramh.sessionId = paramString;
    paramString = paramo.Fb().cmC;
    paramh.scene = paramString.scene;
    paramh.dkh = paramString.dkh;
    paramh.appId = paramo.mAppId;
    paramh.jzY = paramo;
    paramh.dkg = (paramo.aXc().dPf + 1);
    paramh.aDD = paramo.aXc().aDD;
    paramh.mrx = paramString.mrx;
    paramh.dJQ = paramString.dJQ;
    paramh.dJR = paramString.dJR;
    AppMethodBeat.o(48136);
    return paramh;
  }
  
  public static k bxB()
  {
    return msT;
  }
  
  final void report()
  {
    AppMethodBeat.i(48140);
    if (this.msS)
    {
      AppMethodBeat.o(48140);
      return;
    }
    k.1 local1 = new k.1(this, new Object[] { Integer.valueOf(this.scene), this.dkh, this.sessionId, this.appId, Integer.valueOf(this.aDD), Integer.valueOf(this.dkg), Integer.valueOf(this.mrx), this.dki, this.msV, Long.valueOf(this.msQ), Long.valueOf(this.dBD), this.msW, Integer.valueOf(this.msX), this.msY, Long.valueOf(this.lFE), Integer.valueOf(this.msZ), Integer.valueOf(this.dJQ), this.dJR, Integer.valueOf(this.mta), this.mtb, Integer.valueOf(this.apptype), Integer.valueOf(this.jXE), this.mtc, this.mry, Long.valueOf(this.mtd) });
    if (this.msU)
    {
      local1.run();
      try
      {
        KVCommCrossProcessReceiver.dKl();
        AppMethodBeat.o(48140);
        return;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.AppBrand.Report.kv_13536", localException, "sendKV", new Object[0]);
        AppMethodBeat.o(48140);
        return;
      }
    }
    e.bBp().postToWorker(localException);
    AppMethodBeat.o(48140);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(48139);
    String str = "kv_13536{scene=" + this.scene + ", sceneNote='" + this.dkh + '\'' + ", sessionId='" + this.sessionId + '\'' + ", appId='" + this.appId + '\'' + ", appVersion=" + this.aDD + ", appState=" + this.dkg + ", usedState=" + this.mrx + ", pagePath='" + this.dki + '\'' + ", networkType='" + this.msV + '\'' + ", costTime=" + this.msQ + ", stayTime=" + this.dBD + ", referPagePath='" + this.msW + '\'' + ", targetAction=" + this.msX + ", targetPagePath='" + this.msY + '\'' + ", clickTimestamp=" + this.lFE + ", publicLibVersion=" + this.msZ + ", preScene=" + this.dJQ + ", preSceneNote='" + this.dJR + '\'' + ", isEntrance=" + this.mta + ", apptype=" + this.apptype + ", systemRecentsReason=" + this.jXE + ", referAction=" + this.mtc + ", manufacturerAppId=" + this.mry + ", stayTimeFuncPageStart=" + this.mtd + '}';
    AppMethodBeat.o(48139);
    return str;
  }
  
  public final void u(ae paramae)
  {
    AppMethodBeat.i(48137);
    v(paramae);
    report();
    AppMethodBeat.o(48137);
  }
  
  final void v(ae paramae)
  {
    Object localObject3 = null;
    AppMethodBeat.i(48138);
    Object localObject1 = paramae.getRuntime().aXb();
    if (localObject1 != null) {
      this.aDD = ((com.tencent.mm.plugin.appbrand.config.k)localObject1).jYh.pkgVersion;
    }
    localObject1 = paramae.aVF();
    if (localObject1 != null) {
      this.msZ = ((ICommLibReader)localObject1).aZp();
    }
    this.lFE = paramae.mcx.msr;
    this.msQ = paramae.mcx.bxs();
    this.dBD = paramae.mcx.bxt();
    this.mtd = paramae.mcx.bxi();
    label125:
    label254:
    Object localObject2;
    label259:
    int i;
    if (paramae.getRuntime().Eb()) {
      if (paramae.mcx.mrg == null)
      {
        localObject1 = paramae.kuf;
        this.dki = ((String)localObject1);
        this.mtb = paramae.lYf;
        this.msV = com.tencent.mm.plugin.appbrand.report.h.getNetworkType(aj.getContext());
        this.mrx = paramae.getRuntime().Fb().cmC.mrx;
        localObject1 = this.lOw.r(paramae);
        if (localObject1 != null) {
          break label472;
        }
        if ((paramae.getRuntime() == null) || (!paramae.getRuntime().SB)) {
          break label445;
        }
        localObject1 = com.tencent.mm.plugin.appbrand.g.Kv(paramae.getAppId());
        ad.i("MicroMsg.AppBrand.Report.kv_13536", "visitNode (%s) not found, runtime.isFinishing=TRUE, pauseType=%s, maybe closed by user in LoadingSplash", new Object[] { paramae.lYf, localObject1 });
        switch (k.2.jLK[localObject1.ordinal()])
        {
        default: 
          localObject1 = null;
          localObject2 = localObject1;
          localObject1 = null;
          if (localObject2 == null)
          {
            i = 0;
            label266:
            this.msX = i;
            if (localObject2 != null) {
              break label495;
            }
            localObject2 = null;
            label279:
            this.msY = ((String)localObject2);
            if (localObject1 != null) {
              break label505;
            }
            localObject1 = null;
            label291:
            this.msW = ((String)localObject1);
            if (!this.lOw.Un(this.mtb)) {
              break label513;
            }
            i = 1;
            label314:
            this.mta = i;
            localObject1 = paramae.getRuntime();
            if (localObject1 != null) {
              break label518;
            }
            localObject1 = localObject3;
            label331:
            if (localObject1 == null) {
              break label526;
            }
            this.apptype = ((AppBrandInitConfigWC)localObject1).cmr;
          }
          break;
        }
      }
    }
    for (;;)
    {
      this.apptype += 1000;
      this.jXE = paramae.getRuntime().aXc().jXE;
      paramae = n.KE(paramae.getAppId()).jzc;
      if (!bt.isNullOrNil(paramae)) {
        this.mtc = paramae;
      }
      AppMethodBeat.o(48138);
      return;
      localObject1 = paramae.mcx.mrg;
      break;
      this.dki = paramae.kuf;
      break label125;
      localObject1 = new h.c(4);
      break label254;
      localObject1 = new h.c(5);
      break label254;
      label445:
      ad.e("MicroMsg.AppBrand.Report.kv_13536", "visitNode (%s) not found, maybe page switching to quickly", new Object[] { paramae.lYf });
      localObject2 = null;
      localObject1 = null;
      break label259;
      label472:
      localObject2 = ((h.a)localObject1).msG;
      localObject1 = ((h.a)localObject1).msH;
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
      localObject1 = ((o)localObject1).aXc();
      break label331;
      label526:
      this.apptype = i.Uj(this.appId);
      ad.i("MicroMsg.AppBrand.Report.kv_13536", "prepareCommonFields null = initConfig! apptype:%s", new Object[] { Integer.valueOf(this.apptype) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.k
 * JD-Core Version:    0.7.0.1
 */