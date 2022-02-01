package androidx.compose.runtime.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "", "()V", "succeeded", "", "getSucceeded", "()Z", "check", "", "Failure", "Success", "Landroidx/compose/runtime/snapshots/SnapshotApplyResult$Success;", "Landroidx/compose/runtime/snapshots/SnapshotApplyResult$Failure;", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class i
{
  @Metadata(d1={""}, d2={"Landroidx/compose/runtime/snapshots/SnapshotApplyResult$Failure;", "Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "snapshot", "Landroidx/compose/runtime/snapshots/Snapshot;", "(Landroidx/compose/runtime/snapshots/Snapshot;)V", "getSnapshot", "()Landroidx/compose/runtime/snapshots/Snapshot;", "succeeded", "", "getSucceeded", "()Z", "check", "", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends i
  {
    public static final int Ue = 8;
    private final h amf;
    
    public a(h paramh)
    {
      super();
      AppMethodBeat.i(202447);
      this.amf = paramh;
      AppMethodBeat.o(202447);
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/runtime/snapshots/SnapshotApplyResult$Success;", "Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "()V", "succeeded", "", "getSucceeded", "()Z", "check", "", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends i
  {
    public static final b asB;
    
    static
    {
      AppMethodBeat.i(202441);
      asB = new b();
      AppMethodBeat.o(202441);
    }
    
    private b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.f.i
 * JD-Core Version:    0.7.0.1
 */