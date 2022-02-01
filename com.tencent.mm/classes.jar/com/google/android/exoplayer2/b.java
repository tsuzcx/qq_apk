package com.google.android.exoplayer2;

import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.UUID;

public final class b
{
  public static final int CHANNEL_OUT_7POINT1_SURROUND;
  public static final UUID bbJ;
  public static final UUID bbK;
  public static final UUID bbL;
  public static final UUID bbM;
  
  static
  {
    AppMethodBeat.i(91846);
    if (x.SDK_INT < 23) {}
    for (int i = 1020;; i = 6396)
    {
      CHANNEL_OUT_7POINT1_SURROUND = i;
      bbJ = new UUID(0L, 0L);
      bbK = new UUID(1186680826959645954L, -5988876978535335093L);
      bbL = new UUID(-1301668207276963122L, -6645017420763422227L);
      bbM = new UUID(-7348484286925749626L, -6083546864340672619L);
      AppMethodBeat.o(91846);
      return;
    }
  }
  
  public static long v(long paramLong)
  {
    if ((paramLong == -9223372036854775807L) || (paramLong == -9223372036854775808L)) {
      return paramLong;
    }
    return paramLong / 1000L;
  }
  
  public static long w(long paramLong)
  {
    if ((paramLong == -9223372036854775807L) || (paramLong == -9223372036854775808L)) {
      return paramLong;
    }
    return paramLong * 1000L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.b
 * JD-Core Version:    0.7.0.1
 */