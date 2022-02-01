package com.tencent.mm.plugin.appbrand.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.luggage.h.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/utils/LuggageUIUtilsBridge;", "Lcom/tencent/luggage/util/UIUtilsInterface;", "()V", "TAG", "", "getCutOutHeight", "", "context", "Landroid/content/Context;", "getDarkModeColor", "originalColor", "getStableStatusBarHeight", "hasCutOut", "", "hasHuaweiMagicWindowFeature", "huaweiSpecial", "isDarkMode", "isHuaweiFold", "plugin-luggage-wechat-impl_release"})
public final class v
  implements k
{
  public static final v ohj;
  
  static
  {
    AppMethodBeat.i(174557);
    ohj = new v();
    AppMethodBeat.o(174557);
  }
  
  public final boolean Pi()
  {
    AppMethodBeat.i(204359);
    boolean bool = ao.Pi();
    AppMethodBeat.o(204359);
    return bool;
  }
  
  public final boolean Pj()
  {
    AppMethodBeat.i(204361);
    if ((ao.gJK()) || (ao.gJL()))
    {
      AppMethodBeat.o(204361);
      return true;
    }
    AppMethodBeat.o(204361);
    return false;
  }
  
  public final boolean Pk()
  {
    AppMethodBeat.i(204360);
    boolean bool1 = false;
    try
    {
      boolean bool2 = w.Pk();
      bool1 = bool2;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Log.e("MicroMsg.LuggageUIUtilsBridge", "hasHuaweiMagicWindowFeature" + localThrowable.getMessage());
      }
    }
    Log.i("MicroMsg.LuggageUIUtilsBridge", "hasHuaweiMagicWindowFeature: ".concat(String.valueOf(bool1)));
    AppMethodBeat.o(204360);
    return bool1;
  }
  
  public final int aP(Context paramContext)
  {
    AppMethodBeat.i(174555);
    int i = ao.aP(paramContext);
    AppMethodBeat.o(174555);
    return i;
  }
  
  public final boolean aQ(Context paramContext)
  {
    AppMethodBeat.i(174556);
    boolean bool = ao.aQ(paramContext);
    AppMethodBeat.o(174556);
    return bool;
  }
  
  public final int aR(Context paramContext)
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
      f = com.tencent.mm.cc.a.gvp() / f;
      i = kotlin.h.a.cR(paramContext.getDimensionPixelSize(paramContext.getIdentifier("status_bar_height", "dimen", "android")) * f);
      AppMethodBeat.o(182443);
      return i;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        Log.e("MicroMsg.LuggageUIUtilsBridge", "getStableStatusBarHeight e=".concat(String.valueOf(paramContext)));
        int i = 0;
      }
    }
  }
  
  public final int hT(int paramInt)
  {
    AppMethodBeat.i(174553);
    paramInt = ao.hT(paramInt);
    AppMethodBeat.o(174553);
    return paramInt;
  }
  
  public final boolean isDarkMode()
  {
    AppMethodBeat.i(174554);
    boolean bool = ao.isDarkMode();
    AppMethodBeat.o(174554);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.v
 * JD-Core Version:    0.7.0.1
 */