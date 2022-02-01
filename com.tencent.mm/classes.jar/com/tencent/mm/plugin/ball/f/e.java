package com.tencent.mm.plugin.ball.f;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.ar;

public final class e
{
  public static final int nNN;
  public static final int nNO;
  public static final int nNP;
  public static final int nNQ;
  public static final int nNR;
  public static final int nNS;
  public static final int nNT;
  public static final int nNU;
  public static final float nNV;
  public static final int nNW;
  public static final int nNX;
  public static final int nNY;
  public static int nNZ;
  public static final int nOa;
  public static final int nOb;
  public static final int nOc;
  
  static
  {
    AppMethodBeat.i(106369);
    nNN = ar.jN(ak.getContext());
    nNO = ak.getContext().getResources().getDimensionPixelSize(2131166326);
    nNP = ak.getContext().getResources().getDimensionPixelSize(2131166330);
    nNQ = a.ay(ak.getContext(), 2131166329);
    nNR = a.ay(ak.getContext(), 2131166327);
    nNS = a.ay(ak.getContext(), 2131166328);
    nNT = ak.getContext().getResources().getDimensionPixelSize(2131166361);
    int i = ak.getContext().getResources().getDimensionPixelSize(2131166360);
    nNU = i;
    nNV = i / nNT;
    nNW = a.iu(ak.getContext()) - (nNP + nNS);
    nNX = nNO + nNN;
    nNY = a.iv(ak.getContext()) - nNO - (nNP + nNQ + nNR);
    nNZ = en(ak.getContext());
    nOa = nNX;
    nOb = nNW;
    nOc = (int)(a.iv(ak.getContext()) * 0.3F);
    AppMethodBeat.o(106369);
  }
  
  private static int en(Context paramContext)
  {
    int i = 0;
    AppMethodBeat.i(106367);
    try
    {
      int j = ar.en(paramContext);
      i = j;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        ae.e("MicroMsg.FloatBallViewConstants", "getNavigationBarHeight exception:%s", new Object[] { paramContext });
      }
    }
    AppMethodBeat.o(106367);
    return i;
  }
  
  public static void eo(Context paramContext)
  {
    AppMethodBeat.i(106368);
    nNZ = en(paramContext);
    AppMethodBeat.o(106368);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(106366);
      nOd = new a("TOP_LEFT", 0);
      nOe = new a("TOP_RIGHT", 1);
      nOf = new a("BOTTOM_LEFT", 2);
      nOg = new a("BOTTOM_RIGHT", 3);
      nOh = new a[] { nOd, nOe, nOf, nOg };
      AppMethodBeat.o(106366);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.f.e
 * JD-Core Version:    0.7.0.1
 */