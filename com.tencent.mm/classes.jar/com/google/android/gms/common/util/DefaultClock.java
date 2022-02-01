package com.google.android.gms.common.util;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class DefaultClock
  implements Clock
{
  private static final DefaultClock zzzk;
  
  static
  {
    AppMethodBeat.i(5189);
    zzzk = new DefaultClock();
    AppMethodBeat.o(5189);
  }
  
  public static Clock getInstance()
  {
    return zzzk;
  }
  
  public long currentThreadTimeMillis()
  {
    AppMethodBeat.i(5188);
    long l = SystemClock.currentThreadTimeMillis();
    AppMethodBeat.o(5188);
    return l;
  }
  
  public long currentTimeMillis()
  {
    AppMethodBeat.i(5185);
    long l = System.currentTimeMillis();
    AppMethodBeat.o(5185);
    return l;
  }
  
  public long elapsedRealtime()
  {
    AppMethodBeat.i(5186);
    long l = SystemClock.elapsedRealtime();
    AppMethodBeat.o(5186);
    return l;
  }
  
  public long nanoTime()
  {
    AppMethodBeat.i(5187);
    long l = System.nanoTime();
    AppMethodBeat.o(5187);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.util.DefaultClock
 * JD-Core Version:    0.7.0.1
 */