package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

public final class a
{
  private static float mvg = 4.5F;
  private static int mvh = 4;
  
  private static int c(Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(6130);
    if (paramContext == null)
    {
      AppMethodBeat.o(6130);
      return 0;
    }
    int k = dX(paramContext);
    int m = eq(paramContext);
    int j = (int)((m - k * paramFloat) / Math.ceil(paramFloat));
    int i = j;
    if (j < 0) {
      i = 0;
    }
    ac.i("MicroMsg.BizTimeLineHotViewConfig", "alvinluo itemWidth: %d, itemPadding: %d, viewWidth: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(m) });
    AppMethodBeat.o(6130);
    return i;
  }
  
  public static int dX(Context paramContext)
  {
    AppMethodBeat.i(6127);
    if (paramContext == null)
    {
      AppMethodBeat.o(6127);
      return 0;
    }
    int i = (int)(com.tencent.mm.cc.a.av(paramContext, 2131165907) * eb(paramContext));
    ac.d("MicroMsg.BizTimeLineHotViewConfig", "alvinluo itemWidth: %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(6127);
    return i;
  }
  
  public static int dY(Context paramContext)
  {
    AppMethodBeat.i(6128);
    int i = c(paramContext, mvg);
    AppMethodBeat.o(6128);
    return i;
  }
  
  public static float eb(Context paramContext)
  {
    AppMethodBeat.i(6132);
    float f2 = com.tencent.mm.cc.a.eb(paramContext);
    float f1;
    if ((f2 != com.tencent.mm.cc.a.hU(paramContext)) && (f2 != com.tencent.mm.cc.a.hV(paramContext)))
    {
      f1 = f2;
      if (f2 != com.tencent.mm.cc.a.hW(paramContext)) {}
    }
    else
    {
      f1 = com.tencent.mm.cc.a.hT(paramContext);
    }
    AppMethodBeat.o(6132);
    return f1;
  }
  
  private static int eq(Context paramContext)
  {
    AppMethodBeat.i(6129);
    try
    {
      int i = paramContext.getResources().getDisplayMetrics().widthPixels;
      AppMethodBeat.o(6129);
      return i;
    }
    catch (Exception paramContext)
    {
      ac.printErrStackTrace("MicroMsg.BizTimeLineHotViewConfig", paramContext, "alvinluo getViewWidth exception", new Object[0]);
      AppMethodBeat.o(6129);
    }
    return 0;
  }
  
  public static int er(Context paramContext)
  {
    AppMethodBeat.i(6131);
    int i = (int)(com.tencent.mm.cc.a.av(paramContext, 2131165906) * eb(paramContext));
    AppMethodBeat.o(6131);
    return i;
  }
  
  public static int getCompletelyCountPerPage()
  {
    return mvh;
  }
  
  public static float getShowCountPerPage()
  {
    return mvg;
  }
  
  public static void init(Context paramContext)
  {
    AppMethodBeat.i(6126);
    if (c(paramContext, 4.5F) <= com.tencent.mm.cc.a.fromDPToPix(paramContext, 10))
    {
      mvg = 3.5F;
      mvh = 3;
      AppMethodBeat.o(6126);
      return;
    }
    mvg = 4.5F;
    mvh = 4;
    AppMethodBeat.o(6126);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.a
 * JD-Core Version:    0.7.0.1
 */