package com.tencent.magicbrush.ui;

import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import d.m;
import d.z;

@l(gfx={1, 1, 13}, gfy={""}, gfz={"Lcom/tencent/magicbrush/ui/AnimationFrameHandler;", "", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "jsThreadHandler", "Lcom/tencent/magicbrush/handler/MBJsThreadHandler;", "(Lcom/tencent/magicbrush/MBRuntime;Lcom/tencent/magicbrush/handler/MBJsThreadHandler;)V", "isRunning", "", "()Z", "setRunning", "(Z)V", "getJsThreadHandler", "()Lcom/tencent/magicbrush/handler/MBJsThreadHandler;", "locker", "Ljava/lang/Object;", "getLocker", "()Ljava/lang/Object;", "getRuntime", "()Lcom/tencent/magicbrush/MBRuntime;", "strategy", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getStrategy", "()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "create", "", "destroy", "getLatency", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Latency;", "notifyAnimationFrame", "frameTimeMillis", "", "onCreate", "onDestroy", "onPause", "onResume", "pause", "resume", "Companion", "Latency", "Strategy", "lib-magicbrush-nano_release"})
public abstract class a
{
  public static final a czK = new a((byte)0);
  final MBRuntime cvY;
  final Object czI;
  final com.tencent.magicbrush.handler.c czJ;
  boolean isRunning;
  
  public a(MBRuntime paramMBRuntime, com.tencent.magicbrush.handler.c paramc)
  {
    this.cvY = paramMBRuntime;
    this.czJ = paramc;
    this.czI = new Object();
  }
  
  public static final a a(MBRuntime paramMBRuntime, com.tencent.magicbrush.handler.c paramc, a.b paramb)
  {
    return a.a(paramMBRuntime, paramc, paramb);
  }
  
  public abstract a.b HE();
  
  public final void destroy()
  {
    c.c.i("AnimationFrameHandler", "AnimationFrameHandler[%s] destroy", new Object[] { HE().name() });
    synchronized (this.czI)
    {
      if (this.isRunning)
      {
        c.c.i("AnimationFrameHandler", "AnimationFrameHandler[%s] pause automatically", new Object[] { HE().name() });
        pause();
      }
      z localz = z.MKo;
      return;
    }
  }
  
  public final void g(double paramDouble)
  {
    this.cvY.g(paramDouble);
  }
  
  public abstract void onCreate();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public final void pause()
  {
    c.c.i("AnimationFrameHandler", "AnimationFrameHandler[%s] pause", new Object[] { HE().name() });
    synchronized (this.czI)
    {
      boolean bool = this.isRunning;
      if (!bool) {
        return;
      }
      onPause();
      this.isRunning = false;
      z localz = z.MKo;
      return;
    }
  }
  
  public final void resume()
  {
    c.c.i("AnimationFrameHandler", "AnimationFrameHandler[%s] resume", new Object[] { HE().name() });
    synchronized (this.czI)
    {
      boolean bool = this.isRunning;
      if (bool) {
        return;
      }
      onResume();
      this.isRunning = true;
      z localz = z.MKo;
      return;
    }
  }
  
  @l(gfx={1, 1, 13}, gfy={""}, gfz={"Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Companion;", "", "()V", "TAG", "", "create", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "jsThreadHandler", "Lcom/tencent/magicbrush/handler/MBJsThreadHandler;", "strategy", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "lib-magicbrush-nano_release"})
  public static final class a
  {
    public static a a(MBRuntime paramMBRuntime, com.tencent.magicbrush.handler.c paramc, a.b paramb)
    {
      AppMethodBeat.i(215123);
      p.h(paramMBRuntime, "runtime");
      p.h(paramc, "jsThreadHandler");
      p.h(paramb, "strategy");
      switch (b.cpQ[paramb.ordinal()])
      {
      default: 
        paramMBRuntime = new m();
        AppMethodBeat.o(215123);
        throw paramMBRuntime;
      case 1: 
        paramMBRuntime = (a)new c(paramMBRuntime, paramc);
      }
      for (;;)
      {
        a.a(paramMBRuntime);
        AppMethodBeat.o(215123);
        return paramMBRuntime;
        paramMBRuntime = (a)new d(paramMBRuntime, paramc);
        continue;
        paramMBRuntime = (a)new e(paramMBRuntime, paramc);
        continue;
        paramMBRuntime = (a)new k(paramMBRuntime, paramc);
        continue;
        paramMBRuntime = (a)new j(paramMBRuntime, paramc);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.ui.a
 * JD-Core Version:    0.7.0.1
 */