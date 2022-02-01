package androidx.compose.runtime;

import androidx.compose.runtime.f.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"DefaultMonotonicFrameClock", "Landroidx/compose/runtime/MonotonicFrameClock;", "getDefaultMonotonicFrameClock$annotations", "()V", "getDefaultMonotonicFrameClock", "()Landroidx/compose/runtime/MonotonicFrameClock;", "DefaultMonotonicFrameClock$delegate", "Lkotlin/Lazy;", "DisallowDefaultMonotonicFrameClock", "", "createSnapshotMutableState", "Landroidx/compose/runtime/snapshots/SnapshotMutableState;", "T", "value", "policy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "(Ljava/lang/Object;Landroidx/compose/runtime/SnapshotMutationPolicy;)Landroidx/compose/runtime/snapshots/SnapshotMutableState;", "CheckResult", "Landroidx/annotation/CheckResult;", "runtime_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class b
{
  private static final j alp;
  
  static
  {
    AppMethodBeat.i(202319);
    alp = k.cm((a)a.alq);
    AppMethodBeat.o(202319);
  }
  
  public static final <T> q<T> a(T paramT, bi<T> parambi)
  {
    AppMethodBeat.i(202310);
    s.u(parambi, "policy");
    paramT = (q)new ParcelableSnapshotMutableState(paramT, parambi);
    AppMethodBeat.o(202310);
    return paramT;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/runtime/MonotonicFrameClock;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<al>
  {
    public static final a alq;
    
    static
    {
      AppMethodBeat.i(202432);
      alq = new a();
      AppMethodBeat.o(202432);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.b
 * JD-Core Version:    0.7.0.1
 */