package com.tencent.liteav.videoencoder;

import android.opengl.GLES20;
import com.tencent.liteav.basic.d.a;
import com.tencent.liteav.basic.d.g;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.b;
import com.tencent.liteav.beauty.b.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public class TXCSWVideoEncoder
  extends c
{
  private static final boolean DEBUG = false;
  private static final String TAG;
  private int mBitrate = 0;
  private long mNativeEncoder = 0L;
  private long mPTS = 0L;
  private int mPopIdx = 0;
  private int mPushIdx = 0;
  private g mRawFrameFilter;
  private int mRendIdx = 0;
  private g mResizeFilter;
  
  static
  {
    AppMethodBeat.i(67409);
    TAG = TXCSWVideoEncoder.class.getSimpleName();
    b.f();
    nativeClassInit();
    AppMethodBeat.o(67409);
  }
  
  public static long getAndIncreaseGopIndex()
  {
    AppMethodBeat.i(146322);
    long l = nativeGetAndIncreaseGopIndex();
    AppMethodBeat.o(146322);
    return l;
  }
  
  public static long getAndIncreateSeq()
  {
    AppMethodBeat.i(146321);
    long l = nativeGetAndIncreaseSeq();
    AppMethodBeat.o(146321);
    return l;
  }
  
  private static native void nativeClassInit();
  
  private native void nativeEnableNearestRPS(long paramLong, int paramInt);
  
  private native int nativeEncode(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2);
  
  private native int nativeEncodeSync(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2);
  
  private static native long nativeGetAndIncreaseGopIndex();
  
  private static native long nativeGetAndIncreaseSeq();
  
  private native long nativeGetRealFPS(long paramLong);
  
  private native long nativeInit(WeakReference<TXCSWVideoEncoder> paramWeakReference);
  
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
  
  private static void onEncodeFinishedFromNative(WeakReference<TXCSWVideoEncoder> paramWeakReference, long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(146323);
    paramWeakReference = (TXCSWVideoEncoder)paramWeakReference.get();
    if (paramWeakReference != null) {
      paramWeakReference.onEncodeFinished(paramLong1, paramLong2, paramLong3);
    }
    AppMethodBeat.o(146323);
  }
  
  private static void postEventFromNative(WeakReference<TXCSWVideoEncoder> paramWeakReference, byte[] paramArrayOfByte, int paramInt1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, int paramInt2)
  {
    AppMethodBeat.i(67405);
    paramWeakReference = (TXCSWVideoEncoder)paramWeakReference.get();
    if (paramWeakReference != null) {
      paramWeakReference.callDelegate(paramArrayOfByte, paramInt1, paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6, paramInt2, null, null);
    }
    AppMethodBeat.o(67405);
  }
  
  private long pushVideoFrameInternal(int paramInt1, int paramInt2, int paramInt3, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(67406);
    if (this.mGLContextExternal != null)
    {
      this.mInputWidth = paramInt2;
      this.mInputHeight = paramInt3;
      if (this.mResizeFilter == null)
      {
        this.mResizeFilter = new g();
        this.mResizeFilter.a();
        this.mResizeFilter.a(true);
      }
      this.mResizeFilter.a(this.mOutputWidth, this.mOutputHeight);
      GLES20.glViewport(0, 0, this.mOutputWidth, this.mOutputHeight);
      Object localObject;
      int k;
      int i;
      if (this.mResizeFilter != null)
      {
        localObject = b.a(paramInt2, paramInt3, this.mOutputWidth, this.mOutputHeight);
        localObject = this.mResizeFilter.a(paramInt2, paramInt3, null, (a)localObject, 0);
        k = (720 - this.mRotation) % 360;
        if ((k != 90) && (k != 270)) {
          break label301;
        }
        i = this.mOutputHeight;
        if ((k != 90) && (k != 270)) {
          break label310;
        }
      }
      label301:
      label310:
      for (int j = this.mOutputWidth;; j = this.mOutputHeight)
      {
        this.mResizeFilter.a(paramInt2, paramInt3, k, (float[])localObject, i / j, false, false);
        this.mResizeFilter.b(paramInt1);
        if (this.mResizeFilter != null) {
          paramInt1 = this.mResizeFilter.l();
        }
        localObject = new int[1];
        this.mPTS = paramLong;
        if (this.mRawFrameFilter != null) {
          break label352;
        }
        TXCLog.i(TAG, "pushVideoFrameInternal->create mRawFrameFilter");
        this.mRawFrameFilter = new o(1);
        this.mRawFrameFilter.a(true);
        if (this.mRawFrameFilter.a()) {
          break label319;
        }
        TXCLog.i(TAG, "pushVideoFrameInternal->destroy mRawFrameFilter, init failed!");
        this.mRawFrameFilter = null;
        AppMethodBeat.o(67406);
        return 10000004L;
        i = this.mOutputWidth;
        break;
      }
      label319:
      this.mRawFrameFilter.a(this.mOutputWidth, this.mOutputHeight);
      this.mRawFrameFilter.a(new TXCSWVideoEncoder.1(this, paramBoolean, paramInt1));
      label352:
      if (this.mRawFrameFilter == null)
      {
        AppMethodBeat.o(67406);
        return 10000004L;
      }
      GLES20.glViewport(0, 0, this.mOutputWidth, this.mOutputHeight);
      this.mRawFrameFilter.b(paramInt1);
      paramInt1 = localObject[0];
      if (paramInt1 != 0) {
        callDelegate(paramInt1);
      }
    }
    AppMethodBeat.o(67406);
    return 0L;
  }
  
  public void enableNearestRPS(int paramInt)
  {
    AppMethodBeat.i(146315);
    nativeEnableNearestRPS(this.mNativeEncoder, paramInt);
    AppMethodBeat.o(146315);
  }
  
  public long getRealBitrate()
  {
    AppMethodBeat.i(67401);
    long l = nativegetRealBitrate(this.mNativeEncoder);
    AppMethodBeat.o(67401);
    return l;
  }
  
  public double getRealFPS()
  {
    AppMethodBeat.i(146318);
    double d = nativeGetRealFPS(this.mNativeEncoder);
    AppMethodBeat.o(146318);
    return d;
  }
  
  public long pushVideoFrame(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(67402);
    paramLong = pushVideoFrameInternal(paramInt1, paramInt2, paramInt3, paramLong, false);
    AppMethodBeat.o(67402);
    return paramLong;
  }
  
  public long pushVideoFrameSync(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(67403);
    paramLong = pushVideoFrameInternal(paramInt1, paramInt2, paramInt3, paramLong, true);
    AppMethodBeat.o(67403);
    return paramLong;
  }
  
  public void restartIDR()
  {
    AppMethodBeat.i(146320);
    nativeRestartIDR(this.mNativeEncoder);
    AppMethodBeat.o(146320);
  }
  
  public void setBitrate(int paramInt)
  {
    AppMethodBeat.i(67399);
    this.mBitrate = paramInt;
    nativeSetBitrate(this.mNativeEncoder, paramInt);
    AppMethodBeat.o(67399);
  }
  
  public void setBitrateFromQos(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(146316);
    this.mBitrate = paramInt1;
    nativeSetBitrateFromQos(this.mNativeEncoder, paramInt1, paramInt2);
    AppMethodBeat.o(146316);
  }
  
  public void setEncodeIdrFpsFromQos(int paramInt)
  {
    AppMethodBeat.i(146317);
    nativeSetEncodeIdrFpsFromQos(this.mNativeEncoder, paramInt);
    AppMethodBeat.o(146317);
  }
  
  public void setFPS(int paramInt)
  {
    AppMethodBeat.i(146314);
    nativeSetFPS(this.mNativeEncoder, paramInt);
    AppMethodBeat.o(146314);
  }
  
  public void setID(String paramString)
  {
    AppMethodBeat.i(146313);
    super.setID(paramString);
    nativeSetID(this.mNativeEncoder, paramString);
    AppMethodBeat.o(146313);
  }
  
  public void setRPSRefBitmap(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(146319);
    nativeSetRPSRefBitmap(this.mNativeEncoder, paramInt1, paramInt2, paramLong);
    AppMethodBeat.o(146319);
  }
  
  public void signalEOSAndFlush()
  {
    AppMethodBeat.i(67404);
    nativeSignalEOSAndFlush(this.mNativeEncoder);
    AppMethodBeat.o(67404);
  }
  
  public int start(TXSVideoEncoderParam paramTXSVideoEncoderParam)
  {
    AppMethodBeat.i(67397);
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
    this.mNativeEncoder = nativeInit(new WeakReference(this));
    nativeSetBitrate(this.mNativeEncoder, this.mBitrate);
    nativeSetID(this.mNativeEncoder, getID());
    nativeStart(this.mNativeEncoder, paramTXSVideoEncoderParam);
    AppMethodBeat.o(67397);
    return 0;
  }
  
  public void stop()
  {
    AppMethodBeat.i(67398);
    TXCLog.i(TAG, "stop->enter with mRawFrameFilter:" + this.mRawFrameFilter);
    this.mGLContextExternal = null;
    nativeStop(this.mNativeEncoder);
    nativeRelease(this.mNativeEncoder);
    this.mNativeEncoder = 0L;
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
    AppMethodBeat.o(67398);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.liteav.videoencoder.TXCSWVideoEncoder
 * JD-Core Version:    0.7.0.1
 */