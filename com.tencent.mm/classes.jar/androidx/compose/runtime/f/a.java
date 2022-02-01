package androidx.compose.runtime.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/snapshots/GlobalSnapshot;", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "id", "", "invalid", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "(ILandroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "apply", "Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "dispose", "", "nestedActivated", "", "snapshot", "Landroidx/compose/runtime/snapshots/Snapshot;", "nestedActivated$runtime_release", "nestedDeactivated", "nestedDeactivated$runtime_release", "notifyObjectsInitialized", "notifyObjectsInitialized$runtime_release", "takeNestedMutableSnapshot", "readObserver", "Lkotlin/Function1;", "", "writeObserver", "takeNestedSnapshot", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends c
{
  public a(int paramInt, j paramj) {}
  
  public final c c(b<Object, ah> paramb1, final b<Object, ah> paramb2)
  {
    AppMethodBeat.i(202621);
    paramb1 = (c)l.l((b)new b(paramb1, paramb2));
    AppMethodBeat.o(202621);
    return paramb1;
  }
  
  public final void dispose() {}
  
  public final h h(b<Object, ah> paramb)
  {
    AppMethodBeat.i(202609);
    paramb = l.l((b)new c(paramb));
    AppMethodBeat.o(202609);
    return paramb;
  }
  
  public final void rf()
  {
    AppMethodBeat.i(202628);
    l.rE();
    AppMethodBeat.o(202628);
  }
  
  public final i rg()
  {
    AppMethodBeat.i(202639);
    Throwable localThrowable = (Throwable)new IllegalStateException("Cannot apply the global snapshot directly. Call Snapshot.advanceGlobalSnapshot".toString());
    AppMethodBeat.o(202639);
    throw localThrowable;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "invalid", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<j, c>
  {
    b(b<Object, ah> paramb1, b<Object, ah> paramb2)
    {
      super();
    }
    
    private c a(j paramj)
    {
      AppMethodBeat.i(202449);
      s.u(paramj, "invalid");
      synchronized (l.ry())
      {
        int i = l.rJ();
        l.cu(i + 1);
        paramj = new c(i, paramj, this.asn, paramb2);
        AppMethodBeat.o(202449);
        return paramj;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/runtime/snapshots/ReadonlySnapshot;", "invalid", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements b<j, g>
  {
    c(b<Object, ah> paramb)
    {
      super();
    }
    
    private g b(j paramj)
    {
      AppMethodBeat.i(202448);
      s.u(paramj, "invalid");
      synchronized (l.ry())
      {
        int i = l.rJ();
        l.cu(i + 1);
        paramj = new g(i, paramj, this.asn);
        AppMethodBeat.o(202448);
        return paramj;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.f.a
 * JD-Core Version:    0.7.0.1
 */