package com.tencent.mm.plugin.ap;

public class WVAPJNI
{
  public static native int nativeInitMixerFunc(String paramString);
  
  public static native int nativeMixerGetMixedPCM(long paramLong, byte[] paramArrayOfByte, short paramShort);
  
  public static native long nativeMixerInit(int paramInt1, int paramInt2, int paramInt3);
  
  public static native int nativeMixerInsertRawPCM(long paramLong, short paramShort1, short paramShort2, short paramShort3, int paramInt, byte[] paramArrayOfByte);
  
  public static native int nativeMixerUninit(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ap.WVAPJNI
 * JD-Core Version:    0.7.0.1
 */