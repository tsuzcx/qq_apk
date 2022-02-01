package com.tencent.mm.plugin.appbrand.launching;

import android.os.Build.VERSION;
import com.tencent.luggage.sdk.h.e;
import com.tencent.luggage.sdk.h.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.g.d.a;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib;", "", "()V", "TAG", "", "runningTasks", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$ITaskMap;", "obtainTask", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$Task;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "waitFor", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$IWaitForCommLibTask;", "function", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "", "Lcom/tencent/mm/plugin/appbrand/launching/NotifyInvoke;", "ITaskMap", "IWaitForCommLibTask", "Task", "TaskMapApi24", "TaskMapApiBase", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  public static final h sXs;
  private static final a sXt;
  
  static
  {
    AppMethodBeat.i(50746);
    sXs = new h();
    if (Build.VERSION.SDK_INT >= 24) {}
    for (a locala = (a)new d();; locala = (a)new h.e())
    {
      sXt = locala;
      AppMethodBeat.o(50746);
      return;
    }
  }
  
  public static final b a(w paramw, b<? super ICommLibReader, ah> paramb)
  {
    AppMethodBeat.i(320809);
    s.u(paramw, "runtime");
    s.u(paramb, "function");
    if (paramw.cbl() != null)
    {
      paramw = paramw.cbl();
      s.s(paramw, "runtime.libReader");
      paramb.invoke(paramw);
      AppMethodBeat.o(320809);
      return null;
    }
    sXt.a(paramw, (a)new f(paramw));
    paramw = sXt.M(paramw);
    paramw.X(paramb);
    paramw = (b)paramw;
    AppMethodBeat.o(320809);
    return paramw;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$ITaskMap;", "", "get", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$Task;", "key", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "putIfAbsent", "", "function", "Lkotlin/Function0;", "remove", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  static abstract interface a
  {
    public abstract h.c M(w paramw);
    
    public abstract h.c N(w paramw);
    
    public abstract void a(w paramw, a<h.c> parama);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$IWaitForCommLibTask;", "", "interrupt", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void interrupt();
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$Task;", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$IWaitForCommLibTask;", "()V", "callbackContendGuard", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "callbacks", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "", "Lcom/tencent/mm/plugin/appbrand/launching/NotifyInvoke;", "interrupted", "Ljava/util/concurrent/atomic/AtomicBoolean;", "loadedLibReader", "taskStarted", "interrupt", "startTask", "waitFor", "function", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class c
    implements h.b
  {
    volatile ICommLibReader sXu;
    final AtomicBoolean sXv;
    private final AtomicBoolean sXw;
    final ConcurrentLinkedDeque<b<ICommLibReader, ah>> sXx;
    final ReentrantReadWriteLock sXy;
    
    public c()
    {
      AppMethodBeat.i(50731);
      this.sXv = new AtomicBoolean(false);
      this.sXw = new AtomicBoolean(false);
      this.sXx = new ConcurrentLinkedDeque();
      this.sXy = new ReentrantReadWriteLock();
      AppMethodBeat.o(50731);
    }
    
    private final void bJj()
    {
      AppMethodBeat.i(50729);
      Log.i("MicroMsg.AppBrandRuntimeLaunchConditionForCommLib", "startTask instance(" + hashCode() + ") callbacks.size=" + this.sXx.size());
      b localb = (b)new b(this);
      ICommLibReader localICommLibReader = WxaCommLibRuntimeReader.cgz();
      if (localICommLibReader != null)
      {
        Log.i("MicroMsg.AppBrandRuntimeLaunchConditionForCommLib", "task(" + hashCode() + ") getLoadedReader != NULL");
        localb.invoke(localICommLibReader);
        AppMethodBeat.o(50729);
        return;
      }
      d.B((a)new h.c.a(localb, this, Util.currentTicks()));
      AppMethodBeat.o(50729);
    }
    
    /* Error */
    public final void X(b<? super ICommLibReader, ah> paramb)
    {
      // Byte code:
      //   0: ldc 157
      //   2: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_1
      //   6: ldc 158
      //   8: invokestatic 164	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
      //   11: aload_0
      //   12: getfield 64	com/tencent/mm/plugin/appbrand/launching/h$c:sXv	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   15: invokevirtual 168	java/util/concurrent/atomic/AtomicBoolean:get	()Z
      //   18: ifeq +37 -> 55
      //   21: aload_1
      //   22: instanceof 170
      //   25: ifeq +25 -> 50
      //   28: aload_1
      //   29: checkcast 170	com/tencent/mm/vending/g/d$a
      //   32: astore_1
      //   33: aload_1
      //   34: ifnull +10 -> 44
      //   37: aload_1
      //   38: aconst_null
      //   39: invokeinterface 174 2 0
      //   44: ldc 157
      //   46: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   49: return
      //   50: aconst_null
      //   51: astore_1
      //   52: goto -19 -> 33
      //   55: aload_0
      //   56: getfield 66	com/tencent/mm/plugin/appbrand/launching/h$c:sXw	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   59: iconst_1
      //   60: invokevirtual 178	java/util/concurrent/atomic/AtomicBoolean:getAndSet	(Z)Z
      //   63: ifne +21 -> 84
      //   66: aload_0
      //   67: getfield 71	com/tencent/mm/plugin/appbrand/launching/h$c:sXx	Ljava/util/concurrent/ConcurrentLinkedDeque;
      //   70: aload_1
      //   71: invokevirtual 181	java/util/concurrent/ConcurrentLinkedDeque:addLast	(Ljava/lang/Object;)V
      //   74: aload_0
      //   75: invokespecial 183	com/tencent/mm/plugin/appbrand/launching/h$c:bJj	()V
      //   78: ldc 157
      //   80: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   83: return
      //   84: aload_0
      //   85: getfield 76	com/tencent/mm/plugin/appbrand/launching/h$c:sXy	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
      //   88: invokevirtual 187	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
      //   91: astore_2
      //   92: aload_2
      //   93: invokevirtual 192	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
      //   96: aload_0
      //   97: getfield 194	com/tencent/mm/plugin/appbrand/launching/h$c:sXu	Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;
      //   100: ifnull +34 -> 134
      //   103: aload_0
      //   104: getfield 194	com/tencent/mm/plugin/appbrand/launching/h$c:sXu	Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;
      //   107: astore_3
      //   108: aload_3
      //   109: invokestatic 197	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
      //   112: aload_1
      //   113: aload_3
      //   114: invokeinterface 135 2 0
      //   119: pop
      //   120: getstatic 203	kotlin/ah:aiuX	Lkotlin/ah;
      //   123: astore_1
      //   124: aload_2
      //   125: invokevirtual 206	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
      //   128: ldc 157
      //   130: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   133: return
      //   134: aload_0
      //   135: getfield 71	com/tencent/mm/plugin/appbrand/launching/h$c:sXx	Ljava/util/concurrent/ConcurrentLinkedDeque;
      //   138: aload_1
      //   139: invokevirtual 181	java/util/concurrent/ConcurrentLinkedDeque:addLast	(Ljava/lang/Object;)V
      //   142: goto -22 -> 120
      //   145: astore_1
      //   146: aload_2
      //   147: invokevirtual 206	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
      //   150: ldc 157
      //   152: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   155: aload_1
      //   156: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	157	0	this	c
      //   0	157	1	paramb	b<? super ICommLibReader, ah>
      //   91	56	2	localReadLock	java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock
      //   107	7	3	localICommLibReader	ICommLibReader
      // Exception table:
      //   from	to	target	type
      //   96	120	145	finally
      //   120	124	145	finally
      //   134	142	145	finally
    }
    
    public final void interrupt()
    {
      AppMethodBeat.i(321016);
      this.sXv.set(true);
      label60:
      while (!this.sXx.isEmpty())
      {
        Object localObject = this.sXx.poll();
        if ((localObject instanceof d.a)) {}
        for (localObject = (d.a)localObject;; localObject = null)
        {
          if (localObject == null) {
            break label60;
          }
          ((d.a)localObject).onInterrupt(null);
          break;
        }
      }
      AppMethodBeat.o(321016);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "reader", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements b<ICommLibReader, ah>
    {
      b(h.c paramc)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$TaskMapApi24;", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$ITaskMap;", "()V", "map", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$Task;", "get", "key", "putIfAbsent", "", "function", "Lkotlin/Function0;", "remove", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class d
    implements h.a
  {
    private final ConcurrentHashMap<w, h.c> evG;
    
    public d()
    {
      AppMethodBeat.i(50736);
      this.evG = new ConcurrentHashMap();
      AppMethodBeat.o(50736);
    }
    
    private static final h.c a(a parama, w paramw)
    {
      AppMethodBeat.i(320987);
      s.u(parama, "$function");
      s.u(paramw, "it");
      parama = (h.c)parama.invoke();
      AppMethodBeat.o(320987);
      return parama;
    }
    
    public final h.c M(w paramw)
    {
      AppMethodBeat.i(50734);
      s.u(paramw, "key");
      paramw = this.evG.get(paramw);
      s.checkNotNull(paramw);
      s.s(paramw, "map[key]!!");
      paramw = (h.c)paramw;
      AppMethodBeat.o(50734);
      return paramw;
    }
    
    public final h.c N(w paramw)
    {
      AppMethodBeat.i(50735);
      s.u(paramw, "key");
      paramw = (h.c)this.evG.remove(paramw);
      AppMethodBeat.o(50735);
      return paramw;
    }
    
    public final void a(w paramw, a<h.c> parama)
    {
      AppMethodBeat.i(50733);
      s.u(paramw, "key");
      s.u(parama, "function");
      this.evG.computeIfAbsent(paramw, new h.d..ExternalSyntheticLambda0(parama));
      AppMethodBeat.o(50733);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$Task;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements a<h.c>
  {
    f(w paramw)
    {
      super();
    }
    
    private h.c czN()
    {
      AppMethodBeat.i(320977);
      h.c localc = new h.c();
      final w localw = this.rhf;
      Log.i("MicroMsg.AppBrandRuntimeLaunchConditionForCommLib", "obtainTask create new instance(" + localc.hashCode() + ") with appId(" + localw.mAppId + ')');
      localc.X((b)new a(localw));
      g localg = g.evQ;
      g.a((AppBrandRuntime)localw, (b)new b(localc, localw));
      AppMethodBeat.o(320977);
      return localc;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements b<ICommLibReader, ah>
    {
      a(w paramw)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lcom/tencent/luggage/sdk/wxa_ktx/RuntimeLifecycleListenerBuilder;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements b<e, ah>
    {
      b(h.c paramc, w paramw)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.h
 * JD-Core Version:    0.7.0.1
 */