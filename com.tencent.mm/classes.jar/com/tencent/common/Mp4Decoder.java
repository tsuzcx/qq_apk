package com.tencent.common;

public class Mp4Decoder
{
  private static final String TAG = Mp4Decoder.class.getSimpleName();
  
  static
  {
    System.loadLibrary("getframe");
  }
  
  public static native int getFrameAtTime(long paramLong, byte[] paramArrayOfByte, int paramInt);
  
  public static native long initDecoder(String paramString, int[] paramArrayOfInt);
  
  public static native int releaseDecoder(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.common.Mp4Decoder
 * JD-Core Version:    0.7.0.1
 */