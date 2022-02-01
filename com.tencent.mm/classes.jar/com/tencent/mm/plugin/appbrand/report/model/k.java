package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.utils.f;
import com.tencent.mm.plugin.appbrand.y.m.a;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Arrays;

public final class k
{
  private static final k mxQ;
  public int aDD;
  public String appId;
  public int apptype;
  public long dCI;
  public int dLf;
  public String dLg;
  public int dli;
  public String dlj;
  public String dlk;
  public AppBrandRuntime jDb;
  public int kaT;
  public long lKd;
  private final h lSX;
  public int mwv;
  public String mww;
  public long mxN;
  private final boolean mxP;
  boolean mxR = false;
  public String mxS;
  public String mxT;
  public int mxU;
  public String mxV;
  public int mxW;
  public int mxX;
  public String mxY;
  public String mxZ;
  public long mya;
  public int scene;
  public String sessionId;
  
  static
  {
    AppMethodBeat.i(48141);
    mxQ = new k(true, null);
    AppMethodBeat.o(48141);
  }
  
  private k(boolean paramBoolean, h paramh)
  {
    this.mxP = paramBoolean;
    this.lSX = paramh;
  }
  
  public static k a(com.tencent.mm.plugin.appbrand.p paramp, String paramString, h paramh)
  {
    AppMethodBeat.i(48136);
    paramh = new k(false, paramh);
    paramh.sessionId = paramString;
    paramString = paramp.Fg().cmE;
    paramh.scene = paramString.scene;
    paramh.dlj = paramString.dlj;
    paramh.appId = paramp.mAppId;
    paramh.jDb = paramp;
    paramh.dli = (paramp.aXx().dQv + 1);
    paramh.aDD = paramp.aXx().aDD;
    paramh.mwv = paramString.mwv;
    paramh.dLf = paramString.dLf;
    paramh.dLg = paramString.dLg;
    AppMethodBeat.o(48136);
    return paramh;
  }
  
  public static k byu()
  {
    return mxQ;
  }
  
  final void report()
  {
    AppMethodBeat.i(48140);
    if (this.mxP)
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
            str1 = (String)this.myb[19];
            if (!bu.isNullOrNil(str1))
            {
              i = str1.indexOf('?');
              if (i >= 0) {
                continue;
              }
              str1 = "";
              this.myb[19] = str1;
            }
            str1 = (String)this.myb[19];
            if (bu.nullAsNil(str1).length() > 1024)
            {
              str1 = str1.substring(0, 1024);
              this.myb[19] = str1;
            }
          }
          catch (Exception localException)
          {
            String str1;
            int i;
            int j;
            this.myb[19] = "";
            String str2 = (String)this.myb[19];
            if (bu.nullAsNil(str2).length() <= 1024) {
              continue;
            }
            str2 = str2.substring(0, 1024);
            this.myb[19] = str2;
            continue;
          }
          finally
          {
            String str3 = (String)this.myb[19];
            if (bu.nullAsNil(str3).length() <= 1024) {
              continue;
            }
            str3 = str3.substring(0, 1024);
            this.myb[19] = str3;
            AppMethodBeat.o(48135);
          }
          i = 0;
          if (i >= 3) {
            break label285;
          }
          j = new int[] { 1, 11, 13 }[i];
          str1 = (String)this.myb[j];
          if (bu.nullAsNil(str1).length() > 1024)
          {
            str1 = str1.substring(0, 1024);
            this.myb[j] = str1;
          }
          i += 1;
          continue;
          str1 = q.encode(str1.substring(i + 1, str1.length()));
        }
        label285:
        ae.d("MicroMsg.AppBrand.Report.kv_13536", "report " + Arrays.deepToString(this.myb));
        com.tencent.mm.plugin.report.service.g.yxI.f(13536, com.tencent.mm.plugin.appbrand.report.p.k(this.myb));
        KVCommCrossProcessReceiver.dND();
        AppMethodBeat.o(48135);
      }
    };
    if (this.mxR)
    {
      local1.run();
      try
      {
        KVCommCrossProcessReceiver.dND();
        AppMethodBeat.o(48140);
        return;
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.AppBrand.Report.kv_13536", localException, "sendKV", new Object[0]);
        AppMethodBeat.o(48140);
        return;
      }
    }
    f.bCj().postToWorker(localException);
    AppMethodBeat.o(48140);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(48139);
    String str = "kv_13536{scene=" + this.scene + ", sceneNote='" + this.dlj + '\'' + ", sessionId='" + this.sessionId + '\'' + ", appId='" + this.appId + '\'' + ", appVersion=" + this.aDD + ", appState=" + this.dli + ", usedState=" + this.mwv + ", pagePath='" + this.dlk + '\'' + ", networkType='" + this.mxS + '\'' + ", costTime=" + this.mxN + ", stayTime=" + this.dCI + ", referPagePath='" + this.mxT + '\'' + ", targetAction=" + this.mxU + ", targetPagePath='" + this.mxV + '\'' + ", clickTimestamp=" + this.lKd + ", publicLibVersion=" + this.mxW + ", preScene=" + this.dLf + ", preSceneNote='" + this.dLg + '\'' + ", isEntrance=" + this.mxX + ", apptype=" + this.apptype + ", systemRecentsReason=" + this.kaT + ", referAction=" + this.mxZ + ", manufacturerAppId=" + this.mww + ", stayTimeFuncPageStart=" + this.mya + '}';
    AppMethodBeat.o(48139);
    return str;
  }
  
  public final void v(ad paramad)
  {
    AppMethodBeat.i(48137);
    w(paramad);
    report();
    AppMethodBeat.o(48137);
  }
  
  final void w(ad paramad)
  {
    Object localObject3 = null;
    AppMethodBeat.i(48138);
    Object localObject1 = paramad.getRuntime().aXw();
    if (localObject1 != null) {
      this.aDD = ((com.tencent.mm.plugin.appbrand.config.k)localObject1).kbw.pkgVersion;
    }
    localObject1 = paramad.aWe();
    if (localObject1 != null) {
      this.mxW = ((ICommLibReader)localObject1).aZM();
    }
    this.lKd = paramad.mgP.mxo;
    this.mxN = paramad.mgP.byl();
    this.dCI = paramad.mgP.bym();
    this.mya = paramad.mgP.byb();
    label125:
    label254:
    Object localObject2;
    label259:
    int i;
    if (paramad.getRuntime().Ee()) {
      if (paramad.mgP.mwe == null)
      {
        localObject1 = paramad.kxv;
        this.dlk = ((String)localObject1);
        this.mxY = paramad.mcM;
        this.mxS = com.tencent.mm.plugin.appbrand.report.h.getNetworkType(ak.getContext());
        this.mwv = paramad.getRuntime().Fg().cmE.mwv;
        localObject1 = this.lSX.s(paramad);
        if (localObject1 != null) {
          break label472;
        }
        if ((paramad.getRuntime() == null) || (!paramad.getRuntime().SB)) {
          break label445;
        }
        localObject1 = com.tencent.mm.plugin.appbrand.h.KU(paramad.getAppId());
        ae.i("MicroMsg.AppBrand.Report.kv_13536", "visitNode (%s) not found, runtime.isFinishing=TRUE, pauseType=%s, maybe closed by user in LoadingSplash", new Object[] { paramad.mcM, localObject1 });
        switch (k.2.jOW[localObject1.ordinal()])
        {
        default: 
          localObject1 = null;
          localObject2 = localObject1;
          localObject1 = null;
          if (localObject2 == null)
          {
            i = 0;
            label266:
            this.mxU = i;
            if (localObject2 != null) {
              break label495;
            }
            localObject2 = null;
            label279:
            this.mxV = ((String)localObject2);
            if (localObject1 != null) {
              break label505;
            }
            localObject1 = null;
            label291:
            this.mxT = ((String)localObject1);
            if (!this.lSX.UY(this.mxY)) {
              break label513;
            }
            i = 1;
            label314:
            this.mxX = i;
            localObject1 = paramad.getRuntime();
            if (localObject1 != null) {
              break label518;
            }
            localObject1 = localObject3;
            label331:
            if (localObject1 == null) {
              break label526;
            }
            this.apptype = ((AppBrandInitConfigWC)localObject1).cmt;
          }
          break;
        }
      }
    }
    for (;;)
    {
      this.apptype += 1000;
      this.kaT = paramad.getRuntime().aXx().kaT;
      paramad = o.Ld(paramad.getAppId()).jCc;
      if (!bu.isNullOrNil(paramad)) {
        this.mxZ = paramad;
      }
      AppMethodBeat.o(48138);
      return;
      localObject1 = paramad.mgP.mwe;
      break;
      this.dlk = paramad.kxv;
      break label125;
      localObject1 = new h.c(4);
      break label254;
      localObject1 = new h.c(5);
      break label254;
      label445:
      ae.e("MicroMsg.AppBrand.Report.kv_13536", "visitNode (%s) not found, maybe page switching to quickly", new Object[] { paramad.mcM });
      localObject2 = null;
      localObject1 = null;
      break label259;
      label472:
      localObject2 = ((h.a)localObject1).mxD;
      localObject1 = ((h.a)localObject1).mxE;
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
      localObject1 = ((com.tencent.mm.plugin.appbrand.p)localObject1).aXx();
      break label331;
      label526:
      this.apptype = i.UU(this.appId);
      ae.i("MicroMsg.AppBrand.Report.kv_13536", "prepareCommonFields null = initConfig! apptype:%s", new Object[] { Integer.valueOf(this.apptype) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.k
 * JD-Core Version:    0.7.0.1
 */