package androidx.compose.runtime;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/ReferentialEqualityPolicy;", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "", "()V", "equivalent", "", "a", "b", "toString", "", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
final class ax
  implements bi<Object>
{
  public static final ax apy;
  
  static
  {
    AppMethodBeat.i(201909);
    apy = new ax();
    AppMethodBeat.o(201909);
  }
  
  public final boolean f(Object paramObject1, Object paramObject2)
  {
    return paramObject1 == paramObject2;
  }
  
  public final Object py()
  {
    AppMethodBeat.i(201927);
    s.u(this, "this");
    AppMethodBeat.o(201927);
    return null;
  }
  
  public final String toString()
  {
    return "ReferentialEqualityPolicy";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     androidx.compose.runtime.ax
 * JD-Core Version:    0.7.0.1
 */