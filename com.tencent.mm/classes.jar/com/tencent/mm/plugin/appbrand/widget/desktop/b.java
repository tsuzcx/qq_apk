package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.content.Context;
import com.tencent.mm.cb.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;

public final class b
{
  private static int hpD = 2;
  public static final int hpE = AppBrandGlobalSystemConfig.aec().fOM;
  private static int hpF = 0;
  private static float hpG = 4.5F;
  private static int hpH = 4;
  
  public static int ads()
  {
    if (hpF == 0) {
      hpF = ((af)g.r(af.class)).acL();
    }
    return hpF;
  }
  
  public static boolean arj()
  {
    return hpD == 2;
  }
  
  public static boolean ark()
  {
    return true;
  }
  
  public static int getCompletelyCountPerPage()
  {
    return hpH;
  }
  
  public static float getShowCountPerPage()
  {
    return hpG;
  }
  
  public static void init(Context paramContext)
  {
    if (d.c(paramContext, 4.5F) <= a.fromDPToPix(paramContext, 10))
    {
      hpG = 3.5F;
      hpH = 3;
      return;
    }
    hpG = 4.5F;
    hpH = 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.b
 * JD-Core Version:    0.7.0.1
 */