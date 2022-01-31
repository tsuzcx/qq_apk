package com.github.henryye.nativeiv.comm;

import java.nio.ByteBuffer;

public class NativeImageJni
{
  protected static native CommNativeBitmapStruct decodeNative(ByteBuffer paramByteBuffer, int paramInt);
  
  protected static native void destroy();
  
  protected static native void init();
  
  protected static native void recycleNative(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.github.henryye.nativeiv.comm.NativeImageJni
 * JD-Core Version:    0.7.0.1
 */