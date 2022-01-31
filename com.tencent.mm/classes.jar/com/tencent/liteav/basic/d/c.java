package com.tencent.liteav.basic.d;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.view.Surface;
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
    AppMethodBeat.i(146525);
    a = 2;
    b = c.class.getSimpleName();
    if (a == 2)
    {
      m = 4;
      k = new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12352, m, 12610, 1, 12344 };
      if (a != 2) {
        break label277;
      }
    }
    label277:
    for (int m = n;; m = 68)
    {
      l = new int[] { 12339, 1, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12352, m, 12610, 1, 12344 };
      AppMethodBeat.o(146525);
      return;
      m = 68;
      break;
    }
  }
  
  public static c a(EGLConfig paramEGLConfig, EGLContext paramEGLContext, Surface paramSurface, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(146519);
    c localc = new c();
    localc.f = paramInt1;
    localc.g = paramInt2;
    if (localc.a(paramEGLConfig, paramEGLContext, paramSurface))
    {
      AppMethodBeat.o(146519);
      return localc;
    }
    AppMethodBeat.o(146519);
    return null;
  }
  
  private boolean a(EGLConfig paramEGLConfig, EGLContext paramEGLContext, Surface paramSurface)
  {
    AppMethodBeat.i(146523);
    this.c = EGL14.eglGetDisplay(0);
    if (this.c == EGL14.EGL_NO_DISPLAY)
    {
      paramEGLConfig = new RuntimeException("unable to get EGL14 display");
      AppMethodBeat.o(146523);
      throw paramEGLConfig;
    }
    Object localObject = new int[2];
    if (!EGL14.eglInitialize(this.c, (int[])localObject, 0, (int[])localObject, 1))
    {
      this.c = null;
      paramEGLConfig = new RuntimeException("unable to initialize EGL14");
      AppMethodBeat.o(146523);
      throw paramEGLConfig;
    }
    if (paramEGLConfig != null)
    {
      this.e = paramEGLConfig;
      if (paramEGLContext == null) {
        break label231;
      }
      this.h = true;
    }
    int m;
    for (;;)
    {
      m = a;
      this.d = EGL14.eglCreateContext(this.c, this.e, paramEGLContext, new int[] { 12440, m, 12344 }, 0);
      if (this.d != EGL14.EGL_NO_CONTEXT) {
        break label238;
      }
      a();
      AppMethodBeat.o(146523);
      return false;
      localObject = new EGLConfig[1];
      int[] arrayOfInt = new int[1];
      EGLDisplay localEGLDisplay = this.c;
      if (paramSurface == null) {}
      for (paramEGLConfig = l; !EGL14.eglChooseConfig(localEGLDisplay, paramEGLConfig, 0, (EGLConfig[])localObject, 0, 1, arrayOfInt, 0); paramEGLConfig = k)
      {
        AppMethodBeat.o(146523);
        return false;
      }
      this.e = localObject[0];
      break;
      label231:
      paramEGLContext = EGL14.EGL_NO_CONTEXT;
    }
    label238:
    int n;
    if (paramSurface == null)
    {
      m = this.f;
      n = this.g;
    }
    for (this.i = EGL14.eglCreatePbufferSurface(this.c, this.e, new int[] { 12375, m, 12374, n, 12344 }, 0);; this.i = EGL14.eglCreateWindowSurface(this.c, this.e, paramSurface, new int[] { 12344 }, 0))
    {
      a();
      if (EGL14.eglMakeCurrent(this.c, this.i, this.i, this.d)) {
        break;
      }
      a();
      AppMethodBeat.o(146523);
      return false;
    }
    AppMethodBeat.o(146523);
    return true;
  }
  
  public void a()
  {
    AppMethodBeat.i(146520);
    int m = EGL14.eglGetError();
    if (m != 12288)
    {
      RuntimeException localRuntimeException = new RuntimeException(": EGL error: 0x" + Integer.toHexString(m));
      AppMethodBeat.o(146520);
      throw localRuntimeException;
    }
    AppMethodBeat.o(146520);
  }
  
  public void a(long paramLong)
  {
    AppMethodBeat.i(146524);
    EGLExt.eglPresentationTimeANDROID(this.c, this.i, paramLong);
    AppMethodBeat.o(146524);
  }
  
  public void b()
  {
    AppMethodBeat.i(146521);
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
    AppMethodBeat.o(146521);
  }
  
  public boolean c()
  {
    AppMethodBeat.i(146522);
    boolean bool = EGL14.eglSwapBuffers(this.c, this.i);
    AppMethodBeat.o(146522);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.basic.d.c
 * JD-Core Version:    0.7.0.1
 */