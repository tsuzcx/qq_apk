package com.tencent.liteav.videodecoder;

import android.view.Surface;
import com.tencent.liteav.basic.f.b;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

public class TXCVideoFfmpegDecoder
  implements a
{
  private boolean mFirstDec;
  private d mListener;
  private long mNativeDecoder;
  private long mNativeNotify;
  private ByteBuffer mPps;
  private byte[] mRawData;
  private ByteBuffer mSps;
  private int mVideoHeight;
  private int mVideoWidth;
  
  static
  {
    com.tencent.liteav.basic.util.a.d();
    nativeClassInit();
  }
  
  private static native void nativeClassInit();
  
  private native boolean nativeDecode(byte[] paramArrayOfByte, long paramLong1, long paramLong2);
  
  private native void nativeInit(WeakReference<TXCVideoFfmpegDecoder> paramWeakReference, boolean paramBoolean);
  
  private native void nativeLoadRawData(byte[] paramArrayOfByte, long paramLong, int paramInt);
  
  private native void nativeRelease();
  
  private static void postEventFromNative(WeakReference<TXCVideoFfmpegDecoder> paramWeakReference, long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3)
  {
    paramWeakReference = (TXCVideoFfmpegDecoder)paramWeakReference.get();
    if (paramWeakReference != null)
    {
      d locald = paramWeakReference.mListener;
      if (locald != null)
      {
        locald.a(paramLong1, paramInt1, paramInt2, paramLong2, paramLong3);
        if ((paramWeakReference.mVideoWidth != paramInt1) || (paramWeakReference.mVideoHeight != paramInt2))
        {
          paramWeakReference.mVideoWidth = paramInt1;
          paramWeakReference.mVideoHeight = paramInt2;
          locald.a(paramWeakReference.mVideoWidth, paramWeakReference.mVideoHeight);
        }
      }
    }
  }
  
  public int config(Surface paramSurface)
  {
    return 0;
  }
  
  public void decode(b paramb)
  {
    if (this.mFirstDec)
    {
      if ((this.mSps != null) && (this.mPps != null))
      {
        byte[] arrayOfByte1 = this.mSps.array();
        byte[] arrayOfByte2 = this.mPps.array();
        byte[] arrayOfByte3 = new byte[arrayOfByte1.length + arrayOfByte2.length];
        System.arraycopy(arrayOfByte1, 0, arrayOfByte3, 0, arrayOfByte1.length);
        System.arraycopy(arrayOfByte2, 0, arrayOfByte3, arrayOfByte1.length, arrayOfByte2.length);
        nativeDecode(arrayOfByte3, paramb.g - 1L, paramb.h - 1L);
      }
      this.mFirstDec = false;
    }
    nativeDecode(paramb.a, paramb.g, paramb.h);
  }
  
  public boolean isHevc()
  {
    return false;
  }
  
  public void loadNativeData(byte[] paramArrayOfByte, long paramLong, int paramInt)
  {
    nativeLoadRawData(paramArrayOfByte, paramLong, paramInt);
  }
  
  public void setListener(d paramd)
  {
    this.mListener = paramd;
  }
  
  public void setNotifyListener(WeakReference<com.tencent.liteav.basic.c.a> paramWeakReference) {}
  
  public int start(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mSps = paramByteBuffer1;
    this.mPps = paramByteBuffer2;
    this.mFirstDec = true;
    this.mVideoWidth = 0;
    this.mVideoHeight = 0;
    nativeInit(new WeakReference(this), paramBoolean1);
    return 0;
  }
  
  public void stop()
  {
    nativeRelease();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.liteav.videodecoder.TXCVideoFfmpegDecoder
 * JD-Core Version:    0.7.0.1
 */