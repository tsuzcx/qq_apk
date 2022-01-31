package com.tencent.common;

public class PileMp4Decoder
{
  static
  {
    System.loadLibrary("getframe");
  }
  
  public static native int getFrameFromPileMp4(int paramInt, byte[] paramArrayOfByte);
  
  public static native int initDecoder(String paramString);
  
  public static native int releaseDecoder(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.common.PileMp4Decoder
 * JD-Core Version:    0.7.0.1
 */