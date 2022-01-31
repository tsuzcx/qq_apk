package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import com.tencent.mm.h.b.a.an;
import com.tencent.mm.h.b.a.an.a;
import com.tencent.mm.h.b.a.an.b;
import com.tencent.mm.plugin.appbrand.b.c;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.file.al;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.f;
import com.tencent.mm.plugin.appbrand.jsapi.version.a.a;
import com.tencent.mm.plugin.appbrand.keepalive.b;
import com.tencent.mm.plugin.appbrand.keepalive.b.1;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchErrorAction;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.b;
import com.tencent.mm.plugin.appbrand.launching.AppStartupPerformanceReportBundle;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class n$2
  implements AppBrandPrepareTask.b
{
  n$2(n paramn, long paramLong, i.b paramb) {}
  
  public final void a(AppBrandSysConfigWC paramAppBrandSysConfigWC, AppBrandLaunchErrorAction paramAppBrandLaunchErrorAction, AppStartupPerformanceReportBundle paramAppStartupPerformanceReportBundle)
  {
    y.i("MicroMsg.AppBrandRuntimeWC", "AppBrandPrepareTask.onPrepareDone %s", new Object[] { this.fzM.mAppId });
    if (this.fzM.aai().isFinishing()) {
      return;
    }
    com.tencent.mm.plugin.appbrand.report.quality.a.aov();
    Object localObject1 = this.fzM.mAppId;
    if (paramAppStartupPerformanceReportBundle == null) {
      y.i("MicroMsg.AppBrandQualitySystem", "reportAppStartupPerformanceReportBundle, but bundle == null");
    }
    while (paramAppBrandSysConfigWC == null)
    {
      this.fzM.aai().runOnUiThread(new n.2.1(this, paramAppBrandLaunchErrorAction));
      f.b(this.fzM.mAppId, this.fzM.ZF(), this.fzM.aab());
      return;
      localObject1 = com.tencent.mm.plugin.appbrand.report.quality.a.wg((String)localObject1);
      if (localObject1 != null)
      {
        Iterator localIterator = paramAppStartupPerformanceReportBundle.gKk.iterator();
        Object localObject2;
        while (localIterator.hasNext())
        {
          localObject2 = (kv_14609)localIterator.next();
          ((kv_14609)localObject2).gKi = ((QualitySession)localObject1).gKi;
          ((kv_14609)localObject2).wn();
        }
        localIterator = paramAppStartupPerformanceReportBundle.gKj.iterator();
        while (localIterator.hasNext())
        {
          localObject2 = (an)localIterator.next();
          ((an)localObject2).ckG = ((QualitySession)localObject1).appId;
          ((an)localObject2).ckF = ((QualitySession)localObject1).gKi;
          ((an)localObject2).cnM = an.a.eQ(((QualitySession)localObject1).ham);
          ((an)localObject2).cnN = an.b.eR(((QualitySession)localObject1).apptype);
          ((an)localObject2).cic = ((QualitySession)localObject1).scene;
          ((an)localObject2).ckH = ((QualitySession)localObject1).han;
          ((an)localObject2).QX();
        }
      }
    }
    paramAppBrandSysConfigWC.bJw = paramAppBrandSysConfigWC.bJw;
    paramAppBrandSysConfigWC.appId = paramAppBrandSysConfigWC.appId;
    paramAppBrandSysConfigWC.fPM = paramAppBrandSysConfigWC.fPM;
    paramAppBrandSysConfigWC.fPN = paramAppBrandSysConfigWC.fPN;
    paramAppBrandSysConfigWC.fPO = paramAppBrandSysConfigWC.fPO;
    paramAppBrandSysConfigWC.fPQ = paramAppBrandSysConfigWC.fPQ;
    paramAppBrandSysConfigWC.fPR = paramAppBrandSysConfigWC.fPR;
    paramAppBrandSysConfigWC.fPS = paramAppBrandSysConfigWC.fPS;
    paramAppBrandSysConfigWC.fPP = paramAppBrandSysConfigWC.fPP;
    this.fzM.fyu.add(paramAppBrandSysConfigWC);
    this.fzM.fyu.add(paramAppStartupPerformanceReportBundle);
    com.tencent.mm.plugin.appbrand.report.quality.a.a(this.fzM.mAppId, paramAppBrandSysConfigWC, paramAppStartupPerformanceReportBundle, this.fzM);
    n.c(this.fzM).n(1, System.currentTimeMillis() - this.eow);
    com.tencent.mm.plugin.appbrand.performance.a.a(this.fzM.mAppId, "ResourcePrepare", this.eow, System.currentTimeMillis());
    paramAppBrandLaunchErrorAction = this.fzM;
    paramAppStartupPerformanceReportBundle = n.d(this.fzM);
    paramAppBrandLaunchErrorAction.fyu.add(paramAppStartupPerformanceReportBundle);
    n.a(this.fzM, new com.tencent.mm.plugin.appbrand.permission.d(this.fzM));
    n.a(this.fzM, new al(this.fzM, com.tencent.mm.plugin.appbrand.config.d.a(paramAppBrandSysConfigWC)));
    n.e(this.fzM);
    paramAppBrandSysConfigWC = b.gIO;
    paramAppBrandLaunchErrorAction = this.fzM.aai();
    paramAppStartupPerformanceReportBundle = this.fzM;
    y.i("MicroMsg.AppBrandKeepAliveManager", "set up contextUIName:%s", new Object[] { paramAppBrandLaunchErrorAction.getClass().getName() });
    paramAppStartupPerformanceReportBundle.fyy.a(new b.1(paramAppBrandSysConfigWC));
    if (paramAppBrandSysConfigWC.gIP != null) {
      y.i("MicroMsg.AppBrandKeepAliveManager", "already set up mAppBrandUIClassName");
    }
    for (;;)
    {
      this.fzM.aai().runOnUiThread(new n.2.2(this));
      return;
      paramAppBrandSysConfigWC.gIP = paramAppBrandLaunchErrorAction.getClass().getName();
    }
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.version.a parama)
  {
    this.fzM.s(new Runnable()
    {
      public final void run()
      {
        com.tencent.mm.plugin.appbrand.jsapi.version.a locala = parama;
        p localp = n.2.this.fzM.aae();
        y.i("MicroMsg.AppBrand.Version.UpdateState[appversion]", "dispatch(%s), service %s", new Object[] { locala.gCF, localp });
        if (localp == null) {
          return;
        }
        HashMap localHashMap = new HashMap(1);
        localHashMap.put("state", locala.gCF);
        new a.a((byte)0).d(localp).o(localHashMap).dispatch();
      }
    });
  }
  
  public final void iG(long paramLong)
  {
    this.fzM.fzH = true;
    if (n.g(this.fzM) != null) {
      n.g(this.fzM).gZt = true;
    }
  }
  
  public final void ko(int paramInt)
  {
    y.i("MicroMsg.AppBrandRuntimeWC", "onDownloadProgress %d", new Object[] { Integer.valueOf(paramInt) });
    n localn = this.fzM;
    localn.getContext().runOnUiThread(new i.10(localn, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.2
 * JD-Core Version:    0.7.0.1
 */