package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/LiveConstants$TimeOut;", "", "()V", "GET_MESSAGE_TIMEOUT", "", "getGET_MESSAGE_TIMEOUT", "()J", "REPLAY_TIMEOUT", "getREPLAY_TIMEOUT", "plugin-logic_release"})
public final class f$h
{
  private static final long gNs = 604800000L;
  private static final long gNt = 5000L;
  public static final h gNu;
  
  static
  {
    AppMethodBeat.i(212046);
    gNu = new h();
    gNs = 604800000L;
    gNt = 5000L;
    AppMethodBeat.o(212046);
  }
  
  public static long anh()
  {
    return gNt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.f.h
 * JD-Core Version:    0.7.0.1
 */