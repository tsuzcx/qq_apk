package com.tencent.mm.plugin.appbrand.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import com.tencent.luggage.k.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ag.g;
import com.tencent.mm.plugin.appbrand.au.f;
import com.tencent.mm.plugin.appbrand.au.g;
import com.tencent.mm.plugin.appbrand.au.h;
import com.tencent.mm.plugin.appbrand.bd;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.f;
import com.tencent.mm.plugin.appbrand.page.capsulebar.AppBrandSingleCloseCapsuleBar;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ar;
import com.tencent.mm.vfs.u;

public final class i
{
  private static final androidx.b.a<AppBrandRuntime, Bitmap> qVC;
  
  static
  {
    AppMethodBeat.i(48662);
    qVC = new androidx.b.a();
    AppMethodBeat.o(48662);
  }
  
  private static AppBrandUILoadingSplash a(Context paramContext, t paramt, boolean paramBoolean)
  {
    AppMethodBeat.i(266790);
    AppBrandUILoadingSplash localAppBrandUILoadingSplash = (AppBrandUILoadingSplash)paramt.bDh().a(AppBrandUILoadingSplash.class, paramContext);
    if (localAppBrandUILoadingSplash != null)
    {
      localAppBrandUILoadingSplash.jM(paramBoolean);
      localAppBrandUILoadingSplash.ao(paramt);
      paramContext = localAppBrandUILoadingSplash;
    }
    for (;;)
    {
      AppMethodBeat.o(266790);
      return paramContext;
      paramContext = new AppBrandUILoadingSplash(em(paramContext), paramt);
      paramContext.jM(paramBoolean);
    }
  }
  
  public static aa a(Context paramContext, t paramt)
  {
    AppMethodBeat.i(48659);
    Object localObject = (Bitmap)qVC.remove(paramt);
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
    {
      paramContext = new m(paramContext, (Bitmap)localObject);
      AppMethodBeat.o(48659);
      return paramContext;
    }
    localObject = a(paramContext, paramt.bDy());
    if (localObject != null)
    {
      ((z)localObject).setRuntime(paramt);
      AppMethodBeat.o(48659);
      return localObject;
    }
    if (g.ap(paramt))
    {
      paramContext = new com.tencent.mm.plugin.appbrand.ag.b(em(paramContext), paramt);
      AppMethodBeat.o(48659);
      return paramContext;
    }
    if ((p.an(paramt)) || (bd.s(paramt)) || (paramt.bDK()))
    {
      if (paramt.Qv()) {
        localObject = new e(em(paramContext), paramt, paramt.bDy().cwY);
      }
      while (paramt.bDK())
      {
        HalfScreenConfig localHalfScreenConfig = paramt.bDy().nBE;
        if (localHalfScreenConfig.nZH == HalfScreenConfig.f.oac)
        {
          localObject = a(paramContext, paramt, localHalfScreenConfig.nnk);
          paramContext = new AppBrandSingleCloseCapsuleBar(em(paramContext));
          paramContext.setTitle(paramt.bDy().fzM);
          paramContext.setWxaIconUrl(paramt.bDy().iconUrl);
          ((AppBrandUILoadingSplash)localObject).setActionBar(paramContext);
          ((AppBrandUILoadingSplash)localObject).GZ(true);
          AppMethodBeat.o(48659);
          return localObject;
          localObject = new k(em(paramContext), paramt, paramt.bDy().cwY);
        }
        else
        {
          ((k)localObject).GZ(true);
        }
      }
      AppMethodBeat.o(48659);
      return localObject;
    }
    if (paramt.Qv())
    {
      localObject = new f(em(paramContext), paramt);
      if (paramt.bCA())
      {
        paramContext = new a(em(paramContext), paramt, (aa)localObject, paramt.nwE);
        AppMethodBeat.o(48659);
        return paramContext;
      }
      AppMethodBeat.o(48659);
      return localObject;
    }
    localObject = a(paramContext, paramt, false);
    ((AppBrandUILoadingSplash)localObject).setLabelInjector(new AppBrandUILoadingSplash.a()
    {
      public final void a(ViewStub paramAnonymousViewStub)
      {
        AppMethodBeat.i(258318);
        if ((com.tencent.luggage.sdk.config.e.iO(this.nsw.bDy().nYq)) && (((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vXL, 0) == 1))
        {
          paramAnonymousViewStub.setLayoutResource(au.g.app_brand_splash_brand_official_label);
          paramAnonymousViewStub.inflate();
        }
        AppMethodBeat.o(258318);
      }
      
      @SuppressLint({"ResourceType"})
      public final void b(ViewStub paramAnonymousViewStub)
      {
        AppMethodBeat.i(258320);
        if ((com.tencent.luggage.sdk.config.e.iP(this.nsw.bDy().nYp)) && (((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vUA, 0) == 1))
        {
          paramAnonymousViewStub.setLayoutResource(au.g.app_brand_splash_trading_guarantee_label);
          paramAnonymousViewStub = (ImageView)paramAnonymousViewStub.inflate().findViewById(au.f.icon);
          if (!ar.isDarkMode()) {
            break label84;
          }
        }
        label84:
        for (int i = au.h.appbrand_trading_guarantee_icon_white;; i = au.h.appbrand_trading_guarantee_icon_gray)
        {
          paramAnonymousViewStub.setImageResource(i);
          AppMethodBeat.o(258320);
          return;
        }
      }
    });
    if (paramt.bCA())
    {
      paramContext = new a(em(paramContext), paramt, (aa)localObject, paramt.nwE);
      AppMethodBeat.o(48659);
      return paramContext;
    }
    AppMethodBeat.o(48659);
    return localObject;
  }
  
  public static z a(Context paramContext, AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(266783);
    if (paramAppBrandInitConfigWC.nYb)
    {
      if (!TextUtils.isEmpty(l.eo(paramAppBrandInitConfigWC.nBq)))
      {
        AppMethodBeat.o(266783);
        return null;
      }
      if (!com.tencent.mm.plugin.appbrand.ui.c.a.b.clP())
      {
        Log.i("MicroMsg.AppBrandLoadingSplashFactory", "createSnapshotDisplayLoadingSplash but switch off, appId:%s", new Object[] { paramAppBrandInitConfigWC.appId });
        AppMethodBeat.o(266783);
        return null;
      }
      String str = paramAppBrandInitConfigWC.nYo;
      if (u.agG(str))
      {
        Log.i("MicroMsg.AppBrandLoadingSplashFactory", "createScreenshotSplash with appId:%s, path:%s", new Object[] { paramAppBrandInitConfigWC.appId, str });
        paramAppBrandInitConfigWC = BitmapUtil.decodeFile(str);
        if ((paramAppBrandInitConfigWC != null) && (!paramAppBrandInitConfigWC.isRecycled()))
        {
          paramContext = new z(paramContext, paramAppBrandInitConfigWC);
          AppMethodBeat.o(266783);
          return paramContext;
        }
      }
      AppMethodBeat.o(266783);
      return null;
    }
    AppMethodBeat.o(266783);
    return null;
  }
  
  public static void a(AppBrandRuntime paramAppBrandRuntime, Bitmap paramBitmap)
  {
    AppMethodBeat.i(48661);
    if ((paramAppBrandRuntime == null) || (paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(48661);
      return;
    }
    qVC.put(paramAppBrandRuntime, paramBitmap);
    AppMethodBeat.o(48661);
  }
  
  public static boolean cjJ()
  {
    AppMethodBeat.i(161867);
    if (MMApplicationContext.isMainProcess())
    {
      AppMethodBeat.o(161867);
      return false;
    }
    if ((!com.tencent.mm.cj.a.hrp()) && (com.tencent.mm.cj.a.hrh())) {}
    for (int i = 1; (i != 0) && (!com.tencent.mm.cj.a.hro()); i = 0)
    {
      AppMethodBeat.o(161867);
      return true;
    }
    AppMethodBeat.o(161867);
    return false;
  }
  
  private static Context em(Context paramContext)
  {
    AppMethodBeat.i(48660);
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = MMApplicationContext.getContext();
    }
    paramContext = localContext;
    if (cjJ()) {
      paramContext = com.tencent.mm.plugin.appbrand.page.f.eg(localContext);
    }
    AppMethodBeat.o(48660);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.i
 * JD-Core Version:    0.7.0.1
 */