package com.tencent.mm.plugin.appbrand.report.quality;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mm.h.b.a.ag;
import com.tencent.mm.h.b.a.ag.a;
import com.tencent.mm.h.b.a.ag.b;
import com.tencent.mm.h.b.a.ah;
import com.tencent.mm.h.b.a.ah.a;
import com.tencent.mm.h.b.a.ah.b;
import com.tencent.mm.h.b.a.ai;
import com.tencent.mm.h.b.a.ai.a;
import com.tencent.mm.h.b.a.ai.b;
import com.tencent.mm.h.b.a.aq;
import com.tencent.mm.h.b.a.aq.a;
import com.tencent.mm.h.b.a.aq.b;
import com.tencent.mm.h.b.a.aq.c;
import com.tencent.mm.h.b.a.aq.d;
import com.tencent.mm.h.b.a.as;
import com.tencent.mm.h.b.a.as.a;
import com.tencent.mm.h.b.a.as.b;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.launching.AppStartupPerformanceReportBundle;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.page.o;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.util.HashMap;
import java.util.Random;

public class a
{
  private static final b gZR;
  private static final HashMap<String, QualitySessionRuntime> gZS;
  
  static
  {
    if (!a.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      gZR = new b();
      gZS = new HashMap();
      return;
    }
  }
  
  public static void a(String paramString, final AppBrandSysConfigWC paramAppBrandSysConfigWC, AppStartupPerformanceReportBundle paramAppStartupPerformanceReportBundle, com.tencent.mm.plugin.appbrand.n paramn)
  {
    long l2 = 0L;
    QualitySessionRuntime localQualitySessionRuntime = wg(paramString);
    if (localQualitySessionRuntime == null) {
      return;
    }
    localQualitySessionRuntime.haq = System.currentTimeMillis();
    localQualitySessionRuntime.har = paramAppStartupPerformanceReportBundle;
    localQualitySessionRuntime.hao = paramn.aac().startTime;
    AppStartupPerformanceReportBundle localAppStartupPerformanceReportBundle = (AppStartupPerformanceReportBundle)paramn.c(AppStartupPerformanceReportBundle.class, false);
    if (localAppStartupPerformanceReportBundle == null) {
      y.e("MicroMsg.AppBrandQualitySystem", "ReportBundle == null in resourceReady");
    }
    do
    {
      com.tencent.mm.plugin.appbrand.u.n.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          if (this.gZT.gaS.mFinished) {
            return;
          }
          c localc = this.gZT.hau;
          QualitySessionRuntime localQualitySessionRuntime = this.gZT;
          AppBrandSysConfigWC localAppBrandSysConfigWC = paramAppBrandSysConfigWC;
          com.tencent.luggage.j.c.i("MicroMsg.AppBrandRuntimeEventReporter", "AppBrandRuntimeEventReporter.mayStart");
          int i = localQualitySessionRuntime.gaS.aac().uin;
          double d1 = localAppBrandSysConfigWC.fQq.fOV;
          double d2 = new Random(i ^ System.nanoTime()).nextDouble();
          if (d2 <= d1) {}
          for (boolean bool = true;; bool = false)
          {
            com.tencent.luggage.j.c.i("MicroMsg.AppBrandRuntimeEventReporter", "shouldEnableReport() returned: [%b], localRandom = [%f] serverPercent = [%f]", new Object[] { Boolean.valueOf(bool), Double.valueOf(d2), Double.valueOf(d1) });
            if (!bool) {
              break;
            }
            try
            {
              localc.gZZ = localQualitySessionRuntime;
              if (localc.handler == null)
              {
                localc.handler = new Handler(Looper.getMainLooper());
                localc.gZY.hab = (localAppBrandSysConfigWC.fQq.fOW * 1000);
                localc.handler.post(localc.gZY);
              }
              localc.haa = new com.tencent.mm.plugin.appbrand.performance.d();
              localc.haa.mInterval = 200L;
              localc.haa.gWi = null;
              localc.haa.start();
              return;
            }
            finally {}
          }
        }
      });
      return;
      paramAppStartupPerformanceReportBundle = new aq();
      paramString = wg(paramString);
    } while (paramString == null);
    paramAppStartupPerformanceReportBundle.ckG = paramString.appId;
    paramAppStartupPerformanceReportBundle.ckF = paramString.gKi;
    paramAppStartupPerformanceReportBundle.coR = aq.a.eX(paramString.ham);
    paramAppStartupPerformanceReportBundle.coS = aq.b.eY(paramString.apptype);
    paramAppStartupPerformanceReportBundle.cic = paramString.scene;
    paramAppStartupPerformanceReportBundle.ckH = paramString.han;
    paramAppStartupPerformanceReportBundle.aS(paramn.aac().startTime);
    paramAppStartupPerformanceReportBundle.vb();
    paramAppStartupPerformanceReportBundle.aR(paramAppStartupPerformanceReportBundle.ckM - paramn.aac().startTime);
    AppBrandSysConfigWC localAppBrandSysConfigWC = paramn.aaa();
    AppBrandInitConfigWC localAppBrandInitConfigWC = paramn.aac();
    if (localAppStartupPerformanceReportBundle.gKl)
    {
      paramString = aq.d.cpm;
      label210:
      paramAppStartupPerformanceReportBundle.coU = paramString;
      if (!localAppBrandInitConfigWC.fPD) {
        break label332;
      }
      paramString = aq.c.cpj;
      label227:
      paramAppStartupPerformanceReportBundle.coV = paramString;
      if (!paramn.fzH) {
        break label339;
      }
    }
    label332:
    label339:
    for (long l1 = 1L;; l1 = 0L)
    {
      paramAppStartupPerformanceReportBundle.coW = l1;
      l1 = l2;
      if (paramn.fzH)
      {
        paramString = new File(localAppBrandSysConfigWC.fPS.fCl);
        l1 = l2;
        if (paramString.isFile())
        {
          l1 = l2;
          if (paramString.canRead()) {
            l1 = paramString.length();
          }
        }
      }
      paramAppStartupPerformanceReportBundle.coT = l1;
      paramAppStartupPerformanceReportBundle.cis = d.getNetworkType();
      paramAppStartupPerformanceReportBundle.QX();
      break;
      paramString = aq.d.cpn;
      break label210;
      paramString = aq.c.cpk;
      break label227;
    }
  }
  
  public static b aov()
  {
    return gZR;
  }
  
  public static void b(String paramString, com.tencent.mm.plugin.appbrand.n paramn)
  {
    long l2 = 1L;
    if (wg(paramString) == null) {}
    Object localObject;
    label183:
    label189:
    label201:
    do
    {
      return;
      localObject = new ai();
      QualitySessionRuntime localQualitySessionRuntime = wg(paramString);
      if (localQualitySessionRuntime != null)
      {
        ((ai)localObject).ckG = localQualitySessionRuntime.appId;
        ((ai)localObject).ckF = localQualitySessionRuntime.gKi;
        ((ai)localObject).clV = ai.a.eI(localQualitySessionRuntime.ham);
        ((ai)localObject).clW = ai.b.eJ(localQualitySessionRuntime.apptype);
        ((ai)localObject).ckH = localQualitySessionRuntime.han;
        ((ai)localObject).cic = localQualitySessionRuntime.scene;
        ((ai)localObject).az(paramn.aac().startTime);
        ((ai)localObject).uW();
        ((ai)localObject).ay(((ai)localObject).ckM - ((ai)localObject).ckL);
        ((ai)localObject).bmf = paramn.aad().getCurrentUrl();
        if (!paramn.fzH) {
          break;
        }
        l1 = 1L;
        ((ai)localObject).clH = l1;
        if (localQualitySessionRuntime.har == null) {
          break label385;
        }
        if (!localQualitySessionRuntime.har.alH()) {
          break label380;
        }
        l1 = 1L;
        ((ai)localObject).clI = l1;
        if (!paramn.aae().fzX) {
          break label402;
        }
        l1 = 1L;
        ((ai)localObject).ckN = l1;
        ((ai)localObject).clX = 0L;
        ((ai)localObject).QX();
      }
      localObject = new as();
      paramString = wg(paramString);
    } while (paramString == null);
    ((as)localObject).ckG = paramString.appId;
    ((as)localObject).ckF = paramString.gKi;
    ((as)localObject).cpD = as.a.fb(paramString.ham);
    ((as)localObject).cpE = as.b.fc(paramString.apptype);
    ((as)localObject).ckH = paramString.han;
    ((as)localObject).cic = paramString.scene;
    ((as)localObject).aW(paramString.haq);
    ((as)localObject).vd();
    ((as)localObject).aV(((as)localObject).ckM - paramString.haq);
    ((as)localObject).bmf = paramn.aad().getCurrentUrl();
    if (paramn.aae().fzX) {}
    for (long l1 = l2;; l1 = 0L)
    {
      ((as)localObject).ckN = l1;
      ((as)localObject).clX = 0L;
      ((as)localObject).QX();
      return;
      l1 = 0L;
      break;
      label380:
      l1 = 0L;
      break label183;
      label385:
      if (!com.tencent.mm.sdk.platformtools.d.DEBUG) {
        break label189;
      }
      throw new IllegalStateException("StartupBundle not registered.");
      label402:
      l1 = 0L;
      break label201;
    }
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    QualitySessionRuntime localQualitySessionRuntime1 = wg(paramString1);
    if (localQualitySessionRuntime1 == null) {}
    do
    {
      do
      {
        return;
        int i = paramString3.length();
        paramString3 = new ag();
        QualitySessionRuntime localQualitySessionRuntime2 = wg(paramString1);
        if (localQualitySessionRuntime2 != null)
        {
          paramString3.ckG = localQualitySessionRuntime2.appId;
          paramString3.ckF = localQualitySessionRuntime2.gKi;
          paramString3.clp = ag.a.eE(localQualitySessionRuntime2.ham);
          paramString3.clq = ag.b.eF(localQualitySessionRuntime2.apptype);
          paramString3.ckH = localQualitySessionRuntime2.han;
          paramString3.cic = localQualitySessionRuntime2.scene;
          paramString3.av(paramLong);
          paramString3.uU();
          paramString3.au(paramString3.ckM - paramLong);
          paramString3.clr = i;
          paramString3.cls = paramString2;
          paramString3.QX();
        }
      } while ((localQualitySessionRuntime1.hat.gZV) || ((!paramString2.endsWith("app-service.js")) && (!"game.js".equals(paramString2))));
      localQualitySessionRuntime1.hat.gZV = true;
      paramString2 = localQualitySessionRuntime1.gaS;
      paramString3 = new ah();
      localQualitySessionRuntime1 = wg(paramString1);
    } while (localQualitySessionRuntime1 == null);
    paramString3.ckG = localQualitySessionRuntime1.appId;
    paramString3.ckF = localQualitySessionRuntime1.gKi;
    paramString3.clF = ah.a.eG(localQualitySessionRuntime1.ham);
    paramString3.clG = ah.b.eH(localQualitySessionRuntime1.apptype);
    paramString3.ckH = localQualitySessionRuntime1.han;
    paramString3.cic = localQualitySessionRuntime1.scene;
    paramString3.ax(localQualitySessionRuntime1.hao);
    paramString3.uV();
    paramString3.aw(paramString3.ckM - localQualitySessionRuntime1.hao);
    for (;;)
    {
      try
      {
        paramString3.bmf = paramString2.aad().getCurrentUrl();
        if (paramString2.fzH)
        {
          paramLong = 1L;
          paramString3.clH = paramLong;
          if (localQualitySessionRuntime1.har == null) {
            continue;
          }
          if (!localQualitySessionRuntime1.har.alH()) {
            continue;
          }
          paramLong = 1L;
          paramString3.clI = paramLong;
          if (!paramString2.aae().fzX) {
            break label422;
          }
          paramLong = 1L;
          paramString3.ckN = paramLong;
          paramString3.QX();
        }
      }
      catch (NullPointerException localNullPointerException)
      {
        y.e("MicroMsg.AppBrandQualitySystem", "launchToJsInject appId %s getCurrentUrl npe = %s", new Object[] { paramString1, localNullPointerException });
        continue;
        paramLong = 0L;
        continue;
        paramLong = 0L;
        continue;
        if (!com.tencent.mm.sdk.platformtools.d.DEBUG) {
          continue;
        }
        throw new IllegalStateException("StartupBundle not registered.");
      }
      label422:
      paramLong = 0L;
    }
  }
  
  public static void i(com.tencent.mm.plugin.appbrand.n paramn)
  {
    g.a(paramn.mAppId, new a.1(paramn));
  }
  
  public static QualitySessionRuntime wg(String paramString)
  {
    synchronized (gZS)
    {
      paramString = (QualitySessionRuntime)gZS.get(paramString);
      if (paramString != null) {
        return paramString;
      }
      if (com.tencent.mm.sdk.platformtools.d.DEBUG) {
        throw new IllegalStateException("QualitySession not open.");
      }
    }
    com.tencent.luggage.j.c.printErrStackTrace("MicroMsg.AppBrandQualitySystem", new Throwable(), "getSession returns null", new Object[0]);
    return paramString;
  }
  
  public static final class b
  {
    public volatile com.tencent.mm.plugin.appbrand.game.a.a fZD = com.tencent.mm.plugin.appbrand.game.a.a.fZG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.a
 * JD-Core Version:    0.7.0.1
 */