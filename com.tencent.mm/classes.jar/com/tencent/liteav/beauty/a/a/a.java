package com.tencent.liteav.beauty.a.a;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGL11;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class a
{
  private EGL10 a;
  private final EGLContext b;
  private EGLDisplay c;
  private EGLConfig d;
  private EGLSurface e;
  
  public a()
  {
    this(null);
  }
  
  public a(EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(66834);
    this.a = ((EGL10)EGLContext.getEGL());
    this.c = this.a.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    if (this.c == EGL10.EGL_NO_DISPLAY)
    {
      paramEGLConfig = new RuntimeException("unable to get EGL10 display");
      AppMethodBeat.o(66834);
      throw paramEGLConfig;
    }
    int[] arrayOfInt = new int[2];
    if (!this.a.eglInitialize(this.c, arrayOfInt))
    {
      this.c = null;
      paramEGLConfig = new RuntimeException("unable to initialize EGL10");
      AppMethodBeat.o(66834);
      throw paramEGLConfig;
    }
    if (paramEGLConfig != null) {}
    for (this.d = paramEGLConfig;; this.d = b())
    {
      this.b = this.a.eglCreateContext(this.c, this.d, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
      AppMethodBeat.o(66834);
      return;
    }
  }
  
  private void a(String paramString)
  {
    AppMethodBeat.i(66840);
    int i = this.a.eglGetError();
    if (i != 12288)
    {
      paramString = new RuntimeException(paramString + ": EGL error: 0x" + Integer.toHexString(i));
      AppMethodBeat.o(66840);
      throw paramString;
    }
    AppMethodBeat.o(66840);
  }
  
  private EGLConfig b()
  {
    AppMethodBeat.i(66835);
    Object localObject = new EGLConfig[1];
    int[] arrayOfInt = new int[1];
    if (!this.a.eglChooseConfig(this.c, new int[] { 12339, 1, 12325, 16, 12326, 0, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344 }, (EGLConfig[])localObject, 1, arrayOfInt))
    {
      TXCLog.w("ImageEglSurface", "unable to find RGB8888  EGLConfig");
      AppMethodBeat.o(66835);
      return null;
    }
    localObject = localObject[0];
    AppMethodBeat.o(66835);
    return localObject;
  }
  
  public EGLSurface a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66838);
    this.e = this.a.eglCreatePbufferSurface(this.c, this.d, new int[] { 12375, paramInt1, 12374, paramInt2, 12344 });
    a("eglCreatePbufferSurface");
    if (this.e == null)
    {
      localObject = new RuntimeException("surface was null");
      AppMethodBeat.o(66838);
      throw ((Throwable)localObject);
    }
    Object localObject = this.e;
    AppMethodBeat.o(66838);
    return localObject;
  }
  
  public void a()
  {
    AppMethodBeat.i(66836);
    EGL10 localEGL10 = this.a;
    EGLDisplay localEGLDisplay = this.c;
    EGLSurface localEGLSurface = EGL10.EGL_NO_SURFACE;
    localEGL10.eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, EGL10.EGL_NO_CONTEXT);
    this.a.eglDestroyContext(this.c, this.b);
    this.a.eglTerminate(this.c);
    AppMethodBeat.o(66836);
  }
  
  public void a(EGLSurface paramEGLSurface)
  {
    AppMethodBeat.i(66837);
    this.a.eglDestroySurface(this.c, paramEGLSurface);
    AppMethodBeat.o(66837);
  }
  
  public void b(EGLSurface paramEGLSurface)
  {
    AppMethodBeat.i(66839);
    EGLDisplay localEGLDisplay = this.c;
    if (localEGLDisplay == EGL11.EGL_NO_DISPLAY) {
      TXCLog.d("EglCore", "NOTE: makeCurrent w/o display");
    }
    if (!this.a.eglMakeCurrent(localEGLDisplay, paramEGLSurface, paramEGLSurface, this.b))
    {
      paramEGLSurface = new RuntimeException("eglMakeCurrent failed");
      AppMethodBeat.o(66839);
      throw paramEGLSurface;
    }
    AppMethodBeat.o(66839);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.liteav.beauty.a.a.a
 * JD-Core Version:    0.7.0.1
 */