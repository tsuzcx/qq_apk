package com.tencent.liteav.basic.d;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.view.Surface;

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
    a = 2;
    b = c.class.getSimpleName();
    if (a == 2)
    {
      m = 4;
      k = new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12352, m, 12610, 1, 12344 };
      if (a != 2) {
        break label267;
      }
    }
    label267:
    for (int m = n;; m = 68)
    {
      l = new int[] { 12339, 1, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12352, m, 12610, 1, 12344 };
      return;
      m = 68;
      break;
    }
  }
  
  public static c a(EGLConfig paramEGLConfig, EGLContext paramEGLContext, Surface paramSurface, int paramInt1, int paramInt2)
  {
    c localc = new c();
    localc.f = paramInt1;
    localc.g = paramInt2;
    if (localc.a(paramEGLConfig, paramEGLContext, paramSurface)) {
      return localc;
    }
    return null;
  }
  
  private boolean a(EGLConfig paramEGLConfig, EGLContext paramEGLContext, Surface paramSurface)
  {
    this.c = EGL14.eglGetDisplay(0);
    if (this.c == EGL14.EGL_NO_DISPLAY) {
      throw new RuntimeException("unable to get EGL14 display");
    }
    Object localObject = new int[2];
    if (!EGL14.eglInitialize(this.c, (int[])localObject, 0, (int[])localObject, 1))
    {
      this.c = null;
      throw new RuntimeException("unable to initialize EGL14");
    }
    if (paramEGLConfig != null)
    {
      this.e = paramEGLConfig;
      if (paramEGLContext == null) {
        break label200;
      }
      this.h = true;
    }
    int m;
    for (;;)
    {
      m = a;
      this.d = EGL14.eglCreateContext(this.c, this.e, paramEGLContext, new int[] { 12440, m, 12344 }, 0);
      if (this.d != EGL14.EGL_NO_CONTEXT) {
        break label207;
      }
      a();
      label198:
      for (;;)
      {
        return false;
        localObject = new EGLConfig[1];
        int[] arrayOfInt = new int[1];
        EGLDisplay localEGLDisplay = this.c;
        if (paramSurface == null) {}
        for (paramEGLConfig = l;; paramEGLConfig = k)
        {
          if (!EGL14.eglChooseConfig(localEGLDisplay, paramEGLConfig, 0, (EGLConfig[])localObject, 0, 1, arrayOfInt, 0)) {
            break label198;
          }
          this.e = localObject[0];
          break;
        }
      }
      label200:
      paramEGLContext = EGL14.EGL_NO_CONTEXT;
    }
    label207:
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
      return false;
    }
    return true;
  }
  
  public void a()
  {
    int m = EGL14.eglGetError();
    if (m != 12288) {
      throw new RuntimeException(": EGL error: 0x" + Integer.toHexString(m));
    }
  }
  
  public void a(long paramLong)
  {
    EGLExt.eglPresentationTimeANDROID(this.c, this.i, paramLong);
  }
  
  public void b()
  {
    if (this.c != EGL14.EGL_NO_DISPLAY)
    {
      EGL14.eglMakeCurrent(this.c, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
      EGL14.eglDestroySurface(this.c, this.i);
      EGL14.eglDestroyContext(this.c, this.d);
      this.d = EGL14.EGL_NO_CONTEXT;
      EGL14.eglReleaseThread();
      EGL14.eglTerminate(this.c);
    }
    this.c = EGL14.EGL_NO_DISPLAY;
  }
  
  public boolean c()
  {
    return EGL14.eglSwapBuffers(this.c, this.i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.basic.d.c
 * JD-Core Version:    0.7.0.1
 */