package com.tencent.liteav.basic.structs;

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
  
  private native void loadGLArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  private native void loadGLData(int paramInt1, int paramInt2);
  
  private native void loadNativeData(byte[] paramArrayOfByte, int paramInt);
  
  public TXSVideoFrame clone()
  {
    AppMethodBeat.i(146736);
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
    AppMethodBeat.o(146736);
    return localTXSVideoFrame;
  }
  
  public void finalize()
  {
    AppMethodBeat.i(146734);
    release();
    super.finalize();
    AppMethodBeat.o(146734);
  }
  
  public void loadI420Array(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(146735);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < this.width * this.height * 3 / 2))
    {
      AppMethodBeat.o(146735);
      return;
    }
    loadNativeData(paramArrayOfByte, this.width * this.height * 3 / 2);
    AppMethodBeat.o(146735);
  }
  
  public void loadI420BufferFromGL()
  {
    AppMethodBeat.i(146738);
    loadGLData(this.width, this.height);
    AppMethodBeat.o(146738);
  }
  
  public void loadI420BufferFromGL(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(146737);
    loadGLArray(paramArrayOfByte, this.width, this.height);
    AppMethodBeat.o(146737);
  }
  
  public native void nativeClone(ByteBuffer paramByteBuffer);
  
  public native void release();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.liteav.basic.structs.TXSVideoFrame
 * JD-Core Version:    0.7.0.1
 */