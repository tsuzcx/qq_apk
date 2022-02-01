package com.tencent.d.e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;

public final class f
{
  public static final long Mkr;
  public static final long Mks;
  public static final int Mkt;
  public static final long Mku;
  
  static
  {
    AppMethodBeat.i(138395);
    Mkr = TimeUnit.SECONDS.toMillis(1L);
    Mks = TimeUnit.MILLISECONDS.toMillis(50L);
    Mkt = (int)(Mkr / Mks);
    Mku = Mkr * 3L;
    AppMethodBeat.o(138395);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.e.a.a.f
 * JD-Core Version:    0.7.0.1
 */