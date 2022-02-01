package com.tencent.magicbrush.ui;

import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import d.m;
import d.y;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/magicbrush/ui/AnimationFrameHandler;", "", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "jsThreadHandler", "Lcom/tencent/magicbrush/handler/MBJsThreadHandler;", "(Lcom/tencent/magicbrush/MBRuntime;Lcom/tencent/magicbrush/handler/MBJsThreadHandler;)V", "isRunning", "", "()Z", "setRunning", "(Z)V", "getJsThreadHandler", "()Lcom/tencent/magicbrush/handler/MBJsThreadHandler;", "locker", "Ljava/lang/Object;", "getLocker", "()Ljava/lang/Object;", "getRuntime", "()Lcom/tencent/magicbrush/MBRuntime;", "strategy", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getStrategy", "()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "create", "", "destroy", "getLatency", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Latency;", "notifyAnimationFrame", "frameTimeMillis", "", "onCreate", "onDestroy", "onPause", "onResume", "pause", "resume", "Companion", "Latency", "Strategy", "lib-magicbrush-nano_release"})
public abstract class a
{
  public static final a crN = new a((byte)0);
  private final MBRuntime cou;
  final Object crL;
  final com.tencent.magicbrush.handler.c crM;
  boolean isRunning;
  
  public a(MBRuntime paramMBRuntime, com.tencent.magicbrush.handler.c paramc)
  {
    this.cou = paramMBRuntime;
    this.crM = paramc;
    this.crL = new Object();
  }
  
  public static final a a(MBRuntime paramMBRuntime, com.tencent.magicbrush.handler.c paramc, b paramb)
  {
    return a.a(paramMBRuntime, paramc, paramb);
  }
  
  public abstract b Gx();
  
  public final void destroy()
  {
    c.c.i("AnimationFrameHandler", "AnimationFrameHandler[%s] destroy", new Object[] { Gx().name() });
    synchronized (this.crL)
    {
      if (this.isRunning)
      {
        c.c.i("AnimationFrameHandler", "AnimationFrameHandler[%s] pause automatically", new Object[] { Gx().name() });
        pause();
      }
      y localy = y.JfV;
      return;
    }
  }
  
  public final void g(double paramDouble)
  {
    this.cou.g(paramDouble);
  }
  
  public abstract void onCreate();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public final void pause()
  {
    c.c.i("AnimationFrameHandler", "AnimationFrameHandler[%s] pause", new Object[] { Gx().name() });
    synchronized (this.crL)
    {
      boolean bool = this.isRunning;
      if (!bool) {
        return;
      }
      onPause();
      this.isRunning = false;
      y localy = y.JfV;
      return;
    }
  }
  
  public final void resume()
  {
    c.c.i("AnimationFrameHandler", "AnimationFrameHandler[%s] resume", new Object[] { Gx().name() });
    synchronized (this.crL)
    {
      boolean bool = this.isRunning;
      if (bool) {
        return;
      }
      onResume();
      this.isRunning = true;
      y localy = y.JfV;
      return;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Companion;", "", "()V", "TAG", "", "create", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "jsThreadHandler", "Lcom/tencent/magicbrush/handler/MBJsThreadHandler;", "strategy", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "lib-magicbrush-nano_release"})
  public static final class a
  {
    public static a a(MBRuntime paramMBRuntime, com.tencent.magicbrush.handler.c paramc, a.b paramb)
    {
      AppMethodBeat.i(193573);
      k.h(paramMBRuntime, "runtime");
      k.h(paramc, "jsThreadHandler");
      k.h(paramb, "strategy");
      switch (b.ciE[paramb.ordinal()])
      {
      default: 
        paramMBRuntime = new m();
        AppMethodBeat.o(193573);
        throw paramMBRuntime;
      case 1: 
        paramMBRuntime = (a)new c(paramMBRuntime, paramc);
      }
      for (;;)
      {
        a.a(paramMBRuntime);
        AppMethodBeat.o(193573);
        return paramMBRuntime;
        paramMBRuntime = (a)new d(paramMBRuntime, paramc);
        continue;
        paramMBRuntime = (a)new e(paramMBRuntime, paramc);
        continue;
        paramMBRuntime = (a)new j(paramMBRuntime, paramc);
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "", "(Ljava/lang/String;I)V", "ChoreographerInJsThread", "ChoreographerInMainThread", "EglSurfaceSwapLocker", "SchedulerLocker", "lib-magicbrush-nano_release"})
  public static enum b
  {
    static
    {
      AppMethodBeat.i(140205);
      b localb1 = new b("ChoreographerInJsThread", 0);
      crO = localb1;
      b localb2 = new b("ChoreographerInMainThread", 1);
      crP = localb2;
      b localb3 = new b("EglSurfaceSwapLocker", 2);
      crQ = localb3;
      b localb4 = new b("SchedulerLocker", 3);
      crR = localb4;
      crS = new b[] { localb1, localb2, localb3, localb4 };
      AppMethodBeat.o(140205);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.ui.a
 * JD-Core Version:    0.7.0.1
 */