package com.qq.wx.voice.vad;

import java.io.PrintStream;

public final class a
{
  public static boolean DEBUG = false;
  public static boolean aVB = false;
  public MMVoipVadNative aVA = new MMVoipVadNative();
  public EVadNative aVz = new EVadNative();
  public long handle = 0L;
  
  public static void aF(boolean paramBoolean)
  {
    aVB = paramBoolean;
    if (paramBoolean)
    {
      System.loadLibrary("MMVoipVadEmbed");
      if (DEBUG) {
        System.out.println("EVad loadLib MMVoipVadEmbed");
      }
    }
    do
    {
      return;
      System.loadLibrary("EVadEmbed");
    } while (!DEBUG);
    System.out.println("EVad loadLib EVadEmbed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.qq.wx.voice.vad.a
 * JD-Core Version:    0.7.0.1
 */