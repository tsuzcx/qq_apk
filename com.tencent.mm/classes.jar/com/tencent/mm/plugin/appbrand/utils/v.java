package com.tencent.mm.plugin.appbrand.utils;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import com.tencent.luggage.h.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.al;
import d.g.b.p;
import d.l;
import d.n.n;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/utils/LuggageUIUtilsBridge;", "Lcom/tencent/luggage/util/UIUtilsInterface;", "()V", "TAG", "", "getCutOutHeight", "", "context", "Landroid/content/Context;", "getDarkModeColor", "originalColor", "getStableStatusBarHeight", "hasCutOut", "", "hasHuaweiMagicWindowFeature", "huaweiSpecial", "isDarkMode", "isHuaweiFold", "plugin-luggage-wechat-impl_release"})
public final class v
  implements j
{
  public static final v mUi;
  
  static
  {
    AppMethodBeat.i(174557);
    mUi = new v();
    AppMethodBeat.o(174557);
  }
  
  public final boolean FA()
  {
    boolean bool2 = true;
    AppMethodBeat.i(217867);
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
      ae.i("MicroMsg.LuggageUIUtilsBridge", "isHuaweiFold: ".concat(String.valueOf(bool1)));
      AppMethodBeat.o(217867);
      return bool1;
    }
  }
  
  public final boolean FB()
  {
    AppMethodBeat.i(217866);
    boolean bool1 = false;
    try
    {
      boolean bool2 = w.FB();
      bool1 = bool2;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ae.e("MicroMsg.LuggageUIUtilsBridge", "hasHuaweiMagicWindowFeature" + localThrowable.getMessage());
      }
    }
    ae.i("MicroMsg.LuggageUIUtilsBridge", "hasHuaweiMagicWindowFeature: ".concat(String.valueOf(bool1)));
    AppMethodBeat.o(217866);
    return bool1;
  }
  
  public final boolean Fz()
  {
    AppMethodBeat.i(217865);
    boolean bool = al.Fz();
    AppMethodBeat.o(217865);
    return bool;
  }
  
  public final int aG(Context paramContext)
  {
    AppMethodBeat.i(174555);
    int i = al.aG(paramContext);
    AppMethodBeat.o(174555);
    return i;
  }
  
  public final boolean aH(Context paramContext)
  {
    AppMethodBeat.i(174556);
    boolean bool = al.aH(paramContext);
    AppMethodBeat.o(174556);
    return bool;
  }
  
  public final int aI(Context paramContext)
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
      f = com.tencent.mm.cc.a.flD() / f;
      i = d.h.a.cm(paramContext.getDimensionPixelSize(paramContext.getIdentifier("status_bar_height", "dimen", "android")) * f);
      AppMethodBeat.o(182443);
      return i;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        ae.e("MicroMsg.LuggageUIUtilsBridge", "getStableStatusBarHeight e=".concat(String.valueOf(paramContext)));
        int i = 0;
      }
    }
  }
  
  public final int gE(int paramInt)
  {
    AppMethodBeat.i(174553);
    paramInt = al.gE(paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.v
 * JD-Core Version:    0.7.0.1
 */