package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.m.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.appbrand.report.s;
import com.tencent.mm.plugin.appbrand.utils.f;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class k
{
  private static final k nIS;
  public String appId;
  public int appVersion;
  public int apptype;
  public long costTime;
  public int dCv;
  public String dCw;
  public String dCx;
  public long dUy;
  public int ecU;
  public String ecV;
  public AppBrandRuntime kEc;
  public int ldX;
  public long mRS;
  public int nHt;
  public String nHu;
  private final boolean nIR;
  boolean nIT = false;
  public String nIU;
  public int nIV;
  public String nIW;
  public int nIX;
  public int nIY;
  public String nIZ;
  public String nJa;
  public long nJb;
  private final h nay;
  public String networkType;
  public int scene;
  public String sessionId;
  
  static
  {
    AppMethodBeat.i(48141);
    nIS = new k(true, null);
    AppMethodBeat.o(48141);
  }
  
  private k(boolean paramBoolean, h paramh)
  {
    this.nIR = paramBoolean;
    this.nay = paramh;
  }
  
  public static k a(com.tencent.mm.plugin.appbrand.q paramq, String paramString, h paramh)
  {
    AppMethodBeat.i(48136);
    paramh = new k(false, paramh);
    paramh.sessionId = paramString;
    paramString = paramq.ON().cyA;
    paramh.scene = paramString.scene;
    paramh.dCw = paramString.dCw;
    paramh.appId = paramq.mAppId;
    paramh.kEc = paramq;
    paramh.dCv = (paramq.bsC().eix + 1);
    paramh.appVersion = paramq.bsC().appVersion;
    paramh.nHt = paramString.nHt;
    paramh.ecU = paramString.ecU;
    paramh.ecV = paramString.ecV;
    AppMethodBeat.o(48136);
    return paramh;
  }
  
  public static k bUM()
  {
    return nIS;
  }
  
  final void report()
  {
    AppMethodBeat.i(48140);
    if (this.nIR)
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
            str1 = (String)this.nJc[19];
            if (!Util.isNullOrNil(str1))
            {
              i = str1.indexOf('?');
              if (i >= 0) {
                continue;
              }
              str1 = "";
              this.nJc[19] = str1;
            }
            str1 = (String)this.nJc[19];
            if (Util.nullAsNil(str1).length() > 1024)
            {
              str1 = str1.substring(0, 1024);
              this.nJc[19] = str1;
            }
          }
          catch (Exception localException)
          {
            String str1;
            int i;
            int j;
            this.nJc[19] = "";
            String str2 = (String)this.nJc[19];
            if (Util.nullAsNil(str2).length() <= 1024) {
              continue;
            }
            str2 = str2.substring(0, 1024);
            this.nJc[19] = str2;
            continue;
          }
          finally
          {
            String str3 = (String)this.nJc[19];
            if (Util.nullAsNil(str3).length() <= 1024) {
              continue;
            }
            str3 = str3.substring(0, 1024);
            this.nJc[19] = str3;
            AppMethodBeat.o(48135);
          }
          i = 0;
          if (i >= 3) {
            break label285;
          }
          j = new int[] { 1, 11, 13 }[i];
          str1 = (String)this.nJc[j];
          if (Util.nullAsNil(str1).length() > 1024)
          {
            str1 = str1.substring(0, 1024);
            this.nJc[j] = str1;
          }
          i += 1;
          continue;
          str1 = com.tencent.mm.compatible.util.q.encode(str1.substring(i + 1, str1.length()));
        }
        label285:
        Log.i("MicroMsg.AppBrand.Report.kv_13536", "report " + Arrays.deepToString(this.nJc));
        com.tencent.mm.plugin.report.service.h.CyF.a(13536, s.k(this.nJc));
        KVCommCrossProcessReceiver.eOD();
        AppMethodBeat.o(48135);
      }
    };
    if (this.nIT)
    {
      local1.run();
      try
      {
        KVCommCrossProcessReceiver.eOD();
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
    f.bZn().postToWorker(localException);
    AppMethodBeat.o(48140);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(48139);
    String str = "kv_13536{scene=" + this.scene + ", sceneNote='" + this.dCw + '\'' + ", sessionId='" + this.sessionId + '\'' + ", appId='" + this.appId + '\'' + ", appVersion=" + this.appVersion + ", appState=" + this.dCv + ", usedState=" + this.nHt + ", pagePath='" + this.dCx + '\'' + ", networkType='" + this.networkType + '\'' + ", costTime=" + this.costTime + ", stayTime=" + this.dUy + ", referPagePath='" + this.nIU + '\'' + ", targetAction=" + this.nIV + ", targetPagePath='" + this.nIW + '\'' + ", clickTimestamp=" + this.mRS + ", publicLibVersion=" + this.nIX + ", preScene=" + this.ecU + ", preSceneNote='" + this.ecV + '\'' + ", isEntrance=" + this.nIY + ", apptype=" + this.apptype + ", systemRecentsReason=" + this.ldX + ", referAction=" + this.nJa + ", manufacturerAppId=" + this.nHu + ", stayTimeFuncPageStart=" + this.nJb + '}';
    AppMethodBeat.o(48139);
    return str;
  }
  
  public final void v(ag paramag)
  {
    AppMethodBeat.i(48137);
    w(paramag);
    report();
    AppMethodBeat.o(48137);
  }
  
  final void w(ag paramag)
  {
    Object localObject3 = null;
    AppMethodBeat.i(48138);
    Object localObject1 = paramag.getRuntime().bsB();
    if (localObject1 != null) {
      this.appVersion = ((l)localObject1).leE.pkgVersion;
    }
    localObject1 = paramag.bqZ();
    if (localObject1 != null) {
      this.nIX = ((ICommLibReader)localObject1).bvd();
    }
    this.mRS = paramag.nrs.nIs;
    this.costTime = paramag.nrs.bUD();
    this.dUy = paramag.nrs.bUE();
    this.nJb = paramag.nrs.bUs();
    label125:
    label254:
    Object localObject2;
    label259:
    int i;
    if (paramag.getRuntime().NA()) {
      if (paramag.nrs.nHc == null)
      {
        localObject1 = paramag.lBI;
        this.dCx = ((String)localObject1);
        this.nIZ = paramag.nna;
        this.networkType = i.getNetworkType(MMApplicationContext.getContext());
        this.nHt = paramag.getRuntime().ON().cyA.nHt;
        localObject1 = this.nay.s(paramag);
        if (localObject1 != null) {
          break label472;
        }
        if ((paramag.getRuntime() == null) || (!paramag.getRuntime().SO)) {
          break label445;
        }
        localObject1 = com.tencent.mm.plugin.appbrand.h.Uc(paramag.getAppId());
        Log.i("MicroMsg.AppBrand.Report.kv_13536", "visitNode (%s) not found, runtime.isFinishing=TRUE, pauseType=%s, maybe closed by user in LoadingSplash", new Object[] { paramag.nna, localObject1 });
        switch (2.kRE[localObject1.ordinal()])
        {
        default: 
          localObject1 = null;
          localObject2 = localObject1;
          localObject1 = null;
          if (localObject2 == null)
          {
            i = 0;
            label266:
            this.nIV = i;
            if (localObject2 != null) {
              break label495;
            }
            localObject2 = null;
            label279:
            this.nIW = ((String)localObject2);
            if (localObject1 != null) {
              break label505;
            }
            localObject1 = null;
            label291:
            this.nIU = ((String)localObject1);
            if (!this.nay.aeN(this.nIZ)) {
              break label513;
            }
            i = 1;
            label314:
            this.nIY = i;
            localObject1 = paramag.getRuntime();
            if (localObject1 != null) {
              break label518;
            }
            localObject1 = localObject3;
            label331:
            if (localObject1 == null) {
              break label526;
            }
            this.apptype = ((AppBrandInitConfigWC)localObject1).cyo;
          }
          break;
        }
      }
    }
    for (;;)
    {
      this.apptype += 1000;
      this.ldX = paramag.getRuntime().bsC().ldX;
      paramag = p.Um(paramag.getAppId()).kCY;
      if (!Util.isNullOrNil(paramag)) {
        this.nJa = paramag;
      }
      AppMethodBeat.o(48138);
      return;
      localObject1 = paramag.nrs.nHc;
      break;
      this.dCx = paramag.lBI;
      break label125;
      localObject1 = new h.c(4);
      break label254;
      localObject1 = new h.c(5);
      break label254;
      label445:
      Log.e("MicroMsg.AppBrand.Report.kv_13536", "visitNode (%s) not found, maybe page switching to quickly", new Object[] { paramag.nna });
      localObject2 = null;
      localObject1 = null;
      break label259;
      label472:
      localObject2 = ((h.a)localObject1).nIH;
      localObject1 = ((h.a)localObject1).nII;
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
      localObject1 = ((com.tencent.mm.plugin.appbrand.q)localObject1).bsC();
      break label331;
      label526:
      this.apptype = j.aeJ(this.appId);
      Log.i("MicroMsg.AppBrand.Report.kv_13536", "prepareCommonFields null = initConfig! apptype:%s", new Object[] { Integer.valueOf(this.apptype) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.k
 * JD-Core Version:    0.7.0.1
 */