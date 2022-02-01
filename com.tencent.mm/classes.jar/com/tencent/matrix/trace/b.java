package com.tencent.matrix.trace;

import android.app.Application;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import com.tencent.matrix.e.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.f.e;

public class b
  extends com.tencent.matrix.d.b
{
  public final com.tencent.matrix.trace.a.b deE;
  public com.tencent.matrix.trace.f.b deF;
  public e deG;
  public com.tencent.matrix.trace.f.c deH;
  public com.tencent.matrix.trace.f.a deI;
  
  public b(com.tencent.matrix.trace.a.b paramb)
  {
    this.deE = paramb;
  }
  
  public static AppMethodBeat XX()
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
    com.tencent.matrix.e.c.i("Matrix.TracePlugin", "trace plugin init, trace config: %s", new Object[] { this.deE.toString() });
    if (Build.VERSION.SDK_INT < 16)
    {
      com.tencent.matrix.e.c.e("Matrix.TracePlugin", "[FrameBeat] API is low Build.VERSION_CODES.JELLY_BEAN(16), TracePlugin is not supported", new Object[0]);
      unSupportPlugin();
      return;
    }
    this.deI = new com.tencent.matrix.trace.f.a(this.deE);
    this.deH = new com.tencent.matrix.trace.f.c(this.deE);
    this.deF = new com.tencent.matrix.trace.f.b(this.deE);
    this.deG = new e(this.deE);
  }
  
  public void onForeground(boolean paramBoolean)
  {
    super.onForeground(paramBoolean);
    if (!isSupported()) {}
    do
    {
      return;
      if (this.deH != null) {
        this.deH.onForeground(paramBoolean);
      }
      if (this.deI != null) {
        this.deI.onForeground(paramBoolean);
      }
      if (this.deF != null) {
        this.deF.onForeground(paramBoolean);
      }
    } while (this.deG == null);
    this.deG.onForeground(paramBoolean);
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
        label64:
        boolean bool1;
        label310:
        boolean bool2;
        label320:
        boolean bool3;
        label330:
        boolean bool4;
        label341:
        boolean bool5;
        label352:
        boolean bool6;
        if (!com.tencent.matrix.trace.core.b.Ya().isInit)
        {
          com.tencent.matrix.trace.a.b localb1;
          try
          {
            com.tencent.matrix.trace.core.b localb = com.tencent.matrix.trace.core.b.Ya();
            localb1 = b.a(b.this);
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
              break label64;
            }
            throw new AssertionError("must be init in main thread!");
          }
          catch (RuntimeException localRuntimeException)
          {
            com.tencent.matrix.e.c.e("Matrix.TracePlugin", "[start] RuntimeException:%s", new Object[] { localRuntimeException });
          }
          return;
          localRuntimeException.deV = localb1;
          localRuntimeException.choreographer = Choreographer.getInstance();
          localRuntimeException.dfr = f.b(localRuntimeException.choreographer, "mLock", new Object());
          localRuntimeException.dfs = ((Object[])f.b(localRuntimeException.choreographer, "mCallbackQueues", null));
          if (localRuntimeException.dfs != null)
          {
            localRuntimeException.dfu = f.c(localRuntimeException.dfs[0], "addCallbackLocked", new Class[] { Long.TYPE, Object.class, Object.class });
            localRuntimeException.dfv = f.c(localRuntimeException.dfs[1], "addCallbackLocked", new Class[] { Long.TYPE, Object.class, Object.class });
            localRuntimeException.dft = f.c(localRuntimeException.dfs[2], "addCallbackLocked", new Class[] { Long.TYPE, Object.class, Object.class });
          }
          localRuntimeException.dfw = f.b(localRuntimeException.choreographer, "mDisplayEventReceiver", null);
          localRuntimeException.cQd = ((Long)f.b(localRuntimeException.choreographer, "mFrameIntervalNanos", Long.valueOf(16666667L))).longValue();
          com.tencent.matrix.trace.core.a.a(new com.tencent.matrix.trace.core.b.1(localRuntimeException));
          localRuntimeException.isInit = true;
          if (localRuntimeException.dfr != null) {
            break label572;
          }
          bool1 = true;
          if (localRuntimeException.dfs != null) {
            break label577;
          }
          bool2 = true;
          if (localRuntimeException.dfu != null) {
            break label582;
          }
          bool3 = true;
          if (localRuntimeException.dft != null) {
            break label587;
          }
          bool4 = true;
          if (localRuntimeException.dfv != null) {
            break label593;
          }
          bool5 = true;
          if (localRuntimeException.dfw != null) {
            break label599;
          }
          bool6 = true;
          label363:
          com.tencent.matrix.e.c.i("Matrix.UIThreadMonitor", "[UIThreadMonitor] %s %s %s %s %s %s frameIntervalNanos:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(bool6), Long.valueOf(localRuntimeException.cQd) });
          if (localb1.deR) {
            localRuntimeException.a(new com.tencent.matrix.trace.core.b.2(localRuntimeException));
          }
        }
        if (b.a(b.this).deP) {
          AppMethodBeat.getInstance().onStart();
        }
        for (;;)
        {
          com.tencent.matrix.trace.core.b.Ya().onStart();
          if (b.a(b.this).deQ) {
            b.b(b.this).Yk();
          }
          if (b.a(b.this).deM) {
            b.c(b.this).Yk();
          }
          if (b.a(b.this).deN) {
            b.d(b.this).Yk();
          }
          if (!b.a(b.this).deO) {
            break;
          }
          b.e(b.this).Yk();
          return;
          label572:
          bool1 = false;
          break label310;
          label577:
          bool2 = false;
          break label320;
          label582:
          bool3 = false;
          break label330;
          label587:
          bool4 = false;
          break label341;
          label593:
          bool5 = false;
          break label352;
          label599:
          bool6 = false;
          break label363;
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
    com.tencent.matrix.e.b.Ys().post(local1);
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
        com.tencent.matrix.trace.core.b.Ya().onStop();
        b.b(b.this).Yl();
        b.c(b.this).Yl();
        b.d(b.this).Yl();
        b.e(b.this).Yl();
      }
    };
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      local2.run();
      return;
    }
    com.tencent.matrix.e.c.w("Matrix.TracePlugin", "stop TracePlugin in Thread[%s] but not in mainThread!", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
    com.tencent.matrix.e.b.Ys().post(local2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.trace.b
 * JD-Core Version:    0.7.0.1
 */