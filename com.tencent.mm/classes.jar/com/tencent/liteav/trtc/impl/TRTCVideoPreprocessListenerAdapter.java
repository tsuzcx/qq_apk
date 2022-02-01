package com.tencent.liteav.trtc.impl;

import android.opengl.GLES20;
import com.tencent.liteav.basic.a.a;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.opengl.TXCOpenGlUtils;
import com.tencent.liteav.basic.opengl.e.a;
import com.tencent.liteav.basic.util.e;
import com.tencent.liteav.beauty.b.k;
import com.tencent.liteav.beauty.b.o;
import com.tencent.liteav.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.trtc.TRTCCloudDef.TRTCTexture;
import com.tencent.trtc.TRTCCloudDef.TRTCVideoFrame;
import com.tencent.trtc.TRTCCloudListener.TRTCVideoFrameListener;
import java.nio.ByteBuffer;

public class TRTCVideoPreprocessListenerAdapter
  implements m
{
  private static final String TAG = "TRTCVideoPreprocessListenerAdapter";
  private int mBufferType;
  private final a mDelayQueue;
  private int mFrameBufferId;
  private boolean mHasNotifiedGLContextCreated;
  private final e mLastFrameSize;
  private TRTCCloudListener.TRTCVideoFrameListener mListener;
  private int mPixelFormat;
  private o mRGBAToYUVFilter;
  private final TRTCCloudDef.TRTCVideoFrame mShadowInputFrame;
  private final TRTCCloudDef.TRTCVideoFrame mShadowOutputFrame;
  private final TRTCCloudDef.TRTCVideoFrame mYUVInputFrame;
  private final TRTCCloudDef.TRTCVideoFrame mYUVOutputFrame;
  private k mYUVToRGBAFilter;
  
  public TRTCVideoPreprocessListenerAdapter()
  {
    AppMethodBeat.i(230721);
    this.mLastFrameSize = new e(0, 0);
    this.mYUVInputFrame = new TRTCCloudDef.TRTCVideoFrame();
    this.mYUVOutputFrame = new TRTCCloudDef.TRTCVideoFrame();
    this.mShadowInputFrame = new TRTCCloudDef.TRTCVideoFrame();
    this.mShadowOutputFrame = new TRTCCloudDef.TRTCVideoFrame();
    this.mDelayQueue = new a();
    this.mHasNotifiedGLContextCreated = false;
    this.mFrameBufferId = -1;
    AppMethodBeat.o(230721);
  }
  
  private void convertTextureToYUV(int paramInt, TRTCCloudDef.TRTCVideoFrame paramTRTCVideoFrame)
  {
    AppMethodBeat.i(230751);
    int i = paramTRTCVideoFrame.width;
    int j = paramTRTCVideoFrame.height;
    Object localObject = getRGBAToYUVFilter(paramTRTCVideoFrame.pixelFormat, i, j);
    GLES20.glViewport(0, 0, i, j);
    ((o)localObject).a(i, j);
    TXCOpenGlUtils.a(((o)localObject).b(paramInt), this.mFrameBufferId);
    localObject = e.a.a;
    if (paramTRTCVideoFrame.pixelFormat == 1)
    {
      localObject = e.a.b;
      GLES20.glBindFramebuffer(36160, this.mFrameBufferId);
      if (paramTRTCVideoFrame.bufferType != 1) {
        break label134;
      }
      TXCOpenGlUtils.a((e.a)localObject, i, j, paramTRTCVideoFrame.buffer);
    }
    for (;;)
    {
      TXCOpenGlUtils.d(this.mFrameBufferId);
      AppMethodBeat.o(230751);
      return;
      if (paramTRTCVideoFrame.pixelFormat != 4) {
        break;
      }
      localObject = e.a.c;
      break;
      label134:
      TXCOpenGlUtils.a((e.a)localObject, i, j, paramTRTCVideoFrame.data);
    }
  }
  
  private void convertYUVToTexture(TRTCCloudDef.TRTCVideoFrame paramTRTCVideoFrame, int paramInt)
  {
    AppMethodBeat.i(230744);
    if ((paramTRTCVideoFrame.data == null) && (paramTRTCVideoFrame.buffer == null))
    {
      AppMethodBeat.o(230744);
      return;
    }
    int i = paramTRTCVideoFrame.width;
    int j = paramTRTCVideoFrame.height;
    k localk = getYUVToRGBAFilter(paramTRTCVideoFrame.pixelFormat, i, j);
    TXCOpenGlUtils.a(paramInt, this.mFrameBufferId);
    GLES20.glViewport(0, 0, i, j);
    if (paramTRTCVideoFrame.bufferType == 2) {
      localk.a(paramTRTCVideoFrame.data);
    }
    for (;;)
    {
      GLES20.glBindFramebuffer(36160, this.mFrameBufferId);
      localk.a(-1, this.mFrameBufferId, paramInt);
      TXCOpenGlUtils.d(this.mFrameBufferId);
      AppMethodBeat.o(230744);
      return;
      if (paramTRTCVideoFrame.bufferType == 1) {
        localk.a(paramTRTCVideoFrame.buffer);
      }
    }
  }
  
  private o getRGBAToYUVFilter(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(230757);
    if (this.mRGBAToYUVFilter == null) {
      if (paramInt1 != 1) {
        break label79;
      }
    }
    label79:
    for (paramInt1 = 1;; paramInt1 = 3)
    {
      this.mRGBAToYUVFilter = new o(paramInt1);
      this.mRGBAToYUVFilter.a(true);
      if (!this.mRGBAToYUVFilter.a()) {
        TXCLog.e("TRTCVideoPreprocessListenerAdapter", "init RGBA to YUV filter failed.");
      }
      this.mRGBAToYUVFilter.a(paramInt2, paramInt3);
      o localo = this.mRGBAToYUVFilter;
      AppMethodBeat.o(230757);
      return localo;
    }
  }
  
  private k getYUVToRGBAFilter(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 1;
    AppMethodBeat.i(230763);
    if (this.mYUVToRGBAFilter == null) {
      if (paramInt1 != 1) {
        break label75;
      }
    }
    label75:
    for (paramInt1 = i;; paramInt1 = 3)
    {
      this.mYUVToRGBAFilter = new k(paramInt1);
      if (!this.mYUVToRGBAFilter.a()) {
        TXCLog.e("TRTCVideoPreprocessListenerAdapter", "init YUV to RGBA failed.");
      }
      this.mYUVToRGBAFilter.a(paramInt2, paramInt3);
      k localk = this.mYUVToRGBAFilter;
      AppMethodBeat.o(230763);
      return localk;
    }
  }
  
  private static void initVideoFrame(TRTCCloudDef.TRTCVideoFrame paramTRTCVideoFrame, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(230731);
    paramTRTCVideoFrame.width = paramInt1;
    paramTRTCVideoFrame.height = paramInt2;
    paramTRTCVideoFrame.pixelFormat = paramInt3;
    paramTRTCVideoFrame.bufferType = paramInt4;
    if ((paramInt3 == 2) && (paramTRTCVideoFrame.texture == null))
    {
      paramTRTCVideoFrame.texture = new TRTCCloudDef.TRTCTexture();
      Object localObject = TXCOpenGlUtils.e();
      if ((localObject instanceof android.opengl.EGLContext))
      {
        paramTRTCVideoFrame.texture.eglContext14 = ((android.opengl.EGLContext)localObject);
        AppMethodBeat.o(230731);
        return;
      }
      paramTRTCVideoFrame.texture.eglContext10 = ((javax.microedition.khronos.egl.EGLContext)localObject);
      AppMethodBeat.o(230731);
      return;
    }
    if ((paramInt3 == 1) || (paramInt3 == 4))
    {
      if ((paramInt4 == 2) && (paramTRTCVideoFrame.data == null))
      {
        paramTRTCVideoFrame.data = new byte[paramInt1 * paramInt2 * 3 / 2];
        AppMethodBeat.o(230731);
        return;
      }
      if ((paramInt4 == 1) && (paramTRTCVideoFrame.buffer == null)) {
        paramTRTCVideoFrame.buffer = ByteBuffer.allocateDirect(paramInt1 * paramInt2 * 3 / 2);
      }
    }
    AppMethodBeat.o(230731);
  }
  
  private void notifyGLContextCreated()
  {
    AppMethodBeat.i(230764);
    if ((this.mListener != null) && (!this.mHasNotifiedGLContextCreated))
    {
      this.mListener.onGLContextCreated();
      this.mHasNotifiedGLContextCreated = true;
    }
    AppMethodBeat.o(230764);
  }
  
  private void notifyGLContextDestroy()
  {
    AppMethodBeat.i(230766);
    if ((this.mListener != null) && (this.mHasNotifiedGLContextCreated))
    {
      this.mListener.onGLContextDestory();
      this.mHasNotifiedGLContextCreated = false;
    }
    AppMethodBeat.o(230766);
  }
  
  private void releaseOpenGLResources()
  {
    AppMethodBeat.i(230768);
    if (this.mRGBAToYUVFilter != null)
    {
      this.mRGBAToYUVFilter.d();
      this.mRGBAToYUVFilter = null;
    }
    if (this.mYUVToRGBAFilter != null)
    {
      this.mYUVToRGBAFilter.d();
      this.mYUVToRGBAFilter = null;
    }
    TXCOpenGlUtils.b(this.mFrameBufferId);
    this.mFrameBufferId = -1;
    AppMethodBeat.o(230768);
  }
  
  private void setListenerInternal(int paramInt1, int paramInt2, TRTCCloudListener.TRTCVideoFrameListener paramTRTCVideoFrameListener)
  {
    AppMethodBeat.i(230726);
    notifyGLContextDestroy();
    this.mPixelFormat = paramInt1;
    this.mBufferType = paramInt2;
    this.mListener = paramTRTCVideoFrameListener;
    notifyGLContextCreated();
    AppMethodBeat.o(230726);
  }
  
  private void shadowCopyVideoFrame(TRTCCloudDef.TRTCVideoFrame paramTRTCVideoFrame1, TRTCCloudDef.TRTCVideoFrame paramTRTCVideoFrame2)
  {
    paramTRTCVideoFrame2.width = paramTRTCVideoFrame1.width;
    paramTRTCVideoFrame2.height = paramTRTCVideoFrame1.height;
    paramTRTCVideoFrame2.pixelFormat = paramTRTCVideoFrame1.pixelFormat;
    paramTRTCVideoFrame2.bufferType = paramTRTCVideoFrame1.bufferType;
    paramTRTCVideoFrame2.texture = paramTRTCVideoFrame1.texture;
    paramTRTCVideoFrame2.data = paramTRTCVideoFrame1.data;
    paramTRTCVideoFrame2.buffer = paramTRTCVideoFrame1.buffer;
  }
  
  public void onDetectFacePoints(float[] paramArrayOfFloat) {}
  
  public void onGLContextCreated()
  {
    AppMethodBeat.i(230779);
    this.mDelayQueue.a();
    notifyGLContextCreated();
    AppMethodBeat.o(230779);
  }
  
  public void onGLContextReadyToDestory()
  {
    AppMethodBeat.i(230801);
    this.mDelayQueue.a();
    notifyGLContextDestroy();
    releaseOpenGLResources();
    AppMethodBeat.o(230801);
  }
  
  public int onProcessVideoFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(230789);
    this.mDelayQueue.a();
    if (this.mListener == null)
    {
      AppMethodBeat.o(230789);
      return paramInt1;
    }
    if ((this.mLastFrameSize.a != paramInt2) || (this.mLastFrameSize.b != paramInt3))
    {
      releaseOpenGLResources();
      this.mYUVInputFrame.data = null;
      this.mYUVInputFrame.buffer = null;
      this.mYUVOutputFrame.data = null;
      this.mYUVOutputFrame.buffer = null;
      this.mLastFrameSize.a = paramInt2;
      this.mLastFrameSize.b = paramInt3;
    }
    initVideoFrame(this.mYUVInputFrame, paramInt2, paramInt3, this.mPixelFormat, this.mBufferType);
    initVideoFrame(this.mYUVOutputFrame, paramInt2, paramInt3, this.mPixelFormat, this.mBufferType);
    if (this.mPixelFormat == 2)
    {
      this.mYUVInputFrame.texture.textureId = paramInt1;
      this.mYUVOutputFrame.texture.textureId = paramInt4;
      this.mListener.onProcessVideoFrame(this.mYUVInputFrame, this.mYUVOutputFrame);
      paramInt1 = this.mYUVOutputFrame.texture.textureId;
      AppMethodBeat.o(230789);
      return paramInt1;
    }
    if (this.mFrameBufferId == -1) {
      this.mFrameBufferId = TXCOpenGlUtils.d();
    }
    convertTextureToYUV(paramInt1, this.mYUVInputFrame);
    shadowCopyVideoFrame(this.mYUVInputFrame, this.mShadowInputFrame);
    shadowCopyVideoFrame(this.mYUVOutputFrame, this.mShadowOutputFrame);
    this.mListener.onProcessVideoFrame(this.mShadowInputFrame, this.mShadowOutputFrame);
    convertYUVToTexture(this.mShadowOutputFrame, paramInt4);
    AppMethodBeat.o(230789);
    return paramInt4;
  }
  
  public void setListener(final int paramInt1, final int paramInt2, final TRTCCloudListener.TRTCVideoFrameListener paramTRTCVideoFrameListener)
  {
    AppMethodBeat.i(230772);
    this.mDelayQueue.a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(230838);
        TRTCVideoPreprocessListenerAdapter.access$000(TRTCVideoPreprocessListenerAdapter.this, paramInt1, paramInt2, paramTRTCVideoFrameListener);
        AppMethodBeat.o(230838);
      }
    });
    AppMethodBeat.o(230772);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCVideoPreprocessListenerAdapter
 * JD-Core Version:    0.7.0.1
 */