package com.qq.wx.voice.embed.recognizer;

public class GrammarNative
{
  public static native int begin();
  
  public static native int end();
  
  public static native int getResult(Grammar paramGrammar);
  
  public static native int init(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3);
  
  public static native int recognize(byte[] paramArrayOfByte, int paramInt);
  
  public static native int update(byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.qq.wx.voice.embed.recognizer.GrammarNative
 * JD-Core Version:    0.7.0.1
 */