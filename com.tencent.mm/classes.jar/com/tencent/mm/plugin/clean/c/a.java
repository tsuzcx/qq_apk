package com.tencent.mm.plugin.clean.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.ArrayList;

public final class a
{
  private static final aq paH;
  private static ArrayList<Object> paI;
  private static long paJ;
  private static int paK;
  private static long pav;
  private static long paw;
  private static long pax;
  
  static
  {
    AppMethodBeat.i(22808);
    paH = new aq();
    pav = 0L;
    paJ = 0L;
    pax = 0L;
    paw = 0L;
    paK = 0;
    AppMethodBeat.o(22808);
  }
  
  public static final void caV()
  {
    AppMethodBeat.i(22806);
    ae.i("MicroMsg.CleanLogic", "startCleanDataNow");
    paH.removeCallbacksAndMessages(null);
    pav = 0L;
    paJ = 0L;
    ae.i("MicroMsg.CleanLogic", "set analyse data: is null? %b", new Object[] { Boolean.TRUE });
    paI = null;
    paK = 0;
    AppMethodBeat.o(22806);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.c.a
 * JD-Core Version:    0.7.0.1
 */