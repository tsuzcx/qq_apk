package com.tencent.liteav;

import android.content.Context;
import com.tencent.liteav.basic.log.TXCLog;
import java.util.LinkedList;
import java.util.Queue;
import javax.microedition.khronos.egl.EGLContext;

public class i
  implements k, com.tencent.liteav.screencapture.c
{
  private static final String a = i.class.getSimpleName();
  private l b;
  private com.tencent.liteav.screencapture.a c = null;
  private EGLContext d = null;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private final Queue<Runnable> j = new LinkedList();
  
  public i(Context paramContext, f paramf)
  {
    this.c = new com.tencent.liteav.screencapture.a(paramContext);
    this.c.a(this);
    boolean bool = paramf.a();
    this.e = paramf.h;
    if (bool)
    {
      k = 1280;
      this.f = k;
      if (!bool) {
        break label115;
      }
    }
    label115:
    for (int k = m;; k = 1280)
    {
      this.g = k;
      this.h = paramf.a;
      this.i = paramf.b;
      return;
      k = 720;
      break;
    }
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
  
  public void a()
  {
    this.c.a(this.f, this.g, this.e);
    this.c.a(true);
  }
  
  public void a(float paramFloat) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    this.h = paramInt1;
    this.i = paramInt2;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    while (a(this.j)) {}
    if (paramInt1 == 0)
    {
      if (this.b != null)
      {
        com.tencent.liteav.basic.f.c localc = new com.tencent.liteav.basic.f.c();
        localc.d = paramInt3;
        localc.e = paramInt4;
        localc.f = this.h;
        localc.g = this.i;
        localc.a = paramInt2;
        localc.b = 0;
        localc.i = 0;
        localc.j = com.tencent.liteav.basic.util.a.a(localc.d, localc.e, this.h, this.i);
        this.b.b(localc);
      }
      return;
    }
    TXCLog.e(a, "onScreenCaptureFrame failed");
  }
  
  public void a(int paramInt, EGLContext paramEGLContext)
  {
    if (paramInt == 0)
    {
      this.d = paramEGLContext;
      return;
    }
    this.d = null;
    TXCLog.e(a, "Start screen capture failed");
  }
  
  public void a(com.tencent.liteav.basic.c.a parama)
  {
    if (this.c != null) {
      this.c.a(parama);
    }
  }
  
  public void a(com.tencent.liteav.basic.f.c paramc) {}
  
  public void a(l paraml)
  {
    this.b = paraml;
  }
  
  public void a(Object paramObject)
  {
    while (a(this.j)) {}
    if (this.b != null) {
      this.b.q();
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    if (this.c != null) {
      this.c.a(paramRunnable);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.c.a(null);
    this.c.a(false);
  }
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  public void b()
  {
    this.c.a(true);
  }
  
  public void b(int paramInt) {}
  
  public void b(boolean paramBoolean) {}
  
  public void c()
  {
    this.c.a(false);
  }
  
  public void c(int paramInt) {}
  
  public void c(boolean paramBoolean) {}
  
  public void d(int paramInt) {}
  
  public boolean d()
  {
    return true;
  }
  
  public boolean d(boolean paramBoolean)
  {
    return false;
  }
  
  public int e()
  {
    return 0;
  }
  
  public void e(boolean paramBoolean) {}
  
  public EGLContext f()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.i
 * JD-Core Version:    0.7.0.1
 */