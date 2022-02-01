package com.tencent.mm.plugin.facedetectlight.Utils;

public class YTAGFaceReflectForWXJNIInterface
{
  public static native String decrypt(String paramString, byte[] paramArrayOfByte, long paramLong);
  
  public static native byte[] encrypt(String paramString1, String paramString2, long paramLong);
  
  public static native String faceMd5(byte[] paramArrayOfByte, long paramLong);
  
  public static native YTAGFaceReflectResult getEncodeString(String paramString);
  
  public static native String verifyDataToJpg(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.Utils.YTAGFaceReflectForWXJNIInterface
 * JD-Core Version:    0.7.0.1
 */