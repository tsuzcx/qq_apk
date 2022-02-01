package com.tencent.mapsdk.internal;

import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL10;

public final class sv
  extends ss
  implements bt, nq, ob, ss.m
{
  private final sj h;
  private boolean i;
  private Object j;
  private bd k;
  
  public sv(bd parambd)
  {
    super(parambd.getContext());
    AppMethodBeat.i(225182);
    this.k = parambd;
    this.j = parambd.i();
    this.h = ((sj)parambd.b());
    setEGLContextClientVersion(2);
    setPreserveEGLContextOnPause(true);
    setEGLConfigChooser(new ss.b(this, 8, 16));
    setEGLContextFactory(new ss.f()
    {
      public final EGLContext a(EGL10 paramAnonymousEGL10, EGLDisplay paramAnonymousEGLDisplay, EGLConfig paramAnonymousEGLConfig)
      {
        AppMethodBeat.i(222712);
        paramAnonymousEGL10 = paramAnonymousEGL10.eglCreateContext(paramAnonymousEGLDisplay, paramAnonymousEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
        if (sv.a(sv.this) != null) {
          sv.a(sv.this).D();
        }
        AppMethodBeat.o(222712);
        return paramAnonymousEGL10;
      }
      
      public final void a(EGL10 paramAnonymousEGL10, EGLDisplay paramAnonymousEGLDisplay, EGLContext paramAnonymousEGLContext)
      {
        AppMethodBeat.i(222701);
        if (sv.a(sv.this) != null) {
          sv.a(sv.this).E();
        }
        EGLSurface localEGLSurface = EGL10.EGL_NO_SURFACE;
        paramAnonymousEGL10.eglMakeCurrent(paramAnonymousEGLDisplay, localEGLSurface, localEGLSurface, EGL10.EGL_NO_CONTEXT);
        paramAnonymousEGL10.eglDestroyContext(paramAnonymousEGLDisplay, paramAnonymousEGLContext);
        AppMethodBeat.o(222701);
      }
    });
    if (this.j != null) {
      setEGLWindowSurfaceFactory(new ss.g()
      {
        public final EGLSurface a(EGL10 paramAnonymousEGL10, EGLDisplay paramAnonymousEGLDisplay, EGLConfig paramAnonymousEGLConfig, Object paramAnonymousObject)
        {
          paramAnonymousObject = null;
          AppMethodBeat.i(222721);
          try
          {
            paramAnonymousEGL10 = paramAnonymousEGL10.eglCreateWindowSurface(paramAnonymousEGLDisplay, paramAnonymousEGLConfig, sv.b(sv.this), null);
            if (sv.a(sv.this) != null) {
              sv.a(sv.this).D();
            }
            AppMethodBeat.o(222721);
            return paramAnonymousEGL10;
          }
          catch (OutOfMemoryError paramAnonymousEGL10)
          {
            for (;;)
            {
              paramAnonymousEGL10 = paramAnonymousObject;
            }
          }
          catch (IllegalArgumentException paramAnonymousEGL10)
          {
            for (;;)
            {
              paramAnonymousEGL10 = paramAnonymousObject;
            }
          }
        }
        
        public final void a(EGL10 paramAnonymousEGL10, EGLDisplay paramAnonymousEGLDisplay, EGLSurface paramAnonymousEGLSurface)
        {
          AppMethodBeat.i(222729);
          if (sv.a(sv.this) != null) {
            sv.a(sv.this).E();
          }
          paramAnonymousEGL10.eglDestroySurface(paramAnonymousEGLDisplay, paramAnonymousEGLSurface);
          AppMethodBeat.o(222729);
        }
      });
    }
    a(this, this.k.m());
    setRenderMode(0);
    if (Build.VERSION.SDK_INT < 11) {}
    for (boolean bool = false;; bool = true)
    {
      this.i = bool;
      setContentDescription("地图");
      AppMethodBeat.o(225182);
      return;
      setPreserveEGLContextOnPause(true);
    }
  }
  
  private void h()
  {
    AppMethodBeat.i(225190);
    setEGLContextClientVersion(2);
    setPreserveEGLContextOnPause(true);
    setEGLConfigChooser(new ss.b(this, 8, 16));
    setEGLContextFactory(new ss.f()
    {
      public final EGLContext a(EGL10 paramAnonymousEGL10, EGLDisplay paramAnonymousEGLDisplay, EGLConfig paramAnonymousEGLConfig)
      {
        AppMethodBeat.i(222712);
        paramAnonymousEGL10 = paramAnonymousEGL10.eglCreateContext(paramAnonymousEGLDisplay, paramAnonymousEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
        if (sv.a(sv.this) != null) {
          sv.a(sv.this).D();
        }
        AppMethodBeat.o(222712);
        return paramAnonymousEGL10;
      }
      
      public final void a(EGL10 paramAnonymousEGL10, EGLDisplay paramAnonymousEGLDisplay, EGLContext paramAnonymousEGLContext)
      {
        AppMethodBeat.i(222701);
        if (sv.a(sv.this) != null) {
          sv.a(sv.this).E();
        }
        EGLSurface localEGLSurface = EGL10.EGL_NO_SURFACE;
        paramAnonymousEGL10.eglMakeCurrent(paramAnonymousEGLDisplay, localEGLSurface, localEGLSurface, EGL10.EGL_NO_CONTEXT);
        paramAnonymousEGL10.eglDestroyContext(paramAnonymousEGLDisplay, paramAnonymousEGLContext);
        AppMethodBeat.o(222701);
      }
    });
    if (this.j != null) {
      setEGLWindowSurfaceFactory(new ss.g()
      {
        public final EGLSurface a(EGL10 paramAnonymousEGL10, EGLDisplay paramAnonymousEGLDisplay, EGLConfig paramAnonymousEGLConfig, Object paramAnonymousObject)
        {
          paramAnonymousObject = null;
          AppMethodBeat.i(222721);
          try
          {
            paramAnonymousEGL10 = paramAnonymousEGL10.eglCreateWindowSurface(paramAnonymousEGLDisplay, paramAnonymousEGLConfig, sv.b(sv.this), null);
            if (sv.a(sv.this) != null) {
              sv.a(sv.this).D();
            }
            AppMethodBeat.o(222721);
            return paramAnonymousEGL10;
          }
          catch (OutOfMemoryError paramAnonymousEGL10)
          {
            for (;;)
            {
              paramAnonymousEGL10 = paramAnonymousObject;
            }
          }
          catch (IllegalArgumentException paramAnonymousEGL10)
          {
            for (;;)
            {
              paramAnonymousEGL10 = paramAnonymousObject;
            }
          }
        }
        
        public final void a(EGL10 paramAnonymousEGL10, EGLDisplay paramAnonymousEGLDisplay, EGLSurface paramAnonymousEGLSurface)
        {
          AppMethodBeat.i(222729);
          if (sv.a(sv.this) != null) {
            sv.a(sv.this).E();
          }
          paramAnonymousEGL10.eglDestroySurface(paramAnonymousEGLDisplay, paramAnonymousEGLSurface);
          AppMethodBeat.o(222729);
        }
      });
    }
    AppMethodBeat.o(225190);
  }
  
  private static boolean i(ss paramss)
  {
    AppMethodBeat.i(225201);
    if (Build.VERSION.SDK_INT < 11)
    {
      AppMethodBeat.o(225201);
      return false;
    }
    paramss.setPreserveEGLContextOnPause(true);
    AppMethodBeat.o(225201);
    return true;
  }
  
  public final void T()
  {
    AppMethodBeat.i(225239);
    if (this.h != null) {
      this.h.T();
    }
    AppMethodBeat.o(225239);
  }
  
  public final void a()
  {
    AppMethodBeat.i(225328);
    if (this.i) {
      super.a();
    }
    AppMethodBeat.o(225328);
  }
  
  public final void a(Object paramObject, int paramInt1, int paramInt2) {}
  
  public final void a(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(225233);
    if (this.h != null) {
      this.h.a(paramGL10, paramInt1, paramInt2);
    }
    AppMethodBeat.o(225233);
  }
  
  public final void a(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(225225);
    if (this.h != null) {
      this.h.a(paramGL10, paramEGLConfig);
    }
    AppMethodBeat.o(225225);
  }
  
  public final boolean a(GL10 paramGL10)
  {
    AppMethodBeat.i(225349);
    if (this.h == null)
    {
      AppMethodBeat.o(225349);
      return false;
    }
    boolean bool = this.h.a(paramGL10);
    AppMethodBeat.o(225349);
    return bool;
  }
  
  public final void b()
  {
    AppMethodBeat.i(225319);
    if (this.i) {
      super.b();
    }
    AppMethodBeat.o(225319);
  }
  
  public final void c()
  {
    AppMethodBeat.i(225309);
    super.c();
    AppMethodBeat.o(225309);
  }
  
  public final void d()
  {
    AppMethodBeat.i(225339);
    if (getVisibility() == 0) {
      this.g.c();
    }
    AppMethodBeat.o(225339);
  }
  
  protected final boolean dispatchHoverEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(225371);
    if ((this.h != null) && (this.h.a(paramMotionEvent)))
    {
      AppMethodBeat.o(225371);
      return true;
    }
    boolean bool = super.dispatchHoverEvent(paramMotionEvent);
    AppMethodBeat.o(225371);
    return bool;
  }
  
  public final boolean e()
  {
    return false;
  }
  
  public final void f()
  {
    boolean bool = false;
    AppMethodBeat.i(225363);
    setEGLContextClientVersion(2);
    setPreserveEGLContextOnPause(true);
    setEGLConfigChooser(new ss.b(this, 8, 16));
    setEGLContextFactory(new ss.f()
    {
      public final EGLContext a(EGL10 paramAnonymousEGL10, EGLDisplay paramAnonymousEGLDisplay, EGLConfig paramAnonymousEGLConfig)
      {
        AppMethodBeat.i(222712);
        paramAnonymousEGL10 = paramAnonymousEGL10.eglCreateContext(paramAnonymousEGLDisplay, paramAnonymousEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
        if (sv.a(sv.this) != null) {
          sv.a(sv.this).D();
        }
        AppMethodBeat.o(222712);
        return paramAnonymousEGL10;
      }
      
      public final void a(EGL10 paramAnonymousEGL10, EGLDisplay paramAnonymousEGLDisplay, EGLContext paramAnonymousEGLContext)
      {
        AppMethodBeat.i(222701);
        if (sv.a(sv.this) != null) {
          sv.a(sv.this).E();
        }
        EGLSurface localEGLSurface = EGL10.EGL_NO_SURFACE;
        paramAnonymousEGL10.eglMakeCurrent(paramAnonymousEGLDisplay, localEGLSurface, localEGLSurface, EGL10.EGL_NO_CONTEXT);
        paramAnonymousEGL10.eglDestroyContext(paramAnonymousEGLDisplay, paramAnonymousEGLContext);
        AppMethodBeat.o(222701);
      }
    });
    if (this.j != null) {
      setEGLWindowSurfaceFactory(new ss.g()
      {
        public final EGLSurface a(EGL10 paramAnonymousEGL10, EGLDisplay paramAnonymousEGLDisplay, EGLConfig paramAnonymousEGLConfig, Object paramAnonymousObject)
        {
          paramAnonymousObject = null;
          AppMethodBeat.i(222721);
          try
          {
            paramAnonymousEGL10 = paramAnonymousEGL10.eglCreateWindowSurface(paramAnonymousEGLDisplay, paramAnonymousEGLConfig, sv.b(sv.this), null);
            if (sv.a(sv.this) != null) {
              sv.a(sv.this).D();
            }
            AppMethodBeat.o(222721);
            return paramAnonymousEGL10;
          }
          catch (OutOfMemoryError paramAnonymousEGL10)
          {
            for (;;)
            {
              paramAnonymousEGL10 = paramAnonymousObject;
            }
          }
          catch (IllegalArgumentException paramAnonymousEGL10)
          {
            for (;;)
            {
              paramAnonymousEGL10 = paramAnonymousObject;
            }
          }
        }
        
        public final void a(EGL10 paramAnonymousEGL10, EGLDisplay paramAnonymousEGLDisplay, EGLSurface paramAnonymousEGLSurface)
        {
          AppMethodBeat.i(222729);
          if (sv.a(sv.this) != null) {
            sv.a(sv.this).E();
          }
          paramAnonymousEGL10.eglDestroySurface(paramAnonymousEGLDisplay, paramAnonymousEGLSurface);
          AppMethodBeat.o(222729);
        }
      });
    }
    a(this, this.k.m());
    setRenderMode(0);
    if (Build.VERSION.SDK_INT < 11) {}
    for (;;)
    {
      this.i = bool;
      AppMethodBeat.o(225363);
      return;
      setPreserveEGLContextOnPause(true);
      bool = true;
    }
  }
  
  public final int getEGLContextHash()
  {
    AppMethodBeat.i(225357);
    if (this.h != null)
    {
      int m = this.h.getEGLContextHash();
      AppMethodBeat.o(225357);
      return m;
    }
    AppMethodBeat.o(225357);
    return 0;
  }
  
  public final az getVectorMapDelegate()
  {
    return this.h;
  }
  
  public final View getView()
  {
    return this;
  }
  
  public final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(225253);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.h != null) {
      this.h.e(paramInt1, paramInt2);
    }
    AppMethodBeat.o(225253);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public final void setMapOpaque(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.internal.sv
 * JD-Core Version:    0.7.0.1
 */