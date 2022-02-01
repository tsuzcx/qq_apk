package com.qq.wx.voice.vad;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;

public final class a
{
  public static boolean DEBUG = false;
  public static boolean bNU = false;
  public EVadNative bNS;
  public MMVoipVadNative bNT;
  public long handle;
  
  public a()
  {
    AppMethodBeat.i(74968);
    this.handle = 0L;
    this.bNS = new EVadNative();
    this.bNT = new MMVoipVadNative();
    AppMethodBeat.o(74968);
  }
  
  public static void bi(boolean paramBoolean)
  {
    AppMethodBeat.i(74969);
    bNU = paramBoolean;
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
    if (bNU)
    {
      paramInt = this.bNT.AddData(this.handle, paramArrayOfShort, paramInt);
      AppMethodBeat.o(74970);
      return paramInt;
    }
    paramInt = this.bNS.AddData(this.handle, paramArrayOfShort, paramInt);
    AppMethodBeat.o(74970);
    return paramInt;
  }
  
  public final int yH()
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
    if (bNU)
    {
      i = this.bNT.Release(this.handle);
      AppMethodBeat.o(74971);
      return i;
    }
    int i = this.bNS.Release(this.handle);
    AppMethodBeat.o(74971);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.qq.wx.voice.vad.a
 * JD-Core Version:    0.7.0.1
 */