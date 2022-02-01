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
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class a
  implements IJSRuntime
{
  private static final AtomicInteger cLZ = new AtomicInteger(0);
  private static Runnable cMa = new a.1();
  private MultiContextV8 cMb;
  private c cMc;
  private CountDownLatch cMd;
  private MemoryManager cMe;
  private aa cMf;
  e cMg;
  String cMh;
  byte[] cMi;
  boolean cMj;
  private final boolean cMk;
  final boolean cMl;
  private final SparseArray<h> cMm;
  private final ConcurrentLinkedQueue<Runnable> cMn;
  IJSRuntime.Config cMo;
  private volatile int mTid = -1;
  
  a(final IJSRuntime.Config paramConfig)
  {
    IJSRuntime.Config localConfig;
    if (paramConfig != null)
    {
      this.cMh = paramConfig.cMs;
      this.cMi = paramConfig.cMt;
      this.cMk = paramConfig.useNativeBufferJNI();
      this.cMj = paramConfig.cMw;
      this.cMl = paramConfig.cMx;
      if (paramConfig != null) {
        break label229;
      }
      localConfig = new IJSRuntime.Config();
      label65:
      this.cMo = localConfig;
      ac.i("MicroMsg.AbstractJSRuntime", "hy: use native buffer: %b, hasGlobalTimer: %b", new Object[] { Boolean.valueOf(this.cMk), Boolean.valueOf(this.cMl) });
      if (paramConfig == null) {
        break label234;
      }
    }
    label229:
    label234:
    for (paramConfig = paramConfig.toString();; paramConfig = "")
    {
      ac.i("MicroMsg.AbstractJSRuntime", "hy: config: %s", new Object[] { paramConfig });
      this.cMm = new SparseArray();
      this.cMn = new ConcurrentLinkedQueue();
      paramConfig = new CountDownLatch(1);
      this.cMd = new CountDownLatch(1);
      new Thread(String.format(Locale.US, "JSRuntimeLooper#%d", new Object[] { Integer.valueOf(cLZ.getAndIncrement()) }))
      {
        public final void run()
        {
          AppMethodBeat.i(143991);
          a.a(a.this, Process.myTid());
          a.cMa.run();
          ac.i("MicroMsg.AbstractJSRuntime", "expansions file is ready");
          a.a(a.this, a.this.LE());
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
          ac.i("MicroMsg.AbstractJSRuntime", "prepareV8WhenThreadStart, tid[%d] JsRuntime[%d] JsLooper[%d]", new Object[] { Integer.valueOf(a.d(a.this)), Integer.valueOf(a.this.hashCode()), Integer.valueOf(a.b(a.this).hashCode()) });
          a.a(a.this, a.this.LD());
          a.a(a.this, new aa(a.a(a.this)));
          a.e(a.this);
          a.a(a.this, a.a(a.this).createMemoryManager());
          l = System.currentTimeMillis() - l;
          ac.i("MicroMsg.AbstractJSRuntime", "v8 init cost:%d ms", new Object[] { Long.valueOf(l) });
          x.a(5, l, -1, null, -1, -1, -1);
          V8Locker localV8Locker = a.a(a.this).getV8Locker();
          if (localV8Locker.hasLock())
          {
            ac.i("MicroMsg.AbstractJSRuntime", "has lock release");
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
            ac.i("MicroMsg.AbstractJSRuntime", "whenThreadEnd, mJSExceptionHandlerMap.clear() succeed, JsRuntime[%d]", new Object[] { Integer.valueOf(a.this.hashCode()) });
            a.this.LF();
            AppMethodBeat.o(143991);
            return;
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              ac.e("MicroMsg.AbstractJSRuntime", "whenThreadEnd, mJSExceptionHandlerMap.clear(), JsRuntime[%d] get exception[%s]", new Object[] { Integer.valueOf(a.this.hashCode()), localThrowable });
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
        ac.i("MicroMsg.AbstractJSRuntime", "init latch.await InterruptedException:%s", new Object[] { paramConfig });
      }
      this.cMk = false;
      this.cMl = false;
      break;
      localConfig = paramConfig;
      break label65;
    }
  }
  
  private void LI()
  {
    if ((this.cMc == null) && (this.cMd != null)) {
      ac.i("MicroMsg.AbstractJSRuntime", "scheduleToJSThread but looper null");
    }
    try
    {
      this.cMd.await(30000L, TimeUnit.MILLISECONDS);
      ac.i("MicroMsg.AbstractJSRuntime", "scheduleToJSThread but looper assigned");
      if (this.cMc == null)
      {
        cMa.run();
        if (this.cMc == null) {
          throw new IllegalStateException("JSRuntime not ready!");
        }
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        ac.i("MicroMsg.AbstractJSRuntime", "scheduleToJSThread latch.await InterruptedException:%s", new Object[] { localInterruptedException });
      }
    }
  }
  
  private void a(V8ScriptException paramV8ScriptException)
  {
    h localh = (h)this.cMm.get(paramV8ScriptException.getContextTag());
    if (localh != null)
    {
      localh.u(paramV8ScriptException.getJSMessage(), paramV8ScriptException.getJSStackTrace());
      return;
    }
    ac.w("MicroMsg.AbstractJSRuntime", "publishJSException jsHandler null %s", new Object[] { paramV8ScriptException });
  }
  
  public final String AV()
  {
    return this.cMc.AV();
  }
  
  public final IJSRuntime.Config LC()
  {
    return this.cMo;
  }
  
  abstract MultiContextV8 LD();
  
  abstract c LE();
  
  abstract void LF();
  
  public final e LG()
  {
    if (this.cMg == null)
    {
      if (!this.cMk) {
        break label38;
      }
      ac.i("MicroMsg.AbstractJSRuntime", "hy: start load native buffer jni");
    }
    label38:
    for (this.cMg = new NativeBufferJNI();; this.cMg = new u()) {
      return this.cMg;
    }
  }
  
  public final boolean LH()
  {
    return this.cMc.LH();
  }
  
  public final void a(int paramInt, h paramh)
  {
    if (this.mTid < 0)
    {
      ac.e("MicroMsg.AbstractJSRuntime", "setJsExceptionHandler after destroyed, JsRuntime[%d] stack=%s", new Object[] { Integer.valueOf(hashCode()), Log.getStackTraceString(new Throwable()) });
      return;
    }
    ac.i("MicroMsg.AbstractJSRuntime", "setJsExceptionHandler contextId[%d] JsRuntime[%d] JSThread.id[%d], currentThread.id[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(hashCode()), Integer.valueOf(this.mTid), Long.valueOf(Thread.currentThread().getId()) });
    this.cMm.put(paramInt, paramh);
  }
  
  public final void a(Runnable paramRunnable, long paramLong, boolean paramBoolean)
  {
    LI();
    this.cMc.b(paramRunnable, paramLong, paramBoolean);
  }
  
  public final void ci(boolean paramBoolean)
  {
    this.cMc.ci(paramBoolean);
  }
  
  public final void e(Runnable paramRunnable, long paramLong)
  {
    a(paramRunnable, paramLong, false);
  }
  
  public final long getIsolatePtr()
  {
    return this.cMb.getIsolatePtr();
  }
  
  public final long getUVLoopPtr()
  {
    return this.cMb.getUVLoopPtr();
  }
  
  public final m ho(final int paramInt)
  {
    new m(this, LG(), new m.a()
    {
      public final V8Context LJ()
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
    this.cMc.pause();
  }
  
  public final void quit()
  {
    ac.i("MicroMsg.AbstractJSRuntime", "quit() JsRuntime[%d]", new Object[] { Integer.valueOf(hashCode()) });
    this.cMc.quit();
    this.mTid = -1;
  }
  
  public final void r(Runnable paramRunnable)
  {
    s(paramRunnable);
  }
  
  public final void resume()
  {
    this.cMc.resume();
  }
  
  public final void s(Runnable paramRunnable)
  {
    LI();
    this.cMc.u(paramRunnable);
  }
  
  public final void setThreadPriority(int paramInt)
  {
    int i = this.mTid;
    if (i > 0) {}
    try
    {
      Process.setThreadPriority(i, paramInt);
      ac.d("MicroMsg.AbstractJSRuntime", "setThreadPriority priority=%d tid=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.AbstractJSRuntime", localException, "setThreadPriority priority=%d tid=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    }
  }
  
  public final void t(Runnable paramRunnable)
  {
    this.cMn.add(paramRunnable);
  }
  
  public final void waitForDebugger(String paramString)
  {
    n localn = new n(this.cMb, this);
    localn.cNv.r(new n.1(localn, paramString));
    localn.cNv.t(new n.2(localn));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.a
 * JD-Core Version:    0.7.0.1
 */