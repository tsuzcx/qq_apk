package com.tencent.matrix.trace;

import android.app.Application;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import com.tencent.matrix.g.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.core.b.1;
import com.tencent.matrix.trace.core.b.2;
import com.tencent.matrix.trace.f.e;

public class a
  extends com.tencent.matrix.e.b
{
  public final com.tencent.matrix.trace.a.b cKe;
  public com.tencent.matrix.trace.f.b cKf;
  public e cKg;
  public com.tencent.matrix.trace.f.c cKh;
  public com.tencent.matrix.trace.f.a cKi;
  
  public a(com.tencent.matrix.trace.a.b paramb)
  {
    this.cKe = paramb;
  }
  
  public static AppMethodBeat Je()
  {
    return AppMethodBeat.getInstance();
  }
  
  public static com.tencent.matrix.trace.core.b Jf()
  {
    if (com.tencent.matrix.trace.core.b.Ji().cBE) {
      return com.tencent.matrix.trace.core.b.Ji();
    }
    return null;
  }
  
  public void destroy()
  {
    super.destroy();
  }
  
  public String getTag()
  {
    return "Trace";
  }
  
  public void init(Application paramApplication, com.tencent.matrix.e.c paramc)
  {
    super.init(paramApplication, paramc);
    com.tencent.matrix.g.c.i("Matrix.TracePlugin", "trace plugin init, trace config: %s", new Object[] { this.cKe.toString() });
    if (Build.VERSION.SDK_INT < 16)
    {
      com.tencent.matrix.g.c.e("Matrix.TracePlugin", "[FrameBeat] API is low Build.VERSION_CODES.JELLY_BEAN(16), TracePlugin is not supported", new Object[0]);
      unSupportPlugin();
      return;
    }
    this.cKi = new com.tencent.matrix.trace.f.a(this.cKe);
    this.cKh = new com.tencent.matrix.trace.f.c(this.cKe);
    this.cKf = new com.tencent.matrix.trace.f.b(this.cKe);
    this.cKg = new e(this.cKe);
  }
  
  public void onForeground(boolean paramBoolean)
  {
    super.onForeground(paramBoolean);
    if (!isSupported()) {}
    do
    {
      return;
      if (this.cKh != null) {
        this.cKh.onForeground(paramBoolean);
      }
      if (this.cKi != null) {
        this.cKi.onForeground(paramBoolean);
      }
      if (this.cKf != null) {
        this.cKf.onForeground(paramBoolean);
      }
    } while (this.cKg == null);
    this.cKg.onForeground(paramBoolean);
  }
  
  public void start()
  {
    super.start();
    if (!isSupported())
    {
      com.tencent.matrix.g.c.w("Matrix.TracePlugin", "[start] Plugin is unSupported!", new Object[0]);
      return;
    }
    com.tencent.matrix.g.c.w("Matrix.TracePlugin", "start!", new Object[0]);
    Runnable local1 = new Runnable()
    {
      public final void run()
      {
        com.tencent.matrix.trace.a.b localb1;
        boolean bool1;
        boolean bool2;
        label320:
        boolean bool3;
        label330:
        boolean bool4;
        label341:
        boolean bool5;
        if (!com.tencent.matrix.trace.core.b.Ji().cBE)
        {
          try
          {
            com.tencent.matrix.trace.core.b localb = com.tencent.matrix.trace.core.b.Ji();
            localb1 = a.a(a.this);
            if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
              throw new AssertionError("must be init in main thread!");
            }
          }
          catch (RuntimeException localRuntimeException)
          {
            com.tencent.matrix.g.c.e("Matrix.TracePlugin", "[start] RuntimeException:%s", new Object[] { localRuntimeException });
            return;
          }
          localRuntimeException.cKu = localb1;
          localRuntimeException.choreographer = Choreographer.getInstance();
          localRuntimeException.cKR = f.b(localRuntimeException.choreographer, "mLock", new Object());
          localRuntimeException.cKS = ((Object[])f.b(localRuntimeException.choreographer, "mCallbackQueues", null));
          if (localRuntimeException.cKS != null)
          {
            localRuntimeException.cKU = f.c(localRuntimeException.cKS[0], "addCallbackLocked", new Class[] { Long.TYPE, Object.class, Object.class });
            localRuntimeException.cKV = f.c(localRuntimeException.cKS[1], "addCallbackLocked", new Class[] { Long.TYPE, Object.class, Object.class });
            localRuntimeException.cKT = f.c(localRuntimeException.cKS[2], "addCallbackLocked", new Class[] { Long.TYPE, Object.class, Object.class });
          }
          localRuntimeException.cKW = f.b(localRuntimeException.choreographer, "mDisplayEventReceiver", null);
          localRuntimeException.cBg = ((Long)f.b(localRuntimeException.choreographer, "mFrameIntervalNanos", Long.valueOf(16666667L))).longValue();
          com.tencent.matrix.trace.core.a.a(new b.1(localRuntimeException));
          localRuntimeException.cBE = true;
          if (localRuntimeException.cKR != null) {
            break label507;
          }
          bool1 = true;
          if (localRuntimeException.cKS != null) {
            break label512;
          }
          bool2 = true;
          if (localRuntimeException.cKU != null) {
            break label517;
          }
          bool3 = true;
          if (localRuntimeException.cKT != null) {
            break label522;
          }
          bool4 = true;
          if (localRuntimeException.cKV != null) {
            break label528;
          }
          bool5 = true;
          label352:
          if (localRuntimeException.cKW != null) {
            break label534;
          }
        }
        label512:
        label517:
        label522:
        label528:
        label534:
        for (boolean bool6 = true;; bool6 = false)
        {
          com.tencent.matrix.g.c.i("Matrix.UIThreadMonitor", "[UIThreadMonitor] %s %s %s %s %s %s frameIntervalNanos:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(bool6), Long.valueOf(localRuntimeException.cBg) });
          if (localb1.cKq) {
            localRuntimeException.a(new b.2(localRuntimeException));
          }
          AppMethodBeat.getInstance().onStart();
          com.tencent.matrix.trace.core.b.Ji().onStart();
          a.b(a.this).Js();
          a.c(a.this).Js();
          a.d(a.this).Js();
          a.e(a.this).Js();
          return;
          label507:
          bool1 = false;
          break;
          bool2 = false;
          break label320;
          bool3 = false;
          break label330;
          bool4 = false;
          break label341;
          bool5 = false;
          break label352;
        }
      }
    };
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      local1.run();
      return;
    }
    com.tencent.matrix.g.c.w("Matrix.TracePlugin", "start TracePlugin in Thread[%s] but not in mainThread!", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
    com.tencent.matrix.g.b.JA().post(local1);
  }
  
  public void stop()
  {
    super.stop();
    if (!isSupported())
    {
      com.tencent.matrix.g.c.w("Matrix.TracePlugin", "[stop] Plugin is unSupported!", new Object[0]);
      return;
    }
    com.tencent.matrix.g.c.w("Matrix.TracePlugin", "stop!", new Object[0]);
    Runnable local2 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.getInstance().onStop();
        com.tencent.matrix.trace.core.b.Ji().onStop();
        a.b(a.this).Jt();
        a.c(a.this).Jt();
        a.d(a.this).Jt();
        a.e(a.this).Jt();
      }
    };
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      local2.run();
      return;
    }
    com.tencent.matrix.g.c.w("Matrix.TracePlugin", "stop TracePlugin in Thread[%s] but not in mainThread!", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
    com.tencent.matrix.g.b.JA().post(local2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.trace.a
 * JD-Core Version:    0.7.0.1
 */