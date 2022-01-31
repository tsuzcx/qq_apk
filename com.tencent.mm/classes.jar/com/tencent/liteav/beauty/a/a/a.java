package com.tencent.liteav.beauty.a.a;

import com.tencent.liteav.basic.log.TXCLog;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGL11;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class a
{
  private EGL10 a = (EGL10)EGLContext.getEGL();
  private final EGLContext b;
  private EGLDisplay c = this.a.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
  private EGLConfig d;
  private EGLSurface e;
  
  public a()
  {
    this(null);
  }
  
  public a(EGLConfig paramEGLConfig)
  {
    if (this.c == EGL10.EGL_NO_DISPLAY) {
      throw new RuntimeException("unable to get EGL10 display");
    }
    int[] arrayOfInt = new int[2];
    if (!this.a.eglInitialize(this.c, arrayOfInt))
    {
      this.c = null;
      throw new RuntimeException("unable to initialize EGL10");
    }
    if (paramEGLConfig != null) {}
    for (this.d = paramEGLConfig;; this.d = b())
    {
      this.b = this.a.eglCreateContext(this.c, this.d, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
      return;
    }
  }
  
  private void a(String paramString)
  {
    int i = this.a.eglGetError();
    if (i != 12288) {
      throw new RuntimeException(paramString + ": EGL error: 0x" + Integer.toHexString(i));
    }
  }
  
  private EGLConfig b()
  {
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
    int[] arrayOfInt = new int[1];
    if (!this.a.eglChooseConfig(this.c, new int[] { 12339, 1, 12325, 16, 12326, 0, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344 }, arrayOfEGLConfig, 1, arrayOfInt))
    {
      TXCLog.w("ImageEglSurface", "unable to find RGB8888  EGLConfig");
      return null;
    }
    return arrayOfEGLConfig[0];
  }
  
  public EGLSurface a(int paramInt1, int paramInt2)
  {
    this.e = this.a.eglCreatePbufferSurface(this.c, this.d, new int[] { 12375, paramInt1, 12374, paramInt2, 12344 });
    a("eglCreatePbufferSurface");
    if (this.e == null) {
      throw new RuntimeException("surface was null");
    }
    return this.e;
  }
  
  public void a()
  {
    this.a.eglMakeCurrent(this.c, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
    this.a.eglDestroyContext(this.c, this.b);
    this.a.eglTerminate(this.c);
  }
  
  public void a(EGLSurface paramEGLSurface)
  {
    this.a.eglDestroySurface(this.c, paramEGLSurface);
  }
  
  public void b(EGLSurface paramEGLSurface)
  {
    EGLDisplay localEGLDisplay = this.c;
    if (localEGLDisplay == EGL11.EGL_NO_DISPLAY) {
      TXCLog.d("EglCore", "NOTE: makeCurrent w/o display");
    }
    if (!this.a.eglMakeCurrent(localEGLDisplay, paramEGLSurface, paramEGLSurface, this.b)) {
      throw new RuntimeException("eglMakeCurrent failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.liteav.beauty.a.a.a
 * JD-Core Version:    0.7.0.1
 */