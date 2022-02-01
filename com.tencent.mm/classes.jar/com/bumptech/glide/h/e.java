package com.bumptech.glide.h;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  private static final double aNZ;
  
  static
  {
    double d = 1.0D;
    AppMethodBeat.i(77748);
    if (Build.VERSION.SDK_INT >= 17) {
      d = 1.0D / Math.pow(10.0D, 6.0D);
    }
    aNZ = d;
    AppMethodBeat.o(77748);
  }
  
  public static double p(long paramLong)
  {
    AppMethodBeat.i(77747);
    double d1 = qq() - paramLong;
    double d2 = aNZ;
    AppMethodBeat.o(77747);
    return d1 * d2;
  }
  
  @TargetApi(17)
  public static long qq()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.h.e
 * JD-Core Version:    0.7.0.1
 */