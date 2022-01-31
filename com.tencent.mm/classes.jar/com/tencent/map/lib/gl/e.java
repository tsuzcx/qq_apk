package com.tencent.map.lib.gl;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class e
  extends SurfaceView
  implements SurfaceHolder.Callback
{
  private static final e.j a = new e.j(null);
  private final WeakReference<e> b = new WeakReference(this);
  private e.i c;
  private e.m d;
  private boolean e;
  private e.e f;
  private e.f g;
  private e.g h;
  private e.k i;
  private int j;
  private int k;
  private boolean l;
  
  public e(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  private void a()
  {
    getHolder().addCallback(this);
  }
  
  private void d()
  {
    if (this.c != null) {
      throw new IllegalStateException("setRenderer has already been called for this instance.");
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    setEGLConfigChooser(new e.b(this, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6));
  }
  
  public void b()
  {
    this.c.g();
  }
  
  public void c()
  {
    this.c.f();
  }
  
  protected void finalize()
  {
    try
    {
      if (this.c != null) {
        this.c.h();
      }
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public void g()
  {
    this.c.c();
  }
  
  public int getDebugFlags()
  {
    return this.j;
  }
  
  public boolean getPreserveEGLContextOnPause()
  {
    return this.l;
  }
  
  public int getRenderMode()
  {
    return this.c.b();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((this.e) && (this.d != null)) {
      if (this.c == null) {
        break label74;
      }
    }
    label74:
    for (int m = this.c.b();; m = 1)
    {
      this.c = new e.i(this.b);
      if (m != 1) {
        this.c.a(m);
      }
      this.c.start();
      this.e = false;
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    if (this.c != null) {
      this.c.h();
    }
    this.e = true;
    super.onDetachedFromWindow();
  }
  
  public void setDebugFlags(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void setEGLConfigChooser(e.e parame)
  {
    d();
    this.f = parame;
  }
  
  public void setEGLConfigChooser(boolean paramBoolean)
  {
    setEGLConfigChooser(new e.n(this, paramBoolean));
  }
  
  public void setEGLContextClientVersion(int paramInt)
  {
    d();
    this.k = paramInt;
  }
  
  public void setEGLContextFactory(e.f paramf)
  {
    d();
    this.g = paramf;
  }
  
  public void setEGLWindowSurfaceFactory(e.g paramg)
  {
    d();
    this.h = paramg;
  }
  
  public void setGLWrapper(e.k paramk)
  {
    this.i = paramk;
  }
  
  public void setPreserveEGLContextOnPause(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public void setRenderMode(int paramInt)
  {
    this.c.a(paramInt);
  }
  
  public void setRenderer(e.m paramm)
  {
    d();
    if (this.f == null) {
      this.f = new e.n(this, true);
    }
    if (this.g == null) {
      this.g = new c(null);
    }
    if (this.h == null) {
      this.h = new d(null);
    }
    this.d = paramm;
    this.c = new e.i(this.b);
    this.c.start();
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    this.c.a(paramInt2, paramInt3);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    this.c.d();
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.c.e();
  }
  
  private class c
    implements e.f
  {
    private int b = 12440;
    
    private c() {}
    
    public EGLContext a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
    {
      int[] arrayOfInt = new int[3];
      arrayOfInt[0] = this.b;
      arrayOfInt[1] = e.a(e.this);
      arrayOfInt[2] = 12344;
      EGLContext localEGLContext = EGL10.EGL_NO_CONTEXT;
      if (e.a(e.this) != 0) {}
      for (;;)
      {
        return paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, localEGLContext, arrayOfInt);
        arrayOfInt = null;
      }
    }
    
    public void a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
    {
      if (!paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext))
      {
        new StringBuilder("display:").append(paramEGLDisplay).append(" context: ").append(paramEGLContext);
        e.h.a("eglDestroyContex", paramEGL10.eglGetError());
      }
    }
  }
  
  private static class d
    implements e.g
  {
    public EGLSurface a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, Object paramObject)
    {
      try
      {
        paramEGL10 = paramEGL10.eglCreateWindowSurface(paramEGLDisplay, paramEGLConfig, paramObject, null);
        return paramEGL10;
      }
      catch (IllegalArgumentException paramEGL10)
      {
        return null;
      }
      catch (OutOfMemoryError paramEGL10) {}
      return null;
    }
    
    public void a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface)
    {
      paramEGL10.eglDestroySurface(paramEGLDisplay, paramEGLSurface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.map.lib.gl.e
 * JD-Core Version:    0.7.0.1
 */