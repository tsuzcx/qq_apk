package com.tencent.magicbrush.engine;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class JsInspector
{
  private static JsInspector.a bJv;
  
  static native int JniNotify(long paramLong1, long paramLong2, String paramString);
  
  static native void JniReceiveData(long paramLong, String paramString);
  
  @Keep
  public static int jniCallbackNotify(long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(115883);
    if (bJv == null)
    {
      AppMethodBeat.o(115883);
      return -1;
    }
    int i = bJv.yr();
    AppMethodBeat.o(115883);
    return i;
  }
  
  @Keep
  public static int jniCallbackSendData(long paramLong, String paramString)
  {
    AppMethodBeat.i(115882);
    if (bJv == null)
    {
      AppMethodBeat.o(115882);
      return -1;
    }
    int i = bJv.yq();
    AppMethodBeat.o(115882);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.magicbrush.engine.JsInspector
 * JD-Core Version:    0.7.0.1
 */