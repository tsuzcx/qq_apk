package com.tencent.d.e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;

public final class f
{
  public static final long LNs;
  public static final long LNt;
  public static final int LNu;
  public static final long LNv;
  
  static
  {
    AppMethodBeat.i(138395);
    LNs = TimeUnit.SECONDS.toMillis(1L);
    LNt = TimeUnit.MILLISECONDS.toMillis(50L);
    LNu = (int)(LNs / LNt);
    LNv = LNs * 3L;
    AppMethodBeat.o(138395);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.e.a.a.f
 * JD-Core Version:    0.7.0.1
 */