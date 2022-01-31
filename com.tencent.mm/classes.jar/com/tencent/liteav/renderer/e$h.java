package com.tencent.liteav.renderer;

import android.opengl.GLDebugHelper;
import com.tencent.liteav.basic.log.TXCLog;
import java.io.Writer;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;

public class e$h
{
  EGL10 a;
  EGLDisplay b;
  EGLSurface c;
  EGLConfig d;
  EGLContext e;
  private WeakReference<e> f;
  
  public e$h(WeakReference<e> paramWeakReference)
  {
    this.f = paramWeakReference;
  }
  
  private void a(String paramString)
  {
    a(paramString, this.a.eglGetError());
  }
  
  public static void a(String paramString, int paramInt)
  {
    throw new RuntimeException(b(paramString, paramInt));
  }
  
  public static void a(String paramString1, String paramString2, int paramInt)
  {
    TXCLog.w(paramString1, b(paramString2, paramInt));
  }
  
  public static String b(String paramString, int paramInt)
  {
    return paramString + " failed: " + paramInt;
  }
  
  private void h()
  {
    if ((this.c != null) && (this.c != EGL10.EGL_NO_SURFACE))
    {
      this.a.eglMakeCurrent(this.b, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
      e locale = (e)this.f.get();
      if (locale != null)
      {
        e.e(locale).a(this.a, this.b, this.c);
        locale.g = false;
      }
      this.c = null;
    }
  }
  
  public void a()
  {
    this.a = ((EGL10)EGLContext.getEGL());
    this.b = this.a.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    if (this.b == EGL10.EGL_NO_DISPLAY) {
      throw new RuntimeException("eglGetDisplay failed");
    }
    Object localObject = new int[2];
    if (!this.a.eglInitialize(this.b, (int[])localObject)) {
      throw new RuntimeException("eglInitialize failed");
    }
    localObject = (e)this.f.get();
    if (localObject == null) {
      this.d = null;
    }
    for (this.e = null;; this.e = e.d((e)localObject).a(this.a, this.b, this.d))
    {
      if ((this.e == null) || (this.e == EGL10.EGL_NO_CONTEXT))
      {
        this.e = null;
        a("createContext");
      }
      if (localObject != null) {
        ((e)localObject).h = true;
      }
      this.c = null;
      return;
      this.d = e.c((e)localObject).a(this.a, this.b);
    }
  }
  
  public boolean b()
  {
    if (this.a == null) {
      throw new RuntimeException("egl not initialized");
    }
    if (this.b == null) {
      throw new RuntimeException("eglDisplay not initialized");
    }
    if (this.d == null) {
      throw new RuntimeException("mEglConfig not initialized");
    }
    h();
    e locale = (e)this.f.get();
    if (locale != null) {}
    for (this.c = e.e(locale).a(this.a, this.b, this.d, locale.getHolder()); (this.c == null) || (this.c == EGL10.EGL_NO_SURFACE); this.c = null)
    {
      if (this.a.eglGetError() == 12299) {
        TXCLog.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
      }
      return false;
    }
    if (!this.a.eglMakeCurrent(this.b, this.c, this.c, this.e))
    {
      a("EGLHelper", "eglMakeCurrent", this.a.eglGetError());
      return false;
    }
    if (locale != null) {
      locale.g = true;
    }
    return true;
  }
  
  public int c()
  {
    return e();
  }
  
  GL d()
  {
    GL localGL2 = this.e.getGL();
    e locale = (e)this.f.get();
    Object localObject = localGL2;
    GL localGL1;
    int i;
    if (locale != null)
    {
      localGL1 = localGL2;
      if (e.f(locale) != null) {
        localGL1 = e.f(locale).a(localGL2);
      }
      localObject = localGL1;
      if ((e.g(locale) & 0x3) != 0)
      {
        i = 0;
        if ((e.g(locale) & 0x1) != 0) {
          i = 1;
        }
        if ((e.g(locale) & 0x2) == 0) {
          break label106;
        }
      }
    }
    label106:
    for (localObject = new e.l();; localObject = null)
    {
      localObject = GLDebugHelper.wrap(localGL1, i, (Writer)localObject);
      return localObject;
    }
  }
  
  public int e()
  {
    if (!this.a.eglSwapBuffers(this.b, this.c)) {
      return this.a.eglGetError();
    }
    return 12288;
  }
  
  public void f()
  {
    h();
  }
  
  public void g()
  {
    if (this.e != null)
    {
      e locale = (e)this.f.get();
      if (locale != null) {
        e.d(locale).a(this.a, this.b, this.e);
      }
      this.e = null;
    }
    if (this.b != null)
    {
      this.a.eglTerminate(this.b);
      this.b = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.liteav.renderer.e.h
 * JD-Core Version:    0.7.0.1
 */