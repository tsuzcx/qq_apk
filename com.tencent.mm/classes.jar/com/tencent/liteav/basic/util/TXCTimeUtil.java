package com.tencent.liteav.basic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class TXCTimeUtil
{
  static
  {
    AppMethodBeat.i(66040);
    b.f();
    AppMethodBeat.o(66040);
  }
  
  public static long getTimeTick()
  {
    AppMethodBeat.i(66038);
    long l = nativeGetTimeTick();
    AppMethodBeat.o(66038);
    return l;
  }
  
  public static long getUtcTimeTick()
  {
    AppMethodBeat.i(66039);
    long l = nativeGetUtcTimeTick();
    AppMethodBeat.o(66039);
    return l;
  }
  
  public static void initAppStartTime()
  {
    AppMethodBeat.i(146635);
    nativeInitAppStartTime();
    AppMethodBeat.o(146635);
  }
  
  private static native long nativeGetTimeTick();
  
  private static native long nativeGetUtcTimeTick();
  
  private static native void nativeInitAppStartTime();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.util.TXCTimeUtil
 * JD-Core Version:    0.7.0.1
 */