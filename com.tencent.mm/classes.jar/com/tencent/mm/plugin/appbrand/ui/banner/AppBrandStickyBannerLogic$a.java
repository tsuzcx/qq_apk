package com.tencent.mm.plugin.appbrand.ui.banner;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class AppBrandStickyBannerLogic$a
{
  private static final AppBrandStickyBannerLogic.Watcher hfJ = new AppBrandStickyBannerLogic.Watcher();
  private static final Set<f> hfK = new HashSet();
  private static final HashMap<String, Boolean> hfL = new HashMap();
  private static final HashMap<String, f> hfM = new HashMap();
  private static final c hfN = new c();
  private static final Map<String, String> hfO = new HashMap();
  
  public static void a(Context paramContext, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (bk.bl(paramString1)) {
      return;
    }
    if (paramContext == null) {
      paramContext = ae.getContext();
    }
    for (;;)
    {
      for (;;)
      {
        Intent localIntent = new Intent().setClassName(paramContext, "com.tencent.mm.ui.LauncherUI").addFlags(268435456).addFlags(67108864).addFlags(536870912);
        synchronized (hfO)
        {
          String str = (String)hfO.get(paramString1);
          b.a(localIntent, paramString1, paramInt, paramString2, paramString3, bk.pm(str));
          paramContext.startActivity(localIntent);
          if (!(paramContext instanceof Activity)) {
            break;
          }
          try
          {
            ((Activity)paramContext).moveTaskToBack(false);
            return;
          }
          catch (Exception paramContext)
          {
            y.e("MicroMsg.AppBrandStickyBannerLogic.ClientLogic", "stickOnChatting e = %s", new Object[] { paramContext.getMessage() });
            return;
          }
        }
      }
    }
  }
  
  public static boolean apw()
  {
    AppBrandStickyBannerLogic.access$200();
    return false;
  }
  
  static void bc(String paramString, int paramInt)
  {
    synchronized (hfK)
    {
      Iterator localIterator = hfK.iterator();
      if (localIterator.hasNext()) {
        ((f)localIterator.next()).aP(paramString, paramInt);
      }
    }
  }
  
  public static void c(f paramf)
  {
    if (paramf != null) {
      synchronized (hfK)
      {
        hfK.remove(paramf);
        return;
      }
    }
  }
  
  public static void cg(String paramString1, String paramString2)
  {
    if (bk.bl(paramString1)) {}
    for (;;)
    {
      return;
      synchronized (hfO)
      {
        hfO.put(paramString1, bk.pm(paramString2));
        ??? = a.qo(paramString1);
        if (??? == null) {
          continue;
        }
        AppBrandMainProcessService.a(AppBrandStickyBannerLogic.OperateTask.o(paramString1, ((AppBrandSysConfigWC)???).fPS.fEM, paramString2));
        return;
      }
    }
  }
  
  public static void d(f paramf)
  {
    hfJ.hfS = ae.getProcessName();
    AppBrandMainProcessService.a(hfJ);
    if (paramf != null) {
      synchronized (hfK)
      {
        hfK.add(paramf);
        return;
      }
    }
  }
  
  public static void wz(String paramString)
  {
    hfL.remove(paramString);
    y.i("MicroMsg.AppBrandStickyBannerLogic", "release(%s)", new Object[] { paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a
 * JD-Core Version:    0.7.0.1
 */