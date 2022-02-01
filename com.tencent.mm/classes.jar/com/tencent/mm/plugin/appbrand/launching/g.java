package com.tencent.mm.plugin.appbrand.launching;

import android.os.Build.VERSION;
import com.tencent.luggage.sdk.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vending.g.d.a;
import d.g.a.a;
import d.g.a.b;
import d.g.b.q;
import d.l;
import d.z;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.function.Function;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib;", "", "()V", "TAG", "", "runningTasks", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$ITaskMap;", "obtainTask", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$Task;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "waitFor", "", "function", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "Lcom/tencent/mm/plugin/appbrand/launching/NotifyInvoke;", "ITaskMap", "Task", "TaskMapApi24", "TaskMapApiBase", "plugin-appbrand-integration_release"})
public final class g
{
  private static final a lJE;
  public static final g lJF;
  
  static
  {
    AppMethodBeat.i(50746);
    lJF = new g();
    if (Build.VERSION.SDK_INT >= 24) {}
    for (a locala = (a)new c();; locala = (a)new d())
    {
      lJE = locala;
      AppMethodBeat.o(50746);
      return;
    }
  }
  
  public static final void a(com.tencent.mm.plugin.appbrand.p paramp, b<? super ICommLibReader, z> paramb)
  {
    AppMethodBeat.i(50745);
    d.g.b.p.h(paramp, "runtime");
    d.g.b.p.h(paramb, "function");
    if (paramp.aWe() != null)
    {
      paramp = paramp.aWe();
      d.g.b.p.g(paramp, "runtime.libReader");
      paramb.invoke(paramp);
      AppMethodBeat.o(50745);
      return;
    }
    lJE.a(paramp, (a)new e(paramp));
    lJE.x(paramp).v(paramb);
    AppMethodBeat.o(50745);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$ITaskMap;", "", "get", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$Task;", "key", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "putIfAbsent", "", "function", "Lkotlin/Function0;", "remove", "plugin-appbrand-integration_release"})
  static abstract interface a
  {
    public abstract void a(com.tencent.mm.plugin.appbrand.p paramp, a<g.b> parama);
    
    public abstract g.b x(com.tencent.mm.plugin.appbrand.p paramp);
    
    public abstract g.b y(com.tencent.mm.plugin.appbrand.p paramp);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$Task;", "", "()V", "callbackContendGuard", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "callbacks", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "", "Lcom/tencent/mm/plugin/appbrand/launching/NotifyInvoke;", "interrupted", "Ljava/util/concurrent/atomic/AtomicBoolean;", "loadedLibReader", "taskStarted", "interrupt", "startTask", "waitFor", "function", "plugin-appbrand-integration_release"})
  static final class b
  {
    volatile ICommLibReader lJG;
    final AtomicBoolean lJH;
    private final AtomicBoolean lJI;
    final ConcurrentLinkedDeque<b<ICommLibReader, z>> lJJ;
    final ReentrantReadWriteLock lJK;
    
    public b()
    {
      AppMethodBeat.i(50731);
      this.lJH = new AtomicBoolean(false);
      this.lJI = new AtomicBoolean(false);
      this.lJJ = new ConcurrentLinkedDeque();
      this.lJK = new ReentrantReadWriteLock();
      AppMethodBeat.o(50731);
    }
    
    private final void aIg()
    {
      AppMethodBeat.i(50729);
      ae.i("MicroMsg.AppBrandRuntimeLaunchConditionForCommLib", "startTask instance(" + hashCode() + ") callbacks.size=" + this.lJJ.size());
      final b localb = (b)new b(this);
      ICommLibReader localICommLibReader = WxaCommLibRuntimeReader.baH();
      if (localICommLibReader != null)
      {
        ae.i("MicroMsg.AppBrandRuntimeLaunchConditionForCommLib", "task(" + hashCode() + ") getLoadedReader != NULL");
        localb.invoke(localICommLibReader);
        AppMethodBeat.o(50729);
        return;
      }
      c.b(null, (a)new a(this, localb, bu.HQ()));
      AppMethodBeat.o(50729);
    }
    
    public final void v(b<? super ICommLibReader, z> paramb)
    {
      AppMethodBeat.i(50730);
      d.g.b.p.h(paramb, "function");
      if (this.lJH.get())
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
            paramb.ce(null);
            AppMethodBeat.o(50730);
            return;
          }
          AppMethodBeat.o(50730);
          return;
          if (!this.lJI.getAndSet(true))
          {
            this.lJJ.addLast(paramb);
            aIg();
            AppMethodBeat.o(50730);
            return;
          }
          ReentrantReadWriteLock.ReadLock localReadLock = this.lJK.readLock();
          localReadLock.lock();
          try
          {
            if (this.lJG != null)
            {
              ICommLibReader localICommLibReader = this.lJG;
              if (localICommLibReader == null) {
                d.g.b.p.gkB();
              }
              paramb.invoke(localICommLibReader);
            }
            for (;;)
            {
              paramb = z.Nhr;
              return;
              this.lJJ.addLast(paramb);
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
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements a<z>
    {
      a(g.b paramb, b paramb1, long paramLong)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "reader", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "invoke"})
    static final class b
      extends q
      implements b<ICommLibReader, z>
    {
      b(g.b paramb)
      {
        super();
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$TaskMapApi24;", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$ITaskMap;", "()V", "map", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$Task;", "get", "key", "putIfAbsent", "", "function", "Lkotlin/Function0;", "remove", "plugin-appbrand-integration_release"})
  static final class c
    implements g.a
  {
    private final ConcurrentHashMap<com.tencent.mm.plugin.appbrand.p, g.b> cqi;
    
    public c()
    {
      AppMethodBeat.i(50736);
      this.cqi = new ConcurrentHashMap();
      AppMethodBeat.o(50736);
    }
    
    public final void a(com.tencent.mm.plugin.appbrand.p paramp, a<g.b> parama)
    {
      AppMethodBeat.i(50733);
      d.g.b.p.h(paramp, "key");
      d.g.b.p.h(parama, "function");
      this.cqi.computeIfAbsent(paramp, (Function)new a(parama));
      AppMethodBeat.o(50733);
    }
    
    public final g.b x(com.tencent.mm.plugin.appbrand.p paramp)
    {
      AppMethodBeat.i(50734);
      d.g.b.p.h(paramp, "key");
      paramp = this.cqi.get(paramp);
      if (paramp == null) {
        d.g.b.p.gkB();
      }
      d.g.b.p.g(paramp, "map[key]!!");
      paramp = (g.b)paramp;
      AppMethodBeat.o(50734);
      return paramp;
    }
    
    public final g.b y(com.tencent.mm.plugin.appbrand.p paramp)
    {
      AppMethodBeat.i(50735);
      d.g.b.p.h(paramp, "key");
      paramp = (g.b)this.cqi.remove(paramp);
      AppMethodBeat.o(50735);
      return paramp;
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$Task;", "it", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "apply"})
    static final class a<T, R>
      implements Function<com.tencent.mm.plugin.appbrand.p, g.b>
    {
      a(a parama) {}
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$TaskMapApiBase;", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$ITaskMap;", "()V", "map", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$Task;", "Lkotlin/collections/HashMap;", "get", "key", "putIfAbsent", "", "function", "Lkotlin/Function0;", "remove", "plugin-appbrand-integration_release"})
  static final class d
    implements g.a
  {
    private final HashMap<com.tencent.mm.plugin.appbrand.p, g.b> cEm;
    
    public d()
    {
      AppMethodBeat.i(50740);
      this.cEm = new HashMap();
      AppMethodBeat.o(50740);
    }
    
    public final void a(com.tencent.mm.plugin.appbrand.p paramp, a<g.b> parama)
    {
      AppMethodBeat.i(50737);
      d.g.b.p.h(paramp, "key");
      d.g.b.p.h(parama, "function");
      synchronized (this.cEm)
      {
        if ((g.b)this.cEm.get(paramp) == null) {
          ((Map)this.cEm).put(paramp, parama.invoke());
        }
        paramp = z.Nhr;
        AppMethodBeat.o(50737);
        return;
      }
    }
    
    public final g.b x(com.tencent.mm.plugin.appbrand.p paramp)
    {
      AppMethodBeat.i(50738);
      d.g.b.p.h(paramp, "key");
      synchronized (this.cEm)
      {
        paramp = this.cEm.get(paramp);
        if (paramp == null) {
          d.g.b.p.gkB();
        }
        paramp = (g.b)paramp;
        d.g.b.p.g(paramp, "synchronized(map) { map[key]!! }");
        AppMethodBeat.o(50738);
        return paramp;
      }
    }
    
    public final g.b y(com.tencent.mm.plugin.appbrand.p paramp)
    {
      AppMethodBeat.i(50739);
      d.g.b.p.h(paramp, "key");
      synchronized (this.cEm)
      {
        paramp = (g.b)this.cEm.remove(paramp);
        AppMethodBeat.o(50739);
        return paramp;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$Task;", "invoke"})
  static final class e
    extends q
    implements a<g.b>
  {
    e(com.tencent.mm.plugin.appbrand.p paramp)
    {
      super();
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "invoke", "com/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$obtainTask$1$1$1"})
    static final class a
      extends q
      implements b<ICommLibReader, z>
    {
      a(g.e parame)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "Lcom/tencent/luggage/sdk/wxa_ktx/RuntimeLifecycleListenerBuilder;", "invoke", "com/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$obtainTask$1$1$2"})
    static final class b
      extends q
      implements b<d, z>
    {
      b(g.b paramb, g.e parame)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.g
 * JD-Core Version:    0.7.0.1
 */