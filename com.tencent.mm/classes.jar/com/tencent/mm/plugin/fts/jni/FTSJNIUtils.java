package com.tencent.mm.plugin.fts.jni;

public class FTSJNIUtils
{
  public static native int countTokens(String paramString);
  
  public static native int icuInitialize(String paramString);
  
  public static native String icuTokenizer(String paramString);
  
  public static native void nativeInitFts(long paramLong, byte[] paramArrayOfByte);
  
  public static native int stringCompareUtfBinary(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.jni.FTSJNIUtils
 * JD-Core Version:    0.7.0.1
 */