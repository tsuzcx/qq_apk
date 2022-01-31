package com.google.android.gms.common.util;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class DefaultClock
  implements Clock
{
  private static final DefaultClock zzzk;
  
  static
  {
    AppMethodBeat.i(90167);
    zzzk = new DefaultClock();
    AppMethodBeat.o(90167);
  }
  
  public static Clock getInstance()
  {
    return zzzk;
  }
  
  public long currentThreadTimeMillis()
  {
    AppMethodBeat.i(90166);
    long l = SystemClock.currentThreadTimeMillis();
    AppMethodBeat.o(90166);
    return l;
  }
  
  public long currentTimeMillis()
  {
    AppMethodBeat.i(90163);
    long l = System.currentTimeMillis();
    AppMethodBeat.o(90163);
    return l;
  }
  
  public long elapsedRealtime()
  {
    AppMethodBeat.i(90164);
    long l = SystemClock.elapsedRealtime();
    AppMethodBeat.o(90164);
    return l;
  }
  
  public long nanoTime()
  {
    AppMethodBeat.i(90165);
    long l = System.nanoTime();
    AppMethodBeat.o(90165);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.util.DefaultClock
 * JD-Core Version:    0.7.0.1
 */