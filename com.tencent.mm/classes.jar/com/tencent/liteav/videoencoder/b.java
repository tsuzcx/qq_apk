package com.tencent.liteav.videoencoder;

import android.opengl.GLES20;
import android.os.Bundle;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.h;
import com.tencent.liteav.basic.util.i;
import com.tencent.liteav.beauty.b.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import javax.microedition.khronos.egl.EGLContext;

public class b
  extends com.tencent.liteav.basic.module.a
{
  private static Integer s;
  private static final String v;
  private static int w;
  private final com.tencent.liteav.basic.util.c a;
  private d b;
  private e c;
  private WeakReference<com.tencent.liteav.basic.c.b> d;
  private int e;
  private int f;
  private a g;
  private Timer h;
  private TimerTask i;
  private LinkedList<Runnable> j;
  private TXSVideoEncoderParam k;
  private float l;
  private float m;
  private float n;
  private int o;
  private int p;
  private com.tencent.liteav.basic.opengl.b q;
  private i r;
  private boolean t;
  private k u;
  
  static
  {
    AppMethodBeat.i(14818);
    s = Integer.valueOf(1);
    v = b.class.getSimpleName();
    w = 0;
    AppMethodBeat.o(14818);
  }
  
  public b(int paramInt)
  {
    AppMethodBeat.i(14790);
    this.a = new com.tencent.liteav.basic.util.c("video-encoder", (int)TimeUnit.SECONDS.toMillis(5L));
    this.b = null;
    this.c = null;
    this.d = null;
    this.e = 0;
    this.f = 2;
    this.g = a.a;
    this.h = null;
    this.i = null;
    this.j = new LinkedList();
    this.l = 0.0F;
    this.m = 0.0F;
    this.n = 0.0F;
    this.o = 0;
    this.p = 0;
    this.f = paramInt;
    AppMethodBeat.o(14790);
  }
  
  private void a(int paramInt, String paramString)
  {
    AppMethodBeat.i(14812);
    if (this.d == null)
    {
      AppMethodBeat.o(14812);
      return;
    }
    com.tencent.liteav.basic.c.b localb = (com.tencent.liteav.basic.c.b)this.d.get();
    if (localb == null)
    {
      AppMethodBeat.o(14812);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("EVT_ID", paramInt);
    localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
    localBundle.putLong("EVT_UTC_TIME", TXCTimeUtil.getUtcTimeTick());
    localBundle.putCharSequence("EVT_MSG", paramString);
    localb.onNotifyEvent(paramInt, localBundle);
    AppMethodBeat.o(14812);
  }
  
  private void a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(229480);
    if (this.d == null)
    {
      AppMethodBeat.o(229480);
      return;
    }
    com.tencent.liteav.basic.c.b localb = (com.tencent.liteav.basic.c.b)this.d.get();
    if (localb == null)
    {
      AppMethodBeat.o(229480);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("EVT_ID", paramInt1);
    localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
    localBundle.putLong("EVT_UTC_TIME", TXCTimeUtil.getUtcTimeTick());
    localBundle.putCharSequence("EVT_MSG", paramString);
    localBundle.putInt("EVT_PARAM1", paramInt2);
    localBundle.putInt("EVT_STREAM_TYPE", paramInt3);
    localb.onNotifyEvent(paramInt1, localBundle);
    AppMethodBeat.o(229480);
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
  
  private void g()
  {
    AppMethodBeat.i(14814);
    if (this.i == null) {
      this.i = new b(this);
    }
    this.h = new Timer();
    this.h.schedule(this.i, 1000L, 1000L);
    AppMethodBeat.o(14814);
  }
  
  private void h()
  {
    AppMethodBeat.i(229476);
    if (this.h != null)
    {
      this.h.cancel();
      this.h = null;
    }
    if (this.i != null) {
      this.i = null;
    }
    AppMethodBeat.o(229476);
  }
  
  private void i()
  {
    AppMethodBeat.i(229482);
    a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(229092);
        b.a(b.this, 1107, "Switches from software encoding to hardware encoding");
        if (b.d(b.this) != null)
        {
          b.d(b.this).setListener(null);
          b.d(b.this).stop();
        }
        b.a(b.this, new a());
        TXCLog.w("TXCVideoEncoder", "create hw encoder");
        b.a(b.this, b.a.a);
        if (b.g(b.this).isH265EncoderEnabled)
        {
          TXCLog.w(b.f(), "can not switch from 265 sw to hw!");
          b.g(b.this).isH265EncoderEnabled = false;
        }
        b.this.setStatusValue(4007, Long.valueOf(b.h(b.this).a()));
        b.d(b.this).start(b.g(b.this));
        if (b.e(b.this) != null) {
          b.d(b.this).setListener(b.e(b.this));
        }
        if (b.f(b.this) != 0) {
          b.d(b.this).setBitrate(b.f(b.this));
        }
        b.d(b.this).setID(b.this.getID());
        AppMethodBeat.o(229092);
      }
    });
    TXCLog.w("TXCVideoEncoder", "switchSWToHW");
    AppMethodBeat.o(229482);
  }
  
  public int a(TXSVideoEncoderParam paramTXSVideoEncoderParam)
  {
    AppMethodBeat.i(14791);
    StringBuilder localStringBuilder;
    if (paramTXSVideoEncoderParam.enableBlackList)
    {
      i1 = com.tencent.liteav.basic.d.c.a().d();
      localStringBuilder = new StringBuilder("Enables ");
      if ((!paramTXSVideoEncoderParam.isH265EncoderEnabled) || (!c.a(paramTXSVideoEncoderParam.width, paramTXSVideoEncoderParam.height, paramTXSVideoEncoderParam.fps))) {
        break label273;
      }
      localStringBuilder.append("H265 ");
      this.f = 1;
      if ((this.f != 1) || (i1 == 0)) {
        break label380;
      }
      this.b = new a();
      if (!paramTXSVideoEncoderParam.isH265EncoderEnabled) {
        break label370;
      }
    }
    label273:
    label365:
    label370:
    for (this.g = a.c;; this.g = a.a)
    {
      localStringBuilder.append("hardware encoding");
      a(1008, localStringBuilder.toString(), this.g.a(), paramTXSVideoEncoderParam.streamType);
      setStatusValue(4007, Long.valueOf(this.g.a()));
      this.k = paramTXSVideoEncoderParam;
      if (this.b == null) {
        break label536;
      }
      if (this.c != null) {
        this.b.setListener(this.c);
      }
      if (this.e != 0) {
        this.b.setBitrate(this.e);
      }
      this.b.setID(getID());
      int i2 = this.b.start(paramTXSVideoEncoderParam);
      i1 = i2;
      if (i2 == 0) {
        break label540;
      }
      TXCLog.i(v, "start video encode " + localStringBuilder.toString());
      AppMethodBeat.o(14791);
      return i2;
      i1 = 2;
      break;
      localStringBuilder.append("H264 ");
      Locale localLocale;
      String str;
      if (paramTXSVideoEncoderParam.isH265EncoderEnabled)
      {
        a(-2311, "encode not support hevc,change to 264");
        localLocale = Locale.getDefault();
        str = TXCCommonUtil.getDeviceInfo();
        if (!c.a(1920, 1080, 20)) {
          break label365;
        }
      }
      for (i2 = 1;; i2 = 0)
      {
        Monitor.a(2, String.format(localLocale, "VideoEncoder: hevc hardware encoder not support, switch to 264 encoder. %s, %d", new Object[] { str, Integer.valueOf(i2) }), "", 0);
        paramTXSVideoEncoderParam.isH265EncoderEnabled = false;
        break;
      }
    }
    label380:
    if ((this.f == 3) && (paramTXSVideoEncoderParam.width == 720) && (paramTXSVideoEncoderParam.height == 1280) && (i1 != 0))
    {
      this.b = new a();
      if (paramTXSVideoEncoderParam.isH265EncoderEnabled) {}
      for (this.g = a.c;; this.g = a.a)
      {
        localStringBuilder.append("hardware encoding");
        break;
      }
    }
    this.b = new TXCSWVideoEncoder();
    if (paramTXSVideoEncoderParam.isH265EncoderEnabled) {}
    for (this.g = a.d;; this.g = a.b)
    {
      localStringBuilder.append("software encoding");
      if ((this.k == null) || (!this.k.isH265EncoderEnabled)) {
        break;
      }
      this.k.isH265EncoderEnabled = false;
      paramTXSVideoEncoderParam.isH265EncoderEnabled = false;
      break;
    }
    label536:
    int i1 = 10000002;
    label540:
    if (this.f == 3)
    {
      this.l = 0.0F;
      this.m = 0.0F;
      this.n = 0.0F;
      this.o = 0;
      this.p = com.tencent.liteav.basic.d.c.a().h();
      g();
    }
    AppMethodBeat.o(14791);
    return i1;
  }
  
  public long a(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(14799);
    this.a.a();
    long l1 = 10000002L;
    while (a(this.j)) {}
    if (this.b != null)
    {
      setStatusValue(4002, Long.valueOf(d()));
      setStatusValue(4001, this.k.streamType, Double.valueOf(c()));
      if ((this.g == a.a) || (this.g == a.c)) {
        setStatusValue(8002, this.k.streamType, Integer.valueOf(e()));
      }
      l1 = this.b.pushVideoFrame(paramInt1, paramInt2, paramInt3, paramLong);
    }
    AppMethodBeat.o(14799);
    return l1;
  }
  
  public long a(final byte[] paramArrayOfByte, final int paramInt1, final int paramInt2, final int paramInt3, final long paramLong)
  {
    AppMethodBeat.i(14796);
    if (this.q == null)
    {
      AppMethodBeat.o(14796);
      return -1L;
    }
    this.r.b(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(14782);
        if ((b.b(b.this) == null) || (b.b(b.this).o() != paramInt2) || (b.b(b.this).p() != paramInt3))
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
        int i = b.b(b.this).r();
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
    if (!this.t)
    {
      this.t = true;
      synchronized (s)
      {
        StringBuilder localStringBuilder = new StringBuilder("CVGLThread");
        Integer localInteger = s;
        s = Integer.valueOf(s.intValue() + 1);
        this.r = new i(localInteger);
        ??? = new boolean[1];
        this.r.a(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(14899);
            b.a(b.this, com.tencent.liteav.basic.opengl.b.a(null, null, null, paramInt1, paramInt2));
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
          ??? = this.q.d();
          AppMethodBeat.o(14793);
          return ???;
        }
      }
      AppMethodBeat.o(14793);
      return null;
    }
    if (this.q != null)
    {
      ??? = this.q.d();
      AppMethodBeat.o(14793);
      return ???;
    }
    AppMethodBeat.o(14793);
    return null;
  }
  
  public void a()
  {
    AppMethodBeat.i(14797);
    if (this.r != null)
    {
      final com.tencent.liteav.basic.opengl.b localb = this.q;
      this.r.b(new Runnable()
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
      this.r = null;
      this.q = null;
    }
    for (;;)
    {
      if (this.f == 3)
      {
        this.l = 0.0F;
        this.m = 0.0F;
        this.n = 0.0F;
        this.o = 0;
        h();
      }
      this.c = null;
      this.e = 0;
      AppMethodBeat.o(14797);
      return;
      this.j.clear();
      if (this.b != null) {
        this.b.stop();
      }
    }
  }
  
  public void a(int paramInt)
  {
    AppMethodBeat.i(14798);
    if (this.b != null) {
      this.b.setRotation(paramInt);
    }
    AppMethodBeat.o(14798);
  }
  
  public void a(com.tencent.liteav.basic.c.b paramb)
  {
    AppMethodBeat.i(229458);
    this.d = new WeakReference(paramb);
    AppMethodBeat.o(229458);
  }
  
  public void a(final com.tencent.liteav.basic.structs.c paramc)
  {
    AppMethodBeat.i(229470);
    a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(14821);
        if (b.d(b.this) != null) {
          b.d(b.this).setThreadPriority(paramc);
        }
        AppMethodBeat.o(14821);
      }
    });
    AppMethodBeat.o(229470);
  }
  
  public void a(e parame)
  {
    AppMethodBeat.i(229461);
    this.c = parame;
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
    AppMethodBeat.o(229461);
  }
  
  protected void a(Runnable paramRunnable)
  {
    AppMethodBeat.i(14794);
    synchronized (this.j)
    {
      this.j.add(paramRunnable);
      AppMethodBeat.o(14794);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    AppMethodBeat.i(229445);
    if (this.b != null) {
      this.b.setXMirror(paramBoolean);
    }
    AppMethodBeat.o(229445);
  }
  
  public void b()
  {
    AppMethodBeat.i(229456);
    if (this.b != null) {
      this.b.restartIDR();
    }
    AppMethodBeat.o(229456);
  }
  
  public void b(boolean paramBoolean)
  {
    AppMethodBeat.i(229447);
    if (this.b != null) {
      this.b.setGLFinishedTextureNeed(paramBoolean);
    }
    AppMethodBeat.o(229447);
  }
  
  public boolean b(int paramInt)
  {
    AppMethodBeat.i(14800);
    if (this.b != null)
    {
      this.b.setFPS(paramInt);
      AppMethodBeat.o(14800);
      return true;
    }
    AppMethodBeat.o(14800);
    return false;
  }
  
  public boolean b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(14804);
    if (this.b != null)
    {
      this.e = paramInt1;
      this.b.setBitrateFromQos(paramInt1, paramInt2);
      AppMethodBeat.o(14804);
      return true;
    }
    AppMethodBeat.o(14804);
    return false;
  }
  
  public double c()
  {
    AppMethodBeat.i(229472);
    double d1 = 0.0D;
    if (this.b != null) {
      d1 = this.b.getRealFPS();
    }
    AppMethodBeat.o(229472);
    return d1;
  }
  
  public void c(int paramInt)
  {
    AppMethodBeat.i(14803);
    this.e = paramInt;
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
  
  public long d()
  {
    AppMethodBeat.i(229473);
    long l1 = 0L;
    if (this.b != null) {
      l1 = this.b.getRealBitrate();
    }
    AppMethodBeat.o(229473);
    return l1;
  }
  
  public boolean d(int paramInt)
  {
    AppMethodBeat.i(14805);
    if (this.b != null)
    {
      this.b.setEncodeIdrFpsFromQos(paramInt);
      AppMethodBeat.o(14805);
      return true;
    }
    AppMethodBeat.o(14805);
    return false;
  }
  
  public int e()
  {
    AppMethodBeat.i(229474);
    int i1 = 0;
    if (this.b != null) {
      i1 = this.b.getEncodeCost();
    }
    AppMethodBeat.o(229474);
    return i1;
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
    if (this.b != null) {
      this.b.setID(paramString);
    }
    setStatusValue(4007, Long.valueOf(this.g.a()));
    AppMethodBeat.o(14792);
  }
  
  public static enum a
  {
    private final int value;
    
    static
    {
      AppMethodBeat.i(229167);
      a = new a("HW_ENCODER_H264", 0, 1);
      b = new a("SW_ENCODER_H264", 1, 2);
      c = new a("HW_ENCODER_H265", 2, 3);
      d = new a("SW_ENCODER_H265", 3, 4);
      e = new a[] { a, b, c, d };
      AppMethodBeat.o(229167);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public final int a()
    {
      return this.value;
    }
  }
  
  static class b
    extends TimerTask
  {
    private WeakReference<b> a;
    
    public b(b paramb)
    {
      AppMethodBeat.i(229332);
      this.a = new WeakReference(paramb);
      AppMethodBeat.o(229332);
    }
    
    public void run()
    {
      AppMethodBeat.i(229341);
      if (this.a == null)
      {
        AppMethodBeat.o(229341);
        return;
      }
      b localb = (b)this.a.get();
      if (localb == null)
      {
        AppMethodBeat.o(229341);
        return;
      }
      if (b.i(localb) < b.j(localb))
      {
        int[] arrayOfInt = h.a();
        b.k(localb);
        b.a(localb, b.l(localb) + arrayOfInt[0] / 10);
        float f = b.m(localb);
        b.b(localb, arrayOfInt[1] / 10 + f);
        b.c(localb, (float)(b.n(localb) + localb.c() * 100.0D / b.g(localb).fps));
        AppMethodBeat.o(229341);
        return;
      }
      if ((com.tencent.liteav.basic.d.c.a().a(b.l(localb) / b.j(localb), b.m(localb) / b.j(localb), b.n(localb) / b.j(localb))) && (com.tencent.liteav.basic.d.c.a().d() != 0))
      {
        Monitor.a(2, "VideoEncoder: Insufficient performance, switching software encoding to hardware encoding [appCPU:" + b.l(localb) + "][sysCPU:" + b.m(localb) + "][fps:" + b.n(localb) + "][checkCount:" + b.j(localb) + "]", "", 0);
        b.o(localb);
      }
      b.p(localb);
      AppMethodBeat.o(229341);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.videoencoder.b
 * JD-Core Version:    0.7.0.1
 */