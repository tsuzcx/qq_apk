package com.qq.wx.voice.vad;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;

public final class a
{
  public static boolean DEBUG = false;
  public static boolean dYX = false;
  public EVadNative dYV;
  public MMVoipVadNative dYW;
  public long handle;
  
  public a()
  {
    AppMethodBeat.i(74968);
    this.handle = 0L;
    this.dYV = new EVadNative();
    this.dYW = new MMVoipVadNative();
    AppMethodBeat.o(74968);
  }
  
  public static void cB(boolean paramBoolean)
  {
    AppMethodBeat.i(74969);
    dYX = paramBoolean;
    com.tencent.mm.hellhoundlib.b.a locala;
    Object localObject;
    if (paramBoolean)
    {
      locala = new com.tencent.mm.hellhoundlib.b.a().cG("MMVoipVadEmbed");
      localObject = new Object();
      com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/qq/wx/voice/vad/EVad", "loadLib", "(Z)V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
      System.loadLibrary((String)locala.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/qq/wx/voice/vad/EVad", "loadLib", "(Z)V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
      if (DEBUG)
      {
        System.out.println("EVad loadLib MMVoipVadEmbed");
        AppMethodBeat.o(74969);
      }
    }
    else
    {
      locala = new com.tencent.mm.hellhoundlib.b.a().cG("EVadEmbed");
      localObject = new Object();
      com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/qq/wx/voice/vad/EVad", "loadLib", "(Z)V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
      System.loadLibrary((String)locala.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/qq/wx/voice/vad/EVad", "loadLib", "(Z)V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
      if (DEBUG) {
        System.out.println("EVad loadLib EVadEmbed");
      }
    }
    AppMethodBeat.o(74969);
  }
  
  public final int akp()
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
    if (dYX)
    {
      i = this.dYW.Release(this.handle);
      AppMethodBeat.o(74971);
      return i;
    }
    int i = this.dYV.Release(this.handle);
    AppMethodBeat.o(74971);
    return i;
  }
  
  public final int b(short[] paramArrayOfShort, int paramInt)
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
    if (dYX)
    {
      paramInt = this.dYW.AddData(this.handle, paramArrayOfShort, paramInt);
      AppMethodBeat.o(74970);
      return paramInt;
    }
    paramInt = this.dYV.AddData(this.handle, paramArrayOfShort, paramInt);
    AppMethodBeat.o(74970);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.qq.wx.voice.vad.a
 * JD-Core Version:    0.7.0.1
 */