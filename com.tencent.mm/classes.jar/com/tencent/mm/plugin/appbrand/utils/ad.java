package com.tencent.mm.plugin.appbrand.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.luggage.l.g;
import com.tencent.luggage.l.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ce.c;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import kotlin.Metadata;
import kotlin.g.b.aa;
import kotlin.g.b.ai;
import kotlin.g.b.s;
import kotlin.g.b.z;
import kotlin.h.a;
import kotlin.l.o;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/utils/LuggageUIUtilsBridge;", "Lcom/tencent/luggage/util/UIUtilsInterface;", "()V", "TAG", "", "<set-?>", "", "forceIsFoldableDevice", "getForceIsFoldableDevice", "()Z", "setForceIsFoldableDevice", "(Z)V", "forceIsFoldableDevice$delegate", "Lcom/tencent/luggage/util/LuggageMMKVProperty;", "getCutOutHeight", "", "context", "Landroid/content/Context;", "getDarkModeColor", "originalColor", "getStableStatusBarHeight", "hasCutOut", "huaweiSpecial", "isDarkMode", "isDarkModeForWeApp", "appId", "isFoldableDevice", "isHuaweiFold", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ad
  implements l
{
  public static final ad urk;
  public static final g urm;
  
  static
  {
    AppMethodBeat.i(174557);
    aYe = new o[] { (o)ai.a((z)new aa(ad.class, "forceIsFoldableDevice", "getForceIsFoldableDevice()Z", 0)) };
    urk = new ad();
    urm = new g(Boolean.FALSE);
    AppMethodBeat.o(174557);
  }
  
  public final boolean atm()
  {
    AppMethodBeat.i(317357);
    boolean bool = aw.atm();
    AppMethodBeat.o(317357);
    return bool;
  }
  
  public final boolean atn()
  {
    AppMethodBeat.i(317361);
    if ((aw.jkS()) || (aw.jkT()))
    {
      AppMethodBeat.o(317361);
      return true;
    }
    AppMethodBeat.o(317361);
    return false;
  }
  
  public final boolean ato()
  {
    AppMethodBeat.i(317368);
    if ((atn()) || (aw.jkX()) || (aw.jkV()) || (aw.jkY()) || (((Boolean)urm.a(this, aYe[0])).booleanValue()))
    {
      AppMethodBeat.o(317368);
      return true;
    }
    AppMethodBeat.o(317368);
    return false;
  }
  
  public final int bw(Context paramContext)
  {
    AppMethodBeat.i(174555);
    int i = aw.bw(paramContext);
    AppMethodBeat.o(174555);
    return i;
  }
  
  public final boolean bx(Context paramContext)
  {
    AppMethodBeat.i(174556);
    boolean bool = aw.bx(paramContext);
    AppMethodBeat.o(174556);
    return bool;
  }
  
  public final int by(Context paramContext)
  {
    AppMethodBeat.i(182443);
    s.u(paramContext, "context");
    try
    {
      paramContext = paramContext.getApplicationContext().getResources();
      float f = paramContext.getDisplayMetrics().density;
      f = c.iRA() / f;
      i = a.eH(paramContext.getDimensionPixelSize(paramContext.getIdentifier("status_bar_height", "dimen", "android")) * f);
      AppMethodBeat.o(182443);
      return i;
    }
    finally
    {
      for (;;)
      {
        Log.e("MicroMsg.LuggageUIUtilsBridge", s.X("getStableStatusBarHeight e=", paramContext));
        int i = 0;
      }
    }
  }
  
  public final boolean fJ(String paramString)
  {
    AppMethodBeat.i(317342);
    paramString = d.Uc(paramString);
    if ((paramString == null) || (paramString.getInitConfig() == null))
    {
      bool = aw.isDarkMode();
      AppMethodBeat.o(317342);
      return bool;
    }
    paramString = paramString.getInitConfig().qAT;
    s.s(paramString, "runtime.initConfig.halfScreenConfig");
    if ((paramString.isEnable()) && (paramString.qkq))
    {
      AppMethodBeat.o(317342);
      return false;
    }
    boolean bool = aw.isDarkMode();
    AppMethodBeat.o(317342);
    return bool;
  }
  
  public final boolean isDarkMode()
  {
    AppMethodBeat.i(174554);
    boolean bool = aw.isDarkMode();
    AppMethodBeat.o(174554);
    return bool;
  }
  
  public final int mx(int paramInt)
  {
    AppMethodBeat.i(174553);
    paramInt = aw.mx(paramInt);
    AppMethodBeat.o(174553);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.ad
 * JD-Core Version:    0.7.0.1
 */