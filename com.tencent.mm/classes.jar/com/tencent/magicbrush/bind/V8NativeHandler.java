package com.tencent.magicbrush.bind;

import com.tencent.magicbrush.a.c;

public class V8NativeHandler
{
  static {}
  
  public native void nativeAddJsInterface(V8JSInterface paramV8JSInterface, String paramString);
  
  public native String nativeCheckError();
  
  public native void nativeCleanUp();
  
  public native String nativeEvaluateJavascript(String paramString);
  
  public native void nativeInit();
  
  public native void nativePause();
  
  public native void nativeResume();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.magicbrush.bind.V8NativeHandler
 * JD-Core Version:    0.7.0.1
 */