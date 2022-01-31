package com.google.android.exoplayer2;

import com.google.android.exoplayer2.i.t;
import java.util.UUID;

public final class b
{
  public static final int CHANNEL_OUT_7POINT1_SURROUND;
  public static final UUID asM;
  public static final UUID asN;
  public static final UUID asO;
  public static final UUID asP;
  
  static
  {
    if (t.SDK_INT < 23) {}
    for (int i = 1020;; i = 6396)
    {
      CHANNEL_OUT_7POINT1_SURROUND = i;
      asM = new UUID(0L, 0L);
      asN = new UUID(1186680826959645954L, -5988876978535335093L);
      asO = new UUID(-1301668207276963122L, -6645017420763422227L);
      asP = new UUID(-7348484286925749626L, -6083546864340672619L);
      return;
    }
  }
  
  public static long q(long paramLong)
  {
    if ((paramLong == -9223372036854775807L) || (paramLong == -9223372036854775808L)) {
      return paramLong;
    }
    return paramLong / 1000L;
  }
  
  public static long r(long paramLong)
  {
    if ((paramLong == -9223372036854775807L) || (paramLong == -9223372036854775808L)) {
      return paramLong;
    }
    return paramLong * 1000L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.b
 * JD-Core Version:    0.7.0.1
 */