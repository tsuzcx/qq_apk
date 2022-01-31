package com.tencent.mm.d.a;

import android.os.Process;
import com.eclipsesource.v8.MultiContextV8;
import com.eclipsesource.v8.V8ScriptException;
import com.eclipsesource.v8.utils.MemoryManager;
import com.tencent.mm.plugin.appbrand.i.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class a
  implements c
{
  private static int caZ = 0;
  private MultiContextV8 cba;
  private d cbb;
  private CountDownLatch cbc;
  private MemoryManager cbd;
  private x cbe;
  f cbf;
  String cbg;
  byte[] cbh;
  private final Map<Integer, h> cbi;
  private final ConcurrentLinkedQueue<Runnable> cbj;
  private volatile int mTid = -1;
  
  a()
  {
    this(null, null);
  }
  
  a(String paramString, byte[] paramArrayOfByte)
  {
    this.cbg = paramString;
    this.cbh = paramArrayOfByte;
    this.cbi = new HashMap();
    this.cbj = new ConcurrentLinkedQueue();
    paramString = new CountDownLatch(1);
    this.cbc = new CountDownLatch(1);
    int i = caZ;
    caZ = i + 1;
    new a.2(this, String.format("JSRuntimeLooper#%d", new Object[] { Integer.valueOf(i) }), paramString).start();
    try
    {
      paramString.await(5000L, TimeUnit.MILLISECONDS);
      return;
    }
    catch (InterruptedException paramString)
    {
      ab.i("MicroMsg.AbstractJSRuntime", "init latch.await InterruptedException:%s", new Object[] { paramString });
    }
  }
  
  private void Cm()
  {
    if ((this.cbb == null) && (this.cbc != null)) {
      ab.i("MicroMsg.AbstractJSRuntime", "scheduleToJSThread but looper null");
    }
    try
    {
      this.cbc.await(30000L, TimeUnit.MILLISECONDS);
      ab.i("MicroMsg.AbstractJSRuntime", "scheduleToJSThread but looper assigned");
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        ab.i("MicroMsg.AbstractJSRuntime", "scheduleToJSThread latch.await InterruptedException:%s", new Object[] { localInterruptedException });
      }
    }
  }
  
  private void a(V8ScriptException paramV8ScriptException)
  {
    h localh = (h)this.cbi.get(Integer.valueOf(paramV8ScriptException.getContextTag()));
    if (localh != null)
    {
      localh.s(paramV8ScriptException.getJSMessage(), paramV8ScriptException.getJSStackTrace());
      return;
    }
    ab.w("MicroMsg.AbstractJSRuntime", "publishJSException jsHandler null %s", new Object[] { paramV8ScriptException });
  }
  
  abstract MultiContextV8 Ch();
  
  abstract d Ci();
  
  abstract void Cj();
  
  public final f Ck()
  {
    if (this.cbf == null) {
      this.cbf = new s();
    }
    return this.cbf;
  }
  
  public final boolean Cl()
  {
    return this.cbb.Cl();
  }
  
  public final void a(int paramInt, h paramh)
  {
    this.cbi.put(Integer.valueOf(paramInt), paramh);
  }
  
  public final void f(Runnable paramRunnable, long paramLong)
  {
    Cm();
    this.cbb.g(paramRunnable, paramLong);
  }
  
  public final long getIsolatePtr()
  {
    return this.cba.getIsolatePtr();
  }
  
  public final l gg(int paramInt)
  {
    return new l(this, Ck(), new a.1(this, paramInt));
  }
  
  public final void k(Runnable paramRunnable)
  {
    Cm();
    this.cbb.m(paramRunnable);
  }
  
  public final void l(Runnable paramRunnable)
  {
    this.cbj.add(paramRunnable);
  }
  
  public final void pause()
  {
    this.cbb.pause();
  }
  
  public final void quit()
  {
    this.cbb.quit();
    this.mTid = -1;
  }
  
  public final void resume()
  {
    this.cbb.resume();
  }
  
  public final void setThreadPriority(int paramInt)
  {
    int i = this.mTid;
    if (i > 0) {}
    try
    {
      Process.setThreadPriority(i, paramInt);
      ab.d("MicroMsg.AbstractJSRuntime", "setThreadPriority priority=%d tid=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.AbstractJSRuntime", localException, "setThreadPriority priority=%d tid=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    }
  }
  
  public final void waitForDebugger(String paramString)
  {
    m localm = new m(this.cba, this);
    localm.cbT.k(new m.1(localm, paramString));
    localm.cbT.l(new m.2(localm));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.d.a.a
 * JD-Core Version:    0.7.0.1
 */