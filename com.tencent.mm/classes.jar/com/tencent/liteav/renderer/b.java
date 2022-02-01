package com.tencent.liteav.renderer;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.opengl.TXCOpenGlUtils;
import com.tencent.liteav.basic.opengl.c;
import com.tencent.liteav.basic.util.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

class b
  extends Thread
{
  private WeakReference<a> a;
  private volatile boolean b;
  private int c;
  private int d;
  private final Semaphore e;
  private c f;
  private com.tencent.liteav.basic.opengl.b g;
  private Object h;
  
  b(WeakReference<a> paramWeakReference)
  {
    AppMethodBeat.i(16890);
    this.b = false;
    this.c = 1280;
    this.d = 720;
    this.e = new Semaphore(0);
    this.f = null;
    this.g = null;
    this.h = null;
    this.a = paramWeakReference;
    AppMethodBeat.o(16890);
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221682);
    try
    {
      if (this.a != null)
      {
        a locala = (a)this.a.get();
        if (locala != null)
        {
          boolean bool = locala.b(paramInt1, paramInt2);
          AppMethodBeat.o(221682);
          return bool;
        }
      }
    }
    catch (Exception localException)
    {
      TXCLog.e("TXCVideoRenderThread", "drawFrame failed." + localException.getMessage());
      AppMethodBeat.o(221682);
    }
    return false;
  }
  
  private e f()
  {
    AppMethodBeat.i(221667);
    if (this.g != null)
    {
      locale = this.g.f();
      AppMethodBeat.o(221667);
      return locale;
    }
    if (this.f != null)
    {
      locale = this.f.c();
      AppMethodBeat.o(221667);
      return locale;
    }
    TXCOpenGlUtils.a("getSurfaceSize");
    e locale = new e(0, 0);
    AppMethodBeat.o(221667);
    return locale;
  }
  
  private void g()
  {
    AppMethodBeat.i(16897);
    try
    {
      a locala = (a)this.a.get();
      if (locala != null) {
        locala.a(this);
      }
      AppMethodBeat.o(16897);
      return;
    }
    catch (Exception localException)
    {
      TXCLog.e("TXCVideoRenderThread", "init texture render failed.", localException);
      AppMethodBeat.o(16897);
    }
  }
  
  private void h()
  {
    AppMethodBeat.i(16898);
    try
    {
      a locala = (a)this.a.get();
      if (locala != null) {
        locala.b(this);
      }
      AppMethodBeat.o(16898);
      return;
    }
    catch (Exception localException)
    {
      TXCLog.e("TXCVideoRenderThread", "destroy texture render failed", localException);
      AppMethodBeat.o(16898);
    }
  }
  
  private void i()
  {
    AppMethodBeat.i(16899);
    if (this.a != null)
    {
      a locala = (a)this.a.get();
      if (locala != null) {
        locala.j();
      }
    }
    AppMethodBeat.o(16899);
  }
  
  private void j()
  {
    AppMethodBeat.i(16900);
    if (this.a != null)
    {
      a locala = (a)this.a.get();
      if (locala != null) {
        locala.k();
      }
    }
    AppMethodBeat.o(16900);
  }
  
  private void k()
  {
    AppMethodBeat.i(221694);
    Object localObject = (a)this.a.get();
    if (localObject == null)
    {
      AppMethodBeat.o(221694);
      return;
    }
    localObject = ((a)localObject).c();
    if (localObject != null) {}
    for (localObject = new Surface((SurfaceTexture)localObject);; localObject = null)
    {
      if ((this.h == null) || ((this.h instanceof javax.microedition.khronos.egl.EGLContext))) {
        this.g = com.tencent.liteav.basic.opengl.b.a(null, (javax.microedition.khronos.egl.EGLContext)this.h, (Surface)localObject, this.c, this.d);
      }
      for (;;)
      {
        TXCLog.w("TXCVideoRenderThread", "vrender: init egl share context " + this.h + ", create context" + a());
        e();
        AppMethodBeat.o(221694);
        return;
        this.f = c.a(null, (android.opengl.EGLContext)this.h, (Surface)localObject, this.c, this.d);
      }
    }
  }
  
  private void l()
  {
    AppMethodBeat.i(221697);
    TXCLog.w("TXCVideoRenderThread", "vrender: uninit egl " + a());
    if (this.g != null)
    {
      this.g.c();
      this.g = null;
    }
    if (this.f != null)
    {
      this.f.d();
      this.f = null;
    }
    AppMethodBeat.o(221697);
  }
  
  public Object a()
  {
    AppMethodBeat.i(221673);
    Object localObject;
    if (this.g != null)
    {
      localObject = this.g.d();
      AppMethodBeat.o(221673);
      return localObject;
    }
    if (this.f != null)
    {
      localObject = this.f.f();
      AppMethodBeat.o(221673);
      return localObject;
    }
    AppMethodBeat.o(221673);
    return null;
  }
  
  public void a(Object paramObject)
  {
    this.h = paramObject;
  }
  
  public void b()
  {
    AppMethodBeat.i(16892);
    this.b = false;
    c();
    AppMethodBeat.o(16892);
  }
  
  public void c()
  {
    AppMethodBeat.i(16893);
    this.e.release();
    AppMethodBeat.o(16893);
  }
  
  public void d()
  {
    AppMethodBeat.i(16894);
    if (this.g != null) {
      this.g.a();
    }
    if (this.f != null) {
      this.f.e();
    }
    AppMethodBeat.o(16894);
  }
  
  public void e()
  {
    AppMethodBeat.i(16895);
    if (this.g != null) {
      this.g.b();
    }
    if (this.f != null) {
      this.f.b();
    }
    AppMethodBeat.o(16895);
  }
  
  public void run()
  {
    AppMethodBeat.i(16891);
    setName("VRender-" + getId());
    try
    {
      this.b = true;
      k();
      g();
      i();
      label46:
      if (this.b)
      {
        Object localObject1 = f();
        if (a(((e)localObject1).a, ((e)localObject1).b)) {
          if (this.a != null) {
            break label123;
          }
        }
        label123:
        for (localObject1 = null;; localObject1 = (a)this.a.get())
        {
          if ((localObject1 != null) && (((a)localObject1).c() != null)) {
            d();
          }
          if (!this.b) {
            break label46;
          }
          if (!this.e.tryAcquire(500L, TimeUnit.MILLISECONDS)) {
            break;
          }
          break label46;
        }
      }
      j();
      h();
      l();
      return;
    }
    catch (Exception localException)
    {
      TXCLog.e("TXCVideoRenderThread", "render failed.", localException);
      return;
    }
    finally
    {
      AppMethodBeat.o(16891);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.renderer.b
 * JD-Core Version:    0.7.0.1
 */