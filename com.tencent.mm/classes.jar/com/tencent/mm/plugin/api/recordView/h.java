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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public final class h
{
  private final String TAG;
  EGLDisplay eglDisplay;
  EGLSurface eglSurface;
  private boolean gxv;
  HandlerThread hnG;
  aq hnH;
  EGLContext hrF;
  int[] hrz;
  int hwV;
  int jxn;
  int jxo;
  i jyr;
  i.a jys;
  int jyt;
  int jyu;
  
  public h()
  {
    AppMethodBeat.i(89273);
    this.TAG = "MicroMsg.YUVDateRenderToRBGBufferThread";
    this.hnG = d.hi("YUVDateRenderToRBGBufferThread", 5);
    this.jys = null;
    this.gxv = false;
    this.hrz = new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12610, 1, 12344 };
    this.eglDisplay = null;
    this.eglSurface = null;
    this.hrF = null;
    AppMethodBeat.o(89273);
  }
  
  private void H(Runnable paramRunnable)
  {
    AppMethodBeat.i(89277);
    if (this.hnG.isAlive()) {
      this.hnH.post(paramRunnable);
    }
    AppMethodBeat.o(89277);
  }
  
  static boolean KH(String paramString)
  {
    AppMethodBeat.i(89279);
    int i = EGL14.eglGetError();
    if (i != 12288)
    {
      ae.m("MicroMsg.YUVDateRenderToRBGBufferThread", paramString + ": EGL error: 0x" + Integer.toHexString(i), new Object[0]);
      AppMethodBeat.o(89279);
      return true;
    }
    AppMethodBeat.o(89279);
    return false;
  }
  
  public final void C(final byte[] paramArrayOfByte, final int paramInt)
  {
    AppMethodBeat.i(89275);
    if ((!this.gxv) && (this.jyr == null))
    {
      AppMethodBeat.o(89275);
      return;
    }
    H(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(89271);
        i locali = h.this.jyr;
        byte[] arrayOfByte = paramArrayOfByte;
        int j = h.this.jxn;
        int k = h.this.jxo;
        int m = h.this.hwV;
        int n = paramInt;
        try
        {
          if ((locali.jxo != k) || (locali.jxn != j) || (locali.dHi != m)) {
            break label447;
          }
          if (locali.jxw == n) {
            break label442;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ae.e("MicroMsg.YUVDateRenderToRGBBufferRenderer", "setDrawFrame error: %s", new Object[] { localException.getMessage() });
            continue;
            int i = 0;
            continue;
            i = 1;
          }
        }
        if (i != 0) {
          ae.d("MicroMsg.YUVDateRenderToRGBBufferRenderer", "setDrawFrame, frameData: %s, frameWidth: %s, frameHeight: %s, rotate: %s, isLandScape, frameSizeChange: %s, this %s", new Object[] { arrayOfByte, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Boolean.valueOf(locali.hwM), Boolean.TRUE, locali });
        }
        if ((locali.frameData == null) || (locali.frameData.length != arrayOfByte.length)) {
          locali.frameData = new byte[arrayOfByte.length];
        }
        System.arraycopy(arrayOfByte, 0, locali.frameData, 0, arrayOfByte.length);
        locali.jxn = j;
        locali.jxo = k;
        locali.dHi = m;
        locali.jxw = n;
        if (i != 0)
        {
          locali.hrm = ByteBuffer.allocateDirect(k * j);
          locali.hrt = ByteBuffer.allocateDirect(j * k / 2);
          locali.hrm.order(ByteOrder.nativeOrder());
          locali.hrt.order(ByteOrder.nativeOrder());
          if (locali.jxu != null)
          {
            locali.gNV.put(locali.jxu);
            locali.gNV.position(0);
          }
        }
        if ((locali.hrm != null) && (locali.hrt != null))
        {
          locali.hrm.put(locali.frameData, 0, j * k);
          locali.hrm.position(0);
          locali.hrt.put(locali.frameData, j * k, j * k / 2);
          locali.hrt.position(0);
        }
        h.this.jyr.onDrawFrame(null);
        h.this.jys.aVW();
        AppMethodBeat.o(89271);
      }
    });
    AppMethodBeat.o(89275);
  }
  
  public final void a(i.a parama)
  {
    this.jys = parama;
  }
  
  public final void b(final EGLContext paramEGLContext)
  {
    AppMethodBeat.i(89274);
    ae.d("MicroMsg.YUVDateRenderToRBGBufferThread", "start context : " + paramEGLContext + "  hasStart : " + this.gxv);
    if ((this.gxv) || (paramEGLContext == null))
    {
      AppMethodBeat.o(89274);
      return;
    }
    this.gxv = true;
    this.hnG.start();
    this.hnH = new aq(this.hnG.getLooper());
    H(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(89270);
        Object localObject1 = h.this;
        EGLContext localEGLContext = paramEGLContext;
        int i = h.this.jxn;
        int j = h.this.jxo;
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
        EGL14.eglChooseConfig(((h)localObject1).eglDisplay, ((h)localObject1).hrz, 0, (EGLConfig[])localObject2, 0, 1, arrayOfInt, 0);
        if (localObject2[0] == null)
        {
          localObject1 = new RuntimeException("chooseConfig failed");
          AppMethodBeat.o(89270);
          throw ((Throwable)localObject1);
        }
        ((h)localObject1).hrF = EGL14.eglCreateContext(((h)localObject1).eglDisplay, localObject2[0], localEGLContext, new int[] { 12440, 2, 12344 }, 0);
        if (((h)localObject1).hrF == EGL14.EGL_NO_CONTEXT)
        {
          localObject1 = new RuntimeException("EGL error " + EGL14.eglGetError());
          AppMethodBeat.o(89270);
          throw ((Throwable)localObject1);
        }
        h.KH("eglCreateContext");
        ((h)localObject1).eglSurface = null;
        try
        {
          ((h)localObject1).eglSurface = EGL14.eglCreatePbufferSurface(((h)localObject1).eglDisplay, localObject2[0], new int[] { 12375, i, 12374, j, 12344 }, 0);
          h.KH("eglCreatePbufferSurface");
          if (((((h)localObject1).eglSurface == null) || (((h)localObject1).eglSurface == EGL14.EGL_NO_SURFACE)) && (EGL14.eglGetError() == 12299)) {
            ae.e("MicroMsg.YUVDateRenderToRBGBufferThread", "makeMyEGLCurrentSurface:returned EGL_BAD_NATIVE_WINDOW.");
          }
          if (!EGL14.eglMakeCurrent(((h)localObject1).eglDisplay, ((h)localObject1).eglSurface, ((h)localObject1).eglSurface, ((h)localObject1).hrF)) {
            ae.w("MicroMsg.YUVDateRenderToRBGBufferThread", "eglMakeCurrent:" + EGL14.eglGetError());
          }
          localObject1 = h.this;
          i = h.this.jyt;
          j = h.this.jyu;
          ((h)localObject1).jyr = new i(i, j);
          ((h)localObject1).jyr.onSurfaceCreated(null, null);
          ((h)localObject1).jyr.onSurfaceChanged(null, i, j);
          if (((h)localObject1).jys != null) {
            ((h)localObject1).jyr.buffer = ((h)localObject1).jys.getBuffer();
          }
          AppMethodBeat.o(89270);
          return;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          for (;;)
          {
            ae.e("MicroMsg.YUVDateRenderToRBGBufferThread", "eglCreateWindowSurface", new Object[] { localIllegalArgumentException });
          }
        }
      }
    });
    AppMethodBeat.o(89274);
  }
  
  public final void i(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(89276);
    ae.i("MicroMsg.YUVDateRenderToRBGBufferThread", "setFrameInfo, width: %s, height: %s, rotate: %s ,targetWidth:%d ,targetHeight:%d , this: %s ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), this });
    if ((paramInt1 != this.jxn) || (paramInt2 != this.jxo) || (paramInt3 != this.hwV))
    {
      this.jxn = paramInt1;
      this.jxo = paramInt2;
      this.hwV = paramInt3;
    }
    this.jyt = paramInt4;
    this.jyu = paramInt5;
    AppMethodBeat.o(89276);
  }
  
  public final void release()
  {
    AppMethodBeat.i(89278);
    H(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(89272);
        Object localObject = h.this.jyr;
        if (((i)localObject).jyy != 0) {
          GLES20.glDeleteTextures(1, new int[] { ((i)localObject).jyy }, 0);
        }
        if (((i)localObject).jyz != 0) {
          GLES20.glDeleteFramebuffers(1, new int[] { ((i)localObject).jyz }, 0);
        }
        localObject = h.this.eglDisplay;
        EGLSurface localEGLSurface = EGL14.EGL_NO_SURFACE;
        EGL14.eglMakeCurrent((EGLDisplay)localObject, localEGLSurface, localEGLSurface, EGL14.EGL_NO_CONTEXT);
        if ((h.this.eglSurface != null) && (h.this.hrF != null) && (h.this.eglDisplay != null))
        {
          EGL14.eglDestroySurface(h.this.eglDisplay, h.this.eglSurface);
          EGL14.eglDestroyContext(h.this.eglDisplay, h.this.hrF);
          EGL14.eglReleaseThread();
          EGL14.eglTerminate(h.this.eglDisplay);
          h.this.hrF = null;
          h.this.eglDisplay = null;
          h.this.eglSurface = null;
        }
        h.this.hnH.removeCallbacksAndMessages(null);
        h.this.hnG.quitSafely();
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