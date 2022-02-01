package com.tencent.liteav.videodecoder;

import android.view.Surface;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.util.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import org.json.JSONArray;

public class TXCVideoFfmpegDecoder
  implements a
{
  private boolean mFirstDec;
  private c mListener;
  private long mNativeDecoder;
  private long mNativeNotify;
  private ByteBuffer mPps;
  private byte[] mRawData;
  private ByteBuffer mSps;
  private int mVideoHeight;
  private int mVideoWidth;
  
  static
  {
    AppMethodBeat.i(16646);
    d.f();
    nativeClassInit();
    AppMethodBeat.o(16646);
  }
  
  private static native void nativeClassInit();
  
  private native boolean nativeDecode(byte[] paramArrayOfByte, long paramLong1, long paramLong2, long paramLong3);
  
  private native void nativeInit(WeakReference<TXCVideoFfmpegDecoder> paramWeakReference, boolean paramBoolean);
  
  private native void nativeLoadRawData(byte[] paramArrayOfByte, long paramLong, int paramInt);
  
  private native void nativeRelease();
  
  private static void postEventFromNative(WeakReference<TXCVideoFfmpegDecoder> paramWeakReference, long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3, int paramInt3) {}
  
  public int GetDecodeCost()
  {
    return 0;
  }
  
  public int config(Surface paramSurface)
  {
    return 0;
  }
  
  public void config(JSONArray paramJSONArray) {}
  
  public void decode(TXSNALPacket paramTXSNALPacket)
  {
    AppMethodBeat.i(16642);
    if (this.mFirstDec)
    {
      if ((this.mSps != null) && (this.mPps != null))
      {
        byte[] arrayOfByte1 = this.mSps.array();
        byte[] arrayOfByte2 = this.mPps.array();
        byte[] arrayOfByte3 = new byte[arrayOfByte1.length + arrayOfByte2.length];
        System.arraycopy(arrayOfByte1, 0, arrayOfByte3, 0, arrayOfByte1.length);
        System.arraycopy(arrayOfByte2, 0, arrayOfByte3, arrayOfByte1.length, arrayOfByte2.length);
        nativeDecode(arrayOfByte3, paramTXSNALPacket.pts - 1L, paramTXSNALPacket.dts - 1L, paramTXSNALPacket.rotation);
      }
      this.mFirstDec = false;
    }
    nativeDecode(paramTXSNALPacket.nalData, paramTXSNALPacket.pts, paramTXSNALPacket.dts, paramTXSNALPacket.rotation);
    AppMethodBeat.o(16642);
  }
  
  public boolean isHevc()
  {
    return false;
  }
  
  public void loadNativeData(byte[] paramArrayOfByte, long paramLong, int paramInt)
  {
    AppMethodBeat.i(16645);
    nativeLoadRawData(paramArrayOfByte, paramLong, paramInt);
    AppMethodBeat.o(16645);
  }
  
  public void setListener(c paramc)
  {
    this.mListener = paramc;
  }
  
  public void setNotifyListener(WeakReference<com.tencent.liteav.basic.c.a> paramWeakReference) {}
  
  public int start(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(16643);
    this.mSps = paramByteBuffer1;
    this.mPps = paramByteBuffer2;
    this.mFirstDec = true;
    this.mVideoWidth = 0;
    this.mVideoHeight = 0;
    nativeInit(new WeakReference(this), paramBoolean1);
    AppMethodBeat.o(16643);
    return 0;
  }
  
  public void stop()
  {
    AppMethodBeat.i(16644);
    nativeRelease();
    AppMethodBeat.o(16644);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.videodecoder.TXCVideoFfmpegDecoder
 * JD-Core Version:    0.7.0.1
 */