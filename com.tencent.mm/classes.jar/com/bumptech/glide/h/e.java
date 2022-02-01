package com.bumptech.glide.h;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  private static final double aLs;
  
  static
  {
    double d = 1.0D;
    AppMethodBeat.i(77748);
    if (Build.VERSION.SDK_INT >= 17) {
      d = 1.0D / Math.pow(10.0D, 6.0D);
    }
    aLs = d;
    AppMethodBeat.o(77748);
  }
  
  public static double n(long paramLong)
  {
    AppMethodBeat.i(77747);
    double d1 = pO() - paramLong;
    double d2 = aLs;
    AppMethodBeat.o(77747);
    return d1 * d2;
  }
  
  @TargetApi(17)
  public static long pO()
  {
    AppMethodBeat.i(77746);
    if (Build.VERSION.SDK_INT >= 17)
    {
      l = SystemClock.elapsedRealtimeNanos();
      AppMethodBeat.o(77746);
      return l;
    }
    long l = SystemClock.uptimeMillis();
    AppMethodBeat.o(77746);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.h.e
 * JD-Core Version:    0.7.0.1
 */