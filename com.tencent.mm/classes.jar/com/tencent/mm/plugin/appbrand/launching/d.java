package com.tencent.mm.plugin.appbrand.launching;

import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mm.h.a.it;
import com.tencent.mm.h.a.up;
import com.tencent.mm.h.a.uq;
import com.tencent.mm.h.b.a.an;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.m;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.d;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.plugin.appbrand.l.f;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.protocal.c.atg;
import com.tencent.mm.protocal.c.pc;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.vending.j.b;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public final class d
  implements ILaunchWxaAppInfoNotify
{
  private static final android.support.v4.f.a<String, d> gJQ = new android.support.v4.f.a();
  static final com.tencent.mm.vending.j.d<AppBrandSysConfigWC, AppBrandLaunchErrorAction, AppStartupPerformanceReportBundle> gKe = com.tencent.mm.vending.j.a.d(null, null, null);
  final String appId;
  final int caB;
  final int fJy;
  final QualitySession fPC;
  final String fPq;
  final AppBrandLaunchReferrer fPr;
  volatile d.b gJR;
  volatile com.tencent.mm.vending.j.d<AppBrandSysConfigWC, AppBrandLaunchErrorAction, AppStartupPerformanceReportBundle> gJS;
  volatile long gJT = -1L;
  final int gJU;
  final String gJV;
  final int gJW;
  volatile WxaAttributes.d gJX;
  final AppStartupPerformanceReportBundle gJY;
  final List<kv_14609> gJZ = new CopyOnWriteArrayList();
  final com.tencent.mm.sdk.b.c<it> gKa = new com.tencent.mm.sdk.b.c() {};
  final List<an> gKb = new CopyOnWriteArrayList();
  final com.tencent.mm.sdk.b.c<up> gKc = new d.2(this);
  final com.tencent.mm.sdk.b.c<uq> gKd = new d.3(this);
  volatile boolean started;
  
  public d(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    this(paramAppBrandInitConfigWC.appId, paramAppBrandInitConfigWC.fEL, paramAppBrandStatObject.caB, paramAppBrandStatObject.scene, paramAppBrandInitConfigWC.fPq, paramAppBrandInitConfigWC.fPr, paramAppBrandInitConfigWC.fJO, -1, paramAppBrandInitConfigWC.fPC);
    if (paramAppBrandInitConfigWC.ZH()) {
      m.qT(paramAppBrandInitConfigWC.appId);
    }
  }
  
  public d(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, AppBrandLaunchReferrer paramAppBrandLaunchReferrer, String paramString3, int paramInt4, QualitySession paramQualitySession)
  {
    this.appId = paramString1;
    this.fJy = paramInt1;
    this.caB = paramInt2;
    this.gJU = paramInt3;
    this.fPq = paramString2;
    this.fPr = paramAppBrandLaunchReferrer;
    this.gJV = paramString3;
    this.gJW = paramInt4;
    this.fPC = paramQualitySession;
    this.gJY = new AppStartupPerformanceReportBundle(paramQualitySession.gKi);
  }
  
  static d uR(String paramString)
  {
    synchronized (gJQ)
    {
      d locald = (d)gJQ.remove(paramString);
      if (locald != null) {
        y.d("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "pollProcess appId(%s) type(%d) sessionId(%s)", new Object[] { locald.appId, Integer.valueOf(locald.fJy), paramString });
      }
      return locald;
    }
  }
  
  static d uS(String paramString)
  {
    synchronized (gJQ)
    {
      paramString = (d)gJQ.get(paramString);
      return paramString;
    }
  }
  
  final void a(com.tencent.mm.vending.j.d<AppBrandSysConfigWC, AppBrandLaunchErrorAction, AppStartupPerformanceReportBundle> paramd)
  {
    this.gJS = paramd;
    if (this.gJR != null)
    {
      this.gJR.b((AppBrandSysConfigWC)paramd.get(0), (AppBrandLaunchErrorAction)paramd.get(1), (AppStartupPerformanceReportBundle)paramd.get(2));
      uR(this.gJV);
    }
  }
  
  public final void a(String paramString1, int paramInt, String paramString2, t paramt)
  {
    if (this.gJS != null)
    {
      paramString2 = AppBrandLaunchErrorAction.CREATOR;
      paramString2 = AppBrandLaunchErrorAction.a.a(this.appId, this.fJy, paramt);
      if (paramString2 != null) {
        this.gJS = com.tencent.mm.vending.j.a.d(null, paramString2, this.gJY);
      }
    }
    else
    {
      return;
    }
    paramString2 = (AppBrandSysConfigWC)this.gJS.get(0);
    if (paramString2 == null)
    {
      y.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "notifyLaunchInfoUpdate null config with appId(%s)", new Object[] { paramString1 });
      return;
    }
    paramt.b(paramString2);
    this.gJS = com.tencent.mm.vending.j.a.d(paramString2, null, this.gJY);
  }
  
  public final void alD()
  {
    if (this.started) {
      return;
    }
    this.started = true;
    y.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[applaunch] startPrepare in mm %s %d", new Object[] { this.appId, Integer.valueOf(this.fJy) });
    synchronized (gJQ)
    {
      gJQ.put(this.gJV, this);
      ??? = new a(this.gJV);
      long l = TimeUnit.SECONDS.toMillis(300L);
      ((am)???).S(l, l);
      ??? = com.tencent.mm.sdk.f.e.aap(String.format(Locale.US, "AppLaunchPrepareProcess[%s %d]", new Object[] { this.appId, Integer.valueOf(this.fJy) }));
      ((HandlerThread)???).start();
      new ah(((HandlerThread)???).getLooper()).post(new Runnable()
      {
        public final void run()
        {
          AppBrandSysConfigWC localAppBrandSysConfigWC;
          label78:
          int i;
          try
          {
            d locald1 = d.this;
            localObject1 = d.this;
            localAppBrandSysConfigWC = r.ss(((d)localObject1).appId);
            if (localAppBrandSysConfigWC == null) {
              x.uV(com.tencent.mm.plugin.appbrand.v.c.getMMString(y.j.app_brand_preparing_attr_sync_timeout, new Object[] { "" }));
            }
            if (localAppBrandSysConfigWC != null) {
              break label78;
            }
            y.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "get null config!!!");
            localObject1 = d.gKe;
            d.a(locald1, (com.tencent.mm.vending.j.d)localObject1);
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Object localObject1;
              com.tencent.mm.plugin.appbrand.u.k localk;
              y.printErrStackTrace("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", localException, "call() exp ", new Object[0]);
              x.lO(y.j.app_brand_launching_failed);
              d.a(d.this, d.alF());
              continue;
              localObject5 = AppBrandLaunchErrorAction.CREATOR;
              localObject5 = AppBrandLaunchErrorAction.a.a((String)localObject2, localException.fJy, (t)localObject4);
              if (localObject5 != null)
              {
                localk.value = localObject5;
                y.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig username %s, launch ban code %d", new Object[] { localAppBrandSysConfigWC.bFn, Integer.valueOf(((t)localObject4).field_launchAction.ssy) });
                i = 0;
              }
              else
              {
                localException.gJY.gKl = ((t)localObject4).gLa;
                if ((((t)localObject4).field_jsapiInfo != null) && (((t)localObject4).field_jsapiInfo.sMN != null)) {
                  break;
                }
                y.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig username %s, get null jsapi_info", new Object[] { localAppBrandSysConfigWC.bFn });
                i = 0;
              }
            }
            ((t)localObject4).b(localAppBrandSysConfigWC);
            if (!((t)localObject4).field_launchAction.toM) {
              break label733;
            }
          }
          this.gKg.quit();
          return;
          ((com.tencent.mm.plugin.appbrand.appusage.k)com.tencent.mm.plugin.appbrand.app.e.G(com.tencent.mm.plugin.appbrand.appusage.k.class)).v(r.sx(((d)localObject1).appId), bk.UX());
          localk = new com.tencent.mm.plugin.appbrand.u.k();
          Object localObject2 = localAppBrandSysConfigWC.appId;
          String str = localAppBrandSysConfigWC.bFn;
          Object localObject3 = com.tencent.mm.plugin.appbrand.app.e.aaT().e((String)localObject2, new String[] { "versionInfo" });
          ((d)localObject1).gKa.cqo();
          if (((d)localObject1).fJy == 0) {
            ((d)localObject1).gKc.cqo();
          }
          for (;;)
          {
            ((d)localObject1).gJX = ((WxaAttributes)localObject3).aep();
            Object localObject4 = new d.5((d)localObject1, localAppBrandSysConfigWC.appId, ((d)localObject1).fJy, ((d)localObject1).fPq, ((d)localObject1).gJU, ((WxaAttributes)localObject3).aep());
            localObject3 = new FutureTask((Callable)localObject4);
            com.tencent.mm.sdk.f.e.a(new w.1((w)localObject4, (FutureTask)localObject3));
            com.tencent.mm.sdk.f.e.post((Runnable)localObject3, ((w)localObject4).getTag());
            localObject4 = (t)new aa((String)localObject2, ((d)localObject1).fJy, ((d)localObject1).caB, ((d)localObject1).gJU, ((d)localObject1).fPq, ((d)localObject1).fPr, ((d)localObject1).gJV, ((d)localObject1).gJW, ((d)localObject1).fPC).alN();
            if (localObject4 == null)
            {
              y.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig username %s, get null launchInfo", new Object[] { localAppBrandSysConfigWC.bFn });
              i = 0;
              if (i != 0) {
                break label1047;
              }
              y.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig, false, username %s, appId %s", new Object[] { localAppBrandSysConfigWC.bFn, localAppBrandSysConfigWC.appId });
              localObject1 = com.tencent.mm.vending.j.a.d(null, localk.value, ((d)localObject1).gJY);
              break;
              ((d)localObject1).gKd.cqo();
              continue;
            }
            Object localObject5;
            g.r(com.tencent.mm.plugin.appbrand.widget.recentview.d.class);
            if (g.DP().Dz().getBoolean(ac.a.uth, false)) {
              break label1091;
            }
          }
          label1047:
          label1091:
          for (boolean bool = true;; bool = false)
          {
            localAppBrandSysConfigWC.fPU = bool;
            g.DP().Dz().c(ac.a.uth, Boolean.valueOf(true));
            for (;;)
            {
              localObject3 = (WxaPkgWrappingInfo)((Future)localObject3).get();
              localException.gKa.dead();
              localException.gKc.dead();
              localException.gKd.dead();
              localException.gJY.gKj.addAll(localException.gKb);
              localException.gJY.gKk.addAll(localException.gJZ);
              if (localObject3 != null) {
                break label742;
              }
              y.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig null app pkg, username %s appId %s", new Object[] { localAppBrandSysConfigWC.bFn, localAppBrandSysConfigWC.appId });
              i = 0;
              break;
              label733:
              localAppBrandSysConfigWC.fPU = false;
            }
            label742:
            localAppBrandSysConfigWC.fPS.a((WxaPkgWrappingInfo)localObject3);
            if (localAppBrandSysConfigWC.fPS.fEM != 0) {
              localAppBrandSysConfigWC.fPS.fEN = 0;
            }
            y.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig username %s, appId %s, app pkg %s", new Object[] { localAppBrandSysConfigWC.bFn, localAppBrandSysConfigWC.appId, localAppBrandSysConfigWC.fPS });
            localAppBrandSysConfigWC.fQq = AppBrandGlobalSystemConfig.aec();
            localAppBrandSysConfigWC.fQr = com.tencent.mm.plugin.appbrand.app.e.aaY().get("key_sendtodesktop_no_more_show_permission_notify_dialog", "0").equals("1");
            localObject3 = com.tencent.mm.plugin.appbrand.app.e.aaT().d(localAppBrandSysConfigWC.bFn, new String[] { "roundedSquareIconURL", "brandIconURL", "bigHeadURL", "appId", "nickname" });
            if (localObject3 != null)
            {
              localAppBrandSysConfigWC.bHW = new String[] { ((WxaAttributes)localObject3).field_roundedSquareIconURL, ((WxaAttributes)localObject3).field_brandIconURL, ((WxaAttributes)localObject3).field_bigHeadURL };
              localAppBrandSysConfigWC.nickname = ((WxaAttributes)localObject3).field_nickname;
            }
            localObject3 = f.gPZ;
            localObject2 = f.bU((String)localObject2, "copypath");
            if (localObject2 == null) {}
            for (long l = 0L;; l = ((Long)localObject2).longValue())
            {
              localAppBrandSysConfigWC.fQp = l;
              y.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "copyPathMenuShowExpireTime = " + localAppBrandSysConfigWC.fQp);
              com.tencent.mm.sdk.f.e.post(new d.6(localException, str), "AppLaunchPrepareProcess#ExtraWorks");
              y.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig ok username %s, appId %s", new Object[] { localAppBrandSysConfigWC.bFn, localAppBrandSysConfigWC.appId });
              i = 1;
              break;
            }
            y.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "prepare ok, just go weapp, username %s, appId %s", new Object[] { localAppBrandSysConfigWC.bFn, localAppBrandSysConfigWC.appId });
            com.tencent.mm.vending.j.d locald = com.tencent.mm.vending.j.a.d(localAppBrandSysConfigWC, null, localException.gJY);
            break;
          }
        }
      });
      return;
    }
  }
  
  private static final class a
    extends am
  {
    public a(String paramString)
    {
      super(new d.a.1(paramString), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.d
 * JD-Core Version:    0.7.0.1
 */