package com.tencent.liteav.muxer.jni;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class TXSWMuxerJNI
{
  private long a;
  private volatile boolean b;
  private volatile boolean c;
  
  public TXSWMuxerJNI()
  {
    AppMethodBeat.i(14945);
    this.a = -1L;
    this.a = init();
    this.b = true;
    AppMethodBeat.o(14945);
  }
  
  private byte[] b(ByteBuffer paramByteBuffer, int paramInt)
  {
    AppMethodBeat.i(14954);
    if (paramByteBuffer == null)
    {
      AppMethodBeat.o(14954);
      return null;
    }
    byte[] arrayOfByte = new byte[paramInt];
    paramByteBuffer.get(arrayOfByte);
    AppMethodBeat.o(14954);
    return arrayOfByte;
  }
  
  private native long init();
  
  private native void release(long paramLong);
  
  private native void setAVParams(long paramLong, AVOptions paramAVOptions);
  
  private native void setAudioCSD(long paramLong, byte[] paramArrayOfByte);
  
  private native void setDstPath(long paramLong, String paramString);
  
  private native void setVideoCSD(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  private native int start(long paramLong);
  
  private native int stop(long paramLong);
  
  private native int writeFrame(long paramLong1, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong2);
  
  public int a()
  {
    AppMethodBeat.i(14951);
    if (this.b)
    {
      int i = start(this.a);
      if (i == 0) {
        this.c = true;
      }
      for (;;)
      {
        AppMethodBeat.o(14951);
        return i;
        TXCLog.e("TXSWMuxerJNI", "Start Muxer Error!!!");
      }
    }
    TXCLog.e("TXSWMuxerJNI", "Muxer isn't init yet!");
    AppMethodBeat.o(14951);
    return -1;
  }
  
  public int a(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    AppMethodBeat.i(14950);
    if (this.b)
    {
      if (this.c)
      {
        paramInt1 = writeFrame(this.a, b(paramByteBuffer, paramInt3), paramInt1, paramInt2, paramInt3, paramInt4, paramLong);
        if (paramInt1 != 0) {
          TXCLog.e("TXSWMuxerJNI", "Muxer write frame error!");
        }
        AppMethodBeat.o(14950);
        return paramInt1;
      }
      TXCLog.e("TXSWMuxerJNI", "Muxer isn't start yet!");
      AppMethodBeat.o(14950);
      return -1;
    }
    TXCLog.e("TXSWMuxerJNI", "Muxer isn't init yet!");
    AppMethodBeat.o(14950);
    return -1;
  }
  
  public void a(AVOptions paramAVOptions)
  {
    AppMethodBeat.i(14946);
    if (this.b)
    {
      setAVParams(this.a, paramAVOptions);
      AppMethodBeat.o(14946);
      return;
    }
    TXCLog.e("TXSWMuxerJNI", "Muxer isn't init yet!");
    AppMethodBeat.o(14946);
  }
  
  public void a(String paramString)
  {
    AppMethodBeat.i(14947);
    if (this.b)
    {
      setDstPath(this.a, paramString);
      AppMethodBeat.o(14947);
      return;
    }
    TXCLog.e("TXSWMuxerJNI", "Muxer isn't init yet!");
    AppMethodBeat.o(14947);
  }
  
  public void a(ByteBuffer paramByteBuffer, int paramInt)
  {
    AppMethodBeat.i(14949);
    if (this.b)
    {
      setAudioCSD(this.a, b(paramByteBuffer, paramInt));
      AppMethodBeat.o(14949);
      return;
    }
    TXCLog.e("TXSWMuxerJNI", "Muxer isn't init yet!");
    AppMethodBeat.o(14949);
  }
  
  public void a(ByteBuffer paramByteBuffer1, int paramInt1, ByteBuffer paramByteBuffer2, int paramInt2)
  {
    AppMethodBeat.i(14948);
    if (this.b)
    {
      setVideoCSD(this.a, b(paramByteBuffer1, paramInt1), b(paramByteBuffer2, paramInt2));
      AppMethodBeat.o(14948);
      return;
    }
    TXCLog.e("TXSWMuxerJNI", "Muxer isn't init yet!");
    AppMethodBeat.o(14948);
  }
  
  public int b()
  {
    AppMethodBeat.i(14952);
    if (this.b)
    {
      if (this.c)
      {
        this.c = false;
        int i = stop(this.a);
        if (i != 0) {
          TXCLog.e("TXSWMuxerJNI", "Stop Muxer Error!!!");
        }
        AppMethodBeat.o(14952);
        return i;
      }
      TXCLog.e("TXSWMuxerJNI", "Muxer isn't start yet!");
      AppMethodBeat.o(14952);
      return -1;
    }
    TXCLog.e("TXSWMuxerJNI", "Muxer isn't init yet!");
    AppMethodBeat.o(14952);
    return -1;
  }
  
  public void c()
  {
    AppMethodBeat.i(14953);
    if (this.b)
    {
      release(this.a);
      this.b = false;
      this.c = false;
      AppMethodBeat.o(14953);
      return;
    }
    TXCLog.e("TXSWMuxerJNI", "Muxer isn't init yet!");
    AppMethodBeat.o(14953);
  }
  
  public static class AVOptions
  {
    public int audioChannels = 0;
    public int audioSampleRate = 0;
    public int videoGOP = 12;
    public int videoHeight = 540;
    public int videoWidth = 960;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.muxer.jni.TXSWMuxerJNI
 * JD-Core Version:    0.7.0.1
 */