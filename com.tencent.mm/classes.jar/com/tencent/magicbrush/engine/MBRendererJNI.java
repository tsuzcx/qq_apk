package com.tencent.magicbrush.engine;

import com.tencent.magicbrush.a.c;

public class MBRendererJNI
{
  static {}
  
  public native boolean nativeCheckTimer();
  
  public native void nativeCreated(float paramFloat, long paramLong, int paramInt);
  
  public native void nativeDestroy();
  
  public native void nativeOnEGLCreated();
  
  public native void nativeOnEGLSurfaceChanged();
  
  public native void nativeOnSurfaceSizeChanged(int paramInt1, int paramInt2);
  
  public native void nativePause();
  
  public native void nativeResume();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.magicbrush.engine.MBRendererJNI
 * JD-Core Version:    0.7.0.1
 */