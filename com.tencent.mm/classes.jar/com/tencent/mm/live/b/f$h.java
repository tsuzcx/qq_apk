package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/LiveConstants$TimeOut;", "", "()V", "GET_MESSAGE_TIMEOUT", "", "getGET_MESSAGE_TIMEOUT", "()J", "REPLAY_TIMEOUT", "getREPLAY_TIMEOUT", "plugin-logic_release"})
public final class f$h
{
  private static final long gQb = 604800000L;
  private static final long gQc = 5000L;
  public static final h gQd;
  
  static
  {
    AppMethodBeat.i(215665);
    gQd = new h();
    gQb = 604800000L;
    gQc = 5000L;
    AppMethodBeat.o(215665);
  }
  
  public static long anx()
  {
    return gQc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.f.h
 * JD-Core Version:    0.7.0.1
 */