package androidx.compose.runtime;

import androidx.compose.runtime.b.a.a.a.a.c.b.a;
import androidx.compose.runtime.b.a.a.a.j;
import androidx.compose.runtime.f.h.a;
import androidx.compose.runtime.f.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.d.f.c;
import kotlin.g.a.m;
import kotlin.g.b.u;
import kotlinx.coroutines.ac;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.b.x;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.cg;
import kotlinx.coroutines.p;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/Recomposer;", "Landroidx/compose/runtime/CompositionContext;", "effectCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/compose/runtime/Recomposer$State;", "broadcastFrameClock", "Landroidx/compose/runtime/BroadcastFrameClock;", "<set-?>", "", "changeCount", "getChangeCount", "()J", "closeCause", "", "collectingParameterInformation", "", "getCollectingParameterInformation$runtime_release", "()Z", "compositionInvalidations", "", "Landroidx/compose/runtime/ControlledComposition;", "compositionsAwaitingApply", "compoundHashKey", "", "getCompoundHashKey$runtime_release", "()I", "concurrentCompositionsOutstanding", "getEffectCoroutineContext$runtime_release", "()Lkotlin/coroutines/CoroutineContext;", "effectJob", "Lkotlinx/coroutines/CompletableJob;", "hasConcurrentFrameWorkLocked", "getHasConcurrentFrameWorkLocked", "hasFrameWorkLocked", "getHasFrameWorkLocked", "hasPendingWork", "getHasPendingWork", "hasSchedulingWork", "getHasSchedulingWork", "isClosed", "knownCompositions", "recomposeCoroutineContext", "getRecomposeCoroutineContext$runtime_release", "recomposerInfo", "Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "runnerJob", "Lkotlinx/coroutines/Job;", "shouldKeepRecomposing", "getShouldKeepRecomposing", "snapshotInvalidations", "", "", "state", "Lkotlinx/coroutines/flow/Flow;", "getState", "()Lkotlinx/coroutines/flow/Flow;", "stateLock", "workContinuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "applyAndCheck", "snapshot", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "asRecomposerInfo", "Landroidx/compose/runtime/RecomposerInfo;", "awaitIdle", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitWorkAvailable", "cancel", "close", "composeInitial", "composition", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "composeInitial$runtime_release", "(Landroidx/compose/runtime/ControlledComposition;Lkotlin/jvm/functions/Function2;)V", "composing", "T", "modifiedValues", "Landroidx/compose/runtime/collection/IdentityArraySet;", "block", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/compose/runtime/collection/IdentityArraySet;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "deriveStateLocked", "invalidate", "invalidate$runtime_release", "invalidateScope", "scope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "invalidateScope$runtime_release", "join", "performRecompose", "readObserverOf", "Lkotlin/Function1;", "recompositionRunner", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/runtime/MonotonicFrameClock;", "Lkotlin/ParameterName;", "name", "parentFrameClock", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recordComposerModificationsLocked", "onEachInvalidComposition", "recordInspectionTable", "table", "", "Landroidx/compose/runtime/tooling/CompositionData;", "recordInspectionTable$runtime_release", "registerComposition", "registerComposition$runtime_release", "registerRunnerJob", "callingJob", "runFrameLoop", "frameSignal", "Landroidx/compose/runtime/ProduceFrameSignal;", "(Landroidx/compose/runtime/MonotonicFrameClock;Landroidx/compose/runtime/ProduceFrameSignal;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runRecomposeAndApplyChanges", "runRecomposeConcurrentlyAndApplyChanges", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unregisterComposition", "unregisterComposition$runtime_release", "writeObserverOf", "Companion", "HotReloadable", "RecomposerInfoImpl", "State", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aw
  extends l
{
  public static final int Ue;
  public static final a aoR;
  private static final x<j<b>> aph;
  long aoS;
  public final e aoT;
  private final ac aoU;
  private final f aoV;
  private final Object aoW;
  private cb aoX;
  private Throwable aoY;
  private final List<s> aoZ;
  private final List<Set<Object>> apa;
  private final List<s> apb;
  private final List<s> apc;
  private p<? super kotlin.ah> apd;
  private int ape;
  public final x<c> apf;
  private final b apg;
  private boolean isClosed;
  
  static
  {
    AppMethodBeat.i(202318);
    aoR = new a((byte)0);
    Ue = 8;
    b.a locala = androidx.compose.runtime.b.a.a.a.a.c.b.ari;
    aph = kotlinx.coroutines.b.ah.ji((j)androidx.compose.runtime.b.a.a.a.a.c.b.ra());
    AppMethodBeat.o(202318);
  }
  
  public aw(f paramf)
  {
    AppMethodBeat.i(202017);
    this.aoT = new e((kotlin.g.a.a)new d(this));
    ac localac = cg.e((cb)paramf.get((f.c)cb.ajws));
    localac.bh((kotlin.g.a.b)new e(this));
    kotlin.ah localah = kotlin.ah.aiuX;
    this.aoU = localac;
    this.aoV = paramf.plus((f)this.aoT).plus((f)this.aoU);
    this.aoW = new Object();
    this.aoZ = ((List)new ArrayList());
    this.apa = ((List)new ArrayList());
    this.apb = ((List)new ArrayList());
    this.apc = ((List)new ArrayList());
    this.apf = kotlinx.coroutines.b.ah.ji(c.apl);
    this.apg = new b();
    AppMethodBeat.o(202017);
  }
  
  private static s a(final s params, androidx.compose.runtime.a.c<Object> paramc)
  {
    AppMethodBeat.i(202070);
    if ((params.pd()) || (params.pb()))
    {
      AppMethodBeat.o(202070);
      return null;
    }
    Object localObject = androidx.compose.runtime.f.h.asx;
    localObject = h.a.d(c(params), b(params, paramc));
    try
    {
      androidx.compose.runtime.f.h localh = ((androidx.compose.runtime.f.h)localObject).rr();
      if (paramc != null) {}
      try
      {
        if (paramc.qn() == true) {}
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            params.c((kotlin.g.a.a)new g(paramc, params));
          }
          boolean bool = params.pg();
          androidx.compose.runtime.f.h.c(localh);
          a((androidx.compose.runtime.f.c)localObject);
          if (!bool) {
            break;
          }
          AppMethodBeat.o(202070);
          return params;
        }
        params = finally;
      }
      finally
      {
        androidx.compose.runtime.f.h.c(localh);
        AppMethodBeat.o(202070);
      }
      AppMethodBeat.o(202070);
    }
    finally
    {
      a((androidx.compose.runtime.f.c)localObject);
      AppMethodBeat.o(202070);
    }
    return null;
  }
  
  private static void a(androidx.compose.runtime.f.c paramc)
  {
    AppMethodBeat.i(202112);
    if ((paramc.rg() instanceof i.a))
    {
      paramc = (Throwable)new IllegalStateException("Unsupported concurrent change during composition. A state object was modified by composition as well as being modified outside composition.".toString());
      AppMethodBeat.o(202112);
      throw paramc;
    }
    AppMethodBeat.o(202112);
  }
  
  private static kotlin.g.a.b<Object, kotlin.ah> b(s params, final androidx.compose.runtime.a.c<Object> paramc)
  {
    AppMethodBeat.i(202097);
    params = (kotlin.g.a.b)new k(params, paramc);
    AppMethodBeat.o(202097);
    return params;
  }
  
  private static kotlin.g.a.b<Object, kotlin.ah> c(s params)
  {
    AppMethodBeat.i(202082);
    params = (kotlin.g.a.b)new h(params);
    AppMethodBeat.o(202082);
    return params;
  }
  
  private final Object f(d<? super kotlin.ah> paramd)
  {
    AppMethodBeat.i(202055);
    if (!pG())
    {
      kotlinx.coroutines.q localq = new kotlinx.coroutines.q(kotlin.d.a.b.au(paramd), 1);
      localq.kBA();
      Object localObject2 = (p)localq;
      synchronized (this.aoW)
      {
        if (pG())
        {
          localObject2 = (d)localObject2;
          kotlin.ah localah = kotlin.ah.aiuX;
          Result.Companion localCompanion = Result.Companion;
          ((d)localObject2).resumeWith(Result.constructor-impl(localah));
          localObject2 = kotlin.ah.aiuX;
          ??? = localq.getResult();
          if (??? == kotlin.d.a.a.aiwj) {
            kotlin.g.b.s.u(paramd, "frame");
          }
          if (??? == kotlin.d.a.a.aiwj)
          {
            AppMethodBeat.o(202055);
            return ???;
          }
        }
        else
        {
          this.apd = ((p)localObject2);
        }
      }
      paramd = kotlin.ah.aiuX;
      AppMethodBeat.o(202055);
      return paramd;
    }
    paramd = kotlin.ah.aiuX;
    AppMethodBeat.o(202055);
    return paramd;
  }
  
  private final p<kotlin.ah> pE()
  {
    AppMethodBeat.i(202026);
    Object localObject;
    if (((c)this.apf.getValue()).compareTo((Enum)c.apk) <= 0)
    {
      this.aoZ.clear();
      this.apa.clear();
      this.apb.clear();
      this.apc.clear();
      localObject = this.apd;
      if (localObject != null) {
        ((p)localObject).P(null);
      }
      this.apd = null;
      AppMethodBeat.o(202026);
      return null;
    }
    if (this.aoX == null)
    {
      this.apa.clear();
      this.apb.clear();
      if (this.aoT.nT()) {
        localObject = c.apm;
      }
    }
    for (;;)
    {
      this.apf.setValue(localObject);
      if (localObject != c.apo) {
        break;
      }
      localObject = this.apd;
      this.apd = null;
      AppMethodBeat.o(202026);
      return localObject;
      localObject = c.apl;
      continue;
      if (!((Collection)this.apb).isEmpty())
      {
        i = 1;
        label194:
        if (i == 0)
        {
          if (((Collection)this.apa).isEmpty()) {
            break label269;
          }
          i = 1;
          label215:
          if (i == 0) {
            if (((Collection)this.apc).isEmpty()) {
              break label274;
            }
          }
        }
      }
      label269:
      label274:
      for (int i = 1;; i = 0)
      {
        if ((i == 0) && (this.ape <= 0) && (!this.aoT.nT())) {
          break label279;
        }
        localObject = c.apo;
        break;
        i = 0;
        break label194;
        i = 0;
        break label215;
      }
      label279:
      localObject = c.apn;
    }
    AppMethodBeat.o(202026);
    return null;
  }
  
  private final boolean pF()
  {
    AppMethodBeat.i(202035);
    int i;
    synchronized (this.aoW)
    {
      boolean bool = this.isClosed;
      if (!bool)
      {
        i = 1;
        if (i == 0)
        {
          ??? = this.aoU.kCv().iterator();
          do
          {
            if (!((Iterator)???).hasNext()) {
              break;
            }
          } while (!((cb)((Iterator)???).next()).isActive());
          i = 1;
          if (i == 0) {}
        }
        else
        {
          AppMethodBeat.o(202035);
          return true;
        }
      }
      else
      {
        i = 0;
      }
    }
    AppMethodBeat.o(202035);
    return false;
  }
  
  private final boolean pG()
  {
    AppMethodBeat.i(202043);
    synchronized (this.aoW)
    {
      if (!((Collection)this.apa).isEmpty())
      {
        i = 1;
        if (i == 0) {
          if (((Collection)this.apb).isEmpty()) {
            break label84;
          }
        }
      }
      label84:
      for (int i = 1;; i = 0)
      {
        if (i == 0)
        {
          bool = this.aoT.nT();
          if (!bool) {
            break label89;
          }
        }
        bool = true;
        AppMethodBeat.o(202043);
        return bool;
        i = 0;
        break;
      }
      label89:
      boolean bool = false;
    }
  }
  
  public final void a(s params)
  {
    AppMethodBeat.i(202382);
    kotlin.g.b.s.u(params, "composition");
    synchronized (this.aoW)
    {
      ((Collection)this.aoZ).remove(params);
      params = kotlin.ah.aiuX;
      AppMethodBeat.o(202382);
      return;
    }
  }
  
  /* Error */
  public final void a(s params, m<? super h, ? super java.lang.Integer, kotlin.ah> arg2)
  {
    // Byte code:
    //   0: ldc_w 623
    //   3: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ldc_w 617
    //   10: invokestatic 258	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: aload_2
    //   14: ldc_w 624
    //   17: invokestatic 258	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   20: aload_1
    //   21: invokeinterface 354 1 0
    //   26: istore_3
    //   27: getstatic 363	androidx/compose/runtime/f/h:asx	Landroidx/compose/runtime/f/h$a;
    //   30: astore 4
    //   32: aload_1
    //   33: invokestatic 366	androidx/compose/runtime/aw:c	(Landroidx/compose/runtime/s;)Lkotlin/g/a/b;
    //   36: aload_1
    //   37: aconst_null
    //   38: invokestatic 369	androidx/compose/runtime/aw:b	(Landroidx/compose/runtime/s;Landroidx/compose/runtime/a/c;)Lkotlin/g/a/b;
    //   41: invokestatic 375	androidx/compose/runtime/f/h$a:d	(Lkotlin/g/a/b;Lkotlin/g/a/b;)Landroidx/compose/runtime/f/c;
    //   44: astore 4
    //   46: aload 4
    //   48: checkcast 359	androidx/compose/runtime/f/h
    //   51: invokevirtual 379	androidx/compose/runtime/f/h:rr	()Landroidx/compose/runtime/f/h;
    //   54: astore 5
    //   56: aload_1
    //   57: aload_2
    //   58: invokeinterface 627 2 0
    //   63: getstatic 308	kotlin/ah:aiuX	Lkotlin/ah;
    //   66: astore_2
    //   67: aload 5
    //   69: invokestatic 395	androidx/compose/runtime/f/h:c	(Landroidx/compose/runtime/f/h;)V
    //   72: aload 4
    //   74: invokestatic 398	androidx/compose/runtime/aw:a	(Landroidx/compose/runtime/f/c;)V
    //   77: iload_3
    //   78: ifne +13 -> 91
    //   81: getstatic 363	androidx/compose/runtime/f/h:asx	Landroidx/compose/runtime/f/h$a;
    //   84: astore_2
    //   85: invokestatic 632	androidx/compose/runtime/f/l:rx	()Landroidx/compose/runtime/f/h;
    //   88: invokevirtual 635	androidx/compose/runtime/f/h:rf	()V
    //   91: aload_1
    //   92: invokeinterface 638 1 0
    //   97: aload_0
    //   98: getfield 321	androidx/compose/runtime/aw:aoW	Ljava/lang/Object;
    //   101: astore_2
    //   102: aload_2
    //   103: monitorenter
    //   104: aload_0
    //   105: getfield 340	androidx/compose/runtime/aw:apf	Lkotlinx/coroutines/b/x;
    //   108: invokeinterface 421 1 0
    //   113: checkcast 12	androidx/compose/runtime/aw$c
    //   116: getstatic 424	androidx/compose/runtime/aw$c:apk	Landroidx/compose/runtime/aw$c;
    //   119: checkcast 426	java/lang/Enum
    //   122: invokevirtual 430	androidx/compose/runtime/aw$c:compareTo	(Ljava/lang/Enum;)I
    //   125: ifle +30 -> 155
    //   128: aload_0
    //   129: getfield 328	androidx/compose/runtime/aw:aoZ	Ljava/util/List;
    //   132: aload_1
    //   133: invokeinterface 641 2 0
    //   138: ifne +17 -> 155
    //   141: aload_0
    //   142: getfield 328	androidx/compose/runtime/aw:aoZ	Ljava/util/List;
    //   145: checkcast 535	java/util/Collection
    //   148: aload_1
    //   149: invokeinterface 644 2 0
    //   154: pop
    //   155: getstatic 308	kotlin/ah:aiuX	Lkotlin/ah;
    //   158: astore_1
    //   159: aload_2
    //   160: monitorexit
    //   161: iload_3
    //   162: ifne +13 -> 175
    //   165: getstatic 363	androidx/compose/runtime/f/h:asx	Landroidx/compose/runtime/f/h$a;
    //   168: astore_1
    //   169: invokestatic 632	androidx/compose/runtime/f/l:rx	()Landroidx/compose/runtime/f/h;
    //   172: invokevirtual 635	androidx/compose/runtime/f/h:rf	()V
    //   175: ldc_w 623
    //   178: invokestatic 249	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   181: return
    //   182: astore_1
    //   183: aload 5
    //   185: invokestatic 395	androidx/compose/runtime/f/h:c	(Landroidx/compose/runtime/f/h;)V
    //   188: ldc_w 623
    //   191: invokestatic 249	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   194: aload_1
    //   195: athrow
    //   196: astore_1
    //   197: aload 4
    //   199: invokestatic 398	androidx/compose/runtime/aw:a	(Landroidx/compose/runtime/f/c;)V
    //   202: ldc_w 623
    //   205: invokestatic 249	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   208: aload_1
    //   209: athrow
    //   210: astore_1
    //   211: aload_2
    //   212: monitorexit
    //   213: ldc_w 623
    //   216: invokestatic 249	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   219: aload_1
    //   220: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	221	0	this	aw
    //   0	221	1	params	s
    //   26	136	3	bool	boolean
    //   30	168	4	localObject	Object
    //   54	130	5	localh	androidx.compose.runtime.f.h
    // Exception table:
    //   from	to	target	type
    //   56	67	182	finally
    //   46	56	196	finally
    //   67	72	196	finally
    //   183	196	196	finally
    //   104	155	210	finally
    //   155	159	210	finally
  }
  
  public final void b(s params)
  {
    AppMethodBeat.i(202395);
    kotlin.g.b.s.u(params, "composition");
    synchronized (this.aoW)
    {
      if (!this.apb.contains(params))
      {
        ((Collection)this.apb).add(params);
        params = pE();
        if (params != null)
        {
          params = (d)params;
          ??? = kotlin.ah.aiuX;
          Result.Companion localCompanion = Result.Companion;
          params.resumeWith(Result.constructor-impl(???));
        }
        AppMethodBeat.o(202395);
        return;
      }
      params = null;
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(202340);
    ((cb)this.aoU).a(null);
    AppMethodBeat.o(202340);
  }
  
  public final void d(Set<androidx.compose.runtime.g.a> paramSet)
  {
    AppMethodBeat.i(202374);
    kotlin.g.b.s.u(paramSet, "table");
    AppMethodBeat.o(202374);
  }
  
  public final int oU()
  {
    return 1000;
  }
  
  public final boolean oV()
  {
    return false;
  }
  
  public final f oW()
  {
    return this.aoV;
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/runtime/Recomposer$Companion;", "", "()V", "_runningRecomposers", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "Landroidx/compose/runtime/Recomposer;", "runningRecomposers", "Lkotlinx/coroutines/flow/StateFlow;", "", "Landroidx/compose/runtime/RecomposerInfo;", "getRunningRecomposers", "()Lkotlinx/coroutines/flow/StateFlow;", "addRunning", "", "info", "loadStateAndComposeForHotReload", "token", "loadStateAndComposeForHotReload$runtime_release", "removeRunning", "saveStateAndDisposeForHotReload", "saveStateAndDisposeForHotReload$runtime_release", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "Landroidx/compose/runtime/RecomposerInfo;", "(Landroidx/compose/runtime/Recomposer;)V", "changeCount", "", "getChangeCount", "()J", "hasPendingWork", "", "getHasPendingWork", "()Z", "state", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/compose/runtime/Recomposer$State;", "getState", "()Lkotlinx/coroutines/flow/Flow;", "saveStateAndDisposeForHotReload", "", "Landroidx/compose/runtime/Recomposer$HotReloadable;", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
  final class b
  {
    public b()
    {
      AppMethodBeat.i(202405);
      AppMethodBeat.o(202405);
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/runtime/Recomposer$State;", "", "(Ljava/lang/String;I)V", "ShutDown", "ShuttingDown", "Inactive", "InactivePendingWork", "Idle", "PendingWork", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum c
  {
    static
    {
      AppMethodBeat.i(202430);
      apj = new c("ShutDown", 0);
      apk = new c("ShuttingDown", 1);
      apl = new c("Inactive", 2);
      apm = new c("InactivePendingWork", 3);
      apn = new c("Idle", 4);
      apo = new c("PendingWork", 5);
      apq = new c[] { apj, apk, apl, apm, apn, apo };
      AppMethodBeat.o(202430);
    }
    
    private c() {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    d(aw paramaw)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "throwable", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.b<Throwable, kotlin.ah>
  {
    e(aw paramaw)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "runnerJobCause", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.b<Throwable, kotlin.ah>
    {
      a(aw paramaw, Throwable paramThrowable)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroidx/compose/runtime/Recomposer$State;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class f
    extends k
    implements m<aw.c, d<? super Boolean>, Object>
  {
    int label;
    
    public f(d<? super f> paramd)
    {
      super(paramd);
    }
    
    public final d<kotlin.ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(202427);
      paramd = new f(paramd);
      paramd.L$0 = paramObject;
      paramObject = (d)paramd;
      AppMethodBeat.o(202427);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(202420);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(202420);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      if ((aw.c)this.L$0 == aw.c.apj) {}
      for (boolean bool = true;; bool = false)
      {
        AppMethodBeat.o(202420);
        return Boolean.valueOf(bool);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    g(androidx.compose.runtime.a.c<Object> paramc, s params)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "value", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.b<Object, kotlin.ah>
  {
    h(s params)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class i
    extends k
    implements m<aq, d<? super kotlin.ah>, Object>
  {
    Object Uf;
    int label;
    
    public i(aw paramaw, kotlin.g.a.q<? super aq, ? super al, ? super d<? super kotlin.ah>, ? extends Object> paramq, al paramal, d<? super i> paramd)
    {
      super(paramd);
    }
    
    public final d<kotlin.ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(202424);
      paramd = new i(this.api, this.apu, this.apv, paramd);
      paramd.L$0 = paramObject;
      paramObject = (d)paramd;
      AppMethodBeat.o(202424);
      return paramObject;
    }
    
    /* Error */
    public final Object invokeSuspend(Object paramObject)
    {
      // Byte code:
      //   0: ldc 90
      //   2: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: getstatic 96	kotlin/d/a/a:aiwj	Lkotlin/d/a/a;
      //   8: astore 6
      //   10: aload_0
      //   11: getfield 98	androidx/compose/runtime/aw$i:label	I
      //   14: tableswitch	default:+22 -> 36, 0:+39->53, 1:+389->403
      //   37: nop
      //   38: isub
      //   39: dup
      //   40: ldc 102
      //   42: invokespecial 105	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
      //   45: astore_1
      //   46: ldc 90
      //   48: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   51: aload_1
      //   52: athrow
      //   53: aload_1
      //   54: invokestatic 111	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
      //   57: aload_0
      //   58: getfield 66	androidx/compose/runtime/aw$i:L$0	Ljava/lang/Object;
      //   61: checkcast 77	kotlinx/coroutines/aq
      //   64: invokeinterface 115 1 0
      //   69: astore 5
      //   71: aload 5
      //   73: getstatic 121	kotlinx/coroutines/cb:ajws	Lkotlinx/coroutines/cb$b;
      //   76: checkcast 123	kotlin/d/f$c
      //   79: invokeinterface 129 2 0
      //   84: checkcast 117	kotlinx/coroutines/cb
      //   87: astore_1
      //   88: aload_1
      //   89: ifnonnull +31 -> 120
      //   92: new 100	java/lang/IllegalStateException
      //   95: dup
      //   96: ldc 131
      //   98: aload 5
      //   100: invokestatic 137	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
      //   103: invokevirtual 143	java/lang/Object:toString	()Ljava/lang/String;
      //   106: invokespecial 105	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
      //   109: checkcast 145	java/lang/Throwable
      //   112: astore_1
      //   113: ldc 90
      //   115: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   118: aload_1
      //   119: athrow
      //   120: aload_0
      //   121: getfield 43	androidx/compose/runtime/aw$i:api	Landroidx/compose/runtime/aw;
      //   124: aload_1
      //   125: invokestatic 149	androidx/compose/runtime/aw:a	(Landroidx/compose/runtime/aw;Lkotlinx/coroutines/cb;)V
      //   128: getstatic 155	androidx/compose/runtime/f/h:asx	Landroidx/compose/runtime/f/h$a;
      //   131: astore 5
      //   133: new 13	androidx/compose/runtime/aw$i$a
      //   136: dup
      //   137: aload_0
      //   138: getfield 43	androidx/compose/runtime/aw$i:api	Landroidx/compose/runtime/aw;
      //   141: invokespecial 158	androidx/compose/runtime/aw$i$a:<init>	(Landroidx/compose/runtime/aw;)V
      //   144: checkcast 7	kotlin/g/a/m
      //   147: invokestatic 164	androidx/compose/runtime/f/h$a:c	(Lkotlin/g/a/m;)Landroidx/compose/runtime/f/f;
      //   150: astore 5
      //   152: getstatic 168	androidx/compose/runtime/aw:aoR	Landroidx/compose/runtime/aw$a;
      //   155: astore 7
      //   157: aload_0
      //   158: getfield 43	androidx/compose/runtime/aw$i:api	Landroidx/compose/runtime/aw;
      //   161: invokestatic 171	androidx/compose/runtime/aw:k	(Landroidx/compose/runtime/aw;)Landroidx/compose/runtime/aw$b;
      //   164: invokestatic 176	androidx/compose/runtime/aw$a:a	(Landroidx/compose/runtime/aw$b;)V
      //   167: aload_0
      //   168: getfield 43	androidx/compose/runtime/aw$i:api	Landroidx/compose/runtime/aw;
      //   171: invokestatic 179	androidx/compose/runtime/aw:a	(Landroidx/compose/runtime/aw;)Ljava/lang/Object;
      //   174: astore 7
      //   176: aload_0
      //   177: getfield 43	androidx/compose/runtime/aw$i:api	Landroidx/compose/runtime/aw;
      //   180: astore 8
      //   182: aload 7
      //   184: monitorenter
      //   185: aload 8
      //   187: invokestatic 183	androidx/compose/runtime/aw:b	(Landroidx/compose/runtime/aw;)Ljava/util/List;
      //   190: astore 8
      //   192: iconst_0
      //   193: istore_2
      //   194: aload 8
      //   196: invokeinterface 189 1 0
      //   201: iconst_1
      //   202: isub
      //   203: istore 4
      //   205: iload 4
      //   207: iflt +29 -> 236
      //   210: iload_2
      //   211: iconst_1
      //   212: iadd
      //   213: istore_3
      //   214: aload 8
      //   216: iload_2
      //   217: invokeinterface 192 2 0
      //   222: checkcast 194	androidx/compose/runtime/s
      //   225: invokeinterface 198 1 0
      //   230: iload_3
      //   231: iload 4
      //   233: if_icmple +312 -> 545
      //   236: getstatic 85	kotlin/ah:aiuX	Lkotlin/ah;
      //   239: astore 8
      //   241: aload 7
      //   243: monitorexit
      //   244: new 11	androidx/compose/runtime/aw$i$1
      //   247: dup
      //   248: aload_0
      //   249: getfield 45	androidx/compose/runtime/aw$i:apu	Lkotlin/g/a/q;
      //   252: aload_0
      //   253: getfield 47	androidx/compose/runtime/aw$i:apv	Landroidx/compose/runtime/al;
      //   256: aconst_null
      //   257: invokespecial 201	androidx/compose/runtime/aw$i$1:<init>	(Lkotlin/g/a/q;Landroidx/compose/runtime/al;Lkotlin/d/d;)V
      //   260: checkcast 7	kotlin/g/a/m
      //   263: astore 7
      //   265: aload_0
      //   266: checkcast 68	kotlin/d/d
      //   269: astore 8
      //   271: aload_0
      //   272: aload_1
      //   273: putfield 66	androidx/compose/runtime/aw$i:L$0	Ljava/lang/Object;
      //   276: aload_0
      //   277: aload 5
      //   279: putfield 203	androidx/compose/runtime/aw$i:Uf	Ljava/lang/Object;
      //   282: aload_0
      //   283: iconst_1
      //   284: putfield 98	androidx/compose/runtime/aw$i:label	I
      //   287: aload 7
      //   289: aload 8
      //   291: invokestatic 208	kotlinx/coroutines/ar:c	(Lkotlin/g/a/m;Lkotlin/d/d;)Ljava/lang/Object;
      //   294: astore 7
      //   296: aload 7
      //   298: aload 6
      //   300: if_acmpne +235 -> 535
      //   303: ldc 90
      //   305: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   308: aload 6
      //   310: areturn
      //   311: astore 6
      //   313: aload 7
      //   315: monitorexit
      //   316: ldc 90
      //   318: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   321: aload 6
      //   323: athrow
      //   324: astore 7
      //   326: aload_1
      //   327: astore 6
      //   329: aload 7
      //   331: astore_1
      //   332: aload 5
      //   334: invokeinterface 213 1 0
      //   339: aload_0
      //   340: getfield 43	androidx/compose/runtime/aw$i:api	Landroidx/compose/runtime/aw;
      //   343: invokestatic 179	androidx/compose/runtime/aw:a	(Landroidx/compose/runtime/aw;)Ljava/lang/Object;
      //   346: astore 5
      //   348: aload_0
      //   349: getfield 43	androidx/compose/runtime/aw$i:api	Landroidx/compose/runtime/aw;
      //   352: astore 7
      //   354: aload 5
      //   356: monitorenter
      //   357: aload 7
      //   359: invokestatic 217	androidx/compose/runtime/aw:l	(Landroidx/compose/runtime/aw;)Lkotlinx/coroutines/cb;
      //   362: aload 6
      //   364: if_acmpne +8 -> 372
      //   367: aload 7
      //   369: invokestatic 220	androidx/compose/runtime/aw:m	(Landroidx/compose/runtime/aw;)V
      //   372: aload 7
      //   374: invokestatic 224	androidx/compose/runtime/aw:e	(Landroidx/compose/runtime/aw;)Lkotlinx/coroutines/p;
      //   377: pop
      //   378: aload 5
      //   380: monitorexit
      //   381: getstatic 168	androidx/compose/runtime/aw:aoR	Landroidx/compose/runtime/aw$a;
      //   384: astore 5
      //   386: aload_0
      //   387: getfield 43	androidx/compose/runtime/aw$i:api	Landroidx/compose/runtime/aw;
      //   390: invokestatic 171	androidx/compose/runtime/aw:k	(Landroidx/compose/runtime/aw;)Landroidx/compose/runtime/aw$b;
      //   393: invokestatic 226	androidx/compose/runtime/aw$a:b	(Landroidx/compose/runtime/aw$b;)V
      //   396: ldc 90
      //   398: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   401: aload_1
      //   402: athrow
      //   403: aload_0
      //   404: getfield 203	androidx/compose/runtime/aw$i:Uf	Ljava/lang/Object;
      //   407: checkcast 210	androidx/compose/runtime/f/f
      //   410: astore 6
      //   412: aload_0
      //   413: getfield 66	androidx/compose/runtime/aw$i:L$0	Ljava/lang/Object;
      //   416: checkcast 117	kotlinx/coroutines/cb
      //   419: astore 5
      //   421: aload_1
      //   422: invokestatic 111	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
      //   425: aload 6
      //   427: invokeinterface 213 1 0
      //   432: aload_0
      //   433: getfield 43	androidx/compose/runtime/aw$i:api	Landroidx/compose/runtime/aw;
      //   436: invokestatic 179	androidx/compose/runtime/aw:a	(Landroidx/compose/runtime/aw;)Ljava/lang/Object;
      //   439: astore_1
      //   440: aload_0
      //   441: getfield 43	androidx/compose/runtime/aw$i:api	Landroidx/compose/runtime/aw;
      //   444: astore 6
      //   446: aload_1
      //   447: monitorenter
      //   448: aload 6
      //   450: invokestatic 217	androidx/compose/runtime/aw:l	(Landroidx/compose/runtime/aw;)Lkotlinx/coroutines/cb;
      //   453: aload 5
      //   455: if_acmpne +8 -> 463
      //   458: aload 6
      //   460: invokestatic 220	androidx/compose/runtime/aw:m	(Landroidx/compose/runtime/aw;)V
      //   463: aload 6
      //   465: invokestatic 224	androidx/compose/runtime/aw:e	(Landroidx/compose/runtime/aw;)Lkotlinx/coroutines/p;
      //   468: pop
      //   469: aload_1
      //   470: monitorexit
      //   471: getstatic 168	androidx/compose/runtime/aw:aoR	Landroidx/compose/runtime/aw$a;
      //   474: astore_1
      //   475: aload_0
      //   476: getfield 43	androidx/compose/runtime/aw$i:api	Landroidx/compose/runtime/aw;
      //   479: invokestatic 171	androidx/compose/runtime/aw:k	(Landroidx/compose/runtime/aw;)Landroidx/compose/runtime/aw$b;
      //   482: invokestatic 226	androidx/compose/runtime/aw$a:b	(Landroidx/compose/runtime/aw$b;)V
      //   485: getstatic 85	kotlin/ah:aiuX	Lkotlin/ah;
      //   488: astore_1
      //   489: ldc 90
      //   491: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   494: aload_1
      //   495: areturn
      //   496: astore 5
      //   498: aload_1
      //   499: monitorexit
      //   500: ldc 90
      //   502: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   505: aload 5
      //   507: athrow
      //   508: astore_1
      //   509: aload 5
      //   511: monitorexit
      //   512: ldc 90
      //   514: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   517: aload_1
      //   518: athrow
      //   519: astore_1
      //   520: aload 5
      //   522: astore 7
      //   524: aload 6
      //   526: astore 5
      //   528: aload 7
      //   530: astore 6
      //   532: goto -200 -> 332
      //   535: aload 5
      //   537: astore 6
      //   539: aload_1
      //   540: astore 5
      //   542: goto -117 -> 425
      //   545: iload_3
      //   546: istore_2
      //   547: goto -337 -> 210
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	550	0	this	i
      //   0	550	1	paramObject	Object
      //   193	354	2	i	int
      //   213	333	3	j	int
      //   203	31	4	k	int
      //   69	385	5	localObject1	Object
      //   496	25	5	localObject2	Object
      //   526	15	5	localObject3	Object
      //   8	301	6	locala	kotlin.d.a.a
      //   311	11	6	localObject4	Object
      //   327	211	6	localObject5	Object
      //   155	159	7	localObject6	Object
      //   324	6	7	localObject7	Object
      //   352	177	7	localObject8	Object
      //   180	110	8	localObject9	Object
      // Exception table:
      //   from	to	target	type
      //   185	192	311	finally
      //   194	205	311	finally
      //   214	230	311	finally
      //   236	241	311	finally
      //   167	185	324	finally
      //   241	296	324	finally
      //   313	324	324	finally
      //   448	463	496	finally
      //   463	469	496	finally
      //   357	372	508	finally
      //   372	378	508	finally
      //   421	425	519	finally
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "changed", "", "", "<anonymous parameter 1>", "Landroidx/compose/runtime/snapshots/Snapshot;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements m<Set<? extends Object>, androidx.compose.runtime.f.h, kotlin.ah>
    {
      a(aw paramaw)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "parentFrameClock", "Landroidx/compose/runtime/MonotonicFrameClock;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class j
    extends k
    implements kotlin.g.a.q<aq, al, d<? super kotlin.ah>, Object>
  {
    Object Uf;
    Object VC;
    int label;
    
    public j(aw paramaw, d<? super j> paramd)
    {
      super(paramd);
    }
    
    public final Object invokeSuspend(final Object paramObject)
    {
      AppMethodBeat.i(202410);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      al localal;
      final List localList;
      Object localObject1;
      Object localObject2;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(202410);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        localal = (al)this.L$0;
        paramObject = (List)new ArrayList();
        localList = (List)new ArrayList();
        if (aw.f(this.api))
        {
          localObject1 = this.api;
          localObject2 = (d)this;
          this.L$0 = localal;
          this.Uf = paramObject;
          this.VC = localList;
          this.label = 1;
          if (aw.a((aw)localObject1, (d)localObject2) != locala) {
            break label387;
          }
          AppMethodBeat.o(202410);
          return locala;
        }
        break;
      case 1: 
        localList = (List)this.VC;
        localObject1 = (List)this.Uf;
        localal = (al)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        paramObject = localObject1;
      }
      label387:
      for (;;)
      {
        localObject1 = aw.a(this.api);
        localObject2 = this.api;
        try
        {
          int i;
          if (!aw.i((aw)localObject2))
          {
            aw.h((aw)localObject2);
            boolean bool = aw.i((aw)localObject2);
            if (!bool) {
              i = 1;
            }
          }
          for (;;)
          {
            if (i != 0) {
              break;
            }
            localObject1 = (kotlin.g.a.b)new u(this.api)
            {
              /* Error */
              private p<kotlin.ah> z(long paramAnonymousLong)
              {
                // Byte code:
                //   0: ldc 50
                //   2: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
                //   5: aload_0
                //   6: getfield 37	androidx/compose/runtime/aw$j$1:api	Landroidx/compose/runtime/aw;
                //   9: invokestatic 61	androidx/compose/runtime/aw:g	(Landroidx/compose/runtime/aw;)Landroidx/compose/runtime/e;
                //   12: invokevirtual 67	androidx/compose/runtime/e:nT	()Z
                //   15: ifeq +181 -> 196
                //   18: aload_0
                //   19: getfield 37	androidx/compose/runtime/aw$j$1:api	Landroidx/compose/runtime/aw;
                //   22: astore 7
                //   24: getstatic 73	androidx/compose/runtime/bq:aqj	Landroidx/compose/runtime/bq;
                //   27: astore 8
                //   29: ldc 75
                //   31: invokestatic 79	androidx/compose/runtime/bq:ai	(Ljava/lang/String;)Ljava/lang/Object;
                //   34: pop
                //   35: aload 7
                //   37: invokestatic 61	androidx/compose/runtime/aw:g	(Landroidx/compose/runtime/aw;)Landroidx/compose/runtime/e;
                //   40: astore 7
                //   42: aload 7
                //   44: getfield 83	androidx/compose/runtime/e:lock	Ljava/lang/Object;
                //   47: astore 8
                //   49: aload 8
                //   51: monitorenter
                //   52: aload 7
                //   54: getfield 86	androidx/compose/runtime/e:alt	Ljava/util/List;
                //   57: astore 9
                //   59: aload 7
                //   61: aload 7
                //   63: getfield 89	androidx/compose/runtime/e:alu	Ljava/util/List;
                //   66: putfield 86	androidx/compose/runtime/e:alt	Ljava/util/List;
                //   69: aload 7
                //   71: aload 9
                //   73: putfield 89	androidx/compose/runtime/e:alu	Ljava/util/List;
                //   76: iconst_0
                //   77: istore_3
                //   78: aload 9
                //   80: invokeinterface 95 1 0
                //   85: istore 5
                //   87: iload 5
                //   89: ifle +71 -> 160
                //   92: iload_3
                //   93: iconst_1
                //   94: iadd
                //   95: istore 4
                //   97: aload 9
                //   99: iload_3
                //   100: invokeinterface 99 2 0
                //   105: checkcast 101	androidx/compose/runtime/e$a
                //   108: astore 7
                //   110: aload 7
                //   112: getfield 105	androidx/compose/runtime/e$a:alw	Lkotlin/d/d;
                //   115: astore 10
                //   117: getstatic 111	kotlin/Result:Companion	Lkotlin/Result$Companion;
                //   120: astore 11
                //   122: aload 7
                //   124: checkcast 101	androidx/compose/runtime/e$a
                //   127: getfield 115	androidx/compose/runtime/e$a:alv	Lkotlin/g/a/b;
                //   130: lload_1
                //   131: invokestatic 121	java/lang/Long:valueOf	(J)Ljava/lang/Long;
                //   134: invokeinterface 124 2 0
                //   139: invokestatic 127	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
                //   142: astore 7
                //   144: aload 10
                //   146: aload 7
                //   148: invokeinterface 133 2 0
                //   153: iload 4
                //   155: iload 5
                //   157: if_icmplt +696 -> 853
                //   160: aload 9
                //   162: invokeinterface 137 1 0
                //   167: getstatic 143	kotlin/ah:aiuX	Lkotlin/ah;
                //   170: astore 7
                //   172: aload 8
                //   174: monitorexit
                //   175: getstatic 149	androidx/compose/runtime/f/h:asx	Landroidx/compose/runtime/f/h$a;
                //   178: astore 7
                //   180: invokestatic 154	androidx/compose/runtime/f/h$a:rv	()V
                //   183: getstatic 143	kotlin/ah:aiuX	Lkotlin/ah;
                //   186: astore 7
                //   188: getstatic 73	androidx/compose/runtime/bq:aqj	Landroidx/compose/runtime/bq;
                //   191: astore 7
                //   193: invokestatic 157	androidx/compose/runtime/bq:qo	()V
                //   196: aload_0
                //   197: getfield 37	androidx/compose/runtime/aw$j$1:api	Landroidx/compose/runtime/aw;
                //   200: astore 7
                //   202: aload_0
                //   203: getfield 39	androidx/compose/runtime/aw$j$1:apw	Ljava/util/List;
                //   206: astore 8
                //   208: aload_0
                //   209: getfield 41	androidx/compose/runtime/aw$j$1:apx	Ljava/util/List;
                //   212: astore 9
                //   214: getstatic 73	androidx/compose/runtime/bq:aqj	Landroidx/compose/runtime/bq;
                //   217: astore 10
                //   219: ldc 159
                //   221: invokestatic 79	androidx/compose/runtime/bq:ai	(Ljava/lang/String;)Ljava/lang/Object;
                //   224: pop
                //   225: aload 7
                //   227: invokestatic 163	androidx/compose/runtime/aw:a	(Landroidx/compose/runtime/aw;)Ljava/lang/Object;
                //   230: astore 10
                //   232: aload 10
                //   234: monitorenter
                //   235: aload 7
                //   237: invokestatic 167	androidx/compose/runtime/aw:h	(Landroidx/compose/runtime/aw;)V
                //   240: aload 7
                //   242: invokestatic 171	androidx/compose/runtime/aw:d	(Landroidx/compose/runtime/aw;)Ljava/util/List;
                //   245: astore 11
                //   247: iconst_0
                //   248: istore_3
                //   249: aload 11
                //   251: invokeinterface 95 1 0
                //   256: iconst_1
                //   257: isub
                //   258: istore 5
                //   260: iload 5
                //   262: iflt +41 -> 303
                //   265: iload_3
                //   266: iconst_1
                //   267: iadd
                //   268: istore 4
                //   270: aload 11
                //   272: iload_3
                //   273: invokeinterface 99 2 0
                //   278: checkcast 173	androidx/compose/runtime/s
                //   281: astore 12
                //   283: aload 8
                //   285: checkcast 175	java/util/Collection
                //   288: aload 12
                //   290: invokeinterface 179 2 0
                //   295: pop
                //   296: iload 4
                //   298: iload 5
                //   300: if_icmple +547 -> 847
                //   303: aload 7
                //   305: invokestatic 171	androidx/compose/runtime/aw:d	(Landroidx/compose/runtime/aw;)Ljava/util/List;
                //   308: invokeinterface 137 1 0
                //   313: getstatic 143	kotlin/ah:aiuX	Lkotlin/ah;
                //   316: astore 11
                //   318: aload 10
                //   320: monitorexit
                //   321: new 181	androidx/compose/runtime/a/c
                //   324: dup
                //   325: invokespecial 183	androidx/compose/runtime/a/c:<init>	()V
                //   328: astore 10
                //   330: new 181	androidx/compose/runtime/a/c
                //   333: dup
                //   334: invokespecial 183	androidx/compose/runtime/a/c:<init>	()V
                //   337: astore 11
                //   339: aload 8
                //   341: checkcast 175	java/util/Collection
                //   344: invokeinterface 186 1 0
                //   349: istore 6
                //   351: iload 6
                //   353: ifne +516 -> 869
                //   356: iconst_1
                //   357: istore_3
                //   358: iload_3
                //   359: ifeq +315 -> 674
                //   362: iconst_0
                //   363: istore_3
                //   364: aload 8
                //   366: invokeinterface 95 1 0
                //   371: iconst_1
                //   372: isub
                //   373: istore 5
                //   375: iload 5
                //   377: iflt +65 -> 442
                //   380: iload_3
                //   381: iconst_1
                //   382: iadd
                //   383: istore 4
                //   385: aload 8
                //   387: iload_3
                //   388: invokeinterface 99 2 0
                //   393: checkcast 173	androidx/compose/runtime/s
                //   396: astore 12
                //   398: aload 11
                //   400: aload 12
                //   402: invokevirtual 187	androidx/compose/runtime/a/c:add	(Ljava/lang/Object;)Z
                //   405: pop
                //   406: aload 7
                //   408: aload 12
                //   410: aload 10
                //   412: invokestatic 190	androidx/compose/runtime/aw:a	(Landroidx/compose/runtime/aw;Landroidx/compose/runtime/s;Landroidx/compose/runtime/a/c;)Landroidx/compose/runtime/s;
                //   415: astore 12
                //   417: aload 12
                //   419: ifnull +16 -> 435
                //   422: aload 9
                //   424: checkcast 175	java/util/Collection
                //   427: aload 12
                //   429: invokeinterface 179 2 0
                //   434: pop
                //   435: iload 4
                //   437: iload 5
                //   439: if_icmple +402 -> 841
                //   442: aload 8
                //   444: invokeinterface 137 1 0
                //   449: aload 10
                //   451: invokevirtual 193	androidx/compose/runtime/a/c:qn	()Z
                //   454: ifeq -115 -> 339
                //   457: aload 7
                //   459: invokestatic 163	androidx/compose/runtime/aw:a	(Landroidx/compose/runtime/aw;)Ljava/lang/Object;
                //   462: astore 12
                //   464: aload 12
                //   466: monitorenter
                //   467: aload 7
                //   469: invokestatic 196	androidx/compose/runtime/aw:b	(Landroidx/compose/runtime/aw;)Ljava/util/List;
                //   472: astore 13
                //   474: iconst_0
                //   475: istore_3
                //   476: aload 13
                //   478: invokeinterface 95 1 0
                //   483: iconst_1
                //   484: isub
                //   485: istore 5
                //   487: iload 5
                //   489: iflt +62 -> 551
                //   492: iload_3
                //   493: iconst_1
                //   494: iadd
                //   495: istore 4
                //   497: aload 13
                //   499: iload_3
                //   500: invokeinterface 99 2 0
                //   505: checkcast 173	androidx/compose/runtime/s
                //   508: astore 14
                //   510: aload 11
                //   512: aload 14
                //   514: invokevirtual 199	androidx/compose/runtime/a/c:contains	(Ljava/lang/Object;)Z
                //   517: ifne +342 -> 859
                //   520: aload 14
                //   522: aload 10
                //   524: checkcast 201	java/util/Set
                //   527: invokeinterface 205 2 0
                //   532: ifeq +327 -> 859
                //   535: aload 8
                //   537: checkcast 175	java/util/Collection
                //   540: aload 14
                //   542: invokeinterface 179 2 0
                //   547: pop
                //   548: goto +311 -> 859
                //   551: getstatic 143	kotlin/ah:aiuX	Lkotlin/ah;
                //   554: astore 13
                //   556: aload 12
                //   558: monitorexit
                //   559: goto -220 -> 339
                //   562: astore 7
                //   564: getstatic 73	androidx/compose/runtime/bq:aqj	Landroidx/compose/runtime/bq;
                //   567: astore 8
                //   569: invokestatic 157	androidx/compose/runtime/bq:qo	()V
                //   572: ldc 50
                //   574: invokestatic 208	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
                //   577: aload 7
                //   579: athrow
                //   580: astore 7
                //   582: getstatic 111	kotlin/Result:Companion	Lkotlin/Result$Companion;
                //   585: astore 11
                //   587: aload 7
                //   589: invokestatic 214	kotlin/ResultKt:createFailure	(Ljava/lang/Throwable;)Ljava/lang/Object;
                //   592: invokestatic 127	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
                //   595: astore 7
                //   597: goto -453 -> 144
                //   600: astore 7
                //   602: aload 8
                //   604: monitorexit
                //   605: ldc 50
                //   607: invokestatic 208	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
                //   610: aload 7
                //   612: athrow
                //   613: astore 7
                //   615: getstatic 73	androidx/compose/runtime/bq:aqj	Landroidx/compose/runtime/bq;
                //   618: astore 8
                //   620: invokestatic 157	androidx/compose/runtime/bq:qo	()V
                //   623: ldc 50
                //   625: invokestatic 208	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
                //   628: aload 7
                //   630: athrow
                //   631: astore 7
                //   633: aload 10
                //   635: monitorexit
                //   636: ldc 50
                //   638: invokestatic 208	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
                //   641: aload 7
                //   643: athrow
                //   644: astore 7
                //   646: aload 8
                //   648: invokeinterface 137 1 0
                //   653: ldc 50
                //   655: invokestatic 208	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
                //   658: aload 7
                //   660: athrow
                //   661: astore 7
                //   663: aload 12
                //   665: monitorexit
                //   666: ldc 50
                //   668: invokestatic 208	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
                //   671: aload 7
                //   673: athrow
                //   674: aload 9
                //   676: checkcast 175	java/util/Collection
                //   679: invokeinterface 186 1 0
                //   684: ifne +110 -> 794
                //   687: iconst_1
                //   688: istore_3
                //   689: iload_3
                //   690: ifeq +68 -> 758
                //   693: aload 7
                //   695: aload 7
                //   697: getfield 218	androidx/compose/runtime/aw:aoS	J
                //   700: lconst_1
                //   701: ladd
                //   702: invokestatic 221	androidx/compose/runtime/aw:a	(Landroidx/compose/runtime/aw;J)V
                //   705: iconst_0
                //   706: istore_3
                //   707: aload 9
                //   709: invokeinterface 95 1 0
                //   714: iconst_1
                //   715: isub
                //   716: istore 5
                //   718: iload 5
                //   720: iflt +31 -> 751
                //   723: iload_3
                //   724: iconst_1
                //   725: iadd
                //   726: istore 4
                //   728: aload 9
                //   730: iload_3
                //   731: invokeinterface 99 2 0
                //   736: checkcast 173	androidx/compose/runtime/s
                //   739: invokeinterface 224 1 0
                //   744: iload 4
                //   746: iload 5
                //   748: if_icmple +81 -> 829
                //   751: aload 9
                //   753: invokeinterface 137 1 0
                //   758: aload 7
                //   760: invokestatic 163	androidx/compose/runtime/aw:a	(Landroidx/compose/runtime/aw;)Ljava/lang/Object;
                //   763: astore 8
                //   765: aload 8
                //   767: monitorenter
                //   768: aload 7
                //   770: invokestatic 228	androidx/compose/runtime/aw:e	(Landroidx/compose/runtime/aw;)Lkotlinx/coroutines/p;
                //   773: astore 7
                //   775: aload 8
                //   777: monitorexit
                //   778: getstatic 73	androidx/compose/runtime/bq:aqj	Landroidx/compose/runtime/bq;
                //   781: astore 8
                //   783: invokestatic 157	androidx/compose/runtime/bq:qo	()V
                //   786: ldc 50
                //   788: invokestatic 208	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
                //   791: aload 7
                //   793: areturn
                //   794: iconst_0
                //   795: istore_3
                //   796: goto -107 -> 689
                //   799: astore 7
                //   801: aload 9
                //   803: invokeinterface 137 1 0
                //   808: ldc 50
                //   810: invokestatic 208	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
                //   813: aload 7
                //   815: athrow
                //   816: astore 7
                //   818: aload 8
                //   820: monitorexit
                //   821: ldc 50
                //   823: invokestatic 208	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
                //   826: aload 7
                //   828: athrow
                //   829: iload 4
                //   831: istore_3
                //   832: goto -109 -> 723
                //   835: iload 4
                //   837: istore_3
                //   838: goto -346 -> 492
                //   841: iload 4
                //   843: istore_3
                //   844: goto -464 -> 380
                //   847: iload 4
                //   849: istore_3
                //   850: goto -585 -> 265
                //   853: iload 4
                //   855: istore_3
                //   856: goto -764 -> 92
                //   859: iload 4
                //   861: iload 5
                //   863: if_icmple -28 -> 835
                //   866: goto -315 -> 551
                //   869: iconst_0
                //   870: istore_3
                //   871: goto -513 -> 358
                // Local variable table:
                //   start	length	slot	name	signature
                //   0	874	0	this	1
                //   0	874	1	paramAnonymousLong	long
                //   77	794	3	i	int
                //   95	769	4	j	int
                //   85	779	5	k	int
                //   349	3	6	bool	boolean
                //   22	446	7	localObject1	Object
                //   562	16	7	localObject2	Object
                //   580	8	7	localThrowable	Throwable
                //   595	1	7	localObject3	Object
                //   600	11	7	localObject4	Object
                //   613	16	7	localObject5	Object
                //   631	11	7	localObject6	Object
                //   644	15	7	localObject7	Object
                //   661	108	7	localaw	aw
                //   773	19	7	localp	p
                //   799	15	7	localObject8	Object
                //   816	11	7	localObject9	Object
                //   57	745	9	localList	List
                //   115	519	10	localObject11	Object
                //   120	466	11	localObject12	Object
                //   281	383	12	localObject13	Object
                //   472	83	13	localObject14	Object
                //   508	33	14	locals	s
                // Exception table:
                //   from	to	target	type
                //   225	235	562	finally
                //   318	339	562	finally
                //   339	351	562	finally
                //   442	467	562	finally
                //   556	559	562	finally
                //   633	644	562	finally
                //   646	661	562	finally
                //   663	674	562	finally
                //   674	687	562	finally
                //   693	705	562	finally
                //   751	758	562	finally
                //   758	768	562	finally
                //   775	778	562	finally
                //   801	816	562	finally
                //   818	829	562	finally
                //   117	144	580	finally
                //   52	76	600	finally
                //   78	87	600	finally
                //   97	117	600	finally
                //   144	153	600	finally
                //   160	172	600	finally
                //   582	597	600	finally
                //   35	52	613	finally
                //   172	188	613	finally
                //   602	613	613	finally
                //   235	247	631	finally
                //   249	260	631	finally
                //   270	296	631	finally
                //   303	318	631	finally
                //   364	375	644	finally
                //   385	417	644	finally
                //   422	435	644	finally
                //   467	474	661	finally
                //   476	487	661	finally
                //   497	548	661	finally
                //   551	556	661	finally
                //   707	718	799	finally
                //   728	744	799	finally
                //   768	775	816	finally
              }
            };
            localObject2 = (d)this;
            this.L$0 = localal;
            this.Uf = paramObject;
            this.VC = localList;
            this.label = 2;
            return locala;
            i = 0;
            continue;
            i = 0;
          }
          localal = (al)this.L$0;
        }
        finally
        {
          AppMethodBeat.o(202410);
        }
        ResultKt.throwOnFailure(paramObject);
        paramObject = localObject1;
        for (;;)
        {
          break;
          paramObject = kotlin.ah.aiuX;
          AppMethodBeat.o(202410);
          return paramObject;
        }
        break;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "value", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.b<Object, kotlin.ah>
  {
    k(s params, androidx.compose.runtime.a.c<Object> paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.aw
 * JD-Core Version:    0.7.0.1
 */