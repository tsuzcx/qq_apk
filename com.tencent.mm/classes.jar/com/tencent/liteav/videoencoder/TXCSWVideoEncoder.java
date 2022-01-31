package com.tencent.liteav.videoencoder;

import android.opengl.GLES20;
import com.tencent.liteav.basic.d.d;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.a;
import com.tencent.liteav.beauty.b.n;
import java.lang.ref.WeakReference;

public class TXCSWVideoEncoder
  extends c
{
  private static final boolean DEBUG = false;
  private static final String TAG = TXCSWVideoEncoder.class.getSimpleName();
  private int mBitrate = 0;
  private long mNativeX264Encoder = 0L;
  private long mPTS = 0L;
  private int mPopIdx = 0;
  private int mPushIdx = 0;
  private d mRawFrameFilter;
  private int mRendIdx = 0;
  private d mResizeFilter;
  
  static
  {
    a.d();
    nativeClassInit();
  }
  
  private static native void nativeClassInit();
  
  private native int nativeEncode(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2);
  
  private native int nativeEncodeSync(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2);
  
  private native long nativeGetRealFPS(long paramLong);
  
  private native long nativeInit(WeakReference<TXCSWVideoEncoder> paramWeakReference);
  
  private native void nativeRelease(long paramLong);
  
  private native void nativeSetBitrate(long paramLong, int paramInt);
  
  private native void nativeSignalEOSAndFlush(long paramLong);
  
  private native int nativeStart(long paramLong, TXSVideoEncoderParam paramTXSVideoEncoderParam);
  
  private native void nativeStop(long paramLong);
  
  private native long nativegetRealBitrate(long paramLong);
  
  private static void postEventFromNative(WeakReference<TXCSWVideoEncoder> paramWeakReference, byte[] paramArrayOfByte, int paramInt1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, int paramInt2)
  {
    paramWeakReference = (TXCSWVideoEncoder)paramWeakReference.get();
    if (paramWeakReference != null) {
      paramWeakReference.callDelegate(paramArrayOfByte, paramInt1, paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6, paramInt2, null, null);
    }
  }
  
  private long pushVideoFrameInternal(int paramInt1, int paramInt2, int paramInt3, long paramLong, boolean paramBoolean)
  {
    if (this.mGLContextExternal != null)
    {
      if ((this.mInputWidth != paramInt2) || (this.mInputHeight != paramInt3))
      {
        this.mInputWidth = paramInt2;
        this.mInputHeight = paramInt3;
        if (this.mResizeFilter == null)
        {
          this.mResizeFilter = new d();
          this.mResizeFilter.a();
          this.mResizeFilter.a(true);
        }
        this.mResizeFilter.a(this.mOutputWidth, this.mOutputHeight);
      }
      GLES20.glViewport(0, 0, this.mOutputWidth, this.mOutputHeight);
      if (this.mResizeFilter != null) {
        this.mResizeFilter.b(paramInt1);
      }
      if (this.mResizeFilter != null) {
        paramInt1 = this.mResizeFilter.l();
      }
      int[] arrayOfInt = new int[1];
      this.mPTS = paramLong;
      if (this.mRawFrameFilter == null)
      {
        this.mRawFrameFilter = new n(1);
        this.mRawFrameFilter.a(true);
        if (!this.mRawFrameFilter.a()) {
          this.mRawFrameFilter = null;
        }
      }
      while (this.mRawFrameFilter == null)
      {
        return 10000004L;
        this.mRawFrameFilter.a(this.mOutputWidth, this.mOutputHeight);
        this.mRawFrameFilter.a(new TXCSWVideoEncoder.1(this, paramBoolean, paramInt1));
      }
      GLES20.glViewport(0, 0, this.mOutputWidth, this.mOutputHeight);
      this.mRawFrameFilter.b(paramInt1);
      paramInt1 = arrayOfInt[0];
      if (paramInt1 != 0) {
        callDelegate(paramInt1);
      }
    }
    return 0L;
  }
  
  public long getRealBitrate()
  {
    return nativegetRealBitrate(this.mNativeX264Encoder);
  }
  
  public long getRealFPS()
  {
    return nativeGetRealFPS(this.mNativeX264Encoder);
  }
  
  public long pushVideoFrame(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    return pushVideoFrameInternal(paramInt1, paramInt2, paramInt3, paramLong, false);
  }
  
  public long pushVideoFrameSync(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    return pushVideoFrameInternal(paramInt1, paramInt2, paramInt3, paramLong, true);
  }
  
  public void setBitrate(int paramInt)
  {
    this.mBitrate = paramInt;
    nativeSetBitrate(this.mNativeX264Encoder, paramInt);
  }
  
  public void setFPS(int paramInt) {}
  
  public void signalEOSAndFlush()
  {
    nativeSignalEOSAndFlush(this.mNativeX264Encoder);
  }
  
  public int start(TXSVideoEncoderParam paramTXSVideoEncoderParam)
  {
    super.start(paramTXSVideoEncoderParam);
    int i = (paramTXSVideoEncoderParam.width + 7) / 8 * 8;
    int j = (paramTXSVideoEncoderParam.height + 1) / 2 * 2;
    if ((i != paramTXSVideoEncoderParam.width) || (j != paramTXSVideoEncoderParam.height))
    {
      TXCLog.w(TAG, "Encode Resolution not supportted, transforming...");
      TXCLog.w(TAG, paramTXSVideoEncoderParam.width + "x" + paramTXSVideoEncoderParam.height + "-> " + i + "x" + j);
    }
    paramTXSVideoEncoderParam.width = i;
    paramTXSVideoEncoderParam.height = j;
    this.mOutputWidth = i;
    this.mOutputHeight = j;
    this.mInputWidth = i;
    this.mInputHeight = j;
    this.mNativeX264Encoder = nativeInit(new WeakReference(this));
    nativeSetBitrate(this.mNativeX264Encoder, this.mBitrate);
    nativeStart(this.mNativeX264Encoder, paramTXSVideoEncoderParam);
    return 0;
  }
  
  public void stop()
  {
    this.mGLContextExternal = null;
    nativeStop(this.mNativeX264Encoder);
    nativeRelease(this.mNativeX264Encoder);
    this.mNativeX264Encoder = 0L;
    if (this.mRawFrameFilter != null)
    {
      this.mRawFrameFilter.d();
      this.mRawFrameFilter = null;
    }
    if (this.mResizeFilter != null)
    {
      this.mResizeFilter.d();
      this.mResizeFilter = null;
    }
    super.stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.liteav.videoencoder.TXCSWVideoEncoder
 * JD-Core Version:    0.7.0.1
 */