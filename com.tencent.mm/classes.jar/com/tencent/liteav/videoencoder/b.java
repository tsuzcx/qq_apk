package com.tencent.liteav.videoencoder;

import android.os.Bundle;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.beauty.b.k;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import javax.microedition.khronos.egl.EGLContext;

public class b
  extends com.tencent.liteav.basic.module.a
{
  private static Integer r = Integer.valueOf(1);
  private static final String u = b.class.getSimpleName();
  private static int v = 0;
  private c a = null;
  private d b = null;
  private WeakReference<com.tencent.liteav.basic.c.a> c = null;
  private int d = 0;
  private int e = 2;
  private int f = 1;
  private Timer g = null;
  private TimerTask h = null;
  private LinkedList<Runnable> i = new LinkedList();
  private TXSVideoEncoderParam j;
  private float k = 0.0F;
  private float l = 0.0F;
  private float m = 0.0F;
  private int n = 0;
  private int o = 0;
  private com.tencent.liteav.basic.d.b p;
  private com.tencent.liteav.basic.util.b q;
  private boolean s;
  private k t;
  
  public b(int paramInt)
  {
    this.e = paramInt;
  }
  
  private void a(int paramInt, String paramString)
  {
    if (this.c == null) {}
    com.tencent.liteav.basic.c.a locala;
    do
    {
      return;
      locala = (com.tencent.liteav.basic.c.a)this.c.get();
    } while (locala == null);
    Bundle localBundle = new Bundle();
    localBundle.putInt("EVT_ID", paramInt);
    localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
    localBundle.putCharSequence("EVT_MSG", paramString);
    locala.onNotifyEvent(paramInt, localBundle);
  }
  
  private void a(int paramInt1, String paramString, int paramInt2)
  {
    if (this.c == null) {}
    com.tencent.liteav.basic.c.a locala;
    do
    {
      return;
      locala = (com.tencent.liteav.basic.c.a)this.c.get();
    } while (locala == null);
    Bundle localBundle = new Bundle();
    localBundle.putInt("EVT_ID", paramInt1);
    localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
    localBundle.putCharSequence("EVT_MSG", paramString);
    localBundle.putInt("EVT_PARAM1", paramInt2);
    locala.onNotifyEvent(paramInt1, localBundle);
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
  
  private void c()
  {
    if (this.h == null) {
      this.h = new b.a(this);
    }
    this.g = new Timer();
    this.g.schedule(this.h, 1000L, 1000L);
  }
  
  private void d()
  {
    if (this.g != null)
    {
      this.g.cancel();
      this.g = null;
    }
    if (this.h != null) {
      this.h = null;
    }
  }
  
  private void e()
  {
    a(new b.6(this));
    TXCLog.w("TXCVideoEncoder", "switchSWToHW");
  }
  
  public int a(TXSVideoEncoderParam paramTXSVideoEncoderParam)
  {
    this.j = paramTXSVideoEncoderParam;
    int i1;
    label57:
    int i2;
    if (paramTXSVideoEncoderParam.enableBlackList)
    {
      i1 = com.tencent.liteav.basic.e.b.a().c();
      if ((this.e != 1) || (i1 == 0)) {
        break label149;
      }
      this.a = new a();
      this.f = 1;
      a(1008, "启动硬编", 1);
      setStatusValue(4004, Long.valueOf(this.f));
      if (this.a == null) {
        break label240;
      }
      if (this.b != null) {
        this.a.setListener(this.b);
      }
      if (this.d != 0) {
        this.a.setBitrate(this.d);
      }
      this.a.setID(getID());
      i2 = this.a.start(paramTXSVideoEncoderParam);
      i1 = i2;
      if (i2 == 0) {
        break label244;
      }
    }
    label149:
    label240:
    label244:
    do
    {
      return i2;
      i1 = 2;
      break;
      if ((this.e == 3) && (paramTXSVideoEncoderParam.width == 720) && (paramTXSVideoEncoderParam.height == 1280) && (i1 != 0))
      {
        this.a = new a();
        this.f = 1;
        a(1008, "启动硬编", 1);
        break label57;
      }
      this.a = new TXCSWVideoEncoder();
      this.f = 2;
      a(1008, "启动软编", 2);
      break label57;
      i1 = 10000002;
      i2 = i1;
    } while (this.e != 3);
    this.k = 0.0F;
    this.l = 0.0F;
    this.m = 0.0F;
    this.n = 0;
    this.o = com.tencent.liteav.basic.e.b.a().f();
    c();
    return i1;
  }
  
  public long a(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    long l1 = 10000002L;
    while (a(this.i)) {}
    if (this.a != null) {
      l1 = this.a.pushVideoFrame(paramInt1, paramInt2, paramInt3, paramLong);
    }
    return l1;
  }
  
  public long a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    if (this.p == null) {
      return -1L;
    }
    this.q.b(new b.2(this, paramInt2, paramInt3, paramInt1, paramArrayOfByte, paramLong));
    return 0L;
  }
  
  public EGLContext a(int paramInt1, int paramInt2)
  {
    EGLContext localEGLContext = null;
    if (!this.s) {
      this.s = true;
    }
    while (this.p == null) {
      synchronized (r)
      {
        StringBuilder localStringBuilder = new StringBuilder("CVGLThread");
        Integer localInteger = r;
        r = Integer.valueOf(r.intValue() + 1);
        this.q = new com.tencent.liteav.basic.util.b(localInteger);
        ??? = new boolean[1];
        this.q.a(new b.1(this, paramInt1, paramInt2, (boolean[])???));
        if (???[0] != 0) {
          localEGLContext = this.p.c();
        }
        return localEGLContext;
      }
    }
    return this.p.c();
  }
  
  public void a()
  {
    if (this.q != null)
    {
      com.tencent.liteav.basic.d.b localb = this.p;
      this.q.b(new b.3(this, localb));
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
        d();
      }
      this.b = null;
      this.d = 0;
      return;
      this.i.clear();
      if (this.a != null) {
        this.a.stop();
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
    a(new b.5(this));
  }
  
  public void a(com.tencent.liteav.basic.c.a parama)
  {
    this.c = new WeakReference(parama);
  }
  
  public void a(d paramd)
  {
    this.b = paramd;
    a(new b.4(this));
  }
  
  protected void a(Runnable paramRunnable)
  {
    synchronized (this.i)
    {
      this.i.add(paramRunnable);
      return;
    }
  }
  
  public long b()
  {
    long l1 = 0L;
    if (this.a != null) {
      l1 = this.a.getRealFPS();
    }
    return l1;
  }
  
  public void setID(String paramString)
  {
    super.setID(paramString);
    if (this.a != null) {
      this.a.setID(paramString);
    }
    setStatusValue(4004, Long.valueOf(this.f));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.liteav.videoencoder.b
 * JD-Core Version:    0.7.0.1
 */