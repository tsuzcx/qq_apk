package com.tencent.liteav;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.liteav.renderer.d;
import com.tencent.liteav.renderer.i;
import com.tencent.liteav.renderer.j;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGLContext;

public class b
  implements View.OnTouchListener, com.tencent.liteav.basic.c.a, k, i, j
{
  WeakReference<com.tencent.liteav.basic.c.a> a;
  private Context b;
  private TXCloudVideoView c;
  private d d;
  private com.tencent.liteav.capturer.a e = null;
  private Handler f = null;
  private l g;
  private boolean h;
  private f i;
  private int j = 0;
  private int k = 0;
  private int l = 0;
  private boolean m = false;
  private boolean n = false;
  private int o = -1;
  private int p = -1;
  private int q = 1;
  private ScaleGestureDetector r = null;
  private ScaleGestureDetector.OnScaleGestureListener s = new ScaleGestureDetector.OnScaleGestureListener()
  {
    public boolean onScale(ScaleGestureDetector paramAnonymousScaleGestureDetector)
    {
      float f1 = 1.1F;
      int k = b.this.e();
      float f2;
      if (k > 0)
      {
        f2 = paramAnonymousScaleGestureDetector.getScaleFactor();
        if (f2 <= 1.0F) {
          break label181;
        }
        f2 = 0.2F / k * (k - b.f(b.this)) + 1.0F;
        if (f2 > 1.1F) {
          break label277;
        }
      }
      for (;;)
      {
        int j = Math.round(b.f(b.this) * f1);
        int i = j;
        if (j == b.f(b.this))
        {
          if (f1 > 1.0F) {
            i = j + 1;
          }
        }
        else
        {
          label99:
          j = i;
          if (i >= k) {
            j = k;
          }
          i = j;
          if (j <= 1) {
            i = 1;
          }
          if (f1 <= 1.0F) {
            break label239;
          }
          if (i >= b.f(b.this)) {
            break label269;
          }
          i = b.f(b.this);
        }
        label269:
        for (;;)
        {
          b.d(b.this, i);
          b.this.a(b.f(b.this));
          return false;
          label181:
          if (f2 >= 1.0F) {
            break label272;
          }
          f2 = 1.0F - 0.2F / k * b.f(b.this);
          f1 = f2;
          if (f2 < 0.9F) {
            break;
          }
          f1 = 0.9F;
          break;
          i = j;
          if (f1 >= 1.0F) {
            break label99;
          }
          i = j - 1;
          break label99;
          label239:
          if ((f1 < 1.0F) && (i > b.f(b.this))) {
            i = b.f(b.this);
          }
        }
        label272:
        f1 = f2;
        continue;
        label277:
        f1 = f2;
      }
    }
    
    public boolean onScaleBegin(ScaleGestureDetector paramAnonymousScaleGestureDetector)
    {
      return true;
    }
    
    public void onScaleEnd(ScaleGestureDetector paramAnonymousScaleGestureDetector) {}
  };
  private b.a t = new b.a(this, null);
  
  public b(Context paramContext, f paramf, TXCloudVideoView paramTXCloudVideoView)
  {
    try
    {
      this.i = ((f)paramf.clone());
      this.b = paramContext;
      this.f = new Handler(Looper.getMainLooper());
      this.c = paramTXCloudVideoView;
      this.d = this.c.getGLSurfaceView();
      this.r = new ScaleGestureDetector(paramContext, this.s);
      return;
    }
    catch (CloneNotSupportedException paramf)
    {
      for (;;)
      {
        this.i = new f();
      }
    }
  }
  
  private void a(int paramInt, String paramString)
  {
    if (this.f != null) {
      this.f.post(new b.5(this, paramInt, paramString));
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    this.f.post(new b.4(this, paramInt1, paramInt2));
  }
  
  private void c(SurfaceTexture paramSurfaceTexture)
  {
    if ((paramSurfaceTexture != null) && (!this.h) && (this.e != null))
    {
      this.e.a(paramSurfaceTexture);
      this.e.b(this.i.h);
      this.e.d(this.i.l);
      this.e.b(this.i.D);
      this.e.a(h());
      if (this.e.c(this.i.m) != 0) {
        break label199;
      }
      this.h = true;
      a(1003, "打开摄像头成功");
      if (this.d != null)
      {
        this.d.setFPS(this.i.h);
        this.d.setTextureListener(this);
        this.d.setNotifyListener(this);
        this.d.b();
        this.d.c(true);
        g();
      }
      if ((this.m) && (!com.tencent.liteav.audio.c.a().c()))
      {
        com.tencent.liteav.audio.c.a().a(this.b);
        this.m = false;
      }
    }
    return;
    label199:
    this.h = false;
    a(-1301, "打开摄像头失败，请确认摄像头权限是否打开");
  }
  
  private void g()
  {
    if ((this.d != null) && (this.n))
    {
      this.k = 720;
      this.l = 1280;
      b(this.k, this.l);
    }
  }
  
  private int h()
  {
    if (!this.i.M) {}
    switch (this.i.k)
    {
    case 3: 
    case 4: 
    case 5: 
    default: 
      return 7;
    case 0: 
      return 4;
    case 1: 
      return 5;
    case 2: 
      return 6;
    }
    return 3;
  }
  
  private void i()
  {
    if (this.d != null) {
      this.d.a(new b.7(this));
    }
  }
  
  public int a(int paramInt, float[] paramArrayOfFloat)
  {
    com.tencent.liteav.basic.f.c localc;
    boolean bool;
    if (this.g != null)
    {
      localc = new com.tencent.liteav.basic.f.c();
      localc.d = this.e.e();
      localc.e = this.e.f();
      localc.f = this.i.a;
      localc.g = this.i.b;
      localc.i = this.e.c();
      if (!this.e.d()) {
        break label215;
      }
      if (this.i.L) {
        break label210;
      }
      bool = true;
      localc.h = bool;
      localc.a = paramInt;
      localc.c = paramArrayOfFloat;
      localc.b = 4;
      if ((localc.i != 0) && (localc.i != 180)) {
        break label226;
      }
      localc.f = this.i.b;
    }
    for (localc.g = this.i.a;; localc.g = this.i.b)
    {
      localc.j = com.tencent.liteav.basic.util.a.a(localc.d, localc.e, this.i.b, this.i.a);
      this.g.b(localc);
      return 0;
      label210:
      bool = false;
      break;
      label215:
      bool = this.i.L;
      break;
      label226:
      localc.f = this.i.a;
    }
  }
  
  public void a()
  {
    if (this.f != null) {
      this.f.post(new b.1(this));
    }
    this.d.setListener(this);
    c(this.d.getSurfaceTexture());
    if ((this.i.D) || (this.i.E)) {
      this.c.setOnTouchListener(this);
    }
  }
  
  public void a(float paramFloat)
  {
    this.e.a(paramFloat);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.i.a = paramInt1;
    this.i.b = paramInt2;
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    new Handler(Looper.getMainLooper()).post(new b.6(this, paramSurfaceTexture));
    if (this.g != null) {
      this.g.a(paramSurfaceTexture);
    }
  }
  
  public void a(com.tencent.liteav.basic.c.a parama)
  {
    this.a = new WeakReference(parama);
  }
  
  public void a(com.tencent.liteav.basic.f.c paramc)
  {
    if (this.n)
    {
      this.d.a(paramc.a, this.k, this.l, paramc.h, this.j, paramc.d, paramc.e);
      return;
    }
    this.d.a(paramc.a, this.d.getWidth(), this.d.getHeight(), paramc.h, this.j, paramc.d, paramc.e);
  }
  
  public void a(l paraml)
  {
    this.g = paraml;
  }
  
  public void a(Runnable paramRunnable)
  {
    this.d.a(paramRunnable);
  }
  
  public void a(boolean paramBoolean)
  {
    c();
    if (((this.i.D) || (this.i.E)) && (this.c != null)) {
      this.c.setOnTouchListener(null);
    }
    if (this.d != null)
    {
      this.d.c(false);
      this.d.b(paramBoolean);
      if ((paramBoolean) && (this.f != null)) {
        this.f.post(new b.2(this));
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    return this.e.c(paramInt);
  }
  
  public void b()
  {
    c(this.d.getSurfaceTexture());
  }
  
  public void b(int paramInt)
  {
    this.o = paramInt;
    i();
  }
  
  public void b(SurfaceTexture paramSurfaceTexture)
  {
    if (this.g != null) {
      this.g.q();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if ((this.h) && (this.e != null) && (this.d != null))
    {
      f localf = this.i;
      if (!paramBoolean) {
        break label131;
      }
      if (this.i.m) {
        break label126;
      }
      paramBoolean = true;
      localf.m = paramBoolean;
      this.e.b();
      this.d.a(false);
      this.e.a(h());
      this.e.a(this.d.getSurfaceTexture());
      if (this.e.c(this.i.m) != 0) {
        break label142;
      }
      this.h = true;
      a(1003, "打开摄像头成功");
    }
    for (;;)
    {
      this.d.b();
      return;
      label126:
      paramBoolean = false;
      break;
      label131:
      paramBoolean = this.i.m;
      break;
      label142:
      this.h = false;
      a(-1301, "打开摄像头失败，请确认摄像头权限是否打开");
    }
  }
  
  public void c()
  {
    this.e.b();
    this.h = false;
  }
  
  public void c(int paramInt)
  {
    this.p = paramInt;
    i();
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.d != null) {
      this.d.a(new b.3(this, paramBoolean));
    }
  }
  
  public void d(int paramInt)
  {
    this.i.k = paramInt;
    this.i.a();
  }
  
  public boolean d()
  {
    return this.h;
  }
  
  public boolean d(boolean paramBoolean)
  {
    return this.e.a(paramBoolean);
  }
  
  public int e()
  {
    return this.e.a();
  }
  
  public void e(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public EGLContext f()
  {
    return this.d.getGLContext();
  }
  
  public void onNotifyEvent(int paramInt, Bundle paramBundle)
  {
    com.tencent.liteav.basic.util.a.a(this.a, paramInt, paramBundle);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getPointerCount() == 1) && (paramMotionEvent.getAction() == 0))
    {
      this.t.a(paramView);
      this.t.a(paramMotionEvent);
      this.f.postDelayed(this.t, 100L);
    }
    for (;;)
    {
      if ((this.i.E) && (paramMotionEvent.getAction() == 0) && (this.c != null)) {
        this.c.performClick();
      }
      return this.i.E;
      if ((paramMotionEvent.getPointerCount() > 1) && (paramMotionEvent.getAction() == 2))
      {
        this.f.removeCallbacks(this.t);
        if (this.c != null) {
          this.c.onTouchFocus(-1, -1);
        }
        if ((this.r != null) && (this.i.E)) {
          this.r.onTouchEvent(paramMotionEvent);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.liteav.b
 * JD-Core Version:    0.7.0.1
 */