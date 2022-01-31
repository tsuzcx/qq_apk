package com.tencent.liteav.renderer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.liteav.basic.d.f;
import com.tencent.liteav.basic.d.g;
import com.tencent.liteav.basic.d.h;
import com.tencent.liteav.basic.log.TXCLog;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.Queue;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.opengles.GL10;

public class d
  extends e
  implements SurfaceTexture.OnFrameAvailableListener, GLSurfaceView.Renderer
{
  private int A = 0;
  private int B = 0;
  private boolean C = true;
  private d.a D = null;
  private int E = 0;
  private int F;
  private int G;
  private final Queue<Runnable> H = new LinkedList();
  i a;
  j b;
  WeakReference<com.tencent.liteav.basic.c.a> c;
  private SurfaceTexture i;
  private EGLContext j;
  private com.tencent.liteav.basic.d.d k;
  private boolean l = false;
  private int[] m;
  private float[] n = new float[16];
  private int o = 0;
  private boolean p = false;
  private float q = 1.0F;
  private float r = 1.0F;
  private int s = 20;
  private long t = 0L;
  private long u = 0L;
  private int v = 12288;
  private boolean w = true;
  private boolean x = false;
  private Object y = new Object();
  private Handler z;
  
  public d(Context paramContext)
  {
    super(paramContext);
    setEGLContextClientVersion(2);
    a(8, 8, 8, 8, 16, 0);
    setRenderer(this);
  }
  
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
  
  private int[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f1 = paramInt2 / paramInt1;
    float f2 = paramInt4 / paramInt3;
    int i1;
    if (f1 > f2)
    {
      paramInt4 = (int)(paramInt1 * f2);
      i1 = (paramInt2 - paramInt4) / 2;
      paramInt3 = 0;
      paramInt2 = paramInt4;
      paramInt4 = paramInt1;
    }
    for (paramInt1 = i1;; paramInt1 = 0)
    {
      return new int[] { paramInt4, paramInt2, paramInt3, paramInt1 };
      paramInt4 = (int)(paramInt2 / f2);
      paramInt3 = (paramInt1 - paramInt4) / 2;
    }
  }
  
  private void f()
  {
    int i3;
    int i1;
    label50:
    int i2;
    if (this.C) {
      if ((this.A != 0) && (this.B != 0))
      {
        if (getWidth() > getHeight()) {
          break label152;
        }
        i3 = 1;
        if (this.B < this.A) {
          break label157;
        }
        i1 = this.B;
        if (this.B < this.A) {
          break label165;
        }
        i2 = this.A;
        label66:
        if (i3 == 0) {
          break label173;
        }
        i3 = i1;
        i1 = i2;
      }
    }
    for (;;)
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocate(i1 * i3 * 4);
      Bitmap localBitmap = Bitmap.createBitmap(i1, i3, Bitmap.Config.ARGB_8888);
      localByteBuffer.position(0);
      GLES20.glReadPixels(this.F, this.G, i1, i3, 6408, 5121, localByteBuffer);
      new Thread(new d.4(this, localByteBuffer, localBitmap, i1, i3)).start();
      this.C = false;
      return;
      label152:
      i3 = 0;
      break;
      label157:
      i1 = this.A;
      break label50;
      label165:
      i2 = this.B;
      break label66;
      label173:
      i3 = i2;
    }
  }
  
  private void g()
  {
    try
    {
      Thread.sleep(15L);
      return;
    }
    catch (Exception localException) {}
  }
  
  protected void a()
  {
    if (this.a != null) {
      this.a.b(null);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, int paramInt5, int paramInt6)
  {
    if (this.k == null) {
      return;
    }
    try
    {
      if (this.e) {
        return;
      }
    }
    finally {}
    if (this.E == 0)
    {
      this.A = paramInt2;
      this.B = paramInt3;
      this.F = 0;
      this.G = 0;
      GLES20.glViewport(0, 0, paramInt2, paramInt3);
      paramInt2 = getWidth();
      paramInt3 = getHeight();
    }
    label385:
    label391:
    label396:
    label405:
    label411:
    label421:
    for (;;)
    {
      float f1;
      label84:
      float f2;
      label98:
      int i1;
      label192:
      label200:
      label205:
      Object localObject2;
      label237:
      boolean bool;
      if (paramInt3 != 0)
      {
        f1 = paramInt2 / paramInt3;
        if (paramInt6 == 0) {
          break label373;
        }
        f2 = paramInt5 / paramInt6;
        if ((this.p != paramBoolean) || (this.o != paramInt4) || (this.q != f1) || (this.r != f2))
        {
          this.p = paramBoolean;
          this.o = paramInt4;
          this.q = f1;
          this.r = f2;
          int i2 = (720 - this.o) % 360;
          if ((i2 != 90) && (i2 != 270)) {
            break label379;
          }
          paramInt4 = 1;
          if (paramInt4 == 0) {
            break label385;
          }
          i1 = paramInt3;
          if (paramInt4 == 0) {
            break label391;
          }
          localObject2 = this.k;
          float[] arrayOfFloat = h.a(g.a, false, true);
          f1 = i1 / paramInt2;
          if (paramInt4 == 0) {
            break label396;
          }
          paramBoolean = false;
          if (paramInt4 == 0) {
            break label405;
          }
          bool = this.p;
          label248:
          ((com.tencent.liteav.basic.d.d)localObject2).a(paramInt5, paramInt6, i2, arrayOfFloat, f1, paramBoolean, bool);
          if (paramInt4 == 0) {
            break label411;
          }
          this.k.g();
        }
      }
      for (;;)
      {
        GLES20.glBindFramebuffer(36160, 0);
        this.k.a(paramInt1);
        return;
        if (this.E != 1) {
          break label421;
        }
        localObject2 = a(paramInt2, paramInt3, paramInt5, paramInt6);
        paramInt2 = localObject2[0];
        paramInt3 = localObject2[1];
        this.F = localObject2[2];
        this.G = localObject2[3];
        this.A = paramInt2;
        this.B = paramInt3;
        GLES20.glViewport(this.F, this.G, paramInt2, paramInt3);
        break;
        f1 = 1.0F;
        break label84;
        label373:
        f2 = 1.0F;
        break label98;
        label379:
        paramInt4 = 0;
        break label192;
        i1 = paramInt2;
        break label200;
        paramInt2 = paramInt3;
        break label205;
        paramBoolean = this.p;
        break label237;
        bool = false;
        break label248;
        this.k.h();
      }
    }
  }
  
  public void a(d.a parama)
  {
    this.D = parama;
    this.C = true;
  }
  
  public void a(Runnable paramRunnable)
  {
    synchronized (this.H)
    {
      this.H.add(paramRunnable);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.w = true;
    if (paramBoolean)
    {
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
      GLES20.glClear(16384);
      this.v = d();
    }
    try
    {
      if (this.x)
      {
        this.x = false;
        if (this.i != null) {
          this.i.updateTexImage();
        }
      }
      return;
    }
    finally {}
  }
  
  public void b()
  {
    this.l = false;
    this.D = null;
    this.C = false;
  }
  
  public void b(final boolean paramBoolean)
  {
    synchronized (this.y)
    {
      a(new Runnable()
      {
        public void run()
        {
          synchronized (d.c(d.this))
          {
            d.this.a(paramBoolean);
            d.c(d.this).notifyAll();
            return;
          }
        }
      });
    }
    try
    {
      this.y.wait(1000L);
      label30:
      return;
      localObject2 = finally;
      throw localObject2;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label30;
    }
  }
  
  protected int c()
  {
    if (this.v != 12288) {
      TXCLog.e("TXCGLSurfaceView", "background capture swapbuffer error : " + this.v);
    }
    return this.v;
  }
  
  public EGLContext getGLContext()
  {
    return this.j;
  }
  
  public SurfaceTexture getSurfaceTexture()
  {
    return this.i;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((Build.VERSION.SDK_INT >= 21) && (this.z != null)) {
      this.z.getLooper().quitSafely();
    }
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    int i1 = 0;
    a(this.H);
    long l1;
    for (;;)
    {
      l1 = System.currentTimeMillis();
      if (this.u == 0L) {
        this.u = l1;
      }
      if (l1 - this.u >= this.t * 1000L / this.s) {
        break;
      }
      g();
    }
    this.t += 1L;
    if (l1 - this.u > 2000L)
    {
      this.t = 1L;
      this.u = System.currentTimeMillis();
    }
    if (this.w) {}
    for (;;)
    {
      return;
      try
      {
        try
        {
          if (!this.x) {
            return;
          }
        }
        finally {}
        if (this.i == null) {
          break label147;
        }
      }
      catch (Exception paramGL10)
      {
        return;
      }
      this.i.updateTexImage();
      this.i.getTransformMatrix(this.n);
      label147:
      this.x = false;
      if (this.b != null) {
        this.b.a(this.m[0], this.n);
      }
      f();
      try
      {
        if (!this.e) {
          i1 = 1;
        }
        if (i1 == 0) {
          continue;
        }
        this.v = d();
        return;
      }
      finally {}
    }
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    if (!this.l)
    {
      com.tencent.liteav.basic.util.a.a(this.c, 1007, "首帧画面采集完成");
      this.l = true;
    }
    this.w = false;
    try
    {
      this.x = true;
      return;
    }
    finally {}
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2) {}
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    this.j = ((EGL10)EGLContext.getEGL()).eglGetCurrentContext();
    this.m = new int[1];
    this.m[0] = f.b();
    if (this.m[0] <= 0)
    {
      this.m = null;
      TXCLog.e("TXCGLSurfaceView", "create oes texture error!! at glsurfaceview");
      return;
    }
    this.i = new SurfaceTexture(this.m[0]);
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (this.z != null) {
        this.z.getLooper().quitSafely();
      }
      paramGL10 = new HandlerThread("VideoCaptureThread");
      paramGL10.start();
      this.z = new Handler(paramGL10.getLooper());
      this.i.setOnFrameAvailableListener(this, this.z);
    }
    for (;;)
    {
      this.k = new com.tencent.liteav.basic.d.d();
      if (!this.k.a()) {
        break;
      }
      this.k.a(h.e, h.a(g.a, false, false));
      if (this.a == null) {
        break;
      }
      this.a.a(this.i);
      return;
      this.i.setOnFrameAvailableListener(this);
    }
  }
  
  public void setFPS(int paramInt)
  {
    a(new d.1(this, paramInt));
  }
  
  public void setListener(i parami)
  {
    this.a = parami;
  }
  
  public void setNotifyListener(com.tencent.liteav.basic.c.a parama)
  {
    this.c = new WeakReference(parama);
  }
  
  public void setRendMode(int paramInt)
  {
    a(new d.2(this, paramInt));
  }
  
  protected void setRunInBackground(boolean paramBoolean)
  {
    if (paramBoolean) {
      try
      {
        TXCLog.d("TXCGLSurfaceView", "background capture enter background");
        this.e = true;
        return;
      }
      finally {}
    }
    a(new d.3(this));
  }
  
  public void setTextureListener(j paramj)
  {
    this.b = paramj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.renderer.d
 * JD-Core Version:    0.7.0.1
 */