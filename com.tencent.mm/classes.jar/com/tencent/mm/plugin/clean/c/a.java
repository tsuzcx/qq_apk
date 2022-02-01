package com.tencent.mm.plugin.clean.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.ArrayList;

public final class a
{
  private static long oTT;
  private static long oTU;
  private static long oTV;
  private static final ap oUe;
  private static ArrayList<Object> oUf;
  private static long oUg;
  private static int oUh;
  
  static
  {
    AppMethodBeat.i(22808);
    oUe = new ap();
    oTT = 0L;
    oUg = 0L;
    oTV = 0L;
    oTU = 0L;
    oUh = 0;
    AppMethodBeat.o(22808);
  }
  
  public static final void bZG()
  {
    AppMethodBeat.i(22806);
    ad.i("MicroMsg.CleanLogic", "startCleanDataNow");
    oUe.removeCallbacksAndMessages(null);
    oTT = 0L;
    oUg = 0L;
    ad.i("MicroMsg.CleanLogic", "set analyse data: is null? %b", new Object[] { Boolean.TRUE });
    oUf = null;
    oUh = 0;
    AppMethodBeat.o(22806);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.c.a
 * JD-Core Version:    0.7.0.1
 */