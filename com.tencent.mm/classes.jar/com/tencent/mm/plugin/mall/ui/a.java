package com.tencent.mm.plugin.mall.ui;

import android.content.res.Resources;
import android.graphics.Point;
import android.support.v7.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;

public final class a
{
  public static final int oyi;
  public static final int oyj;
  public static final int oyk;
  private static int oyl;
  private static int oym;
  private static int oyn;
  private static int oyo;
  private static int oyp;
  private static int oyq;
  private static int oyr;
  
  static
  {
    AppMethodBeat.i(43134);
    oyi = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 8);
    oyj = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 140);
    oyk = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 85);
    oyl = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 39);
    oym = 40;
    oyn = 95;
    oyo = 0;
    oyp = 0;
    oyq = 70;
    oyr = 38;
    AppMethodBeat.o(43134);
  }
  
  public static void a(MMActivity paramMMActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(43133);
    int n;
    int k;
    if (paramBoolean2)
    {
      Point localPoint = af.hQ(paramMMActivity);
      n = localPoint.x;
      k = localPoint.y;
      if (!af.hO(paramMMActivity)) {
        break label412;
      }
    }
    label412:
    for (int j = k - af.fx(paramMMActivity);; j = k)
    {
      int m;
      if (paramMMActivity.getSupportActionBar() != null)
      {
        m = paramMMActivity.getSupportActionBar().getHeight();
        i = m;
        if (m > 0) {}
      }
      for (int i = paramMMActivity.getResources().getDimensionPixelSize(2131427559);; i = 0)
      {
        i = j - i - af.getStatusBarHeight(paramMMActivity);
        if (k / n * 1.0D > 2.0D) {}
        for (i = (i - oyi * 3) / 20;; i = (i - oyi * 3) / 17)
        {
          oyp = Math.max(i * 4, oyj);
          oyl = (int)(i * 1.5D);
          oyo = Math.max(i * 3, oyk);
          ab.i("MicroMsg.FunctionGridSizeCalculator", "baseA: %s, top height: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(oyp) });
          AppMethodBeat.o(43133);
          return;
        }
        k = oyl;
        m = com.tencent.mm.cb.a.fromDPToPix(paramMMActivity, oym);
        j = af.hQ(paramMMActivity).y;
        i = j;
        if (af.hO(paramMMActivity)) {
          i = j - af.fx(paramMMActivity);
        }
        if (paramMMActivity.getSupportActionBar() != null) {}
        for (j = paramMMActivity.getSupportActionBar().getHeight();; j = 0)
        {
          n = com.tencent.mm.cb.a.fromDPToPix(paramMMActivity, oyn);
          oyo = Math.round((i - k * 2 - m - j) / 5.0F);
          ab.i("MicroMsg.FunctionGridSizeCalculator", "calc GRID_HEIGHT_SIZE_PX: %s, minHeight: %s", new Object[] { Integer.valueOf(oyo), Integer.valueOf(n) });
          if (oyo < n) {
            oyo = n;
          }
          oyp = Math.round(oyo * 4 / 3.0F) + com.tencent.mm.cb.a.fromDPToPix(paramMMActivity, oyq);
          if (paramBoolean1) {
            oyp += com.tencent.mm.cb.a.fromDPToPix(paramMMActivity, oyr);
          }
          ab.i("MicroMsg.FunctionGridSizeCalculator", "calcGridSize, GRID_HEIGHT_SIZE_PX: %s, TOP_FUNC_LINE_GRID_SIZE_PX: %s", new Object[] { Integer.valueOf(oyo), Integer.valueOf(oyp) });
          AppMethodBeat.o(43133);
          return;
        }
      }
    }
  }
  
  public static int bOt()
  {
    return oyo;
  }
  
  public static int bOu()
  {
    return oyp;
  }
  
  public static int bOv()
  {
    return oyl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.a
 * JD-Core Version:    0.7.0.1
 */