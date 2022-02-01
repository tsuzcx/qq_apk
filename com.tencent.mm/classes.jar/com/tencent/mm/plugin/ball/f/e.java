package com.tencent.mm.plugin.ball.f;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.ap;

public final class e
{
  public static final int mFJ;
  public static final int mFK;
  public static final int mFL;
  public static final int mFM;
  public static final int mFN;
  public static final int mFO;
  public static final int mFP;
  public static final int mFQ;
  public static final float mFR;
  public static final int mFS;
  public static final int mFT;
  public static final int mFU;
  public static int mFV;
  public static final int mFW;
  public static final int mFX;
  public static final int mFY;
  
  static
  {
    AppMethodBeat.i(106369);
    mFJ = ap.iX(aj.getContext());
    mFK = aj.getContext().getResources().getDimensionPixelSize(2131166326);
    mFL = aj.getContext().getResources().getDimensionPixelSize(2131166330);
    mFM = a.ap(aj.getContext(), 2131166329);
    mFN = a.ap(aj.getContext(), 2131166327);
    mFO = a.ap(aj.getContext(), 2131166328);
    mFP = aj.getContext().getResources().getDimensionPixelSize(2131166361);
    int i = aj.getContext().getResources().getDimensionPixelSize(2131166360);
    mFQ = i;
    mFR = i / mFP;
    mFS = a.hV(aj.getContext()) - (mFL + mFO);
    mFT = mFK + mFJ;
    mFU = a.hW(aj.getContext()) - mFK - (mFL + mFM + mFN);
    mFV = eb(aj.getContext());
    mFW = mFT;
    mFX = mFS;
    mFY = (int)(a.hW(aj.getContext()) * 0.3F);
    AppMethodBeat.o(106369);
  }
  
  private static int eb(Context paramContext)
  {
    int i = 0;
    AppMethodBeat.i(106367);
    try
    {
      int j = ap.eb(paramContext);
      i = j;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        ad.e("MicroMsg.FloatBallViewConstants", "getNavigationBarHeight exception:%s", new Object[] { paramContext });
      }
    }
    AppMethodBeat.o(106367);
    return i;
  }
  
  public static void ec(Context paramContext)
  {
    AppMethodBeat.i(106368);
    mFV = eb(paramContext);
    AppMethodBeat.o(106368);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(106366);
      mFZ = new a("TOP_LEFT", 0);
      mGa = new a("TOP_RIGHT", 1);
      mGb = new a("BOTTOM_LEFT", 2);
      mGc = new a("BOTTOM_RIGHT", 3);
      mGd = new a[] { mFZ, mGa, mGb, mGc };
      AppMethodBeat.o(106366);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.f.e
 * JD-Core Version:    0.7.0.1
 */