package com.tencent.magicbrush.ui;

import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.p;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/magicbrush/ui/AnimationFrameHandler;", "", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "jsThreadHandler", "Lcom/tencent/magicbrush/handler/MBJsThreadHandler;", "(Lcom/tencent/magicbrush/MBRuntime;Lcom/tencent/magicbrush/handler/MBJsThreadHandler;)V", "isRunning", "", "()Z", "setRunning", "(Z)V", "getJsThreadHandler", "()Lcom/tencent/magicbrush/handler/MBJsThreadHandler;", "locker", "Ljava/lang/Object;", "getLocker", "()Ljava/lang/Object;", "getRuntime", "()Lcom/tencent/magicbrush/MBRuntime;", "strategy", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getStrategy", "()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "create", "", "destroy", "getLatency", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Latency;", "notifyAnimationFrame", "frameTimeMillis", "", "onCreate", "onDestroy", "onPause", "onResume", "pause", "resume", "Companion", "Latency", "Strategy", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 16})
public abstract class a
{
  public static final a eKr = new a((byte)0);
  boolean Uz;
  final MBRuntime eGN;
  final Object eKp;
  final com.tencent.magicbrush.handler.c eKq;
  
  public a(MBRuntime paramMBRuntime, com.tencent.magicbrush.handler.c paramc)
  {
    this.eGN = paramMBRuntime;
    this.eKq = paramc;
    this.eKp = new Object();
  }
  
  public static final a a(MBRuntime paramMBRuntime, com.tencent.magicbrush.handler.c paramc, b paramb)
  {
    return a.a(paramMBRuntime, paramc, paramb);
  }
  
  public abstract b avR();
  
  public final void destroy()
  {
    c.c.i("AnimationFrameHandler", "AnimationFrameHandler[%s] destroy", new Object[] { avR().name() });
    synchronized (this.eKp)
    {
      if (this.Uz)
      {
        c.c.i("AnimationFrameHandler", "AnimationFrameHandler[%s] pause automatically", new Object[] { avR().name() });
        pause();
      }
      ah localah = ah.aiuX;
      return;
    }
  }
  
  public abstract void onCreate();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public final void pause()
  {
    c.c.i("AnimationFrameHandler", "AnimationFrameHandler[%s] pause", new Object[] { avR().name() });
    synchronized (this.eKp)
    {
      boolean bool = this.Uz;
      if (!bool) {
        return;
      }
      onPause();
      this.Uz = false;
      ah localah = ah.aiuX;
      return;
    }
  }
  
  public final void resume()
  {
    c.c.i("AnimationFrameHandler", "AnimationFrameHandler[%s] resume", new Object[] { avR().name() });
    synchronized (this.eKp)
    {
      boolean bool = this.Uz;
      if (bool) {
        return;
      }
      onResume();
      this.Uz = true;
      ah localah = ah.aiuX;
      return;
    }
  }
  
  public final void x(double paramDouble)
  {
    this.eGN.x(paramDouble);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Companion;", "", "()V", "TAG", "", "create", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "jsThreadHandler", "Lcom/tencent/magicbrush/handler/MBJsThreadHandler;", "strategy", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 16})
  public static final class a
  {
    public static a a(MBRuntime paramMBRuntime, com.tencent.magicbrush.handler.c paramc, a.b paramb)
    {
      AppMethodBeat.i(229016);
      s.t(paramMBRuntime, "runtime");
      s.t(paramc, "jsThreadHandler");
      s.t(paramb, "strategy");
      switch (b.$EnumSwitchMapping$0[paramb.ordinal()])
      {
      default: 
        paramMBRuntime = new p();
        AppMethodBeat.o(229016);
        throw paramMBRuntime;
      case 1: 
        paramMBRuntime = (a)new c(paramMBRuntime, paramc);
      }
      for (;;)
      {
        a.a(paramMBRuntime);
        AppMethodBeat.o(229016);
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
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "", "(Ljava/lang/String;I)V", "ChoreographerInJsThread", "ChoreographerInMainThread", "EglSurfaceSwapLocker", "SchedulerLocker", "NativeLocker", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 16})
  public static enum b
  {
    static
    {
      AppMethodBeat.i(140205);
      b localb1 = new b("ChoreographerInJsThread", 0);
      eKs = localb1;
      b localb2 = new b("ChoreographerInMainThread", 1);
      eKt = localb2;
      b localb3 = new b("EglSurfaceSwapLocker", 2);
      eKu = localb3;
      b localb4 = new b("SchedulerLocker", 3);
      eKv = localb4;
      b localb5 = new b("NativeLocker", 4);
      eKw = localb5;
      eKx = new b[] { localb1, localb2, localb3, localb4, localb5 };
      AppMethodBeat.o(140205);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.magicbrush.ui.a
 * JD-Core Version:    0.7.0.1
 */