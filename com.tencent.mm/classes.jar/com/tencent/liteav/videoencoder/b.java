package com.tencent.liteav.videoencoder;

import android.opengl.GLES20;
import android.os.Bundle;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.f;
import com.tencent.liteav.basic.util.g;
import com.tencent.liteav.beauty.b.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import javax.microedition.khronos.egl.EGLContext;

public class b
  extends com.tencent.liteav.basic.module.a
{
  private static Integer r;
  private static final String u;
  private static int v;
  private c a;
  private d b;
  private WeakReference<com.tencent.liteav.basic.c.a> c;
  private int d;
  private int e;
  private int f;
  private Timer g;
  private TimerTask h;
  private LinkedList<Runnable> i;
  private TXSVideoEncoderParam j;
  private float k;
  private float l;
  private float m;
  private int n;
  private int o;
  private com.tencent.liteav.basic.d.b p;
  private g q;
  private boolean s;
  private k t;
  
  static
  {
    AppMethodBeat.i(14818);
    r = Integer.valueOf(1);
    u = b.class.getSimpleName();
    v = 0;
    AppMethodBeat.o(14818);
  }
  
  public b(int paramInt)
  {
    AppMethodBeat.i(14790);
    this.a = null;
    this.b = null;
    this.c = null;
    this.d = 0;
    this.e = 2;
    this.f = 1;
    this.g = null;
    this.h = null;
    this.i = new LinkedList();
    this.k = 0.0F;
    this.l = 0.0F;
    this.m = 0.0F;
    this.n = 0;
    this.o = 0;
    this.e = paramInt;
    AppMethodBeat.o(14790);
  }
  
  private void a(int paramInt, String paramString)
  {
    AppMethodBeat.i(14812);
    if (this.c == null)
    {
      AppMethodBeat.o(14812);
      return;
    }
    com.tencent.liteav.basic.c.a locala = (com.tencent.liteav.basic.c.a)this.c.get();
    if (locala == null)
    {
      AppMethodBeat.o(14812);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("EVT_ID", paramInt);
    localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
    localBundle.putCharSequence("EVT_MSG", paramString);
    locala.onNotifyEvent(paramInt, localBundle);
    AppMethodBeat.o(14812);
  }
  
  private void a(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(14813);
    if (this.c == null)
    {
      AppMethodBeat.o(14813);
      return;
    }
    com.tencent.liteav.basic.c.a locala = (com.tencent.liteav.basic.c.a)this.c.get();
    if (locala == null)
    {
      AppMethodBeat.o(14813);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("EVT_ID", paramInt1);
    localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
    localBundle.putCharSequence("EVT_MSG", paramString);
    localBundle.putInt("EVT_PARAM1", paramInt2);
    locala.onNotifyEvent(paramInt1, localBundle);
    AppMethodBeat.o(14813);
  }
  
  private boolean a(Queue<Runnable> paramQueue)
  {
    AppMethodBeat.i(14795);
    try
    {
      if (paramQueue.isEmpty()) {
        return false;
      }
      Runnable localRunnable = (Runnable)paramQueue.poll();
      if (localRunnable == null)
      {
        AppMethodBeat.o(14795);
        return false;
      }
    }
    finally
    {
      AppMethodBeat.o(14795);
    }
    localObject.run();
    AppMethodBeat.o(14795);
    return true;
  }
  
  private void e()
  {
    AppMethodBeat.i(14810);
    if (this.h == null) {
      this.h = new a(this);
    }
    this.g = new Timer();
    this.g.schedule(this.h, 1000L, 1000L);
    AppMethodBeat.o(14810);
  }
  
  private void f()
  {
    AppMethodBeat.i(14811);
    if (this.g != null)
    {
      this.g.cancel();
      this.g = null;
    }
    if (this.h != null) {
      this.h = null;
    }
    AppMethodBeat.o(14811);
  }
  
  private void g()
  {
    AppMethodBeat.i(14814);
    a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(14821);
        b.a(b.this, 1107, "软编切硬编");
        if (b.d(b.this) != null)
        {
          b.d(b.this).setListener(null);
          b.d(b.this).stop();
        }
        b.a(b.this, new a());
        b.a(b.this, 1);
        b.this.setStatusValue(4007, Long.valueOf(b.g(b.this)));
        b.d(b.this).start(b.h(b.this));
        if (b.e(b.this) != null) {
          b.d(b.this).setListener(b.e(b.this));
        }
        if (b.f(b.this) != 0) {
          b.d(b.this).setBitrate(b.f(b.this));
        }
        b.d(b.this).setID(b.this.getID());
        AppMethodBeat.o(14821);
      }
    });
    TXCLog.w("TXCVideoEncoder", "switchSWToHW");
    AppMethodBeat.o(14814);
  }
  
  public int a(TXSVideoEncoderParam paramTXSVideoEncoderParam)
  {
    AppMethodBeat.i(14791);
    this.j = paramTXSVideoEncoderParam;
    int i1;
    if (paramTXSVideoEncoderParam.enableBlackList)
    {
      i1 = com.tencent.liteav.basic.e.b.a().c();
      if ((this.e != 1) || (i1 == 0)) {
        break label187;
      }
      this.a = new a();
      this.f = 1;
      a(1008, "启动硬编", 1);
      label63:
      setStatusValue(4007, Long.valueOf(this.f));
      if (this.a == null) {
        break label335;
      }
      if (this.b != null) {
        this.a.setListener(this.b);
      }
      if (this.d != 0) {
        this.a.setBitrate(this.d);
      }
      this.a.setID(getID());
      i1 = this.a.start(paramTXSVideoEncoderParam);
      if (i1 == 0) {
        break label285;
      }
      if (this.f != 1) {
        break label278;
      }
    }
    label278:
    for (paramTXSVideoEncoderParam = "hw";; paramTXSVideoEncoderParam = "sw")
    {
      TXCLog.i(u, "start video encode ".concat(String.valueOf(paramTXSVideoEncoderParam)));
      AppMethodBeat.o(14791);
      return i1;
      i1 = 2;
      break;
      label187:
      if ((this.e == 3) && (paramTXSVideoEncoderParam.width == 720) && (paramTXSVideoEncoderParam.height == 1280) && (i1 != 0))
      {
        this.a = new a();
        this.f = 1;
        a(1008, "启动硬编", 1);
        break label63;
      }
      this.a = new TXCSWVideoEncoder();
      this.f = 2;
      a(1008, "启动软编", 2);
      break label63;
    }
    for (;;)
    {
      label285:
      if (this.e == 3)
      {
        this.k = 0.0F;
        this.l = 0.0F;
        this.m = 0.0F;
        this.n = 0;
        this.o = com.tencent.liteav.basic.e.b.a().f();
        e();
      }
      AppMethodBeat.o(14791);
      return i1;
      label335:
      i1 = 10000002;
    }
  }
  
  public long a(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(14799);
    long l1 = 10000002L;
    while (a(this.i)) {}
    if (this.a != null)
    {
      setStatusValue(4002, Long.valueOf(c()));
      setStatusValue(4001, this.j.streamType, Double.valueOf(b()));
      if (this.f == 1) {
        setStatusValue(8002, this.j.streamType, Integer.valueOf(d()));
      }
      l1 = this.a.pushVideoFrame(paramInt1, paramInt2, paramInt3, paramLong);
    }
    AppMethodBeat.o(14799);
    return l1;
  }
  
  public long a(final byte[] paramArrayOfByte, final int paramInt1, final int paramInt2, final int paramInt3, final long paramLong)
  {
    AppMethodBeat.i(14796);
    if (this.p == null)
    {
      AppMethodBeat.o(14796);
      return -1L;
    }
    this.q.b(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(14782);
        if ((b.b(b.this) == null) || (b.b(b.this).n() != paramInt2) || (b.b(b.this).o() != paramInt3))
        {
          if (b.b(b.this) != null)
          {
            b.b(b.this).d();
            b.a(b.this, null);
          }
          b.a(b.this, new k(paramInt1));
          if (!b.b(b.this).a())
          {
            if (b.a(b.this) != null)
            {
              b.a(b.this).c();
              b.a(b.this, null);
            }
            b.a(b.this, null);
            AppMethodBeat.o(14782);
            return;
          }
          b.b(b.this).a(true);
          b.b(b.this).a(paramInt2, paramInt3);
        }
        b.b(b.this).a(paramArrayOfByte);
        GLES20.glViewport(0, 0, paramInt2, paramInt3);
        int i = b.b(b.this).q();
        GLES20.glFlush();
        b.this.a(i, paramInt2, paramInt3, paramLong);
        AppMethodBeat.o(14782);
      }
    });
    AppMethodBeat.o(14796);
    return 0L;
  }
  
  public EGLContext a(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(14793);
    if (!this.s)
    {
      this.s = true;
      synchronized (r)
      {
        StringBuilder localStringBuilder = new StringBuilder("CVGLThread");
        Integer localInteger = r;
        r = Integer.valueOf(r.intValue() + 1);
        this.q = new g(localInteger);
        ??? = new boolean[1];
        this.q.a(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(14899);
            b.a(b.this, com.tencent.liteav.basic.d.b.a(null, null, null, paramInt1, paramInt2));
            boolean[] arrayOfBoolean = this.c;
            if (b.a(b.this) != null) {}
            for (int i = 1;; i = 0)
            {
              arrayOfBoolean[0] = i;
              AppMethodBeat.o(14899);
              return;
            }
          }
        });
        if (???[0] != 0)
        {
          ??? = this.p.d();
          AppMethodBeat.o(14793);
          return ???;
        }
      }
      AppMethodBeat.o(14793);
      return null;
    }
    if (this.p != null)
    {
      ??? = this.p.d();
      AppMethodBeat.o(14793);
      return ???;
    }
    AppMethodBeat.o(14793);
    return null;
  }
  
  public void a()
  {
    AppMethodBeat.i(14797);
    if (this.q != null)
    {
      final com.tencent.liteav.basic.d.b localb = this.p;
      this.q.b(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(14856);
          b.c(b.this).clear();
          if (b.d(b.this) != null) {
            b.d(b.this).stop();
          }
          if (b.b(b.this) != null)
          {
            b.b(b.this).d();
            b.a(b.this, null);
          }
          if (localb != null) {
            localb.c();
          }
          AppMethodBeat.o(14856);
        }
      });
      this.q = null;
      this.p = null;
    }
    for (;;)
    {
      if (this.e == 3)
      {
        this.k = 0.0F;
        this.l = 0.0F;
        this.m = 0.0F;
        this.n = 0;
        f();
      }
      this.b = null;
      this.d = 0;
      AppMethodBeat.o(14797);
      return;
      this.i.clear();
      if (this.a != null) {
        this.a.stop();
      }
    }
  }
  
  public void a(int paramInt)
  {
    AppMethodBeat.i(14798);
    if (this.a != null) {
      this.a.setRotation(paramInt);
    }
    AppMethodBeat.o(14798);
  }
  
  public void a(com.tencent.liteav.basic.c.a parama)
  {
    AppMethodBeat.i(14801);
    this.c = new WeakReference(parama);
    AppMethodBeat.o(14801);
  }
  
  public void a(d paramd)
  {
    AppMethodBeat.i(14802);
    this.b = paramd;
    a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(14819);
        if (b.d(b.this) != null) {
          b.d(b.this).setListener(b.e(b.this));
        }
        AppMethodBeat.o(14819);
      }
    });
    AppMethodBeat.o(14802);
  }
  
  protected void a(Runnable paramRunnable)
  {
    AppMethodBeat.i(14794);
    synchronized (this.i)
    {
      this.i.add(paramRunnable);
      AppMethodBeat.o(14794);
      return;
    }
  }
  
  public double b()
  {
    AppMethodBeat.i(14807);
    double d1 = 0.0D;
    if (this.a != null) {
      d1 = this.a.getRealFPS();
    }
    AppMethodBeat.o(14807);
    return d1;
  }
  
  public boolean b(int paramInt)
  {
    AppMethodBeat.i(14800);
    if (this.a != null)
    {
      this.a.setFPS(paramInt);
      AppMethodBeat.o(14800);
      return true;
    }
    AppMethodBeat.o(14800);
    return false;
  }
  
  public boolean b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(14804);
    if (this.a != null)
    {
      this.d = paramInt1;
      this.a.setBitrateFromQos(paramInt1, paramInt2);
      AppMethodBeat.o(14804);
      return true;
    }
    AppMethodBeat.o(14804);
    return false;
  }
  
  public long c()
  {
    AppMethodBeat.i(14808);
    long l1 = 0L;
    if (this.a != null) {
      l1 = this.a.getRealBitrate();
    }
    AppMethodBeat.o(14808);
    return l1;
  }
  
  public void c(int paramInt)
  {
    AppMethodBeat.i(14803);
    this.d = paramInt;
    a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(14786);
        if (b.d(b.this) != null) {
          b.d(b.this).setBitrate(b.f(b.this));
        }
        AppMethodBeat.o(14786);
      }
    });
    AppMethodBeat.o(14803);
  }
  
  public int d()
  {
    AppMethodBeat.i(14809);
    int i1 = 0;
    if (this.a != null) {
      i1 = this.a.getEncodeCost();
    }
    AppMethodBeat.o(14809);
    return i1;
  }
  
  public boolean d(int paramInt)
  {
    AppMethodBeat.i(14805);
    if (this.a != null)
    {
      this.a.setEncodeIdrFpsFromQos(paramInt);
      AppMethodBeat.o(14805);
      return true;
    }
    AppMethodBeat.o(14805);
    return false;
  }
  
  public void e(final int paramInt)
  {
    AppMethodBeat.i(14806);
    a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(14783);
        if (b.d(b.this) != null) {
          b.d(b.this).enableNearestRPS(paramInt);
        }
        AppMethodBeat.o(14783);
      }
    });
    AppMethodBeat.o(14806);
  }
  
  public void setID(String paramString)
  {
    AppMethodBeat.i(14792);
    super.setID(paramString);
    if (this.a != null) {
      this.a.setID(paramString);
    }
    setStatusValue(4007, Long.valueOf(this.f));
    AppMethodBeat.o(14792);
  }
  
  static class a
    extends TimerTask
  {
    private WeakReference<b> a;
    
    public a(b paramb)
    {
      AppMethodBeat.i(14823);
      this.a = new WeakReference(paramb);
      AppMethodBeat.o(14823);
    }
    
    public void run()
    {
      AppMethodBeat.i(14824);
      if (this.a == null)
      {
        AppMethodBeat.o(14824);
        return;
      }
      b localb = (b)this.a.get();
      if (localb == null)
      {
        AppMethodBeat.o(14824);
        return;
      }
      if (b.i(localb) < b.j(localb))
      {
        int[] arrayOfInt = f.a();
        b.k(localb);
        b.a(localb, b.l(localb) + arrayOfInt[0] / 10);
        float f = b.m(localb);
        b.b(localb, arrayOfInt[1] / 10 + f);
        b.c(localb, (float)(b.n(localb) + localb.b() * 100.0D / b.h(localb).fps));
        AppMethodBeat.o(14824);
        return;
      }
      if ((com.tencent.liteav.basic.e.b.a().a(b.l(localb) / b.j(localb), b.m(localb) / b.j(localb), b.n(localb) / b.j(localb))) && (com.tencent.liteav.basic.e.b.a().c() != 0))
      {
        Monitor.a(2, "VideoEncoder: 性能不足，软编切硬编 [appCPU:" + b.l(localb) + "][sysCPU:" + b.m(localb) + "][fps:" + b.n(localb) + "][checkCount:" + b.j(localb) + "]", "", 0);
        b.o(localb);
      }
      b.p(localb);
      AppMethodBeat.o(14824);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.videoencoder.b
 * JD-Core Version:    0.7.0.1
 */