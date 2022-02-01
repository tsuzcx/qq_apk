package com.tencent.matrix.trace;

import android.app.Application;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.tracer.SignalAnrTracer;
import com.tencent.matrix.trace.tracer.ThreadPriorityTracer;
import com.tencent.matrix.trace.tracer.TouchEventLagTracer;
import com.tencent.matrix.trace.tracer.d;
import com.tencent.matrix.trace.tracer.e;

public class b
  extends com.tencent.matrix.d.b
{
  private static boolean fdx;
  public final com.tencent.matrix.trace.a.b fdo;
  public com.tencent.matrix.trace.tracer.a fdp;
  public com.tencent.matrix.trace.tracer.f fdq;
  public com.tencent.matrix.trace.tracer.b fdr;
  public e fds;
  private SignalAnrTracer fdt;
  private d fdu;
  private TouchEventLagTracer fdv;
  private ThreadPriorityTracer fdw;
  
  public b(com.tencent.matrix.trace.a.b paramb)
  {
    this.fdo = paramb;
  }
  
  public static AppMethodBeat azC()
  {
    return AppMethodBeat.getInstance();
  }
  
  public void destroy()
  {
    super.destroy();
  }
  
  public String getTag()
  {
    return "Trace";
  }
  
  public void init(Application paramApplication, com.tencent.matrix.d.c paramc)
  {
    super.init(paramApplication, paramc);
    com.tencent.matrix.e.c.i("Matrix.TracePlugin", "trace plugin init, trace config: %s", new Object[] { this.fdo.toString() });
    int i = Build.VERSION.SDK_INT;
    if (i < 16)
    {
      com.tencent.matrix.e.c.e("Matrix.TracePlugin", "[FrameBeat] API is low Build.VERSION_CODES.JELLY_BEAN(16), TracePlugin is not supported", new Object[0]);
      unSupportPlugin();
      return;
    }
    if (i >= 26) {
      fdx = true;
    }
    this.fds = new e(this.fdo);
    this.fdr = new com.tencent.matrix.trace.tracer.b(this.fdo, fdx);
    this.fdp = new com.tencent.matrix.trace.tracer.a(this.fdo);
    this.fdq = new com.tencent.matrix.trace.tracer.f(this.fdo);
  }
  
  public void onForeground(boolean paramBoolean)
  {
    super.onForeground(paramBoolean);
    if (!isSupported()) {}
    do
    {
      return;
      if (this.fdr != null) {
        this.fdr.onForeground(paramBoolean);
      }
      if (this.fds != null) {
        this.fds.onForeground(paramBoolean);
      }
      if (this.fdp != null) {
        this.fdp.onForeground(paramBoolean);
      }
    } while (this.fdq == null);
    this.fdq.onForeground(paramBoolean);
  }
  
  public void start()
  {
    super.start();
    if (!isSupported())
    {
      com.tencent.matrix.e.c.w("Matrix.TracePlugin", "[start] Plugin is unSupported!", new Object[0]);
      return;
    }
    com.tencent.matrix.e.c.w("Matrix.TracePlugin", "start!", new Object[0]);
    Runnable local1 = new Runnable()
    {
      public final void run()
      {
        boolean bool1;
        label92:
        boolean bool2;
        label347:
        label357:
        boolean bool3;
        label367:
        boolean bool4;
        label378:
        boolean bool5;
        label389:
        boolean bool6;
        if ((b.a(b.a(b.this))) && (!com.tencent.matrix.trace.core.b.azL().isInit))
        {
          com.tencent.matrix.trace.a.b localb1;
          try
          {
            com.tencent.matrix.trace.core.b localb = com.tencent.matrix.trace.core.b.azL();
            localb1 = b.a(b.this);
            bool1 = b.ayB();
            localb.fdU = localb1;
            com.tencent.matrix.trace.core.b.feF = bool1;
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
              break label92;
            }
            throw new AssertionError("must be init in main thread!");
          }
          catch (RuntimeException localRuntimeException)
          {
            com.tencent.matrix.e.c.e("Matrix.TracePlugin", "[start] RuntimeException:%s", new Object[] { localRuntimeException });
          }
          return;
          com.tencent.matrix.trace.core.a.a(new com.tencent.matrix.trace.core.b.1(localRuntimeException, localb1.fdT, localb1.eLL));
          localRuntimeException.isInit = true;
          localRuntimeException.eLi = ((Long)com.tencent.matrix.e.f.c(localRuntimeException.choreographer, "mFrameIntervalNanos", Long.valueOf(16666667L))).longValue();
          if (!com.tencent.matrix.trace.core.b.feF)
          {
            localRuntimeException.choreographer = Choreographer.getInstance();
            localRuntimeException.feG = com.tencent.matrix.e.f.c(localRuntimeException.choreographer, "mLock", new Object());
            localRuntimeException.feH = ((Object[])com.tencent.matrix.e.f.c(localRuntimeException.choreographer, "mCallbackQueues", null));
            if (localRuntimeException.feH != null)
            {
              localRuntimeException.feJ = com.tencent.matrix.e.f.c(localRuntimeException.feH[0], "addCallbackLocked", new Class[] { Long.TYPE, Object.class, Object.class });
              localRuntimeException.feK = com.tencent.matrix.e.f.c(localRuntimeException.feH[1], "addCallbackLocked", new Class[] { Long.TYPE, Object.class, Object.class });
              localRuntimeException.feI = com.tencent.matrix.e.f.c(localRuntimeException.feH[2], "addCallbackLocked", new Class[] { Long.TYPE, Object.class, Object.class });
            }
            localRuntimeException.feL = com.tencent.matrix.e.f.c(localRuntimeException.choreographer, "mDisplayEventReceiver", null);
            if (localRuntimeException.feG != null) {
              break label788;
            }
            bool1 = true;
            if (localRuntimeException.feH != null) {
              break label793;
            }
            bool2 = true;
            if (localRuntimeException.feJ != null) {
              break label798;
            }
            bool3 = true;
            if (localRuntimeException.feI != null) {
              break label803;
            }
            bool4 = true;
            if (localRuntimeException.feK != null) {
              break label809;
            }
            bool5 = true;
            if (localRuntimeException.feL != null) {
              break label815;
            }
            bool6 = true;
            label400:
            com.tencent.matrix.e.c.i("Matrix.UIThreadMonitor", "[UIThreadMonitor] %s %s %s %s %s %s frameIntervalNanos:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(bool6), Long.valueOf(localRuntimeException.eLi) });
            if (localb1.fdK) {
              localRuntimeException.a(new com.tencent.matrix.trace.core.b.2(localRuntimeException));
            }
          }
        }
        if (b.a(b.this).azE()) {
          AppMethodBeat.getInstance().onStart();
        }
        for (;;)
        {
          com.tencent.matrix.trace.core.b.azL().onStart();
          if (b.a(b.this).fdF) {
            b.b(b.this).aAa();
          }
          if (b.a(b.this).fdG)
          {
            b.a(b.this, new d(b.a(b.this)));
            b.c(b.this).aAa();
          }
          if (b.a(b.this).fdJ)
          {
            b.a(b.this, new TouchEventLagTracer(b.a(b.this)));
            b.d(b.this).aAa();
          }
          if ((b.a(b.this).fdL) && (!SignalAnrTracer.fgA))
          {
            b.a(b.this, new SignalAnrTracer(b.a(b.this)));
            b.e(b.this).aAa();
          }
          if (b.a(b.this).fdN)
          {
            b.a(b.this, new ThreadPriorityTracer());
            b.f(b.this).aAa();
          }
          if (b.a(b.this).fdB) {
            b.g(b.this).aAa();
          }
          if (b.a(b.this).fdC) {
            b.h(b.this).aAa();
          }
          if (!b.a(b.this).fdD) {
            break;
          }
          b.i(b.this).aAa();
          return;
          label788:
          bool1 = false;
          break label347;
          label793:
          bool2 = false;
          break label357;
          label798:
          bool3 = false;
          break label367;
          label803:
          bool4 = false;
          break label378;
          label809:
          bool5 = false;
          break label389;
          label815:
          bool6 = false;
          break label400;
          AppMethodBeat.getInstance().forceStop();
        }
      }
    };
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      local1.run();
      return;
    }
    com.tencent.matrix.e.c.w("Matrix.TracePlugin", "start TracePlugin in Thread[%s] but not in mainThread!", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
    com.tencent.matrix.e.b.aAn().post(local1);
  }
  
  public void stop()
  {
    super.stop();
    if (!isSupported())
    {
      com.tencent.matrix.e.c.w("Matrix.TracePlugin", "[stop] Plugin is unSupported!", new Object[0]);
      return;
    }
    com.tencent.matrix.e.c.w("Matrix.TracePlugin", "stop!", new Object[0]);
    Runnable local2 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.getInstance().onStop();
        com.tencent.matrix.trace.core.b.azL().onStop();
        b.b(b.this).aAb();
        b.g(b.this).aAb();
        b.h(b.this).aAb();
        b.i(b.this).aAb();
        if (b.e(b.this) != null) {
          b.e(b.this).aAb();
        }
        if (b.c(b.this) != null) {
          b.c(b.this).aAb();
        }
        if (b.f(b.this) != null) {
          b.f(b.this).aAb();
        }
      }
    };
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      local2.run();
      return;
    }
    com.tencent.matrix.e.c.w("Matrix.TracePlugin", "stop TracePlugin in Thread[%s] but not in mainThread!", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
    com.tencent.matrix.e.b.aAn().post(local2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.trace.b
 * JD-Core Version:    0.7.0.1
 */