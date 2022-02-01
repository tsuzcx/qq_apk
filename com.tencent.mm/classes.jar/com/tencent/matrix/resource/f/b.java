package com.tencent.matrix.resource.f;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Debug;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.report.e;
import com.tencent.matrix.resource.analyzer.model.DestroyedActivityInfo;
import com.tencent.matrix.resource.b.a.b;
import com.tencent.matrix.resource.processor.ManualDumpProcessor;
import com.tencent.matrix.resource.processor.d;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

public final class b
  extends e
{
  private static final long dec = TimeUnit.DAYS.toMillis(1L);
  private final a.b dcD;
  public final com.tencent.matrix.resource.c ded;
  public final c dee;
  private final int def;
  public final long deg;
  public final long deh;
  private final ConcurrentLinkedQueue<DestroyedActivityInfo> dei;
  public final com.tencent.matrix.resource.processor.b dej;
  public final Application.ActivityLifecycleCallbacks dek = new a()
  {
    public final void onActivityDestroyed(Activity paramAnonymousActivity)
    {
      b.a(b.this, paramAnonymousActivity);
      b.a(b.this).postDelayed(new Runnable()
      {
        public final void run() {}
      }, 2000L);
    }
  };
  public final c.a del = new c.a()
  {
    public final c.a.a XU()
    {
      if (b.b(b.this).isEmpty())
      {
        com.tencent.matrix.e.c.i("Matrix.ActivityRefWatcher", "DestroyedActivityInfo is empty! wait...", new Object[0]);
        synchronized (b.b(b.this))
        {
          try
          {
            while (b.b(b.this).isEmpty()) {
              b.b(b.this).wait();
            }
            localObject2 = finally;
          }
          catch (Throwable localThrowable)
          {
            com.tencent.matrix.e.c.i("Matrix.ActivityRefWatcher", "DestroyedActivityInfo is NOT empty! resume check", new Object[0]);
            return c.a.a.dew;
          }
        }
      }
      if ((Debug.isDebuggerConnected()) && (!b.c(b.this).daP.dcE))
      {
        com.tencent.matrix.e.c.w("Matrix.ActivityRefWatcher", "debugger is connected, to avoid fake result, detection was delayed.", new Object[0]);
        return c.a.a.dew;
      }
      b.XT();
      b.XT();
      b.XT();
      ??? = b.b(b.this).iterator();
      while (((Iterator)???).hasNext())
      {
        DestroyedActivityInfo localDestroyedActivityInfo = (DestroyedActivityInfo)((Iterator)???).next();
        if (((b.d(b.this) == a.b.dcI) || (b.d(b.this) == a.b.dcJ)) && (!b.c(b.this).daP.dcE) && (b.this.fx(localDestroyedActivityInfo.mActivityName)))
        {
          com.tencent.matrix.e.c.v("Matrix.ActivityRefWatcher", "activity with key [%s] was already published.", new Object[] { localDestroyedActivityInfo.mActivityName });
          ((Iterator)???).remove();
        }
        else
        {
          b.XT();
          if (localDestroyedActivityInfo.mActivityRef.get() == null)
          {
            com.tencent.matrix.e.c.v("Matrix.ActivityRefWatcher", "activity with key [%s] was already recycled.", new Object[] { localDestroyedActivityInfo.mKey });
            ((Iterator)???).remove();
          }
          else
          {
            localDestroyedActivityInfo.mDetectedCount += 1;
            if ((localDestroyedActivityInfo.mDetectedCount < b.e(b.this)) && (!b.c(b.this).daP.dcE))
            {
              com.tencent.matrix.e.c.i("Matrix.ActivityRefWatcher", "activity with key [%s] should be recycled but actually still exists in %s times, wait for next detection to confirm.", new Object[] { localDestroyedActivityInfo.mKey, Integer.valueOf(localDestroyedActivityInfo.mDetectedCount) });
              b.XT();
            }
            else
            {
              com.tencent.matrix.e.c.i("Matrix.ActivityRefWatcher", "activity with key [%s] was suspected to be a leaked instance. mode[%s]", new Object[] { localDestroyedActivityInfo.mKey, b.d(b.this) });
              if (b.f(b.this) == null) {
                throw new NullPointerException("LeakProcessor not found!!!");
              }
              b.XT();
              if (b.f(b.this).a(localDestroyedActivityInfo))
              {
                com.tencent.matrix.e.c.i("Matrix.ActivityRefWatcher", "the leaked activity [%s] with key [%s] has been processed. stop polling", new Object[] { localDestroyedActivityInfo.mActivityName, localDestroyedActivityInfo.mKey });
                ((Iterator)???).remove();
              }
            }
          }
        }
      }
      b.XT();
      return c.a.a.dew;
    }
  };
  private final Handler mHandler;
  public final HandlerThread mHandlerThread;
  
  public b(Application paramApplication, com.tencent.matrix.resource.c paramc)
  {
    this(paramApplication, paramc, (byte)0);
  }
  
  private b(Application paramApplication, com.tencent.matrix.resource.c paramc, byte paramByte)
  {
    super(paramApplication, dec, paramc.getTag(), paramc);
    this.ded = paramc;
    paramApplication = paramc.daP;
    this.mHandlerThread = com.tencent.matrix.e.b.L("matrix_res", 5);
    this.mHandler = new Handler(this.mHandlerThread.getLooper());
    this.dcD = paramApplication.dcD;
    this.deg = paramApplication.XF();
    this.deh = paramApplication.XE();
    paramc = this.mHandlerThread;
    this.dee = new c(paramApplication.XE(), paramc);
    this.def = paramApplication.XG();
    paramApplication = this.dcD;
    switch (3.deo[paramApplication.ordinal()])
    {
    default: 
      paramApplication = new com.tencent.matrix.resource.processor.c(this);
    }
    for (;;)
    {
      this.dej = paramApplication;
      this.dei = new ConcurrentLinkedQueue();
      return;
      paramApplication = new com.tencent.matrix.resource.processor.a(this);
      continue;
      paramApplication = new ManualDumpProcessor(this, this.ded.daP.dcF);
      continue;
      paramApplication = new d(this);
    }
  }
  
  private void XS()
  {
    this.dee.XV();
    this.dei.clear();
  }
  
  public static void XT()
  {
    com.tencent.matrix.e.c.v("Matrix.ActivityRefWatcher", "triggering gc...", new Object[0]);
    Runtime.getRuntime().gc();
    try
    {
      Thread.sleep(100L);
      Runtime.getRuntime().runFinalization();
      com.tencent.matrix.e.c.v("Matrix.ActivityRefWatcher", "gc was triggered.", new Object[0]);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        com.tencent.matrix.e.c.printErrStackTrace("Matrix.ActivityRefWatcher", localInterruptedException, "", new Object[0]);
      }
    }
  }
  
  public final void XR()
  {
    Application localApplication = this.ded.getApplication();
    if (localApplication != null)
    {
      localApplication.unregisterActivityLifecycleCallbacks(this.dek);
      XS();
    }
  }
  
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.resource.f.b
 * JD-Core Version:    0.7.0.1
 */