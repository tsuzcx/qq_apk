package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
{
  private static float jdk = 4.5F;
  private static int jdl = 4;
  
  private static int d(Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(14338);
    if (paramContext == null)
    {
      AppMethodBeat.o(14338);
      return 0;
    }
    int k = dn(paramContext);
    int m = dB(paramContext);
    int j = (int)((m - k * paramFloat) / Math.ceil(paramFloat));
    int i = j;
    if (j < 0) {
      i = 0;
    }
    ab.d("MicroMsg.BizTimeLineHotViewConfig", "alvinluo itemWidth: %d, itemPadding: %d, viewWidth: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(m) });
    AppMethodBeat.o(14338);
    return i;
  }
  
  private static int dB(Context paramContext)
  {
    AppMethodBeat.i(14337);
    try
    {
      int i = paramContext.getResources().getDisplayMetrics().widthPixels;
      AppMethodBeat.o(14337);
      return i;
    }
    catch (Exception paramContext)
    {
      ab.printErrStackTrace("MicroMsg.BizTimeLineHotViewConfig", paramContext, "alvinluo getViewWidth exception", new Object[0]);
      AppMethodBeat.o(14337);
    }
    return 0;
  }
  
  public static int dC(Context paramContext)
  {
    AppMethodBeat.i(14339);
    int i = (int)(com.tencent.mm.cb.a.ap(paramContext, 2131428126) * dr(paramContext));
    AppMethodBeat.o(14339);
    return i;
  }
  
  public static int dn(Context paramContext)
  {
    AppMethodBeat.i(14335);
    if (paramContext == null)
    {
      AppMethodBeat.o(14335);
      return 0;
    }
    int i = (int)(com.tencent.mm.cb.a.ap(paramContext, 2131428127) * dr(paramContext));
    ab.d("MicroMsg.BizTimeLineHotViewConfig", "alvinluo itemWidth: %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(14335);
    return i;
  }
  
  public static int jdMethod_do(Context paramContext)
  {
    AppMethodBeat.i(14336);
    int i = d(paramContext, jdk);
    AppMethodBeat.o(14336);
    return i;
  }
  
  private static float dr(Context paramContext)
  {
    AppMethodBeat.i(14340);
    float f2 = com.tencent.mm.cb.a.dr(paramContext);
    float f1;
    if ((f2 != com.tencent.mm.cb.a.gk(paramContext)) && (f2 != com.tencent.mm.cb.a.gl(paramContext)))
    {
      f1 = f2;
      if (f2 != com.tencent.mm.cb.a.gm(paramContext)) {}
    }
    else
    {
      f1 = com.tencent.mm.cb.a.gj(paramContext);
    }
    AppMethodBeat.o(14340);
    return f1;
  }
  
  public static int getCompletelyCountPerPage()
  {
    return jdl;
  }
  
  public static float getShowCountPerPage()
  {
    return jdk;
  }
  
  public static void init(Context paramContext)
  {
    AppMethodBeat.i(14334);
    if (d(paramContext, 4.5F) <= com.tencent.mm.cb.a.fromDPToPix(paramContext, 10))
    {
      jdk = 3.5F;
      jdl = 3;
      AppMethodBeat.o(14334);
      return;
    }
    jdk = 4.5F;
    jdl = 4;
    AppMethodBeat.o(14334);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.a
 * JD-Core Version:    0.7.0.1
 */