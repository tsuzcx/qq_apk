package com.tencent.liteav;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.liteav.basic.a.c;
import com.tencent.liteav.basic.d.m;
import com.tencent.liteav.basic.d.n;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.capturer.a.a;
import com.tencent.liteav.renderer.TXCGLSurfaceView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.List;
import javax.microedition.khronos.egl.EGLContext;

public class b
  implements com.tencent.liteav.basic.c.a, n, com.tencent.liteav.capturer.b, j
{
  WeakReference<com.tencent.liteav.basic.c.a> a;
  private Context b;
  private final com.tencent.liteav.capturer.a c;
  private k d;
  private boolean e;
  private f f;
  private int g;
  private m h;
  private boolean i;
  private long j;
  private long k;
  private long l;
  private int m;
  private Object n;
  private HandlerThread o;
  private Handler p;
  private String q;
  private boolean r;
  
  public b(Context paramContext, f paramf, m paramm, boolean paramBoolean)
  {
    AppMethodBeat.i(187212);
    this.g = 0;
    this.h = null;
    this.i = false;
    this.j = 0L;
    this.l = 0L;
    this.m = 0;
    this.n = new Object();
    this.o = null;
    this.p = null;
    this.q = "";
    this.r = true;
    this.c = new com.tencent.liteav.capturer.a();
    try
    {
      this.f = ((f)paramf.clone());
      this.b = paramContext;
      this.h = paramm;
      this.h.setSurfaceTextureListener(this);
      this.f.W = paramBoolean;
      this.c.b(this.f.U);
      AppMethodBeat.o(187212);
      return;
    }
    catch (CloneNotSupportedException paramf)
    {
      for (;;)
      {
        this.f = new f();
      }
    }
  }
  
  private void a(int paramInt, String paramString)
  {
    AppMethodBeat.i(16719);
    com.tencent.liteav.basic.util.f.a(this.a, paramInt, paramString);
    AppMethodBeat.o(16719);
  }
  
  private void a(int paramInt1, byte[] paramArrayOfByte, float[] paramArrayOfFloat, int paramInt2)
  {
    AppMethodBeat.i(16724);
    if (!this.e)
    {
      AppMethodBeat.o(16724);
      return;
    }
    if (!this.i)
    {
      Monitor.a(2, String.format("VideoCapture[%d]: capture first frame", new Object[] { Integer.valueOf(hashCode()) }), "", 0);
      com.tencent.liteav.basic.util.f.a(this.a, 1007, "首帧画面采集完成");
      this.i = true;
      this.r = true;
      TXCLog.i("CameraCapture", "trtc_render: render first frame");
    }
    com.tencent.liteav.basic.structs.b localb = new com.tencent.liteav.basic.structs.b();
    localb.e = this.c.i();
    localb.f = this.c.j();
    localb.g = this.f.a;
    localb.h = this.f.b;
    localb.j = this.c.g();
    boolean bool;
    if (this.c.h()) {
      if (!this.f.S)
      {
        bool = true;
        localb.i = bool;
        localb.a = paramInt1;
        localb.c = paramArrayOfFloat;
        localb.d = this.f.W;
        localb.m = paramArrayOfByte;
        localb.b = paramInt2;
        if ((localb.j != 0) && (localb.j != 180)) {
          break label483;
        }
        localb.g = this.f.b;
      }
    }
    for (localb.h = this.f.a;; localb.h = this.f.b)
    {
      localb.l = com.tencent.liteav.basic.util.f.a(localb.e, localb.f, this.f.b, this.f.a);
      if (this.d != null) {
        this.d.b(localb);
      }
      if (this.r)
      {
        this.r = false;
        TXCLog.i("CameraCapture", String.format("vsize onCaptureFrame w*h:%d*%d angle:%d", new Object[] { Integer.valueOf(localb.g), Integer.valueOf(localb.h), Integer.valueOf(localb.j) }));
      }
      this.j += 1L;
      long l1 = System.currentTimeMillis() - this.k;
      if (l1 >= 1000L)
      {
        double d1 = (this.j - this.l) * 1000.0D / l1;
        TXCStatus.a(this.q, 1001, this.m, Double.valueOf(d1));
        this.l = this.j;
        this.k = (l1 + this.k);
      }
      AppMethodBeat.o(16724);
      return;
      bool = false;
      break;
      bool = this.f.S;
      break;
      label483:
      localb.g = this.f.a;
    }
  }
  
  private void c(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(16718);
    if ((paramSurfaceTexture != null) && (!this.e) && (this.c != null))
    {
      this.c.a(this);
      this.c.a(paramSurfaceTexture);
      this.c.a(this.f.h);
      this.c.c(this.f.l);
      this.c.c(this.f.K);
      this.c.a(n());
      this.c.a(this.f.W, this.f.a, this.f.b);
      TXCLog.i("CameraCapture", String.format("vsize startCapture w*h:%d*%d orientation:%d", new Object[] { Integer.valueOf(this.f.a), Integer.valueOf(this.f.b), Integer.valueOf(this.f.l) }));
      if (this.c.d(this.f.m) == 0)
      {
        this.e = true;
        this.k = System.currentTimeMillis();
        int i1 = hashCode();
        if (this.f.m) {}
        for (paramSurfaceTexture = "front";; paramSurfaceTexture = "back")
        {
          Monitor.a(2, String.format("VideoCapture[%d]: start %s camera successfully", new Object[] { Integer.valueOf(i1), paramSurfaceTexture }), "", 0);
          a(1003, "打开摄像头成功");
          this.i = false;
          AppMethodBeat.o(16718);
          return;
        }
      }
      this.e = false;
      a(-1301, "打开摄像头失败，请确认摄像头权限是否打开");
    }
    AppMethodBeat.o(16718);
  }
  
  private a.a n()
  {
    AppMethodBeat.i(187213);
    if (this.f.T)
    {
      locala = a.a.i;
      AppMethodBeat.o(187213);
      return locala;
    }
    switch (3.a[this.f.k.ordinal()])
    {
    default: 
      locala = a.a.g;
      AppMethodBeat.o(187213);
      return locala;
    case 1: 
      locala = a.a.a;
      AppMethodBeat.o(187213);
      return locala;
    case 2: 
      locala = a.a.e;
      AppMethodBeat.o(187213);
      return locala;
    case 3: 
      locala = a.a.f;
      AppMethodBeat.o(187213);
      return locala;
    case 4: 
      locala = a.a.h;
      AppMethodBeat.o(187213);
      return locala;
    }
    a.a locala = a.a.d;
    AppMethodBeat.o(187213);
    return locala;
  }
  
  private boolean o()
  {
    AppMethodBeat.i(16727);
    for (;;)
    {
      int i1;
      try
      {
        if (this.b != null)
        {
          List localList = ((ActivityManager)this.b.getSystemService("activity")).getRunningAppProcesses();
          if (localList == null)
          {
            TXCLog.w("CameraCapture", "List of RunningAppProcessInfo is null");
            AppMethodBeat.o(16727);
            return false;
          }
          i1 = 0;
          if (i1 < localList.size())
          {
            ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localList.get(i1);
            if (localRunningAppProcessInfo == null)
            {
              TXCLog.w("CameraCapture", "ActivityManager.RunningAppProcessInfo is null");
              break label137;
            }
            if (!localRunningAppProcessInfo.processName.equals(this.b.getPackageName())) {
              break label137;
            }
            int i2 = localRunningAppProcessInfo.importance;
            if (i2 != 100) {
              break label137;
            }
            AppMethodBeat.o(16727);
            return true;
          }
        }
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(16727);
        return false;
      }
      label137:
      i1 += 1;
    }
  }
  
  public int a(int paramInt, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(16722);
    a(paramInt, null, paramArrayOfFloat, 4);
    AppMethodBeat.o(16722);
    return 0;
  }
  
  public void a()
  {
    boolean bool = true;
    AppMethodBeat.i(16691);
    Monitor.a(2, String.format("VideoCapture[%d]: start camera", new Object[] { Integer.valueOf(hashCode()) }), "", 0);
    TXCLog.i("CameraCapture", "start->enter with getSurfaceTexture:" + this.h.getSurfaceTexture());
    m localm = this.h;
    int i1 = this.f.h;
    if (!this.f.W) {}
    for (;;)
    {
      localm.a(i1, bool);
      c(this.h.getSurfaceTexture());
      AppMethodBeat.o(16691);
      return;
      bool = false;
    }
  }
  
  public void a(float paramFloat)
  {
    AppMethodBeat.i(16699);
    this.c.a(paramFloat);
    AppMethodBeat.o(16699);
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(16712);
    if ((this.c != null) && (this.f.K)) {
      this.c.a(paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(16712);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(16698);
    this.c.a(paramInt1, paramInt2);
    AppMethodBeat.o(16698);
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(16720);
    TXCLog.i("CameraCapture", "onSurfaceTextureAvailable->enter with mListener:" + this.d);
    c(paramSurfaceTexture);
    if (this.d != null) {
      this.d.a(paramSurfaceTexture);
    }
    AppMethodBeat.o(16720);
  }
  
  public void a(c paramc)
  {
    this.f.k = paramc;
    this.r = true;
  }
  
  public void a(com.tencent.liteav.basic.c.a parama)
  {
    AppMethodBeat.i(16708);
    this.a = new WeakReference(parama);
    AppMethodBeat.o(16708);
  }
  
  public void a(com.tencent.liteav.basic.structs.b paramb)
  {
    AppMethodBeat.i(16704);
    if (this.h != null) {
      this.h.a(paramb.a, paramb.i, this.g, paramb.e, paramb.f, this.c.h());
    }
    AppMethodBeat.o(16704);
  }
  
  public void a(k paramk)
  {
    this.d = paramk;
  }
  
  public void a(Runnable paramRunnable)
  {
    AppMethodBeat.i(16705);
    this.h.a(paramRunnable);
    AppMethodBeat.o(16705);
  }
  
  public void a(String paramString)
  {
    this.q = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    AppMethodBeat.i(16692);
    Monitor.a(2, String.format("VideoCapture[%d]: stop camera", new Object[] { Integer.valueOf(hashCode()) }), "", 0);
    c();
    this.h.a();
    synchronized (this.n)
    {
      if (this.p != null) {
        this.p.removeCallbacksAndMessages(null);
      }
      if (this.o != null)
      {
        TXCLog.w("CameraCapture", "stop camera monitor ");
        this.o.quit();
        this.o = null;
        this.p = null;
      }
      AppMethodBeat.o(16692);
      return;
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(16725);
    if (this.h != null) {
      this.h.a(paramArrayOfByte);
    }
    AppMethodBeat.o(16725);
  }
  
  public void a(byte[] paramArrayOfByte, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(16723);
    a(-1, paramArrayOfByte, paramArrayOfFloat, 3);
    AppMethodBeat.o(16723);
  }
  
  public boolean a(int paramInt)
  {
    AppMethodBeat.i(16697);
    boolean bool = this.c.b(paramInt);
    AppMethodBeat.o(16697);
    return bool;
  }
  
  public void b()
  {
    AppMethodBeat.i(16693);
    TXCLog.i("CameraCapture", "startCapture->enter with getSurfaceTexture:" + this.h.getSurfaceTexture());
    c(this.h.getSurfaceTexture());
    AppMethodBeat.o(16693);
  }
  
  public void b(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(16710);
    this.f.a = paramInt1;
    this.f.b = paramInt2;
    this.r = true;
    TXCLog.i("CameraCapture", String.format("vsize setVideoEncSize w*h:%d*%d orientation:%d", new Object[] { Integer.valueOf(this.f.a), Integer.valueOf(this.f.b), Integer.valueOf(this.f.l) }));
    AppMethodBeat.o(16710);
  }
  
  public void b(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(16721);
    c();
    TXCLog.i("CameraCapture", "onSurfaceTextureDestroy->enter with mListener:" + this.d);
    if (this.d != null) {
      this.d.s();
    }
    AppMethodBeat.o(16721);
  }
  
  public void b(boolean paramBoolean)
  {
    AppMethodBeat.i(16695);
    Object localObject;
    if ((this.e) && (this.c != null))
    {
      localObject = this.f;
      if (!paramBoolean) {
        break label304;
      }
      if (this.f.m) {
        break label299;
      }
      paramBoolean = true;
      ((f)localObject).m = paramBoolean;
      this.c.f();
      this.h.a(false);
      this.c.a(this.f.h);
      this.c.c(this.f.l);
      this.c.a(n());
      this.c.a(this.f.W, this.f.a, this.f.b);
      this.c.a(this);
      this.c.a(this.h.getSurfaceTexture());
      TXCLog.i("CameraCapture", String.format("vsize refreshCapture w*h:%d*%d orientation:%d", new Object[] { Integer.valueOf(this.f.a), Integer.valueOf(this.f.b), Integer.valueOf(this.f.l) }));
      if (this.c.d(this.f.m) != 0) {
        break label322;
      }
      this.e = true;
      int i1 = hashCode();
      if (!this.f.m) {
        break label315;
      }
      localObject = "front";
      label249:
      Monitor.a(2, String.format("VideoCapture[%d]: start %s camera successfully", new Object[] { Integer.valueOf(i1), localObject }), "", 0);
      a(1003, "打开摄像头成功");
    }
    for (;;)
    {
      this.i = false;
      AppMethodBeat.o(16695);
      return;
      label299:
      paramBoolean = false;
      break;
      label304:
      paramBoolean = this.f.m;
      break;
      label315:
      localObject = "back";
      break label249;
      label322:
      this.e = false;
      a(-1301, "打开摄像头失败，请确认摄像头权限是否打开");
    }
  }
  
  public void c()
  {
    AppMethodBeat.i(16694);
    TXCLog.i("CameraCapture", "stopCapture->enter with null");
    this.c.a(null);
    this.c.f();
    this.e = false;
    AppMethodBeat.o(16694);
  }
  
  public void c(int paramInt)
  {
    AppMethodBeat.i(16700);
    if (this.h != null) {
      this.h.setRendMode(paramInt);
    }
    AppMethodBeat.o(16700);
  }
  
  public void c(final boolean paramBoolean)
  {
    AppMethodBeat.i(16702);
    a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(14900);
        b.a(b.this).S = paramBoolean;
        AppMethodBeat.o(14900);
      }
    });
    AppMethodBeat.o(16702);
  }
  
  public void d(int paramInt)
  {
    AppMethodBeat.i(16701);
    if (this.h != null) {
      this.h.setRendMirror(paramInt);
    }
    AppMethodBeat.o(16701);
  }
  
  public boolean d()
  {
    return this.e;
  }
  
  public boolean d(boolean paramBoolean)
  {
    AppMethodBeat.i(16703);
    paramBoolean = this.c.a(paramBoolean);
    AppMethodBeat.o(16703);
    return paramBoolean;
  }
  
  public int e()
  {
    AppMethodBeat.i(16696);
    int i1 = this.c.e();
    AppMethodBeat.o(16696);
    return i1;
  }
  
  public void e(int paramInt)
  {
    AppMethodBeat.i(16709);
    this.f.l = paramInt;
    this.c.c(this.f.l);
    this.r = true;
    TXCLog.i("CameraCapture", String.format("vsize setCaptureOrientation w*h:%d*%d orientation:%d", new Object[] { Integer.valueOf(this.f.a), Integer.valueOf(this.f.b), Integer.valueOf(this.f.l) }));
    AppMethodBeat.o(16709);
  }
  
  public void e(boolean paramBoolean)
  {
    AppMethodBeat.i(187214);
    this.f.U = paramBoolean;
    this.c.b(paramBoolean);
    this.r = true;
    AppMethodBeat.o(187214);
  }
  
  public EGLContext f()
  {
    AppMethodBeat.i(16706);
    EGLContext localEGLContext = this.h.getGLContext();
    AppMethodBeat.o(16706);
    return localEGLContext;
  }
  
  public void f(int paramInt)
  {
    AppMethodBeat.i(16711);
    this.f.h = paramInt;
    if (this.c != null) {
      this.c.a(paramInt);
    }
    if ((this.h != null) && ((this.h instanceof TXCGLSurfaceView))) {
      ((TXCGLSurfaceView)this.h).setFPS(paramInt);
    }
    AppMethodBeat.o(16711);
  }
  
  public int g()
  {
    return this.f.h;
  }
  
  public void g(int paramInt)
  {
    this.m = paramInt;
  }
  
  public boolean h()
  {
    AppMethodBeat.i(16713);
    if (this.c != null)
    {
      boolean bool = this.c.a();
      AppMethodBeat.o(16713);
      return bool;
    }
    AppMethodBeat.o(16713);
    return false;
  }
  
  public boolean i()
  {
    AppMethodBeat.i(16714);
    if (this.c != null)
    {
      boolean bool = this.c.b();
      AppMethodBeat.o(16714);
      return bool;
    }
    AppMethodBeat.o(16714);
    return false;
  }
  
  public boolean j()
  {
    AppMethodBeat.i(16715);
    if (this.c != null)
    {
      boolean bool = this.c.c();
      AppMethodBeat.o(16715);
      return bool;
    }
    AppMethodBeat.o(16715);
    return false;
  }
  
  public boolean k()
  {
    AppMethodBeat.i(16716);
    if (this.c != null)
    {
      boolean bool = this.c.d();
      AppMethodBeat.o(16716);
      return bool;
    }
    AppMethodBeat.o(16716);
    return false;
  }
  
  public boolean l()
  {
    AppMethodBeat.i(16717);
    if (this.c != null)
    {
      boolean bool = this.c.h();
      AppMethodBeat.o(16717);
      return bool;
    }
    AppMethodBeat.o(16717);
    return false;
  }
  
  public void m()
  {
    AppMethodBeat.i(16726);
    if (this.c.k() != null) {
      this.c.f();
    }
    synchronized (this.n)
    {
      if (this.o == null)
      {
        this.o = new HandlerThread("cameraMonitorThread");
        this.o.start();
        this.p = new Handler(this.o.getLooper());
        TXCLog.w("CameraCapture", "start camera monitor ");
      }
      if (this.p != null) {
        this.p.postDelayed(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(14379);
            try
            {
              if ((b.this.d()) && (b.b(b.this)) && (b.c(b.this).k() == null))
              {
                TXCLog.w("CameraCapture", "camera monitor restart capture");
                b.c(b.this).f();
                b.d(b.this).a(false);
                b.c(b.this).a(b.a(b.this).h);
                b.c(b.this).a(b.a(b.this).W, b.a(b.this).a, b.a(b.this).b);
                b.c(b.this).a(b.d(b.this).getSurfaceTexture());
                b.c(b.this).d(b.a(b.this).m);
                AppMethodBeat.o(14379);
                return;
              }
              if (b.e(b.this) != null) {
                b.e(b.this).postDelayed(this, 2000L);
              }
              AppMethodBeat.o(14379);
              return;
            }
            catch (Exception localException)
            {
              TXCLog.w("CameraCapture", "camera monitor exception ");
              AppMethodBeat.o(14379);
            }
          }
        }, 2000L);
      }
      AppMethodBeat.o(16726);
      return;
    }
  }
  
  public void onNotifyEvent(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(16707);
    com.tencent.liteav.basic.util.f.a(this.a, paramInt, paramBundle);
    AppMethodBeat.o(16707);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.b
 * JD-Core Version:    0.7.0.1
 */