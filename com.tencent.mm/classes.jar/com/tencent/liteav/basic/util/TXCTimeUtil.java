package com.tencent.liteav.basic.util;

public class TXCTimeUtil
{
  static {}
  
  public static long getTimeTick()
  {
    return nativeGetTimeTick();
  }
  
  public static long getUtcTimeTick()
  {
    return nativeGetUtcTimeTick();
  }
  
  private static native long nativeGetTimeTick();
  
  private static native long nativeGetUtcTimeTick();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.util.TXCTimeUtil
 * JD-Core Version:    0.7.0.1
 */