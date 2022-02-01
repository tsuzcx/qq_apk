package com.tencent.liteav.basic.d;

import android.view.Surface;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class b
{
  public static final String a;
  private static int[] l;
  private static int[] m;
  private EGL10 b;
  private EGLDisplay c;
  private EGLConfig d;
  private boolean e;
  private EGLContext f;
  private boolean g;
  private EGLSurface h;
  private int i;
  private int j;
  private int[] k;
  
  static
  {
    AppMethodBeat.i(14560);
    a = b.class.getSimpleName();
    l = new int[] { 12339, 1, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12352, 4, 12344 };
    m = new int[] { 12339, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12352, 4, 12610, 1, 12344 };
    AppMethodBeat.o(14560);
  }
  
  private b()
  {
    AppMethodBeat.i(14554);
    this.i = 0;
    this.j = 0;
    this.k = new int[2];
    AppMethodBeat.o(14554);
  }
  
  public static b a(EGLConfig paramEGLConfig, EGLContext paramEGLContext, Surface paramSurface, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(14555);
    b localb = new b();
    localb.i = paramInt1;
    localb.j = paramInt2;
    if (localb.a(paramEGLConfig, paramEGLContext, paramSurface))
    {
      AppMethodBeat.o(14555);
      return localb;
    }
    AppMethodBeat.o(14555);
    return null;
  }
  
  private boolean a(EGLConfig paramEGLConfig, EGLContext paramEGLContext, Surface paramSurface)
  {
    AppMethodBeat.i(14558);
    this.b = ((EGL10)EGLContext.getEGL());
    this.c = this.b.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    this.b.eglInitialize(this.c, this.k);
    if (paramEGLConfig == null)
    {
      int[] arrayOfInt = new int[1];
      EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
      EGL10 localEGL10 = this.b;
      EGLDisplay localEGLDisplay = this.c;
      if (paramSurface == null)
      {
        paramEGLConfig = l;
        localEGL10.eglChooseConfig(localEGLDisplay, paramEGLConfig, arrayOfEGLConfig, 1, arrayOfInt);
        this.d = arrayOfEGLConfig[0];
        this.e = true;
        label114:
        paramEGLConfig = new int[3];
        EGLConfig tmp119_118 = paramEGLConfig;
        tmp119_118[0] = 12440;
        EGLConfig tmp125_119 = tmp119_118;
        tmp125_119[1] = 2;
        EGLConfig tmp129_125 = tmp125_119;
        tmp129_125[2] = 12344;
        tmp129_125;
        if (paramEGLContext != null) {
          break label202;
        }
        this.f = this.b.eglCreateContext(this.c, this.d, EGL10.EGL_NO_CONTEXT, paramEGLConfig);
      }
    }
    for (;;)
    {
      if (this.f != EGL10.EGL_NO_CONTEXT) {
        break label233;
      }
      e();
      AppMethodBeat.o(14558);
      return false;
      paramEGLConfig = m;
      break;
      this.d = paramEGLConfig;
      break label114;
      label202:
      this.f = this.b.eglCreateContext(this.c, this.d, paramEGLContext, paramEGLConfig);
      this.g = true;
    }
    label233:
    int n = this.i;
    int i1 = this.j;
    if (paramSurface == null) {}
    for (this.h = this.b.eglCreatePbufferSurface(this.c, this.d, new int[] { 12375, n, 12374, i1, 12344 }); this.h == EGL10.EGL_NO_SURFACE; this.h = this.b.eglCreateWindowSurface(this.c, this.d, paramSurface, null))
    {
      e();
      AppMethodBeat.o(14558);
      return false;
    }
    if (!this.b.eglMakeCurrent(this.c, this.h, this.h, this.f))
    {
      e();
      AppMethodBeat.o(14558);
      return false;
    }
    AppMethodBeat.o(14558);
    return true;
  }
  
  public boolean a()
  {
    AppMethodBeat.i(14556);
    boolean bool = this.b.eglSwapBuffers(this.c, this.h);
    e();
    AppMethodBeat.o(14556);
    return bool;
  }
  
  public void b()
  {
    AppMethodBeat.i(14557);
    this.b.eglMakeCurrent(this.c, this.h, this.h, this.f);
    e();
    AppMethodBeat.o(14557);
  }
  
  public void c()
  {
    AppMethodBeat.i(182428);
    EGL10 localEGL10 = this.b;
    EGLDisplay localEGLDisplay = this.c;
    EGLSurface localEGLSurface = EGL10.EGL_NO_SURFACE;
    localEGL10.eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, EGL10.EGL_NO_CONTEXT);
    if (this.h != null) {
      this.b.eglDestroySurface(this.c, this.h);
    }
    if (this.f != null) {
      this.b.eglDestroyContext(this.c, this.f);
    }
    this.b.eglTerminate(this.c);
    e();
    this.c = null;
    this.h = null;
    this.c = null;
    AppMethodBeat.o(182428);
  }
  
  public EGLContext d()
  {
    return this.f;
  }
  
  public void e()
  {
    AppMethodBeat.i(182429);
    int n = this.b.eglGetError();
    if (n != 12288) {
      TXCLog.e(a, "EGL error: 0x" + Integer.toHexString(n));
    }
    AppMethodBeat.o(182429);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.d.b
 * JD-Core Version:    0.7.0.1
 */