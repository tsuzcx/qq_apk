package com.qq.wx.voice.embed.recognizer;

public final class e
{
  public Grammar aVw = null;
  g aVx = new g();
  byte[] c = null;
  public boolean d = false;
  public boolean e = false;
  
  public final int a(c paramc, byte[] paramArrayOfByte)
  {
    int i = -302;
    if (!this.d) {
      i = -304;
    }
    while (!this.e) {
      return i;
    }
    this.aVx.aVy = paramc;
    this.c = paramArrayOfByte;
    if (this.c == null) {
      return -301;
    }
    try
    {
      new Thread(new e.a(this, (byte)0)).start();
      return 0;
    }
    catch (Exception paramc) {}
    return -302;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.qq.wx.voice.embed.recognizer.e
 * JD-Core Version:    0.7.0.1
 */