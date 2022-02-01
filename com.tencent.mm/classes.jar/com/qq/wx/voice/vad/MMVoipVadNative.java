package com.qq.wx.voice.vad;

public class MMVoipVadNative
{
  public native int AddData(long paramLong, short[] paramArrayOfShort, int paramInt);
  
  public native long Init(int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4);
  
  public native int Release(long paramLong);
  
  public native int Reset(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.qq.wx.voice.vad.MMVoipVadNative
 * JD-Core Version:    0.7.0.1
 */