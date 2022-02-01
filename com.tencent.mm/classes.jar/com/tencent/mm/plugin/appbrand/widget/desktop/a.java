package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.au.d;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
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
    AppMethodBeat.i(49439);
    rpf = 1;
    rpg = 4.5F;
    rph = 4;
    rpi = 3.5F;
    rpj = 3;
    rpk = AppBrandGlobalSystemConfig.bLe().nXf;
    rpl = rpg;
    rpm = rph;
    rpn = 3;
    rpo = 0;
    AppMethodBeat.o(49439);
  }
  
  public static boolean cnk()
  {
    return rpf == 2;
  }
  
  public static void init(Context paramContext)
  {
    AppMethodBeat.i(49437);
    Log.i("MicroMsg.AppBrandDesktopConfig", "alvinluo DesktopConfig init mCurrentType: %d", new Object[] { Integer.valueOf(rpf) });
    if (rpf == 1)
    {
      rpg = 4.0F;
      rph = 4;
      rpi = 3.0F;
      rpj = 3;
      rpl = rpg;
      rpm = rph;
    }
    int j = b.c(paramContext, rpl);
    int i = j;
    if (rpf == 1) {
      i = (int)(j + paramContext.getResources().getDimensionPixelSize(au.d.SmallPadding) * 2 * b.ez(paramContext));
    }
    if (i <= com.tencent.mm.ci.a.fromDPToPix(paramContext, 10)) {
      rpl = rpi;
    }
    for (rpm = rpj;; rpm = rph)
    {
      rpn = 3;
      i = Math.max(3, 1);
      rpn = i;
      rpn = Math.min(i, 4);
      Log.i("MicroMsg.AppBrandDesktopConfig", "alvinluo DesktopConfig init showCountPerPage: %f, completelyShowCountPerPage: %d, mRecentAppBrandMaxShowLines: %d", new Object[] { Float.valueOf(rpl), Integer.valueOf(rpm), Integer.valueOf(rpn) });
      AppMethodBeat.o(49437);
      return;
      rpl = rpg;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.a
 * JD-Core Version:    0.7.0.1
 */