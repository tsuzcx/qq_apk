package com.tencent.mm.plugin.mall.ui;

import android.content.res.Resources;
import android.graphics.Point;
import android.support.v7.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aj;

public final class a
{
  public static final int uBc;
  public static final int uBd;
  public static final int uBe;
  private static int uBf;
  private static int uBg;
  private static int uBh;
  private static int uBi;
  private static int uBj;
  private static int uBk;
  private static int uBl;
  
  static
  {
    AppMethodBeat.i(66032);
    uBc = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 8);
    uBd = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 140);
    uBe = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 85);
    uBf = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 39);
    uBg = 40;
    uBh = 95;
    uBi = 0;
    uBj = 0;
    uBk = 70;
    uBl = 38;
    AppMethodBeat.o(66032);
  }
  
  public static void c(MMActivity paramMMActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(66030);
    if (paramBoolean)
    {
      i(paramMMActivity);
      AppMethodBeat.o(66030);
      return;
    }
    i(paramMMActivity);
    ac.i("MicroMsg.FunctionGridSizeCalculator", "calcGridSize, GRID_HEIGHT_SIZE_PX: %s, TOP_FUNC_LINE_GRID_SIZE_PX: %s", new Object[] { Integer.valueOf(uBi), Integer.valueOf(uBj) });
    AppMethodBeat.o(66030);
  }
  
  public static int daO()
  {
    return uBi;
  }
  
  public static int daP()
  {
    return uBj;
  }
  
  public static int daQ()
  {
    return uBf;
  }
  
  private static void i(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(66031);
    Point localPoint = aj.cl(paramMMActivity);
    int n = localPoint.x;
    int k = localPoint.y;
    if (aj.jF(paramMMActivity)) {}
    for (int j = k - aj.ej(paramMMActivity);; j = k)
    {
      if (paramMMActivity.getSupportActionBar() != null)
      {
        int m = paramMMActivity.getSupportActionBar().getHeight();
        i = m;
        if (m > 0) {}
      }
      for (int i = paramMMActivity.getResources().getDimensionPixelSize(2131165252);; i = 0)
      {
        i = j - i - aj.ji(paramMMActivity);
        if (k / n * 1.0D > 2.0D) {}
        for (i = (i - uBc * 3) / 20;; i = (i - uBc * 3) / 17)
        {
          uBj = Math.max(i * 4, uBd);
          uBf = (int)(i * 1.5D);
          uBi = Math.max(i * 3, uBe);
          ac.i("MicroMsg.FunctionGridSizeCalculator", "baseA: %s, top height: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(uBj) });
          AppMethodBeat.o(66031);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.a
 * JD-Core Version:    0.7.0.1
 */