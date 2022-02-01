package com.tencent.mm.appbrand.v8;

import android.os.Process;
import android.text.TextUtils;
import android.util.SparseArray;
import com.eclipsesource.mmv8.MultiContextV8;
import com.eclipsesource.mmv8.V8Context;
import com.eclipsesource.mmv8.V8Locker;
import com.eclipsesource.mmv8.V8ScriptException;
import com.eclipsesource.mmv8.utils.MemoryManager;
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
  private static final AtomicInteger fhu = new AtomicInteger(0);
  private static Runnable fhv = new a.1();
  private aa fhA;
  private e fhB;
  private String fhC = "RuntimeLooper";
  String fhD;
  byte[] fhE;
  String fhF;
  boolean fhG;
  private final boolean fhH;
  final boolean fhI;
  private final SparseArray<h> fhJ;
  private final ConcurrentLinkedQueue<Runnable> fhK;
  private final IJSRuntime.Config fhL;
  private MultiContextV8 fhw;
  private c fhx;
  private CountDownLatch fhy;
  private MemoryManager fhz;
  private volatile int mTid = -1;
  
  a(final IJSRuntime.Config paramConfig)
  {
    IJSRuntime.Config localConfig;
    label128:
    boolean bool1;
    boolean bool2;
    if (paramConfig != null)
    {
      if (!TextUtils.isEmpty(paramConfig.fhP)) {
        paramConfig.fhP = com.tencent.mm.vfs.u.n(paramConfig.fhP, true);
      }
      this.fhD = paramConfig.fhP;
      this.fhE = paramConfig.fhQ;
      this.fhH = paramConfig.useNativeBufferJNI();
      this.fhG = paramConfig.fhT;
      this.fhI = paramConfig.fhU;
      this.fhF = paramConfig.fhW;
      this.fhB = paramConfig.fhZ;
      if (!Util.isNullOrNil(paramConfig.fhX)) {
        this.fhC = paramConfig.fhX;
      }
      if (paramConfig != null) {
        break label293;
      }
      localConfig = new IJSRuntime.Config();
      this.fhL = localConfig;
      bool1 = this.fhH;
      bool2 = this.fhI;
      if (paramConfig == null) {
        break label299;
      }
    }
    label293:
    label299:
    for (paramConfig = paramConfig.toString();; paramConfig = "")
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AbstractJSRuntime", "<init> hy: use native buffer: %b, hasGlobalTimer: %b, config: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), paramConfig });
      this.fhJ = new SparseArray();
      this.fhK = new ConcurrentLinkedQueue();
      paramConfig = new CountDownLatch(1);
      this.fhy = new CountDownLatch(1);
      new Thread(String.format(Locale.US, "JS%s#%d", new Object[] { this.fhC, Integer.valueOf(fhu.getAndIncrement()) }))
      {
        public final void run()
        {
          AppMethodBeat.i(143991);
          a.a(a.this, Process.myTid());
          a.fhv.run();
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AbstractJSRuntime", "expansions file is ready");
          a.a(a.this, a.this.abV());
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
          a.a(a.this, a.this.abU());
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
          a.b(a.this).acb();
          a.f(a.this);
          a.g(a.this).release();
          a.e(a.this);
          try
          {
            a.h(a.this).clear();
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AbstractJSRuntime", "whenThreadEnd, mJSExceptionHandlerMap.clear() succeed, JsRuntime[%d]", new Object[] { Integer.valueOf(a.this.hashCode()) });
            a.this.abW();
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
      this.fhH = false;
      this.fhI = false;
      break;
      localConfig = paramConfig;
      break label128;
    }
  }
  
  private void a(V8ScriptException paramV8ScriptException)
  {
    synchronized (this.fhJ)
    {
      h localh = (h)this.fhJ.get(paramV8ScriptException.getContextTag());
      if (localh != null)
      {
        localh.A(paramV8ScriptException.getJSMessage(), paramV8ScriptException.getJSStackTrace());
        return;
      }
    }
    com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AbstractJSRuntime", "publishJSException jsHandler null %s", new Object[] { paramV8ScriptException });
  }
  
  private void abZ()
  {
    if ((this.fhx == null) && (this.fhy != null)) {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AbstractJSRuntime", "scheduleToJSThread but looper null");
    }
    try
    {
      this.fhy.await(30000L, TimeUnit.MILLISECONDS);
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AbstractJSRuntime", "scheduleToJSThread but looper assigned");
      if (this.fhx == null)
      {
        fhv.run();
        if (this.fhx == null) {
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
  
  public final String OG()
  {
    return this.fhx.OG();
  }
  
  public final void a(int paramInt, h paramh)
  {
    if (this.mTid < 0)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AbstractJSRuntime", "setJsExceptionHandler after destroyed, JsRuntime[%d] stack=%s", new Object[] { Integer.valueOf(hashCode()), android.util.Log.getStackTraceString(new Throwable()) });
      return;
    }
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AbstractJSRuntime", "setJsExceptionHandler contextId[%d] JsRuntime[%d] JSThread.id[%d], currentThread.id[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(hashCode()), Integer.valueOf(this.mTid), Long.valueOf(Thread.currentThread().getId()) });
    synchronized (this.fhJ)
    {
      this.fhJ.put(paramInt, paramh);
      return;
    }
  }
  
  public final void a(Runnable paramRunnable, long paramLong, boolean paramBoolean)
  {
    abZ();
    this.fhx.b(paramRunnable, paramLong, paramBoolean);
  }
  
  public final IJSRuntime.Config abT()
  {
    return this.fhL;
  }
  
  abstract MultiContextV8 abU();
  
  abstract c abV();
  
  abstract void abW();
  
  public final e abX()
  {
    if (this.fhB == null)
    {
      if (!this.fhH) {
        break label38;
      }
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AbstractJSRuntime", "hy: start load native buffer jni");
    }
    label38:
    for (this.fhB = new NativeBufferJNI();; this.fhB = new u()) {
      return this.fhB;
    }
  }
  
  public final boolean abY()
  {
    return this.fhx.abY();
  }
  
  public final void d(Runnable paramRunnable, long paramLong)
  {
    a(paramRunnable, paramLong, false);
  }
  
  public final boolean doInnerLoopTask()
  {
    return this.fhx.doInnerLoopTask();
  }
  
  public final void dp(boolean paramBoolean)
  {
    this.fhx.dp(paramBoolean);
  }
  
  public final long getIsolatePtr()
  {
    return this.fhw.getIsolatePtr();
  }
  
  public final long getUVLoopPtr()
  {
    return this.fhw.getUVLoopPtr();
  }
  
  public final void ke(int paramInt)
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
  
  public final m kf(final int paramInt)
  {
    new m(this, abX(), new m.a()
    {
      public final V8Context aca()
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
    this.fhx.pause();
  }
  
  public final void q(Runnable paramRunnable)
  {
    r(paramRunnable);
  }
  
  public final void quit()
  {
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AbstractJSRuntime", "quit() JsRuntime[%d]", new Object[] { Integer.valueOf(hashCode()) });
    this.fhx.quit();
    this.mTid = -1;
  }
  
  public final void r(Runnable paramRunnable)
  {
    abZ();
    this.fhx.t(paramRunnable);
  }
  
  public final void resume()
  {
    this.fhx.resume();
  }
  
  public final void resumeLoopTasks()
  {
    this.fhx.resumeLoopTasks();
  }
  
  public final void s(Runnable paramRunnable)
  {
    this.fhK.add(paramRunnable);
  }
  
  public final void waitForDebugger(String paramString)
  {
    n localn = new n(this.fhw, this);
    localn.fiU.q(new n.1(localn, paramString));
    localn.fiU.s(new n.2(localn));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.a
 * JD-Core Version:    0.7.0.1
 */