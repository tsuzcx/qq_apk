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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public final class h
{
  private final String TAG;
  EGLDisplay eglDisplay;
  EGLSurface eglSurface;
  HandlerThread gSR;
  ao gSS;
  int[] gWF;
  EGLContext gWL;
  private boolean gbe;
  int hbZ;
  int jbj;
  int jbk;
  i jcn;
  i.a jco;
  int jcp;
  int jcq;
  
  public h()
  {
    AppMethodBeat.i(89273);
    this.TAG = "MicroMsg.YUVDateRenderToRBGBufferThread";
    this.gSR = d.gB("YUVDateRenderToRBGBufferThread", 5);
    this.jco = null;
    this.gbe = false;
    this.gWF = new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12610, 1, 12344 };
    this.eglDisplay = null;
    this.eglSurface = null;
    this.gWL = null;
    AppMethodBeat.o(89273);
  }
  
  static boolean GT(String paramString)
  {
    AppMethodBeat.i(89279);
    int i = EGL14.eglGetError();
    if (i != 12288)
    {
      ac.m("MicroMsg.YUVDateRenderToRBGBufferThread", paramString + ": EGL error: 0x" + Integer.toHexString(i), new Object[0]);
      AppMethodBeat.o(89279);
      return true;
    }
    AppMethodBeat.o(89279);
    return false;
  }
  
  private void K(Runnable paramRunnable)
  {
    AppMethodBeat.i(89277);
    if (this.gSR.isAlive()) {
      this.gSS.post(paramRunnable);
    }
    AppMethodBeat.o(89277);
  }
  
  public final void C(final byte[] paramArrayOfByte, final int paramInt)
  {
    AppMethodBeat.i(89275);
    if ((!this.gbe) && (this.jcn == null))
    {
      AppMethodBeat.o(89275);
      return;
    }
    K(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(89271);
        i locali = h.this.jcn;
        byte[] arrayOfByte = paramArrayOfByte;
        int j = h.this.jbj;
        int k = h.this.jbk;
        int m = h.this.hbZ;
        int n = paramInt;
        try
        {
          if ((locali.jbk != k) || (locali.jbj != j) || (locali.duc != m)) {
            break label447;
          }
          if (locali.jbs == n) {
            break label442;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ac.e("MicroMsg.YUVDateRenderToRGBBufferRenderer", "setDrawFrame error: %s", new Object[] { localException.getMessage() });
            continue;
            int i = 0;
            continue;
            i = 1;
          }
        }
        if (i != 0) {
          ac.d("MicroMsg.YUVDateRenderToRGBBufferRenderer", "setDrawFrame, frameData: %s, frameWidth: %s, frameHeight: %s, rotate: %s, isLandScape, frameSizeChange: %s, this %s", new Object[] { arrayOfByte, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Boolean.valueOf(locali.hbQ), Boolean.TRUE, locali });
        }
        if ((locali.frameData == null) || (locali.frameData.length != arrayOfByte.length)) {
          locali.frameData = new byte[arrayOfByte.length];
        }
        System.arraycopy(arrayOfByte, 0, locali.frameData, 0, arrayOfByte.length);
        locali.jbj = j;
        locali.jbk = k;
        locali.duc = m;
        locali.jbs = n;
        if (i != 0)
        {
          locali.gWs = ByteBuffer.allocateDirect(k * j);
          locali.gWz = ByteBuffer.allocateDirect(j * k / 2);
          locali.gWs.order(ByteOrder.nativeOrder());
          locali.gWz.order(ByteOrder.nativeOrder());
          if (locali.jbq != null)
          {
            locali.grE.put(locali.jbq);
            locali.grE.position(0);
          }
        }
        if ((locali.gWs != null) && (locali.gWz != null))
        {
          locali.gWs.put(locali.frameData, 0, j * k);
          locali.gWs.position(0);
          locali.gWz.put(locali.frameData, j * k, j * k / 2);
          locali.gWz.position(0);
        }
        h.this.jcn.onDrawFrame(null);
        h.this.jco.aSl();
        AppMethodBeat.o(89271);
      }
    });
    AppMethodBeat.o(89275);
  }
  
  public final void a(i.a parama)
  {
    this.jco = parama;
  }
  
  public final void b(final EGLContext paramEGLContext)
  {
    AppMethodBeat.i(89274);
    ac.d("MicroMsg.YUVDateRenderToRBGBufferThread", "start context : " + paramEGLContext + "  hasStart : " + this.gbe);
    if ((this.gbe) || (paramEGLContext == null))
    {
      AppMethodBeat.o(89274);
      return;
    }
    this.gbe = true;
    this.gSR.start();
    this.gSS = new ao(this.gSR.getLooper());
    K(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(89270);
        Object localObject1 = h.this;
        EGLContext localEGLContext = paramEGLContext;
        int i = h.this.jbj;
        int j = h.this.jbk;
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
        EGL14.eglChooseConfig(((h)localObject1).eglDisplay, ((h)localObject1).gWF, 0, (EGLConfig[])localObject2, 0, 1, arrayOfInt, 0);
        if (localObject2[0] == null)
        {
          localObject1 = new RuntimeException("chooseConfig failed");
          AppMethodBeat.o(89270);
          throw ((Throwable)localObject1);
        }
        ((h)localObject1).gWL = EGL14.eglCreateContext(((h)localObject1).eglDisplay, localObject2[0], localEGLContext, new int[] { 12440, 2, 12344 }, 0);
        if (((h)localObject1).gWL == EGL14.EGL_NO_CONTEXT)
        {
          localObject1 = new RuntimeException("EGL error " + EGL14.eglGetError());
          AppMethodBeat.o(89270);
          throw ((Throwable)localObject1);
        }
        h.GT("eglCreateContext");
        ((h)localObject1).eglSurface = null;
        try
        {
          ((h)localObject1).eglSurface = EGL14.eglCreatePbufferSurface(((h)localObject1).eglDisplay, localObject2[0], new int[] { 12375, i, 12374, j, 12344 }, 0);
          h.GT("eglCreatePbufferSurface");
          if (((((h)localObject1).eglSurface == null) || (((h)localObject1).eglSurface == EGL14.EGL_NO_SURFACE)) && (EGL14.eglGetError() == 12299)) {
            ac.e("MicroMsg.YUVDateRenderToRBGBufferThread", "makeMyEGLCurrentSurface:returned EGL_BAD_NATIVE_WINDOW.");
          }
          if (!EGL14.eglMakeCurrent(((h)localObject1).eglDisplay, ((h)localObject1).eglSurface, ((h)localObject1).eglSurface, ((h)localObject1).gWL)) {
            ac.w("MicroMsg.YUVDateRenderToRBGBufferThread", "eglMakeCurrent:" + EGL14.eglGetError());
          }
          localObject1 = h.this;
          i = h.this.jcp;
          j = h.this.jcq;
          ((h)localObject1).jcn = new i(i, j);
          ((h)localObject1).jcn.onSurfaceCreated(null, null);
          ((h)localObject1).jcn.onSurfaceChanged(null, i, j);
          if (((h)localObject1).jco != null) {
            ((h)localObject1).jcn.buffer = ((h)localObject1).jco.getBuffer();
          }
          AppMethodBeat.o(89270);
          return;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          for (;;)
          {
            ac.e("MicroMsg.YUVDateRenderToRBGBufferThread", "eglCreateWindowSurface", new Object[] { localIllegalArgumentException });
          }
        }
      }
    });
    AppMethodBeat.o(89274);
  }
  
  public final void h(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(89276);
    ac.i("MicroMsg.YUVDateRenderToRBGBufferThread", "setFrameInfo, width: %s, height: %s, rotate: %s ,targetWidth:%d ,targetHeight:%d , this: %s ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), this });
    if ((paramInt1 != this.jbj) || (paramInt2 != this.jbk) || (paramInt3 != this.hbZ))
    {
      this.jbj = paramInt1;
      this.jbk = paramInt2;
      this.hbZ = paramInt3;
    }
    this.jcp = paramInt4;
    this.jcq = paramInt5;
    AppMethodBeat.o(89276);
  }
  
  public final void release()
  {
    AppMethodBeat.i(89278);
    K(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(89272);
        Object localObject = h.this.jcn;
        if (((i)localObject).jcu != 0) {
          GLES20.glDeleteTextures(1, new int[] { ((i)localObject).jcu }, 0);
        }
        if (((i)localObject).jcv != 0) {
          GLES20.glDeleteFramebuffers(1, new int[] { ((i)localObject).jcv }, 0);
        }
        localObject = h.this.eglDisplay;
        EGLSurface localEGLSurface = EGL14.EGL_NO_SURFACE;
        EGL14.eglMakeCurrent((EGLDisplay)localObject, localEGLSurface, localEGLSurface, EGL14.EGL_NO_CONTEXT);
        if ((h.this.eglSurface != null) && (h.this.gWL != null) && (h.this.eglDisplay != null))
        {
          EGL14.eglDestroySurface(h.this.eglDisplay, h.this.eglSurface);
          EGL14.eglDestroyContext(h.this.eglDisplay, h.this.gWL);
          EGL14.eglReleaseThread();
          EGL14.eglTerminate(h.this.eglDisplay);
          h.this.gWL = null;
          h.this.eglDisplay = null;
          h.this.eglSurface = null;
        }
        h.this.gSS.removeCallbacksAndMessages(null);
        h.this.gSR.quitSafely();
        AppMethodBeat.o(89272);
      }
    });
    AppMethodBeat.o(89278);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.h
 * JD-Core Version:    0.7.0.1
 */