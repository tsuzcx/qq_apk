package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
{
  private static float omJ = 4.5F;
  private static int omK = 4;
  
  private static int c(Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(6130);
    if (paramContext == null)
    {
      AppMethodBeat.o(6130);
      return 0;
    }
    int k = ev(paramContext);
    int m = eM(paramContext);
    int j = (int)(2.0F * (m - k * paramFloat) / (Math.floor(paramFloat) * 2.0D + 1.0D));
    int i = j;
    if (j < 0) {
      i = 0;
    }
    Log.i("MicroMsg.BizTimeLineHotViewConfig", "alvinluo getItemPadding itemWidth: %d, itemPadding: %d, viewWidth: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(m) });
    AppMethodBeat.o(6130);
    return i;
  }
  
  private static int eM(Context paramContext)
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
      Log.printErrStackTrace("MicroMsg.BizTimeLineHotViewConfig", paramContext, "alvinluo getViewWidth exception", new Object[0]);
      AppMethodBeat.o(6129);
    }
    return 0;
  }
  
  public static int eN(Context paramContext)
  {
    AppMethodBeat.i(195012);
    if (paramContext == null)
    {
      AppMethodBeat.o(195012);
      return 0;
    }
    int i = (int)(eM(paramContext) * 2 / (Math.floor(omJ) * 2.0D + 1.0D));
    AppMethodBeat.o(195012);
    return i;
  }
  
  public static int eO(Context paramContext)
  {
    AppMethodBeat.i(6131);
    int i = (int)(com.tencent.mm.cb.a.aH(paramContext, 2131165933) * ez(paramContext));
    AppMethodBeat.o(6131);
    return i;
  }
  
  public static int eP(Context paramContext)
  {
    AppMethodBeat.i(195013);
    int i = (int)(com.tencent.mm.cb.a.aH(paramContext, 2131165932) * ez(paramContext));
    AppMethodBeat.o(195013);
    return i;
  }
  
  public static int ev(Context paramContext)
  {
    AppMethodBeat.i(6127);
    if (paramContext == null)
    {
      AppMethodBeat.o(6127);
      return 0;
    }
    int i = (int)(com.tencent.mm.cb.a.aH(paramContext, 2131165934) * ez(paramContext));
    Log.d("MicroMsg.BizTimeLineHotViewConfig", "alvinluo itemWidth: %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(6127);
    return i;
  }
  
  public static int ew(Context paramContext)
  {
    AppMethodBeat.i(6128);
    int i = c(paramContext, omJ);
    AppMethodBeat.o(6128);
    return i;
  }
  
  private static float ez(Context paramContext)
  {
    AppMethodBeat.i(6132);
    float f2 = com.tencent.mm.cb.a.ez(paramContext);
    float f1;
    if ((f2 != com.tencent.mm.cb.a.jb(paramContext)) && (f2 != com.tencent.mm.cb.a.jc(paramContext)))
    {
      f1 = f2;
      if (f2 != com.tencent.mm.cb.a.jd(paramContext)) {}
    }
    else
    {
      f1 = com.tencent.mm.cb.a.ja(paramContext);
    }
    AppMethodBeat.o(6132);
    return f1;
  }
  
  public static int getCompletelyCountPerPage()
  {
    return omK;
  }
  
  public static float getShowCountPerPage()
  {
    return omJ;
  }
  
  public static void init(Context paramContext)
  {
    AppMethodBeat.i(6126);
    if (c(paramContext, 4.5F) <= com.tencent.mm.cb.a.fromDPToPix(paramContext, 8))
    {
      omJ = 3.5F;
      omK = 3;
      AppMethodBeat.o(6126);
      return;
    }
    omJ = 4.5F;
    omK = 4;
    AppMethodBeat.o(6126);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.a
 * JD-Core Version:    0.7.0.1
 */