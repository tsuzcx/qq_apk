package com.tencent.mm.plugin.ball.f;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.au;

public final class e
{
  public static final int oYI;
  public static final int oYJ;
  public static final int oYK;
  public static final int oYL;
  public static final int oYM;
  public static final int oYN;
  public static final int oYO;
  public static final int oYP;
  public static final float oYQ;
  public static final int oYR;
  public static final int oYS;
  public static final int oYT;
  public static int oYU;
  public static final int oYV;
  public static final int oYW;
  
  static
  {
    AppMethodBeat.i(106369);
    oYI = au.getStatusBarHeight(MMApplicationContext.getContext());
    oYJ = MMApplicationContext.getContext().getResources().getDimensionPixelSize(2131166414);
    oYK = MMApplicationContext.getContext().getResources().getDimensionPixelSize(2131166419);
    oYL = a.aH(MMApplicationContext.getContext(), 2131166418);
    oYM = a.aH(MMApplicationContext.getContext(), 2131166415);
    oYN = a.aH(MMApplicationContext.getContext(), 2131166416);
    oYO = MMApplicationContext.getContext().getResources().getDimensionPixelSize(2131166453);
    int i = MMApplicationContext.getContext().getResources().getDimensionPixelSize(2131166452);
    oYP = i;
    oYQ = i / oYO;
    oYR = a.jn(MMApplicationContext.getContext()) - (oYK + oYN);
    oYS = oYJ + oYI;
    oYT = a.jo(MMApplicationContext.getContext()) - oYJ - (oYK + oYL + oYM);
    oYU = aD(MMApplicationContext.getContext());
    oYV = oYS;
    oYW = (int)(a.jo(MMApplicationContext.getContext()) * 0.3F);
    AppMethodBeat.o(106369);
  }
  
  private static int aD(Context paramContext)
  {
    int i = 0;
    AppMethodBeat.i(106367);
    try
    {
      int j = au.aD(paramContext);
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
  
  public static void eG(Context paramContext)
  {
    AppMethodBeat.i(106368);
    oYU = aD(paramContext);
    AppMethodBeat.o(106368);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.f.e
 * JD-Core Version:    0.7.0.1
 */