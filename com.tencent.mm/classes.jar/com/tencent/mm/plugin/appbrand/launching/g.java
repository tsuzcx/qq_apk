package com.tencent.mm.plugin.appbrand.launching;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.g.d.a;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.function.Function;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib;", "", "()V", "TAG", "", "runningTasks", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$ITaskMap;", "obtainTask", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$Task;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "waitFor", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$IWaitForCommLibTask;", "function", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "", "Lcom/tencent/mm/plugin/appbrand/launching/NotifyInvoke;", "ITaskMap", "IWaitForCommLibTask", "Task", "TaskMapApi24", "TaskMapApiBase", "plugin-appbrand-integration_release"})
public final class g
{
  private static final a mRu;
  public static final g mRv;
  
  static
  {
    AppMethodBeat.i(50746);
    mRv = new g();
    if (Build.VERSION.SDK_INT >= 24) {}
    for (a locala = (a)new d();; locala = (a)new g.e())
    {
      mRu = locala;
      AppMethodBeat.o(50746);
      return;
    }
  }
  
  public static final b a(com.tencent.mm.plugin.appbrand.q paramq, b<? super ICommLibReader, x> paramb)
  {
    AppMethodBeat.i(228617);
    p.h(paramq, "runtime");
    p.h(paramb, "function");
    if (paramq.bqZ() != null)
    {
      paramq = paramq.bqZ();
      p.g(paramq, "runtime.libReader");
      paramb.invoke(paramq);
      AppMethodBeat.o(228617);
      return null;
    }
    mRu.a(paramq, (a)new f(paramq));
    paramq = mRu.B(paramq);
    paramq.w(paramb);
    paramq = (b)paramq;
    AppMethodBeat.o(228617);
    return paramq;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$ITaskMap;", "", "get", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$Task;", "key", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "putIfAbsent", "", "function", "Lkotlin/Function0;", "remove", "plugin-appbrand-integration_release"})
  static abstract interface a
  {
    public abstract g.c B(com.tencent.mm.plugin.appbrand.q paramq);
    
    public abstract g.c C(com.tencent.mm.plugin.appbrand.q paramq);
    
    public abstract void a(com.tencent.mm.plugin.appbrand.q paramq, a<g.c> parama);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$IWaitForCommLibTask;", "", "interrupt", "", "plugin-appbrand-integration_release"})
  public static abstract interface b
  {
    public abstract void interrupt();
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$Task;", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$IWaitForCommLibTask;", "()V", "callbackContendGuard", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "callbacks", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "", "Lcom/tencent/mm/plugin/appbrand/launching/NotifyInvoke;", "interrupted", "Ljava/util/concurrent/atomic/AtomicBoolean;", "loadedLibReader", "taskStarted", "interrupt", "startTask", "waitFor", "function", "plugin-appbrand-integration_release"})
  static final class c
    implements g.b
  {
    final ReentrantReadWriteLock mRA;
    volatile ICommLibReader mRw;
    final AtomicBoolean mRx;
    private final AtomicBoolean mRy;
    final ConcurrentLinkedDeque<b<ICommLibReader, x>> mRz;
    
    public c()
    {
      AppMethodBeat.i(50731);
      this.mRx = new AtomicBoolean(false);
      this.mRy = new AtomicBoolean(false);
      this.mRz = new ConcurrentLinkedDeque();
      this.mRA = new ReentrantReadWriteLock();
      AppMethodBeat.o(50731);
    }
    
    private final void bbZ()
    {
      AppMethodBeat.i(50729);
      Log.i("MicroMsg.AppBrandRuntimeLaunchConditionForCommLib", "startTask instance(" + hashCode() + ") callbacks.size=" + this.mRz.size());
      final b localb = (b)new b(this);
      ICommLibReader localICommLibReader = WxaCommLibRuntimeReader.bvV();
      if (localICommLibReader != null)
      {
        Log.i("MicroMsg.AppBrandRuntimeLaunchConditionForCommLib", "task(" + hashCode() + ") getLoadedReader != NULL");
        localb.invoke(localICommLibReader);
        AppMethodBeat.o(50729);
        return;
      }
      com.tencent.mm.ac.d.i((a)new a(this, localb, Util.currentTicks()));
      AppMethodBeat.o(50729);
    }
    
    public final void interrupt()
    {
      AppMethodBeat.i(228616);
      this.mRx.set(true);
      while (!this.mRz.isEmpty())
      {
        Object localObject2 = this.mRz.poll();
        Object localObject1 = localObject2;
        if (!(localObject2 instanceof d.a)) {
          localObject1 = null;
        }
        localObject1 = (d.a)localObject1;
        if (localObject1 != null) {
          ((d.a)localObject1).cn(null);
        }
      }
      AppMethodBeat.o(228616);
    }
    
    public final void w(b<? super ICommLibReader, x> paramb)
    {
      AppMethodBeat.i(50730);
      p.h(paramb, "function");
      if (this.mRx.get())
      {
        if (!(paramb instanceof d.a)) {
          paramb = null;
        }
      }
      else {
        for (;;)
        {
          paramb = (d.a)paramb;
          if (paramb != null)
          {
            paramb.cn(null);
            AppMethodBeat.o(50730);
            return;
          }
          AppMethodBeat.o(50730);
          return;
          if (!this.mRy.getAndSet(true))
          {
            this.mRz.addLast(paramb);
            bbZ();
            AppMethodBeat.o(50730);
            return;
          }
          ReentrantReadWriteLock.ReadLock localReadLock = this.mRA.readLock();
          localReadLock.lock();
          try
          {
            if (this.mRw != null)
            {
              ICommLibReader localICommLibReader = this.mRw;
              if (localICommLibReader == null) {
                p.hyc();
              }
              paramb.invoke(localICommLibReader);
            }
            for (;;)
            {
              paramb = x.SXb;
              return;
              this.mRz.addLast(paramb);
            }
          }
          finally
          {
            localReadLock.unlock();
            AppMethodBeat.o(50730);
          }
        }
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements a<x>
    {
      a(g.c paramc, b paramb, long paramLong)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "reader", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "invoke"})
    static final class b
      extends kotlin.g.b.q
      implements b<ICommLibReader, x>
    {
      b(g.c paramc)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$TaskMapApi24;", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$ITaskMap;", "()V", "map", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$Task;", "get", "key", "putIfAbsent", "", "function", "Lkotlin/Function0;", "remove", "plugin-appbrand-integration_release"})
  static final class d
    implements g.a
  {
    private final ConcurrentHashMap<com.tencent.mm.plugin.appbrand.q, g.c> cCB;
    
    public d()
    {
      AppMethodBeat.i(50736);
      this.cCB = new ConcurrentHashMap();
      AppMethodBeat.o(50736);
    }
    
    public final g.c B(com.tencent.mm.plugin.appbrand.q paramq)
    {
      AppMethodBeat.i(50734);
      p.h(paramq, "key");
      paramq = this.cCB.get(paramq);
      if (paramq == null) {
        p.hyc();
      }
      p.g(paramq, "map[key]!!");
      paramq = (g.c)paramq;
      AppMethodBeat.o(50734);
      return paramq;
    }
    
    public final g.c C(com.tencent.mm.plugin.appbrand.q paramq)
    {
      AppMethodBeat.i(50735);
      p.h(paramq, "key");
      paramq = (g.c)this.cCB.remove(paramq);
      AppMethodBeat.o(50735);
      return paramq;
    }
    
    public final void a(com.tencent.mm.plugin.appbrand.q paramq, a<g.c> parama)
    {
      AppMethodBeat.i(50733);
      p.h(paramq, "key");
      p.h(parama, "function");
      this.cCB.computeIfAbsent(paramq, (Function)new a(parama));
      AppMethodBeat.o(50733);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$Task;", "it", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "apply"})
    static final class a<T, R>
      implements Function<com.tencent.mm.plugin.appbrand.q, g.c>
    {
      a(a parama) {}
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$Task;", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements a<g.c>
  {
    f(com.tencent.mm.plugin.appbrand.q paramq)
    {
      super();
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "invoke", "com/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$obtainTask$1$1$1"})
    static final class a
      extends kotlin.g.b.q
      implements b<ICommLibReader, x>
    {
      a(g.f paramf)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lcom/tencent/luggage/sdk/wxa_ktx/RuntimeLifecycleListenerBuilder;", "invoke", "com/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$obtainTask$1$1$2"})
    static final class b
      extends kotlin.g.b.q
      implements b<com.tencent.luggage.sdk.g.d, x>
    {
      b(g.c paramc, g.f paramf)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.g
 * JD-Core Version:    0.7.0.1
 */