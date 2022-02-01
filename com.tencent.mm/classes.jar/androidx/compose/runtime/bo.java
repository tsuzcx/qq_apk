package androidx.compose.runtime;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/StaticValueHolder;", "T", "Landroidx/compose/runtime/State;", "value", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Landroidx/compose/runtime/StaticValueHolder;", "equals", "", "other", "", "hashCode", "", "toString", "", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bo<T>
  implements bm<T>
{
  private final T value;
  
  public bo(T paramT)
  {
    this.value = paramT;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(201998);
    if (this == paramObject)
    {
      AppMethodBeat.o(201998);
      return true;
    }
    if (!(paramObject instanceof bo))
    {
      AppMethodBeat.o(201998);
      return false;
    }
    paramObject = (bo)paramObject;
    if (!s.p(this.value, paramObject.value))
    {
      AppMethodBeat.o(201998);
      return false;
    }
    AppMethodBeat.o(201998);
    return true;
  }
  
  public final T getValue()
  {
    return this.value;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(201991);
    if (this.value == null)
    {
      AppMethodBeat.o(201991);
      return 0;
    }
    int i = this.value.hashCode();
    AppMethodBeat.o(201991);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(201985);
    String str = "StaticValueHolder(value=" + this.value + ')';
    AppMethodBeat.o(201985);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.compose.runtime.bo
 * JD-Core Version:    0.7.0.1
 */