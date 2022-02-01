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
  public final com.tencent.matrix.trace.a.b cyA;
  public com.tencent.matrix.trace.f.b cyB;
  public e cyC;
  public com.tencent.matrix.trace.f.c cyD;
  public com.tencent.matrix.trace.f.a cyE;
  
  public a(com.tencent.matrix.trace.a.b paramb)
  {
    this.cyA = paramb;
  }
  
  public static AppMethodBeat HB()
  {
    return AppMethodBeat.getInstance();
  }
  
  public static com.tencent.matrix.trace.core.b HC()
  {
    if (com.tencent.matrix.trace.core.b.HF().cqf) {
      return com.tencent.matrix.trace.core.b.HF();
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
    com.tencent.matrix.g.c.i("Matrix.TracePlugin", "trace plugin init, trace config: %s", new Object[] { this.cyA.toString() });
    if (Build.VERSION.SDK_INT < 16)
    {
      com.tencent.matrix.g.c.e("Matrix.TracePlugin", "[FrameBeat] API is low Build.VERSION_CODES.JELLY_BEAN(16), TracePlugin is not supported", new Object[0]);
      unSupportPlugin();
      return;
    }
    this.cyE = new com.tencent.matrix.trace.f.a(this.cyA);
    this.cyD = new com.tencent.matrix.trace.f.c(this.cyA);
    this.cyB = new com.tencent.matrix.trace.f.b(this.cyA);
    this.cyC = new e(this.cyA);
  }
  
  public void onForeground(boolean paramBoolean)
  {
    super.onForeground(paramBoolean);
    if (!isSupported()) {}
    do
    {
      return;
      if (this.cyD != null) {
        this.cyD.onForeground(paramBoolean);
      }
      if (this.cyE != null) {
        this.cyE.onForeground(paramBoolean);
      }
      if (this.cyB != null) {
        this.cyB.onForeground(paramBoolean);
      }
    } while (this.cyC == null);
    this.cyC.onForeground(paramBoolean);
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
        if (!com.tencent.matrix.trace.core.b.HF().cqf)
        {
          try
          {
            com.tencent.matrix.trace.core.b localb = com.tencent.matrix.trace.core.b.HF();
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
          localRuntimeException.cyQ = localb1;
          localRuntimeException.choreographer = Choreographer.getInstance();
          localRuntimeException.czm = f.b(localRuntimeException.choreographer, "mLock", new Object());
          localRuntimeException.czn = ((Object[])f.b(localRuntimeException.choreographer, "mCallbackQueues", null));
          if (localRuntimeException.czn != null)
          {
            localRuntimeException.czp = f.c(localRuntimeException.czn[0], "addCallbackLocked", new Class[] { Long.TYPE, Object.class, Object.class });
            localRuntimeException.czq = f.c(localRuntimeException.czn[1], "addCallbackLocked", new Class[] { Long.TYPE, Object.class, Object.class });
            localRuntimeException.czo = f.c(localRuntimeException.czn[2], "addCallbackLocked", new Class[] { Long.TYPE, Object.class, Object.class });
          }
          localRuntimeException.czr = f.b(localRuntimeException.choreographer, "mDisplayEventReceiver", null);
          localRuntimeException.cpI = ((Long)f.b(localRuntimeException.choreographer, "mFrameIntervalNanos", Long.valueOf(16666667L))).longValue();
          com.tencent.matrix.trace.core.a.a(new b.1(localRuntimeException));
          localRuntimeException.cqf = true;
          if (localRuntimeException.czm != null) {
            break label507;
          }
          bool1 = true;
          if (localRuntimeException.czn != null) {
            break label512;
          }
          bool2 = true;
          if (localRuntimeException.czp != null) {
            break label517;
          }
          bool3 = true;
          if (localRuntimeException.czo != null) {
            break label522;
          }
          bool4 = true;
          if (localRuntimeException.czq != null) {
            break label528;
          }
          bool5 = true;
          label352:
          if (localRuntimeException.czr != null) {
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
          com.tencent.matrix.g.c.i("Matrix.UIThreadMonitor", "[UIThreadMonitor] %s %s %s %s %s %s frameIntervalNanos:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(bool6), Long.valueOf(localRuntimeException.cpI) });
          if (localb1.cyM) {
            localRuntimeException.a(new b.2(localRuntimeException));
          }
          AppMethodBeat.getInstance().onStart();
          com.tencent.matrix.trace.core.b.HF().onStart();
          a.b(a.this).HP();
          a.c(a.this).HP();
          a.d(a.this).HP();
          a.e(a.this).HP();
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
    com.tencent.matrix.g.b.HX().post(local1);
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
        com.tencent.matrix.trace.core.b.HF().onStop();
        a.b(a.this).HQ();
        a.c(a.this).HQ();
        a.d(a.this).HQ();
        a.e(a.this).HQ();
      }
    };
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      local2.run();
      return;
    }
    com.tencent.matrix.g.c.w("Matrix.TracePlugin", "stop TracePlugin in Thread[%s] but not in mainThread!", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
    com.tencent.matrix.g.b.HX().post(local2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.trace.a
 * JD-Core Version:    0.7.0.1
 */