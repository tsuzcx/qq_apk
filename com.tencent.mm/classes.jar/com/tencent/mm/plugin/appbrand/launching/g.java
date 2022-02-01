package com.tencent.mm.plugin.appbrand.launching;

import android.os.Build.VERSION;
import com.tencent.luggage.sdk.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vending.g.d.a;
import d.g.a.a;
import d.g.a.b;
import d.g.b.p;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib;", "", "()V", "TAG", "", "runningTasks", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$ITaskMap;", "obtainTask", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$Task;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "waitFor", "", "function", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "Lcom/tencent/mm/plugin/appbrand/launching/NotifyInvoke;", "ITaskMap", "Task", "TaskMapApi24", "TaskMapApiBase", "plugin-appbrand-integration_release"})
public final class g
{
  private static final a lFf;
  public static final g lFg;
  
  static
  {
    AppMethodBeat.i(50746);
    lFg = new g();
    if (Build.VERSION.SDK_INT >= 24) {}
    for (a locala = (a)new c();; locala = (a)new d())
    {
      lFf = locala;
      AppMethodBeat.o(50746);
      return;
    }
  }
  
  public static final void a(o paramo, b<? super ICommLibReader, z> paramb)
  {
    AppMethodBeat.i(50745);
    p.h(paramo, "runtime");
    p.h(paramb, "function");
    if (paramo.aVF() != null)
    {
      paramo = paramo.aVF();
      p.g(paramo, "runtime.libReader");
      paramb.invoke(paramo);
      AppMethodBeat.o(50745);
      return;
    }
    lFf.a(paramo, (a)new e(paramo));
    lFf.w(paramo).v(paramb);
    AppMethodBeat.o(50745);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$ITaskMap;", "", "get", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$Task;", "key", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "putIfAbsent", "", "function", "Lkotlin/Function0;", "remove", "plugin-appbrand-integration_release"})
  static abstract interface a
  {
    public abstract void a(o paramo, a<g.b> parama);
    
    public abstract g.b w(o paramo);
    
    public abstract g.b x(o paramo);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$Task;", "", "()V", "callbackContendGuard", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "callbacks", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "", "Lcom/tencent/mm/plugin/appbrand/launching/NotifyInvoke;", "interrupted", "Ljava/util/concurrent/atomic/AtomicBoolean;", "loadedLibReader", "taskStarted", "interrupt", "startTask", "waitFor", "function", "plugin-appbrand-integration_release"})
  static final class b
  {
    volatile ICommLibReader lFh;
    final AtomicBoolean lFi;
    private final AtomicBoolean lFj;
    final ConcurrentLinkedDeque<b<ICommLibReader, z>> lFk;
    final ReentrantReadWriteLock lFl;
    
    public b()
    {
      AppMethodBeat.i(50731);
      this.lFi = new AtomicBoolean(false);
      this.lFj = new AtomicBoolean(false);
      this.lFk = new ConcurrentLinkedDeque();
      this.lFl = new ReentrantReadWriteLock();
      AppMethodBeat.o(50731);
    }
    
    private final void aHP()
    {
      AppMethodBeat.i(50729);
      ad.i("MicroMsg.AppBrandRuntimeLaunchConditionForCommLib", "startTask instance(" + hashCode() + ") callbacks.size=" + this.lFk.size());
      final b localb = (b)new b(this);
      ICommLibReader localICommLibReader = WxaCommLibRuntimeReader.bai();
      if (localICommLibReader != null)
      {
        ad.i("MicroMsg.AppBrandRuntimeLaunchConditionForCommLib", "task(" + hashCode() + ") getLoadedReader != NULL");
        localb.invoke(localICommLibReader);
        AppMethodBeat.o(50729);
        return;
      }
      c.b(null, (a)new a(this, localb, bt.HI()));
      AppMethodBeat.o(50729);
    }
    
    public final void v(b<? super ICommLibReader, z> paramb)
    {
      AppMethodBeat.i(50730);
      p.h(paramb, "function");
      if (this.lFi.get())
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
          if (!this.lFj.getAndSet(true))
          {
            this.lFk.addLast(paramb);
            aHP();
            AppMethodBeat.o(50730);
            return;
          }
          ReentrantReadWriteLock.ReadLock localReadLock = this.lFl.readLock();
          localReadLock.lock();
          try
          {
            if (this.lFh != null)
            {
              ICommLibReader localICommLibReader = this.lFh;
              if (localICommLibReader == null) {
                p.gfZ();
              }
              paramb.invoke(localICommLibReader);
            }
            for (;;)
            {
              paramb = z.MKo;
              return;
              this.lFk.addLast(paramb);
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
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements a<z>
    {
      a(g.b paramb, b paramb1, long paramLong)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "reader", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "invoke"})
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$TaskMapApi24;", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$ITaskMap;", "()V", "map", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$Task;", "get", "key", "putIfAbsent", "", "function", "Lkotlin/Function0;", "remove", "plugin-appbrand-integration_release"})
  static final class c
    implements g.a
  {
    private final ConcurrentHashMap<o, g.b> cpF;
    
    public c()
    {
      AppMethodBeat.i(50736);
      this.cpF = new ConcurrentHashMap();
      AppMethodBeat.o(50736);
    }
    
    public final void a(o paramo, a<g.b> parama)
    {
      AppMethodBeat.i(50733);
      p.h(paramo, "key");
      p.h(parama, "function");
      this.cpF.computeIfAbsent(paramo, (Function)new a(parama));
      AppMethodBeat.o(50733);
    }
    
    public final g.b w(o paramo)
    {
      AppMethodBeat.i(50734);
      p.h(paramo, "key");
      paramo = this.cpF.get(paramo);
      if (paramo == null) {
        p.gfZ();
      }
      p.g(paramo, "map[key]!!");
      paramo = (g.b)paramo;
      AppMethodBeat.o(50734);
      return paramo;
    }
    
    public final g.b x(o paramo)
    {
      AppMethodBeat.i(50735);
      p.h(paramo, "key");
      paramo = (g.b)this.cpF.remove(paramo);
      AppMethodBeat.o(50735);
      return paramo;
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$Task;", "it", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "apply"})
    static final class a<T, R>
      implements Function<o, g.b>
    {
      a(a parama) {}
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$TaskMapApiBase;", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$ITaskMap;", "()V", "map", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$Task;", "Lkotlin/collections/HashMap;", "get", "key", "putIfAbsent", "", "function", "Lkotlin/Function0;", "remove", "plugin-appbrand-integration_release"})
  static final class d
    implements g.a
  {
    private final HashMap<o, g.b> cDF;
    
    public d()
    {
      AppMethodBeat.i(50740);
      this.cDF = new HashMap();
      AppMethodBeat.o(50740);
    }
    
    public final void a(o paramo, a<g.b> parama)
    {
      AppMethodBeat.i(50737);
      p.h(paramo, "key");
      p.h(parama, "function");
      synchronized (this.cDF)
      {
        if ((g.b)this.cDF.get(paramo) == null) {
          ((Map)this.cDF).put(paramo, parama.invoke());
        }
        paramo = z.MKo;
        AppMethodBeat.o(50737);
        return;
      }
    }
    
    public final g.b w(o paramo)
    {
      AppMethodBeat.i(50738);
      p.h(paramo, "key");
      synchronized (this.cDF)
      {
        paramo = this.cDF.get(paramo);
        if (paramo == null) {
          p.gfZ();
        }
        paramo = (g.b)paramo;
        p.g(paramo, "synchronized(map) { map[key]!! }");
        AppMethodBeat.o(50738);
        return paramo;
      }
    }
    
    public final g.b x(o paramo)
    {
      AppMethodBeat.i(50739);
      p.h(paramo, "key");
      synchronized (this.cDF)
      {
        paramo = (g.b)this.cDF.remove(paramo);
        AppMethodBeat.o(50739);
        return paramo;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$Task;", "invoke"})
  static final class e
    extends q
    implements a<g.b>
  {
    e(o paramo)
    {
      super();
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "invoke", "com/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$obtainTask$1$1$1"})
    static final class a
      extends q
      implements b<ICommLibReader, z>
    {
      a(g.e parame)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "Lcom/tencent/luggage/sdk/wxa_ktx/RuntimeLifecycleListenerBuilder;", "invoke", "com/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$obtainTask$1$1$2"})
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