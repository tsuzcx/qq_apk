package com.tencent.liteav;

import android.content.Context;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.structs.b;
import com.tencent.liteav.basic.util.d;
import com.tencent.liteav.screencapture.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.Queue;
import javax.microedition.khronos.egl.EGLContext;

public class h
  implements j, c
{
  private static final String a;
  private k b;
  private com.tencent.liteav.screencapture.a c;
  private EGLContext d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private String j;
  private final Queue<Runnable> k;
  
  static
  {
    AppMethodBeat.i(15550);
    a = h.class.getSimpleName();
    AppMethodBeat.o(15550);
  }
  
  public h(Context paramContext, f paramf)
  {
    AppMethodBeat.i(15538);
    this.c = null;
    this.d = null;
    this.j = "";
    this.k = new LinkedList();
    this.c = new com.tencent.liteav.screencapture.a(paramContext, paramf.V);
    this.c.a(this);
    boolean bool = paramf.a();
    this.e = paramf.h;
    if ((paramf.a > 1280) || (paramf.b > 1280))
    {
      if (bool)
      {
        m = Math.max(paramf.a, paramf.b);
        this.f = m;
        if (!bool) {
          break label182;
        }
      }
      label182:
      for (m = Math.min(paramf.a, paramf.b);; m = Math.max(paramf.a, paramf.b))
      {
        this.g = m;
        this.h = paramf.a;
        this.i = paramf.b;
        AppMethodBeat.o(15538);
        return;
        m = Math.min(paramf.a, paramf.b);
        break;
      }
    }
    if (bool)
    {
      m = 1280;
      label206:
      this.f = m;
      if (!bool) {
        break label234;
      }
    }
    label234:
    for (int m = n;; m = 1280)
    {
      this.g = m;
      break;
      m = 720;
      break label206;
    }
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
  
  private void e(boolean paramBoolean)
  {
    AppMethodBeat.i(15549);
    if (paramBoolean)
    {
      if (this.h > this.i)
      {
        b(this.i, this.h);
        AppMethodBeat.o(15549);
      }
    }
    else if (this.h < this.i) {
      b(this.i, this.h);
    }
    AppMethodBeat.o(15549);
  }
  
  public void a()
  {
    AppMethodBeat.i(15539);
    Monitor.a(2, String.format("VideoCapture[%d]: start screen", new Object[] { Integer.valueOf(hashCode()) }), "", 0);
    this.c.a(this.f, this.g, this.e);
    this.c.a(true);
    AppMethodBeat.o(15539);
  }
  
  public void a(float paramFloat) {}
  
  public void a(float paramFloat1, float paramFloat2) {}
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    AppMethodBeat.i(15547);
    while (a(this.k)) {}
    if (paramInt1 == 0)
    {
      if (this.b != null)
      {
        if (paramInt3 < paramInt4) {}
        for (boolean bool = true;; bool = false)
        {
          e(bool);
          b localb = new b();
          localb.e = paramInt3;
          localb.f = paramInt4;
          localb.g = this.h;
          localb.h = this.i;
          localb.a = paramInt2;
          localb.b = 0;
          localb.j = 0;
          localb.l = d.a(localb.e, localb.f, this.h, this.i);
          this.b.b(localb);
          AppMethodBeat.o(15547);
          return;
        }
      }
    }
    else {
      TXCLog.e(a, "onScreenCaptureFrame failed");
    }
    AppMethodBeat.o(15547);
  }
  
  public void a(int paramInt, EGLContext paramEGLContext)
  {
    AppMethodBeat.i(15546);
    if (paramInt == 0)
    {
      this.d = paramEGLContext;
      AppMethodBeat.o(15546);
      return;
    }
    this.d = null;
    TXCLog.e(a, "Start screen capture failed");
    AppMethodBeat.o(15546);
  }
  
  public void a(com.tencent.liteav.basic.c.a parama)
  {
    AppMethodBeat.i(15544);
    if (this.c != null) {
      this.c.a(parama);
    }
    AppMethodBeat.o(15544);
  }
  
  public void a(b paramb) {}
  
  public void a(k paramk)
  {
    this.b = paramk;
  }
  
  public void a(Object paramObject)
  {
    AppMethodBeat.i(15548);
    while (a(this.k)) {}
    if (this.b != null) {
      this.b.t();
    }
    AppMethodBeat.o(15548);
  }
  
  public void a(Runnable paramRunnable)
  {
    AppMethodBeat.i(15543);
    if (this.c != null) {
      this.c.a(paramRunnable);
    }
    AppMethodBeat.o(15543);
  }
  
  public void a(String paramString)
  {
    this.j = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    AppMethodBeat.i(15540);
    Monitor.a(2, String.format("VideoCapture[%d]: stop screen", new Object[] { Integer.valueOf(hashCode()) }), "", 0);
    this.c.a(null);
    this.c.a(false);
    AppMethodBeat.o(15540);
  }
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  public void b()
  {
    AppMethodBeat.i(15542);
    this.c.a(true);
    AppMethodBeat.o(15542);
  }
  
  public void b(int paramInt) {}
  
  public void b(int paramInt1, int paramInt2)
  {
    this.h = paramInt1;
    this.i = paramInt2;
  }
  
  public void b(boolean paramBoolean) {}
  
  public void c()
  {
    AppMethodBeat.i(15541);
    this.c.a(false);
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
  
  public EGLContext f()
  {
    return this.d;
  }
  
  public void f(int paramInt) {}
  
  public int g()
  {
    return 0;
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