package com.tencent.mm.offlineutil;

public class OfflineUtilJni
{
  public static native char[] CheckSumWithBase91(String paramString);
  
  public static native String DecodeBase91(String paramString);
  
  public static native String EncodeBase91(String paramString);
  
  public static native String GenOffLineQrcode(String paramString, byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.offlineutil.OfflineUtilJni
 * JD-Core Version:    0.7.0.1
 */