package com.tencent.mm.plugin.ball.f;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.ball.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ax;

public final class e
{
  public static final int saJ;
  public static final int saK;
  public static final int saL;
  public static final int saM;
  public static final int saN;
  public static final int saO;
  public static final int saP;
  public static final int saQ;
  public static final float saR;
  public static final int saS;
  public static final int saT;
  public static final int saU;
  public static int saV;
  public static final int saW;
  public static final int saX;
  
  static
  {
    AppMethodBeat.i(106369);
    saJ = ax.getStatusBarHeight(MMApplicationContext.getContext());
    saK = MMApplicationContext.getContext().getResources().getDimensionPixelSize(a.c.float_ball_outer_margin);
    saL = MMApplicationContext.getContext().getResources().getDimensionPixelSize(a.c.float_ball_size);
    saM = a.aZ(MMApplicationContext.getContext(), a.c.float_ball_shadow_top);
    saN = a.aZ(MMApplicationContext.getContext(), a.c.float_ball_shadow_bottom);
    saO = a.aZ(MMApplicationContext.getContext(), a.c.float_ball_shadow_horizontal);
    saP = MMApplicationContext.getContext().getResources().getDimensionPixelSize(a.c.float_corner_view_size);
    int i = MMApplicationContext.getContext().getResources().getDimensionPixelSize(a.c.float_corner_view_scale_size);
    saQ = i;
    saR = i / saP;
    saS = a.kr(MMApplicationContext.getContext()) - (saL + saO);
    saT = saK + saJ;
    saU = a.ks(MMApplicationContext.getContext()) - saK - (saL + saM + saN);
    saV = aB(MMApplicationContext.getContext());
    saW = saT;
    saX = (int)(a.ks(MMApplicationContext.getContext()) * 0.3F);
    AppMethodBeat.o(106369);
  }
  
  private static int aB(Context paramContext)
  {
    int i = 0;
    AppMethodBeat.i(106367);
    try
    {
      int j = ax.aB(paramContext);
      i = j;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        Log.e("MicroMsg.FloatBallViewConstants", "getNavigationBarHeight exception:%s", new Object[] { paramContext });
      }
    }
    AppMethodBeat.o(106367);
    return i;
  }
  
  public static void eJ(Context paramContext)
  {
    AppMethodBeat.i(106368);
    saV = aB(paramContext);
    AppMethodBeat.o(106368);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.f.e
 * JD-Core Version:    0.7.0.1
 */