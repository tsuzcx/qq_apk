package com.tencent.e.e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;

public final class f
{
  public static final long RMR;
  public static final long RMS;
  public static final int RMT;
  public static final long RMU;
  
  static
  {
    AppMethodBeat.i(138395);
    RMR = TimeUnit.SECONDS.toMillis(1L);
    RMS = TimeUnit.MILLISECONDS.toMillis(50L);
    RMT = (int)(RMR / RMS);
    RMU = RMR * 3L;
    AppMethodBeat.o(138395);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.e.e.a.a.f
 * JD-Core Version:    0.7.0.1
 */