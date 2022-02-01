package com.tencent.liteav;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.liteav.basic.c.m;
import com.tencent.liteav.basic.c.n;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.util.f;
import com.tencent.liteav.capturer.a;
import com.tencent.liteav.capturer.a.a;
import com.tencent.liteav.renderer.TXCGLSurfaceView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.List;
import javax.microedition.khronos.egl.EGLContext;

public class c
  implements com.tencent.liteav.basic.b.b, n, com.tencent.liteav.capturer.b, k
{
  WeakReference<com.tencent.liteav.basic.b.b> a;
  private Context b;
  private final a c;
  private l d;
  private boolean e;
  private g f;
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
  
  public c(Context paramContext, g paramg, m paramm, boolean paramBoolean)
  {
    AppMethodBeat.i(221757);
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
    this.c = new a();
    try
    {
      this.f = ((g)paramg.clone());
      this.b = paramContext;
      this.h = paramm;
      this.h.setSurfaceTextureListener(this);
      this.f.W = paramBoolean;
      this.c.b(this.f.U);
      AppMethodBeat.o(221757);
      return;
    }
    catch (CloneNotSupportedException paramg)
    {
      for (;;)
      {
        this.f = new g();
      }
    }
  }
  
  private void a(int paramInt, String paramString)
  {
    AppMethodBeat.i(16158);
    f.a(this.a, paramInt, paramString);
    AppMethodBeat.o(16158);
  }
  
  private void a(int paramInt1, byte[] paramArrayOfByte, float[] paramArrayOfFloat, int paramInt2)
  {
    AppMethodBeat.i(221774);
    if (!this.e)
    {
      AppMethodBeat.o(221774);
      return;
    }
    if (!this.i)
    {
      Monitor.a(2, String.format("VideoCapture[%d]: capture first frame", new Object[] { Integer.valueOf(hashCode()) }), "", 0);
      f.a(this.a, 1007, "First frame capture completed");
      this.i = true;
      this.r = true;
      TXCLog.i("CameraCapture", "trtc_render: render first frame");
    }
    com.tencent.liteav.basic.structs.b localb = new com.tencent.liteav.basic.structs.b();
    localb.e = this.c.j();
    localb.f = this.c.k();
    localb.g = this.f.a;
    localb.h = this.f.b;
    localb.j = this.c.h();
    boolean bool;
    if (this.c.i()) {
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
          break label480;
        }
        localb.g = this.f.b;
      }
    }
    for (localb.h = this.f.a;; localb.h = this.f.b)
    {
      localb.l = f.a(localb.e, localb.f, this.f.b, this.f.a);
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
      AppMethodBeat.o(221774);
      return;
      bool = false;
      break;
      bool = this.f.S;
      break;
      label480:
      localb.g = this.f.a;
    }
  }
  
  private void c(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(221770);
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
          a(1003, "Enabled camera successfully");
          this.i = false;
          AppMethodBeat.o(221770);
          return;
        }
      }
      this.e = false;
      a(-1301, "Failed to open camera, please confirm whether the camera permission is turned on");
    }
    AppMethodBeat.o(221770);
  }
  
  private a.a n()
  {
    AppMethodBeat.i(221775);
    if (this.f.T)
    {
      locala = a.a.i;
      AppMethodBeat.o(221775);
      return locala;
    }
    switch (3.a[this.f.k.ordinal()])
    {
    default: 
      locala = a.a.g;
      AppMethodBeat.o(221775);
      return locala;
    case 1: 
      locala = a.a.a;
      AppMethodBeat.o(221775);
      return locala;
    case 2: 
      locala = a.a.e;
      AppMethodBeat.o(221775);
      return locala;
    case 3: 
      locala = a.a.f;
      AppMethodBeat.o(221775);
      return locala;
    case 4: 
      locala = a.a.h;
      AppMethodBeat.o(221775);
      return locala;
    }
    a.a locala = a.a.d;
    AppMethodBeat.o(221775);
    return locala;
  }
  
  private boolean o()
  {
    AppMethodBeat.i(16148);
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
            AppMethodBeat.o(16148);
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
            AppMethodBeat.o(16148);
            return true;
          }
        }
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(16148);
        return false;
      }
      label137:
      i1 += 1;
    }
  }
  
  public int a(int paramInt, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(221772);
    a(paramInt, null, paramArrayOfFloat, 4);
    AppMethodBeat.o(221772);
    return 0;
  }
  
  public void a()
  {
    boolean bool = true;
    AppMethodBeat.i(16173);
    Monitor.a(2, String.format("VideoCapture[%d]: start camera", new Object[] { Integer.valueOf(hashCode()) }), "", 0);
    TXCLog.i("CameraCapture", "start->enter with getSurfaceTexture:" + this.h.getSurfaceTexture());
    m localm = this.h;
    int i1 = this.f.h;
    if (!this.f.W) {}
    for (;;)
    {
      localm.a(i1, bool);
      c(this.h.getSurfaceTexture());
      AppMethodBeat.o(16173);
      return;
      bool = false;
    }
  }
  
  public void a(float paramFloat)
  {
    AppMethodBeat.i(16142);
    this.c.a(paramFloat);
    AppMethodBeat.o(16142);
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(16196);
    if ((this.c != null) && (this.f.K)) {
      this.c.a(paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(16196);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(16126);
    this.c.a(paramInt1, paramInt2);
    AppMethodBeat.o(16126);
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(16174);
    TXCLog.i("CameraCapture", "onSurfaceTextureAvailable->enter with mListener:" + this.d);
    c(paramSurfaceTexture);
    if (this.d != null) {
      this.d.a(paramSurfaceTexture);
    }
    AppMethodBeat.o(16174);
  }
  
  public void a(com.tencent.liteav.basic.a.c paramc)
  {
    this.f.k = paramc;
    this.r = true;
  }
  
  public void a(com.tencent.liteav.basic.b.b paramb)
  {
    AppMethodBeat.i(221764);
    this.a = new WeakReference(paramb);
    AppMethodBeat.o(221764);
  }
  
  public void a(com.tencent.liteav.basic.structs.b paramb)
  {
    AppMethodBeat.i(221761);
    if (this.h != null) {
      this.h.a(paramb.a, paramb.i, this.g, paramb.e, paramb.f, this.c.i());
    }
    AppMethodBeat.o(221761);
  }
  
  public void a(l paraml)
  {
    AppMethodBeat.i(16105);
    this.d = paraml;
    AppMethodBeat.o(16105);
  }
  
  public void a(Runnable paramRunnable)
  {
    AppMethodBeat.i(221762);
    this.h.a(paramRunnable);
    AppMethodBeat.o(221762);
  }
  
  public void a(String paramString)
  {
    AppMethodBeat.i(16137);
    this.q = paramString;
    AppMethodBeat.o(16137);
  }
  
  public void a(boolean paramBoolean)
  {
    AppMethodBeat.i(16113);
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
      AppMethodBeat.o(16113);
      return;
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(221776);
    if (this.h != null) {
      this.h.a(paramArrayOfByte);
    }
    AppMethodBeat.o(221776);
  }
  
  public void a(byte[] paramArrayOfByte, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(221773);
    a(-1, paramArrayOfByte, paramArrayOfFloat, 3);
    AppMethodBeat.o(221773);
  }
  
  public boolean a(int paramInt)
  {
    AppMethodBeat.i(221760);
    boolean bool = this.c.b(paramInt);
    AppMethodBeat.o(221760);
    return bool;
  }
  
  public void b()
  {
    AppMethodBeat.i(221758);
    TXCLog.i("CameraCapture", "startCapture->enter with getSurfaceTexture:" + this.h.getSurfaceTexture());
    c(this.h.getSurfaceTexture());
    AppMethodBeat.o(221758);
  }
  
  public void b(int paramInt)
  {
    AppMethodBeat.i(16107);
    this.g = paramInt;
    AppMethodBeat.o(16107);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(16153);
    this.f.a = paramInt1;
    this.f.b = paramInt2;
    this.r = true;
    TXCLog.i("CameraCapture", String.format("vsize setVideoEncSize w*h:%d*%d orientation:%d", new Object[] { Integer.valueOf(this.f.a), Integer.valueOf(this.f.b), Integer.valueOf(this.f.l) }));
    AppMethodBeat.o(16153);
  }
  
  public void b(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(221771);
    c();
    TXCLog.i("CameraCapture", "onSurfaceTextureDestroy->enter with mListener:" + this.d);
    if (this.d != null) {
      this.d.s();
    }
    AppMethodBeat.o(221771);
  }
  
  public void b(boolean paramBoolean)
  {
    AppMethodBeat.i(16122);
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
      ((g)localObject).m = paramBoolean;
      this.c.g();
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
      a(1003, "Enabled camera successfully");
    }
    for (;;)
    {
      this.i = false;
      AppMethodBeat.o(16122);
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
      a(-1301, "Failed to open the camera, please confirm whether the camera permission is turned on");
    }
  }
  
  public void c()
  {
    AppMethodBeat.i(221759);
    TXCLog.i("CameraCapture", "stopCapture->enter with null");
    this.c.a(null);
    this.c.g();
    this.e = false;
    AppMethodBeat.o(221759);
  }
  
  public void c(int paramInt)
  {
    AppMethodBeat.i(16108);
    if (this.h != null) {
      this.h.setRendMode(paramInt);
    }
    AppMethodBeat.o(16108);
  }
  
  public void c(final boolean paramBoolean)
  {
    AppMethodBeat.i(182264);
    a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(16669);
        c.a(c.this).S = paramBoolean;
        AppMethodBeat.o(16669);
      }
    });
    AppMethodBeat.o(182264);
  }
  
  public void d(int paramInt)
  {
    AppMethodBeat.i(16117);
    if (this.h != null) {
      this.h.setRendMirror(paramInt);
    }
    AppMethodBeat.o(16117);
  }
  
  public boolean d()
  {
    return this.e;
  }
  
  public boolean d(boolean paramBoolean)
  {
    AppMethodBeat.i(16132);
    paramBoolean = this.c.a(paramBoolean);
    AppMethodBeat.o(16132);
    return paramBoolean;
  }
  
  public int e()
  {
    AppMethodBeat.i(16109);
    int i1 = this.c.f();
    AppMethodBeat.o(16109);
    return i1;
  }
  
  public void e(int paramInt)
  {
    AppMethodBeat.i(16119);
    this.f.l = paramInt;
    this.c.c(this.f.l);
    this.r = true;
    TXCLog.i("CameraCapture", String.format("vsize setCaptureOrientation w*h:%d*%d orientation:%d", new Object[] { Integer.valueOf(this.f.a), Integer.valueOf(this.f.b), Integer.valueOf(this.f.l) }));
    AppMethodBeat.o(16119);
  }
  
  public void e(boolean paramBoolean)
  {
    AppMethodBeat.i(16138);
    this.f.U = paramBoolean;
    this.c.b(paramBoolean);
    this.r = true;
    AppMethodBeat.o(16138);
  }
  
  public EGLContext f()
  {
    AppMethodBeat.i(221763);
    EGLContext localEGLContext = this.h.getGLContext();
    AppMethodBeat.o(221763);
    return localEGLContext;
  }
  
  public void f(int paramInt)
  {
    AppMethodBeat.i(16124);
    this.f.h = paramInt;
    if (this.c != null) {
      this.c.a(paramInt);
    }
    if ((this.h != null) && ((this.h instanceof TXCGLSurfaceView))) {
      ((TXCGLSurfaceView)this.h).setFPS(paramInt);
    }
    AppMethodBeat.o(16124);
  }
  
  public int g()
  {
    return this.f.h;
  }
  
  public void g(int paramInt)
  {
    AppMethodBeat.i(16130);
    this.m = paramInt;
    AppMethodBeat.o(16130);
  }
  
  public boolean h()
  {
    AppMethodBeat.i(221765);
    if (this.c != null)
    {
      boolean bool = this.c.b();
      AppMethodBeat.o(221765);
      return bool;
    }
    AppMethodBeat.o(221765);
    return false;
  }
  
  public boolean i()
  {
    AppMethodBeat.i(221766);
    if (this.c != null)
    {
      boolean bool = this.c.c();
      AppMethodBeat.o(221766);
      return bool;
    }
    AppMethodBeat.o(221766);
    return false;
  }
  
  public boolean j()
  {
    AppMethodBeat.i(221767);
    if (this.c != null)
    {
      boolean bool = this.c.d();
      AppMethodBeat.o(221767);
      return bool;
    }
    AppMethodBeat.o(221767);
    return false;
  }
  
  public boolean k()
  {
    AppMethodBeat.i(221768);
    if (this.c != null)
    {
      boolean bool = this.c.e();
      AppMethodBeat.o(221768);
      return bool;
    }
    AppMethodBeat.o(221768);
    return false;
  }
  
  public boolean l()
  {
    AppMethodBeat.i(221769);
    if (this.c != null)
    {
      boolean bool = this.c.i();
      AppMethodBeat.o(221769);
      return bool;
    }
    AppMethodBeat.o(221769);
    return false;
  }
  
  public void m()
  {
    AppMethodBeat.i(16129);
    if (this.c.l() != null) {
      this.c.g();
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
            AppMethodBeat.i(15501);
            try
            {
              if ((c.this.d()) && (c.b(c.this)) && (c.c(c.this).l() == null))
              {
                TXCLog.w("CameraCapture", "camera monitor restart capture");
                c.c(c.this).g();
                c.d(c.this).a(false);
                c.c(c.this).a(c.a(c.this).h);
                c.c(c.this).a(c.a(c.this).W, c.a(c.this).a, c.a(c.this).b);
                c.c(c.this).a(c.d(c.this).getSurfaceTexture());
                c.c(c.this).d(c.a(c.this).m);
                AppMethodBeat.o(15501);
                return;
              }
              if (c.e(c.this) != null) {
                c.e(c.this).postDelayed(this, 2000L);
              }
              AppMethodBeat.o(15501);
              return;
            }
            catch (Exception localException)
            {
              TXCLog.w("CameraCapture", "camera monitor exception ");
              AppMethodBeat.o(15501);
            }
          }
        }, 2000L);
      }
      AppMethodBeat.o(16129);
      return;
    }
  }
  
  public void onNotifyEvent(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(16170);
    f.a(this.a, paramInt, paramBundle);
    AppMethodBeat.o(16170);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.c
 * JD-Core Version:    0.7.0.1
 */