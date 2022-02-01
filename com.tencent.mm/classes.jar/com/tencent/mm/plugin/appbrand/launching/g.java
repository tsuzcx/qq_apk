package com.tencent.mm.plugin.appbrand.launching;

import android.os.Build.VERSION;
import com.tencent.luggage.sdk.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vending.g.d.a;
import d.g.a.a;
import d.g.a.b;
import d.g.b.k;
import d.y;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib;", "", "()V", "TAG", "", "runningTasks", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$ITaskMap;", "obtainTask", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$Task;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "waitFor", "", "function", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "Lcom/tencent/mm/plugin/appbrand/launching/NotifyInvoke;", "ITaskMap", "Task", "TaskMapApi24", "TaskMapApiBase", "plugin-appbrand-integration_release"})
public final class g
{
  private static final a lic;
  public static final g lid;
  
  static
  {
    AppMethodBeat.i(50746);
    lid = new g();
    if (Build.VERSION.SDK_INT >= 24) {}
    for (a locala = (a)new g.c();; locala = (a)new g.d())
    {
      lic = locala;
      AppMethodBeat.o(50746);
      return;
    }
  }
  
  public static final void a(o paramo, b<? super ICommLibReader, y> paramb)
  {
    AppMethodBeat.i(50745);
    k.h(paramo, "runtime");
    k.h(paramb, "function");
    if (paramo.aSt() != null)
    {
      paramo = paramo.aSt();
      k.g(paramo, "runtime.libReader");
      paramb.ay(paramo);
      AppMethodBeat.o(50745);
      return;
    }
    lic.a(paramo, (a)new e(paramo));
    lic.F(paramo).u(paramb);
    AppMethodBeat.o(50745);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$ITaskMap;", "", "get", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$Task;", "key", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "putIfAbsent", "", "function", "Lkotlin/Function0;", "remove", "plugin-appbrand-integration_release"})
  static abstract interface a
  {
    public abstract g.b F(o paramo);
    
    public abstract g.b G(o paramo);
    
    public abstract void a(o paramo, a<g.b> parama);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$Task;", "", "()V", "callbackContendGuard", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "callbacks", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "", "Lcom/tencent/mm/plugin/appbrand/launching/NotifyInvoke;", "interrupted", "Ljava/util/concurrent/atomic/AtomicBoolean;", "loadedLibReader", "taskStarted", "interrupt", "startTask", "waitFor", "function", "plugin-appbrand-integration_release"})
  static final class b
  {
    volatile ICommLibReader lie;
    final AtomicBoolean lif;
    private final AtomicBoolean lig;
    final ConcurrentLinkedDeque<b<ICommLibReader, y>> lih;
    final ReentrantReadWriteLock lii;
    
    public b()
    {
      AppMethodBeat.i(50731);
      this.lif = new AtomicBoolean(false);
      this.lig = new AtomicBoolean(false);
      this.lih = new ConcurrentLinkedDeque();
      this.lii = new ReentrantReadWriteLock();
      AppMethodBeat.o(50731);
    }
    
    private final void aEK()
    {
      AppMethodBeat.i(50729);
      ac.i("MicroMsg.AppBrandRuntimeLaunchConditionForCommLib", "startTask instance(" + hashCode() + ") callbacks.size=" + this.lih.size());
      final b localb = (b)new b(this);
      ICommLibReader localICommLibReader = WxaCommLibRuntimeReader.aWL();
      if (localICommLibReader != null)
      {
        ac.i("MicroMsg.AppBrandRuntimeLaunchConditionForCommLib", "task(" + hashCode() + ") getLoadedReader != NULL");
        localb.ay(localICommLibReader);
        AppMethodBeat.o(50729);
        return;
      }
      c.b(null, (a)new a(this, localb, bs.Gn()));
      AppMethodBeat.o(50729);
    }
    
    public final void u(b<? super ICommLibReader, y> paramb)
    {
      AppMethodBeat.i(50730);
      k.h(paramb, "function");
      if (this.lif.get())
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
            paramb.cc(null);
            AppMethodBeat.o(50730);
            return;
          }
          AppMethodBeat.o(50730);
          return;
          if (!this.lig.getAndSet(true))
          {
            this.lih.addLast(paramb);
            aEK();
            AppMethodBeat.o(50730);
            return;
          }
          ReentrantReadWriteLock.ReadLock localReadLock = this.lii.readLock();
          localReadLock.lock();
          try
          {
            if (this.lie != null)
            {
              ICommLibReader localICommLibReader = this.lie;
              if (localICommLibReader == null) {
                k.fOy();
              }
              paramb.ay(localICommLibReader);
            }
            for (;;)
            {
              paramb = y.KTp;
              return;
              this.lih.addLast(paramb);
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
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements a<y>
    {
      a(g.b paramb, b paramb1, long paramLong)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "reader", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "invoke"})
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
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$Task;", "invoke"})
  static final class e
    extends d.g.b.l
    implements a<g.b>
  {
    e(o paramo)
    {
      super();
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "invoke", "com/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$obtainTask$1$1$1"})
    static final class a
      extends d.g.b.l
      implements b<ICommLibReader, y>
    {
      a(g.e parame)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "Lcom/tencent/luggage/sdk/wxa_ktx/RuntimeLifecycleListenerBuilder;", "invoke", "com/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$obtainTask$1$1$2"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.g
 * JD-Core Version:    0.7.0.1
 */