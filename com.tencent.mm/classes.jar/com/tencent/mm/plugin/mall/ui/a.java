package com.tencent.mm.plugin.mall.ui;

import android.content.res.Resources;
import android.graphics.Point;
import android.support.v7.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ai;

public final class a
{
  public static final int tsJ;
  public static final int tsK;
  public static final int tsL;
  private static int tsM;
  private static int tsN;
  private static int tsO;
  private static int tsP;
  private static int tsQ;
  private static int tsR;
  private static int tsS;
  
  static
  {
    AppMethodBeat.i(66032);
    tsJ = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 8);
    tsK = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 140);
    tsL = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 85);
    tsM = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 39);
    tsN = 40;
    tsO = 95;
    tsP = 0;
    tsQ = 0;
    tsR = 70;
    tsS = 38;
    AppMethodBeat.o(66032);
  }
  
  public static void b(MMActivity paramMMActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(66030);
    if (paramBoolean)
    {
      i(paramMMActivity);
      AppMethodBeat.o(66030);
      return;
    }
    i(paramMMActivity);
    ad.i("MicroMsg.FunctionGridSizeCalculator", "calcGridSize, GRID_HEIGHT_SIZE_PX: %s, TOP_FUNC_LINE_GRID_SIZE_PX: %s", new Object[] { Integer.valueOf(tsP), Integer.valueOf(tsQ) });
    AppMethodBeat.o(66030);
  }
  
  public static int cNh()
  {
    return tsP;
  }
  
  public static int cNi()
  {
    return tsQ;
  }
  
  public static int cNj()
  {
    return tsM;
  }
  
  private static void i(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(66031);
    Point localPoint = ai.cf(paramMMActivity);
    int n = localPoint.x;
    int k = localPoint.y;
    if (ai.ju(paramMMActivity)) {}
    for (int j = k - ai.eb(paramMMActivity);; j = k)
    {
      if (paramMMActivity.getSupportActionBar() != null)
      {
        int m = paramMMActivity.getSupportActionBar().getHeight();
        i = m;
        if (m > 0) {}
      }
      for (int i = paramMMActivity.getResources().getDimensionPixelSize(2131165252);; i = 0)
      {
        i = j - i - ai.iX(paramMMActivity);
        if (k / n * 1.0D > 2.0D) {}
        for (i = (i - tsJ * 3) / 20;; i = (i - tsJ * 3) / 17)
        {
          tsQ = Math.max(i * 4, tsK);
          tsM = (int)(i * 1.5D);
          tsP = Math.max(i * 3, tsL);
          ad.i("MicroMsg.FunctionGridSizeCalculator", "baseA: %s, top height: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(tsQ) });
          AppMethodBeat.o(66031);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.a
 * JD-Core Version:    0.7.0.1
 */