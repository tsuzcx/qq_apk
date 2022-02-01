package com.tencent.liteav;

import android.content.Context;
import com.tencent.liteav.basic.a.c;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.util.d;
import com.tencent.liteav.screencapture.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import javax.microedition.khronos.egl.EGLContext;

public class h
  implements j, com.tencent.liteav.screencapture.b
{
  private final com.tencent.liteav.screencapture.a a;
  private k b;
  private EGLContext c;
  private WeakReference<com.tencent.liteav.basic.c.a> d;
  private int e;
  private d f;
  private int g;
  private int h;
  private String i;
  private int j;
  private long k;
  private long l;
  private long m;
  private boolean n;
  private final Queue<Runnable> o;
  
  public h(Context paramContext, f paramf, a.a parama)
  {
    AppMethodBeat.i(221326);
    this.c = null;
    this.d = null;
    this.i = "";
    this.j = 0;
    this.o = new LinkedList();
    this.a = new com.tencent.liteav.screencapture.a(paramContext, paramf.V, parama);
    this.a.a(this);
    paramf.a();
    this.f = c(paramf.a, paramf.b);
    this.e = paramf.h;
    this.g = paramf.a;
    this.h = paramf.b;
    TXCLog.i("TXCScreenCaptureSource", "capture size: %s, encode size: %dx%d", new Object[] { this.f, Integer.valueOf(this.g), Integer.valueOf(this.h) });
    AppMethodBeat.o(221326);
  }
  
  private boolean a(Queue<Runnable> paramQueue)
  {
    AppMethodBeat.i(15545);
    try
    {
      if (paramQueue.isEmpty()) {
        return false;
      }
      Runnable localRunnable = (Runnable)paramQueue.poll();
      if (localRunnable == null)
      {
        AppMethodBeat.o(15545);
        return false;
      }
    }
    finally
    {
      AppMethodBeat.o(15545);
    }
    localObject.run();
    AppMethodBeat.o(15545);
    return true;
  }
  
  private d c(int paramInt1, int paramInt2)
  {
    int i2 = 720;
    AppMethodBeat.i(221327);
    int i1;
    d locald;
    if (paramInt1 > paramInt2)
    {
      i1 = 1;
      locald = new d();
      if ((paramInt1 <= 1280) && (paramInt2 <= 1280)) {
        break label106;
      }
      if (i1 == 0) {
        break label87;
      }
      i2 = Math.max(paramInt1, paramInt2);
      label51:
      locald.a = i2;
      if (i1 == 0) {
        break label97;
      }
    }
    label87:
    label97:
    for (paramInt1 = Math.min(paramInt1, paramInt2);; paramInt1 = Math.max(paramInt1, paramInt2))
    {
      locald.b = paramInt1;
      AppMethodBeat.o(221327);
      return locald;
      i1 = 0;
      break;
      i2 = Math.min(paramInt1, paramInt2);
      break label51;
    }
    label106:
    if (i1 != 0)
    {
      paramInt1 = 1280;
      label114:
      locald.a = paramInt1;
      if (i1 == 0) {
        break label143;
      }
    }
    label143:
    for (paramInt1 = i2;; paramInt1 = 1280)
    {
      locald.b = paramInt1;
      break;
      paramInt1 = 720;
      break label114;
    }
  }
  
  private void f(boolean paramBoolean)
  {
    AppMethodBeat.i(221330);
    if (paramBoolean)
    {
      if (this.g > this.h)
      {
        b(this.h, this.g);
        AppMethodBeat.o(221330);
      }
    }
    else if (this.g < this.h) {
      b(this.h, this.g);
    }
    AppMethodBeat.o(221330);
  }
  
  public void a()
  {
    AppMethodBeat.i(15539);
    Monitor.a(2, String.format("VideoCapture[%d]: start screen", new Object[] { Integer.valueOf(hashCode()) }), "", 0);
    this.k = 0L;
    this.l = 0L;
    this.m = 0L;
    this.n = true;
    this.a.a(this.f.a, this.f.b, this.e);
    AppMethodBeat.o(15539);
  }
  
  public void a(float paramFloat) {}
  
  public void a(float paramFloat1, float paramFloat2) {}
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    boolean bool = true;
    AppMethodBeat.i(15547);
    while (a(this.o)) {}
    if (paramInt1 != 0)
    {
      TXCLog.e("TXCScreenCaptureSource", "onScreenCaptureFrame failed");
      AppMethodBeat.o(15547);
      return;
    }
    if (this.n)
    {
      this.n = false;
      Monitor.a(2, String.format("VideoCapture[%d]: capture first frame", new Object[] { Integer.valueOf(hashCode()) }), "", 0);
      com.tencent.liteav.basic.util.f.a(this.d, 1007, "首帧画面采集完成");
      TXCLog.i("TXCScreenCaptureSource", "on Got first frame");
    }
    this.k += 1L;
    paramLong = System.currentTimeMillis() - this.l;
    if (paramLong >= TimeUnit.SECONDS.toMillis(1L))
    {
      double d1 = (this.k - this.m) * 1000.0D / paramLong;
      this.m = this.k;
      this.l = System.currentTimeMillis();
      TXCStatus.a(this.i, 1001, this.j, Double.valueOf(d1));
    }
    if (this.b != null) {
      if (paramInt3 >= paramInt4) {
        break label304;
      }
    }
    for (;;)
    {
      f(bool);
      com.tencent.liteav.basic.structs.b localb = new com.tencent.liteav.basic.structs.b();
      localb.e = paramInt3;
      localb.f = paramInt4;
      localb.g = this.g;
      localb.h = this.h;
      localb.a = paramInt2;
      localb.b = 0;
      localb.j = 0;
      localb.l = com.tencent.liteav.basic.util.f.a(localb.e, localb.f, this.g, this.h);
      this.b.b(localb);
      AppMethodBeat.o(15547);
      return;
      label304:
      bool = false;
    }
  }
  
  public void a(int paramInt, EGLContext paramEGLContext)
  {
    AppMethodBeat.i(15546);
    if (paramInt == 0)
    {
      this.c = paramEGLContext;
      AppMethodBeat.o(15546);
      return;
    }
    this.c = null;
    TXCLog.e("TXCScreenCaptureSource", "Start screen capture failed");
    AppMethodBeat.o(15546);
  }
  
  public void a(c paramc) {}
  
  public void a(com.tencent.liteav.basic.c.a parama)
  {
    AppMethodBeat.i(15544);
    this.d = new WeakReference(parama);
    if (this.a != null) {
      this.a.a(parama);
    }
    AppMethodBeat.o(15544);
  }
  
  public void a(com.tencent.liteav.basic.structs.b paramb) {}
  
  public void a(k paramk)
  {
    this.b = paramk;
  }
  
  public void a(Object paramObject)
  {
    AppMethodBeat.i(15548);
    while (a(this.o)) {}
    if (this.b != null) {
      this.b.s();
    }
    AppMethodBeat.o(15548);
  }
  
  public void a(Runnable paramRunnable)
  {
    AppMethodBeat.i(15543);
    if (this.a != null) {
      this.a.a(paramRunnable);
    }
    AppMethodBeat.o(15543);
  }
  
  public void a(String paramString)
  {
    this.i = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    AppMethodBeat.i(15540);
    Monitor.a(2, String.format("VideoCapture[%d]: stop screen", new Object[] { Integer.valueOf(hashCode()) }), "", 0);
    this.a.a(null);
    AppMethodBeat.o(15540);
  }
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  public void b()
  {
    AppMethodBeat.i(15542);
    this.a.a(true);
    AppMethodBeat.o(15542);
  }
  
  public void b(int paramInt) {}
  
  public void b(int paramInt1, int paramInt2)
  {
    this.g = paramInt1;
    this.h = paramInt2;
  }
  
  public void b(boolean paramBoolean)
  {
    AppMethodBeat.i(221328);
    d locald = c(this.g, this.h);
    if (!locald.equals(this.f))
    {
      this.f = locald;
      this.a.a(locald.a, locald.b);
      TXCLog.i("TXCScreenCaptureSource", "capture size: %s, encode size: %dx%d", new Object[] { this.f, Integer.valueOf(this.g), Integer.valueOf(this.h) });
    }
    AppMethodBeat.o(221328);
  }
  
  public void c()
  {
    AppMethodBeat.i(15541);
    this.a.a(false);
    AppMethodBeat.o(15541);
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
  
  public void e(int paramInt) {}
  
  public void e(boolean paramBoolean)
  {
    AppMethodBeat.i(15549);
    AppMethodBeat.o(15549);
  }
  
  public EGLContext f()
  {
    return this.c;
  }
  
  public void f(int paramInt)
  {
    AppMethodBeat.i(221329);
    this.e = paramInt;
    this.a.a(paramInt);
    AppMethodBeat.o(221329);
  }
  
  public int g()
  {
    return this.e;
  }
  
  public void g(int paramInt)
  {
    this.j = paramInt;
  }
  
  public boolean h()
  {
    return false;
  }
  
  public boolean i()
  {
    return false;
  }
  
  public boolean j()
  {
    return false;
  }
  
  public boolean k()
  {
    return false;
  }
  
  public boolean l()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.h
 * JD-Core Version:    0.7.0.1
 */