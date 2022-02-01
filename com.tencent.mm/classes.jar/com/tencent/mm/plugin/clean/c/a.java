package com.tencent.mm.plugin.clean.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;

public final class a
{
  private static long tOc;
  private static long tOd;
  private static long tOe;
  private static final MMHandler tOo;
  private static ArrayList<Object> tOp;
  private static long tOq;
  private static int tOr;
  
  static
  {
    AppMethodBeat.i(22808);
    tOo = new MMHandler();
    tOc = 0L;
    tOq = 0L;
    tOe = 0L;
    tOd = 0L;
    tOr = 0;
    AppMethodBeat.o(22808);
  }
  
  public static final void cNf()
  {
    AppMethodBeat.i(22806);
    Log.i("MicroMsg.CleanLogic", "startCleanDataNow");
    tOo.removeCallbacksAndMessages(null);
    tOc = 0L;
    tOq = 0L;
    Log.i("MicroMsg.CleanLogic", "set analyse data: is null? %b", new Object[] { Boolean.TRUE });
    tOp = null;
    tOr = 0;
    AppMethodBeat.o(22806);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.c.a
 * JD-Core Version:    0.7.0.1
 */