package com.tencent.mm.plugin.appbrand.performance;

import android.os.Build.VERSION;
import android.os.Process;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.game.j;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.storage.JsApiGetStorageInfoTask;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.page.k;
import com.tencent.mm.plugin.appbrand.page.o;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class AppBrandPerformanceManager$a
  implements Runnable
{
  volatile boolean IL = true;
  private volatile double gWc = 0.0D;
  private volatile int gWd = 4;
  volatile boolean gWe = false;
  private volatile boolean gWf = false;
  private c gWg;
  d gWh;
  d.a gWi = new AppBrandPerformanceManager.a.2(this);
  g.b gWj = new AppBrandPerformanceManager.a.3(this);
  final String mAppId;
  volatile boolean sn = false;
  
  public AppBrandPerformanceManager$a(String paramString)
  {
    this.mAppId = paramString;
    this.gWg = new c(Process.myPid());
    paramString = com.tencent.mm.plugin.appbrand.a.qn(paramString);
    if ((paramString != null) && (paramString.ZH())) {
      this.gWf = true;
    }
    if (anF())
    {
      this.gWh = new d();
      this.gWh.mInterval = 100L;
      this.gWh.gWi = this.gWi;
    }
  }
  
  static boolean anF()
  {
    return Build.VERSION.SDK_INT >= 16;
  }
  
  private com.tencent.mm.plugin.appbrand.game.c.f anG()
  {
    try
    {
      Object localObject1 = com.tencent.mm.plugin.appbrand.a.qn(this.mAppId).aad().getCurrentPage().getCurrentPageView();
      if ((localObject1 instanceof com.tencent.mm.plugin.appbrand.game.page.f))
      {
        localObject1 = ((com.tencent.mm.plugin.appbrand.game.page.f)localObject1).gcy.getMBRenderer();
        if ((localObject1 != null) && (((com.tencent.mm.plugin.appbrand.game.a)localObject1).fZC != null)) {
          break label73;
        }
        y.e("MicroMsg.AppBrandPerformanceManager", "buildWAGameQualityEvent find renderer.fps == null");
        return null;
      }
    }
    catch (Exception localException)
    {
      Object localObject2;
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.AppBrandPerformanceManager", localException, "get QualityEvent of WAGame but fail.", new Object[0]);
        localObject2 = null;
      }
      label73:
      return localObject2.fZC;
    }
  }
  
  public final void run()
  {
    Object localObject;
    if ((this.IL) && (!this.sn))
    {
      double d = this.gWg.anI();
      AppBrandPerformanceManager.m(this.mAppId, 101, (int)d + "%");
      a.a(this.mAppId, "Hardware", "CPU", d);
      i = bk.fZ(((h)com.tencent.mm.kernel.g.DM().Dr()).bT);
      AppBrandPerformanceManager.m(this.mAppId, 102, i + "m");
      a.a(this.mAppId, "Hardware", "MEMORY", i);
      if (this.gWf)
      {
        localObject = com.tencent.mm.plugin.appbrand.report.quality.a.wg(this.mAppId);
        if (localObject == null) {
          break label332;
        }
      }
    }
    label332:
    for (int i = bk.fZ(((h)com.tencent.mm.kernel.g.DM().Dr()).bT) - ((QualitySessionRuntime)localObject).has;; i = 2147483647)
    {
      if (i != 2147483647) {
        AppBrandPerformanceManager.m(this.mAppId, 103, i + "m");
      }
      if (this.gWf)
      {
        localObject = anG();
        if (localObject != null)
        {
          a.a(this.mAppId, "Hardware", "FPS_GAME_RT", ((com.tencent.mm.plugin.appbrand.game.c.f)localObject).gbN);
          a.a(this.mAppId, "Hardware", "FPS_GAME_EX", ((com.tencent.mm.plugin.appbrand.game.c.f)localObject).gbV);
        }
      }
      this.gWd += 1;
      if (this.gWd >= 4)
      {
        this.gWd = 0;
        localObject = new JsApiGetStorageInfoTask();
        ((JsApiGetStorageInfoTask)localObject).appId = this.mAppId;
        ((JsApiGetStorageInfoTask)localObject).gfD = new AppBrandPerformanceManager.a.1(this, (JsApiGetStorageInfoTask)localObject);
        ((JsApiGetStorageInfoTask)localObject).ahC();
        AppBrandMainProcessService.a((MainProcessTask)localObject);
      }
      if (this.IL) {
        com.tencent.mm.plugin.appbrand.v.c.DS().k(this, 3000L);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager.a
 * JD-Core Version:    0.7.0.1
 */