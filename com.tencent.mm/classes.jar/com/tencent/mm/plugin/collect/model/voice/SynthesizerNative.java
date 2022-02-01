package com.tencent.mm.plugin.collect.model.voice;

public class SynthesizerNative
{
  public native int init(byte[] paramArrayOfByte);
  
  public native int readmoney(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt, float paramFloat1, float paramFloat2);
  
  public native void release();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.voice.SynthesizerNative
 * JD-Core Version:    0.7.0.1
 */