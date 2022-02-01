package com.github.henryye.nativeiv.comm;

import android.support.annotation.Keep;
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
  
  @Keep
  native CommNativeBitmapStruct nativeDecodeNative(long paramLong, ByteBuffer paramByteBuffer, int paramInt, boolean paramBoolean);
  
  @Keep
  native void nativeDestroy(long paramLong);
  
  @Keep
  native long nativeInit();
  
  @Keep
  native void nativeRecycleNative(long paramLong1, long paramLong2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.github.henryye.nativeiv.comm.NativeImageJni
 * JD-Core Version:    0.7.0.1
 */