package com.tencent.mm.appbrand.v8;

import android.os.Process;
import android.util.SparseArray;
import com.eclipsesource.v8.MultiContextV8;
import com.eclipsesource.v8.V8Context;
import com.eclipsesource.v8.V8Locker;
import com.eclipsesource.v8.V8ScriptException;
import com.eclipsesource.v8.utils.MemoryManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.h;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class a
  implements IJSRuntime
{
  private static final AtomicInteger doO = new AtomicInteger(0);
  private static Runnable doP = new a.1();
  private MultiContextV8 doQ;
  private c doR;
  private CountDownLatch doS;
  private MemoryManager doT;
  private aa doU;
  e doV;
  private String doW = "RuntimeLooper";
  String doX;
  byte[] doY;
  String doZ;
  boolean dpa;
  private final boolean dpb;
  final boolean dpc;
  private final SparseArray<h> dpd;
  private final ConcurrentLinkedQueue<Runnable> dpe;
  IJSRuntime.Config dpf;
  private volatile int mTid = -1;
  
  a(final IJSRuntime.Config paramConfig)
  {
    IJSRuntime.Config localConfig;
    if (paramConfig != null)
    {
      this.doX = paramConfig.dpj;
      this.doY = paramConfig.dpk;
      this.dpb = paramConfig.useNativeBufferJNI();
      this.dpa = paramConfig.dpn;
      this.dpc = paramConfig.dpo;
      this.doZ = paramConfig.dpq;
      if (!Util.isNullOrNil(paramConfig.dpr)) {
        this.doW = paramConfig.dpr;
      }
      if (paramConfig != null) {
        break label268;
      }
      localConfig = new IJSRuntime.Config();
      label97:
      this.dpf = localConfig;
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AbstractJSRuntime", "hy: use native buffer: %b, hasGlobalTimer: %b", new Object[] { Boolean.valueOf(this.dpb), Boolean.valueOf(this.dpc) });
      if (paramConfig == null) {
        break label273;
      }
    }
    label268:
    label273:
    for (paramConfig = paramConfig.toString();; paramConfig = "")
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AbstractJSRuntime", "hy: config: %s", new Object[] { paramConfig });
      this.dpd = new SparseArray();
      this.dpe = new ConcurrentLinkedQueue();
      paramConfig = new CountDownLatch(1);
      this.doS = new CountDownLatch(1);
      new Thread(String.format(Locale.US, "JS%s#%d", new Object[] { this.doW, Integer.valueOf(doO.getAndIncrement()) }))
      {
        public final void run()
        {
          AppMethodBeat.i(143991);
          a.a(a.this, Process.myTid());
          a.doP.run();
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AbstractJSRuntime", "expansions file is ready");
          a.a(a.this, a.this.Xt());
          a.b(a.this).a(new c.a()
          {
            public final void b(V8ScriptException paramAnonymous2V8ScriptException)
            {
              AppMethodBeat.i(143990);
              a.a(a.this, paramAnonymous2V8ScriptException);
              AppMethodBeat.o(143990);
            }
          });
          paramConfig.countDown();
          a.c(a.this).countDown();
          long l = System.currentTimeMillis();
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AbstractJSRuntime", "prepareV8WhenThreadStart, tid[%d] JsRuntime[%d] JsLooper[%d]", new Object[] { Integer.valueOf(a.d(a.this)), Integer.valueOf(a.this.hashCode()), Integer.valueOf(a.b(a.this).hashCode()) });
          a.a(a.this, a.this.Xs());
          a.a(a.this, new aa(a.a(a.this)));
          a.e(a.this);
          a.a(a.this, a.a(a.this).createMemoryManager());
          l = System.currentTimeMillis() - l;
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AbstractJSRuntime", "v8 init cost:%d ms", new Object[] { Long.valueOf(l) });
          x.a(5, l, -1, null, -1, -1, -1);
          V8Locker localV8Locker = a.a(a.this).getV8Locker();
          if (localV8Locker.hasLock())
          {
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AbstractJSRuntime", "has lock release");
            localV8Locker.release();
          }
          localV8Locker.acquire();
          a.b(a.this).loop();
          a.f(a.this);
          a.g(a.this).release();
          a.e(a.this);
          try
          {
            a.h(a.this).clear();
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AbstractJSRuntime", "whenThreadEnd, mJSExceptionHandlerMap.clear() succeed, JsRuntime[%d]", new Object[] { Integer.valueOf(a.this.hashCode()) });
            a.this.Xu();
            AppMethodBeat.o(143991);
            return;
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AbstractJSRuntime", "whenThreadEnd, mJSExceptionHandlerMap.clear(), JsRuntime[%d] get exception[%s]", new Object[] { Integer.valueOf(a.this.hashCode()), localThrowable });
            }
          }
        }
      }.start();
      try
      {
        paramConfig.await(5000L, TimeUnit.MILLISECONDS);
        return;
      }
      catch (InterruptedException paramConfig)
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AbstractJSRuntime", "init latch.await InterruptedException:%s", new Object[] { paramConfig });
      }
      this.dpb = false;
      this.dpc = false;
      break;
      localConfig = paramConfig;
      break label97;
    }
  }
  
  private void Xx()
  {
    if ((this.doR == null) && (this.doS != null)) {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AbstractJSRuntime", "scheduleToJSThread but looper null");
    }
    try
    {
      this.doS.await(30000L, TimeUnit.MILLISECONDS);
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AbstractJSRuntime", "scheduleToJSThread but looper assigned");
      if (this.doR == null)
      {
        doP.run();
        if (this.doR == null) {
          throw new IllegalStateException("JSRuntime not ready!");
        }
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AbstractJSRuntime", "scheduleToJSThread latch.await InterruptedException:%s", new Object[] { localInterruptedException });
      }
    }
  }
  
  private void a(V8ScriptException paramV8ScriptException)
  {
    synchronized (this.dpd)
    {
      h localh = (h)this.dpd.get(paramV8ScriptException.getContextTag());
      if (localh != null)
      {
        localh.u(paramV8ScriptException.getJSMessage(), paramV8ScriptException.getJSStackTrace());
        return;
      }
    }
    com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AbstractJSRuntime", "publishJSException jsHandler null %s", new Object[] { paramV8ScriptException });
  }
  
  public final String LP()
  {
    return this.doR.LP();
  }
  
  public final IJSRuntime.Config Xr()
  {
    return this.dpf;
  }
  
  abstract MultiContextV8 Xs();
  
  abstract c Xt();
  
  abstract void Xu();
  
  public final e Xv()
  {
    if (this.doV == null)
    {
      if (!this.dpb) {
        break label38;
      }
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AbstractJSRuntime", "hy: start load native buffer jni");
    }
    label38:
    for (this.doV = new NativeBufferJNI();; this.doV = new u()) {
      return this.doV;
    }
  }
  
  public final boolean Xw()
  {
    return this.doR.Xw();
  }
  
  public final void a(int paramInt, h paramh)
  {
    if (this.mTid < 0)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AbstractJSRuntime", "setJsExceptionHandler after destroyed, JsRuntime[%d] stack=%s", new Object[] { Integer.valueOf(hashCode()), android.util.Log.getStackTraceString(new Throwable()) });
      return;
    }
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AbstractJSRuntime", "setJsExceptionHandler contextId[%d] JsRuntime[%d] JSThread.id[%d], currentThread.id[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(hashCode()), Integer.valueOf(this.mTid), Long.valueOf(Thread.currentThread().getId()) });
    synchronized (this.dpd)
    {
      this.dpd.put(paramInt, paramh);
      return;
    }
  }
  
  public final void a(Runnable paramRunnable, long paramLong, boolean paramBoolean)
  {
    Xx();
    this.doR.b(paramRunnable, paramLong, paramBoolean);
  }
  
  public final void cS(boolean paramBoolean)
  {
    this.doR.cS(paramBoolean);
  }
  
  public final boolean doInnerLoopTask()
  {
    return this.doR.doInnerLoopTask();
  }
  
  public final void e(Runnable paramRunnable, long paramLong)
  {
    a(paramRunnable, paramLong, false);
  }
  
  public final long getIsolatePtr()
  {
    return this.doQ.getIsolatePtr();
  }
  
  public final long getUVLoopPtr()
  {
    return this.doQ.getUVLoopPtr();
  }
  
  public final m iP(final int paramInt)
  {
    new m(this, Xv(), new m.a()
    {
      public final V8Context Xy()
      {
        AppMethodBeat.i(143989);
        if (a.a(a.this) == null)
        {
          localObject = new IllegalStateException("createContext mV8 not ready!");
          AppMethodBeat.o(143989);
          throw ((Throwable)localObject);
        }
        Object localObject = a.a(a.this).createContext(paramInt);
        AppMethodBeat.o(143989);
        return localObject;
      }
    });
  }
  
  public final void pause()
  {
    this.doR.pause();
  }
  
  public final void quit()
  {
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AbstractJSRuntime", "quit() JsRuntime[%d]", new Object[] { Integer.valueOf(hashCode()) });
    this.doR.quit();
    this.mTid = -1;
  }
  
  public final void r(Runnable paramRunnable)
  {
    s(paramRunnable);
  }
  
  public final void resume()
  {
    this.doR.resume();
  }
  
  public final void resumeLoopTasks()
  {
    this.doR.resumeLoopTasks();
  }
  
  public final void s(Runnable paramRunnable)
  {
    Xx();
    this.doR.u(paramRunnable);
  }
  
  public final void setThreadPriority(int paramInt)
  {
    int i = this.mTid;
    if (i > 0) {}
    try
    {
      Process.setThreadPriority(i, paramInt);
      com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AbstractJSRuntime", "setThreadPriority priority=%d tid=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.AbstractJSRuntime", localException, "setThreadPriority priority=%d tid=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    }
  }
  
  public final void t(Runnable paramRunnable)
  {
    this.dpe.add(paramRunnable);
  }
  
  public final void waitForDebugger(String paramString)
  {
    n localn = new n(this.doQ, this);
    localn.dqn.r(new n.1(localn, paramString));
    localn.dqn.t(new n.2(localn));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.a
 * JD-Core Version:    0.7.0.1
 */