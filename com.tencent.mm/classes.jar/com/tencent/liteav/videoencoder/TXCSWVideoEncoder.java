package com.tencent.liteav.videoencoder;

import android.opengl.GLES20;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.opengl.j;
import com.tencent.liteav.basic.opengl.j.a;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.util.h;
import com.tencent.liteav.beauty.b.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public class TXCSWVideoEncoder
  extends d
{
  private static final boolean DEBUG = false;
  private static final String TAG;
  private int mBitrate = 0;
  private long mNativeEncoder = 0L;
  private long mPTS = 0L;
  private int mPopIdx = 0;
  private int mPushIdx = 0;
  private j mRawFrameFilter;
  private int mRendIdx = 0;
  private j mResizeFilter;
  
  static
  {
    AppMethodBeat.i(14849);
    TAG = TXCSWVideoEncoder.class.getSimpleName();
    h.d();
    nativeClassInit();
    AppMethodBeat.o(14849);
  }
  
  public static long getAndIncreaseGopIndex()
  {
    AppMethodBeat.i(14843);
    long l = nativeGetAndIncreaseGopIndex();
    AppMethodBeat.o(14843);
    return l;
  }
  
  public static long getAndIncreateSeq()
  {
    AppMethodBeat.i(14842);
    long l = nativeGetAndIncreaseSeq();
    AppMethodBeat.o(14842);
    return l;
  }
  
  public static boolean isRPSSupported()
  {
    AppMethodBeat.i(229493);
    boolean bool = nativeIsRPSSupported();
    AppMethodBeat.o(229493);
    return bool;
  }
  
  private static native void nativeClassInit();
  
  private native void nativeEnableNearestRPS(long paramLong, int paramInt);
  
  private native int nativeEncode(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2);
  
  private native int nativeEncodeSync(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2);
  
  private static native long nativeGetAndIncreaseGopIndex();
  
  private static native long nativeGetAndIncreaseSeq();
  
  private native long nativeGetRealFPS(long paramLong);
  
  private native long nativeInit(WeakReference<TXCSWVideoEncoder> paramWeakReference);
  
  private static native boolean nativeIsRPSSupported();
  
  private native void nativeRelease(long paramLong);
  
  private native void nativeRestartIDR(long paramLong);
  
  private native void nativeSetBitrate(long paramLong, int paramInt);
  
  private native void nativeSetBitrateFromQos(long paramLong, int paramInt1, int paramInt2);
  
  private native void nativeSetEncodeIdrFpsFromQos(long paramLong, int paramInt);
  
  private native void nativeSetFPS(long paramLong, int paramInt);
  
  private native void nativeSetID(long paramLong, String paramString);
  
  private native void nativeSetRPSRefBitmap(long paramLong1, int paramInt1, int paramInt2, long paramLong2);
  
  private native void nativeSignalEOSAndFlush(long paramLong);
  
  private native int nativeStart(long paramLong, TXSVideoEncoderParam paramTXSVideoEncoderParam);
  
  private native void nativeStop(long paramLong);
  
  private native long nativegetRealBitrate(long paramLong);
  
  private static void onEncodeFinishedFromNative(WeakReference<TXCSWVideoEncoder> paramWeakReference, int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(229509);
    paramWeakReference = (TXCSWVideoEncoder)paramWeakReference.get();
    if (paramWeakReference != null) {
      paramWeakReference.onEncodeFinished(paramInt, paramLong1, paramLong2);
    }
    AppMethodBeat.o(229509);
  }
  
  private static void postEventFromNative(WeakReference<TXCSWVideoEncoder> paramWeakReference, byte[] paramArrayOfByte, int paramInt1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, int paramInt2)
  {
    AppMethodBeat.i(14844);
    paramWeakReference = (TXCSWVideoEncoder)paramWeakReference.get();
    if (paramWeakReference != null)
    {
      TXSNALPacket localTXSNALPacket = new TXSNALPacket();
      localTXSNALPacket.nalData = paramArrayOfByte;
      localTXSNALPacket.nalType = paramInt1;
      localTXSNALPacket.gopIndex = paramLong1;
      localTXSNALPacket.gopFrameIndex = paramLong2;
      localTXSNALPacket.frameIndex = paramLong3;
      localTXSNALPacket.refFremeIndex = paramLong4;
      localTXSNALPacket.pts = paramLong5;
      localTXSNALPacket.dts = paramLong6;
      paramWeakReference.callDelegate(localTXSNALPacket, paramInt2);
    }
    AppMethodBeat.o(14844);
  }
  
  private long pushVideoFrameInternal(final int paramInt1, int paramInt2, int paramInt3, long paramLong, final boolean paramBoolean)
  {
    AppMethodBeat.i(14846);
    Object localObject2 = this.mResizeFilter;
    j localj = this.mRawFrameFilter;
    Object localObject1;
    if (this.mGLContextExternal != null)
    {
      this.mInputWidth = paramInt2;
      this.mInputHeight = paramInt3;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new j();
        this.mResizeFilter = ((j)localObject1);
        ((j)localObject1).a();
        ((j)localObject1).a(true);
      }
      ((j)localObject1).a(this.mOutputWidth, this.mOutputHeight);
      GLES20.glViewport(0, 0, this.mOutputWidth, this.mOutputHeight);
      int k;
      int i;
      if (localObject1 != null)
      {
        k = (720 - this.mRotation) % 360;
        if ((k != 90) && (k != 270)) {
          break label275;
        }
        i = this.mOutputHeight;
        if ((k != 90) && (k != 270)) {
          break label284;
        }
      }
      label275:
      label284:
      for (int j = this.mOutputWidth;; j = this.mOutputHeight)
      {
        ((j)localObject1).a(paramInt2, paramInt3, k, null, i / j, this.mEnableXMirror, false);
        ((j)localObject1).b(paramInt1);
        if (localObject1 != null) {
          paramInt1 = ((j)localObject1).l();
        }
        localObject2 = new int[1];
        this.mPTS = paramLong;
        if (localj != null) {
          break label379;
        }
        TXCLog.i(TAG, "pushVideoFrameInternal->create mRawFrameFilter");
        localObject1 = new o(1);
        this.mRawFrameFilter = ((j)localObject1);
        ((j)localObject1).a(true);
        if (((j)localObject1).a()) {
          break label293;
        }
        TXCLog.i(TAG, "pushVideoFrameInternal->destroy mRawFrameFilter, init failed!");
        this.mRawFrameFilter = null;
        AppMethodBeat.o(14846);
        return 10000004L;
        i = this.mOutputWidth;
        break;
      }
      label293:
      ((j)localObject1).a(this.mOutputWidth, this.mOutputHeight);
      ((j)localObject1).a(new j.a()
      {
        public void a(int paramAnonymousInt)
        {
          AppMethodBeat.i(14825);
          synchronized (TXCSWVideoEncoder.this)
          {
            if (TXCSWVideoEncoder.this.mListener != null) {
              TXCSWVideoEncoder.this.mListener.m(TXCSWVideoEncoder.this.mStreamType);
            }
            if (paramBoolean)
            {
              TXCSWVideoEncoder.access$200(TXCSWVideoEncoder.this, TXCSWVideoEncoder.this.mNativeEncoder, paramInt1, TXCSWVideoEncoder.this.mOutputWidth, TXCSWVideoEncoder.this.mOutputHeight, TXCSWVideoEncoder.this.mPTS);
              AppMethodBeat.o(14825);
              return;
            }
            TXCSWVideoEncoder.access$300(TXCSWVideoEncoder.this, TXCSWVideoEncoder.this.mNativeEncoder, paramInt1, TXCSWVideoEncoder.this.mOutputWidth, TXCSWVideoEncoder.this.mOutputHeight, TXCSWVideoEncoder.this.mPTS);
          }
        }
      });
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        AppMethodBeat.o(14846);
        return 10000004L;
      }
      GLES20.glViewport(0, 0, this.mOutputWidth, this.mOutputHeight);
      ((j)localObject1).b(paramInt1);
      paramInt1 = localObject2[0];
      if (paramInt1 != 0) {
        callDelegate(paramInt1);
      }
      AppMethodBeat.o(14846);
      return 0L;
      label379:
      localObject1 = localj;
    }
  }
  
  public void enableNearestRPS(int paramInt)
  {
    AppMethodBeat.i(14830);
    try
    {
      nativeEnableNearestRPS(this.mNativeEncoder, paramInt);
      return;
    }
    finally
    {
      AppMethodBeat.o(14830);
    }
  }
  
  public long getRealBitrate()
  {
    AppMethodBeat.i(14835);
    try
    {
      long l = nativegetRealBitrate(this.mNativeEncoder);
      return l;
    }
    finally
    {
      AppMethodBeat.o(14835);
    }
  }
  
  public double getRealFPS()
  {
    AppMethodBeat.i(14834);
    try
    {
      double d = nativeGetRealFPS(this.mNativeEncoder);
      return d;
    }
    finally
    {
      AppMethodBeat.o(14834);
    }
  }
  
  public long pushVideoFrame(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(14836);
    paramLong = pushVideoFrameInternal(paramInt1, paramInt2, paramInt3, paramLong, false);
    AppMethodBeat.o(14836);
    return paramLong;
  }
  
  public long pushVideoFrameAsync(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(14838);
    paramLong = pushVideoFrameInternal(paramInt1, paramInt2, paramInt3, paramLong, true);
    AppMethodBeat.o(14838);
    return paramLong;
  }
  
  public long pushVideoFrameSync(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(14837);
    paramLong = pushVideoFrameInternal(paramInt1, paramInt2, paramInt3, paramLong, true);
    AppMethodBeat.o(14837);
    return paramLong;
  }
  
  public void restartIDR()
  {
    AppMethodBeat.i(14841);
    try
    {
      nativeRestartIDR(this.mNativeEncoder);
      return;
    }
    finally
    {
      AppMethodBeat.o(14841);
    }
  }
  
  public void setBitrate(int paramInt)
  {
    AppMethodBeat.i(14831);
    this.mBitrate = paramInt;
    try
    {
      nativeSetBitrate(this.mNativeEncoder, paramInt);
      return;
    }
    finally
    {
      AppMethodBeat.o(14831);
    }
  }
  
  public void setBitrateFromQos(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(14832);
    this.mBitrate = paramInt1;
    try
    {
      nativeSetBitrateFromQos(this.mNativeEncoder, paramInt1, paramInt2);
      return;
    }
    finally
    {
      AppMethodBeat.o(14832);
    }
  }
  
  public void setEncodeIdrFpsFromQos(int paramInt)
  {
    AppMethodBeat.i(14833);
    try
    {
      nativeSetEncodeIdrFpsFromQos(this.mNativeEncoder, paramInt);
      return;
    }
    finally
    {
      AppMethodBeat.o(14833);
    }
  }
  
  public void setFPS(int paramInt)
  {
    AppMethodBeat.i(14829);
    try
    {
      nativeSetFPS(this.mNativeEncoder, paramInt);
      return;
    }
    finally
    {
      AppMethodBeat.o(14829);
    }
  }
  
  public void setID(String paramString)
  {
    AppMethodBeat.i(14828);
    super.setID(paramString);
    try
    {
      nativeSetID(this.mNativeEncoder, paramString);
      return;
    }
    finally
    {
      AppMethodBeat.o(14828);
    }
  }
  
  public void setRPSRefBitmap(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(14840);
    try
    {
      nativeSetRPSRefBitmap(this.mNativeEncoder, paramInt1, paramInt2, paramLong);
      return;
    }
    finally
    {
      AppMethodBeat.o(14840);
    }
  }
  
  public void signalEOSAndFlush()
  {
    AppMethodBeat.i(14839);
    try
    {
      nativeSignalEOSAndFlush(this.mNativeEncoder);
      return;
    }
    finally
    {
      AppMethodBeat.o(14839);
    }
  }
  
  public int start(TXSVideoEncoderParam paramTXSVideoEncoderParam)
  {
    AppMethodBeat.i(14826);
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
    this.mRawFrameFilter = null;
    this.mResizeFilter = null;
    try
    {
      this.mNativeEncoder = nativeInit(new WeakReference(this));
      nativeSetBitrate(this.mNativeEncoder, this.mBitrate);
      nativeSetID(this.mNativeEncoder, getID());
      nativeStart(this.mNativeEncoder, paramTXSVideoEncoderParam);
      return 0;
    }
    finally
    {
      AppMethodBeat.o(14826);
    }
  }
  
  public void stop()
  {
    AppMethodBeat.i(14827);
    TXCLog.i(TAG, "stop->enter with mRawFrameFilter:" + this.mRawFrameFilter);
    this.mGLContextExternal = null;
    try
    {
      long l = this.mNativeEncoder;
      this.mNativeEncoder = 0L;
      nativeStop(l);
      nativeRelease(l);
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
      AppMethodBeat.o(14827);
      return;
    }
    finally
    {
      AppMethodBeat.o(14827);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.videoencoder.TXCSWVideoEncoder
 * JD-Core Version:    0.7.0.1
 */