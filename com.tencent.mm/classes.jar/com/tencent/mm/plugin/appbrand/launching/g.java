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
import d.g.b.k;
import d.y;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.function.Function;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib;", "", "()V", "TAG", "", "runningTasks", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$ITaskMap;", "obtainTask", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$Task;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "waitFor", "", "function", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "Lcom/tencent/mm/plugin/appbrand/launching/NotifyInvoke;", "ITaskMap", "Task", "TaskMapApi24", "TaskMapApiBase", "plugin-appbrand-integration_release"})
public final class g
{
  private static final a kGI;
  public static final g kGJ;
  
  static
  {
    AppMethodBeat.i(50746);
    kGJ = new g();
    if (Build.VERSION.SDK_INT >= 24) {}
    for (a locala = (a)new c();; locala = (a)new d())
    {
      kGI = locala;
      AppMethodBeat.o(50746);
      return;
    }
  }
  
  public static final void a(o paramo, b<? super ICommLibReader, y> paramb)
  {
    AppMethodBeat.i(50745);
    k.h(paramo, "runtime");
    k.h(paramb, "function");
    if (paramo.aLC() != null)
    {
      paramo = paramo.aLC();
      k.g(paramo, "runtime.libReader");
      paramb.aA(paramo);
      AppMethodBeat.o(50745);
      return;
    }
    kGI.a(paramo, (a)new e(paramo));
    kGI.F(paramo).q(paramb);
    AppMethodBeat.o(50745);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$ITaskMap;", "", "get", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$Task;", "key", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "putIfAbsent", "", "function", "Lkotlin/Function0;", "remove", "plugin-appbrand-integration_release"})
  static abstract interface a
  {
    public abstract g.b F(o paramo);
    
    public abstract g.b G(o paramo);
    
    public abstract void a(o paramo, a<g.b> parama);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$Task;", "", "()V", "callbackContendGuard", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "callbacks", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "", "Lcom/tencent/mm/plugin/appbrand/launching/NotifyInvoke;", "interrupted", "Ljava/util/concurrent/atomic/AtomicBoolean;", "loadedLibReader", "taskStarted", "interrupt", "startTask", "waitFor", "function", "plugin-appbrand-integration_release"})
  static final class b
  {
    volatile ICommLibReader kGK;
    final AtomicBoolean kGL;
    private final AtomicBoolean kGM;
    final ConcurrentLinkedDeque<b<ICommLibReader, y>> kGN;
    final ReentrantReadWriteLock kGO;
    
    public b()
    {
      AppMethodBeat.i(50731);
      this.kGL = new AtomicBoolean(false);
      this.kGM = new AtomicBoolean(false);
      this.kGN = new ConcurrentLinkedDeque();
      this.kGO = new ReentrantReadWriteLock();
      AppMethodBeat.o(50731);
    }
    
    private final void axS()
    {
      AppMethodBeat.i(50729);
      ad.i("MicroMsg.AppBrandRuntimeLaunchConditionForCommLib", "startTask instance(" + hashCode() + ") callbacks.size=" + this.kGN.size());
      final b localb = (b)new b(this);
      ICommLibReader localICommLibReader = WxaCommLibRuntimeReader.aPT();
      if (localICommLibReader != null)
      {
        ad.i("MicroMsg.AppBrandRuntimeLaunchConditionForCommLib", "task(" + hashCode() + ") getLoadedReader != NULL");
        localb.aA(localICommLibReader);
        AppMethodBeat.o(50729);
        return;
      }
      c.b(null, (a)new a(this, localb, bt.GC()));
      AppMethodBeat.o(50729);
    }
    
    public final void q(b<? super ICommLibReader, y> paramb)
    {
      AppMethodBeat.i(50730);
      k.h(paramb, "function");
      if (this.kGL.get())
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
          if (!this.kGM.getAndSet(true))
          {
            this.kGN.addLast(paramb);
            axS();
            AppMethodBeat.o(50730);
            return;
          }
          ReentrantReadWriteLock.ReadLock localReadLock = this.kGO.readLock();
          localReadLock.lock();
          try
          {
            if (this.kGK != null)
            {
              ICommLibReader localICommLibReader = this.kGK;
              if (localICommLibReader == null) {
                k.fvU();
              }
              paramb.aA(localICommLibReader);
            }
            for (;;)
            {
              paramb = y.JfV;
              return;
              this.kGN.addLast(paramb);
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
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements a<y>
    {
      a(g.b paramb, b paramb1, long paramLong)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "reader", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "invoke"})
    static final class b
      extends d.g.b.l
      implements b<ICommLibReader, y>
    {
      b(g.b paramb)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$TaskMapApi24;", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$ITaskMap;", "()V", "map", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$Task;", "get", "key", "putIfAbsent", "", "function", "Lkotlin/Function0;", "remove", "plugin-appbrand-integration_release"})
  static final class c
    implements g.a
  {
    private final ConcurrentHashMap<o, g.b> cit;
    
    public c()
    {
      AppMethodBeat.i(50736);
      this.cit = new ConcurrentHashMap();
      AppMethodBeat.o(50736);
    }
    
    public final g.b F(o paramo)
    {
      AppMethodBeat.i(50734);
      k.h(paramo, "key");
      paramo = this.cit.get(paramo);
      if (paramo == null) {
        k.fvU();
      }
      k.g(paramo, "map[key]!!");
      paramo = (g.b)paramo;
      AppMethodBeat.o(50734);
      return paramo;
    }
    
    public final g.b G(o paramo)
    {
      AppMethodBeat.i(50735);
      k.h(paramo, "key");
      paramo = (g.b)this.cit.remove(paramo);
      AppMethodBeat.o(50735);
      return paramo;
    }
    
    public final void a(o paramo, a<g.b> parama)
    {
      AppMethodBeat.i(50733);
      k.h(paramo, "key");
      k.h(parama, "function");
      this.cit.computeIfAbsent(paramo, (Function)new a(parama));
      AppMethodBeat.o(50733);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$Task;", "it", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "apply"})
    static final class a<T, R>
      implements Function<o, g.b>
    {
      a(a parama) {}
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$TaskMapApiBase;", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$ITaskMap;", "()V", "map", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$Task;", "Lkotlin/collections/HashMap;", "get", "key", "putIfAbsent", "", "function", "Lkotlin/Function0;", "remove", "plugin-appbrand-integration_release"})
  static final class d
    implements g.a
  {
    private final HashMap<o, g.b> cvB;
    
    public d()
    {
      AppMethodBeat.i(50740);
      this.cvB = new HashMap();
      AppMethodBeat.o(50740);
    }
    
    public final g.b F(o paramo)
    {
      AppMethodBeat.i(50738);
      k.h(paramo, "key");
      synchronized (this.cvB)
      {
        paramo = this.cvB.get(paramo);
        if (paramo == null) {
          k.fvU();
        }
        paramo = (g.b)paramo;
        k.g(paramo, "synchronized(map) { map[key]!! }");
        AppMethodBeat.o(50738);
        return paramo;
      }
    }
    
    public final g.b G(o paramo)
    {
      AppMethodBeat.i(50739);
      k.h(paramo, "key");
      synchronized (this.cvB)
      {
        paramo = (g.b)this.cvB.remove(paramo);
        AppMethodBeat.o(50739);
        return paramo;
      }
    }
    
    public final void a(o paramo, a<g.b> parama)
    {
      AppMethodBeat.i(50737);
      k.h(paramo, "key");
      k.h(parama, "function");
      synchronized (this.cvB)
      {
        if ((g.b)this.cvB.get(paramo) == null) {
          ((Map)this.cvB).put(paramo, parama.invoke());
        }
        paramo = y.JfV;
        AppMethodBeat.o(50737);
        return;
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$Task;", "invoke"})
  static final class e
    extends d.g.b.l
    implements a<g.b>
  {
    e(o paramo)
    {
      super();
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "invoke", "com/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$obtainTask$1$1$1"})
    static final class a
      extends d.g.b.l
      implements b<ICommLibReader, y>
    {
      a(g.e parame)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "Lcom/tencent/luggage/sdk/wxa_ktx/RuntimeLifecycleListenerBuilder;", "invoke", "com/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$obtainTask$1$1$2"})
    static final class b
      extends d.g.b.l
      implements b<d, y>
    {
      b(g.b paramb, g.e parame)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.g
 * JD-Core Version:    0.7.0.1
 */