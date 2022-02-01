package com.tencent.liteav.basic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class TXCTimeUtil
{
  static
  {
    AppMethodBeat.i(14727);
    f.f();
    AppMethodBeat.o(14727);
  }
  
  public static long generatePtsMS()
  {
    AppMethodBeat.i(14722);
    long l = nativeGeneratePtsMS();
    AppMethodBeat.o(14722);
    return l;
  }
  
  public static long getClockTickInHz()
  {
    AppMethodBeat.i(14726);
    long l = nativeGetClockTickInHz();
    AppMethodBeat.o(14726);
    return l;
  }
  
  public static long getTimeTick()
  {
    AppMethodBeat.i(14723);
    long l = nativeGetTimeTick();
    AppMethodBeat.o(14723);
    return l;
  }
  
  public static long getUtcTimeTick()
  {
    AppMethodBeat.i(14724);
    long l = nativeGetUtcTimeTick();
    AppMethodBeat.o(14724);
    return l;
  }
  
  public static void initAppStartTime()
  {
    AppMethodBeat.i(14725);
    nativeInitAppStartTime();
    AppMethodBeat.o(14725);
  }
  
  private static native long nativeGeneratePtsMS();
  
  private static native long nativeGetClockTickInHz();
  
  private static native long nativeGetTimeTick();
  
  private static native long nativeGetUtcTimeTick();
  
  private static native void nativeInitAppStartTime();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.basic.util.TXCTimeUtil
 * JD-Core Version:    0.7.0.1
 */