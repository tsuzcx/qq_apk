package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.aa.l.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.f;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.utils.e;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Arrays;

public final class k
{
  private static final k lri;
  public int aAS;
  public String appId;
  public int apptype;
  public int dbs;
  public String dbt;
  public String dbu;
  public long dsf;
  public int dzS;
  public String dzT;
  public AppBrandRuntime iGV;
  public int jdv;
  private final h kPx;
  public int lpL;
  public String lpM;
  public long lrf;
  private final boolean lrh;
  boolean lrj = false;
  public String lrk;
  public String lrl;
  public int lrm;
  public String lrn;
  public long lro;
  public int lrp;
  public int lrq;
  public String lrr;
  public String lrs;
  public long lrt;
  public int scene;
  public String sessionId;
  
  static
  {
    AppMethodBeat.i(48141);
    lri = new k(true, null);
    AppMethodBeat.o(48141);
  }
  
  private k(boolean paramBoolean, h paramh)
  {
    this.lrh = paramBoolean;
    this.kPx = paramh;
  }
  
  public static k a(o paramo, String paramString, h paramh)
  {
    AppMethodBeat.i(48136);
    paramh = new k(false, paramh);
    paramh.sessionId = paramString;
    paramString = paramo.DZ().cfo;
    paramh.scene = paramString.scene;
    paramh.dbt = paramString.dbt;
    paramh.appId = paramo.mAppId;
    paramh.iGV = paramo;
    paramh.dbs = (paramo.aNc().iOP + 1);
    paramh.aAS = paramo.aNc().aAS;
    paramh.lpL = paramString.lpL;
    paramh.dzS = paramString.dzS;
    paramh.dzT = paramString.dzT;
    AppMethodBeat.o(48136);
    return paramh;
  }
  
  public static k bmA()
  {
    return lri;
  }
  
  final void report()
  {
    AppMethodBeat.i(48140);
    if (this.lrh)
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
            str1 = (String)this.lru[19];
            if (!bt.isNullOrNil(str1))
            {
              i = str1.indexOf('?');
              if (i >= 0) {
                continue;
              }
              str1 = "";
              this.lru[19] = str1;
            }
            str1 = (String)this.lru[19];
            if (bt.nullAsNil(str1).length() > 1024)
            {
              str1 = str1.substring(0, 1024);
              this.lru[19] = str1;
            }
          }
          catch (Exception localException)
          {
            String str1;
            int i;
            int j;
            this.lru[19] = "";
            String str2 = (String)this.lru[19];
            if (bt.nullAsNil(str2).length() <= 1024) {
              continue;
            }
            str2 = str2.substring(0, 1024);
            this.lru[19] = str2;
            continue;
          }
          finally
          {
            String str3 = (String)this.lru[19];
            if (bt.nullAsNil(str3).length() <= 1024) {
              continue;
            }
            str3 = str3.substring(0, 1024);
            this.lru[19] = str3;
            AppMethodBeat.o(48135);
          }
          i = 0;
          if (i >= 3) {
            break label285;
          }
          j = new int[] { 1, 11, 13 }[i];
          str1 = (String)this.lru[j];
          if (bt.nullAsNil(str1).length() > 1024)
          {
            str1 = str1.substring(0, 1024);
            this.lru[j] = str1;
          }
          i += 1;
          continue;
          str1 = com.tencent.mm.compatible.util.p.encode(str1.substring(i + 1, str1.length()));
        }
        label285:
        ad.d("MicroMsg.AppBrand.Report.kv_13536", "report " + Arrays.deepToString(this.lru));
        com.tencent.mm.plugin.report.service.h.vKh.f(13536, com.tencent.mm.plugin.appbrand.report.p.k(this.lru));
        KVCommCrossProcessReceiver.dkK();
        AppMethodBeat.o(48135);
      }
    };
    if (this.lrj)
    {
      local1.run();
      try
      {
        KVCommCrossProcessReceiver.dkK();
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
    e.bqm().postToWorker(localException);
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
    String str = "kv_13536{scene=" + this.scene + ", sceneNote='" + this.dbt + '\'' + ", sessionId='" + this.sessionId + '\'' + ", appId='" + this.appId + '\'' + ", appVersion=" + this.aAS + ", appState=" + this.dbs + ", usedState=" + this.lpL + ", pagePath='" + this.dbu + '\'' + ", networkType='" + this.lrk + '\'' + ", costTime=" + this.lrf + ", stayTime=" + this.dsf + ", referPagePath='" + this.lrl + '\'' + ", targetAction=" + this.lrm + ", targetPagePath='" + this.lrn + '\'' + ", clickTimestamp=" + this.lro + ", publicLibVersion=" + this.lrp + ", preScene=" + this.dzS + ", preSceneNote='" + this.dzT + '\'' + ", isEntrance=" + this.lrq + ", apptype=" + this.apptype + ", systemRecentsReason=" + this.jdv + ", referAction=" + this.lrs + ", manufacturerAppId=" + this.lpM + ", stayTimeFuncPageStart=" + this.lrt + '}';
    AppMethodBeat.o(48139);
    return str;
  }
  
  final void u(ae paramae)
  {
    Object localObject3 = null;
    AppMethodBeat.i(48138);
    Object localObject1 = paramae.getRuntime().aNb();
    if (localObject1 != null) {
      this.aAS = ((com.tencent.mm.plugin.appbrand.config.k)localObject1).jdS.pkgVersion;
    }
    localObject1 = paramae.aLC();
    if (localObject1 != null) {
      this.lrp = ((ICommLibReader)localObject1).aPc();
    }
    this.lro = paramae.lbw.lqF;
    this.lrf = paramae.lbw.bmr();
    this.dsf = paramae.lbw.bms();
    this.lrt = paramae.lbw.bmh();
    label125:
    Object localObject2;
    label199:
    int i;
    if (paramae.getRuntime().CZ()) {
      if (paramae.lbw.lpq == null)
      {
        localObject1 = paramae.jzm;
        this.dbu = ((String)localObject1);
        this.lrr = paramae.kWX;
        this.lrk = com.tencent.mm.plugin.appbrand.report.h.getNetworkType(aj.getContext());
        this.lpL = paramae.getRuntime().DZ().cfo.lpL;
        localObject1 = this.kPx.q(paramae);
        if (localObject1 != null) {
          break label361;
        }
        ad.e("MicroMsg.AppBrand.Report.kv_13536", "visitNode (%s) not found, maybe page switching to quickly", new Object[] { paramae.kWX });
        localObject2 = null;
        localObject1 = null;
        if (localObject2 != null) {
          break label375;
        }
        i = 0;
        label206:
        this.lrm = i;
        if (localObject2 != null) {
          break label384;
        }
        localObject2 = null;
        label219:
        this.lrn = ((String)localObject2);
        if (localObject1 != null) {
          break label394;
        }
        localObject1 = null;
        label231:
        this.lrl = ((String)localObject1);
        if (!this.kPx.My(this.lrr)) {
          break label402;
        }
        i = 1;
        label254:
        this.lrq = i;
        localObject1 = paramae.getRuntime();
        if (localObject1 != null) {
          break label407;
        }
        localObject1 = localObject3;
        label271:
        if (localObject1 == null) {
          break label415;
        }
        this.apptype = ((AppBrandInitConfigWC)localObject1).cfd;
      }
    }
    for (;;)
    {
      this.apptype += 1000;
      this.jdv = paramae.getRuntime().aNc().jdv;
      paramae = n.Do(paramae.getAppId()).iFU;
      if (!bt.isNullOrNil(paramae)) {
        this.lrs = paramae;
      }
      AppMethodBeat.o(48138);
      return;
      localObject1 = paramae.lbw.lpq;
      break;
      this.dbu = paramae.jzm;
      break label125;
      label361:
      localObject2 = ((h.a)localObject1).lqV;
      localObject1 = ((h.a)localObject1).lqW;
      break label199;
      label375:
      i = ((h.c)localObject2).type;
      break label206;
      label384:
      localObject2 = ((h.c)localObject2).path;
      break label219;
      label394:
      localObject1 = ((h.b)localObject1).path;
      break label231;
      label402:
      i = 0;
      break label254;
      label407:
      localObject1 = ((o)localObject1).aNc();
      break label271;
      label415:
      this.apptype = i.Mu(this.appId);
      ad.i("MicroMsg.AppBrand.Report.kv_13536", "prepareCommonFields null = initConfig! apptype:%s", new Object[] { Integer.valueOf(this.apptype) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.k
 * JD-Core Version:    0.7.0.1
 */