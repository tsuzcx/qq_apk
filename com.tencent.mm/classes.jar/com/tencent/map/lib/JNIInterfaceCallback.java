package com.tencent.map.lib;

public abstract interface JNIInterfaceCallback
{
  public abstract Object callback(int paramInt1, int paramInt2, String paramString, byte[] paramArrayOfByte, Object paramObject);
  
  public abstract int callbackGetGLContext();
  
  public abstract void onMapCameraChangeStopped();
  
  public abstract void onMapCameraChanged();
  
  public abstract void onMapLoaded();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.map.lib.JNIInterfaceCallback
 * JD-Core Version:    0.7.0.1
 */