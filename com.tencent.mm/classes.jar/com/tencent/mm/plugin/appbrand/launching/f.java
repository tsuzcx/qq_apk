package com.tencent.mm.plugin.appbrand.launching;

import android.os.Build.VERSION;
import com.tencent.luggage.sdk.h.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.g.d.a;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.function.Function;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib;", "", "()V", "TAG", "", "runningTasks", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$ITaskMap;", "obtainTask", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$Task;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "waitFor", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$IWaitForCommLibTask;", "function", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "", "Lcom/tencent/mm/plugin/appbrand/launching/NotifyInvoke;", "ITaskMap", "IWaitForCommLibTask", "Task", "TaskMapApi24", "TaskMapApiBase", "plugin-appbrand-integration_release"})
public final class f
{
  private static final a pSq;
  public static final f pSr;
  
  static
  {
    AppMethodBeat.i(50746);
    pSr = new f();
    if (Build.VERSION.SDK_INT >= 24) {}
    for (a locala = (a)new d();; locala = (a)new e())
    {
      pSq = locala;
      AppMethodBeat.o(50746);
      return;
    }
  }
  
  public static final f.b a(t paramt, b<? super ICommLibReader, x> paramb)
  {
    AppMethodBeat.i(283725);
    p.k(paramt, "runtime");
    p.k(paramb, "function");
    if (paramt.bBP() != null)
    {
      paramt = paramt.bBP();
      p.j(paramt, "runtime.libReader");
      paramb.invoke(paramt);
      AppMethodBeat.o(283725);
      return null;
    }
    pSq.a(paramt, (a)new f(paramt));
    paramt = pSq.C(paramt);
    paramt.w(paramb);
    paramt = (f.b)paramt;
    AppMethodBeat.o(283725);
    return paramt;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$ITaskMap;", "", "get", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$Task;", "key", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "putIfAbsent", "", "function", "Lkotlin/Function0;", "remove", "plugin-appbrand-integration_release"})
  static abstract interface a
  {
    public abstract f.c C(t paramt);
    
    public abstract f.c D(t paramt);
    
    public abstract void a(t paramt, a<f.c> parama);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$Task;", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$IWaitForCommLibTask;", "()V", "callbackContendGuard", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "callbacks", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "", "Lcom/tencent/mm/plugin/appbrand/launching/NotifyInvoke;", "interrupted", "Ljava/util/concurrent/atomic/AtomicBoolean;", "loadedLibReader", "taskStarted", "interrupt", "startTask", "waitFor", "function", "plugin-appbrand-integration_release"})
  static final class c
    implements f.b
  {
    volatile ICommLibReader pSs;
    final AtomicBoolean pSt;
    private final AtomicBoolean pSu;
    final ConcurrentLinkedDeque<b<ICommLibReader, x>> pSv;
    final ReentrantReadWriteLock pSw;
    
    public c()
    {
      AppMethodBeat.i(50731);
      this.pSt = new AtomicBoolean(false);
      this.pSu = new AtomicBoolean(false);
      this.pSv = new ConcurrentLinkedDeque();
      this.pSw = new ReentrantReadWriteLock();
      AppMethodBeat.o(50731);
    }
    
    private final void blp()
    {
      AppMethodBeat.i(50729);
      Log.i("MicroMsg.AppBrandRuntimeLaunchConditionForCommLib", "startTask instance(" + hashCode() + ") callbacks.size=" + this.pSv.size());
      final b localb = (b)new b(this);
      ICommLibReader localICommLibReader = WxaCommLibRuntimeReader.bHd();
      if (localICommLibReader != null)
      {
        Log.i("MicroMsg.AppBrandRuntimeLaunchConditionForCommLib", "task(" + hashCode() + ") getLoadedReader != NULL");
        localb.invoke(localICommLibReader);
        AppMethodBeat.o(50729);
        return;
      }
      d.h((a)new a(this, localb, Util.currentTicks()));
      AppMethodBeat.o(50729);
    }
    
    public final void interrupt()
    {
      AppMethodBeat.i(279291);
      this.pSt.set(true);
      while (!this.pSv.isEmpty())
      {
        Object localObject2 = this.pSv.poll();
        Object localObject1 = localObject2;
        if (!(localObject2 instanceof d.a)) {
          localObject1 = null;
        }
        localObject1 = (d.a)localObject1;
        if (localObject1 != null) {
          ((d.a)localObject1).cm(null);
        }
      }
      AppMethodBeat.o(279291);
    }
    
    public final void w(b<? super ICommLibReader, x> paramb)
    {
      AppMethodBeat.i(50730);
      p.k(paramb, "function");
      if (this.pSt.get())
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
            paramb.cm(null);
            AppMethodBeat.o(50730);
            return;
          }
          AppMethodBeat.o(50730);
          return;
          if (!this.pSu.getAndSet(true))
          {
            this.pSv.addLast(paramb);
            blp();
            AppMethodBeat.o(50730);
            return;
          }
          ReentrantReadWriteLock.ReadLock localReadLock = this.pSw.readLock();
          localReadLock.lock();
          try
          {
            if (this.pSs != null)
            {
              ICommLibReader localICommLibReader = this.pSs;
              if (localICommLibReader == null) {
                p.iCn();
              }
              paramb.invoke(localICommLibReader);
            }
            for (;;)
            {
              paramb = x.aazN;
              return;
              this.pSv.addLast(paramb);
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
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements a<x>
    {
      a(f.c paramc, b paramb, long paramLong)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "reader", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "invoke"})
    static final class b
      extends q
      implements b<ICommLibReader, x>
    {
      b(f.c paramc)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$TaskMapApi24;", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$ITaskMap;", "()V", "map", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$Task;", "get", "key", "putIfAbsent", "", "function", "Lkotlin/Function0;", "remove", "plugin-appbrand-integration_release"})
  static final class d
    implements f.a
  {
    private final ConcurrentHashMap<t, f.c> cDe;
    
    public d()
    {
      AppMethodBeat.i(50736);
      this.cDe = new ConcurrentHashMap();
      AppMethodBeat.o(50736);
    }
    
    public final f.c C(t paramt)
    {
      AppMethodBeat.i(50734);
      p.k(paramt, "key");
      paramt = this.cDe.get(paramt);
      if (paramt == null) {
        p.iCn();
      }
      p.j(paramt, "map[key]!!");
      paramt = (f.c)paramt;
      AppMethodBeat.o(50734);
      return paramt;
    }
    
    public final f.c D(t paramt)
    {
      AppMethodBeat.i(50735);
      p.k(paramt, "key");
      paramt = (f.c)this.cDe.remove(paramt);
      AppMethodBeat.o(50735);
      return paramt;
    }
    
    public final void a(t paramt, a<f.c> parama)
    {
      AppMethodBeat.i(50733);
      p.k(paramt, "key");
      p.k(parama, "function");
      this.cDe.computeIfAbsent(paramt, (Function)new a(parama));
      AppMethodBeat.o(50733);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$Task;", "it", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "apply"})
    static final class a<T, R>
      implements Function<t, f.c>
    {
      a(a parama) {}
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$TaskMapApiBase;", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$ITaskMap;", "()V", "map", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$Task;", "Lkotlin/collections/HashMap;", "get", "key", "putIfAbsent", "", "function", "Lkotlin/Function0;", "remove", "plugin-appbrand-integration_release"})
  static final class e
    implements f.a
  {
    private final HashMap<t, f.c> map;
    
    public e()
    {
      AppMethodBeat.i(50740);
      this.map = new HashMap();
      AppMethodBeat.o(50740);
    }
    
    public final f.c C(t paramt)
    {
      AppMethodBeat.i(50738);
      p.k(paramt, "key");
      synchronized (this.map)
      {
        paramt = this.map.get(paramt);
        if (paramt == null) {
          p.iCn();
        }
        paramt = (f.c)paramt;
        p.j(paramt, "synchronized(map) { map[key]!! }");
        AppMethodBeat.o(50738);
        return paramt;
      }
    }
    
    public final f.c D(t paramt)
    {
      AppMethodBeat.i(50739);
      p.k(paramt, "key");
      synchronized (this.map)
      {
        paramt = (f.c)this.map.remove(paramt);
        AppMethodBeat.o(50739);
        return paramt;
      }
    }
    
    public final void a(t paramt, a<f.c> parama)
    {
      AppMethodBeat.i(50737);
      p.k(paramt, "key");
      p.k(parama, "function");
      synchronized (this.map)
      {
        if ((f.c)this.map.get(paramt) == null) {
          ((Map)this.map).put(paramt, parama.invoke());
        }
        paramt = x.aazN;
        AppMethodBeat.o(50737);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$Task;", "invoke"})
  static final class f
    extends q
    implements a<f.c>
  {
    f(t paramt)
    {
      super();
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "invoke", "com/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$obtainTask$1$1$1"})
    static final class a
      extends q
      implements b<ICommLibReader, x>
    {
      a(f.f paramf)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lcom/tencent/luggage/sdk/wxa_ktx/RuntimeLifecycleListenerBuilder;", "invoke", "com/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$obtainTask$1$1$2"})
    static final class b
      extends q
      implements b<e, x>
    {
      b(f.c paramc, f.f paramf)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.f
 * JD-Core Version:    0.7.0.1
 */