package com.tencent.mm.plugin.appbrand.task;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.a.ak;
import kotlin.a.j;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/task/AppBrandMemoryPeriodicProvider;", "", "()V", "PERIOD_MS", "", "TAG", "", "listeners", "", "Lkotlin/Function2;", "", "", "memoryMonitor", "Lcom/tencent/threadpool/runnable/FutureEx;", "pauseTask", "addListener", "listener", "getAllTaskMemUsageAsync", "mb", "getMemUsageMBByPids", "Lkotlin/Pair;", "pids", "", "pause", "removeListener", "resume", "AppForegroundListener", "plugin-appbrand-integration_release"})
public final class c
{
  private static final List<m<Integer, Integer, x>> listeners;
  private static com.tencent.e.i.d<?> qQN;
  private static com.tencent.e.i.d<?> qQO;
  public static final c qQP;
  
  static
  {
    AppMethodBeat.i(275986);
    qQP = new c();
    listeners = (List)new ArrayList();
    if ((!MMApplicationContext.isMainProcess()) && (t.nwr))
    {
      Throwable localThrowable = (Throwable)new IllegalArgumentException(android.util.Log.getStackTraceString(new Throwable()));
      AppMethodBeat.o(275986);
      throw localThrowable;
    }
    AppForegroundDelegate.fby.a((com.tencent.mm.app.o)new a());
    AppMethodBeat.o(275986);
  }
  
  public static void c(m<? super Integer, ? super Integer, x> paramm)
  {
    AppMethodBeat.i(275985);
    p.k(paramm, "listener");
    listeners.add(paramm);
    AppMethodBeat.o(275985);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/task/AppBrandMemoryPeriodicProvider$AppForegroundListener;", "Lcom/tencent/mm/app/IAppForegroundListener;", "()V", "mayCancelPauseTask", "", "onAppBackground", "activity", "", "onAppForeground", "plugin-appbrand-integration_release"})
  static final class a
    implements com.tencent.mm.app.o
  {
    public final void onAppBackground(String paramString)
    {
      AppMethodBeat.i(265485);
      com.tencent.e.h.ZvG.bc((Runnable)new a(this));
      AppMethodBeat.o(265485);
    }
    
    public final void onAppForeground(String paramString)
    {
      AppMethodBeat.i(265484);
      com.tencent.e.h.ZvG.bc((Runnable)new b(this));
      AppMethodBeat.o(265484);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(c.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(279964);
        com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrandMemoryPeriodicProvider", "onAppBackground: ");
        c.a.ciS();
        c localc = c.qQP;
        c.a(com.tencent.e.h.ZvG.n((Runnable)1.qQR, 600000L));
        AppMethodBeat.o(279964);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(c.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(276027);
        c.a.ciS();
        com.tencent.e.h.ZvG.n((Runnable)1.qQS, 15000L);
        AppMethodBeat.o(276027);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(m paramm) {}
    
    public final void run()
    {
      AppMethodBeat.i(272973);
      Object localObject1 = (ActivityManager)MMApplicationContext.getContext().getSystemService("activity");
      if (localObject1 == null)
      {
        this.qQT.invoke(Integer.valueOf(0), Integer.valueOf(0));
        AppMethodBeat.o(272973);
        return;
      }
      Object localObject2 = ((ActivityManager)localObject1).getRunningAppProcesses();
      localObject1 = i.qRL;
      localObject1 = kotlin.m.i.d(j.z((Iterable)i.a.cjb().RS()), (b)a.qQU);
      p.k(localObject1, "$this$toSet");
      localObject1 = (Iterable)ak.B((Set)kotlin.m.i.a((kotlin.m.h)localObject1, (Collection)new LinkedHashSet()));
      Collection localCollection = (Collection)new ArrayList();
      Iterator localIterator1 = ((Iterable)localObject1).iterator();
      label197:
      label234:
      label237:
      while (localIterator1.hasNext())
      {
        String str = (String)localIterator1.next();
        p.j(localObject2, "runningProcesses");
        Iterator localIterator2 = ((Iterable)localObject2).iterator();
        while (localIterator2.hasNext())
        {
          localObject1 = localIterator2.next();
          if (p.h(((ActivityManager.RunningAppProcessInfo)localObject1).processName, str))
          {
            localObject1 = (ActivityManager.RunningAppProcessInfo)localObject1;
            if (localObject1 == null) {
              break label234;
            }
          }
        }
        for (localObject1 = Integer.valueOf(((ActivityManager.RunningAppProcessInfo)localObject1).pid);; localObject1 = null)
        {
          if (localObject1 == null) {
            break label237;
          }
          localCollection.add(localObject1);
          break;
          localObject1 = null;
          break label197;
        }
      }
      localObject1 = (List)localCollection;
      localObject2 = c.qQP;
      localObject1 = c.w(j.s((Collection)localObject1));
      this.qQT.invoke(((kotlin.o)localObject1).Mx, ((kotlin.o)localObject1).My);
      AppMethodBeat.o(272973);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "p", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandMiniProgramProcess;", "invoke"})
    static final class a
      extends q
      implements b<d, String>
    {
      public static final a qQU;
      
      static
      {
        AppMethodBeat.i(252084);
        qQU = new a();
        AppMethodBeat.o(252084);
      }
      
      a()
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    public static final c qQV;
    
    static
    {
      AppMethodBeat.i(270627);
      qQV = new c();
      AppMethodBeat.o(270627);
    }
    
    public final void run()
    {
      AppMethodBeat.i(270626);
      com.tencent.e.h.ZvG.bc((Runnable)1.qQW);
      AppMethodBeat.o(270626);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.c
 * JD-Core Version:    0.7.0.1
 */