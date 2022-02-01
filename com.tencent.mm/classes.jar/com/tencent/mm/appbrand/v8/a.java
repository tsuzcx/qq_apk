package com.tencent.mm.appbrand.v8;

import android.os.Process;
import android.util.Log;
import android.util.SparseArray;
import com.eclipsesource.v8.MultiContextV8;
import com.eclipsesource.v8.V8Context;
import com.eclipsesource.v8.V8Locker;
import com.eclipsesource.v8.V8ScriptException;
import com.eclipsesource.v8.utils.MemoryManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsruntime.h;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class a
  implements IJSRuntime
{
  private static final AtomicInteger cXn = new AtomicInteger(0);
  private static Runnable cXo = new a.1();
  final boolean cXA;
  private final SparseArray<h> cXB;
  private final ConcurrentLinkedQueue<Runnable> cXC;
  IJSRuntime.Config cXD;
  private MultiContextV8 cXp;
  private c cXq;
  private CountDownLatch cXr;
  private MemoryManager cXs;
  private aa cXt;
  e cXu;
  String cXv;
  byte[] cXw;
  String cXx;
  boolean cXy;
  private final boolean cXz;
  private volatile int mTid = -1;
  
  a(final IJSRuntime.Config paramConfig)
  {
    IJSRuntime.Config localConfig;
    if (paramConfig != null)
    {
      this.cXv = paramConfig.cXH;
      this.cXw = paramConfig.cXI;
      this.cXz = paramConfig.useNativeBufferJNI();
      this.cXy = paramConfig.cXL;
      this.cXA = paramConfig.cXM;
      this.cXx = paramConfig.cXO;
      if (paramConfig != null) {
        break label237;
      }
      localConfig = new IJSRuntime.Config();
      label73:
      this.cXD = localConfig;
      ad.i("MicroMsg.AbstractJSRuntime", "hy: use native buffer: %b, hasGlobalTimer: %b", new Object[] { Boolean.valueOf(this.cXz), Boolean.valueOf(this.cXA) });
      if (paramConfig == null) {
        break label242;
      }
    }
    label237:
    label242:
    for (paramConfig = paramConfig.toString();; paramConfig = "")
    {
      ad.i("MicroMsg.AbstractJSRuntime", "hy: config: %s", new Object[] { paramConfig });
      this.cXB = new SparseArray();
      this.cXC = new ConcurrentLinkedQueue();
      paramConfig = new CountDownLatch(1);
      this.cXr = new CountDownLatch(1);
      new Thread(String.format(Locale.US, "JSRuntimeLooper#%d", new Object[] { Integer.valueOf(cXn.getAndIncrement()) }))
      {
        public final void run()
        {
          AppMethodBeat.i(143991);
          a.a(a.this, Process.myTid());
          a.cXo.run();
          ad.i("MicroMsg.AbstractJSRuntime", "expansions file is ready");
          a.a(a.this, a.this.Nm());
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
          ad.i("MicroMsg.AbstractJSRuntime", "prepareV8WhenThreadStart, tid[%d] JsRuntime[%d] JsLooper[%d]", new Object[] { Integer.valueOf(a.d(a.this)), Integer.valueOf(a.this.hashCode()), Integer.valueOf(a.b(a.this).hashCode()) });
          a.a(a.this, a.this.Nl());
          a.a(a.this, new aa(a.a(a.this)));
          a.e(a.this);
          a.a(a.this, a.a(a.this).createMemoryManager());
          l = System.currentTimeMillis() - l;
          ad.i("MicroMsg.AbstractJSRuntime", "v8 init cost:%d ms", new Object[] { Long.valueOf(l) });
          x.a(5, l, -1, null, -1, -1, -1);
          V8Locker localV8Locker = a.a(a.this).getV8Locker();
          if (localV8Locker.hasLock())
          {
            ad.i("MicroMsg.AbstractJSRuntime", "has lock release");
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
            ad.i("MicroMsg.AbstractJSRuntime", "whenThreadEnd, mJSExceptionHandlerMap.clear() succeed, JsRuntime[%d]", new Object[] { Integer.valueOf(a.this.hashCode()) });
            a.this.Nn();
            AppMethodBeat.o(143991);
            return;
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              ad.e("MicroMsg.AbstractJSRuntime", "whenThreadEnd, mJSExceptionHandlerMap.clear(), JsRuntime[%d] get exception[%s]", new Object[] { Integer.valueOf(a.this.hashCode()), localThrowable });
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
        ad.i("MicroMsg.AbstractJSRuntime", "init latch.await InterruptedException:%s", new Object[] { paramConfig });
      }
      this.cXz = false;
      this.cXA = false;
      break;
      localConfig = paramConfig;
      break label73;
    }
  }
  
  private void Nq()
  {
    if ((this.cXq == null) && (this.cXr != null)) {
      ad.i("MicroMsg.AbstractJSRuntime", "scheduleToJSThread but looper null");
    }
    try
    {
      this.cXr.await(30000L, TimeUnit.MILLISECONDS);
      ad.i("MicroMsg.AbstractJSRuntime", "scheduleToJSThread but looper assigned");
      if (this.cXq == null)
      {
        cXo.run();
        if (this.cXq == null) {
          throw new IllegalStateException("JSRuntime not ready!");
        }
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        ad.i("MicroMsg.AbstractJSRuntime", "scheduleToJSThread latch.await InterruptedException:%s", new Object[] { localInterruptedException });
      }
    }
  }
  
  private void a(V8ScriptException paramV8ScriptException)
  {
    h localh = (h)this.cXB.get(paramV8ScriptException.getContextTag());
    if (localh != null)
    {
      localh.u(paramV8ScriptException.getJSMessage(), paramV8ScriptException.getJSStackTrace());
      return;
    }
    ad.w("MicroMsg.AbstractJSRuntime", "publishJSException jsHandler null %s", new Object[] { paramV8ScriptException });
  }
  
  public final String Cu()
  {
    return this.cXq.Cu();
  }
  
  public final IJSRuntime.Config Nk()
  {
    return this.cXD;
  }
  
  abstract MultiContextV8 Nl();
  
  abstract c Nm();
  
  abstract void Nn();
  
  public final e No()
  {
    if (this.cXu == null)
    {
      if (!this.cXz) {
        break label38;
      }
      ad.i("MicroMsg.AbstractJSRuntime", "hy: start load native buffer jni");
    }
    label38:
    for (this.cXu = new NativeBufferJNI();; this.cXu = new u()) {
      return this.cXu;
    }
  }
  
  public final boolean Np()
  {
    return this.cXq.Np();
  }
  
  public final void a(int paramInt, h paramh)
  {
    if (this.mTid < 0)
    {
      ad.e("MicroMsg.AbstractJSRuntime", "setJsExceptionHandler after destroyed, JsRuntime[%d] stack=%s", new Object[] { Integer.valueOf(hashCode()), Log.getStackTraceString(new Throwable()) });
      return;
    }
    ad.i("MicroMsg.AbstractJSRuntime", "setJsExceptionHandler contextId[%d] JsRuntime[%d] JSThread.id[%d], currentThread.id[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(hashCode()), Integer.valueOf(this.mTid), Long.valueOf(Thread.currentThread().getId()) });
    this.cXB.put(paramInt, paramh);
  }
  
  public final void a(Runnable paramRunnable, long paramLong, boolean paramBoolean)
  {
    Nq();
    this.cXq.b(paramRunnable, paramLong, paramBoolean);
  }
  
  public final void cj(boolean paramBoolean)
  {
    this.cXq.cj(paramBoolean);
  }
  
  public final void e(Runnable paramRunnable, long paramLong)
  {
    a(paramRunnable, paramLong, false);
  }
  
  public final long getIsolatePtr()
  {
    return this.cXp.getIsolatePtr();
  }
  
  public final long getUVLoopPtr()
  {
    return this.cXp.getUVLoopPtr();
  }
  
  public final m hv(final int paramInt)
  {
    new m(this, No(), new m.a()
    {
      public final V8Context Nr()
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
    this.cXq.pause();
  }
  
  public final void quit()
  {
    ad.i("MicroMsg.AbstractJSRuntime", "quit() JsRuntime[%d]", new Object[] { Integer.valueOf(hashCode()) });
    this.cXq.quit();
    this.mTid = -1;
  }
  
  public final void r(Runnable paramRunnable)
  {
    s(paramRunnable);
  }
  
  public final void resume()
  {
    this.cXq.resume();
  }
  
  public final void s(Runnable paramRunnable)
  {
    Nq();
    this.cXq.u(paramRunnable);
  }
  
  public final void setThreadPriority(int paramInt)
  {
    int i = this.mTid;
    if (i > 0) {}
    try
    {
      Process.setThreadPriority(i, paramInt);
      ad.d("MicroMsg.AbstractJSRuntime", "setThreadPriority priority=%d tid=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.AbstractJSRuntime", localException, "setThreadPriority priority=%d tid=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    }
  }
  
  public final void t(Runnable paramRunnable)
  {
    this.cXC.add(paramRunnable);
  }
  
  public final void waitForDebugger(String paramString)
  {
    n localn = new n(this.cXp, this);
    localn.cYL.r(new n.1(localn, paramString));
    localn.cYL.t(new n.2(localn));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.a
 * JD-Core Version:    0.7.0.1
 */