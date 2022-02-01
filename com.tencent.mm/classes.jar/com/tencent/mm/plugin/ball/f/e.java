package com.tencent.mm.plugin.ball.f;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.ar;

public final class e
{
  public static final int nIk;
  public static final int nIl;
  public static final int nIm;
  public static final int nIn;
  public static final int nIo;
  public static final int nIp;
  public static final int nIq;
  public static final int nIr;
  public static final float nIs;
  public static final int nIt;
  public static final int nIu;
  public static final int nIv;
  public static int nIw;
  public static final int nIx;
  public static final int nIy;
  public static final int nIz;
  
  static
  {
    AppMethodBeat.i(106369);
    nIk = ar.jG(aj.getContext());
    nIl = aj.getContext().getResources().getDimensionPixelSize(2131166326);
    nIm = aj.getContext().getResources().getDimensionPixelSize(2131166330);
    nIn = a.ay(aj.getContext(), 2131166329);
    nIo = a.ay(aj.getContext(), 2131166327);
    nIp = a.ay(aj.getContext(), 2131166328);
    nIq = aj.getContext().getResources().getDimensionPixelSize(2131166361);
    int i = aj.getContext().getResources().getDimensionPixelSize(2131166360);
    nIr = i;
    nIs = i / nIq;
    nIt = a.ip(aj.getContext()) - (nIm + nIp);
    nIu = nIl + nIk;
    nIv = a.iq(aj.getContext()) - nIl - (nIm + nIn + nIo);
    nIw = ej(aj.getContext());
    nIx = nIu;
    nIy = nIt;
    nIz = (int)(a.iq(aj.getContext()) * 0.3F);
    AppMethodBeat.o(106369);
  }
  
  private static int ej(Context paramContext)
  {
    int i = 0;
    AppMethodBeat.i(106367);
    try
    {
      int j = ar.ej(paramContext);
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
  
  public static void ek(Context paramContext)
  {
    AppMethodBeat.i(106368);
    nIw = ej(paramContext);
    AppMethodBeat.o(106368);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(106366);
      nIA = new a("TOP_LEFT", 0);
      nIB = new a("TOP_RIGHT", 1);
      nIC = new a("BOTTOM_LEFT", 2);
      nID = new a("BOTTOM_RIGHT", 3);
      nIE = new a[] { nIA, nIB, nIC, nID };
      AppMethodBeat.o(106366);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.f.e
 * JD-Core Version:    0.7.0.1
 */