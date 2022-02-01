package com.tencent.mm.plugin.clean.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import java.util.ArrayList;

public final class a
{
  private static long oqA;
  private static final ao oqJ;
  private static ArrayList<Object> oqK;
  private static long oqL;
  private static int oqM;
  private static long oqy;
  private static long oqz;
  
  static
  {
    AppMethodBeat.i(22808);
    oqJ = new ao();
    oqy = 0L;
    oqL = 0L;
    oqA = 0L;
    oqz = 0L;
    oqM = 0;
    AppMethodBeat.o(22808);
  }
  
  public static final void bVb()
  {
    AppMethodBeat.i(22806);
    ac.i("MicroMsg.CleanLogic", "startCleanDataNow");
    oqJ.removeCallbacksAndMessages(null);
    oqy = 0L;
    oqL = 0L;
    ac.i("MicroMsg.CleanLogic", "set analyse data: is null? %b", new Object[] { Boolean.TRUE });
    oqK = null;
    oqM = 0;
    AppMethodBeat.o(22806);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.c.a
 * JD-Core Version:    0.7.0.1
 */