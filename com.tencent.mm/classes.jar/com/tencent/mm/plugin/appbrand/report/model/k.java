package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.f;
import com.tencent.mm.plugin.appbrand.utils.e;
import com.tencent.mm.plugin.appbrand.z.l.a;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Arrays;

public final class k
{
  private static final k lTd;
  public int aBM;
  public String appId;
  public int apptype;
  public int cYO;
  public String cYP;
  public String cYQ;
  public long dpQ;
  public int dxE;
  public String dxF;
  public int jDI;
  public AppBrandRuntime jgY;
  public int lRH;
  public String lRI;
  public long lTa;
  private final boolean lTc;
  boolean lTe = false;
  public String lTf;
  public String lTg;
  public int lTh;
  public String lTi;
  public long lTj;
  public int lTk;
  public int lTl;
  public String lTm;
  public String lTn;
  public long lTo;
  private final h lqW;
  public int scene;
  public String sessionId;
  
  static
  {
    AppMethodBeat.i(48141);
    lTd = new k(true, null);
    AppMethodBeat.o(48141);
  }
  
  private k(boolean paramBoolean, h paramh)
  {
    this.lTc = paramBoolean;
    this.lqW = paramh;
  }
  
  public static k a(com.tencent.mm.plugin.appbrand.o paramo, String paramString, h paramh)
  {
    AppMethodBeat.i(48136);
    paramh = new k(false, paramh);
    paramh.sessionId = paramString;
    paramString = paramo.DC().ccl;
    paramh.scene = paramString.scene;
    paramh.cYP = paramString.cYP;
    paramh.appId = paramo.mAppId;
    paramh.jgY = paramo;
    paramh.cYO = (paramo.aTS().joY + 1);
    paramh.aBM = paramo.aTS().aBM;
    paramh.lRH = paramString.lRH;
    paramh.dxE = paramString.dxE;
    paramh.dxF = paramString.dxF;
    AppMethodBeat.o(48136);
    return paramh;
  }
  
  public static k btw()
  {
    return lTd;
  }
  
  final void report()
  {
    AppMethodBeat.i(48140);
    if (this.lTc)
    {
      AppMethodBeat.o(48140);
      return;
    }
    Runnable local1 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48135);
        for (;;)
        {
          try
          {
            str1 = (String)this.lTp[19];
            if (!bs.isNullOrNil(str1))
            {
              i = str1.indexOf('?');
              if (i >= 0) {
                continue;
              }
              str1 = "";
              this.lTp[19] = str1;
            }
            str1 = (String)this.lTp[19];
            if (bs.nullAsNil(str1).length() > 1024)
            {
              str1 = str1.substring(0, 1024);
              this.lTp[19] = str1;
            }
          }
          catch (Exception localException)
          {
            String str1;
            int i;
            int j;
            this.lTp[19] = "";
            String str2 = (String)this.lTp[19];
            if (bs.nullAsNil(str2).length() <= 1024) {
              continue;
            }
            str2 = str2.substring(0, 1024);
            this.lTp[19] = str2;
            continue;
          }
          finally
          {
            String str3 = (String)this.lTp[19];
            if (bs.nullAsNil(str3).length() <= 1024) {
              continue;
            }
            str3 = str3.substring(0, 1024);
            this.lTp[19] = str3;
            AppMethodBeat.o(48135);
          }
          i = 0;
          if (i >= 3) {
            break label285;
          }
          j = new int[] { 1, 11, 13 }[i];
          str1 = (String)this.lTp[j];
          if (bs.nullAsNil(str1).length() > 1024)
          {
            str1 = str1.substring(0, 1024);
            this.lTp[j] = str1;
          }
          i += 1;
          continue;
          str1 = p.encode(str1.substring(i + 1, str1.length()));
        }
        label285:
        ac.d("MicroMsg.AppBrand.Report.kv_13536", "report " + Arrays.deepToString(this.lTp));
        com.tencent.mm.plugin.report.service.h.wUl.f(13536, com.tencent.mm.plugin.appbrand.report.o.l(this.lTp));
        KVCommCrossProcessReceiver.dyN();
        AppMethodBeat.o(48135);
      }
    };
    if (this.lTe)
    {
      local1.run();
      try
      {
        KVCommCrossProcessReceiver.dyN();
        AppMethodBeat.o(48140);
        return;
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("MicroMsg.AppBrand.Report.kv_13536", localException, "sendKV", new Object[0]);
        AppMethodBeat.o(48140);
        return;
      }
    }
    e.bxj().postToWorker(localException);
    AppMethodBeat.o(48140);
  }
  
  public final void t(ae paramae)
  {
    AppMethodBeat.i(48137);
    u(paramae);
    report();
    AppMethodBeat.o(48137);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(48139);
    String str = "kv_13536{scene=" + this.scene + ", sceneNote='" + this.cYP + '\'' + ", sessionId='" + this.sessionId + '\'' + ", appId='" + this.appId + '\'' + ", appVersion=" + this.aBM + ", appState=" + this.cYO + ", usedState=" + this.lRH + ", pagePath='" + this.cYQ + '\'' + ", networkType='" + this.lTf + '\'' + ", costTime=" + this.lTa + ", stayTime=" + this.dpQ + ", referPagePath='" + this.lTg + '\'' + ", targetAction=" + this.lTh + ", targetPagePath='" + this.lTi + '\'' + ", clickTimestamp=" + this.lTj + ", publicLibVersion=" + this.lTk + ", preScene=" + this.dxE + ", preSceneNote='" + this.dxF + '\'' + ", isEntrance=" + this.lTl + ", apptype=" + this.apptype + ", systemRecentsReason=" + this.jDI + ", referAction=" + this.lTn + ", manufacturerAppId=" + this.lRI + ", stayTimeFuncPageStart=" + this.lTo + '}';
    AppMethodBeat.o(48139);
    return str;
  }
  
  final void u(ae paramae)
  {
    Object localObject3 = null;
    AppMethodBeat.i(48138);
    Object localObject1 = paramae.getRuntime().aTR();
    if (localObject1 != null) {
      this.aBM = ((com.tencent.mm.plugin.appbrand.config.k)localObject1).jEg.pkgVersion;
    }
    localObject1 = paramae.aSt();
    if (localObject1 != null) {
      this.lTk = ((ICommLibReader)localObject1).aVU();
    }
    this.lTj = paramae.lCV.lSA;
    this.lTa = paramae.lCV.btn();
    this.dpQ = paramae.lCV.bto();
    this.lTo = paramae.lCV.btd();
    label125:
    label254:
    Object localObject2;
    label259:
    int i;
    if (paramae.getRuntime().CC()) {
      if (paramae.lCV.lRq == null)
      {
        localObject1 = paramae.jZJ;
        this.cYQ = ((String)localObject1);
        this.lTm = paramae.lyH;
        this.lTf = com.tencent.mm.plugin.appbrand.report.g.getNetworkType(ai.getContext());
        this.lRH = paramae.getRuntime().DC().ccl.lRH;
        localObject1 = this.lqW.q(paramae);
        if (localObject1 != null) {
          break label472;
        }
        if ((paramae.getRuntime() == null) || (!paramae.getRuntime().QM)) {
          break label445;
        }
        localObject1 = com.tencent.mm.plugin.appbrand.g.Hg(paramae.getAppId());
        ac.i("MicroMsg.AppBrand.Report.kv_13536", "visitNode (%s) not found, runtime.isFinishing=TRUE, pauseType=%s, maybe closed by user in LoadingSplash", new Object[] { paramae.lyH, localObject1 });
        switch (2.jrQ[localObject1.ordinal()])
        {
        default: 
          localObject1 = null;
          localObject2 = localObject1;
          localObject1 = null;
          if (localObject2 == null)
          {
            i = 0;
            label266:
            this.lTh = i;
            if (localObject2 != null) {
              break label495;
            }
            localObject2 = null;
            label279:
            this.lTi = ((String)localObject2);
            if (localObject1 != null) {
              break label505;
            }
            localObject1 = null;
            label291:
            this.lTg = ((String)localObject1);
            if (!this.lqW.QH(this.lTm)) {
              break label513;
            }
            i = 1;
            label314:
            this.lTl = i;
            localObject1 = paramae.getRuntime();
            if (localObject1 != null) {
              break label518;
            }
            localObject1 = localObject3;
            label331:
            if (localObject1 == null) {
              break label526;
            }
            this.apptype = ((AppBrandInitConfigWC)localObject1).cca;
          }
          break;
        }
      }
    }
    for (;;)
    {
      this.apptype += 1000;
      this.jDI = paramae.getRuntime().aTS().jDI;
      paramae = n.Hr(paramae.getAppId()).jfW;
      if (!bs.isNullOrNil(paramae)) {
        this.lTn = paramae;
      }
      AppMethodBeat.o(48138);
      return;
      localObject1 = paramae.lCV.lRq;
      break;
      this.cYQ = paramae.jZJ;
      break label125;
      localObject1 = new h.c(4);
      break label254;
      localObject1 = new h.c(5);
      break label254;
      label445:
      ac.e("MicroMsg.AppBrand.Report.kv_13536", "visitNode (%s) not found, maybe page switching to quickly", new Object[] { paramae.lyH });
      localObject2 = null;
      localObject1 = null;
      break label259;
      label472:
      localObject2 = ((h.a)localObject1).lSQ;
      localObject1 = ((h.a)localObject1).lSR;
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
      localObject1 = ((com.tencent.mm.plugin.appbrand.o)localObject1).aTS();
      break label331;
      label526:
      this.apptype = com.tencent.mm.plugin.appbrand.report.h.QD(this.appId);
      ac.i("MicroMsg.AppBrand.Report.kv_13536", "prepareCommonFields null = initConfig! apptype:%s", new Object[] { Integer.valueOf(this.apptype) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.k
 * JD-Core Version:    0.7.0.1
 */