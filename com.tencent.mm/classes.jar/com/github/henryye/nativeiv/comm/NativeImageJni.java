package com.github.henryye.nativeiv.comm;

import com.github.henryye.nativeiv.a.a;
import com.github.henryye.nativeiv.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class NativeImageJni
{
  long mNativeInst = 0L;
  
  static
  {
    AppMethodBeat.i(127376);
    b.d("NativeImageJni", "load library", new Object[0]);
    a.loadLibrary("native-iv");
    AppMethodBeat.o(127376);
  }
  
  native CommNativeBitmapStruct nativeDecodeNative(long paramLong, ByteBuffer paramByteBuffer, int paramInt, boolean paramBoolean);
  
  native void nativeDestroy(long paramLong);
  
  native long nativeInit();
  
  native void nativeRecycleNative(long paramLong1, long paramLong2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.github.henryye.nativeiv.comm.NativeImageJni
 * JD-Core Version:    0.7.0.1
 */