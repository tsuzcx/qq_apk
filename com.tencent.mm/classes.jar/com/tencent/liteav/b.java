package com.tencent.liteav;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.liteav.basic.d.l;
import com.tencent.liteav.basic.d.m;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.renderer.TXCGLSurfaceView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.List;
import javax.microedition.khronos.egl.EGLContext;

public class b
  implements com.tencent.liteav.basic.c.a, m, com.tencent.liteav.capturer.b, j
{
  WeakReference<com.tencent.liteav.basic.c.a> a;
  private Context b;
  private com.tencent.liteav.capturer.a c;
  private k d;
  private boolean e;
  private f f;
  private int g;
  private boolean h;
  private int i;
  private int j;
  private l k;
  private boolean l;
  private long m;
  private long n;
  private long o;
  private int p;
  private Object q;
  private HandlerThread r;
  private Handler s;
  private String t;
  
  public b(Context paramContext, f paramf, l paraml, boolean paramBoolean)
  {
    AppMethodBeat.i(146409);
    this.c = null;
    this.g = 0;
    this.h = false;
    this.i = -1;
    this.j = -1;
    this.k = null;
    this.l = false;
    this.m = 0L;
    this.o = 0L;
    this.p = 0;
    this.q = new Object();
    this.r = null;
    this.s = null;
    this.t = "";
    this.c = new com.tencent.liteav.capturer.a();
    try
    {
      this.f = ((f)paramf.clone());
      this.b = paramContext;
      this.k = paraml;
      this.k.setSurfaceTextureListener(this);
      this.f.P = paramBoolean;
      AppMethodBeat.o(146409);
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
    AppMethodBeat.i(67676);
    com.tencent.liteav.basic.util.b.a(this.a, paramInt, paramString);
    AppMethodBeat.o(67676);
  }
  
  private void a(int paramInt1, byte[] paramArrayOfByte, float[] paramArrayOfFloat, int paramInt2)
  {
    boolean bool = true;
    AppMethodBeat.i(146416);
    if (!this.e)
    {
      AppMethodBeat.o(146416);
      return;
    }
    if (!this.l)
    {
      com.tencent.liteav.basic.util.b.a(this.a, 1007, "首帧画面采集完成");
      this.l = true;
      TXCLog.d("CameraCapture", "trtc_render: render first frame");
    }
    com.tencent.liteav.basic.structs.b localb = new com.tencent.liteav.basic.structs.b();
    localb.e = this.c.e();
    localb.f = this.c.f();
    localb.g = this.f.a;
    localb.h = this.f.b;
    localb.j = this.c.c();
    localb.k = this.g;
    if (this.c.d()) {
      if (!this.f.M)
      {
        localb.i = bool;
        localb.a = paramInt1;
        localb.c = paramArrayOfFloat;
        localb.d = this.f.P;
        localb.m = paramArrayOfByte;
        localb.b = paramInt2;
        if ((localb.j != 0) && (localb.j != 180)) {
          break label399;
        }
        localb.g = this.f.b;
      }
    }
    for (localb.h = this.f.a;; localb.h = this.f.b)
    {
      localb.l = com.tencent.liteav.basic.util.b.a(localb.e, localb.f, this.f.b, this.f.a);
      if (this.d != null) {
        this.d.b(localb);
      }
      this.m += 1L;
      long l1 = System.currentTimeMillis() - this.n;
      if (l1 >= 1000L)
      {
        double d1 = (this.m - this.o) * 1000.0D / l1;
        TXCStatus.a(this.t, 1001, this.p, Double.valueOf(d1));
        this.o = this.m;
        this.n = (l1 + this.n);
      }
      AppMethodBeat.o(146416);
      return;
      bool = false;
      break;
      bool = this.f.M;
      break;
      label399:
      localb.g = this.f.a;
    }
  }
  
  private void c(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(67675);
    if ((paramSurfaceTexture != null) && (!this.e) && (this.c != null))
    {
      this.c.a(this);
      this.c.a(paramSurfaceTexture);
      this.c.b(this.f.h);
      this.c.d(this.f.l);
      this.c.b(this.f.E);
      this.c.a(i());
      this.c.a(this.f.P, this.f.a, this.f.b);
      if (this.c.c(this.f.m) == 0)
      {
        this.e = true;
        this.n = System.currentTimeMillis();
        a(1003, "打开摄像头成功");
        this.l = false;
        if ((this.h) && (!com.tencent.liteav.audio.b.a().c()))
        {
          if (com.tencent.liteav.audio.b.a().a(this.b) == 0) {
            a(2027, "打开麦克风成功");
          }
          this.h = false;
          AppMethodBeat.o(67675);
        }
      }
      else
      {
        this.e = false;
        a(-1301, "打开摄像头失败，请确认摄像头权限是否打开");
      }
    }
    AppMethodBeat.o(67675);
  }
  
  private int i()
  {
    if (!this.f.N) {}
    switch (this.f.k)
    {
    case 3: 
    case 4: 
    case 5: 
    default: 
      return 7;
    case 0: 
      return 4;
    case 1: 
      return 5;
    case 2: 
      return 6;
    }
    return 3;
  }
  
  private void j()
  {
    AppMethodBeat.i(146417);
    a(new b.2(this));
    AppMethodBeat.o(146417);
  }
  
  private boolean k()
  {
    AppMethodBeat.i(146419);
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
            AppMethodBeat.o(146419);
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
            AppMethodBeat.o(146419);
            return true;
          }
        }
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(146419);
        return false;
      }
      label137:
      i1 += 1;
    }
  }
  
  public int a(int paramInt, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(67679);
    a(paramInt, null, paramArrayOfFloat, 4);
    AppMethodBeat.o(67679);
    return 0;
  }
  
  public void a()
  {
    AppMethodBeat.i(67656);
    TXCLog.i("CameraCapture", "start->enter with getSurfaceTexture:" + this.k.getSurfaceTexture());
    l locall = this.k;
    int i1 = this.f.h;
    if (!this.f.P) {}
    for (boolean bool = true;; bool = false)
    {
      locall.a(i1, bool);
      c(this.k.getSurfaceTexture());
      AppMethodBeat.o(67656);
      return;
    }
  }
  
  public void a(float paramFloat)
  {
    AppMethodBeat.i(67663);
    this.c.a(paramFloat);
    AppMethodBeat.o(67663);
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(67674);
    if ((this.c != null) && (this.f.E)) {
      this.c.a(paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(67674);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.f.a = paramInt1;
    this.f.b = paramInt2;
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(67677);
    TXCLog.i("CameraCapture", "onSurfaceTextureAvailable->enter with mListener:" + this.d);
    c(paramSurfaceTexture);
    if (this.d != null) {
      this.d.a(paramSurfaceTexture);
    }
    AppMethodBeat.o(67677);
  }
  
  public void a(com.tencent.liteav.basic.c.a parama)
  {
    AppMethodBeat.i(146411);
    this.a = new WeakReference(parama);
    AppMethodBeat.o(146411);
  }
  
  public void a(com.tencent.liteav.basic.structs.b paramb)
  {
    AppMethodBeat.i(146410);
    if (this.k != null) {
      this.k.a(paramb.a, paramb.i, this.g, paramb.e, paramb.f, this.c.d());
    }
    AppMethodBeat.o(146410);
  }
  
  public void a(k paramk)
  {
    this.d = paramk;
  }
  
  public void a(Runnable paramRunnable)
  {
    AppMethodBeat.i(67668);
    this.k.a(paramRunnable);
    AppMethodBeat.o(67668);
  }
  
  public void a(String paramString)
  {
    this.t = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    AppMethodBeat.i(67657);
    c();
    this.k.a();
    synchronized (this.q)
    {
      if (this.s != null) {
        this.s.removeCallbacksAndMessages(null);
      }
      if (this.r != null)
      {
        TXCLog.w("CameraCapture", "stop camera monitor ");
        this.r.quit();
        this.r = null;
        this.s = null;
      }
      AppMethodBeat.o(67657);
      return;
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(146418);
    if (this.k != null) {
      this.k.a(paramArrayOfByte);
    }
    AppMethodBeat.o(146418);
  }
  
  public void a(byte[] paramArrayOfByte, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(146415);
    a(-1, paramArrayOfByte, paramArrayOfFloat, 3);
    AppMethodBeat.o(146415);
  }
  
  public boolean a(int paramInt)
  {
    AppMethodBeat.i(67662);
    boolean bool = this.c.c(paramInt);
    AppMethodBeat.o(67662);
    return bool;
  }
  
  public void b()
  {
    AppMethodBeat.i(67658);
    TXCLog.i("CameraCapture", "startCapture->enter with getSurfaceTexture:" + this.k.getSurfaceTexture());
    c(this.k.getSurfaceTexture());
    AppMethodBeat.o(67658);
  }
  
  public void b(int paramInt)
  {
    AppMethodBeat.i(67664);
    this.i = paramInt;
    j();
    AppMethodBeat.o(67664);
  }
  
  public void b(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(67678);
    TXCLog.i("CameraCapture", "onSurfaceTextureDestroy->enter with mListener:" + this.d);
    if (this.d != null) {
      this.d.u();
    }
    AppMethodBeat.o(67678);
  }
  
  public void b(boolean paramBoolean)
  {
    AppMethodBeat.i(67660);
    if ((this.e) && (this.c != null))
    {
      f localf = this.f;
      if (!paramBoolean) {
        break label188;
      }
      if (this.f.m) {
        break label183;
      }
      paramBoolean = true;
      localf.m = paramBoolean;
      this.c.b();
      this.k.a(false);
      this.c.b(this.f.h);
      this.c.a(i());
      this.c.a(this.f.P, this.f.a, this.f.b);
      this.c.a(this);
      this.c.a(this.k.getSurfaceTexture());
      if (this.c.c(this.f.m) != 0) {
        break label199;
      }
      this.e = true;
      a(1003, "打开摄像头成功");
    }
    for (;;)
    {
      this.l = false;
      AppMethodBeat.o(67660);
      return;
      label183:
      paramBoolean = false;
      break;
      label188:
      paramBoolean = this.f.m;
      break;
      label199:
      this.e = false;
      a(-1301, "打开摄像头失败，请确认摄像头权限是否打开");
    }
  }
  
  public void c()
  {
    AppMethodBeat.i(67659);
    TXCLog.i("CameraCapture", "stopCapture->enter with null");
    this.c.a(null);
    this.c.b();
    this.e = false;
    AppMethodBeat.o(67659);
  }
  
  public void c(int paramInt)
  {
    AppMethodBeat.i(67672);
    if (this.k != null) {
      this.k.setRendMode(paramInt);
    }
    AppMethodBeat.o(67672);
  }
  
  public void c(boolean paramBoolean)
  {
    AppMethodBeat.i(67665);
    a(new b.1(this, paramBoolean));
    AppMethodBeat.o(67665);
  }
  
  public void d(int paramInt)
  {
    AppMethodBeat.i(67673);
    if (this.k != null) {
      this.k.setRendMirror(paramInt);
    }
    AppMethodBeat.o(67673);
  }
  
  public boolean d()
  {
    return this.e;
  }
  
  public boolean d(boolean paramBoolean)
  {
    AppMethodBeat.i(67666);
    paramBoolean = this.c.a(paramBoolean);
    AppMethodBeat.o(67666);
    return paramBoolean;
  }
  
  public int e()
  {
    AppMethodBeat.i(67661);
    int i1 = this.c.a();
    AppMethodBeat.o(67661);
    return i1;
  }
  
  public void e(int paramInt)
  {
    AppMethodBeat.i(146412);
    this.j = paramInt;
    j();
    AppMethodBeat.o(146412);
  }
  
  public void e(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public EGLContext f()
  {
    AppMethodBeat.i(67669);
    EGLContext localEGLContext = this.k.getGLContext();
    AppMethodBeat.o(67669);
    return localEGLContext;
  }
  
  public void f(int paramInt)
  {
    AppMethodBeat.i(146413);
    this.f.h = paramInt;
    if (this.c != null) {
      this.c.b(paramInt);
    }
    if ((this.k != null) && ((this.k instanceof TXCGLSurfaceView))) {
      ((TXCGLSurfaceView)this.k).setFPS(paramInt);
    }
    AppMethodBeat.o(146413);
  }
  
  public void g(int paramInt)
  {
    this.p = paramInt;
  }
  
  public boolean g()
  {
    AppMethodBeat.i(146414);
    if (this.c != null)
    {
      boolean bool = this.c.d();
      AppMethodBeat.o(146414);
      return bool;
    }
    AppMethodBeat.o(146414);
    return false;
  }
  
  public void h()
  {
    AppMethodBeat.i(67680);
    if (this.c.g() != null) {
      this.c.b();
    }
    synchronized (this.q)
    {
      if (this.r == null)
      {
        this.r = new HandlerThread("cameraMonitorThread");
        this.r.start();
        this.s = new Handler(this.r.getLooper());
        TXCLog.w("CameraCapture", "start camera monitor ");
      }
      if (this.s != null) {
        this.s.postDelayed(new b.3(this), 2000L);
      }
      AppMethodBeat.o(67680);
      return;
    }
  }
  
  public void onNotifyEvent(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(67670);
    com.tencent.liteav.basic.util.b.a(this.a, paramInt, paramBundle);
    AppMethodBeat.o(67670);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.liteav.b
 * JD-Core Version:    0.7.0.1
 */