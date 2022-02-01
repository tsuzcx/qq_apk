package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.luggage.l.m;
import com.tencent.luggage.m.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.bj;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.f;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.g;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.h;
import com.tencent.mm.plugin.appbrand.config.z;
import com.tencent.mm.plugin.appbrand.page.capsulebar.BaseAppBrandSingleCloseCapsuleBar;
import com.tencent.mm.plugin.appbrand.page.f;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.y;

public final class h
{
  private static final ThreadLocal<Boolean> ubh;
  private static final androidx.b.a<AppBrandRuntime, Bitmap> ubi;
  
  static
  {
    AppMethodBeat.i(48662);
    ubh = new ThreadLocal() {};
    ubi = new androidx.b.a();
    AppMethodBeat.o(48662);
  }
  
  private static AppBrandUILoadingSplash a(Context paramContext, w paramw, HalfScreenConfig.f paramf)
  {
    AppMethodBeat.i(322097);
    AppBrandUILoadingSplash localAppBrandUILoadingSplash = (AppBrandUILoadingSplash)paramw.ccx().a(AppBrandUILoadingSplash.class, paramContext);
    if (localAppBrandUILoadingSplash != null)
    {
      localAppBrandUILoadingSplash.cLA();
      localAppBrandUILoadingSplash.setTheme(paramf);
      localAppBrandUILoadingSplash.aC(paramw);
      paramContext = localAppBrandUILoadingSplash;
    }
    for (;;)
    {
      AppMethodBeat.o(322097);
      return paramContext;
      paramContext = new AppBrandUILoadingSplash(fi(paramContext), paramw);
      paramContext.setTheme(paramf);
    }
  }
  
  public static ag a(Context paramContext, AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(322078);
    if (paramAppBrandInitConfigWC.aqE() == z.raW)
    {
      AppMethodBeat.o(322078);
      return null;
    }
    if (paramAppBrandInitConfigWC.qYd)
    {
      if (!TextUtils.isEmpty(m.fL(paramAppBrandInitConfigWC.qAF)))
      {
        AppMethodBeat.o(322078);
        return null;
      }
      if (!com.tencent.mm.plugin.appbrand.ui.b.a.b.cNh())
      {
        Log.i("MicroMsg.AppBrandLoadingSplashFactory", "createSnapshotDisplayLoadingSplash but switch off, appId:%s", new Object[] { paramAppBrandInitConfigWC.appId });
        AppMethodBeat.o(322078);
        return null;
      }
      String str = paramAppBrandInitConfigWC.qYq;
      if (y.ZC(str))
      {
        Log.i("MicroMsg.AppBrandLoadingSplashFactory", "createScreenshotSplash with appId:%s, path:%s", new Object[] { paramAppBrandInitConfigWC.appId, str });
        paramAppBrandInitConfigWC = BitmapUtil.decodeFile(str);
        if ((paramAppBrandInitConfigWC != null) && (!paramAppBrandInitConfigWC.isRecycled()))
        {
          paramContext = new ag(paramContext, paramAppBrandInitConfigWC);
          AppMethodBeat.o(322078);
          return paramContext;
        }
      }
      AppMethodBeat.o(322078);
      return null;
    }
    AppMethodBeat.o(322078);
    return null;
  }
  
  public static ah a(Context paramContext, w paramw)
  {
    AppMethodBeat.i(48659);
    Object localObject = (Bitmap)ubi.remove(paramw);
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
    {
      paramContext = new p(paramContext, (Bitmap)localObject);
      AppMethodBeat.o(48659);
      return paramContext;
    }
    localObject = a(paramContext, paramw.getInitConfig());
    if (localObject != null)
    {
      ((ag)localObject).setRuntime(paramw);
      AppMethodBeat.o(48659);
      return localObject;
    }
    if (paramw.getInitConfig().aqE() == z.raW)
    {
      paramContext = new ad(fi(paramContext));
      AppMethodBeat.o(48659);
      return paramContext;
    }
    if (com.tencent.mm.plugin.appbrand.weishi.h.aD(paramw))
    {
      paramContext = new com.tencent.mm.plugin.appbrand.weishi.b(fi(paramContext), paramw);
      AppMethodBeat.o(48659);
      return paramContext;
    }
    if ((t.aB(paramw)) || (bj.x(paramw)) || (paramw.ccX()))
    {
      HalfScreenConfig localHalfScreenConfig;
      if (paramw.aqJ())
      {
        localObject = new d(fi(paramContext), paramw, paramw.getInitConfig().epa);
        if (!paramw.ccX()) {
          break label349;
        }
        localHalfScreenConfig = paramw.getInitConfig().qAT;
        if (localHalfScreenConfig.qZR != HalfScreenConfig.h.raE) {
          break label336;
        }
        localObject = a(paramContext, paramw, localHalfScreenConfig.ckP());
        com.tencent.mm.plugin.appbrand.page.capsulebar.g localg = com.tencent.mm.plugin.appbrand.page.capsulebar.g.tCv;
        paramContext = com.tencent.mm.plugin.appbrand.page.capsulebar.g.a(paramw, fi(paramContext), true);
        paramContext.setTitle(paramw.getInitConfig().hEy);
        paramContext.setWxaIconUrl(paramw.getInitConfig().iconUrl);
        paramContext.setCloseBtnListener(new h.1(paramw));
        if (localHalfScreenConfig.rac == HalfScreenConfig.g.raA) {
          break label310;
        }
        ((AppBrandUILoadingSplash)localObject).setActionBar(paramContext);
      }
      for (;;)
      {
        ((AppBrandUILoadingSplash)localObject).MU(true);
        AppMethodBeat.o(48659);
        return localObject;
        localObject = new j(fi(paramContext), paramw, paramw.getInitConfig().epa);
        break;
        label310:
        paramContext = ((AppBrandUILoadingSplash)localObject).ufi.findViewById(a.d.app_brand_ui_loading_splash_action_bar);
        if (paramContext != null) {
          ((AppBrandUILoadingSplash)localObject).ufi.removeView(paramContext);
        }
      }
      label336:
      ((j)localObject).setBackButtonVisibility(localHalfScreenConfig.raa);
      ((j)localObject).MU(true);
      label349:
      AppMethodBeat.o(48659);
      return localObject;
    }
    if (paramw.aqJ())
    {
      localObject = new e(fi(paramContext), paramw);
      if (paramw.cbN())
      {
        paramContext = new a(fi(paramContext), paramw, (ah)localObject, paramw.qvJ);
        AppMethodBeat.o(48659);
        return paramContext;
      }
      AppMethodBeat.o(48659);
      return localObject;
    }
    localObject = a(paramContext, paramw, HalfScreenConfig.f.rav);
    ((AppBrandUILoadingSplash)localObject).setLabelInjector(new h.2(paramw));
    if (paramw.cbN())
    {
      paramContext = new a(fi(paramContext), paramw, (ah)localObject, paramw.qvJ);
      AppMethodBeat.o(48659);
      return paramContext;
    }
    AppMethodBeat.o(48659);
    return localObject;
  }
  
  public static void a(AppBrandRuntime paramAppBrandRuntime, Bitmap paramBitmap)
  {
    AppMethodBeat.i(48661);
    if ((paramAppBrandRuntime == null) || (paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(48661);
      return;
    }
    ubi.put(paramAppBrandRuntime, paramBitmap);
    AppMethodBeat.o(48661);
  }
  
  public static boolean cKV()
  {
    AppMethodBeat.i(161867);
    if (MMApplicationContext.isMainProcess())
    {
      AppMethodBeat.o(161867);
      return false;
    }
    boolean bool = ((Boolean)ubh.get()).booleanValue();
    AppMethodBeat.o(161867);
    return bool;
  }
  
  private static Context fi(Context paramContext)
  {
    AppMethodBeat.i(48660);
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = MMApplicationContext.getContext();
    }
    paramContext = localContext;
    if (cKV()) {
      paramContext = com.tencent.mm.plugin.appbrand.page.g.fa(localContext);
    }
    AppMethodBeat.o(48660);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.h
 * JD-Core Version:    0.7.0.1
 */