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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.f;

public final class g
{
  private static final android.support.v4.e.a<AppBrandRuntime, Bitmap> mbT;
  
  static
  {
    AppMethodBeat.i(48662);
    mbT = new android.support.v4.e.a();
    AppMethodBeat.o(48662);
  }
  
  public static t a(Context paramContext, AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(187021);
    if (paramAppBrandInitConfigWC.jDy)
    {
      if (!TextUtils.isEmpty(com.tencent.luggage.h.k.cp(paramAppBrandInitConfigWC.jjf)))
      {
        AppMethodBeat.o(187021);
        return null;
      }
      if (!com.tencent.mm.plugin.appbrand.ui.c.a.b.bxd())
      {
        ac.i("MicroMsg.AppBrandLoadingSplashFactory", "createSnapshotDisplayLoadingSplash but switch off, appId:%s", new Object[] { paramAppBrandInitConfigWC.appId });
        AppMethodBeat.o(187021);
        return null;
      }
      String str = paramAppBrandInitConfigWC.jDL;
      if (com.tencent.mm.vfs.i.eA(str))
      {
        ac.i("MicroMsg.AppBrandLoadingSplashFactory", "createScreenshotSplash with appId:%s, path:%s", new Object[] { paramAppBrandInitConfigWC.appId, str });
        paramAppBrandInitConfigWC = f.decodeFile(str);
        if ((paramAppBrandInitConfigWC != null) && (!paramAppBrandInitConfigWC.isRecycled()))
        {
          paramContext = new t(paramContext, paramAppBrandInitConfigWC);
          AppMethodBeat.o(187021);
          return paramContext;
        }
      }
      AppMethodBeat.o(187021);
      return null;
    }
    AppMethodBeat.o(187021);
    return null;
  }
  
  public static u a(Context paramContext, o paramo)
  {
    AppMethodBeat.i(48659);
    Object localObject = (Bitmap)mbT.remove(paramo);
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
    {
      paramContext = new k(paramContext, (Bitmap)localObject);
      AppMethodBeat.o(48659);
      return paramContext;
    }
    localObject = a(paramContext, paramo.aTS());
    if (localObject != null)
    {
      ((t)localObject).setRuntime(paramo);
      AppMethodBeat.o(48659);
      return localObject;
    }
    if (com.tencent.mm.plugin.appbrand.ab.g.as(paramo))
    {
      paramContext = new com.tencent.mm.plugin.appbrand.ab.b(dN(paramContext), paramo);
      AppMethodBeat.o(48659);
      return paramContext;
    }
    if ((m.ar(paramo)) || (ao.w(paramo)))
    {
      if (paramo.CC())
      {
        paramContext = new c(dN(paramContext), paramo, paramo.aTS().cch);
        AppMethodBeat.o(48659);
        return paramContext;
      }
      paramContext = new i(dN(paramContext), paramo, paramo.aTS().cch);
      AppMethodBeat.o(48659);
      return paramContext;
    }
    if (paramo.CC())
    {
      paramContext = new d(dN(paramContext), paramo);
      AppMethodBeat.o(48659);
      return paramContext;
    }
    localObject = (AppBrandUILoadingSplash)paramo.jgx.aC(AppBrandUILoadingSplash.class);
    if (localObject != null)
    {
      ac.d("MicroMsg.AppBrandUILoadingSplash", "attachRuntime %s", new Object[] { paramo.DJ().ddh });
      ((AppBrandUILoadingSplash)localObject).jgY = paramo;
      paramContext = com.tencent.mm.sdk.f.a.jg(paramo.mContext);
      int i;
      if ((((AppBrandUILoadingSplash)localObject).getContext() instanceof MutableContextWrapper))
      {
        ((MutableContextWrapper)((AppBrandUILoadingSplash)localObject).getContext()).setBaseContext(paramContext);
        i = ((AppBrandUILoadingSplash)localObject).getResources().getColor(2131099650);
        if (((AppBrandUILoadingSplash)localObject).DT()) {
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
    paramContext = new AppBrandUILoadingSplash(dN(paramContext), paramo);
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
    mbT.put(paramAppBrandRuntime, paramBitmap);
    AppMethodBeat.o(48661);
  }
  
  public static boolean bvg()
  {
    AppMethodBeat.i(161867);
    if (ai.cin())
    {
      AppMethodBeat.o(161867);
      return false;
    }
    if ((!com.tencent.mm.cd.a.eSw()) && (com.tencent.mm.cd.a.eSp())) {}
    for (int i = 1; (i != 0) && (!com.tencent.mm.cd.a.eSv()); i = 0)
    {
      AppMethodBeat.o(161867);
      return true;
    }
    AppMethodBeat.o(161867);
    return false;
  }
  
  private static Context dN(Context paramContext)
  {
    AppMethodBeat.i(48660);
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = ai.getContext();
    }
    paramContext = localContext;
    if (bvg()) {
      paramContext = new p(localContext);
    }
    AppMethodBeat.o(48660);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.g
 * JD-Core Version:    0.7.0.1
 */