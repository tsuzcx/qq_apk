package androidx.compose.runtime;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/StructuralEqualityPolicy;", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "", "()V", "equivalent", "", "a", "b", "toString", "", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
final class bp
  implements bi<Object>
{
  public static final bp aqi;
  
  static
  {
    AppMethodBeat.i(201972);
    aqi = new bp();
    AppMethodBeat.o(201972);
  }
  
  public final boolean f(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(201975);
    boolean bool = s.p(paramObject1, paramObject2);
    AppMethodBeat.o(201975);
    return bool;
  }
  
  public final Object py()
  {
    AppMethodBeat.i(201979);
    s.u(this, "this");
    AppMethodBeat.o(201979);
    return null;
  }
  
  public final String toString()
  {
    return "StructuralEqualityPolicy";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     androidx.compose.runtime.bp
 * JD-Core Version:    0.7.0.1
 */