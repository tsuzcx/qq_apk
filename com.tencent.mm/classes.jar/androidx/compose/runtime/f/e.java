package androidx.compose.runtime.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/snapshots/NestedReadonlySnapshot;", "Landroidx/compose/runtime/snapshots/Snapshot;", "id", "", "invalid", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "readObserver", "Lkotlin/Function1;", "", "", "parent", "(ILandroidx/compose/runtime/snapshots/SnapshotIdSet;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/snapshots/Snapshot;)V", "modified", "Ljava/util/HashSet;", "Landroidx/compose/runtime/snapshots/StateObject;", "Lkotlin/collections/HashSet;", "getModified$runtime_release", "()Ljava/util/HashSet;", "getParent", "()Landroidx/compose/runtime/snapshots/Snapshot;", "getReadObserver$runtime_release", "()Lkotlin/jvm/functions/Function1;", "readOnly", "", "getReadOnly", "()Z", "root", "getRoot", "writeObserver", "getWriteObserver$runtime_release", "dispose", "hasPendingChanges", "nestedActivated", "", "snapshot", "nestedActivated$runtime_release", "nestedDeactivated", "nestedDeactivated$runtime_release", "notifyObjectsInitialized", "notifyObjectsInitialized$runtime_release", "recordModified", "state", "recordModified$runtime_release", "takeNestedSnapshot", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends h
{
  private final b<Object, ah> asp;
  private final h asw;
  
  public e(int paramInt, j paramj, b<Object, ah> paramb, h paramh)
  {
    super(paramInt, paramj, (byte)0);
    AppMethodBeat.i(202538);
    this.asw = paramh;
    this.asw.b((h)this);
    if (paramb == null)
    {
      paramj = null;
      paramb = paramj;
      if (paramj == null) {
        paramb = this.asw.rh();
      }
      this.asp = paramb;
      AppMethodBeat.o(202538);
      return;
    }
    paramj = this.asw.rh();
    if (paramj == null) {}
    for (;;)
    {
      paramj = paramb;
      break;
      paramb = (b)new e.a(paramb, paramj);
    }
  }
  
  public final void a(aa paramaa)
  {
    AppMethodBeat.i(202587);
    s.u(paramaa, "state");
    this.asw.a(paramaa);
    AppMethodBeat.o(202587);
  }
  
  public final void dispose()
  {
    AppMethodBeat.i(202572);
    if (!rs())
    {
      if (getId() != this.asw.getId()) {
        rk();
      }
      this.asw.a((h)this);
      super.dispose();
    }
    AppMethodBeat.o(202572);
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
 * Qualified Name:     androidx.compose.runtime.f.e
 * JD-Core Version:    0.7.0.1
 */