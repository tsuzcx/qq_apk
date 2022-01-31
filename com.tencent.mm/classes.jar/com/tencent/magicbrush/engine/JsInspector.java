package com.tencent.magicbrush.engine;

import android.support.annotation.Keep;

public class JsInspector
{
  private static JsInspector.a bkw;
  
  static native int JniNotify(long paramLong1, long paramLong2, String paramString);
  
  static native void JniReceiveData(long paramLong, String paramString);
  
  public static void a(JsInspector.a parama)
  {
    bkw = parama;
  }
  
  public static void b(long paramLong, String paramString)
  {
    JniReceiveData(paramLong, paramString);
  }
  
  @Keep
  public static int jniCallbackNotify(long paramLong1, long paramLong2, String paramString)
  {
    if (bkw == null) {
      return -1;
    }
    return 0;
  }
  
  @Keep
  public static int jniCallbackSendData(long paramLong, String paramString)
  {
    if (bkw == null) {
      return -1;
    }
    return bkw.c(paramLong, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.magicbrush.engine.JsInspector
 * JD-Core Version:    0.7.0.1
 */