package com.tencent.liteav.basic.structs;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class TXSVideoFrame
{
  public ByteBuffer buffer;
  public byte[] data;
  public Object eglContext;
  public int frameType;
  public int height;
  public long pts;
  public int rotation;
  public int textureId;
  public int width;
  
  private native void nativeLoadArrayFromBuffer(byte[] paramArrayOfByte, int paramInt);
  
  private native void nativeLoadArrayFromGL(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  private native void nativeLoadBufferFromGL(int paramInt1, int paramInt2);
  
  private native void nativeLoadNV21BufferFromI420Buffer(int paramInt1, int paramInt2);
  
  public byte[] I420toNV21(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(14454);
    byte[] arrayOfByte = paramArrayOfByte2;
    if (paramArrayOfByte2 == null) {
      arrayOfByte = new byte[paramArrayOfByte1.length];
    }
    paramInt1 *= paramInt2;
    int j = paramInt1 + paramInt1 / 4;
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, paramInt1);
    paramInt2 = j;
    int i = paramInt1;
    while (i < j)
    {
      arrayOfByte[paramInt1] = paramArrayOfByte1[paramInt2];
      arrayOfByte[(paramInt1 + 1)] = paramArrayOfByte1[i];
      i += 1;
      paramInt2 += 1;
      paramInt1 += 2;
    }
    AppMethodBeat.o(14454);
    return arrayOfByte;
  }
  
  public TXSVideoFrame clone()
  {
    AppMethodBeat.i(14450);
    TXSVideoFrame localTXSVideoFrame = new TXSVideoFrame();
    localTXSVideoFrame.width = this.width;
    localTXSVideoFrame.height = this.height;
    localTXSVideoFrame.frameType = this.frameType;
    localTXSVideoFrame.rotation = this.rotation;
    localTXSVideoFrame.pts = this.pts;
    localTXSVideoFrame.data = this.data;
    localTXSVideoFrame.textureId = this.textureId;
    localTXSVideoFrame.eglContext = this.eglContext;
    localTXSVideoFrame.nativeClone(this.buffer);
    AppMethodBeat.o(14450);
    return localTXSVideoFrame;
  }
  
  public void finalize()
  {
    AppMethodBeat.i(14449);
    release();
    super.finalize();
    AppMethodBeat.o(14449);
  }
  
  public void loadNV21BufferFromI420Buffer()
  {
    AppMethodBeat.i(14453);
    nativeLoadNV21BufferFromI420Buffer(this.width, this.height);
    AppMethodBeat.o(14453);
  }
  
  public void loadYUVArray(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(14451);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < this.width * this.height * 3 / 2))
    {
      AppMethodBeat.o(14451);
      return;
    }
    if (this.buffer == null)
    {
      int i = this.height * 3 / 8;
      GLES20.glReadPixels(0, 0, this.width, i, 6408, 5121, ByteBuffer.wrap(paramArrayOfByte));
      AppMethodBeat.o(14451);
      return;
    }
    nativeLoadArrayFromBuffer(paramArrayOfByte, this.width * this.height * 3 / 2);
    AppMethodBeat.o(14451);
  }
  
  public void loadYUVBufferFromGL()
  {
    AppMethodBeat.i(14452);
    nativeLoadBufferFromGL(this.width, this.height);
    AppMethodBeat.o(14452);
  }
  
  public native void nativeClone(ByteBuffer paramByteBuffer);
  
  public native void release();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.structs.TXSVideoFrame
 * JD-Core Version:    0.7.0.1
 */