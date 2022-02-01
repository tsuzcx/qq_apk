package androidx.compose.runtime.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/snapshots/ReadonlySnapshot;", "Landroidx/compose/runtime/snapshots/Snapshot;", "id", "", "invalid", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "readObserver", "Lkotlin/Function1;", "", "", "(ILandroidx/compose/runtime/snapshots/SnapshotIdSet;Lkotlin/jvm/functions/Function1;)V", "value", "Ljava/util/HashSet;", "Landroidx/compose/runtime/snapshots/StateObject;", "Lkotlin/collections/HashSet;", "modified", "getModified$runtime_release", "()Ljava/util/HashSet;", "setModified", "(Ljava/util/HashSet;)V", "getReadObserver$runtime_release", "()Lkotlin/jvm/functions/Function1;", "readOnly", "", "getReadOnly", "()Z", "root", "getRoot", "()Landroidx/compose/runtime/snapshots/Snapshot;", "snapshots", "writeObserver", "getWriteObserver$runtime_release", "dispose", "hasPendingChanges", "nestedActivated", "snapshot", "nestedActivated$runtime_release", "nestedDeactivated", "nestedDeactivated$runtime_release", "notifyObjectsInitialized", "notifyObjectsInitialized$runtime_release", "recordModified", "state", "recordModified$runtime_release", "takeNestedSnapshot", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends h
{
  private final b<Object, ah> asp;
  private int ast;
  
  public g(int paramInt, j paramj, b<Object, ah> paramb)
  {
    super(paramInt, paramj, (byte)0);
    AppMethodBeat.i(202534);
    this.asp = paramb;
    this.ast = 1;
    AppMethodBeat.o(202534);
  }
  
  public final void a(aa paramaa)
  {
    AppMethodBeat.i(202651);
    s.u(paramaa, "state");
    paramaa = (Throwable)new IllegalStateException("Cannot modify a state object in a read-only snapshot".toString());
    AppMethodBeat.o(202651);
    throw paramaa;
  }
  
  public final void a(h paramh)
  {
    AppMethodBeat.i(202641);
    s.u(paramh, "snapshot");
    this.ast -= 1;
    if (this.ast == 0) {
      rk();
    }
    AppMethodBeat.o(202641);
  }
  
  public final void b(h paramh)
  {
    AppMethodBeat.i(202629);
    s.u(paramh, "snapshot");
    this.ast += 1;
    AppMethodBeat.o(202629);
  }
  
  public final void dispose()
  {
    AppMethodBeat.i(202615);
    if (!rs())
    {
      a((h)this);
      super.dispose();
    }
    AppMethodBeat.o(202615);
  }
  
  public final h h(b<Object, ah> paramb)
  {
    AppMethodBeat.i(202591);
    l.d((h)this);
    paramb = (h)new e(getId(), rq(), paramb, (h)this);
    AppMethodBeat.o(202591);
    return paramb;
  }
  
  public final void rf() {}
  
  public final b<Object, ah> rh()
  {
    return this.asp;
  }
  
  public final b<Object, ah> ri()
  {
    return null;
  }
  
  public final boolean rj()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.f.g
 * JD-Core Version:    0.7.0.1
 */