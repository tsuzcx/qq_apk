package com.eclipsesource.v8;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class V8Inspector
{
  private static JsInspectorChannelServer _server;
  
  static native int JniNotify(long paramLong1, long paramLong2, String paramString);
  
  static native void JniReceiveData(long paramLong, String paramString);
  
  @Keep
  public static int jniCallbackNotify(long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(75501);
    if (_server == null)
    {
      AppMethodBeat.o(75501);
      return -1;
    }
    int i = _server.notify(paramLong1, paramLong2, paramString);
    AppMethodBeat.o(75501);
    return i;
  }
  
  @Keep
  public static int jniCallbackSendData(long paramLong, String paramString)
  {
    AppMethodBeat.i(75500);
    if (_server == null)
    {
      AppMethodBeat.o(75500);
      return -1;
    }
    int i = _server.sendData(paramLong, paramString);
    AppMethodBeat.o(75500);
    return i;
  }
  
  public static int notify(long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(75499);
    int i = JniNotify(paramLong1, paramLong2, paramString);
    AppMethodBeat.o(75499);
    return i;
  }
  
  public static void onReceiveData(long paramLong, String paramString)
  {
    AppMethodBeat.i(75498);
    JniReceiveData(paramLong, paramString);
    AppMethodBeat.o(75498);
  }
  
  public static void setServer(JsInspectorChannelServer paramJsInspectorChannelServer)
  {
    _server = paramJsInspectorChannelServer;
  }
  
  public static abstract interface JsInspectorChannelServer
  {
    public abstract int notify(long paramLong1, long paramLong2, String paramString);
    
    public abstract int sendData(long paramLong, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.eclipsesource.v8.V8Inspector
 * JD-Core Version:    0.7.0.1
 */