package com.qq.wx.voice.vad;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;

public final class a
{
  public static boolean DEBUG = false;
  public static boolean cgx = false;
  public EVadNative cgv;
  public MMVoipVadNative cgw;
  public long handle;
  
  public a()
  {
    AppMethodBeat.i(74968);
    this.handle = 0L;
    this.cgv = new EVadNative();
    this.cgw = new MMVoipVadNative();
    AppMethodBeat.o(74968);
  }
  
  public static void bI(boolean paramBoolean)
  {
    AppMethodBeat.i(74969);
    cgx = paramBoolean;
    if (paramBoolean)
    {
      System.loadLibrary("MMVoipVadEmbed");
      if (DEBUG)
      {
        System.out.println("EVad loadLib MMVoipVadEmbed");
        AppMethodBeat.o(74969);
      }
    }
    else
    {
      System.loadLibrary("EVadEmbed");
      if (DEBUG) {
        System.out.println("EVad loadLib EVadEmbed");
      }
    }
    AppMethodBeat.o(74969);
  }
  
  public final int IL()
  {
    AppMethodBeat.i(74971);
    if (this.handle == 0L)
    {
      AppMethodBeat.o(74971);
      return 1;
    }
    if (DEBUG) {
      System.out.println("EVad Release handle = " + this.handle);
    }
    if (cgx)
    {
      i = this.cgw.Release(this.handle);
      AppMethodBeat.o(74971);
      return i;
    }
    int i = this.cgv.Release(this.handle);
    AppMethodBeat.o(74971);
    return i;
  }
  
  public final int a(short[] paramArrayOfShort, int paramInt)
  {
    AppMethodBeat.i(74970);
    if (this.handle == 0L)
    {
      AppMethodBeat.o(74970);
      return 1;
    }
    if (DEBUG) {
      System.out.println("EVad AddData handle = " + this.handle);
    }
    if (cgx)
    {
      paramInt = this.cgw.AddData(this.handle, paramArrayOfShort, paramInt);
      AppMethodBeat.o(74970);
      return paramInt;
    }
    paramInt = this.cgv.AddData(this.handle, paramArrayOfShort, paramInt);
    AppMethodBeat.o(74970);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.qq.wx.voice.vad.a
 * JD-Core Version:    0.7.0.1
 */