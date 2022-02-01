package com.google.android.exoplayer2;

import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.UUID;

public final class b
{
  public static final int cFe;
  public static final UUID cFf;
  public static final UUID cFg;
  public static final UUID cFh;
  public static final UUID cFi;
  
  static
  {
    AppMethodBeat.i(91846);
    if (x.SDK_INT < 23) {}
    for (int i = 1020;; i = 6396)
    {
      cFe = i;
      cFf = new UUID(0L, 0L);
      cFg = new UUID(1186680826959645954L, -5988876978535335093L);
      cFh = new UUID(-1301668207276963122L, -6645017420763422227L);
      cFi = new UUID(-7348484286925749626L, -6083546864340672619L);
      AppMethodBeat.o(91846);
      return;
    }
  }
  
  public static long bM(long paramLong)
  {
    if ((paramLong == -9223372036854775807L) || (paramLong == -9223372036854775808L)) {
      return paramLong;
    }
    return paramLong / 1000L;
  }
  
  public static long bN(long paramLong)
  {
    if ((paramLong == -9223372036854775807L) || (paramLong == -9223372036854775808L)) {
      return paramLong;
    }
    return paramLong * 1000L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.b
 * JD-Core Version:    0.7.0.1
 */