package com.tencent.common;

public class DualMp4Decoder
{
  static
  {
    System.loadLibrary("ijkffmpeg");
    System.loadLibrary("getframe");
  }
  
  public static native int getFrameAtTime(long paramLong, byte[] paramArrayOfByte, int paramInt);
  
  public static native int getFrameFromDualMp4(long paramLong, byte[] paramArrayOfByte);
  
  public static native long initDecoder(String paramString1, String paramString2);
  
  public static native int releaseDecoder(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.common.DualMp4Decoder
 * JD-Core Version:    0.7.0.1
 */