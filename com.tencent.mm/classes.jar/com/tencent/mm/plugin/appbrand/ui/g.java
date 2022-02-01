package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ao;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.f;

public final class g
{
  private static final android.support.v4.e.a<AppBrandRuntime, Bitmap> lzX;
  
  static
  {
    AppMethodBeat.i(48662);
    lzX = new android.support.v4.e.a();
    AppMethodBeat.o(48662);
  }
  
  public static u a(Context paramContext, AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(196176);
    if (paramAppBrandInitConfigWC.jdl)
    {
      if (!TextUtils.isEmpty(com.tencent.luggage.h.k.cA(paramAppBrandInitConfigWC.iJb)))
      {
        AppMethodBeat.o(196176);
        return null;
      }
      if (!com.tencent.mm.plugin.appbrand.ui.c.a.b.bqg())
      {
        ad.i("MicroMsg.AppBrandLoadingSplashFactory", "createSnapshotDisplayLoadingSplash but switch off, appId:%s", new Object[] { paramAppBrandInitConfigWC.appId });
        AppMethodBeat.o(196176);
        return null;
      }
      String str = paramAppBrandInitConfigWC.jdy;
      if (com.tencent.mm.vfs.i.eK(str))
      {
        ad.i("MicroMsg.AppBrandLoadingSplashFactory", "createScreenshotSplash with appId:%s, path:%s", new Object[] { paramAppBrandInitConfigWC.appId, str });
        paramAppBrandInitConfigWC = f.decodeFile(str);
        if ((paramAppBrandInitConfigWC != null) && (!paramAppBrandInitConfigWC.isRecycled()))
        {
          paramContext = new u(paramContext, paramAppBrandInitConfigWC);
          AppMethodBeat.o(196176);
          return paramContext;
        }
      }
      AppMethodBeat.o(196176);
      return null;
    }
    AppMethodBeat.o(196176);
    return null;
  }
  
  public static v a(Context paramContext, o paramo)
  {
    AppMethodBeat.i(48659);
    Object localObject = (Bitmap)lzX.remove(paramo);
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
    {
      paramContext = new k(paramContext, (Bitmap)localObject);
      AppMethodBeat.o(48659);
      return paramContext;
    }
    localObject = a(paramContext, paramo.aNc());
    if (localObject != null)
    {
      ((u)localObject).setRuntime(paramo);
      AppMethodBeat.o(48659);
      return localObject;
    }
    if (com.tencent.mm.plugin.appbrand.ac.g.as(paramo))
    {
      paramContext = new com.tencent.mm.plugin.appbrand.ac.b(dE(paramContext), paramo);
      AppMethodBeat.o(48659);
      return paramContext;
    }
    if ((m.ar(paramo)) || (ao.w(paramo)))
    {
      if (paramo.CZ())
      {
        paramContext = new c(dE(paramContext), paramo, paramo.aNc().cfl);
        AppMethodBeat.o(48659);
        return paramContext;
      }
      paramContext = new i(dE(paramContext), paramo, paramo.aNc().cfl);
      AppMethodBeat.o(48659);
      return paramContext;
    }
    if (paramo.CZ())
    {
      paramContext = new d(dE(paramContext), paramo);
      AppMethodBeat.o(48659);
      return paramContext;
    }
    localObject = (AppBrandUILoadingSplash)paramo.iGv.aC(AppBrandUILoadingSplash.class);
    if (localObject != null)
    {
      ad.d("MicroMsg.AppBrandUILoadingSplash", "attachRuntime %s", new Object[] { paramo.Eg().dfM });
      ((AppBrandUILoadingSplash)localObject).iGV = paramo;
      paramContext = com.tencent.mm.sdk.f.a.iV(paramo.mContext);
      int i;
      if ((((AppBrandUILoadingSplash)localObject).getContext() instanceof MutableContextWrapper))
      {
        ((MutableContextWrapper)((AppBrandUILoadingSplash)localObject).getContext()).setBaseContext(paramContext);
        i = ((AppBrandUILoadingSplash)localObject).getResources().getColor(2131099650);
        if (((AppBrandUILoadingSplash)localObject).Eq()) {
          break label319;
        }
      }
      label319:
      for (boolean bool = true;; bool = false)
      {
        ((AppBrandUILoadingSplash)localObject).L(i, bool);
        AppMethodBeat.o(48659);
        return localObject;
      }
    }
    paramContext = new AppBrandUILoadingSplash(dE(paramContext), paramo);
    AppMethodBeat.o(48659);
    return paramContext;
  }
  
  public static void a(AppBrandRuntime paramAppBrandRuntime, Bitmap paramBitmap)
  {
    AppMethodBeat.i(48661);
    if ((paramAppBrandRuntime == null) || (paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(48661);
      return;
    }
    lzX.put(paramAppBrandRuntime, paramBitmap);
    AppMethodBeat.o(48661);
  }
  
  public static boolean bok()
  {
    AppMethodBeat.i(161867);
    if (aj.cbe())
    {
      AppMethodBeat.o(161867);
      return false;
    }
    if ((!com.tencent.mm.ce.a.eDc()) && (com.tencent.mm.ce.a.eCV())) {}
    for (int i = 1; (i != 0) && (!com.tencent.mm.ce.a.eDb()); i = 0)
    {
      AppMethodBeat.o(161867);
      return true;
    }
    AppMethodBeat.o(161867);
    return false;
  }
  
  private static Context dE(Context paramContext)
  {
    AppMethodBeat.i(48660);
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = aj.getContext();
    }
    paramContext = localContext;
    if (bok()) {
      paramContext = new p(localContext);
    }
    AppMethodBeat.o(48660);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.g
 * JD-Core Version:    0.7.0.1
 */