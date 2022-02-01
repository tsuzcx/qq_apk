package com.tencent.mm.plugin.ball.f;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.ap;

public final class e
{
  public static final int nhO;
  public static final int nhP;
  public static final int nhQ;
  public static final int nhR;
  public static final int nhS;
  public static final int nhT;
  public static final int nhU;
  public static final int nhV;
  public static final float nhW;
  public static final int nhX;
  public static final int nhY;
  public static final int nhZ;
  public static int nia;
  public static final int nib;
  public static final int nic;
  public static final int nid;
  
  static
  {
    AppMethodBeat.i(106369);
    nhO = ap.ji(ai.getContext());
    nhP = ai.getContext().getResources().getDimensionPixelSize(2131166326);
    nhQ = ai.getContext().getResources().getDimensionPixelSize(2131166330);
    nhR = a.av(ai.getContext(), 2131166329);
    nhS = a.av(ai.getContext(), 2131166327);
    nhT = a.av(ai.getContext(), 2131166328);
    nhU = ai.getContext().getResources().getDimensionPixelSize(2131166361);
    int i = ai.getContext().getResources().getDimensionPixelSize(2131166360);
    nhV = i;
    nhW = i / nhU;
    nhX = a.ig(ai.getContext()) - (nhQ + nhT);
    nhY = nhP + nhO;
    nhZ = a.ih(ai.getContext()) - nhP - (nhQ + nhR + nhS);
    nia = ej(ai.getContext());
    nib = nhY;
    nic = nhX;
    nid = (int)(a.ih(ai.getContext()) * 0.3F);
    AppMethodBeat.o(106369);
  }
  
  private static int ej(Context paramContext)
  {
    int i = 0;
    AppMethodBeat.i(106367);
    try
    {
      int j = ap.ej(paramContext);
      i = j;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        ac.e("MicroMsg.FloatBallViewConstants", "getNavigationBarHeight exception:%s", new Object[] { paramContext });
      }
    }
    AppMethodBeat.o(106367);
    return i;
  }
  
  public static void ek(Context paramContext)
  {
    AppMethodBeat.i(106368);
    nia = ej(paramContext);
    AppMethodBeat.o(106368);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(106366);
      nie = new a("TOP_LEFT", 0);
      nif = new a("TOP_RIGHT", 1);
      nig = new a("BOTTOM_LEFT", 2);
      nih = new a("BOTTOM_RIGHT", 3);
      nii = new a[] { nie, nif, nig, nih };
      AppMethodBeat.o(106366);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.f.e
 * JD-Core Version:    0.7.0.1
 */