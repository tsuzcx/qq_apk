package com.tencent.magicbrush.ui;

import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.m;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/magicbrush/ui/AnimationFrameHandler;", "", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "jsThreadHandler", "Lcom/tencent/magicbrush/handler/MBJsThreadHandler;", "(Lcom/tencent/magicbrush/MBRuntime;Lcom/tencent/magicbrush/handler/MBJsThreadHandler;)V", "isRunning", "", "()Z", "setRunning", "(Z)V", "getJsThreadHandler", "()Lcom/tencent/magicbrush/handler/MBJsThreadHandler;", "locker", "Ljava/lang/Object;", "getLocker", "()Ljava/lang/Object;", "getRuntime", "()Lcom/tencent/magicbrush/MBRuntime;", "strategy", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getStrategy", "()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "create", "", "destroy", "getLatency", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Latency;", "notifyAnimationFrame", "frameTimeMillis", "", "onCreate", "onDestroy", "onPause", "onResume", "pause", "resume", "Companion", "Latency", "Strategy", "lib-magicbrush-nano_release"})
public abstract class a
{
  public static final a cOx = new a((byte)0);
  final MBRuntime cKJ;
  final Object cOv;
  final com.tencent.magicbrush.handler.c cOw;
  boolean isRunning;
  
  public a(MBRuntime paramMBRuntime, com.tencent.magicbrush.handler.c paramc)
  {
    this.cKJ = paramMBRuntime;
    this.cOw = paramc;
    this.cOv = new Object();
  }
  
  public static final a a(MBRuntime paramMBRuntime, com.tencent.magicbrush.handler.c paramc, b paramb)
  {
    return a.a(paramMBRuntime, paramc, paramb);
  }
  
  public abstract b RB();
  
  public final void destroy()
  {
    c.c.i("AnimationFrameHandler", "AnimationFrameHandler[%s] destroy", new Object[] { RB().name() });
    synchronized (this.cOv)
    {
      if (this.isRunning)
      {
        c.c.i("AnimationFrameHandler", "AnimationFrameHandler[%s] pause automatically", new Object[] { RB().name() });
        pause();
      }
      x localx = x.SXb;
      return;
    }
  }
  
  public final void h(double paramDouble)
  {
    this.cKJ.h(paramDouble);
  }
  
  public abstract void onCreate();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public final void pause()
  {
    c.c.i("AnimationFrameHandler", "AnimationFrameHandler[%s] pause", new Object[] { RB().name() });
    synchronized (this.cOv)
    {
      boolean bool = this.isRunning;
      if (!bool) {
        return;
      }
      onPause();
      this.isRunning = false;
      x localx = x.SXb;
      return;
    }
  }
  
  public final void resume()
  {
    c.c.i("AnimationFrameHandler", "AnimationFrameHandler[%s] resume", new Object[] { RB().name() });
    synchronized (this.cOv)
    {
      boolean bool = this.isRunning;
      if (bool) {
        return;
      }
      onResume();
      this.isRunning = true;
      x localx = x.SXb;
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Companion;", "", "()V", "TAG", "", "create", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "jsThreadHandler", "Lcom/tencent/magicbrush/handler/MBJsThreadHandler;", "strategy", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "lib-magicbrush-nano_release"})
  public static final class a
  {
    public static a a(MBRuntime paramMBRuntime, com.tencent.magicbrush.handler.c paramc, a.b paramb)
    {
      AppMethodBeat.i(206868);
      p.h(paramMBRuntime, "runtime");
      p.h(paramc, "jsThreadHandler");
      p.h(paramb, "strategy");
      switch (b.$EnumSwitchMapping$0[paramb.ordinal()])
      {
      default: 
        paramMBRuntime = new m();
        AppMethodBeat.o(206868);
        throw paramMBRuntime;
      case 1: 
        paramMBRuntime = (a)new c(paramMBRuntime, paramc);
      }
      for (;;)
      {
        a.a(paramMBRuntime);
        AppMethodBeat.o(206868);
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "", "(Ljava/lang/String;I)V", "ChoreographerInJsThread", "ChoreographerInMainThread", "EglSurfaceSwapLocker", "SchedulerLocker", "NativeLocker", "lib-magicbrush-nano_release"})
  public static enum b
  {
    static
    {
      AppMethodBeat.i(140205);
      b localb1 = new b("ChoreographerInJsThread", 0);
      cOy = localb1;
      b localb2 = new b("ChoreographerInMainThread", 1);
      cOz = localb2;
      b localb3 = new b("EglSurfaceSwapLocker", 2);
      cOA = localb3;
      b localb4 = new b("SchedulerLocker", 3);
      cOB = localb4;
      b localb5 = new b("NativeLocker", 4);
      cOC = localb5;
      cOD = new b[] { localb1, localb2, localb3, localb4, localb5 };
      AppMethodBeat.o(140205);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.magicbrush.ui.a
 * JD-Core Version:    0.7.0.1
 */