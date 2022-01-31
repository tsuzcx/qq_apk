package com.tencent.liteav;

import android.content.Context;
import com.tencent.liteav.basic.log.TXCLog;
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
    AppMethodBeat.i(146811);
    a = h.class.getSimpleName();
    AppMethodBeat.o(146811);
  }
  
  public h(Context paramContext, f paramf)
  {
    AppMethodBeat.i(146801);
    this.c = null;
    this.d = null;
    this.j = "";
    this.k = new LinkedList();
    this.c = new com.tencent.liteav.screencapture.a(paramContext, paramf.O);
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
          break label180;
        }
      }
      label180:
      for (m = Math.min(paramf.a, paramf.b);; m = Math.max(paramf.a, paramf.b))
      {
        this.g = m;
        this.h = paramf.a;
        this.i = paramf.b;
        AppMethodBeat.o(146801);
        return;
        m = Math.min(paramf.a, paramf.b);
        break;
      }
    }
    if (bool)
    {
      m = 1280;
      label204:
      this.f = m;
      if (!bool) {
        break label232;
      }
    }
    label232:
    for (int m = n;; m = 1280)
    {
      this.g = m;
      break;
      m = 720;
      break label204;
    }
  }
  
  private boolean a(Queue<Runnable> paramQueue)
  {
    AppMethodBeat.i(146806);
    try
    {
      if (paramQueue.isEmpty()) {
        return false;
      }
      Runnable localRunnable = (Runnable)paramQueue.poll();
      if (localRunnable == null)
      {
        AppMethodBeat.o(146806);
        return false;
      }
    }
    finally
    {
      AppMethodBeat.o(146806);
    }
    localObject.run();
    AppMethodBeat.o(146806);
    return true;
  }
  
  private void f(boolean paramBoolean)
  {
    AppMethodBeat.i(146810);
    if (paramBoolean)
    {
      if (this.h > this.i)
      {
        a(this.i, this.h);
        AppMethodBeat.o(146810);
      }
    }
    else if (this.h < this.i) {
      a(this.i, this.h);
    }
    AppMethodBeat.o(146810);
  }
  
  public void a()
  {
    AppMethodBeat.i(67726);
    this.c.a(this.f, this.g, this.e);
    this.c.a(true);
    AppMethodBeat.o(67726);
  }
  
  public void a(float paramFloat) {}
  
  public void a(float paramFloat1, float paramFloat2) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(67762);
    this.h = paramInt1;
    this.i = paramInt2;
    AppMethodBeat.o(67762);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    AppMethodBeat.i(146808);
    while (a(this.k)) {}
    if (paramInt1 == 0)
    {
      if (this.b != null)
      {
        if (paramInt3 < paramInt4) {}
        for (boolean bool = true;; bool = false)
        {
          f(bool);
          com.tencent.liteav.basic.structs.b localb = new com.tencent.liteav.basic.structs.b();
          localb.e = paramInt3;
          localb.f = paramInt4;
          localb.g = this.h;
          localb.h = this.i;
          localb.a = paramInt2;
          localb.b = 0;
          localb.j = 0;
          localb.l = com.tencent.liteav.basic.util.b.a(localb.e, localb.f, this.h, this.i);
          this.b.b(localb);
          AppMethodBeat.o(146808);
          return;
        }
      }
    }
    else {
      TXCLog.e(a, "onScreenCaptureFrame failed");
    }
    AppMethodBeat.o(146808);
  }
  
  public void a(int paramInt, EGLContext paramEGLContext)
  {
    AppMethodBeat.i(146807);
    if (paramInt == 0)
    {
      this.d = paramEGLContext;
      AppMethodBeat.o(146807);
      return;
    }
    this.d = null;
    TXCLog.e(a, "Start screen capture failed");
    AppMethodBeat.o(146807);
  }
  
  public void a(com.tencent.liteav.basic.c.a parama)
  {
    AppMethodBeat.i(146805);
    if (this.c != null) {
      this.c.a(parama);
    }
    AppMethodBeat.o(146805);
  }
  
  public void a(com.tencent.liteav.basic.structs.b paramb) {}
  
  public void a(k paramk)
  {
    this.b = paramk;
  }
  
  public void a(Object paramObject)
  {
    AppMethodBeat.i(146809);
    while (a(this.k)) {}
    if (this.b != null) {
      this.b.u();
    }
    AppMethodBeat.o(146809);
  }
  
  public void a(Runnable paramRunnable)
  {
    AppMethodBeat.i(146804);
    if (this.c != null) {
      this.c.a(paramRunnable);
    }
    AppMethodBeat.o(146804);
  }
  
  public void a(String paramString)
  {
    this.j = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    AppMethodBeat.i(67725);
    this.c.a(null);
    this.c.a(false);
    AppMethodBeat.o(67725);
  }
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  public void b()
  {
    AppMethodBeat.i(146803);
    this.c.a(true);
    AppMethodBeat.o(146803);
  }
  
  public void b(int paramInt)
  {
    AppMethodBeat.i(67730);
    AppMethodBeat.o(67730);
  }
  
  public void b(boolean paramBoolean)
  {
    AppMethodBeat.i(67731);
    AppMethodBeat.o(67731);
  }
  
  public void c()
  {
    AppMethodBeat.i(146802);
    this.c.a(false);
    AppMethodBeat.o(146802);
  }
  
  public void c(int paramInt)
  {
    AppMethodBeat.i(67732);
    AppMethodBeat.o(67732);
  }
  
  public void c(boolean paramBoolean)
  {
    AppMethodBeat.i(67748);
    AppMethodBeat.o(67748);
  }
  
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
    AppMethodBeat.i(67737);
    AppMethodBeat.o(67737);
    return 0;
  }
  
  public void e(int paramInt) {}
  
  public void e(boolean paramBoolean) {}
  
  public EGLContext f()
  {
    return this.d;
  }
  
  public void f(int paramInt) {}
  
  public boolean g()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.liteav.h
 * JD-Core Version:    0.7.0.1
 */