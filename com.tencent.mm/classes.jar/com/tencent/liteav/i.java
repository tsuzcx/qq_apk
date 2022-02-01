package com.tencent.liteav;

import android.content.Context;
import com.tencent.liteav.basic.b.c;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.util.e;
import com.tencent.liteav.basic.util.h;
import com.tencent.liteav.screencapture.a;
import com.tencent.liteav.screencapture.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import javax.microedition.khronos.egl.EGLContext;

public class i
  implements k, com.tencent.liteav.screencapture.b
{
  private final a a;
  private l b;
  private EGLContext c;
  private WeakReference<com.tencent.liteav.basic.c.b> d;
  private int e;
  private e f;
  private int g;
  private int h;
  private String i;
  private int j;
  private long k;
  private long l;
  private long m;
  private boolean n;
  private final Queue<Runnable> o;
  
  public i(Context paramContext, g paramg, a.a parama)
  {
    AppMethodBeat.i(229341);
    this.c = null;
    this.d = null;
    this.i = "";
    this.j = 0;
    this.o = new LinkedList();
    this.a = new a(paramContext, paramg.W, parama);
    this.a.a(this);
    paramg.a();
    this.f = c(paramg.a, paramg.b);
    this.e = paramg.i;
    this.g = paramg.a;
    this.h = paramg.b;
    TXCLog.i("TXCScreenCaptureSource", "capture size: %s, encode size: %dx%d", new Object[] { this.f, Integer.valueOf(this.g), Integer.valueOf(this.h) });
    AppMethodBeat.o(229341);
  }
  
  private boolean a(Queue<Runnable> paramQueue)
  {
    AppMethodBeat.i(229347);
    try
    {
      if (paramQueue.isEmpty()) {
        return false;
      }
      Runnable localRunnable = (Runnable)paramQueue.poll();
      if (localRunnable == null)
      {
        AppMethodBeat.o(229347);
        return false;
      }
    }
    finally
    {
      AppMethodBeat.o(229347);
    }
    localObject.run();
    AppMethodBeat.o(229347);
    return true;
  }
  
  private e c(int paramInt1, int paramInt2)
  {
    int i2 = 720;
    AppMethodBeat.i(229343);
    int i1;
    e locale;
    if (paramInt1 > paramInt2)
    {
      i1 = 1;
      locale = new e();
      if ((paramInt1 <= 1280) && (paramInt2 <= 1280)) {
        break label106;
      }
      if (i1 == 0) {
        break label87;
      }
      i2 = Math.max(paramInt1, paramInt2);
      label51:
      locale.a = i2;
      if (i1 == 0) {
        break label97;
      }
    }
    label87:
    label97:
    for (paramInt1 = Math.min(paramInt1, paramInt2);; paramInt1 = Math.max(paramInt1, paramInt2))
    {
      locale.b = paramInt1;
      AppMethodBeat.o(229343);
      return locale;
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
      locale.a = paramInt1;
      if (i1 == 0) {
        break label143;
      }
    }
    label143:
    for (paramInt1 = i2;; paramInt1 = 1280)
    {
      locale.b = paramInt1;
      break;
      paramInt1 = 720;
      break label114;
    }
  }
  
  private void f(boolean paramBoolean)
  {
    AppMethodBeat.i(229350);
    if (paramBoolean)
    {
      if (this.g > this.h)
      {
        b(this.h, this.g);
        AppMethodBeat.o(229350);
      }
    }
    else if (this.g < this.h) {
      b(this.h, this.g);
    }
    AppMethodBeat.o(229350);
  }
  
  public void a()
  {
    AppMethodBeat.i(229354);
    Monitor.a(2, String.format("VideoCapture[%d]: start screen", new Object[] { Integer.valueOf(hashCode()) }), "", 0);
    this.k = 0L;
    this.l = 0L;
    this.m = 0L;
    this.n = true;
    this.a.a(this.f.a, this.f.b, this.e);
    AppMethodBeat.o(229354);
  }
  
  public void a(float paramFloat) {}
  
  public void a(float paramFloat1, float paramFloat2) {}
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(int paramInt1, EGLContext paramEGLContext, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    AppMethodBeat.i(229482);
    this.c = paramEGLContext;
    while (a(this.o)) {}
    if (paramInt1 != 0)
    {
      TXCLog.e("TXCScreenCaptureSource", "onScreenCaptureFrame failed");
      AppMethodBeat.o(229482);
      return;
    }
    if (this.n)
    {
      this.n = false;
      Monitor.a(2, String.format("VideoCapture[%d]: capture first frame", new Object[] { Integer.valueOf(hashCode()) }), "", 0);
      h.a(this.d, 1007, "First frame capture completed");
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
        break label296;
      }
    }
    label296:
    for (boolean bool = true;; bool = false)
    {
      f(bool);
      paramEGLContext = new com.tencent.liteav.basic.structs.b();
      paramEGLContext.e = paramInt3;
      paramEGLContext.f = paramInt4;
      paramEGLContext.g = this.g;
      paramEGLContext.h = this.h;
      paramEGLContext.a = paramInt2;
      paramEGLContext.b = 0;
      paramEGLContext.j = 0;
      paramEGLContext.l = h.a(paramEGLContext.e, paramEGLContext.f, this.g, this.h);
      this.b.b(paramEGLContext);
      AppMethodBeat.o(229482);
      return;
    }
  }
  
  public void a(c paramc) {}
  
  public void a(com.tencent.liteav.basic.c.b paramb)
  {
    AppMethodBeat.i(229437);
    this.d = new WeakReference(paramb);
    if (this.a != null) {
      this.a.a(paramb);
    }
    AppMethodBeat.o(229437);
  }
  
  public void a(com.tencent.liteav.basic.structs.b paramb) {}
  
  public void a(l paraml)
  {
    this.b = paraml;
  }
  
  public void a(Object paramObject)
  {
    AppMethodBeat.i(229487);
    while (a(this.o)) {}
    if (this.b != null) {
      this.b.t();
    }
    AppMethodBeat.o(229487);
  }
  
  public void a(Runnable paramRunnable)
  {
    AppMethodBeat.i(229431);
    if (this.a != null) {
      this.a.a(paramRunnable);
    }
    AppMethodBeat.o(229431);
  }
  
  public void a(String paramString)
  {
    this.i = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    AppMethodBeat.i(229361);
    Monitor.a(2, String.format("VideoCapture[%d]: stop screen", new Object[] { Integer.valueOf(hashCode()) }), "", 0);
    this.a.a(null);
    AppMethodBeat.o(229361);
  }
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  public void b()
  {
    AppMethodBeat.i(229373);
    this.a.a(true);
    AppMethodBeat.o(229373);
  }
  
  public void b(int paramInt) {}
  
  public void b(int paramInt1, int paramInt2)
  {
    this.g = paramInt1;
    this.h = paramInt2;
  }
  
  public void b(boolean paramBoolean)
  {
    AppMethodBeat.i(229377);
    e locale = c(this.g, this.h);
    if (!locale.equals(this.f))
    {
      this.f = locale;
      this.a.a(locale.a, locale.b);
      TXCLog.i("TXCScreenCaptureSource", "capture size: %s, encode size: %dx%d", new Object[] { this.f, Integer.valueOf(this.g), Integer.valueOf(this.h) });
    }
    AppMethodBeat.o(229377);
  }
  
  public void c()
  {
    AppMethodBeat.i(229370);
    this.a.a(false);
    AppMethodBeat.o(229370);
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
  
  public void e(boolean paramBoolean) {}
  
  public EGLContext f()
  {
    return this.c;
  }
  
  public void f(int paramInt)
  {
    AppMethodBeat.i(229448);
    this.e = paramInt;
    this.a.a(paramInt);
    AppMethodBeat.o(229448);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.i
 * JD-Core Version:    0.7.0.1
 */