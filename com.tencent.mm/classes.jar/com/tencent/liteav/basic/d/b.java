package com.tencent.liteav.basic.d;

import android.view.Surface;
import com.tencent.liteav.basic.log.TXCLog;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class b
{
  public static final String a = b.class.getSimpleName();
  private static int[] l = { 12339, 1, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12352, 4, 12344 };
  private static int[] m = { 12339, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12352, 4, 12610, 1, 12344 };
  private EGL10 b;
  private EGLDisplay c;
  private EGLConfig d;
  private boolean e;
  private EGLContext f;
  private boolean g;
  private EGLSurface h;
  private int i = 0;
  private int j = 0;
  private int[] k = new int[2];
  
  public static b a(EGLConfig paramEGLConfig, EGLContext paramEGLContext, Surface paramSurface, int paramInt1, int paramInt2)
  {
    b localb = new b();
    localb.i = paramInt1;
    localb.j = paramInt2;
    if (localb.a(paramEGLConfig, paramEGLContext, paramSurface)) {
      return localb;
    }
    return null;
  }
  
  private boolean a(EGLConfig paramEGLConfig, EGLContext paramEGLContext, Surface paramSurface)
  {
    boolean bool = true;
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
        label111:
        paramEGLConfig = new int[3];
        EGLConfig tmp116_115 = paramEGLConfig;
        tmp116_115[0] = 12440;
        EGLConfig tmp122_116 = tmp116_115;
        tmp122_116[1] = 2;
        EGLConfig tmp126_122 = tmp122_116;
        tmp126_122[2] = 12344;
        tmp126_122;
        if (paramEGLContext != null) {
          break label197;
        }
        this.f = this.b.eglCreateContext(this.c, this.d, EGL10.EGL_NO_CONTEXT, paramEGLConfig);
        label162:
        if (this.f != EGL10.EGL_NO_CONTEXT) {
          break label228;
        }
        d();
        bool = false;
      }
    }
    label197:
    label228:
    do
    {
      return bool;
      paramEGLConfig = m;
      break;
      this.d = paramEGLConfig;
      break label111;
      this.f = this.b.eglCreateContext(this.c, this.d, paramEGLContext, paramEGLConfig);
      this.g = true;
      break label162;
      int n = this.i;
      int i1 = this.j;
      if (paramSurface == null) {}
      for (this.h = this.b.eglCreatePbufferSurface(this.c, this.d, new int[] { 12375, n, 12374, i1, 12344 }); this.h == EGL10.EGL_NO_SURFACE; this.h = this.b.eglCreateWindowSurface(this.c, this.d, paramSurface, null))
      {
        d();
        return false;
      }
    } while (this.b.eglMakeCurrent(this.c, this.h, this.h, this.f));
    d();
    return false;
  }
  
  public boolean a()
  {
    boolean bool = this.b.eglSwapBuffers(this.c, this.h);
    d();
    return bool;
  }
  
  public void b()
  {
    this.b.eglMakeCurrent(this.c, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
    if (this.h != null) {
      this.b.eglDestroySurface(this.c, this.h);
    }
    if (this.f != null) {
      this.b.eglDestroyContext(this.c, this.f);
    }
    this.b.eglTerminate(this.c);
    d();
    this.c = null;
    this.h = null;
    this.c = null;
  }
  
  public EGLContext c()
  {
    return this.f;
  }
  
  public void d()
  {
    int n = this.b.eglGetError();
    if (n != 12288) {
      TXCLog.e(a, "EGL error: 0x" + Integer.toHexString(n));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.liteav.basic.d.b
 * JD-Core Version:    0.7.0.1
 */