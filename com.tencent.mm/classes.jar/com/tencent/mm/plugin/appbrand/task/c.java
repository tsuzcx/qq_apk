package com.tencent.mm.plugin.appbrand.task;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Debug.MemoryInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.q;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.m.k;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/task/AppBrandMemoryPeriodicProvider;", "", "()V", "PERIOD_MS", "", "TAG", "", "listeners", "", "Lkotlin/Function2;", "", "", "memoryMonitor", "Lcom/tencent/threadpool/runnable/FutureEx;", "pauseTask", "addListener", "listener", "getAllTaskMemUsageAsync", "mb", "getMemUsageMBByPids", "Lkotlin/Pair;", "pids", "", "pause", "removeListener", "resume", "AppForegroundListener", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  private static final List<m<Integer, Integer, ah>> listeners;
  public static final c tVD;
  private static com.tencent.threadpool.i.d<?> tVE;
  private static com.tencent.threadpool.i.d<?> tVF;
  
  static
  {
    AppMethodBeat.i(318650);
    tVD = new c();
    listeners = (List)new ArrayList();
    if ((!MMApplicationContext.isMainProcess()) && (w.qvw))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException(android.util.Log.getStackTraceString(new Throwable()));
      AppMethodBeat.o(318650);
      throw localIllegalArgumentException;
    }
    AppForegroundDelegate.heY.a((q)new a());
    AppMethodBeat.o(318650);
  }
  
  private static final void cJH()
  {
    AppMethodBeat.i(318602);
    m localm = (m)c.tVH;
    com.tencent.threadpool.h.ahAA.bo(new c..ExternalSyntheticLambda1(localm));
    AppMethodBeat.o(318602);
  }
  
  private static final void cJI()
  {
    AppMethodBeat.i(318604);
    com.tencent.threadpool.h.ahAA.bk(c..ExternalSyntheticLambda3.INSTANCE);
    AppMethodBeat.o(318604);
  }
  
  public static void j(m<? super Integer, ? super Integer, ah> paramm)
  {
    AppMethodBeat.i(318596);
    s.u(paramm, "listener");
    com.tencent.threadpool.h.ahAA.bk(new c..ExternalSyntheticLambda0(paramm));
    AppMethodBeat.o(318596);
  }
  
  private static final void k(m paramm)
  {
    AppMethodBeat.i(318614);
    s.u(paramm, "$mb");
    Object localObject = (ActivityManager)MMApplicationContext.getContext().getSystemService("activity");
    if (localObject == null)
    {
      paramm.invoke(Integer.valueOf(0), Integer.valueOf(0));
      AppMethodBeat.o(318614);
      return;
    }
    List localList = ((ActivityManager)localObject).getRunningAppProcesses();
    if (localList == null)
    {
      paramm.invoke(Integer.valueOf(0), Integer.valueOf(0));
      AppMethodBeat.o(318614);
      return;
    }
    localObject = i.tWq;
    localObject = k.d(p.A((Iterable)i.a.cJV().asg()), (b)b.tVG);
    s.u(localObject, "$this$toSet");
    localObject = (Iterable)ar.M((Set)k.a((kotlin.m.h)localObject, (Collection)new LinkedHashSet()));
    Collection localCollection = (Collection)new ArrayList();
    Iterator localIterator1 = ((Iterable)localObject).iterator();
    label260:
    while (localIterator1.hasNext())
    {
      String str = (String)localIterator1.next();
      Iterator localIterator2 = ((Iterable)localList).iterator();
      while (localIterator2.hasNext())
      {
        localObject = localIterator2.next();
        if (s.p(((ActivityManager.RunningAppProcessInfo)localObject).processName, str))
        {
          label220:
          localObject = (ActivityManager.RunningAppProcessInfo)localObject;
          if (localObject != null) {
            break label251;
          }
        }
      }
      label251:
      for (localObject = null;; localObject = Integer.valueOf(((ActivityManager.RunningAppProcessInfo)localObject).pid))
      {
        if (localObject == null) {
          break label260;
        }
        localCollection.add(localObject);
        break;
        localObject = null;
        break label220;
      }
    }
    localObject = y(p.I((Collection)localCollection));
    paramm.invoke(((r)localObject).bsC, ((r)localObject).bsD);
    AppMethodBeat.o(318614);
  }
  
  private static final void l(m paramm)
  {
    AppMethodBeat.i(318622);
    s.u(paramm, "$listener");
    listeners.add(paramm);
    AppMethodBeat.o(318622);
  }
  
  private static r<Integer, Integer> y(int[] paramArrayOfInt)
  {
    int k = 0;
    AppMethodBeat.i(318583);
    if (paramArrayOfInt != null) {
      if (paramArrayOfInt.length != 0) {
        break label47;
      }
    }
    label47:
    for (int i = 1; i != 0; i = 0)
    {
      paramArrayOfInt = new r(Integer.valueOf(0), Integer.valueOf(0));
      AppMethodBeat.o(318583);
      return paramArrayOfInt;
    }
    Object localObject = MMApplicationContext.getContext().getSystemService("activity");
    label84:
    label95:
    label101:
    label125:
    int n;
    if ((localObject instanceof ActivityManager))
    {
      localObject = (ActivityManager)localObject;
      if (localObject != null) {
        break label168;
      }
      paramArrayOfInt = null;
      if (paramArrayOfInt == null) {
        break label268;
      }
      if (paramArrayOfInt.length != 0) {
        break label178;
      }
      i = 1;
      if (i != 0) {
        break label183;
      }
      i = 1;
      if (i == 0) {
        break label268;
      }
      localObject = (Collection)new ArrayList(paramArrayOfInt.length);
      int m = paramArrayOfInt.length;
      i = 0;
      if (i >= m) {
        break label197;
      }
      n = paramArrayOfInt[i];
      if (n != null) {
        break label188;
      }
    }
    label168:
    label178:
    label183:
    label188:
    for (int j = 0;; j = n.getTotalPss())
    {
      ((Collection)localObject).add(Integer.valueOf(j));
      i += 1;
      break label125;
      localObject = null;
      break;
      paramArrayOfInt = ((ActivityManager)localObject).getProcessMemoryInfo(paramArrayOfInt);
      break label84;
      i = 0;
      break label95;
      i = 0;
      break label101;
    }
    label197:
    paramArrayOfInt = (List)localObject;
    j = p.C((Iterable)paramArrayOfInt) / 1024;
    paramArrayOfInt = (Integer)p.x((Iterable)paramArrayOfInt);
    if (paramArrayOfInt == null) {}
    for (i = k;; i = paramArrayOfInt.intValue())
    {
      paramArrayOfInt = new r(Integer.valueOf(j), Integer.valueOf(i / 1024));
      AppMethodBeat.o(318583);
      return paramArrayOfInt;
    }
    label268:
    paramArrayOfInt = new r(Integer.valueOf(0), Integer.valueOf(0));
    AppMethodBeat.o(318583);
    return paramArrayOfInt;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/task/AppBrandMemoryPeriodicProvider$AppForegroundListener;", "Lcom/tencent/mm/app/IAppForegroundListener;", "()V", "mayCancelPauseTask", "", "onAppBackground", "activity", "", "onAppForeground", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
    implements q
  {
    private static final void a(a parama)
    {
      AppMethodBeat.i(318534);
      s.u(parama, "this$0");
      cJN();
      com.tencent.threadpool.h.ahAA.o(c.a..ExternalSyntheticLambda3.INSTANCE, 15000L);
      AppMethodBeat.o(318534);
    }
    
    private static final void b(a parama)
    {
      AppMethodBeat.i(318541);
      s.u(parama, "this$0");
      com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrandMemoryPeriodicProvider", "onAppBackground: ");
      cJN();
      parama = c.tVD;
      c.a(com.tencent.threadpool.h.ahAA.o(c.a..ExternalSyntheticLambda2.INSTANCE, 600000L));
      AppMethodBeat.o(318541);
    }
    
    private static void cJN()
    {
      int k = 0;
      AppMethodBeat.i(318525);
      com.tencent.threadpool.i.d locald = c.cJJ();
      int j = k;
      if (locald != null) {
        if (locald.isDone()) {
          break label70;
        }
      }
      label70:
      for (int i = 1;; i = 0)
      {
        j = k;
        if (i == 1) {
          j = 1;
        }
        if (j != 0)
        {
          locald = c.cJJ();
          s.checkNotNull(locald);
          locald.cancel(true);
          com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrandMemoryPeriodicProvider", "mayCancelPauseTask: pause task canceled");
        }
        AppMethodBeat.o(318525);
        return;
      }
    }
    
    private static final void cJO()
    {
      AppMethodBeat.i(318529);
      c localc = c.tVD;
      c.cJK();
      AppMethodBeat.o(318529);
    }
    
    private static final void cJP()
    {
      AppMethodBeat.i(318538);
      if (!AppForegroundDelegate.heY.eLx)
      {
        c localc = c.tVD;
        c.cJL();
      }
      AppMethodBeat.o(318538);
    }
    
    public final void onAppBackground(String paramString)
    {
      AppMethodBeat.i(318567);
      com.tencent.threadpool.h.ahAA.bk(new c.a..ExternalSyntheticLambda1(this));
      AppMethodBeat.o(318567);
    }
    
    public final void onAppForeground(String paramString)
    {
      AppMethodBeat.i(318564);
      com.tencent.threadpool.h.ahAA.bk(new c.a..ExternalSyntheticLambda0(this));
      AppMethodBeat.o(318564);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "p", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandMiniProgramProcess;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<d, String>
  {
    public static final b tVG;
    
    static
    {
      AppMethodBeat.i(318532);
      tVG = new b();
      AppMethodBeat.o(318532);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "mb", "", "max"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements m<Integer, Integer, ah>
  {
    public static final c tVH;
    
    static
    {
      AppMethodBeat.i(318527);
      tVH = new c();
      AppMethodBeat.o(318527);
    }
    
    c()
    {
      super();
    }
    
    private static final void fN(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(318522);
      Iterator localIterator = ((Iterable)c.cJM()).iterator();
      while (localIterator.hasNext()) {
        ((m)localIterator.next()).invoke(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      }
      AppMethodBeat.o(318522);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.c
 * JD-Core Version:    0.7.0.1
 */