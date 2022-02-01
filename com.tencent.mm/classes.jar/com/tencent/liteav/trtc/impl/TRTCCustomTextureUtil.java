package com.tencent.liteav.trtc.impl;

import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import com.tencent.liteav.basic.d.b;
import com.tencent.liteav.basic.d.f;
import com.tencent.liteav.basic.d.g;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.beauty.b.k;
import com.tencent.liteav.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.trtc.TRTCCloudDef.TRTCTexture;
import com.tencent.trtc.TRTCCloudDef.TRTCVideoFrame;

public class TRTCCustomTextureUtil
{
  private static final String TAG;
  private c mCaptureAndEnc;
  private Object mEGLContext;
  private HandlerThread mEGLThread;
  private Object mGLLock;
  private f mGLThreadHandler;
  private k mI4202RGBAFilter;
  private long mLastGLThreadId;
  private g mRotateFilter;
  
  static
  {
    AppMethodBeat.i(15599);
    TAG = TRTCCustomTextureUtil.class.getSimpleName();
    AppMethodBeat.o(15599);
  }
  
  public TRTCCustomTextureUtil(c paramc)
  {
    AppMethodBeat.i(15588);
    this.mGLThreadHandler = null;
    this.mEGLThread = null;
    this.mGLLock = new Object();
    this.mEGLContext = null;
    this.mI4202RGBAFilter = null;
    this.mCaptureAndEnc = paramc;
    AppMethodBeat.o(15588);
  }
  
  private void apiLog(String paramString)
  {
    AppMethodBeat.i(15595);
    TXCLog.i(TAG, "trtc_api ".concat(String.valueOf(paramString)));
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
      localg = new g();
      localg.a();
      localg.a(true);
      localg.a(paramTRTCVideoFrame.width, paramTRTCVideoFrame.height);
      this.mRotateFilter = localg;
    }
    g localg = this.mRotateFilter;
    int i = paramInt;
    if (localg != null)
    {
      GLES20.glViewport(0, 0, paramTRTCVideoFrame.width, paramTRTCVideoFrame.height);
      i = (720 - j * 90) % 360;
      localg.a(paramTRTCVideoFrame.width, paramTRTCVideoFrame.height);
      localg.a(paramTRTCVideoFrame.width, paramTRTCVideoFrame.height, i, null, paramTRTCVideoFrame.width / paramTRTCVideoFrame.height, false, false);
      localg.b(paramInt);
      j = localg.l();
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
        GLES20.glFinish();
        this.mGLThreadHandler.post(new Runnable()
        {
          public void run()
          {
            int j = 3;
            AppMethodBeat.i(15662);
            f localf = TRTCCustomTextureUtil.this.mGLThreadHandler;
            if (localf != null)
            {
              localf.d();
              if (localf.d)
              {
                if (paramTRTCVideoFrame.texture != null)
                {
                  paramTRTCVideoFrame.texture.textureId = TRTCCustomTextureUtil.access$100(TRTCCustomTextureUtil.this, paramTRTCVideoFrame.texture.textureId, paramTRTCVideoFrame);
                  TRTCCustomTextureUtil.this.mCaptureAndEnc.a(paramTRTCVideoFrame.texture.textureId, paramTRTCVideoFrame.width, paramTRTCVideoFrame.height, localf.e, paramTRTCVideoFrame.timestamp, paramTRTCVideoFrame.rotation);
                  AppMethodBeat.o(15662);
                }
              }
              else
              {
                if (paramTRTCVideoFrame.texture != null)
                {
                  paramTRTCVideoFrame.texture.textureId = TRTCCustomTextureUtil.access$100(TRTCCustomTextureUtil.this, paramTRTCVideoFrame.texture.textureId, paramTRTCVideoFrame);
                  TRTCCustomTextureUtil.this.mCaptureAndEnc.a(paramTRTCVideoFrame.texture.textureId, paramTRTCVideoFrame.width, paramTRTCVideoFrame.height, localf.g, paramTRTCVideoFrame.timestamp, paramTRTCVideoFrame.rotation);
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
                      TXCLog.e(TRTCCustomTextureUtil.TAG, "mI4202RGBAFilter init failed!!, break init");
                    }
                    localk.a(paramTRTCVideoFrame.width, paramTRTCVideoFrame.height);
                    TRTCCustomTextureUtil.access$302(TRTCCustomTextureUtil.this, localk);
                  }
                  k localk = TRTCCustomTextureUtil.this.mI4202RGBAFilter;
                  if (localk == null) {
                    break;
                  }
                  GLES20.glViewport(0, 0, paramTRTCVideoFrame.width, paramTRTCVideoFrame.height);
                  localk.a(paramTRTCVideoFrame.data);
                  i = localk.q();
                  i = TRTCCustomTextureUtil.access$100(TRTCCustomTextureUtil.this, i, paramTRTCVideoFrame);
                  TRTCCustomTextureUtil.this.mCaptureAndEnc.a(i, paramTRTCVideoFrame.width, paramTRTCVideoFrame.height, localf.f.d(), paramTRTCVideoFrame.timestamp, paramTRTCVideoFrame.rotation);
                  AppMethodBeat.o(15662);
                  return;
                  i = j;
                  if (paramTRTCVideoFrame.pixelFormat == 4) {
                    i = j;
                  }
                }
                TRTCCustomTextureUtil.this.mCaptureAndEnc.a(paramTRTCVideoFrame.data, i, paramTRTCVideoFrame.width, paramTRTCVideoFrame.height, localf.f.d(), paramTRTCVideoFrame.timestamp, paramTRTCVideoFrame.rotation);
              }
            }
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
    for (;;)
    {
      try
      {
        if (this.mEGLThread == null)
        {
          this.mEGLThread = new HandlerThread("customCaptureGLThread");
          this.mEGLThread.start();
          this.mGLThreadHandler = new f(this.mEGLThread.getLooper());
          if (paramTRTCVideoFrame.texture == null)
          {
            apiLog("CustomCapture buffer start egl10 thread");
            this.mGLThreadHandler.d = false;
            this.mGLThreadHandler.g = null;
            this.mGLThreadHandler.a = 1280;
            this.mGLThreadHandler.b = 720;
            this.mGLThreadHandler.sendEmptyMessage(100);
          }
        }
        else
        {
          return;
        }
        if (paramTRTCVideoFrame.texture.eglContext10 != null)
        {
          apiLog("CustomCapture texture start egl10 thread");
          this.mGLThreadHandler.d = false;
          this.mGLThreadHandler.g = paramTRTCVideoFrame.texture.eglContext10;
          this.mGLThreadHandler.a = 1280;
          this.mGLThreadHandler.b = 720;
          this.mGLThreadHandler.sendEmptyMessage(100);
          continue;
        }
        if (paramTRTCVideoFrame.texture.eglContext14 == null) {
          continue;
        }
      }
      finally
      {
        AppMethodBeat.o(15593);
      }
      if (Build.VERSION.SDK_INT >= 17)
      {
        apiLog("CustomCapture texture start egl14 thread");
        this.mGLThreadHandler.d = true;
        this.mGLThreadHandler.e = paramTRTCVideoFrame.texture.eglContext14;
        this.mGLThreadHandler.a = 1280;
        this.mGLThreadHandler.b = 720;
        this.mGLThreadHandler.sendEmptyMessage(100);
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
        final g localg = this.mRotateFilter;
        this.mRotateFilter = null;
        final k localk = this.mI4202RGBAFilter;
        this.mI4202RGBAFilter = null;
        this.mGLThreadHandler.post(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(15729);
            if (localg != null) {
              localg.d();
            }
            if (localk != null) {
              localk.d();
            }
            if (TRTCCustomTextureUtil.this.mCaptureAndEnc != null)
            {
              TRTCCustomTextureUtil.access$500(TRTCCustomTextureUtil.this, "CustomCapture release");
              TRTCCustomTextureUtil.this.mCaptureAndEnc.s();
            }
            AppMethodBeat.o(15729);
          }
        });
        f.a(this.mGLThreadHandler, this.mEGLThread);
        apiLog("CustomCapture destroy egl thread");
      }
      this.mGLThreadHandler = null;
      this.mEGLThread = null;
      AppMethodBeat.o(15594);
      return;
    }
    finally {}
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
    checkEGLContext(paramTRTCVideoFrame);
    sendCustomTextureInternal(paramTRTCVideoFrame);
    AppMethodBeat.o(15590);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCustomTextureUtil
 * JD-Core Version:    0.7.0.1
 */