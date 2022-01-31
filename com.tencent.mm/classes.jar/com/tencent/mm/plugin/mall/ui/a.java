package com.tencent.mm.plugin.mall.ui;

import android.graphics.Point;
import android.support.v7.app.ActionBar;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ak;

public final class a
{
  private static int lYD = 39;
  private static int lYE = 40;
  private static int lYF = 95;
  private static int lYG = 0;
  private static int lYH = 0;
  private static int lYI = 70;
  private static int lYJ = 38;
  
  public static void b(MMActivity paramMMActivity, boolean paramBoolean)
  {
    int k = com.tencent.mm.cb.a.fromDPToPix(paramMMActivity, lYD);
    int m = com.tencent.mm.cb.a.fromDPToPix(paramMMActivity, lYE);
    int j = ak.gx(paramMMActivity).y;
    int i = j;
    if (ak.gw(paramMMActivity)) {
      i = j - ak.gv(paramMMActivity);
    }
    if (paramMMActivity.getSupportActionBar() != null) {}
    for (j = paramMMActivity.getSupportActionBar().getHeight();; j = 0)
    {
      int n = com.tencent.mm.cb.a.fromDPToPix(paramMMActivity, lYF);
      lYG = Math.round((i - k * 2 - m - j) / 5.0F);
      y.i("MicroMsg.FunctionGridSizeCalculator", "calc GRID_HEIGHT_SIZE_PX: %s, minHeight: %s", new Object[] { Integer.valueOf(lYG), Integer.valueOf(n) });
      if (lYG < n) {
        lYG = n;
      }
      lYH = Math.round(lYG * 4 / 3.0F) + com.tencent.mm.cb.a.fromDPToPix(paramMMActivity, lYI);
      if (paramBoolean) {
        lYH += com.tencent.mm.cb.a.fromDPToPix(paramMMActivity, lYJ);
      }
      y.i("MicroMsg.FunctionGridSizeCalculator", "calcGridSize, GRID_HEIGHT_SIZE_PX: %s, TOP_FUNC_LINE_GRID_SIZE_PX: %s", new Object[] { Integer.valueOf(lYG), Integer.valueOf(lYH) });
      return;
    }
  }
  
  public static int bgA()
  {
    return lYG;
  }
  
  public static int bgB()
  {
    return lYH;
  }
  
  public static int bgC()
  {
    return com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), lYD);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.a
 * JD-Core Version:    0.7.0.1
 */