package androidx.compose.runtime.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/snapshots/TransparentObserverMutableSnapshot;", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "previousSnapshot", "specifiedReadObserver", "Lkotlin/Function1;", "", "", "specifiedWriteObserver", "(Landroidx/compose/runtime/snapshots/MutableSnapshot;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "currentSnapshot", "getCurrentSnapshot", "()Landroidx/compose/runtime/snapshots/MutableSnapshot;", "value", "", "id", "getId", "()I", "setId$runtime_release", "(I)V", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "invalid", "getInvalid$runtime_release", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "setInvalid$runtime_release", "(Landroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "", "Landroidx/compose/runtime/snapshots/StateObject;", "modified", "getModified$runtime_release", "()Ljava/util/Set;", "setModified", "(Ljava/util/Set;)V", "readOnly", "", "getReadOnly", "()Z", "getSpecifiedReadObserver$runtime_release", "()Lkotlin/jvm/functions/Function1;", "getSpecifiedWriteObserver$runtime_release", "apply", "Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "dispose", "hasPendingChanges", "nestedActivated", "", "snapshot", "Landroidx/compose/runtime/snapshots/Snapshot;", "nestedActivated$runtime_release", "nestedDeactivated", "nestedDeactivated$runtime_release", "notifyObjectsInitialized", "notifyObjectsInitialized$runtime_release", "recordModified", "state", "recordModified$runtime_release", "takeNestedMutableSnapshot", "readObserver", "writeObserver", "takeNestedSnapshot", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ad
  extends c
{
  private final b<Object, ah> atA;
  private final c aty;
  private final b<Object, ah> atz;
  
  public ad(c paramc, b<Object, ah> paramb) {}
  
  private final c rS()
  {
    AppMethodBeat.i(202470);
    Object localObject = this.aty;
    if (localObject == null)
    {
      localObject = l.rH().get();
      s.s(localObject, "currentGlobalSnapshot.get()");
      localObject = (c)localObject;
      AppMethodBeat.o(202470);
      return localObject;
    }
    AppMethodBeat.o(202470);
    return localObject;
  }
  
  public final void a(aa paramaa)
  {
    AppMethodBeat.i(202526);
    s.u(paramaa, "state");
    rS().a(paramaa);
    AppMethodBeat.o(202526);
  }
  
  public final c c(b<Object, ah> paramb1, b<Object, ah> paramb2)
  {
    AppMethodBeat.i(202542);
    paramb1 = rS().c(l.e(paramb1, rh()), l.f(paramb2, ri()));
    AppMethodBeat.o(202542);
    return paramb1;
  }
  
  public final void cq(int paramInt)
  {
    AppMethodBeat.i(202484);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(202484);
    throw localUnsupportedOperationException;
  }
  
  public final void dispose()
  {
    AppMethodBeat.i(202475);
    rt();
    AppMethodBeat.o(202475);
  }
  
  public final void e(j paramj)
  {
    AppMethodBeat.i(202496);
    s.u(paramj, "value");
    paramj = new UnsupportedOperationException();
    AppMethodBeat.o(202496);
    throw paramj;
  }
  
  public final int getId()
  {
    AppMethodBeat.i(202479);
    int i = rS().getId();
    AppMethodBeat.o(202479);
    return i;
  }
  
  public final h h(b<Object, ah> paramb)
  {
    AppMethodBeat.i(202533);
    paramb = rS().h(l.e(paramb, rh()));
    AppMethodBeat.o(202533);
    return paramb;
  }
  
  public final void h(Set<aa> paramSet)
  {
    AppMethodBeat.i(202507);
    paramSet = new UnsupportedOperationException();
    AppMethodBeat.o(202507);
    throw paramSet;
  }
  
  public final void rf()
  {
    AppMethodBeat.i(202550);
    rS().rf();
    AppMethodBeat.o(202550);
  }
  
  public final i rg()
  {
    AppMethodBeat.i(202520);
    i locali = rS().rg();
    AppMethodBeat.o(202520);
    return locali;
  }
  
  public final boolean rj()
  {
    AppMethodBeat.i(202512);
    boolean bool = rS().rj();
    AppMethodBeat.o(202512);
    return bool;
  }
  
  public final Set<aa> rn()
  {
    AppMethodBeat.i(202502);
    Set localSet = rS().rn();
    AppMethodBeat.o(202502);
    return localSet;
  }
  
  public final j rq()
  {
    AppMethodBeat.i(202491);
    j localj = rS().rq();
    AppMethodBeat.o(202491);
    return localj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.f.ad
 * JD-Core Version:    0.7.0.1
 */