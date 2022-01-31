package com.tencent.mm.d.a;

import com.eclipsesource.v8.MultiContextV8;
import com.eclipsesource.v8.V8Locker;
import com.eclipsesource.v8.V8ScriptException;
import com.tencent.mm.plugin.appbrand.i.e;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class h
{
  volatile boolean ahC = true;
  final MultiContextV8 bzA;
  private Thread bzB;
  final ConcurrentLinkedQueue<Runnable> bzC = new ConcurrentLinkedQueue();
  ConcurrentHashMap<Integer, e> bzD = new ConcurrentHashMap();
  volatile boolean sn = false;
  
  h(MultiContextV8 paramMultiContextV8)
  {
    this.bzA = paramMultiContextV8;
    this.bzB = new h.1(this);
    paramMultiContextV8 = this.bzA.getV8Locker();
    if (paramMultiContextV8.hasLock()) {
      paramMultiContextV8.release();
    }
    this.bzB.start();
  }
  
  public final void i(Runnable arg1)
  {
    if (Thread.currentThread().getId() == this.bzB.getId())
    {
      y.i("MicroMsg.J2V8.V8EngineLooper", "schedule same thread");
      j(???);
      return;
    }
    this.bzC.offer(???);
    synchronized (this.bzC)
    {
      this.bzC.notify();
      return;
    }
  }
  
  final void j(Runnable paramRunnable)
  {
    try
    {
      paramRunnable.run();
      return;
    }
    catch (V8ScriptException paramRunnable)
    {
      y.e("MicroMsg.J2V8.V8EngineLooper", "runTask contextTag:%d V8ScriptException: %s", new Object[] { Integer.valueOf(paramRunnable.getContextTag()), paramRunnable });
      e locale = (e)this.bzD.get(Integer.valueOf(paramRunnable.getContextTag()));
      if (locale != null)
      {
        locale.x(paramRunnable.getJSMessage(), paramRunnable.getJSStackTrace());
        return;
      }
      y.e("MicroMsg.J2V8.V8EngineLooper", "runTask V8ScriptException jsHandler null");
      return;
    }
    catch (UndeclaredThrowableException paramRunnable)
    {
      y.e("MicroMsg.J2V8.V8EngineLooper", "runTask UndeclaredThrowableException: %s %s", new Object[] { paramRunnable, paramRunnable.getCause() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.d.a.h
 * JD-Core Version:    0.7.0.1
 */