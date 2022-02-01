package com.tencent.liteav.basic.opengl;

import android.view.Surface;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.e;
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
    AppMethodBeat.i(230244);
    a = b.class.getSimpleName();
    l = new int[] { 12339, 1, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12352, 4, 12344 };
    m = new int[] { 12339, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12352, 4, 12610, 1, 12344 };
    AppMethodBeat.o(230244);
  }
  
  private b()
  {
    AppMethodBeat.i(230206);
    this.i = 0;
    this.j = 0;
    this.k = new int[2];
    AppMethodBeat.o(230206);
  }
  
  public static b a(EGLConfig paramEGLConfig, EGLContext paramEGLContext, Surface paramSurface, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(230213);
    b localb = new b();
    localb.i = paramInt1;
    localb.j = paramInt2;
    if (localb.a(paramEGLConfig, paramEGLContext, paramSurface))
    {
      AppMethodBeat.o(230213);
      return localb;
    }
    AppMethodBeat.o(230213);
    return null;
  }
  
  private EGLContext a(EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt, EGLContext paramEGLContext)
  {
    AppMethodBeat.i(230235);
    EGLContext localEGLContext = paramEGLContext;
    if (paramEGLContext == null) {
      localEGLContext = EGL10.EGL_NO_CONTEXT;
    }
    paramEGLDisplay = this.b.eglCreateContext(paramEGLDisplay, paramEGLConfig, localEGLContext, new int[] { 12440, paramInt, 12344 });
    g();
    AppMethodBeat.o(230235);
    return paramEGLDisplay;
  }
  
  private boolean a(EGLConfig paramEGLConfig, EGLContext paramEGLContext, Surface paramSurface)
  {
    AppMethodBeat.i(230225);
    this.b = ((EGL10)EGLContext.getEGL());
    this.c = this.b.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    this.b.eglInitialize(this.c, this.k);
    int[] arrayOfInt;
    EGLConfig[] arrayOfEGLConfig;
    EGL10 localEGL10;
    EGLDisplay localEGLDisplay;
    if (paramEGLConfig == null)
    {
      arrayOfInt = new int[1];
      arrayOfEGLConfig = new EGLConfig[1];
      localEGL10 = this.b;
      localEGLDisplay = this.c;
      if (paramSurface == null) {
        paramEGLConfig = l;
      }
    }
    for (;;)
    {
      localEGL10.eglChooseConfig(localEGLDisplay, paramEGLConfig, arrayOfEGLConfig, 1, arrayOfInt);
      this.d = arrayOfEGLConfig[0];
      this.e = true;
      if (paramEGLContext != null) {
        this.g = true;
      }
      try
      {
        this.f = a(this.c, this.d, 2, paramEGLContext);
        int n = this.i;
        int i1 = this.j;
        if (paramSurface == null)
        {
          this.h = this.b.eglCreatePbufferSurface(this.c, this.d, new int[] { 12375, n, 12374, i1, 12344 });
          if (this.h != EGL10.EGL_NO_SURFACE) {
            break label323;
          }
          e();
          AppMethodBeat.o(230225);
          return false;
          paramEGLConfig = m;
          continue;
          this.d = paramEGLConfig;
        }
      }
      catch (d paramEGLConfig)
      {
        for (;;)
        {
          TXCLog.i(a, "failed to create EGLContext of OpenGL ES 2.0, try 3.0");
          try
          {
            this.f = a(this.c, this.d, 3, paramEGLContext);
          }
          catch (d paramEGLConfig)
          {
            TXCLog.e(a, "failed to create EGLContext of 3.0. ".concat(String.valueOf(paramEGLConfig)));
            AppMethodBeat.o(230225);
            return false;
          }
          this.h = this.b.eglCreateWindowSurface(this.c, this.d, paramSurface, null);
        }
        label323:
        if (!this.b.eglMakeCurrent(this.c, this.h, this.h, this.f))
        {
          e();
          AppMethodBeat.o(230225);
          return false;
        }
        AppMethodBeat.o(230225);
      }
    }
    return true;
  }
  
  private void g()
  {
    AppMethodBeat.i(230239);
    int n = this.b.eglGetError();
    if (n != 12288)
    {
      d locald = new d(n);
      AppMethodBeat.o(230239);
      throw locald;
    }
    AppMethodBeat.o(230239);
  }
  
  public boolean a()
  {
    AppMethodBeat.i(230251);
    boolean bool = this.b.eglSwapBuffers(this.c, this.h);
    e();
    AppMethodBeat.o(230251);
    return bool;
  }
  
  public void b()
  {
    AppMethodBeat.i(230256);
    this.b.eglMakeCurrent(this.c, this.h, this.h, this.f);
    e();
    AppMethodBeat.o(230256);
  }
  
  public void c()
  {
    AppMethodBeat.i(230264);
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
    AppMethodBeat.o(230264);
  }
  
  public EGLContext d()
  {
    return this.f;
  }
  
  public void e()
  {
    AppMethodBeat.i(230279);
    int n = this.b.eglGetError();
    if (n != 12288) {
      TXCLog.e(a, "EGL error: 0x" + Integer.toHexString(n));
    }
    AppMethodBeat.o(230279);
  }
  
  public e f()
  {
    AppMethodBeat.i(230288);
    Object localObject = new int[1];
    int[] arrayOfInt = new int[1];
    boolean bool1 = this.b.eglQuerySurface(this.c, this.h, 12375, (int[])localObject);
    boolean bool2 = this.b.eglQuerySurface(this.c, this.h, 12374, arrayOfInt);
    if ((bool1) && (bool2))
    {
      localObject = new e(localObject[0], arrayOfInt[0]);
      AppMethodBeat.o(230288);
      return localObject;
    }
    localObject = new e(0, 0);
    AppMethodBeat.o(230288);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.basic.opengl.b
 * JD-Core Version:    0.7.0.1
 */