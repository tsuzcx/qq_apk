package com.tencent.e.e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;

public final class f
{
  public static final long BkP;
  public static final long BkQ;
  public static final int BkR;
  public static final long BkS;
  
  static
  {
    AppMethodBeat.i(114554);
    BkP = TimeUnit.SECONDS.toMillis(1L);
    BkQ = TimeUnit.MILLISECONDS.toMillis(50L);
    BkR = (int)(BkP / BkQ);
    BkS = BkP * 3L;
    AppMethodBeat.o(114554);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.e.e.a.a.f
 * JD-Core Version:    0.7.0.1
 */