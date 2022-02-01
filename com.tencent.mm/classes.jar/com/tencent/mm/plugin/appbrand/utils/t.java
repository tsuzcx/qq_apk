package com.tencent.mm.plugin.appbrand.utils;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import com.tencent.luggage.h.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.aj;
import d.g.b.k;
import d.l;
import d.n.n;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/utils/LuggageUIUtilsBridge;", "Lcom/tencent/luggage/util/UIUtilsInterface;", "()V", "TAG", "", "getCutOutHeight", "", "context", "Landroid/content/Context;", "getDarkModeColor", "originalColor", "getStableStatusBarHeight", "hasCutOut", "", "hasHuaweiMagicWindowFeature", "huaweiSpecial", "isDarkMode", "isHuaweiFold", "plugin-luggage-wechat-impl_release"})
public final class t
  implements j
{
  public static final t moB;
  
  static
  {
    AppMethodBeat.i(174557);
    moB = new t();
    AppMethodBeat.o(174557);
  }
  
  public final boolean DT()
  {
    AppMethodBeat.i(174554);
    boolean bool = aj.DT();
    AppMethodBeat.o(174554);
    return bool;
  }
  
  public final boolean DU()
  {
    AppMethodBeat.i(205638);
    boolean bool = aj.DU();
    AppMethodBeat.o(205638);
    return bool;
  }
  
  public final boolean DV()
  {
    boolean bool2 = true;
    AppMethodBeat.i(205640);
    if (n.I("HUAWEI", Build.BRAND, true))
    {
      bool1 = bool2;
      if (!n.I("unknownRLI", Build.DEVICE, true))
      {
        bool1 = bool2;
        if (!n.I("HWTAH", Build.DEVICE, true))
        {
          bool1 = bool2;
          if (!n.I("HWTAH-C", Build.DEVICE, true))
          {
            bool1 = bool2;
            if (!n.I("unknownRHA", Build.DEVICE, true))
            {
              bool1 = bool2;
              if (!n.I("HWTET", Build.DEVICE, true)) {
                if (!n.I("unknownTXL", Build.DEVICE, true)) {
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
      ac.i("MicroMsg.LuggageUIUtilsBridge", "isHuaweiFold: ".concat(String.valueOf(bool1)));
      AppMethodBeat.o(205640);
      return bool1;
    }
  }
  
  public final boolean DW()
  {
    AppMethodBeat.i(205639);
    boolean bool1 = false;
    try
    {
      boolean bool2 = u.DW();
      bool1 = bool2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.e("MicroMsg.LuggageUIUtilsBridge", "hasHuaweiMagicWindowFeature" + localException.getMessage());
      }
    }
    ac.i("MicroMsg.LuggageUIUtilsBridge", "hasHuaweiMagicWindowFeature: ".concat(String.valueOf(bool1)));
    AppMethodBeat.o(205639);
    return bool1;
  }
  
  public final int aF(Context paramContext)
  {
    AppMethodBeat.i(174555);
    int i = aj.aF(paramContext);
    AppMethodBeat.o(174555);
    return i;
  }
  
  public final boolean aG(Context paramContext)
  {
    AppMethodBeat.i(174556);
    boolean bool = aj.aG(paramContext);
    AppMethodBeat.o(174556);
    return bool;
  }
  
  public final int aH(Context paramContext)
  {
    AppMethodBeat.i(182443);
    k.h(paramContext, "context");
    try
    {
      paramContext = paramContext.getApplicationContext();
      k.g(paramContext, "context.applicationContext");
      paramContext = paramContext.getResources();
      k.g(paramContext, "resources");
      float f = paramContext.getDisplayMetrics().density;
      f = com.tencent.mm.cd.a.eSs() / f;
      i = d.h.a.cj(paramContext.getDimensionPixelSize(paramContext.getIdentifier("status_bar_height", "dimen", "android")) * f);
      AppMethodBeat.o(182443);
      return i;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        ac.e("MicroMsg.LuggageUIUtilsBridge", "getStableStatusBarHeight e=".concat(String.valueOf(paramContext)));
        int i = 0;
      }
    }
  }
  
  public final int gy(int paramInt)
  {
    AppMethodBeat.i(174553);
    paramInt = aj.gy(paramInt);
    AppMethodBeat.o(174553);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.t
 * JD-Core Version:    0.7.0.1
 */