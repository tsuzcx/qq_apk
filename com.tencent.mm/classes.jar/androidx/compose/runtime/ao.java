package androidx.compose.runtime;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/NeverEqualPolicy;", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "", "()V", "equivalent", "", "a", "b", "toString", "", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
final class ao
  implements bi<Object>
{
  public static final ao aov;
  
  static
  {
    AppMethodBeat.i(201900);
    aov = new ao();
    AppMethodBeat.o(201900);
  }
  
  public final boolean f(Object paramObject1, Object paramObject2)
  {
    return false;
  }
  
  public final Object py()
  {
    AppMethodBeat.i(201918);
    s.u(this, "this");
    AppMethodBeat.o(201918);
    return null;
  }
  
  public final String toString()
  {
    return "NeverEqualPolicy";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     androidx.compose.runtime.ao
 * JD-Core Version:    0.7.0.1
 */