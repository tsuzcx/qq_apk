package com.tencent.magicbrush.c;

import a.f.b.j;
import a.l;
import a.m;
import a.y;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.a.c.c;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/magicbrush/ui/AnimationFrameHandler;", "", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "jsThreadHandler", "Lcom/tencent/magicbrush/handler/IJsThreadHandler;", "(Lcom/tencent/magicbrush/MBRuntime;Lcom/tencent/magicbrush/handler/IJsThreadHandler;)V", "isRunning", "", "()Z", "setRunning", "(Z)V", "getJsThreadHandler", "()Lcom/tencent/magicbrush/handler/IJsThreadHandler;", "locker", "Ljava/lang/Object;", "getLocker", "()Ljava/lang/Object;", "getRuntime", "()Lcom/tencent/magicbrush/MBRuntime;", "strategy", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getStrategy", "()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "create", "", "destroy", "getLatency", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Latency;", "notifyAnimationFrame", "frameTimeMillis", "", "onCreate", "onDestroy", "onPause", "onResume", "pause", "resume", "Companion", "Latency", "Strategy", "lib-magicbrush-nano_release"})
public abstract class a
{
  public static final a.a bLn = new a.a((byte)0);
  private final MBRuntime bJe;
  public final Object bLl;
  final com.tencent.magicbrush.handler.a bLm;
  public boolean isRunning;
  
  public a(MBRuntime paramMBRuntime, com.tencent.magicbrush.handler.a parama)
  {
    this.bJe = paramMBRuntime;
    this.bLm = parama;
    this.bLl = new Object();
  }
  
  public static final a a(MBRuntime paramMBRuntime, com.tencent.magicbrush.handler.a parama, a.b paramb)
  {
    j.q(paramMBRuntime, "runtime");
    j.q(parama, "jsThreadHandler");
    j.q(paramb, "strategy");
    switch (b.bLo[paramb.ordinal()])
    {
    default: 
      throw new m();
    case 1: 
      paramMBRuntime = (a)new c(paramMBRuntime, parama);
    }
    for (;;)
    {
      parama = new StringBuilder("AnimationFrameHandler[").append(paramMBRuntime.yx().name()).append("] create ");
      paramb = Thread.currentThread();
      j.p(paramb, "Thread.currentThread()");
      c.c.i("AnimationFrameHandler", paramb.getName(), new Object[0]);
      paramMBRuntime.onCreate();
      return paramMBRuntime;
      paramMBRuntime = (a)new d(paramMBRuntime, parama);
      continue;
      paramMBRuntime = (a)new e(paramMBRuntime, parama);
      continue;
      paramMBRuntime = (a)new h(paramMBRuntime, parama);
    }
  }
  
  public final void notifyAnimationFrame(double paramDouble)
  {
    this.bJe.notifyAnimationFrame(paramDouble);
  }
  
  public abstract void onCreate();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public final void pause()
  {
    c.c.i("AnimationFrameHandler", "AnimationFrameHandler[%s] pause", new Object[] { yx().name() });
    synchronized (this.bLl)
    {
      boolean bool = this.isRunning;
      if (!bool) {
        return;
      }
      onPause();
      this.isRunning = false;
      y localy = y.BMg;
      return;
    }
  }
  
  public abstract a.b yx();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.magicbrush.c.a
 * JD-Core Version:    0.7.0.1
 */