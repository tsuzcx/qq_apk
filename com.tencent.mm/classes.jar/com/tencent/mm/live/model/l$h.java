package com.tencent.mm.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/LiveConstants$TimeOut;", "", "()V", "GET_MESSAGE_TIMEOUT", "", "getGET_MESSAGE_TIMEOUT", "()J", "REPLAY_TIMEOUT", "getREPLAY_TIMEOUT", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l$h
{
  public static final h mYE;
  private static final long mYF;
  private static final long mYG;
  
  static
  {
    AppMethodBeat.i(246654);
    mYE = new h();
    mYF = 604800000L;
    mYG = 5000L;
    AppMethodBeat.o(246654);
  }
  
  public static long bhB()
  {
    return mYG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.model.l.h
 * JD-Core Version:    0.7.0.1
 */