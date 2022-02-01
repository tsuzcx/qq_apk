package com.tencent.mm.plugin.appbrand.widget.recent;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.au.d;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
{
  private static int rpf;
  public static float rpg;
  public static int rph;
  public static float rpi;
  public static int rpj;
  public static final int rpk;
  private static float rpl;
  private static int rpm;
  private static int rpn;
  private static int rpo;
  
  static
  {
    AppMethodBeat.i(273286);
    rpf = 1;
    rpg = 4.5F;
    rph = 4;
    rpi = 3.5F;
    rpj = 3;
    rpk = AppBrandGlobalSystemConfig.bLe().nXf;
    rpl = rpg;
    rpm = rph;
    rpn = 1;
    rpo = 0;
    AppMethodBeat.o(273286);
  }
  
  public static boolean cnk()
  {
    return rpf == 2;
  }
  
  public static boolean cqh()
  {
    return true;
  }
  
  public static int getCompletelyCountPerPage()
  {
    return rpm;
  }
  
  public static void init(Context paramContext)
  {
    AppMethodBeat.i(273284);
    Log.i("MicroMsg.AppBrandRecentConfig", "alvinluo DesktopConfig init mCurrentType: %d", new Object[] { Integer.valueOf(rpf) });
    if (rpf == 1)
    {
      rpg = 4.0F;
      rph = 4;
      rpi = 3.0F;
      rpj = 3;
      rpl = rpg;
      rpm = rph;
    }
    int j = f.c(paramContext, rpl);
    int i = j;
    if (rpf == 1) {
      i = (int)(j + paramContext.getResources().getDimensionPixelSize(au.d.SmallPadding) * 2 * f.ez(paramContext));
    }
    if (i <= a.fromDPToPix(paramContext, 10)) {
      rpl = rpi;
    }
    for (rpm = rpj;; rpm = rph)
    {
      i = ((b)h.ae(b.class)).a(b.a.vRB, 1);
      rpn = i;
      i = Math.max(i, 1);
      rpn = i;
      rpn = Math.min(i, 4);
      Log.i("MicroMsg.AppBrandRecentConfig", "alvinluo DesktopConfig init showCountPerPage: %f, completelyShowCountPerPage: %d, mRecentAppBrandMaxShowLines: %d", new Object[] { Float.valueOf(rpl), Integer.valueOf(rpm), Integer.valueOf(rpn) });
      AppMethodBeat.o(273284);
      return;
      rpl = rpg;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recent.d
 * JD-Core Version:    0.7.0.1
 */