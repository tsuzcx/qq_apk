package com.tencent.mm.plugin.api.recordView;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.HandlerThread;
import com.tencent.f.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public final class h
{
  private final String TAG;
  EGLDisplay eglDisplay;
  EGLSurface eglSurface;
  private boolean hki;
  HandlerThread igZ;
  MMHandler iha;
  int[] ilp;
  EGLContext ilv;
  int iqx;
  int kxW;
  int kxX;
  i kza;
  i.a kzb;
  int kzc;
  int kzd;
  
  public h()
  {
    AppMethodBeat.i(89273);
    this.TAG = "MicroMsg.YUVDateRenderToRBGBufferThread";
    this.igZ = d.hC("YUVDateRenderToRBGBufferThread", 5);
    this.kzb = null;
    this.hki = false;
    this.ilp = new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12610, 1, 12344 };
    this.eglDisplay = null;
    this.eglSurface = null;
    this.ilv = null;
    AppMethodBeat.o(89273);
  }
  
  private void M(Runnable paramRunnable)
  {
    AppMethodBeat.i(89277);
    if (this.igZ.isAlive()) {
      this.iha.post(paramRunnable);
    }
    AppMethodBeat.o(89277);
  }
  
  static boolean TP(String paramString)
  {
    AppMethodBeat.i(89279);
    int i = EGL14.eglGetError();
    if (i != 12288)
    {
      Log.printInfoStack("MicroMsg.YUVDateRenderToRBGBufferThread", paramString + ": EGL error: 0x" + Integer.toHexString(i), new Object[0]);
      AppMethodBeat.o(89279);
      return true;
    }
    AppMethodBeat.o(89279);
    return false;
  }
  
  public final void E(final byte[] paramArrayOfByte, final int paramInt)
  {
    AppMethodBeat.i(89275);
    if ((!this.hki) && (this.kza == null))
    {
      AppMethodBeat.o(89275);
      return;
    }
    M(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(89271);
        i locali = h.this.kza;
        byte[] arrayOfByte = paramArrayOfByte;
        int j = h.this.kxW;
        int k = h.this.kxX;
        int m = h.this.iqx;
        int n = paramInt;
        try
        {
          if ((locali.kxX != k) || (locali.kxW != j) || (locali.dYT != m)) {
            break label447;
          }
          if (locali.kyf == n) {
            break label442;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.e("MicroMsg.YUVDateRenderToRGBBufferRenderer", "setDrawFrame error: %s", new Object[] { localException.getMessage() });
            continue;
            int i = 0;
            continue;
            i = 1;
          }
        }
        if (i != 0) {
          Log.d("MicroMsg.YUVDateRenderToRGBBufferRenderer", "setDrawFrame, frameData: %s, frameWidth: %s, frameHeight: %s, rotate: %s, isLandScape, frameSizeChange: %s, this %s", new Object[] { arrayOfByte, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Boolean.valueOf(locali.iqo), Boolean.TRUE, locali });
        }
        if ((locali.frameData == null) || (locali.frameData.length != arrayOfByte.length)) {
          locali.frameData = new byte[arrayOfByte.length];
        }
        System.arraycopy(arrayOfByte, 0, locali.frameData, 0, arrayOfByte.length);
        locali.kxW = j;
        locali.kxX = k;
        locali.dYT = m;
        locali.kyf = n;
        if (i != 0)
        {
          locali.ikI = ByteBuffer.allocateDirect(k * j);
          locali.ikP = ByteBuffer.allocateDirect(j * k / 2);
          locali.ikI.order(ByteOrder.nativeOrder());
          locali.ikP.order(ByteOrder.nativeOrder());
          if (locali.kyd != null)
          {
            locali.hDU.put(locali.kyd);
            locali.hDU.position(0);
          }
        }
        if ((locali.ikI != null) && (locali.ikP != null))
        {
          locali.ikI.put(locali.frameData, 0, j * k);
          locali.ikI.position(0);
          locali.ikP.put(locali.frameData, j * k, j * k / 2);
          locali.ikP.position(0);
        }
        h.this.kza.onDrawFrame(null);
        h.this.kzb.bqT();
        AppMethodBeat.o(89271);
      }
    });
    AppMethodBeat.o(89275);
  }
  
  public final void a(i.a parama)
  {
    this.kzb = parama;
  }
  
  public final void b(final EGLContext paramEGLContext)
  {
    AppMethodBeat.i(89274);
    Log.d("MicroMsg.YUVDateRenderToRBGBufferThread", "start context : " + paramEGLContext + "  hasStart : " + this.hki);
    if ((this.hki) || (paramEGLContext == null))
    {
      AppMethodBeat.o(89274);
      return;
    }
    this.hki = true;
    this.igZ.start();
    this.iha = new MMHandler(this.igZ.getLooper());
    M(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(89270);
        Object localObject1 = h.this;
        EGLContext localEGLContext = paramEGLContext;
        int i = h.this.kxW;
        int j = h.this.kxX;
        ((h)localObject1).eglDisplay = EGL14.eglGetDisplay(0);
        if (((h)localObject1).eglDisplay == EGL14.EGL_NO_DISPLAY)
        {
          localObject1 = new RuntimeException("unable to get EGL14 display");
          AppMethodBeat.o(89270);
          throw ((Throwable)localObject1);
        }
        Object localObject2 = new int[2];
        if (!EGL14.eglInitialize(((h)localObject1).eglDisplay, (int[])localObject2, 0, (int[])localObject2, 1))
        {
          ((h)localObject1).eglDisplay = null;
          localObject1 = new RuntimeException("eglInitialize failed");
          AppMethodBeat.o(89270);
          throw ((Throwable)localObject1);
        }
        localObject2 = new EGLConfig[1];
        int[] arrayOfInt = new int[1];
        EGL14.eglChooseConfig(((h)localObject1).eglDisplay, ((h)localObject1).ilp, 0, (EGLConfig[])localObject2, 0, 1, arrayOfInt, 0);
        if (localObject2[0] == null)
        {
          localObject1 = new RuntimeException("chooseConfig failed");
          AppMethodBeat.o(89270);
          throw ((Throwable)localObject1);
        }
        ((h)localObject1).ilv = EGL14.eglCreateContext(((h)localObject1).eglDisplay, localObject2[0], localEGLContext, new int[] { 12440, 2, 12344 }, 0);
        if (((h)localObject1).ilv == EGL14.EGL_NO_CONTEXT)
        {
          localObject1 = new RuntimeException("EGL error " + EGL14.eglGetError());
          AppMethodBeat.o(89270);
          throw ((Throwable)localObject1);
        }
        h.TP("eglCreateContext");
        ((h)localObject1).eglSurface = null;
        try
        {
          ((h)localObject1).eglSurface = EGL14.eglCreatePbufferSurface(((h)localObject1).eglDisplay, localObject2[0], new int[] { 12375, i, 12374, j, 12344 }, 0);
          h.TP("eglCreatePbufferSurface");
          if (((((h)localObject1).eglSurface == null) || (((h)localObject1).eglSurface == EGL14.EGL_NO_SURFACE)) && (EGL14.eglGetError() == 12299)) {
            Log.e("MicroMsg.YUVDateRenderToRBGBufferThread", "makeMyEGLCurrentSurface:returned EGL_BAD_NATIVE_WINDOW.");
          }
          if (!EGL14.eglMakeCurrent(((h)localObject1).eglDisplay, ((h)localObject1).eglSurface, ((h)localObject1).eglSurface, ((h)localObject1).ilv)) {
            Log.w("MicroMsg.YUVDateRenderToRBGBufferThread", "eglMakeCurrent:" + EGL14.eglGetError());
          }
          localObject1 = h.this;
          i = h.this.kzc;
          j = h.this.kzd;
          ((h)localObject1).kza = new i(i, j);
          ((h)localObject1).kza.onSurfaceCreated(null, null);
          ((h)localObject1).kza.onSurfaceChanged(null, i, j);
          if (((h)localObject1).kzb != null) {
            ((h)localObject1).kza.buffer = ((h)localObject1).kzb.getBuffer();
          }
          AppMethodBeat.o(89270);
          return;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          for (;;)
          {
            Log.e("MicroMsg.YUVDateRenderToRBGBufferThread", "eglCreateWindowSurface", new Object[] { localIllegalArgumentException });
          }
        }
      }
    });
    AppMethodBeat.o(89274);
  }
  
  public final void i(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(89276);
    Log.i("MicroMsg.YUVDateRenderToRBGBufferThread", "setFrameInfo, width: %s, height: %s, rotate: %s ,targetWidth:%d ,targetHeight:%d , this: %s ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), this });
    if ((paramInt1 != this.kxW) || (paramInt2 != this.kxX) || (paramInt3 != this.iqx))
    {
      this.kxW = paramInt1;
      this.kxX = paramInt2;
      this.iqx = paramInt3;
    }
    this.kzc = paramInt4;
    this.kzd = paramInt5;
    AppMethodBeat.o(89276);
  }
  
  public final void release()
  {
    AppMethodBeat.i(89278);
    M(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(89272);
        Object localObject = h.this.kza;
        if (((i)localObject).kzh != 0) {
          GLES20.glDeleteTextures(1, new int[] { ((i)localObject).kzh }, 0);
        }
        if (((i)localObject).kzi != 0) {
          GLES20.glDeleteFramebuffers(1, new int[] { ((i)localObject).kzi }, 0);
        }
        localObject = h.this.eglDisplay;
        EGLSurface localEGLSurface = EGL14.EGL_NO_SURFACE;
        EGL14.eglMakeCurrent((EGLDisplay)localObject, localEGLSurface, localEGLSurface, EGL14.EGL_NO_CONTEXT);
        if ((h.this.eglSurface != null) && (h.this.ilv != null) && (h.this.eglDisplay != null))
        {
          EGL14.eglDestroySurface(h.this.eglDisplay, h.this.eglSurface);
          EGL14.eglDestroyContext(h.this.eglDisplay, h.this.ilv);
          EGL14.eglReleaseThread();
          EGL14.eglTerminate(h.this.eglDisplay);
          h.this.ilv = null;
          h.this.eglDisplay = null;
          h.this.eglSurface = null;
        }
        h.this.iha.removeCallbacksAndMessages(null);
        h.this.igZ.quitSafely();
        AppMethodBeat.o(89272);
      }
    });
    AppMethodBeat.o(89278);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.h
 * JD-Core Version:    0.7.0.1
 */