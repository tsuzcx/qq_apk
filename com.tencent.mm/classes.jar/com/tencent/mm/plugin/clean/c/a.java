package com.tencent.mm.plugin.clean.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;

public final class a
{
  private static final MMHandler qpF;
  private static ArrayList<Object> qpG;
  private static long qpH;
  private static int qpI;
  private static long qpt;
  private static long qpu;
  private static long qpv;
  
  static
  {
    AppMethodBeat.i(22808);
    qpF = new MMHandler();
    qpt = 0L;
    qpH = 0L;
    qpv = 0L;
    qpu = 0L;
    qpI = 0;
    AppMethodBeat.o(22808);
  }
  
  public static final void cyK()
  {
    AppMethodBeat.i(22806);
    Log.i("MicroMsg.CleanLogic", "startCleanDataNow");
    qpF.removeCallbacksAndMessages(null);
    qpt = 0L;
    qpH = 0L;
    Log.i("MicroMsg.CleanLogic", "set analyse data: is null? %b", new Object[] { Boolean.TRUE });
    qpG = null;
    qpI = 0;
    AppMethodBeat.o(22806);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.c.a
 * JD-Core Version:    0.7.0.1
 */