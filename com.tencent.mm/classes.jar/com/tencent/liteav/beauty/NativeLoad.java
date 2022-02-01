package com.tencent.liteav.beauty;

import com.tencent.liteav.basic.util.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class NativeLoad
{
  private static final String TAG = "NativeLoad";
  
  static
  {
    AppMethodBeat.i(229778);
    h.d();
    OnLoadBeauty();
    AppMethodBeat.o(229778);
  }
  
  private NativeLoad()
  {
    AppMethodBeat.i(15207);
    AppMethodBeat.o(15207);
  }
  
  public static native void OnLoadBeauty();
  
  public static native void nativeClearQueue();
  
  public static native void nativeDeleteYuv2Yuv();
  
  public static native void nativeGlMapBufferToQueue(int paramInt1, int paramInt2, ByteBuffer paramByteBuffer);
  
  public static native void nativeGlReadPixs(int paramInt1, int paramInt2, byte[] paramArrayOfByte);
  
  public static native boolean nativeGlReadPixsFromQueue(int paramInt1, int paramInt2, byte[] paramArrayOfByte);
  
  public static native void nativeGlReadPixsToQueue(int paramInt1, int paramInt2);
  
  public static native int nativeLoadGLProgram(int paramInt);
  
  public static native void nativeglTexImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, byte[] paramArrayOfByte, int paramInt9);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.beauty.NativeLoad
 * JD-Core Version:    0.7.0.1
 */