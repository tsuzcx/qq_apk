package com.tencent.magicbrush.engine;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class JsInspector
{
  private static a cno;
  
  static native int JniNotify(long paramLong1, long paramLong2, String paramString);
  
  static native void JniReceiveData(long paramLong, String paramString);
  
  @Keep
  public static int jniCallbackNotify(long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(139988);
    if (cno == null)
    {
      AppMethodBeat.o(139988);
      return -1;
    }
    int i = cno.Gd();
    AppMethodBeat.o(139988);
    return i;
  }
  
  @Keep
  public static int jniCallbackSendData(long paramLong, String paramString)
  {
    AppMethodBeat.i(139987);
    if (cno == null)
    {
      AppMethodBeat.o(139987);
      return -1;
    }
    int i = cno.Gc();
    AppMethodBeat.o(139987);
    return i;
  }
  
  public static abstract interface a
  {
    public abstract int Gc();
    
    public abstract int Gd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.engine.JsInspector
 * JD-Core Version:    0.7.0.1
 */