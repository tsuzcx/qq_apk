package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ad.e;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.n;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.appbrand.weishi.h;
import com.tencent.mm.sdk.platformtools.Util;

public final class q
  extends com.tencent.mm.plugin.appbrand.menu.a.a<ah>
{
  public q()
  {
    super(x.tkk.ordinal());
    AppMethodBeat.i(47652);
    AppMethodBeat.o(47652);
  }
  
  public static y a(Context paramContext, ah paramah)
  {
    AppMethodBeat.i(323833);
    AppBrandSysConfigWC localAppBrandSysConfigWC = paramah.getRuntime().ccM();
    if ((localAppBrandSysConfigWC != null) && (com.tencent.mm.plugin.appbrand.config.a.qVu.a(localAppBrandSysConfigWC) == 1))
    {
      paramContext = y.tkR;
      AppMethodBeat.o(323833);
      return paramContext;
    }
    if ((!g(paramah)) || (e.eu(paramContext)) || (com.tencent.mm.plugin.appbrand.k.a.a.F(paramah.getRuntime())))
    {
      paramContext = y.tkT;
      AppMethodBeat.o(323833);
      return paramContext;
    }
    paramContext = y.tkS;
    AppMethodBeat.o(323833);
    return paramContext;
  }
  
  public static void a(Context paramContext, ah paramah, String paramString, w paramw)
  {
    AppMethodBeat.i(47654);
    j.a(paramString, paramah.cgR(), 39, "", Util.nowSecond(), 1, 0);
    if (h.aD(paramah.getRuntime()))
    {
      z.a(paramah, paramw);
      AppMethodBeat.o(47654);
      return;
    }
    z.a(paramContext, paramah, paramw, null);
    AppMethodBeat.o(47654);
  }
  
  public static boolean g(ah paramah)
  {
    AppMethodBeat.i(47653);
    AppBrandSysConfigWC localAppBrandSysConfigWC = paramah.getRuntime().ccM();
    if ((localAppBrandSysConfigWC != null) && (localAppBrandSysConfigWC.qYY.qHO == 0) && (com.tencent.mm.plugin.appbrand.config.a.qVu.a(localAppBrandSysConfigWC) == 2))
    {
      AppMethodBeat.o(47653);
      return false;
    }
    if (paramah.CF(x.tkk.ordinal()) == null)
    {
      AppMethodBeat.o(47653);
      return false;
    }
    if (!paramah.CF(x.tkk.ordinal()).disable)
    {
      AppMethodBeat.o(47653);
      return true;
    }
    AppMethodBeat.o(47653);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.q
 * JD-Core Version:    0.7.0.1
 */