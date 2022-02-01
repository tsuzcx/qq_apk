package com.tencent.magicbrush.engine;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class JsInspector
{
  private static a eIP;
  
  static native int JniNotify(long paramLong1, long paramLong2, String paramString);
  
  static native void JniReceiveData(long paramLong, String paramString);
  
  public static int jniCallbackNotify(long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(139988);
    if (eIP == null)
    {
      AppMethodBeat.o(139988);
      return -1;
    }
    int i = eIP.avI();
    AppMethodBeat.o(139988);
    return i;
  }
  
  public static int jniCallbackSendData(long paramLong, String paramString)
  {
    AppMethodBeat.i(139987);
    if (eIP == null)
    {
      AppMethodBeat.o(139987);
      return -1;
    }
    int i = eIP.avH();
    AppMethodBeat.o(139987);
    return i;
  }
  
  public static abstract interface a
  {
    public abstract int avH();
    
    public abstract int avI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.magicbrush.engine.JsInspector
 * JD-Core Version:    0.7.0.1
 */