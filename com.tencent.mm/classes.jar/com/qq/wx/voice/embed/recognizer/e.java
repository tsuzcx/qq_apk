package com.qq.wx.voice.embed.recognizer;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  public Grammar bme;
  g bmf;
  byte[] c;
  public boolean d;
  public boolean e;
  
  public e()
  {
    AppMethodBeat.i(123211);
    this.bme = null;
    this.bmf = new g();
    this.c = null;
    this.d = false;
    this.e = false;
    this.bme = new Grammar();
    AppMethodBeat.o(123211);
  }
  
  public final int a(c paramc, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(123212);
    if (!this.d)
    {
      AppMethodBeat.o(123212);
      return -304;
    }
    if (!this.e)
    {
      AppMethodBeat.o(123212);
      return -302;
    }
    this.bmf.bmg = paramc;
    this.c = paramArrayOfByte;
    if (this.c == null)
    {
      AppMethodBeat.o(123212);
      return -301;
    }
    try
    {
      new Thread(new e.a(this, (byte)0)).start();
      AppMethodBeat.o(123212);
      return 0;
    }
    catch (Exception paramc)
    {
      AppMethodBeat.o(123212);
    }
    return -302;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.qq.wx.voice.embed.recognizer.e
 * JD-Core Version:    0.7.0.1
 */