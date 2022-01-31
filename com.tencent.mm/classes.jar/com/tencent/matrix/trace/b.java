package com.tencent.matrix.trace;

import android.app.Application;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.f.e;

public class b
  extends com.tencent.matrix.d.b
{
  public final com.tencent.matrix.trace.a.a bQN;
  public com.tencent.matrix.trace.f.b bQO;
  public e bQP;
  public com.tencent.matrix.trace.f.c bQQ;
  private com.tencent.matrix.trace.f.a bQR;
  
  public b(com.tencent.matrix.trace.a.a parama)
  {
    this.bQN = parama;
  }
  
  public static AppMethodBeat zr()
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
    com.tencent.matrix.g.c.i("Matrix.TracePlugin", "trace plugin init, trace config: %s", new Object[] { this.bQN.toString() });
    if (Build.VERSION.SDK_INT < 16)
    {
      com.tencent.matrix.g.c.e("Matrix.TracePlugin", "[FrameBeat] API is low Build.VERSION_CODES.JELLY_BEAN(16), TracePlugin is not supported", new Object[0]);
      unSupportPlugin();
      return;
    }
    this.bQR = new com.tencent.matrix.trace.f.a(this.bQN);
    this.bQQ = new com.tencent.matrix.trace.f.c(this.bQN);
    this.bQO = new com.tencent.matrix.trace.f.b(this.bQN);
    this.bQP = new e(this.bQN);
  }
  
  public void onForeground(boolean paramBoolean)
  {
    super.onForeground(paramBoolean);
    if (!isSupported()) {}
    do
    {
      return;
      if (this.bQQ != null) {
        this.bQQ.onForeground(paramBoolean);
      }
      if (this.bQR != null) {
        this.bQR.onForeground(paramBoolean);
      }
      if (this.bQO != null) {
        this.bQO.onForeground(paramBoolean);
      }
    } while (this.bQP == null);
    this.bQP.onForeground(paramBoolean);
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
        boolean bool1;
        boolean bool2;
        label298:
        boolean bool3;
        label308:
        boolean bool4;
        if (!com.tencent.matrix.trace.core.b.zt().bRB)
        {
          com.tencent.matrix.trace.a.a locala;
          try
          {
            com.tencent.matrix.trace.core.b localb = com.tencent.matrix.trace.core.b.zt();
            locala = b.a(b.this);
            if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
              throw new AssertionError("must be init in main thread!");
            }
          }
          catch (RuntimeException localRuntimeException)
          {
            com.tencent.matrix.g.c.e("Matrix.TracePlugin", "[start] RuntimeException:%s", new Object[] { localRuntimeException });
            return;
          }
          localRuntimeException.bRa = locala;
          localRuntimeException.choreographer = Choreographer.getInstance();
          localRuntimeException.bRt = com.tencent.matrix.trace.core.b.e(localRuntimeException.choreographer, "mLock");
          localRuntimeException.bRu = ((Object[])com.tencent.matrix.trace.core.b.e(localRuntimeException.choreographer, "mCallbackQueues"));
          localRuntimeException.bRw = com.tencent.matrix.trace.core.b.d(localRuntimeException.bRu[0], "addCallbackLocked", new Class[] { Long.TYPE, Object.class, Object.class });
          localRuntimeException.bRx = com.tencent.matrix.trace.core.b.d(localRuntimeException.bRu[1], "addCallbackLocked", new Class[] { Long.TYPE, Object.class, Object.class });
          localRuntimeException.bRv = com.tencent.matrix.trace.core.b.d(localRuntimeException.bRu[2], "addCallbackLocked", new Class[] { Long.TYPE, Object.class, Object.class });
          localRuntimeException.bLF = ((Long)com.tencent.matrix.trace.core.b.e(localRuntimeException.choreographer, "mFrameIntervalNanos")).longValue();
          com.tencent.matrix.trace.core.a.a(new com.tencent.matrix.trace.core.b.1(localRuntimeException));
          if (locala.bQX) {
            localRuntimeException.a(new com.tencent.matrix.trace.core.b.2(localRuntimeException));
          }
          if (localRuntimeException.bRt != null) {
            break label449;
          }
          bool1 = true;
          if (localRuntimeException.bRu != null) {
            break label454;
          }
          bool2 = true;
          if (localRuntimeException.bRw != null) {
            break label459;
          }
          bool3 = true;
          if (localRuntimeException.bRv != null) {
            break label464;
          }
          bool4 = true;
          label319:
          if (localRuntimeException.bRx != null) {
            break label470;
          }
        }
        label449:
        label454:
        label459:
        label464:
        label470:
        for (boolean bool5 = true;; bool5 = false)
        {
          com.tencent.matrix.g.c.i("Matrix.UIThreadMonitor", "[UIThreadMonitor] %s %s %s %s %s frameIntervalNanos:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Long.valueOf(localRuntimeException.bLF) });
          localRuntimeException.bRB = true;
          AppMethodBeat.getInstance().onStart();
          com.tencent.matrix.trace.core.b.zt().onStart();
          b.b(b.this).zA();
          b.c(b.this).zA();
          b.d(b.this).zA();
          b.e(b.this).zA();
          return;
          bool1 = false;
          break;
          bool2 = false;
          break label298;
          bool3 = false;
          break label308;
          bool4 = false;
          break label319;
        }
      }
    };
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      local1.run();
      return;
    }
    com.tencent.matrix.g.c.w("Matrix.TracePlugin", "start TracePlugin in Thread[%s] but not in mainThread!", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
    com.tencent.matrix.g.b.zH().post(local1);
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
        com.tencent.matrix.trace.core.b.zt().onStop();
        b.b(b.this).zB();
        b.c(b.this).zB();
        b.d(b.this).zB();
        b.e(b.this).zB();
      }
    };
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      local2.run();
      return;
    }
    com.tencent.matrix.g.c.w("Matrix.TracePlugin", "stop TracePlugin in Thread[%s] but not in mainThread!", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
    com.tencent.matrix.g.b.zH().post(local2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.trace.b
 * JD-Core Version:    0.7.0.1
 */