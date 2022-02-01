package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.luggage.h.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ap;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.vfs.i;

public final class h
{
  private static final android.support.v4.e.a<AppBrandRuntime, Bitmap> mCb;
  
  static
  {
    AppMethodBeat.i(48662);
    mCb = new android.support.v4.e.a();
    AppMethodBeat.o(48662);
  }
  
  public static u a(Context paramContext, AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(188863);
    if (paramAppBrandInitConfigWC.jXu)
    {
      if (!TextUtils.isEmpty(k.dr(paramAppBrandInitConfigWC.jCN)))
      {
        AppMethodBeat.o(188863);
        return null;
      }
      if (!com.tencent.mm.plugin.appbrand.ui.c.a.b.bBj())
      {
        ad.i("MicroMsg.AppBrandLoadingSplashFactory", "createSnapshotDisplayLoadingSplash but switch off, appId:%s", new Object[] { paramAppBrandInitConfigWC.appId });
        AppMethodBeat.o(188863);
        return null;
      }
      String str = paramAppBrandInitConfigWC.jXH;
      if (i.fv(str))
      {
        ad.i("MicroMsg.AppBrandLoadingSplashFactory", "createScreenshotSplash with appId:%s, path:%s", new Object[] { paramAppBrandInitConfigWC.appId, str });
        paramAppBrandInitConfigWC = com.tencent.mm.sdk.platformtools.g.decodeFile(str);
        if ((paramAppBrandInitConfigWC != null) && (!paramAppBrandInitConfigWC.isRecycled()))
        {
          paramContext = new u(paramContext, paramAppBrandInitConfigWC);
          AppMethodBeat.o(188863);
          return paramContext;
        }
      }
      AppMethodBeat.o(188863);
      return null;
    }
    AppMethodBeat.o(188863);
    return null;
  }
  
  public static v a(Context paramContext, o paramo)
  {
    AppMethodBeat.i(48659);
    Object localObject = (Bitmap)mCb.remove(paramo);
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
    {
      paramContext = new l(paramContext, (Bitmap)localObject);
      AppMethodBeat.o(48659);
      return paramContext;
    }
    localObject = a(paramContext, paramo.aXc());
    if (localObject != null)
    {
      ((u)localObject).setRuntime(paramo);
      AppMethodBeat.o(48659);
      return localObject;
    }
    if (com.tencent.mm.plugin.appbrand.ab.g.am(paramo))
    {
      paramContext = new com.tencent.mm.plugin.appbrand.ab.b(dM(paramContext), paramo);
      AppMethodBeat.o(48659);
      return paramContext;
    }
    if ((n.al(paramo)) || (ap.n(paramo)))
    {
      if (paramo.Eb())
      {
        paramContext = new d(dM(paramContext), paramo, paramo.aXc().cmy);
        AppMethodBeat.o(48659);
        return paramContext;
      }
      paramContext = new j(dM(paramContext), paramo, paramo.aXc().cmy);
      AppMethodBeat.o(48659);
      return paramContext;
    }
    if (paramo.Eb())
    {
      localObject = new e(dM(paramContext), paramo);
      if (paramo.aWn())
      {
        paramContext = new c(dM(paramContext), paramo, (v)localObject, paramo.jzv);
        AppMethodBeat.o(48659);
        return paramContext;
      }
      AppMethodBeat.o(48659);
      return localObject;
    }
    AppBrandUILoadingSplash localAppBrandUILoadingSplash = (AppBrandUILoadingSplash)paramo.jzw.aC(AppBrandUILoadingSplash.class);
    boolean bool;
    if (localAppBrandUILoadingSplash != null)
    {
      ad.d("MicroMsg.AppBrandUILoadingSplash", "attachRuntime %s", new Object[] { paramo.Fi().doD });
      localAppBrandUILoadingSplash.jzY = paramo;
      Activity localActivity = com.tencent.mm.sdk.f.a.jq(paramo.mContext);
      localObject = localAppBrandUILoadingSplash;
      if ((localAppBrandUILoadingSplash.getContext() instanceof MutableContextWrapper))
      {
        ((MutableContextWrapper)localAppBrandUILoadingSplash.getContext()).setBaseContext(localActivity);
        int i = localAppBrandUILoadingSplash.getResources().getColor(2131099650);
        if (localAppBrandUILoadingSplash.isDarkMode()) {
          break label402;
        }
        bool = true;
        localAppBrandUILoadingSplash.L(i, bool);
      }
    }
    for (localObject = localAppBrandUILoadingSplash;; localObject = new AppBrandUILoadingSplash(dM(paramContext), paramo))
    {
      ((AppBrandUILoadingSplash)localObject).setLabelInjector(new h.1(paramo));
      if (!paramo.aWn()) {
        break label424;
      }
      paramContext = new c(dM(paramContext), paramo, (v)localObject, paramo.jzv);
      AppMethodBeat.o(48659);
      return paramContext;
      label402:
      bool = false;
      break;
    }
    label424:
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
    mCb.put(paramAppBrandRuntime, paramBitmap);
    AppMethodBeat.o(48661);
  }
  
  public static boolean bzm()
  {
    AppMethodBeat.i(161867);
    if (aj.cmR())
    {
      AppMethodBeat.o(161867);
      return false;
    }
    if ((!com.tencent.mm.cd.a.fhP()) && (com.tencent.mm.cd.a.fhI())) {}
    for (int i = 1; (i != 0) && (!com.tencent.mm.cd.a.fhO()); i = 0)
    {
      AppMethodBeat.o(161867);
      return true;
    }
    AppMethodBeat.o(161867);
    return false;
  }
  
  private static Context dM(Context paramContext)
  {
    AppMethodBeat.i(48660);
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = aj.getContext();
    }
    paramContext = localContext;
    if (bzm()) {
      paramContext = new q(localContext);
    }
    AppMethodBeat.o(48660);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.h
 * JD-Core Version:    0.7.0.1
 */