package com.tencent.mm.plugin.appbrand.ui.banner;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class AppBrandStickyBannerLogic$a
{
  private static final AppBrandStickyBannerLogic.Watcher iQX;
  private static final Set<f> iQY;
  private static final HashMap<String, Boolean> iQZ;
  private static final HashMap<String, f> iRa;
  private static final c iRb;
  private static final Map<String, String> iRc;
  
  static
  {
    AppMethodBeat.i(133287);
    iQX = new AppBrandStickyBannerLogic.Watcher();
    iQY = new HashSet();
    iQZ = new HashMap();
    iRa = new HashMap();
    iRb = new c();
    iRc = new HashMap();
    AppMethodBeat.o(133287);
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(133281);
    if (bo.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(133281);
      return;
    }
    if (paramContext == null) {
      paramContext = ah.getContext();
    }
    for (;;)
    {
      Intent localIntent = new Intent().setClassName(paramContext, "com.tencent.mm.ui.LauncherUI").addFlags(268435456).addFlags(67108864).addFlags(536870912);
      synchronized (iRc)
      {
        String str = (String)iRc.get(paramString1);
        b.a(localIntent, paramString1, paramInt, paramString2, paramString3, bo.nullAsNil(str));
        paramContext.startActivity(localIntent);
        if (!(paramContext instanceof Activity)) {}
      }
      AppMethodBeat.o(133281);
      return;
    }
  }
  
  public static boolean aMM()
  {
    AppMethodBeat.i(133282);
    AppBrandStickyBannerLogic.access$200();
    AppMethodBeat.o(133282);
    return false;
  }
  
  static void bx(String paramString, int paramInt)
  {
    AppMethodBeat.i(133280);
    synchronized (iQY)
    {
      Iterator localIterator = iQY.iterator();
      if (localIterator.hasNext()) {
        ((f)localIterator.next()).bf(paramString, paramInt);
      }
    }
    AppMethodBeat.o(133280);
  }
  
  public static void c(f paramf)
  {
    AppMethodBeat.i(133283);
    if (paramf != null) {
      synchronized (iQY)
      {
        iQY.remove(paramf);
        AppMethodBeat.o(133283);
        return;
      }
    }
    AppMethodBeat.o(133283);
  }
  
  public static void cV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(133286);
    if (bo.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(133286);
      return;
    }
    synchronized (iRc)
    {
      iRc.put(paramString1, bo.nullAsNil(paramString2));
      ??? = a.xM(paramString1);
      if (??? == null)
      {
        AppMethodBeat.o(133286);
        return;
      }
    }
    AppBrandMainProcessService.a(AppBrandStickyBannerLogic.OperateTask.o(paramString1, ((h)???).hiX.gXe, paramString2));
    AppMethodBeat.o(133286);
  }
  
  public static void d(f paramf)
  {
    AppMethodBeat.i(133284);
    iQX.iRg = ah.getProcessName();
    AppBrandMainProcessService.a(iQX);
    if (paramf != null) {
      synchronized (iQY)
      {
        iQY.add(paramf);
        AppMethodBeat.o(133284);
        return;
      }
    }
    AppMethodBeat.o(133284);
  }
  
  public static void release(String paramString)
  {
    AppMethodBeat.i(133285);
    iQZ.remove(paramString);
    ab.i("MicroMsg.AppBrandStickyBannerLogic", "release(%s)", new Object[] { paramString });
    AppMethodBeat.o(133285);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a
 * JD-Core Version:    0.7.0.1
 */