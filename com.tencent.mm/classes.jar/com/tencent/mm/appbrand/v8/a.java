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
  private static final AtomicInteger cOE = new AtomicInteger(0);
  private static Runnable cOF = new a.1();
  private MultiContextV8 cOG;
  private c cOH;
  private CountDownLatch cOI;
  private MemoryManager cOJ;
  private aa cOK;
  e cOL;
  String cOM;
  byte[] cON;
  boolean cOO;
  private final boolean cOP;
  final boolean cOQ;
  private final SparseArray<h> cOR;
  private final ConcurrentLinkedQueue<Runnable> cOS;
  IJSRuntime.Config cOT;
  private volatile int mTid = -1;
  
  a(final IJSRuntime.Config paramConfig)
  {
    IJSRuntime.Config localConfig;
    if (paramConfig != null)
    {
      this.cOM = paramConfig.cOX;
      this.cON = paramConfig.cOY;
      this.cOP = paramConfig.useNativeBufferJNI();
      this.cOO = paramConfig.cPb;
      this.cOQ = paramConfig.cPc;
      if (paramConfig != null) {
        break label229;
      }
      localConfig = new IJSRuntime.Config();
      label65:
      this.cOT = localConfig;
      ad.i("MicroMsg.AbstractJSRuntime", "hy: use native buffer: %b, hasGlobalTimer: %b", new Object[] { Boolean.valueOf(this.cOP), Boolean.valueOf(this.cOQ) });
      if (paramConfig == null) {
        break label234;
      }
    }
    label229:
    label234:
    for (paramConfig = paramConfig.toString();; paramConfig = "")
    {
      ad.i("MicroMsg.AbstractJSRuntime", "hy: config: %s", new Object[] { paramConfig });
      this.cOR = new SparseArray();
      this.cOS = new ConcurrentLinkedQueue();
      paramConfig = new CountDownLatch(1);
      this.cOI = new CountDownLatch(1);
      new Thread(String.format(Locale.US, "JSRuntimeLooper#%d", new Object[] { Integer.valueOf(cOE.getAndIncrement()) }))
      {
        public final void run()
        {
          AppMethodBeat.i(143991);
          a.a(a.this, Process.myTid());
          a.cOF.run();
          ad.i("MicroMsg.AbstractJSRuntime", "expansions file is ready");
          a.a(a.this, a.this.LG());
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
          a.a(a.this, a.this.LF());
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
            a.this.LH();
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
      this.cOP = false;
      this.cOQ = false;
      break;
      localConfig = paramConfig;
      break label65;
    }
  }
  
  private void LK()
  {
    if ((this.cOH == null) && (this.cOI != null)) {
      ad.i("MicroMsg.AbstractJSRuntime", "scheduleToJSThread but looper null");
    }
    try
    {
      this.cOI.await(30000L, TimeUnit.MILLISECONDS);
      ad.i("MicroMsg.AbstractJSRuntime", "scheduleToJSThread but looper assigned");
      if (this.cOH == null)
      {
        cOF.run();
        if (this.cOH == null) {
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
    h localh = (h)this.cOR.get(paramV8ScriptException.getContextTag());
    if (localh != null)
    {
      localh.t(paramV8ScriptException.getJSMessage(), paramV8ScriptException.getJSStackTrace());
      return;
    }
    ad.w("MicroMsg.AbstractJSRuntime", "publishJSException jsHandler null %s", new Object[] { paramV8ScriptException });
  }
  
  public final String Br()
  {
    return this.cOH.Br();
  }
  
  public final IJSRuntime.Config LE()
  {
    return this.cOT;
  }
  
  abstract MultiContextV8 LF();
  
  abstract c LG();
  
  abstract void LH();
  
  public final e LI()
  {
    if (this.cOL == null)
    {
      if (!this.cOP) {
        break label38;
      }
      ad.i("MicroMsg.AbstractJSRuntime", "hy: start load native buffer jni");
    }
    label38:
    for (this.cOL = new NativeBufferJNI();; this.cOL = new u()) {
      return this.cOL;
    }
  }
  
  public final boolean LJ()
  {
    return this.cOH.LJ();
  }
  
  public final void a(int paramInt, h paramh)
  {
    if (this.mTid < 0)
    {
      ad.e("MicroMsg.AbstractJSRuntime", "setJsExceptionHandler after destroyed, JsRuntime[%d] stack=%s", new Object[] { Integer.valueOf(hashCode()), Log.getStackTraceString(new Throwable()) });
      return;
    }
    ad.i("MicroMsg.AbstractJSRuntime", "setJsExceptionHandler contextId[%d] JsRuntime[%d] JSThread.id[%d], currentThread.id[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(hashCode()), Integer.valueOf(this.mTid), Long.valueOf(Thread.currentThread().getId()) });
    this.cOR.put(paramInt, paramh);
  }
  
  public final void a(Runnable paramRunnable, long paramLong, boolean paramBoolean)
  {
    LK();
    this.cOH.b(paramRunnable, paramLong, paramBoolean);
  }
  
  public final void cg(boolean paramBoolean)
  {
    this.cOH.cg(paramBoolean);
  }
  
  public final void e(Runnable paramRunnable, long paramLong)
  {
    a(paramRunnable, paramLong, false);
  }
  
  public final long getIsolatePtr()
  {
    return this.cOG.getIsolatePtr();
  }
  
  public final long getUVLoopPtr()
  {
    return this.cOG.getUVLoopPtr();
  }
  
  public final m hE(final int paramInt)
  {
    new m(this, LI(), new m.a()
    {
      public final V8Context LL()
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
    this.cOH.pause();
  }
  
  public final void q(Runnable paramRunnable)
  {
    r(paramRunnable);
  }
  
  public final void quit()
  {
    ad.i("MicroMsg.AbstractJSRuntime", "quit() JsRuntime[%d]", new Object[] { Integer.valueOf(hashCode()) });
    this.cOH.quit();
    this.mTid = -1;
  }
  
  public final void r(Runnable paramRunnable)
  {
    LK();
    this.cOH.t(paramRunnable);
  }
  
  public final void resume()
  {
    this.cOH.resume();
  }
  
  public final void s(Runnable paramRunnable)
  {
    this.cOS.add(paramRunnable);
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
  
  public final void waitForDebugger(String paramString)
  {
    n localn = new n(this.cOG, this);
    localn.cQa.q(new n.1(localn, paramString));
    localn.cQa.s(new n.2(localn));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.a
 * JD-Core Version:    0.7.0.1
 */