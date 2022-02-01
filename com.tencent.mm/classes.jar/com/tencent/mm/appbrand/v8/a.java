package com.tencent.mm.appbrand.v8;

import android.os.Process;
import android.text.TextUtils;
import android.util.SparseArray;
import com.eclipsesource.mmv8.MultiContextV8;
import com.eclipsesource.mmv8.V8;
import com.eclipsesource.mmv8.V8Context;
import com.eclipsesource.mmv8.V8Locker;
import com.eclipsesource.mmv8.V8ScriptException;
import com.eclipsesource.mmv8.utils.MemoryManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.n.h;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class a
  implements IJSRuntime
{
  private static final AtomicInteger hlE = new AtomicInteger(0);
  private static Runnable hlF = new a.1();
  private MultiContextV8 hlG;
  private c hlH;
  private CountDownLatch hlI;
  private MemoryManager hlJ;
  private aa hlK;
  private e hlL;
  private String hlM = "RuntimeLooper";
  String hlN;
  byte[] hlO;
  String hlP;
  boolean hlQ;
  boolean hlR;
  private final boolean hlS;
  final boolean hlT;
  private final SparseArray<h> hlU;
  private final ConcurrentLinkedQueue<Runnable> hlV;
  private final IJSRuntime.Config hlW;
  private volatile int mTid = -1;
  
  a(final IJSRuntime.Config paramConfig)
  {
    IJSRuntime.Config localConfig;
    label136:
    boolean bool1;
    boolean bool2;
    if (paramConfig != null)
    {
      if (!TextUtils.isEmpty(paramConfig.hmb)) {
        paramConfig.hmb = y.n(paramConfig.hmb, true);
      }
      this.hlN = paramConfig.hmb;
      this.hlO = paramConfig.hmc;
      this.hlS = paramConfig.useNativeBufferJNI();
      this.hlR = paramConfig.hmf;
      this.hlT = paramConfig.hmg;
      this.hlP = paramConfig.hmi;
      this.hlL = paramConfig.hmm;
      if (!Util.isNullOrNil(paramConfig.hmj)) {
        this.hlM = paramConfig.hmj;
      }
      this.hlQ = paramConfig.hmk;
      if (paramConfig != null) {
        break label308;
      }
      localConfig = new IJSRuntime.Config();
      this.hlW = localConfig;
      bool1 = this.hlS;
      bool2 = this.hlT;
      if (paramConfig == null) {
        break label314;
      }
    }
    label308:
    label314:
    for (paramConfig = paramConfig.toString();; paramConfig = "")
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AbstractJSRuntime", "<init> hy: use native buffer: %b, hasGlobalTimer: %b, config: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), paramConfig });
      this.hlU = new SparseArray();
      this.hlV = new ConcurrentLinkedQueue();
      paramConfig = new CountDownLatch(1);
      this.hlI = new CountDownLatch(1);
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AbstractJSRuntime", "startLooper");
      new Thread(String.format(Locale.US, "JS%s#%d", new Object[] { this.hlM, Integer.valueOf(hlE.getAndIncrement()) }))
      {
        public final void run()
        {
          AppMethodBeat.i(143991);
          a.a(a.this, Process.myTid());
          a.hlF.run();
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AbstractJSRuntime", "expansions file is ready");
          a.a(a.this, a.this.aDU());
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
          a.a(a.this, a.this.aDT());
          a.a(a.this).getV8().setDelaySaveCodeCache(a.this.hlQ);
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
          a.b(a.this).aEa();
          a.f(a.this);
          a.g(a.this).release();
          a.e(a.this);
          try
          {
            a.h(a.this).clear();
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AbstractJSRuntime", "whenThreadEnd, mJSExceptionHandlerMap.clear() succeed, JsRuntime[%d]", new Object[] { Integer.valueOf(a.this.hashCode()) });
            a.this.aDV();
            AppMethodBeat.o(143991);
            return;
          }
          finally
          {
            for (;;)
            {
              com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AbstractJSRuntime", "whenThreadEnd, mJSExceptionHandlerMap.clear(), JsRuntime[%d] get exception[%s]", new Object[] { Integer.valueOf(a.this.hashCode()), localObject });
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
      this.hlS = false;
      this.hlT = false;
      break;
      localConfig = paramConfig;
      break label136;
    }
  }
  
  private void a(V8ScriptException paramV8ScriptException)
  {
    synchronized (this.hlU)
    {
      h localh = (h)this.hlU.get(paramV8ScriptException.getContextTag());
      if (localh != null)
      {
        localh.handleException(paramV8ScriptException.getJSMessage(), paramV8ScriptException.getJSStackTrace());
        return;
      }
    }
    com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AbstractJSRuntime", "publishJSException jsHandler null %s", new Object[] { paramV8ScriptException });
  }
  
  private void aDY()
  {
    if ((this.hlH == null) && (this.hlI != null)) {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AbstractJSRuntime", "scheduleToJSThread but looper null");
    }
    try
    {
      this.hlI.await(30000L, TimeUnit.MILLISECONDS);
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AbstractJSRuntime", "scheduleToJSThread but looper assigned");
      if (this.hlH == null)
      {
        hlF.run();
        if (this.hlH == null) {
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
  
  public final void a(int paramInt, h paramh)
  {
    if (this.mTid < 0)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AbstractJSRuntime", "setJsExceptionHandler after destroyed, JsRuntime[%d] stack=%s", new Object[] { Integer.valueOf(hashCode()), android.util.Log.getStackTraceString(new Throwable()) });
      return;
    }
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AbstractJSRuntime", "setJsExceptionHandler contextId[%d] JsRuntime[%d] JSThread.id[%d], currentThread.id[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(hashCode()), Integer.valueOf(this.mTid), Long.valueOf(Thread.currentThread().getId()) });
    synchronized (this.hlU)
    {
      this.hlU.put(paramInt, paramh);
      return;
    }
  }
  
  public final void a(Runnable paramRunnable, long paramLong, boolean paramBoolean)
  {
    aDY();
    this.hlH.b(paramRunnable, paramLong, paramBoolean);
  }
  
  public final IJSRuntime.Config aDS()
  {
    return this.hlW;
  }
  
  abstract MultiContextV8 aDT();
  
  abstract c aDU();
  
  abstract void aDV();
  
  public final e aDW()
  {
    if (this.hlL == null)
    {
      if (!this.hlS) {
        break label38;
      }
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AbstractJSRuntime", "hy: start load native buffer jni");
    }
    label38:
    for (this.hlL = new NativeBufferJNI();; this.hlL = new u()) {
      return this.hlL;
    }
  }
  
  public final boolean aDX()
  {
    return this.hlH.aDX();
  }
  
  public final String aoO()
  {
    return this.hlH.aoO();
  }
  
  public final boolean doInnerLoopTask()
  {
    return this.hlH.doInnerLoopTask();
  }
  
  public final void e(Runnable paramRunnable, long paramLong)
  {
    a(paramRunnable, paramLong, false);
  }
  
  public final void eb(boolean paramBoolean)
  {
    this.hlH.eb(paramBoolean);
  }
  
  public final long getIsolatePtr()
  {
    return this.hlG.getIsolatePtr();
  }
  
  public final long getUVLoopPtr()
  {
    return this.hlG.getUVLoopPtr();
  }
  
  public final void nM(int paramInt)
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
  
  public final m nN(final int paramInt)
  {
    new m(this, aDW(), new m.a()
    {
      public final V8Context aDZ()
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
    this.hlH.pause();
  }
  
  public final void quit()
  {
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AbstractJSRuntime", "quit() JsRuntime[%d]", new Object[] { Integer.valueOf(hashCode()) });
    this.hlH.quit();
    this.mTid = -1;
  }
  
  public final void resume()
  {
    this.hlH.resume();
  }
  
  public final void resumeLoopTasks()
  {
    this.hlH.resumeLoopTasks();
  }
  
  public final void u(Runnable paramRunnable)
  {
    v(paramRunnable);
  }
  
  public final void v(Runnable paramRunnable)
  {
    aDY();
    this.hlH.x(paramRunnable);
  }
  
  public final void w(Runnable paramRunnable)
  {
    this.hlV.add(paramRunnable);
  }
  
  public final void waitForDebugger(String paramString)
  {
    n localn = new n(this.hlG, this);
    localn.hnh.u(new n.1(localn, paramString));
    localn.hnh.w(new n.2(localn));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.a
 * JD-Core Version:    0.7.0.1
 */