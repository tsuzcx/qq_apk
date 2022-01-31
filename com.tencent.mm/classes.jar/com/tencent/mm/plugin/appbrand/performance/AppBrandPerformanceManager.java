package com.tencent.mm.plugin.appbrand.performance;

import android.annotation.SuppressLint;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ui.j;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.Set;

@SuppressLint({"DefaultLocale"})
public final class AppBrandPerformanceManager
{
  private static SparseArray<AppBrandPerformanceManager.a> gWa = new SparseArray();
  
  public static final void E(String paramString1, String paramString2, String paramString3)
  {
    j localj = com.tencent.mm.plugin.appbrand.a.qq(paramString1);
    if (localj == null)
    {
      u.Hc().v(paramString1.hashCode() + "performance_custom_data", true).h(paramString2, paramString3);
      return;
    }
    localj.cf(paramString2, paramString3);
  }
  
  public static final void b(String paramString, int paramInt, long paramLong)
  {
    m(paramString, paramInt, String.format("%d ms", new Object[] { Long.valueOf(paramLong) }));
  }
  
  public static final void m(String paramString1, int paramInt, String paramString2)
  {
    j localj = com.tencent.mm.plugin.appbrand.a.qq(paramString1);
    if (localj == null)
    {
      u.Hc().v(paramString1.hashCode() + "performance_data", true).h(String.valueOf(paramInt), paramString2);
      return;
    }
    localj.P(paramInt, paramString2);
  }
  
  public static final void vP(String paramString)
  {
    y.d("MicroMsg.AppBrandPerformanceManager", "startMonitoring, appId: %s", new Object[] { paramString });
    AppBrandPerformanceManager.a locala2 = (AppBrandPerformanceManager.a)gWa.get(paramString.hashCode());
    AppBrandPerformanceManager.a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new AppBrandPerformanceManager.a(paramString);
      gWa.put(paramString.hashCode(), locala1);
    }
    locala1.IL = true;
    com.tencent.mm.plugin.appbrand.v.c.DS().O(locala1);
    g.a(locala1.mAppId, locala1.gWj);
    if ((AppBrandPerformanceManager.a.anF()) && (locala1.gWh != null)) {
      locala1.gWh.start();
    }
    if (!locala1.gWe)
    {
      paramString = new AppBrandPerformanceManager.GetPkgDownloadCostTask((byte)0);
      AppBrandPerformanceManager.GetPkgDownloadCostTask.a(paramString, locala1.mAppId);
      AppBrandMainProcessService.a(paramString);
      locala1.gWe = true;
    }
  }
  
  public static final void vQ(String paramString)
  {
    y.d("MicroMsg.AppBrandPerformanceManager", "enablePanel for AppId %s", new Object[] { paramString });
    AppBrandPerformanceManager.SetAppPerformanceModeTask localSetAppPerformanceModeTask = new AppBrandPerformanceManager.SetAppPerformanceModeTask((byte)0);
    AppBrandPerformanceManager.SetAppPerformanceModeTask.a(localSetAppPerformanceModeTask, paramString);
    AppBrandPerformanceManager.SetAppPerformanceModeTask.a(localSetAppPerformanceModeTask, true);
    AppBrandMainProcessService.a(localSetAppPerformanceModeTask);
  }
  
  public static final void vR(String paramString)
  {
    y.d("MicroMsg.AppBrandPerformanceManager", "disablePanel for AppId %s", new Object[] { paramString });
    AppBrandPerformanceManager.SetAppPerformanceModeTask localSetAppPerformanceModeTask = new AppBrandPerformanceManager.SetAppPerformanceModeTask((byte)0);
    AppBrandPerformanceManager.SetAppPerformanceModeTask.a(localSetAppPerformanceModeTask, paramString);
    AppBrandPerformanceManager.SetAppPerformanceModeTask.a(localSetAppPerformanceModeTask, false);
    AppBrandMainProcessService.a(localSetAppPerformanceModeTask);
  }
  
  public static final boolean vS(String paramString)
  {
    if (DebuggerShell.aeu()) {}
    do
    {
      return true;
      paramString = com.tencent.mm.plugin.appbrand.a.qo(paramString);
    } while ((paramString != null) && (paramString.fPT) && (paramString.fPS.fEM == 1));
    return false;
  }
  
  public static final void vT(String paramString)
  {
    j localj = com.tencent.mm.plugin.appbrand.a.qq(paramString);
    u.b localb = u.Hc().ii(paramString.hashCode() + "performance_data");
    if (localj == null) {
      y.e("MicroMsg.AppBrandPerformanceManager", "insertCachedPerformanceData panel is not ready.");
    }
    for (;;)
    {
      vU(paramString);
      return;
      if (localb == null)
      {
        y.d("MicroMsg.AppBrandPerformanceManager", "insertCachedPerformanceData cache is empty.");
      }
      else
      {
        Iterator localIterator = localb.dd().iterator();
        while (localIterator.hasNext())
        {
          String str1 = (String)localIterator.next();
          String str2 = (String)localb.get(str1);
          if (str2 != null) {
            localj.P(Integer.valueOf(str1).intValue(), str2);
          }
        }
      }
    }
  }
  
  private static final void vU(String paramString)
  {
    j localj = com.tencent.mm.plugin.appbrand.a.qq(paramString);
    paramString = u.Hc().ii(paramString.hashCode() + "performance_custom_data");
    if (localj == null) {
      y.e("MicroMsg.AppBrandPerformanceManager", "insertCachedCustomData panel is not ready.");
    }
    for (;;)
    {
      return;
      if (paramString == null)
      {
        y.d("MicroMsg.AppBrandPerformanceManager", "insertCachedCustomData cache is empty.");
        return;
      }
      Iterator localIterator = paramString.dd().iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = (String)paramString.get(str1);
        if (str2 != null) {
          localj.cf(str1, str2);
        }
      }
    }
  }
  
  public static final void w(String paramString, long paramLong)
  {
    e.aaY().bi(paramString + "_PkgDownloadCost", String.valueOf(paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager
 * JD-Core Version:    0.7.0.1
 */