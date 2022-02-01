package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
{
  private static float lTe = 4.5F;
  private static int lTf = 4;
  
  private static int c(Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(6130);
    if (paramContext == null)
    {
      AppMethodBeat.o(6130);
      return 0;
    }
    int k = dP(paramContext);
    int m = ei(paramContext);
    int j = (int)((m - k * paramFloat) / Math.ceil(paramFloat));
    int i = j;
    if (j < 0) {
      i = 0;
    }
    ad.i("MicroMsg.BizTimeLineHotViewConfig", "alvinluo itemWidth: %d, itemPadding: %d, viewWidth: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(m) });
    AppMethodBeat.o(6130);
    return i;
  }
  
  public static int dP(Context paramContext)
  {
    AppMethodBeat.i(6127);
    if (paramContext == null)
    {
      AppMethodBeat.o(6127);
      return 0;
    }
    int i = (int)(com.tencent.mm.cd.a.ap(paramContext, 2131165907) * dT(paramContext));
    ad.d("MicroMsg.BizTimeLineHotViewConfig", "alvinluo itemWidth: %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(6127);
    return i;
  }
  
  public static int dQ(Context paramContext)
  {
    AppMethodBeat.i(6128);
    int i = c(paramContext, lTe);
    AppMethodBeat.o(6128);
    return i;
  }
  
  private static float dT(Context paramContext)
  {
    AppMethodBeat.i(6132);
    float f2 = com.tencent.mm.cd.a.dT(paramContext);
    float f1;
    if ((f2 != com.tencent.mm.cd.a.hJ(paramContext)) && (f2 != com.tencent.mm.cd.a.hK(paramContext)))
    {
      f1 = f2;
      if (f2 != com.tencent.mm.cd.a.hL(paramContext)) {}
    }
    else
    {
      f1 = com.tencent.mm.cd.a.hI(paramContext);
    }
    AppMethodBeat.o(6132);
    return f1;
  }
  
  private static int ei(Context paramContext)
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
      ad.printErrStackTrace("MicroMsg.BizTimeLineHotViewConfig", paramContext, "alvinluo getViewWidth exception", new Object[0]);
      AppMethodBeat.o(6129);
    }
    return 0;
  }
  
  public static int ej(Context paramContext)
  {
    AppMethodBeat.i(6131);
    int i = (int)(com.tencent.mm.cd.a.ap(paramContext, 2131165906) * dT(paramContext));
    AppMethodBeat.o(6131);
    return i;
  }
  
  public static int getCompletelyCountPerPage()
  {
    return lTf;
  }
  
  public static float getShowCountPerPage()
  {
    return lTe;
  }
  
  public static void init(Context paramContext)
  {
    AppMethodBeat.i(6126);
    if (c(paramContext, 4.5F) <= com.tencent.mm.cd.a.fromDPToPix(paramContext, 10))
    {
      lTe = 3.5F;
      lTf = 3;
      AppMethodBeat.o(6126);
      return;
    }
    lTe = 4.5F;
    lTf = 4;
    AppMethodBeat.o(6126);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.a
 * JD-Core Version:    0.7.0.1
 */