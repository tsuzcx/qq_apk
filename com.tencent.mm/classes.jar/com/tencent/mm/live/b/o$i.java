package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/LiveConstants$TimeOut;", "", "()V", "GET_MESSAGE_TIMEOUT", "", "getGET_MESSAGE_TIMEOUT", "()J", "REPLAY_TIMEOUT", "getREPLAY_TIMEOUT", "plugin-logic_release"})
public final class o$i
{
  private static final long hHe = 604800000L;
  private static final long hHf = 5000L;
  public static final i hHg;
  
  static
  {
    AppMethodBeat.i(207602);
    hHg = new i();
    hHe = 604800000L;
    hHf = 5000L;
    AppMethodBeat.o(207602);
  }
  
  public static long aFJ()
  {
    return hHf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.o.i
 * JD-Core Version:    0.7.0.1
 */