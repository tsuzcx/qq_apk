package com.qq.wx.voice.vad;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;

public final class a
{
  public static boolean DEBUG = false;
  public static boolean bmj = false;
  public EVadNative bmh;
  public MMVoipVadNative bmi;
  public long handle;
  
  public a()
  {
    AppMethodBeat.i(93970);
    this.handle = 0L;
    this.bmh = new EVadNative();
    this.bmi = new MMVoipVadNative();
    AppMethodBeat.o(93970);
  }
  
  public static void aT(boolean paramBoolean)
  {
    AppMethodBeat.i(93971);
    bmj = paramBoolean;
    if (paramBoolean)
    {
      System.loadLibrary("MMVoipVadEmbed");
      if (DEBUG)
      {
        System.out.println("EVad loadLib MMVoipVadEmbed");
        AppMethodBeat.o(93971);
      }
    }
    else
    {
      System.loadLibrary("EVadEmbed");
      if (DEBUG) {
        System.out.println("EVad loadLib EVadEmbed");
      }
    }
    AppMethodBeat.o(93971);
  }
  
  public final int b(short[] paramArrayOfShort, int paramInt)
  {
    AppMethodBeat.i(93972);
    if (this.handle == 0L)
    {
      AppMethodBeat.o(93972);
      return 1;
    }
    if (DEBUG) {
      System.out.println("EVad AddData handle = " + this.handle);
    }
    if (bmj)
    {
      paramInt = this.bmi.AddData(this.handle, paramArrayOfShort, paramInt);
      AppMethodBeat.o(93972);
      return paramInt;
    }
    paramInt = this.bmh.AddData(this.handle, paramArrayOfShort, paramInt);
    AppMethodBeat.o(93972);
    return paramInt;
  }
  
  public final int tc()
  {
    AppMethodBeat.i(93973);
    if (this.handle == 0L)
    {
      AppMethodBeat.o(93973);
      return 1;
    }
    if (DEBUG) {
      System.out.println("EVad Release handle = " + this.handle);
    }
    if (bmj)
    {
      i = this.bmi.Release(this.handle);
      AppMethodBeat.o(93973);
      return i;
    }
    int i = this.bmh.Release(this.handle);
    AppMethodBeat.o(93973);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.qq.wx.voice.vad.a
 * JD-Core Version:    0.7.0.1
 */