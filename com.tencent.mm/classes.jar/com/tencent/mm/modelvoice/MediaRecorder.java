package com.tencent.mm.modelvoice;

import com.tencent.mm.pointers.PByteArray;

public class MediaRecorder
{
  public static long fZo = 0L;
  public static long fZp = 0L;
  public static final int[] fZq = { 13, 14, 16, 18, 20, 21, 27, 32 };
  
  public static native int SetVoiceSilkControl(int paramInt1, int paramInt2, long paramLong);
  
  public static native int SetVoiceSilkDecControl(int paramInt1, byte[] paramArrayOfByte, int paramInt2, long paramLong);
  
  public static native long SilkDecInit(int paramInt1, byte[] paramArrayOfByte, int paramInt2, long paramLong);
  
  public static native int SilkDecUnInit(long paramLong);
  
  public static native int SilkDoDec(byte[] paramArrayOfByte, short paramShort, long paramLong);
  
  public static native int SilkDoEnc(byte[] paramArrayOfByte1, short paramShort, byte[] paramArrayOfByte2, short[] paramArrayOfShort, boolean paramBoolean, long paramLong);
  
  public static native long SilkEncInit(int paramInt1, int paramInt2, int paramInt3, long paramLong);
  
  public static native int SilkEncUnInit(long paramLong);
  
  public static native int SilkGetEncSampleRate(byte[] paramArrayOfByte, long paramLong);
  
  public static native boolean native_init();
  
  public static native boolean native_pcm2amr(int paramInt1, byte[] paramArrayOfByte, int paramInt2, PByteArray paramPByteArray, int paramInt3);
  
  public static native boolean native_pcmresamp(byte[] paramArrayOfByte, int paramInt, PByteArray paramPByteArray);
  
  public static native boolean native_release();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvoice.MediaRecorder
 * JD-Core Version:    0.7.0.1
 */