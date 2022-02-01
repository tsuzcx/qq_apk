package com.tencent.mm.plugin.appbrand.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.luggage.k.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ar;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/utils/LuggageUIUtilsBridge;", "Lcom/tencent/luggage/util/UIUtilsInterface;", "()V", "TAG", "", "getCutOutHeight", "", "context", "Landroid/content/Context;", "getDarkModeColor", "originalColor", "getStableStatusBarHeight", "hasCutOut", "", "huaweiSpecial", "isDarkMode", "isDarkModeForWeApp", "appId", "isHuaweiFold", "plugin-appbrand-integration_release"})
public final class y
  implements k
{
  public static final y riX;
  
  static
  {
    AppMethodBeat.i(174557);
    riX = new y();
    AppMethodBeat.o(174557);
  }
  
  public final boolean SI()
  {
    AppMethodBeat.i(260604);
    boolean bool = ar.SI();
    AppMethodBeat.o(260604);
    return bool;
  }
  
  public final boolean SJ()
  {
    AppMethodBeat.i(260605);
    if ((ar.hIH()) || (ar.hII()))
    {
      AppMethodBeat.o(260605);
      return true;
    }
    AppMethodBeat.o(260605);
    return false;
  }
  
  public final int aM(Context paramContext)
  {
    AppMethodBeat.i(174555);
    int i = ar.aM(paramContext);
    AppMethodBeat.o(174555);
    return i;
  }
  
  public final boolean aN(Context paramContext)
  {
    AppMethodBeat.i(174556);
    boolean bool = ar.aN(paramContext);
    AppMethodBeat.o(174556);
    return bool;
  }
  
  public final int aO(Context paramContext)
  {
    AppMethodBeat.i(182443);
    p.k(paramContext, "context");
    try
    {
      paramContext = paramContext.getApplicationContext();
      p.j(paramContext, "context.applicationContext");
      paramContext = paramContext.getResources();
      p.j(paramContext, "resources");
      float f = paramContext.getDisplayMetrics().density;
      f = com.tencent.mm.cj.a.hrl() / f;
      i = kotlin.h.a.dm(paramContext.getDimensionPixelSize(paramContext.getIdentifier("status_bar_height", "dimen", "android")) * f);
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
  
  public final boolean em(String paramString)
  {
    AppMethodBeat.i(260601);
    paramString = d.abA(paramString);
    if ((paramString == null) || (paramString.bDy() == null))
    {
      bool = ar.isDarkMode();
      AppMethodBeat.o(260601);
      return bool;
    }
    paramString = paramString.bDy().nBE;
    p.j(paramString, "runtime.initConfig.halfScreenConfig");
    if ((paramString.isEnable()) && (paramString.nnk))
    {
      AppMethodBeat.o(260601);
      return false;
    }
    boolean bool = ar.isDarkMode();
    AppMethodBeat.o(260601);
    return bool;
  }
  
  public final int iV(int paramInt)
  {
    AppMethodBeat.i(174553);
    paramInt = ar.iV(paramInt);
    AppMethodBeat.o(174553);
    return paramInt;
  }
  
  public final boolean isDarkMode()
  {
    AppMethodBeat.i(174554);
    boolean bool = ar.isDarkMode();
    AppMethodBeat.o(174554);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.y
 * JD-Core Version:    0.7.0.1
 */