package com.tencent.mm.plugin.appbrand.task;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import com.tencent.f.i.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
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
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/task/AppBrandMemoryPeriodicProvider;", "", "()V", "PERIOD_MS", "", "TAG", "", "listeners", "", "Lkotlin/Function2;", "", "", "memoryMonitor", "Lcom/tencent/threadpool/runnable/FutureEx;", "pauseTask", "addListener", "listener", "getAllTaskMemUsageAsync", "mb", "getMemUsageMBByPids", "Lkotlin/Pair;", "pids", "", "pause", "removeListener", "resume", "AppForegroundListener", "plugin-appbrand-integration_release"})
public final class c
{
  private static final List<kotlin.g.a.m<Integer, Integer, x>> listeners;
  private static d<?> nOp;
  private static d<?> nOq;
  public static final c nOr;
  
  static
  {
    AppMethodBeat.i(229386);
    nOr = new c();
    listeners = (List)new ArrayList();
    if ((!MMApplicationContext.isMainProcess()) && (com.tencent.mm.plugin.appbrand.q.kDg))
    {
      Throwable localThrowable = (Throwable)new IllegalArgumentException(android.util.Log.getStackTraceString(new Throwable()));
      AppMethodBeat.o(229386);
      throw localThrowable;
    }
    AppForegroundDelegate.djR.a((com.tencent.mm.app.o)new a());
    AppMethodBeat.o(229386);
  }
  
  public static void c(kotlin.g.a.m<? super Integer, ? super Integer, x> paramm)
  {
    AppMethodBeat.i(229385);
    kotlin.g.b.p.h(paramm, "listener");
    listeners.add(paramm);
    AppMethodBeat.o(229385);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/task/AppBrandMemoryPeriodicProvider$AppForegroundListener;", "Lcom/tencent/mm/app/IAppForegroundListener;", "()V", "mayCancelPauseTask", "", "onAppBackground", "activity", "", "onAppForeground", "plugin-appbrand-integration_release"})
  static final class a
    implements com.tencent.mm.app.o
  {
    public final void onAppBackground(String paramString)
    {
      AppMethodBeat.i(229373);
      com.tencent.f.h.RTc.aV((Runnable)new a(this));
      AppMethodBeat.o(229373);
    }
    
    public final void onAppForeground(String paramString)
    {
      AppMethodBeat.i(229372);
      com.tencent.f.h.RTc.aV((Runnable)new b(this));
      AppMethodBeat.o(229372);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(c.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(229368);
        com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrandMemoryPeriodicProvider", "onAppBackground: ");
        c.a.bVL();
        c localc = c.nOr;
        c.a(com.tencent.f.h.RTc.n((Runnable)1.nOt, 600000L));
        AppMethodBeat.o(229368);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(c.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(229371);
        c.a.bVL();
        com.tencent.f.h.RTc.n((Runnable)1.nOu, 15000L);
        AppMethodBeat.o(229371);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(kotlin.g.a.m paramm) {}
    
    public final void run()
    {
      AppMethodBeat.i(229377);
      Object localObject1 = (ActivityManager)MMApplicationContext.getContext().getSystemService("activity");
      if (localObject1 == null)
      {
        this.nOv.invoke(Integer.valueOf(0), Integer.valueOf(0));
        AppMethodBeat.o(229377);
        return;
      }
      Object localObject2 = ((ActivityManager)localObject1).getRunningAppProcesses();
      localObject1 = i.nPZ;
      localObject1 = kotlin.m.i.d(j.z((Iterable)i.b.bWj()), (b)a.nOw);
      kotlin.g.b.p.h(localObject1, "$this$toSet");
      localObject1 = (Iterable)ak.C((Set)kotlin.m.i.a((kotlin.m.h)localObject1, (Collection)new LinkedHashSet()));
      Collection localCollection = (Collection)new ArrayList();
      Iterator localIterator1 = ((Iterable)localObject1).iterator();
      label194:
      label231:
      label234:
      while (localIterator1.hasNext())
      {
        String str = (String)localIterator1.next();
        kotlin.g.b.p.g(localObject2, "runningProcesses");
        Iterator localIterator2 = ((Iterable)localObject2).iterator();
        while (localIterator2.hasNext())
        {
          localObject1 = localIterator2.next();
          if (kotlin.g.b.p.j(((ActivityManager.RunningAppProcessInfo)localObject1).processName, str))
          {
            localObject1 = (ActivityManager.RunningAppProcessInfo)localObject1;
            if (localObject1 == null) {
              break label231;
            }
          }
        }
        for (localObject1 = Integer.valueOf(((ActivityManager.RunningAppProcessInfo)localObject1).pid);; localObject1 = null)
        {
          if (localObject1 == null) {
            break label234;
          }
          localCollection.add(localObject1);
          break;
          localObject1 = null;
          break label194;
        }
      }
      localObject1 = (List)localCollection;
      localObject2 = c.nOr;
      localObject1 = c.w(j.u((Collection)localObject1));
      this.nOv.invoke(((kotlin.o)localObject1).first, ((kotlin.o)localObject1).second);
      AppMethodBeat.o(229377);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "kotlin.jvm.PlatformType", "task", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandUIProcess;", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements b<m, String>
    {
      public static final a nOw;
      
      static
      {
        AppMethodBeat.i(229376);
        nOw = new a();
        AppMethodBeat.o(229376);
      }
      
      a()
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    public static final c nOx;
    
    static
    {
      AppMethodBeat.i(229384);
      nOx = new c();
      AppMethodBeat.o(229384);
    }
    
    public final void run()
    {
      AppMethodBeat.i(229383);
      com.tencent.f.h.RTc.aV((Runnable)1.nOy);
      AppMethodBeat.o(229383);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.c
 * JD-Core Version:    0.7.0.1
 */