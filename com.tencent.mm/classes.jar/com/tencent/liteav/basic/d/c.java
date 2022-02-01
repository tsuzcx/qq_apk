package com.tencent.liteav.basic.d;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.view.Surface;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

@TargetApi(17)
public class c
{
  private static int a;
  private static final String b;
  private static int[] k;
  private static int[] l;
  private EGLDisplay c = EGL14.EGL_NO_DISPLAY;
  private EGLContext d = EGL14.EGL_NO_CONTEXT;
  private EGLConfig e = null;
  private int f = 0;
  private int g = 0;
  private boolean h;
  private EGLSurface i;
  private int j = -1;
  
  static
  {
    int n = 4;
    AppMethodBeat.i(14593);
    a = 2;
    b = c.class.getSimpleName();
    if (a == 2)
    {
      m = 4;
      k = new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12352, m, 12610, 1, 12344 };
      if (a != 2) {
        break label279;
      }
    }
    label279:
    for (int m = n;; m = 68)
    {
      l = new int[] { 12339, 1, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12352, m, 12610, 1, 12344 };
      AppMethodBeat.o(14593);
      return;
      m = 68;
      break;
    }
  }
  
  private static EGLContext a(EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt, EGLContext paramEGLContext)
  {
    AppMethodBeat.i(193126);
    paramEGLDisplay = EGL14.eglCreateContext(paramEGLDisplay, paramEGLConfig, paramEGLContext, new int[] { 12440, paramInt, 12344 }, 0);
    e();
    AppMethodBeat.o(193126);
    return paramEGLDisplay;
  }
  
  public static c a(EGLConfig paramEGLConfig, EGLContext paramEGLContext, Surface paramSurface, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(14587);
    c localc = new c();
    localc.f = paramInt1;
    localc.g = paramInt2;
    if (localc.a(paramEGLConfig, paramEGLContext, paramSurface))
    {
      AppMethodBeat.o(14587);
      return localc;
    }
    AppMethodBeat.o(14587);
    return null;
  }
  
  private boolean a(EGLConfig paramEGLConfig, EGLContext paramEGLContext, Surface paramSurface)
  {
    AppMethodBeat.i(14591);
    this.c = EGL14.eglGetDisplay(0);
    if (this.c == EGL14.EGL_NO_DISPLAY) {
      TXCLog.e(b, "unable to get EGL14 display");
    }
    Object localObject = new int[2];
    if (!EGL14.eglInitialize(this.c, (int[])localObject, 0, (int[])localObject, 1))
    {
      this.c = null;
      TXCLog.e(b, "unable to initialize EGL14");
    }
    if (paramEGLConfig != null) {
      this.e = paramEGLConfig;
    }
    for (;;)
    {
      if (paramEGLContext != null) {
        this.h = true;
      }
      try
      {
        for (;;)
        {
          this.d = a(this.c, this.e, 2, paramEGLContext);
          if (paramSurface != null) {
            break label330;
          }
          int m = this.f;
          int n = this.g;
          this.i = EGL14.eglCreatePbufferSurface(this.c, this.e, new int[] { 12375, m, 12374, n, 12344 }, 0);
          a();
          if (EGL14.eglMakeCurrent(this.c, this.i, this.i, this.d)) {
            break label359;
          }
          a();
          AppMethodBeat.o(14591);
          return false;
          localObject = new EGLConfig[1];
          int[] arrayOfInt = new int[1];
          EGLDisplay localEGLDisplay = this.c;
          if (paramSurface == null) {}
          for (paramEGLConfig = l; !EGL14.eglChooseConfig(localEGLDisplay, paramEGLConfig, 0, (EGLConfig[])localObject, 0, 1, arrayOfInt, 0); paramEGLConfig = k)
          {
            AppMethodBeat.o(14591);
            return false;
          }
          this.e = localObject[0];
          break;
          paramEGLContext = EGL14.EGL_NO_CONTEXT;
        }
      }
      catch (d paramEGLConfig)
      {
        for (;;)
        {
          TXCLog.i(b, "failed to create EGLContext of OpenGL ES 2.0, try 3.0");
          try
          {
            this.d = a(this.c, this.e, 3, paramEGLContext);
          }
          catch (d paramEGLConfig)
          {
            TXCLog.e(b, "failed to create EGLContext of 3.0. ".concat(String.valueOf(paramEGLConfig)));
            AppMethodBeat.o(14591);
            return false;
          }
          label330:
          this.i = EGL14.eglCreateWindowSurface(this.c, this.e, paramSurface, new int[] { 12344 }, 0);
        }
        label359:
        AppMethodBeat.o(14591);
      }
    }
    return true;
  }
  
  private static void e()
  {
    AppMethodBeat.i(193127);
    int m = EGL14.eglGetError();
    if (m != 12288)
    {
      d locald = new d(m);
      AppMethodBeat.o(193127);
      throw locald;
    }
    AppMethodBeat.o(193127);
  }
  
  public void a()
  {
    AppMethodBeat.i(14588);
    int m = EGL14.eglGetError();
    if (m != 12288) {
      TXCLog.e(b, "EGL error:".concat(String.valueOf(m)));
    }
    AppMethodBeat.o(14588);
  }
  
  public void a(long paramLong)
  {
    AppMethodBeat.i(14592);
    EGLExt.eglPresentationTimeANDROID(this.c, this.i, paramLong);
    AppMethodBeat.o(14592);
  }
  
  public void b()
  {
    AppMethodBeat.i(14589);
    EGLDisplay localEGLDisplay = EGL14.EGL_NO_DISPLAY;
    if (!EGL14.eglMakeCurrent(this.c, this.i, this.i, this.d)) {
      TXCLog.e(b, "eglMakeCurrent failed");
    }
    AppMethodBeat.o(14589);
  }
  
  public void c()
  {
    AppMethodBeat.i(182426);
    if (this.c != EGL14.EGL_NO_DISPLAY)
    {
      EGLDisplay localEGLDisplay = this.c;
      EGLSurface localEGLSurface = EGL14.EGL_NO_SURFACE;
      EGL14.eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, EGL14.EGL_NO_CONTEXT);
      EGL14.eglDestroySurface(this.c, this.i);
      EGL14.eglDestroyContext(this.c, this.d);
      this.d = EGL14.EGL_NO_CONTEXT;
      EGL14.eglReleaseThread();
      EGL14.eglTerminate(this.c);
    }
    this.c = EGL14.EGL_NO_DISPLAY;
    AppMethodBeat.o(182426);
  }
  
  public boolean d()
  {
    AppMethodBeat.i(182427);
    boolean bool = EGL14.eglSwapBuffers(this.c, this.i);
    AppMethodBeat.o(182427);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.d.c
 * JD-Core Version:    0.7.0.1
 */