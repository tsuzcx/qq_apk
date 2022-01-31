package com.tencent.mm.plugin.appbrand.performance;

import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.g.c;

final class AppBrandPerformanceManager$a$3
  extends g.b
{
  AppBrandPerformanceManager$a$3(AppBrandPerformanceManager.a parama) {}
  
  public final void a(g.c paramc)
  {
    super.a(paramc);
    paramc = this.gWk;
    paramc.sn = true;
    if ((AppBrandPerformanceManager.a.anF()) && (paramc.gWh != null)) {
      paramc.gWh.sn = true;
    }
  }
  
  public final void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.gWk;
    ((AppBrandPerformanceManager.a)localObject).IL = false;
    g.b(((AppBrandPerformanceManager.a)localObject).mAppId, ((AppBrandPerformanceManager.a)localObject).gWj);
    if ((AppBrandPerformanceManager.a.anF()) && (((AppBrandPerformanceManager.a)localObject).gWh != null))
    {
      localObject = ((AppBrandPerformanceManager.a)localObject).gWh;
      ((d)localObject).IL = false;
      ((d)localObject).mFrameStartTime = 0L;
      ((d)localObject).gWy = 0;
      ((d)localObject).brd.removeFrameCallback((Choreographer.FrameCallback)localObject);
    }
  }
  
  public final void onResume()
  {
    super.onResume();
    AppBrandPerformanceManager.a locala = this.gWk;
    locala.sn = false;
    if ((AppBrandPerformanceManager.a.anF()) && (locala.gWh != null)) {
      locala.gWh.sn = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager.a.3
 * JD-Core Version:    0.7.0.1
 */