package com.tencent.mm.plugin.appbrand.utils;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import com.tencent.luggage.h.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.ai;
import d.g.b.k;
import d.l;
import d.n.n;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/utils/LuggageUIUtilsBridge;", "Lcom/tencent/luggage/util/UIUtilsInterface;", "()V", "TAG", "", "getCutOutHeight", "", "context", "Landroid/content/Context;", "getDarkModeColor", "originalColor", "getStableStatusBarHeight", "hasCutOut", "", "hasHuaweiMagicWindowFeature", "huaweiSpecial", "isDarkMode", "isHuaweiFold", "plugin-luggage-wechat-impl_release"})
public final class t
  implements j
{
  public static final t lME;
  
  static
  {
    AppMethodBeat.i(174557);
    lME = new t();
    AppMethodBeat.o(174557);
  }
  
  public final boolean Eq()
  {
    AppMethodBeat.i(174554);
    boolean bool = ai.Eq();
    AppMethodBeat.o(174554);
    return bool;
  }
  
  public final boolean Er()
  {
    AppMethodBeat.i(192565);
    boolean bool = ai.Er();
    AppMethodBeat.o(192565);
    return bool;
  }
  
  public final boolean Es()
  {
    boolean bool2 = true;
    AppMethodBeat.i(192567);
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
      ad.i("MicroMsg.LuggageUIUtilsBridge", "isHuaweiFold: ".concat(String.valueOf(bool1)));
      AppMethodBeat.o(192567);
      return bool1;
    }
  }
  
  public final boolean Et()
  {
    AppMethodBeat.i(192566);
    boolean bool1 = false;
    try
    {
      boolean bool2 = u.Et();
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
    AppMethodBeat.o(192566);
    return bool1;
  }
  
  public final int aE(Context paramContext)
  {
    AppMethodBeat.i(174555);
    int i = ai.aE(paramContext);
    AppMethodBeat.o(174555);
    return i;
  }
  
  public final boolean aF(Context paramContext)
  {
    AppMethodBeat.i(174556);
    boolean bool = ai.aF(paramContext);
    AppMethodBeat.o(174556);
    return bool;
  }
  
  public final int aG(Context paramContext)
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
      f = com.tencent.mm.ce.a.eCY() / f;
      i = d.h.a.bU(paramContext.getDimensionPixelSize(paramContext.getIdentifier("status_bar_height", "dimen", "android")) * f);
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
  
  public final int gO(int paramInt)
  {
    AppMethodBeat.i(174553);
    paramInt = ai.gO(paramInt);
    AppMethodBeat.o(174553);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.t
 * JD-Core Version:    0.7.0.1
 */