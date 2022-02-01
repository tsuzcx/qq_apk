package com.tencent.mm.plugin.appbrand.utils;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import com.tencent.luggage.h.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.al;
import d.g.b.p;
import d.l;
import d.n.n;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/utils/LuggageUIUtilsBridge;", "Lcom/tencent/luggage/util/UIUtilsInterface;", "()V", "TAG", "", "getCutOutHeight", "", "context", "Landroid/content/Context;", "getDarkModeColor", "originalColor", "getStableStatusBarHeight", "hasCutOut", "", "hasHuaweiMagicWindowFeature", "huaweiSpecial", "isDarkMode", "isHuaweiFold", "plugin-luggage-wechat-impl_release"})
public final class t
  implements j
{
  public static final t mPd;
  
  static
  {
    AppMethodBeat.i(174557);
    mPd = new t();
    AppMethodBeat.o(174557);
  }
  
  public final boolean Ft()
  {
    AppMethodBeat.i(217222);
    boolean bool = al.Ft();
    AppMethodBeat.o(217222);
    return bool;
  }
  
  public final boolean Fu()
  {
    boolean bool2 = true;
    AppMethodBeat.i(217224);
    if (n.H("HUAWEI", Build.BRAND, true))
    {
      bool1 = bool2;
      if (!n.H("unknownRLI", Build.DEVICE, true))
      {
        bool1 = bool2;
        if (!n.H("HWTAH", Build.DEVICE, true))
        {
          bool1 = bool2;
          if (!n.H("HWTAH-C", Build.DEVICE, true))
          {
            bool1 = bool2;
            if (!n.H("unknownRHA", Build.DEVICE, true))
            {
              bool1 = bool2;
              if (!n.H("HWTET", Build.DEVICE, true)) {
                if (!n.H("unknownTXL", Build.DEVICE, true)) {
                  break label124;
                }
              }
            }
          }
        }
      }
    }
    label124:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ad.i("MicroMsg.LuggageUIUtilsBridge", "isHuaweiFold: ".concat(String.valueOf(bool1)));
      AppMethodBeat.o(217224);
      return bool1;
    }
  }
  
  public final boolean Fv()
  {
    AppMethodBeat.i(217223);
    boolean bool1 = false;
    try
    {
      boolean bool2 = u.Fv();
      bool1 = bool2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.LuggageUIUtilsBridge", "hasHuaweiMagicWindowFeature" + localException.getMessage());
      }
    }
    ad.i("MicroMsg.LuggageUIUtilsBridge", "hasHuaweiMagicWindowFeature: ".concat(String.valueOf(bool1)));
    AppMethodBeat.o(217223);
    return bool1;
  }
  
  public final int aF(Context paramContext)
  {
    AppMethodBeat.i(174555);
    int i = al.aF(paramContext);
    AppMethodBeat.o(174555);
    return i;
  }
  
  public final boolean aG(Context paramContext)
  {
    AppMethodBeat.i(174556);
    boolean bool = al.aG(paramContext);
    AppMethodBeat.o(174556);
    return bool;
  }
  
  public final int aH(Context paramContext)
  {
    AppMethodBeat.i(182443);
    p.h(paramContext, "context");
    try
    {
      paramContext = paramContext.getApplicationContext();
      p.g(paramContext, "context.applicationContext");
      paramContext = paramContext.getResources();
      p.g(paramContext, "resources");
      float f = paramContext.getDisplayMetrics().density;
      f = com.tencent.mm.cd.a.fhL() / f;
      i = d.h.a.co(paramContext.getDimensionPixelSize(paramContext.getIdentifier("status_bar_height", "dimen", "android")) * f);
      AppMethodBeat.o(182443);
      return i;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        ad.e("MicroMsg.LuggageUIUtilsBridge", "getStableStatusBarHeight e=".concat(String.valueOf(paramContext)));
        int i = 0;
      }
    }
  }
  
  public final int gD(int paramInt)
  {
    AppMethodBeat.i(174553);
    paramInt = al.gD(paramInt);
    AppMethodBeat.o(174553);
    return paramInt;
  }
  
  public final boolean isDarkMode()
  {
    AppMethodBeat.i(174554);
    boolean bool = al.isDarkMode();
    AppMethodBeat.o(174554);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.t
 * JD-Core Version:    0.7.0.1
 */