package com.tencent.d.e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;

public final class f
{
  public static final long ZpA;
  public static final long Zpx;
  public static final long Zpy;
  public static final int Zpz;
  
  static
  {
    AppMethodBeat.i(138395);
    Zpx = TimeUnit.SECONDS.toMillis(1L);
    Zpy = TimeUnit.MILLISECONDS.toMillis(50L);
    Zpz = (int)(Zpx / Zpy);
    ZpA = Zpx * 3L;
    AppMethodBeat.o(138395);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.e.a.a.f
 * JD-Core Version:    0.7.0.1
 */