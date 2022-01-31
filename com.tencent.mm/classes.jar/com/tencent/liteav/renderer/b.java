package com.tencent.liteav.renderer;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.view.TextureView;
import com.tencent.liteav.basic.log.TXCLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import javax.microedition.khronos.egl.EGLContext;

public class b
  extends h
  implements SurfaceTexture.OnFrameAvailableListener
{
  j a;
  b.a b;
  private final int k = 0;
  private final int l = 0;
  private final int m = 0;
  private final int n = 0;
  private c o;
  private SurfaceTexture p;
  private f q;
  private boolean r;
  private float[] s = new float[16];
  private f t;
  private ArrayList<Long> u = new ArrayList();
  private TXCYuvTextureRender v;
  private final Queue<Runnable> w = new LinkedList();
  
  private boolean a(Queue<Runnable> paramQueue)
  {
    try
    {
      if (paramQueue.isEmpty()) {
        return false;
      }
      Runnable localRunnable = (Runnable)paramQueue.poll();
      if (localRunnable == null) {
        return false;
      }
    }
    finally {}
    localObject.run();
    return true;
  }
  
  private void m()
  {
    this.q = new f(true);
    this.v = new TXCYuvTextureRender();
    this.t = new f(false);
  }
  
  private void n()
  {
    this.o = new c(new WeakReference(this));
    this.o.start();
    TXCLog.w("TXCVideoRender", "play:vrender: start render thread");
  }
  
  private void o()
  {
    if (this.o != null)
    {
      this.o.b();
      this.o = null;
      TXCLog.w("TXCVideoRender", "play:vrender: quit render thread");
    }
    this.p = null;
  }
  
  private boolean p()
  {
    for (;;)
    {
      long l1;
      try
      {
        boolean bool;
        if (this.r)
        {
          bool = this.r;
          this.r = false;
          l1 = 0L;
          GLES20.glViewport(0, 0, this.e, this.f);
          if (!bool) {
            break label166;
          }
          if (this.p != null)
          {
            this.p.updateTexImage();
            this.p.getTransformMatrix(this.s);
          }
          if (this.a != null)
          {
            this.a.a(this.q.a(), this.s);
            return true;
          }
        }
        else
        {
          if (!this.u.isEmpty())
          {
            l1 = ((Long)this.u.get(0)).longValue();
            this.u.remove(0);
            bool = false;
            continue;
          }
          return false;
        }
      }
      finally {}
      if (this.q != null)
      {
        this.q.a(this.p);
        continue;
        label166:
        if ((l1 != 0L) && (this.v != null)) {
          if (this.b != null)
          {
            int i = this.v.drawToTexture(l1);
            this.b.d(i);
          }
          else
          {
            this.v.drawFrame(l1);
          }
        }
      }
    }
  }
  
  public SurfaceTexture a()
  {
    return this.p;
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    if (this.v != null) {
      this.v.setVideoSize(paramInt1, paramInt2);
    }
    if (this.q != null) {
      this.q.a(paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    GLES20.glViewport(0, 0, this.e, this.f);
    if (this.t != null) {
      this.t.a(paramInt1, paramBoolean, paramInt4);
    }
    super.a(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    try
    {
      this.u.add(Long.valueOf(paramLong));
      super.a(paramLong, paramInt1, paramInt2);
      return;
    }
    finally {}
  }
  
  protected void a(SurfaceTexture paramSurfaceTexture)
  {
    n();
  }
  
  public void a(b.a parama)
  {
    this.b = parama;
    if ((parama != null) && (this.v != null)) {
      this.v.setHasFrameBuffer(this.g, this.h);
    }
  }
  
  public void a(j paramj)
  {
    this.a = paramj;
  }
  
  public EGLContext b()
  {
    if (this.o != null) {
      return this.o.a();
    }
    return null;
  }
  
  protected void b(SurfaceTexture paramSurfaceTexture)
  {
    o();
  }
  
  void c()
  {
    m();
    if (this.d != null)
    {
      this.d.a(this.e, this.f);
      this.d.b(this.g, this.h);
    }
    if (this.q != null)
    {
      this.q.b();
      this.p = new SurfaceTexture(this.q.a());
      this.p.setOnFrameAvailableListener(this);
    }
    if (this.v != null) {
      this.v.createTexture();
    }
    if ((this.b != null) && (this.v != null)) {
      this.v.setHasFrameBuffer(this.g, this.h);
    }
    if (this.t != null) {
      this.t.b();
    }
    if (this.i != null) {
      this.i.a(this.p);
    }
  }
  
  void d()
  {
    try
    {
      if (this.i != null) {
        this.i.b(this.p);
      }
      label20:
      this.q = null;
      this.v = null;
      this.t = null;
      return;
    }
    catch (Exception localException)
    {
      break label20;
    }
  }
  
  boolean e()
  {
    while (a(this.w)) {}
    return p();
  }
  
  SurfaceTexture f()
  {
    if (this.c != null) {
      return this.c.getSurfaceTexture();
    }
    return null;
  }
  
  public void finalize()
  {
    super.finalize();
    TXCLog.w("TXCVideoRender", "play:vrender: quit render thread when finalize");
    try
    {
      o();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    try
    {
      this.r = true;
      return;
    }
    finally {}
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.liteav.renderer.b
 * JD-Core Version:    0.7.0.1
 */