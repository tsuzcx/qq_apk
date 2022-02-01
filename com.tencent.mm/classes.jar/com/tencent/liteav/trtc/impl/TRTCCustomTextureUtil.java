package com.tencent.liteav.trtc.impl;

import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.os.HandlerThread;
import android.os.SystemClock;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.opengl.b;
import com.tencent.liteav.basic.opengl.i;
import com.tencent.liteav.basic.opengl.j;
import com.tencent.liteav.basic.util.TXCBuild;
import com.tencent.liteav.beauty.b.k;
import com.tencent.liteav.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.trtc.TRTCCloudDef.TRTCTexture;
import com.tencent.trtc.TRTCCloudDef.TRTCVideoFrame;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class TRTCCustomTextureUtil
{
  private static final String TAG = "TRTCCustomTextureUtil";
  private d mCaptureAndEnc;
  private long mCaptureFrameCount;
  private double mCurrentFps;
  private Object mEGLContext;
  private HandlerThread mEGLThread;
  private final com.tencent.liteav.basic.util.c mFpsMeter;
  private int mGLSyncMode;
  private i mGLThreadHandler;
  private k mI4202RGBAFilter;
  private long mLastCaptureCalculateTS;
  private long mLastCaptureFrameCount;
  private long mLastGLThreadId;
  private j mRotateFilter;
  
  public TRTCCustomTextureUtil(d paramd, int paramInt)
  {
    AppMethodBeat.i(230879);
    this.mGLThreadHandler = null;
    this.mEGLThread = null;
    this.mEGLContext = null;
    this.mI4202RGBAFilter = null;
    this.mLastCaptureCalculateTS = 0L;
    this.mCaptureFrameCount = 0L;
    this.mLastCaptureFrameCount = 0L;
    this.mCurrentFps = 0.0D;
    this.mGLSyncMode = 0;
    this.mCaptureAndEnc = paramd;
    this.mFpsMeter = new com.tencent.liteav.basic.util.c("send-custom-texture", (int)TimeUnit.SECONDS.toMillis(5L));
    this.mGLSyncMode = paramInt;
    apiLog("TRTCCustomTextureUtil: glMode:".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(230879);
  }
  
  private void apiLog(String paramString)
  {
    AppMethodBeat.i(15595);
    TXCLog.i("TRTCCustomTextureUtil", "trtc_api ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(15595);
  }
  
  private void checkEGLContext(TRTCCloudDef.TRTCVideoFrame paramTRTCVideoFrame)
  {
    AppMethodBeat.i(15592);
    if (paramTRTCVideoFrame == null)
    {
      AppMethodBeat.o(15592);
      return;
    }
    int i;
    int j;
    if (this.mLastGLThreadId == Thread.currentThread().getId())
    {
      if (paramTRTCVideoFrame.texture == null) {
        break label224;
      }
      if (paramTRTCVideoFrame.texture.eglContext10 == null) {
        break label219;
      }
      if (!paramTRTCVideoFrame.texture.eglContext10.equals(this.mEGLContext))
      {
        i = 1;
        j = i;
        if (i != 0)
        {
          apiLog("CustomCapture egl10Context change!");
          j = i;
        }
        label81:
        i = j;
        if (paramTRTCVideoFrame.texture.eglContext14 != null)
        {
          if (paramTRTCVideoFrame.texture.eglContext14.equals(this.mEGLContext)) {
            break label189;
          }
          j = 1;
          label112:
          i = j;
          if (j != 0)
          {
            apiLog("CustomCapture egl14Context change!");
            i = j;
          }
        }
      }
    }
    for (;;)
    {
      label126:
      this.mLastGLThreadId = Thread.currentThread().getId();
      if (paramTRTCVideoFrame.texture != null) {
        if (paramTRTCVideoFrame.texture.eglContext10 == null) {
          break label205;
        }
      }
      label189:
      label205:
      for (this.mEGLContext = paramTRTCVideoFrame.texture.eglContext10;; this.mEGLContext = paramTRTCVideoFrame.texture.eglContext14)
      {
        if (i != 0)
        {
          stopThread();
          startThread(paramTRTCVideoFrame);
        }
        AppMethodBeat.o(15592);
        return;
        i = 0;
        break;
        j = 0;
        break label112;
        apiLog("CustomCapture eglContext's thread change!");
        i = 1;
        break label126;
      }
      label219:
      j = 0;
      break label81;
      label224:
      i = 0;
    }
  }
  
  private int checkRotate(int paramInt, TRTCCloudDef.TRTCVideoFrame paramTRTCVideoFrame)
  {
    AppMethodBeat.i(15596);
    if ((paramTRTCVideoFrame == null) || (paramTRTCVideoFrame.rotation == 0))
    {
      AppMethodBeat.o(15596);
      return paramInt;
    }
    int j = paramTRTCVideoFrame.rotation;
    if (this.mRotateFilter == null)
    {
      localj = new j();
      localj.a();
      localj.a(true);
      localj.a(paramTRTCVideoFrame.width, paramTRTCVideoFrame.height);
      this.mRotateFilter = localj;
    }
    j localj = this.mRotateFilter;
    int i = paramInt;
    if (localj != null)
    {
      GLES20.glViewport(0, 0, paramTRTCVideoFrame.width, paramTRTCVideoFrame.height);
      i = (720 - j * 90) % 360;
      localj.a(paramTRTCVideoFrame.width, paramTRTCVideoFrame.height);
      localj.a(paramTRTCVideoFrame.width, paramTRTCVideoFrame.height, i, null, paramTRTCVideoFrame.width / paramTRTCVideoFrame.height, false, false);
      localj.b(paramInt);
      j = localj.l();
      if ((i != 90) && (i != 270)) {
        break label230;
      }
      paramInt = paramTRTCVideoFrame.height;
      if ((i != 90) && (i != 270)) {
        break label238;
      }
    }
    label230:
    label238:
    for (i = paramTRTCVideoFrame.width;; i = paramTRTCVideoFrame.height)
    {
      paramTRTCVideoFrame.width = paramInt;
      paramTRTCVideoFrame.height = i;
      i = j;
      AppMethodBeat.o(15596);
      return i;
      paramInt = paramTRTCVideoFrame.width;
      break;
    }
  }
  
  private void sendCustomTextureInternal(final TRTCCloudDef.TRTCVideoFrame paramTRTCVideoFrame)
  {
    AppMethodBeat.i(15591);
    try
    {
      if (this.mGLThreadHandler != null)
      {
        if (this.mGLSyncMode == 0) {
          GLES20.glFinish();
        }
        final i locali = this.mGLThreadHandler;
        this.mGLThreadHandler.post(new Runnable()
        {
          public void run()
          {
            int j = 3;
            AppMethodBeat.i(15662);
            locali.d();
            if (locali.d)
            {
              if (paramTRTCVideoFrame.texture != null)
              {
                paramTRTCVideoFrame.texture.textureId = TRTCCustomTextureUtil.access$000(TRTCCustomTextureUtil.this, paramTRTCVideoFrame.texture.textureId, paramTRTCVideoFrame);
                if (TRTCCustomTextureUtil.this.mGLSyncMode == 0)
                {
                  TRTCCustomTextureUtil.this.mCaptureAndEnc.b(paramTRTCVideoFrame.texture.textureId, paramTRTCVideoFrame.width, paramTRTCVideoFrame.height, locali.e.f(), paramTRTCVideoFrame.timestamp);
                  AppMethodBeat.o(15662);
                  return;
                }
                TRTCCustomTextureUtil.this.mCaptureAndEnc.a(paramTRTCVideoFrame.texture.textureId, paramTRTCVideoFrame.width, paramTRTCVideoFrame.height, locali.e.f(), paramTRTCVideoFrame.timestamp);
                AppMethodBeat.o(15662);
              }
            }
            else
            {
              if (paramTRTCVideoFrame.texture != null)
              {
                paramTRTCVideoFrame.texture.textureId = TRTCCustomTextureUtil.access$000(TRTCCustomTextureUtil.this, paramTRTCVideoFrame.texture.textureId, paramTRTCVideoFrame);
                if (TRTCCustomTextureUtil.this.mGLSyncMode == 0)
                {
                  TRTCCustomTextureUtil.this.mCaptureAndEnc.b(paramTRTCVideoFrame.texture.textureId, paramTRTCVideoFrame.width, paramTRTCVideoFrame.height, locali.g.d(), paramTRTCVideoFrame.timestamp);
                  AppMethodBeat.o(15662);
                  return;
                }
                TRTCCustomTextureUtil.this.mCaptureAndEnc.a(paramTRTCVideoFrame.texture.textureId, paramTRTCVideoFrame.width, paramTRTCVideoFrame.height, locali.g.d(), paramTRTCVideoFrame.timestamp);
                AppMethodBeat.o(15662);
                return;
              }
              int i;
              if (paramTRTCVideoFrame.pixelFormat == 1) {
                i = 1;
              }
              for (;;)
              {
                if (TRTCCustomTextureUtil.this.mI4202RGBAFilter == null)
                {
                  localk = new k(i);
                  localk.a(true);
                  if (!localk.a()) {
                    TXCLog.e("TRTCCustomTextureUtil", "mI4202RGBAFilter init failed!!, break init");
                  }
                  localk.a(paramTRTCVideoFrame.width, paramTRTCVideoFrame.height);
                  TRTCCustomTextureUtil.access$302(TRTCCustomTextureUtil.this, localk);
                }
                k localk = TRTCCustomTextureUtil.this.mI4202RGBAFilter;
                if (localk == null) {
                  break label632;
                }
                GLES20.glViewport(0, 0, paramTRTCVideoFrame.width, paramTRTCVideoFrame.height);
                localk.a(paramTRTCVideoFrame.data);
                i = localk.r();
                i = TRTCCustomTextureUtil.access$000(TRTCCustomTextureUtil.this, i, paramTRTCVideoFrame);
                if (locali.g == null) {
                  break label632;
                }
                if (TRTCCustomTextureUtil.this.mGLSyncMode != 0) {
                  break;
                }
                TRTCCustomTextureUtil.this.mCaptureAndEnc.b(i, paramTRTCVideoFrame.width, paramTRTCVideoFrame.height, locali.g.d(), paramTRTCVideoFrame.timestamp);
                AppMethodBeat.o(15662);
                return;
                i = j;
                if (paramTRTCVideoFrame.pixelFormat == 4) {
                  i = j;
                }
              }
              TRTCCustomTextureUtil.this.mCaptureAndEnc.a(i, paramTRTCVideoFrame.width, paramTRTCVideoFrame.height, locali.g.d(), paramTRTCVideoFrame.timestamp);
            }
            label632:
            AppMethodBeat.o(15662);
          }
        });
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(15591);
    }
  }
  
  private void startThread(TRTCCloudDef.TRTCVideoFrame paramTRTCVideoFrame)
  {
    AppMethodBeat.i(15593);
    if (paramTRTCVideoFrame == null)
    {
      AppMethodBeat.o(15593);
      return;
    }
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    for (;;)
    {
      try
      {
        if (this.mEGLThread == null)
        {
          this.mEGLThread = new HandlerThread("customCaptureGLThread");
          this.mEGLThread.start();
          this.mGLThreadHandler = new i(this.mEGLThread.getLooper());
          if (paramTRTCVideoFrame.texture == null)
          {
            apiLog("CustomCapture buffer start egl10 thread");
            this.mGLThreadHandler.d = false;
            this.mGLThreadHandler.h = null;
            this.mGLThreadHandler.a = 1280;
            this.mGLThreadHandler.b = 720;
            this.mGLThreadHandler.sendEmptyMessage(100);
            this.mGLThreadHandler.post(new Runnable()
            {
              public void run()
              {
                AppMethodBeat.i(15729);
                TXCLog.i("TRTCCustomTextureUtil", "GLContext create finished!");
                localCountDownLatch.countDown();
                AppMethodBeat.o(15729);
              }
            });
          }
        }
      }
      finally
      {
        AppMethodBeat.o(15593);
      }
      try
      {
        localCountDownLatch.await();
        AppMethodBeat.o(15593);
        return;
      }
      catch (InterruptedException paramTRTCVideoFrame)
      {
        Thread.currentThread().interrupt();
        AppMethodBeat.o(15593);
      }
      if (paramTRTCVideoFrame.texture.eglContext10 != null)
      {
        apiLog("CustomCapture texture start egl10 thread");
        this.mGLThreadHandler.d = false;
        this.mGLThreadHandler.h = paramTRTCVideoFrame.texture.eglContext10;
        this.mGLThreadHandler.a = 1280;
        this.mGLThreadHandler.b = 720;
        this.mGLThreadHandler.sendEmptyMessage(100);
      }
      else if ((paramTRTCVideoFrame.texture.eglContext14 != null) && (TXCBuild.VersionInt() >= 17))
      {
        apiLog("CustomCapture texture start egl14 thread");
        this.mGLThreadHandler.d = true;
        this.mGLThreadHandler.f = paramTRTCVideoFrame.texture.eglContext14;
        this.mGLThreadHandler.a = 1280;
        this.mGLThreadHandler.b = 720;
        this.mGLThreadHandler.sendEmptyMessage(100);
        continue;
        localCountDownLatch.countDown();
      }
    }
  }
  
  private void stopThread()
  {
    try
    {
      AppMethodBeat.i(15594);
      if (this.mGLThreadHandler != null)
      {
        final j localj = this.mRotateFilter;
        this.mRotateFilter = null;
        final k localk = this.mI4202RGBAFilter;
        this.mI4202RGBAFilter = null;
        this.mGLThreadHandler.post(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(230708);
            if (localj != null) {
              localj.d();
            }
            if (localk != null) {
              localk.d();
            }
            if (TRTCCustomTextureUtil.this.mCaptureAndEnc != null)
            {
              TRTCCustomTextureUtil.access$400(TRTCCustomTextureUtil.this, "CustomCapture release");
              TRTCCustomTextureUtil.this.mCaptureAndEnc.s();
            }
            AppMethodBeat.o(230708);
          }
        });
        i.a(this.mGLThreadHandler, this.mEGLThread);
        apiLog("CustomCapture destroy egl thread");
      }
      this.mGLThreadHandler = null;
      this.mEGLThread = null;
      AppMethodBeat.o(15594);
      return;
    }
    finally {}
  }
  
  public double getCurrentFPS()
  {
    AppMethodBeat.i(230907);
    long l1 = SystemClock.elapsedRealtime();
    long l2 = l1 - this.mLastCaptureCalculateTS;
    if (l2 >= 1000L)
    {
      this.mCurrentFps = ((this.mCaptureFrameCount - this.mLastCaptureFrameCount) * 1000.0D / l2);
      this.mLastCaptureFrameCount = this.mCaptureFrameCount;
      this.mLastCaptureCalculateTS = l1;
    }
    double d = this.mCurrentFps;
    AppMethodBeat.o(230907);
    return d;
  }
  
  public void release()
  {
    AppMethodBeat.i(15589);
    stopThread();
    AppMethodBeat.o(15589);
  }
  
  public void sendCustomTexture(TRTCCloudDef.TRTCVideoFrame paramTRTCVideoFrame)
  {
    AppMethodBeat.i(15590);
    this.mFpsMeter.a();
    checkEGLContext(paramTRTCVideoFrame);
    sendCustomTextureInternal(paramTRTCVideoFrame);
    if (this.mLastCaptureCalculateTS == 0L)
    {
      this.mLastCaptureCalculateTS = SystemClock.elapsedRealtime();
      this.mLastCaptureFrameCount = 0L;
      this.mCaptureFrameCount = 0L;
      AppMethodBeat.o(15590);
      return;
    }
    this.mCaptureFrameCount += 1L;
    AppMethodBeat.o(15590);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCustomTextureUtil
 * JD-Core Version:    0.7.0.1
 */