package com.tencent.mm.plugin.clean.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.ArrayList;

public final class a
{
  private static final ap nNH;
  private static ArrayList<Object> nNI;
  private static long nNJ;
  private static int nNK;
  private static long nNw;
  private static long nNx;
  private static long nNy;
  
  static
  {
    AppMethodBeat.i(22808);
    nNH = new ap();
    nNw = 0L;
    nNJ = 0L;
    nNy = 0L;
    nNx = 0L;
    nNK = 0;
    AppMethodBeat.o(22808);
  }
  
  public static final void bNQ()
  {
    AppMethodBeat.i(22806);
    ad.i("MicroMsg.CleanLogic", "startCleanDataNow");
    nNH.removeCallbacksAndMessages(null);
    nNw = 0L;
    nNJ = 0L;
    ad.i("MicroMsg.CleanLogic", "set analyse data: is null? %b", new Object[] { Boolean.TRUE });
    nNI = null;
    nNK = 0;
    AppMethodBeat.o(22806);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.c.a
 * JD-Core Version:    0.7.0.1
 */