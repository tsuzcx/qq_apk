package com.tencent.mm.plugin.clean.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;

public final class a
{
  private static final MMHandler wRE;
  private static ArrayList<Object> wRF;
  private static long wRG;
  private static int wRH;
  private static long wRs;
  private static long wRt;
  private static long wRu;
  
  static
  {
    AppMethodBeat.i(22808);
    wRE = new MMHandler();
    wRs = 0L;
    wRG = 0L;
    wRu = 0L;
    wRt = 0L;
    wRH = 0;
    AppMethodBeat.o(22808);
  }
  
  public static final void dqL()
  {
    AppMethodBeat.i(22806);
    Log.i("MicroMsg.CleanLogic", "startCleanDataNow");
    wRE.removeCallbacksAndMessages(null);
    wRs = 0L;
    wRG = 0L;
    Log.i("MicroMsg.CleanLogic", "set analyse data: is null? %b", new Object[] { Boolean.TRUE });
    wRF = null;
    wRH = 0;
    AppMethodBeat.o(22806);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.c.a
 * JD-Core Version:    0.7.0.1
 */