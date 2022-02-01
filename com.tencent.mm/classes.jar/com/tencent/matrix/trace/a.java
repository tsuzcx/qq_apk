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
  public final com.tencent.matrix.trace.a.b cJv;
  public com.tencent.matrix.trace.f.b cJw;
  public e cJx;
  public com.tencent.matrix.trace.f.c cJy;
  public com.tencent.matrix.trace.f.a cJz;
  
  public a(com.tencent.matrix.trace.a.b paramb)
  {
    this.cJv = paramb;
  }
  
  public static AppMethodBeat IW()
  {
    return AppMethodBeat.getInstance();
  }
  
  public static com.tencent.matrix.trace.core.b IX()
  {
    if (com.tencent.matrix.trace.core.b.Ja().cAX) {
      return com.tencent.matrix.trace.core.b.Ja();
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
    com.tencent.matrix.g.c.i("Matrix.TracePlugin", "trace plugin init, trace config: %s", new Object[] { this.cJv.toString() });
    if (Build.VERSION.SDK_INT < 16)
    {
      com.tencent.matrix.g.c.e("Matrix.TracePlugin", "[FrameBeat] API is low Build.VERSION_CODES.JELLY_BEAN(16), TracePlugin is not supported", new Object[0]);
      unSupportPlugin();
      return;
    }
    this.cJz = new com.tencent.matrix.trace.f.a(this.cJv);
    this.cJy = new com.tencent.matrix.trace.f.c(this.cJv);
    this.cJw = new com.tencent.matrix.trace.f.b(this.cJv);
    this.cJx = new e(this.cJv);
  }
  
  public void onForeground(boolean paramBoolean)
  {
    super.onForeground(paramBoolean);
    if (!isSupported()) {}
    do
    {
      return;
      if (this.cJy != null) {
        this.cJy.onForeground(paramBoolean);
      }
      if (this.cJz != null) {
        this.cJz.onForeground(paramBoolean);
      }
      if (this.cJw != null) {
        this.cJw.onForeground(paramBoolean);
      }
    } while (this.cJx == null);
    this.cJx.onForeground(paramBoolean);
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
        if (!com.tencent.matrix.trace.core.b.Ja().cAX)
        {
          try
          {
            com.tencent.matrix.trace.core.b localb = com.tencent.matrix.trace.core.b.Ja();
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
          localRuntimeException.cJL = localb1;
          localRuntimeException.choreographer = Choreographer.getInstance();
          localRuntimeException.cKi = f.b(localRuntimeException.choreographer, "mLock", new Object());
          localRuntimeException.cKj = ((Object[])f.b(localRuntimeException.choreographer, "mCallbackQueues", null));
          if (localRuntimeException.cKj != null)
          {
            localRuntimeException.cKl = f.c(localRuntimeException.cKj[0], "addCallbackLocked", new Class[] { Long.TYPE, Object.class, Object.class });
            localRuntimeException.cKm = f.c(localRuntimeException.cKj[1], "addCallbackLocked", new Class[] { Long.TYPE, Object.class, Object.class });
            localRuntimeException.cKk = f.c(localRuntimeException.cKj[2], "addCallbackLocked", new Class[] { Long.TYPE, Object.class, Object.class });
          }
          localRuntimeException.cKn = f.b(localRuntimeException.choreographer, "mDisplayEventReceiver", null);
          localRuntimeException.cAz = ((Long)f.b(localRuntimeException.choreographer, "mFrameIntervalNanos", Long.valueOf(16666667L))).longValue();
          com.tencent.matrix.trace.core.a.a(new b.1(localRuntimeException));
          localRuntimeException.cAX = true;
          if (localRuntimeException.cKi != null) {
            break label507;
          }
          bool1 = true;
          if (localRuntimeException.cKj != null) {
            break label512;
          }
          bool2 = true;
          if (localRuntimeException.cKl != null) {
            break label517;
          }
          bool3 = true;
          if (localRuntimeException.cKk != null) {
            break label522;
          }
          bool4 = true;
          if (localRuntimeException.cKm != null) {
            break label528;
          }
          bool5 = true;
          label352:
          if (localRuntimeException.cKn != null) {
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
          com.tencent.matrix.g.c.i("Matrix.UIThreadMonitor", "[UIThreadMonitor] %s %s %s %s %s %s frameIntervalNanos:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(bool6), Long.valueOf(localRuntimeException.cAz) });
          if (localb1.cJH) {
            localRuntimeException.a(new b.2(localRuntimeException));
          }
          AppMethodBeat.getInstance().onStart();
          com.tencent.matrix.trace.core.b.Ja().onStart();
          a.b(a.this).Jk();
          a.c(a.this).Jk();
          a.d(a.this).Jk();
          a.e(a.this).Jk();
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
    com.tencent.matrix.g.b.Js().post(local1);
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
        com.tencent.matrix.trace.core.b.Ja().onStop();
        a.b(a.this).Jl();
        a.c(a.this).Jl();
        a.d(a.this).Jl();
        a.e(a.this).Jl();
      }
    };
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      local2.run();
      return;
    }
    com.tencent.matrix.g.c.w("Matrix.TracePlugin", "stop TracePlugin in Thread[%s] but not in mainThread!", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
    com.tencent.matrix.g.b.Js().post(local2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.trace.a
 * JD-Core Version:    0.7.0.1
 */