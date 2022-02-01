package androidx.compose.runtime.f;

import androidx.compose.runtime.bk;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.f;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"INVALID_SNAPSHOT", "", "applyObservers", "", "Lkotlin/Function2;", "", "", "Landroidx/compose/runtime/snapshots/Snapshot;", "", "currentGlobalSnapshot", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/runtime/snapshots/GlobalSnapshot;", "kotlin.jvm.PlatformType", "Landroidx/compose/runtime/AtomicReference;", "emptyLambda", "Lkotlin/Function1;", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "Lkotlin/ParameterName;", "name", "invalid", "globalWriteObservers", "lock", "getLock$annotations", "()V", "getLock", "()Ljava/lang/Object;", "nextSnapshotId", "openSnapshots", "snapshotInitializer", "getSnapshotInitializer$annotations", "getSnapshotInitializer", "()Landroidx/compose/runtime/snapshots/Snapshot;", "threadSnapshot", "Landroidx/compose/runtime/SnapshotThreadLocal;", "advanceGlobalSnapshot", "T", "block", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "current", "Landroidx/compose/runtime/snapshots/StateRecord;", "r", "snapshot", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/Snapshot;)Landroidx/compose/runtime/snapshots/StateRecord;", "currentSnapshot", "mergedReadObserver", "readObserver", "parentObserver", "mergedWriteObserver", "writeObserver", "notifyWrite", "state", "Landroidx/compose/runtime/snapshots/StateObject;", "optimisticMerges", "", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "applyingSnapshot", "invalidSnapshots", "readError", "", "readable", "id", "(Landroidx/compose/runtime/snapshots/StateRecord;ILandroidx/compose/runtime/snapshots/SnapshotIdSet;)Landroidx/compose/runtime/snapshots/StateRecord;", "sync", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "takeNewGlobalSnapshot", "previousGlobalSnapshot", "(Landroidx/compose/runtime/snapshots/Snapshot;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "takeNewSnapshot", "(Lkotlin/jvm/functions/Function1;)Landroidx/compose/runtime/snapshots/Snapshot;", "used", "valid", "", "data", "candidateSnapshot", "validateOpen", "newOverwritableRecord", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Landroidx/compose/runtime/snapshots/Snapshot;)Landroidx/compose/runtime/snapshots/StateRecord;", "newWritableRecord", "overwritable", "R", "candidate", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Landroidx/compose/runtime/snapshots/StateRecord;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "overwritableRecord", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Landroidx/compose/runtime/snapshots/Snapshot;Landroidx/compose/runtime/snapshots/StateRecord;)Landroidx/compose/runtime/snapshots/StateRecord;", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;)Landroidx/compose/runtime/snapshots/StateRecord;", "withCurrent", "(Landroidx/compose/runtime/snapshots/StateRecord;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writable", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Landroidx/compose/runtime/snapshots/Snapshot;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writableRecord", "runtime_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class l
{
  private static final b<j, ah> asK;
  private static final bk<h> asL;
  private static j asM;
  private static int asN;
  private static final List<m<Set<? extends Object>, h, ah>> asO;
  private static final List<b<Object, ah>> asP;
  private static final AtomicReference<a> asQ;
  private static final h asR;
  private static final Object lock;
  
  static
  {
    AppMethodBeat.i(202802);
    asK = (b)l.b.asT;
    asL = new bk();
    lock = new Object();
    Object localObject = j.asC;
    asM = j.rw();
    asN = 1;
    asO = (List)new ArrayList();
    asP = (List)new ArrayList();
    int i = asN;
    asN = i + 1;
    localObject = j.asC;
    localObject = new a(i, j.rw());
    asM = asM.cs(((a)localObject).getId());
    ah localah = ah.aiuX;
    localObject = new AtomicReference(localObject);
    asQ = (AtomicReference)localObject;
    localObject = ((AtomicReference)localObject).get();
    s.s(localObject, "currentGlobalSnapshot.get()");
    asR = (h)localObject;
    AppMethodBeat.o(202802);
  }
  
  private static final ab a(aa paramaa, int paramInt, j paramj)
  {
    AppMethodBeat.i(202644);
    paramaa = paramaa.pp();
    Object localObject1 = paramj.asG;
    if (localObject1 != null)
    {
      paramInt = localObject1[0];
      localObject1 = null;
    }
    for (;;)
    {
      if (paramaa != null)
      {
        if (paramaa.att == 0)
        {
          AppMethodBeat.o(202644);
          return paramaa;
          if (paramj.asE != 0L)
          {
            paramInt = paramj.asF + k.C(paramj.asE);
            break;
          }
          if (paramj.asD == 0L) {
            break;
          }
          paramInt = paramj.asF + 64 + k.C(paramj.asD);
          break;
        }
        Object localObject2 = localObject1;
        if (a(paramaa, paramInt, paramj))
        {
          if (localObject1 == null) {
            localObject2 = paramaa;
          }
        }
        else
        {
          paramaa = paramaa.atu;
          localObject1 = localObject2;
          continue;
        }
        if (paramaa.att < ((ab)localObject1).att)
        {
          AppMethodBeat.o(202644);
          return paramaa;
        }
        AppMethodBeat.o(202644);
        return localObject1;
      }
    }
    AppMethodBeat.o(202644);
    return null;
  }
  
  public static final <T extends ab> T a(T paramT, aa paramaa)
  {
    AppMethodBeat.i(202611);
    s.u(paramT, "<this>");
    s.u(paramaa, "state");
    paramT = a(paramT, paramaa, rx());
    AppMethodBeat.o(202611);
    return paramT;
  }
  
  public static final <T extends ab> T a(T paramT, aa paramaa, h paramh)
  {
    AppMethodBeat.i(202626);
    s.u(paramT, "<this>");
    s.u(paramaa, "state");
    s.u(paramh, "snapshot");
    b localb = paramh.rh();
    if (localb != null) {
      localb.invoke(paramaa);
    }
    paramT = b(paramT, paramh.getId(), paramh.rq());
    if (paramT == null)
    {
      rA();
      paramT = new f();
      AppMethodBeat.o(202626);
      throw paramT;
    }
    AppMethodBeat.o(202626);
    return paramT;
  }
  
  public static final <T extends ab> T a(T paramT1, aa paramaa, h paramh, T paramT2)
  {
    AppMethodBeat.i(202661);
    s.u(paramT1, "<this>");
    s.u(paramaa, "state");
    s.u(paramh, "snapshot");
    s.u(paramT2, "candidate");
    if (paramh.rj()) {
      paramh.a(paramaa);
    }
    int i = paramh.getId();
    if (paramT2.att == i)
    {
      AppMethodBeat.o(202661);
      return paramT2;
    }
    paramT1 = d(paramT1, paramaa, paramh);
    paramT1.att = i;
    paramh.a(paramaa);
    AppMethodBeat.o(202661);
    return paramT1;
  }
  
  public static final <T extends ab> T a(T paramT, h paramh)
  {
    AppMethodBeat.i(202697);
    s.u(paramT, "r");
    s.u(paramh, "snapshot");
    paramT = b(paramT, paramh.getId(), paramh.rq());
    if (paramT == null)
    {
      rA();
      paramT = new f();
      AppMethodBeat.o(202697);
      throw paramT;
    }
    AppMethodBeat.o(202697);
    return paramT;
  }
  
  private static final <T> T a(h paramh, b<? super j, ? extends T> arg1)
  {
    AppMethodBeat.i(202565);
    Object localObject = ???.invoke(asM.ct(paramh.getId()));
    synchronized (lock)
    {
      int i = asN;
      asN = i + 1;
      asM = asM.ct(paramh.getId());
      asQ.set(new a(i, asM));
      asM = asM.cs(i);
      paramh = ah.aiuX;
      AppMethodBeat.o(202565);
      return localObject;
    }
  }
  
  public static final void a(h paramh, aa paramaa)
  {
    AppMethodBeat.i(202690);
    s.u(paramh, "snapshot");
    s.u(paramaa, "state");
    paramh = paramh.ri();
    if (paramh != null) {
      paramh.invoke(paramaa);
    }
    AppMethodBeat.o(202690);
  }
  
  private static final boolean a(ab paramab, int paramInt, j paramj)
  {
    AppMethodBeat.i(202592);
    int i = paramab.att;
    if ((i != 0) && (i <= paramInt) && (!paramj.cr(i)))
    {
      AppMethodBeat.o(202592);
      return true;
    }
    AppMethodBeat.o(202592);
    return false;
  }
  
  private static final <T extends ab> T b(T paramT, int paramInt, j paramj)
  {
    AppMethodBeat.i(202604);
    Object localObject2 = null;
    if (paramT != null)
    {
      Object localObject1 = localObject2;
      if (a(paramT, paramInt, paramj))
      {
        if (localObject2 != null) {
          break label43;
        }
        localObject1 = paramT;
      }
      for (;;)
      {
        paramT = paramT.atu;
        localObject2 = localObject1;
        break;
        label43:
        localObject1 = localObject2;
        if (localObject2.att < paramT.att) {
          localObject1 = paramT;
        }
      }
    }
    if (localObject2 != null)
    {
      AppMethodBeat.o(202604);
      return localObject2;
    }
    AppMethodBeat.o(202604);
    return null;
  }
  
  public static final <T extends ab> T b(T paramT, aa paramaa, h paramh)
  {
    AppMethodBeat.i(202654);
    s.u(paramT, "<this>");
    s.u(paramaa, "state");
    s.u(paramh, "snapshot");
    if (paramh.rj()) {
      paramh.a(paramaa);
    }
    ab localab = b(paramT, paramh.getId(), paramh.rq());
    if (localab == null)
    {
      rA();
      paramT = new f();
      AppMethodBeat.o(202654);
      throw paramT;
    }
    if (localab.att == paramh.getId())
    {
      AppMethodBeat.o(202654);
      return localab;
    }
    paramT = c(paramT, paramaa, paramh);
    paramh.a(paramaa);
    AppMethodBeat.o(202654);
    return paramT;
  }
  
  public static final <T extends ab> T c(T paramT, aa paramaa, h paramh)
  {
    AppMethodBeat.i(202673);
    s.u(paramT, "<this>");
    s.u(paramaa, "state");
    s.u(paramh, "snapshot");
    paramaa = d(paramT, paramaa, paramh);
    paramaa.b(paramT);
    paramaa.att = paramh.getId();
    AppMethodBeat.o(202673);
    return paramaa;
  }
  
  private static <T extends ab> T d(T paramT, aa paramaa, h paramh)
  {
    AppMethodBeat.i(202683);
    s.u(paramT, "<this>");
    s.u(paramaa, "state");
    s.u(paramh, "snapshot");
    paramh = a(paramaa, paramh.getId(), asM);
    if (paramh == null) {
      paramh = null;
    }
    while (paramh == null)
    {
      paramT = paramT.ps();
      paramT.att = 2147483647;
      paramT.atu = paramaa.pp();
      paramaa.a(paramT);
      AppMethodBeat.o(202683);
      return paramT;
      paramh.att = 2147483647;
    }
    AppMethodBeat.o(202683);
    return paramh;
  }
  
  private static final <T> T j(b<? super j, ? extends T> paramb)
  {
    AppMethodBeat.i(202581);
    a locala = (a)asQ.get();
    Set localSet;
    synchronized (lock)
    {
      s.s(locala, "previousGlobalSnapshot");
      paramb = a((h)locala, paramb);
      localSet = locala.rn();
      if (localSet == null) {}
    }
    for (;;)
    {
      int j;
      synchronized (lock)
      {
        List localList = p.J((Collection)asO);
        i = 0;
        int k = localList.size() - 1;
        if (k >= 0)
        {
          j = i + 1;
          ((m)localList.get(i)).invoke(localSet, locala);
          if (j <= k) {}
        }
        else
        {
          AppMethodBeat.o(202581);
          return paramb;
          paramb = finally;
          AppMethodBeat.o(202581);
          throw paramb;
        }
      }
      int i = j;
    }
  }
  
  private static final Void rA()
  {
    AppMethodBeat.i(202635);
    Throwable localThrowable = (Throwable)new IllegalStateException("Reading a state that was created after the snapshot was taken or in a snapshot that has not yet been applied".toString());
    AppMethodBeat.o(202635);
    throw localThrowable;
  }
  
  public static final h rx()
  {
    AppMethodBeat.i(202536);
    Object localObject = (h)asL.get();
    if (localObject == null)
    {
      localObject = asQ.get();
      s.s(localObject, "currentGlobalSnapshot.get()");
      localObject = (h)localObject;
      AppMethodBeat.o(202536);
      return localObject;
    }
    AppMethodBeat.o(202536);
    return localObject;
  }
  
  public static final Object ry()
  {
    return lock;
  }
  
  public static final h rz()
  {
    return asR;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "T", "Landroidx/compose/runtime/snapshots/Snapshot;", "invalid", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements b<j, T>
  {
    e(b<? super j, ? extends T> paramb)
    {
      super();
    }
    
    private T m(j arg1)
    {
      AppMethodBeat.i(202666);
      s.u(???, "invalid");
      h localh = (h)this.Uk.invoke(???);
      synchronized (l.ry())
      {
        l.l(l.rG().cs(localh.getId()));
        ah localah = ah.aiuX;
        AppMethodBeat.o(202666);
        return localh;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.f.l
 * JD-Core Version:    0.7.0.1
 */