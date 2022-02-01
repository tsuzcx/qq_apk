package com.tencent.mm.plugin.api.recordView;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.HandlerThread;
import com.tencent.e.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public final class h
{
  private final String TAG;
  EGLDisplay eglDisplay;
  EGLSurface eglSurface;
  private boolean guO;
  HandlerThread hkS;
  ap hkT;
  int[] hoL;
  EGLContext hoR;
  int huh;
  int jus;
  int jut;
  i jvw;
  i.a jvx;
  int jvy;
  int jvz;
  
  public h()
  {
    AppMethodBeat.i(89273);
    this.TAG = "MicroMsg.YUVDateRenderToRBGBufferThread";
    this.hkS = d.gZ("YUVDateRenderToRBGBufferThread", 5);
    this.jvx = null;
    this.guO = false;
    this.hoL = new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12610, 1, 12344 };
    this.eglDisplay = null;
    this.eglSurface = null;
    this.hoR = null;
    AppMethodBeat.o(89273);
  }
  
  private void J(Runnable paramRunnable)
  {
    AppMethodBeat.i(89277);
    if (this.hkS.isAlive()) {
      this.hkT.post(paramRunnable);
    }
    AppMethodBeat.o(89277);
  }
  
  static boolean Ki(String paramString)
  {
    AppMethodBeat.i(89279);
    int i = EGL14.eglGetError();
    if (i != 12288)
    {
      ad.m("MicroMsg.YUVDateRenderToRBGBufferThread", paramString + ": EGL error: 0x" + Integer.toHexString(i), new Object[0]);
      AppMethodBeat.o(89279);
      return true;
    }
    AppMethodBeat.o(89279);
    return false;
  }
  
  public final void C(final byte[] paramArrayOfByte, final int paramInt)
  {
    AppMethodBeat.i(89275);
    if ((!this.guO) && (this.jvw == null))
    {
      AppMethodBeat.o(89275);
      return;
    }
    J(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(89271);
        i locali = h.this.jvw;
        byte[] arrayOfByte = paramArrayOfByte;
        int j = h.this.jus;
        int k = h.this.jut;
        int m = h.this.huh;
        int n = paramInt;
        try
        {
          if ((locali.jut != k) || (locali.jus != j) || (locali.dGc != m)) {
            break label447;
          }
          if (locali.juB == n) {
            break label442;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.e("MicroMsg.YUVDateRenderToRGBBufferRenderer", "setDrawFrame error: %s", new Object[] { localException.getMessage() });
            continue;
            int i = 0;
            continue;
            i = 1;
          }
        }
        if (i != 0) {
          ad.d("MicroMsg.YUVDateRenderToRGBBufferRenderer", "setDrawFrame, frameData: %s, frameWidth: %s, frameHeight: %s, rotate: %s, isLandScape, frameSizeChange: %s, this %s", new Object[] { arrayOfByte, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Boolean.valueOf(locali.htY), Boolean.TRUE, locali });
        }
        if ((locali.frameData == null) || (locali.frameData.length != arrayOfByte.length)) {
          locali.frameData = new byte[arrayOfByte.length];
        }
        System.arraycopy(arrayOfByte, 0, locali.frameData, 0, arrayOfByte.length);
        locali.jus = j;
        locali.jut = k;
        locali.dGc = m;
        locali.juB = n;
        if (i != 0)
        {
          locali.hoy = ByteBuffer.allocateDirect(k * j);
          locali.hoF = ByteBuffer.allocateDirect(j * k / 2);
          locali.hoy.order(ByteOrder.nativeOrder());
          locali.hoF.order(ByteOrder.nativeOrder());
          if (locali.juz != null)
          {
            locali.gLm.put(locali.juz);
            locali.gLm.position(0);
          }
        }
        if ((locali.hoy != null) && (locali.hoF != null))
        {
          locali.hoy.put(locali.frameData, 0, j * k);
          locali.hoy.position(0);
          locali.hoF.put(locali.frameData, j * k, j * k / 2);
          locali.hoF.position(0);
        }
        h.this.jvw.onDrawFrame(null);
        h.this.jvx.aVx();
        AppMethodBeat.o(89271);
      }
    });
    AppMethodBeat.o(89275);
  }
  
  public final void a(i.a parama)
  {
    this.jvx = parama;
  }
  
  public final void b(final EGLContext paramEGLContext)
  {
    AppMethodBeat.i(89274);
    ad.d("MicroMsg.YUVDateRenderToRBGBufferThread", "start context : " + paramEGLContext + "  hasStart : " + this.guO);
    if ((this.guO) || (paramEGLContext == null))
    {
      AppMethodBeat.o(89274);
      return;
    }
    this.guO = true;
    this.hkS.start();
    this.hkT = new ap(this.hkS.getLooper());
    J(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(89270);
        Object localObject1 = h.this;
        EGLContext localEGLContext = paramEGLContext;
        int i = h.this.jus;
        int j = h.this.jut;
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
        EGL14.eglChooseConfig(((h)localObject1).eglDisplay, ((h)localObject1).hoL, 0, (EGLConfig[])localObject2, 0, 1, arrayOfInt, 0);
        if (localObject2[0] == null)
        {
          localObject1 = new RuntimeException("chooseConfig failed");
          AppMethodBeat.o(89270);
          throw ((Throwable)localObject1);
        }
        ((h)localObject1).hoR = EGL14.eglCreateContext(((h)localObject1).eglDisplay, localObject2[0], localEGLContext, new int[] { 12440, 2, 12344 }, 0);
        if (((h)localObject1).hoR == EGL14.EGL_NO_CONTEXT)
        {
          localObject1 = new RuntimeException("EGL error " + EGL14.eglGetError());
          AppMethodBeat.o(89270);
          throw ((Throwable)localObject1);
        }
        h.Ki("eglCreateContext");
        ((h)localObject1).eglSurface = null;
        try
        {
          ((h)localObject1).eglSurface = EGL14.eglCreatePbufferSurface(((h)localObject1).eglDisplay, localObject2[0], new int[] { 12375, i, 12374, j, 12344 }, 0);
          h.Ki("eglCreatePbufferSurface");
          if (((((h)localObject1).eglSurface == null) || (((h)localObject1).eglSurface == EGL14.EGL_NO_SURFACE)) && (EGL14.eglGetError() == 12299)) {
            ad.e("MicroMsg.YUVDateRenderToRBGBufferThread", "makeMyEGLCurrentSurface:returned EGL_BAD_NATIVE_WINDOW.");
          }
          if (!EGL14.eglMakeCurrent(((h)localObject1).eglDisplay, ((h)localObject1).eglSurface, ((h)localObject1).eglSurface, ((h)localObject1).hoR)) {
            ad.w("MicroMsg.YUVDateRenderToRBGBufferThread", "eglMakeCurrent:" + EGL14.eglGetError());
          }
          localObject1 = h.this;
          i = h.this.jvy;
          j = h.this.jvz;
          ((h)localObject1).jvw = new i(i, j);
          ((h)localObject1).jvw.onSurfaceCreated(null, null);
          ((h)localObject1).jvw.onSurfaceChanged(null, i, j);
          if (((h)localObject1).jvx != null) {
            ((h)localObject1).jvw.buffer = ((h)localObject1).jvx.getBuffer();
          }
          AppMethodBeat.o(89270);
          return;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          for (;;)
          {
            ad.e("MicroMsg.YUVDateRenderToRBGBufferThread", "eglCreateWindowSurface", new Object[] { localIllegalArgumentException });
          }
        }
      }
    });
    AppMethodBeat.o(89274);
  }
  
  public final void i(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(89276);
    ad.i("MicroMsg.YUVDateRenderToRBGBufferThread", "setFrameInfo, width: %s, height: %s, rotate: %s ,targetWidth:%d ,targetHeight:%d , this: %s ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), this });
    if ((paramInt1 != this.jus) || (paramInt2 != this.jut) || (paramInt3 != this.huh))
    {
      this.jus = paramInt1;
      this.jut = paramInt2;
      this.huh = paramInt3;
    }
    this.jvy = paramInt4;
    this.jvz = paramInt5;
    AppMethodBeat.o(89276);
  }
  
  public final void release()
  {
    AppMethodBeat.i(89278);
    J(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(89272);
        Object localObject = h.this.jvw;
        if (((i)localObject).jvD != 0) {
          GLES20.glDeleteTextures(1, new int[] { ((i)localObject).jvD }, 0);
        }
        if (((i)localObject).jvE != 0) {
          GLES20.glDeleteFramebuffers(1, new int[] { ((i)localObject).jvE }, 0);
        }
        localObject = h.this.eglDisplay;
        EGLSurface localEGLSurface = EGL14.EGL_NO_SURFACE;
        EGL14.eglMakeCurrent((EGLDisplay)localObject, localEGLSurface, localEGLSurface, EGL14.EGL_NO_CONTEXT);
        if ((h.this.eglSurface != null) && (h.this.hoR != null) && (h.this.eglDisplay != null))
        {
          EGL14.eglDestroySurface(h.this.eglDisplay, h.this.eglSurface);
          EGL14.eglDestroyContext(h.this.eglDisplay, h.this.hoR);
          EGL14.eglReleaseThread();
          EGL14.eglTerminate(h.this.eglDisplay);
          h.this.hoR = null;
          h.this.eglDisplay = null;
          h.this.eglSurface = null;
        }
        h.this.hkT.removeCallbacksAndMessages(null);
        h.this.hkS.quitSafely();
        AppMethodBeat.o(89272);
      }
    });
    AppMethodBeat.o(89278);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.h
 * JD-Core Version:    0.7.0.1
 */