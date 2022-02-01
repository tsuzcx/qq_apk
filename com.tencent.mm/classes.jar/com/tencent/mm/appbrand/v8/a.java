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
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class a
  implements IJSRuntime
{
  private static final AtomicInteger cYk = new AtomicInteger(0);
  private static Runnable cYl = new a.1();
  IJSRuntime.Config cYA;
  private MultiContextV8 cYm;
  private c cYn;
  private CountDownLatch cYo;
  private MemoryManager cYp;
  private aa cYq;
  e cYr;
  String cYs;
  byte[] cYt;
  String cYu;
  boolean cYv;
  private final boolean cYw;
  final boolean cYx;
  private final SparseArray<h> cYy;
  private final ConcurrentLinkedQueue<Runnable> cYz;
  private volatile int mTid = -1;
  
  a(final IJSRuntime.Config paramConfig)
  {
    IJSRuntime.Config localConfig;
    if (paramConfig != null)
    {
      this.cYs = paramConfig.cYF;
      this.cYt = paramConfig.cYG;
      this.cYw = paramConfig.useNativeBufferJNI();
      this.cYv = paramConfig.cYJ;
      this.cYx = paramConfig.cYK;
      this.cYu = paramConfig.cYM;
      if (paramConfig != null) {
        break label237;
      }
      localConfig = new IJSRuntime.Config();
      label73:
      this.cYA = localConfig;
      ae.i("MicroMsg.AbstractJSRuntime", "hy: use native buffer: %b, hasGlobalTimer: %b", new Object[] { Boolean.valueOf(this.cYw), Boolean.valueOf(this.cYx) });
      if (paramConfig == null) {
        break label242;
      }
    }
    label237:
    label242:
    for (paramConfig = paramConfig.toString();; paramConfig = "")
    {
      ae.i("MicroMsg.AbstractJSRuntime", "hy: config: %s", new Object[] { paramConfig });
      this.cYy = new SparseArray();
      this.cYz = new ConcurrentLinkedQueue();
      paramConfig = new CountDownLatch(1);
      this.cYo = new CountDownLatch(1);
      new Thread(String.format(Locale.US, "JSRuntimeLooper#%d", new Object[] { Integer.valueOf(cYk.getAndIncrement()) }))
      {
        public final void run()
        {
          AppMethodBeat.i(143991);
          a.a(a.this, Process.myTid());
          a.cYl.run();
          ae.i("MicroMsg.AbstractJSRuntime", "expansions file is ready");
          a.a(a.this, a.this.Nh());
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
          ae.i("MicroMsg.AbstractJSRuntime", "prepareV8WhenThreadStart, tid[%d] JsRuntime[%d] JsLooper[%d]", new Object[] { Integer.valueOf(a.d(a.this)), Integer.valueOf(a.this.hashCode()), Integer.valueOf(a.b(a.this).hashCode()) });
          a.a(a.this, a.this.Ng());
          a.a(a.this, new aa(a.a(a.this)));
          a.e(a.this);
          a.a(a.this, a.a(a.this).createMemoryManager());
          l = System.currentTimeMillis() - l;
          ae.i("MicroMsg.AbstractJSRuntime", "v8 init cost:%d ms", new Object[] { Long.valueOf(l) });
          x.a(5, l, -1, null, -1, -1, -1);
          V8Locker localV8Locker = a.a(a.this).getV8Locker();
          if (localV8Locker.hasLock())
          {
            ae.i("MicroMsg.AbstractJSRuntime", "has lock release");
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
            ae.i("MicroMsg.AbstractJSRuntime", "whenThreadEnd, mJSExceptionHandlerMap.clear() succeed, JsRuntime[%d]", new Object[] { Integer.valueOf(a.this.hashCode()) });
            a.this.Ni();
            AppMethodBeat.o(143991);
            return;
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              ae.e("MicroMsg.AbstractJSRuntime", "whenThreadEnd, mJSExceptionHandlerMap.clear(), JsRuntime[%d] get exception[%s]", new Object[] { Integer.valueOf(a.this.hashCode()), localThrowable });
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
        ae.i("MicroMsg.AbstractJSRuntime", "init latch.await InterruptedException:%s", new Object[] { paramConfig });
      }
      this.cYw = false;
      this.cYx = false;
      break;
      localConfig = paramConfig;
      break label73;
    }
  }
  
  private void Nl()
  {
    if ((this.cYn == null) && (this.cYo != null)) {
      ae.i("MicroMsg.AbstractJSRuntime", "scheduleToJSThread but looper null");
    }
    try
    {
      this.cYo.await(30000L, TimeUnit.MILLISECONDS);
      ae.i("MicroMsg.AbstractJSRuntime", "scheduleToJSThread but looper assigned");
      if (this.cYn == null)
      {
        cYl.run();
        if (this.cYn == null) {
          throw new IllegalStateException("JSRuntime not ready!");
        }
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        ae.i("MicroMsg.AbstractJSRuntime", "scheduleToJSThread latch.await InterruptedException:%s", new Object[] { localInterruptedException });
      }
    }
  }
  
  private void a(V8ScriptException paramV8ScriptException)
  {
    synchronized (this.cYy)
    {
      h localh = (h)this.cYy.get(paramV8ScriptException.getContextTag());
      if (localh != null)
      {
        localh.u(paramV8ScriptException.getJSMessage(), paramV8ScriptException.getJSStackTrace());
        return;
      }
    }
    ae.w("MicroMsg.AbstractJSRuntime", "publishJSException jsHandler null %s", new Object[] { paramV8ScriptException });
  }
  
  public final String Cx()
  {
    return this.cYn.Cx();
  }
  
  public final IJSRuntime.Config Nf()
  {
    return this.cYA;
  }
  
  abstract MultiContextV8 Ng();
  
  abstract c Nh();
  
  abstract void Ni();
  
  public final e Nj()
  {
    if (this.cYr == null)
    {
      if (!this.cYw) {
        break label38;
      }
      ae.i("MicroMsg.AbstractJSRuntime", "hy: start load native buffer jni");
    }
    label38:
    for (this.cYr = new NativeBufferJNI();; this.cYr = new u()) {
      return this.cYr;
    }
  }
  
  public final boolean Nk()
  {
    return this.cYn.Nk();
  }
  
  public final void a(int paramInt, h paramh)
  {
    if (this.mTid < 0)
    {
      ae.e("MicroMsg.AbstractJSRuntime", "setJsExceptionHandler after destroyed, JsRuntime[%d] stack=%s", new Object[] { Integer.valueOf(hashCode()), Log.getStackTraceString(new Throwable()) });
      return;
    }
    ae.i("MicroMsg.AbstractJSRuntime", "setJsExceptionHandler contextId[%d] JsRuntime[%d] JSThread.id[%d], currentThread.id[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(hashCode()), Integer.valueOf(this.mTid), Long.valueOf(Thread.currentThread().getId()) });
    synchronized (this.cYy)
    {
      this.cYy.put(paramInt, paramh);
      return;
    }
  }
  
  public final void a(Runnable paramRunnable, long paramLong, boolean paramBoolean)
  {
    Nl();
    this.cYn.b(paramRunnable, paramLong, paramBoolean);
  }
  
  public final void b(Runnable paramRunnable, boolean paramBoolean)
  {
    Nl();
    this.cYn.c(paramRunnable, paramBoolean);
  }
  
  public final void cj(boolean paramBoolean)
  {
    this.cYn.cj(paramBoolean);
  }
  
  public final boolean doInnerLoopTask()
  {
    return this.cYn.doInnerLoopTask();
  }
  
  public final void e(Runnable paramRunnable, long paramLong)
  {
    a(paramRunnable, paramLong, false);
  }
  
  public final long getIsolatePtr()
  {
    return this.cYm.getIsolatePtr();
  }
  
  public final long getUVLoopPtr()
  {
    return this.cYm.getUVLoopPtr();
  }
  
  public final m hv(final int paramInt)
  {
    new m(this, Nj(), new m.a()
    {
      public final V8Context Nm()
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
    this.cYn.pause();
  }
  
  public final void quit()
  {
    ae.i("MicroMsg.AbstractJSRuntime", "quit() JsRuntime[%d]", new Object[] { Integer.valueOf(hashCode()) });
    this.cYn.quit();
    this.mTid = -1;
  }
  
  public final void r(Runnable paramRunnable)
  {
    b(paramRunnable, false);
  }
  
  public final void resume()
  {
    this.cYn.resume();
  }
  
  public final void resumeLoopTasks()
  {
    this.cYn.resumeLoopTasks();
  }
  
  public final void s(Runnable paramRunnable)
  {
    this.cYz.add(paramRunnable);
  }
  
  public final void setThreadPriority(int paramInt)
  {
    int i = this.mTid;
    if (i > 0) {}
    try
    {
      Process.setThreadPriority(i, paramInt);
      ae.d("MicroMsg.AbstractJSRuntime", "setThreadPriority priority=%d tid=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.AbstractJSRuntime", localException, "setThreadPriority priority=%d tid=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    }
  }
  
  public final void waitForDebugger(String paramString)
  {
    n localn = new n(this.cYm, this);
    localn.cZJ.r(new n.1(localn, paramString));
    localn.cZJ.s(new n.2(localn));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.a
 * JD-Core Version:    0.7.0.1
 */