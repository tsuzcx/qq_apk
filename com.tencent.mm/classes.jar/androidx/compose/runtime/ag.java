package androidx.compose.runtime;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/JoinedKey;", "", "left", "right", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getLeft", "()Ljava/lang/Object;", "getRight", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "hashCodeOf", "value", "toString", "", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ag
{
  private final Object aol;
  private final Object aom;
  
  public ag(Object paramObject1, Object paramObject2)
  {
    this.aol = paramObject1;
    this.aom = paramObject2;
  }
  
  private static int M(Object paramObject)
  {
    AppMethodBeat.i(201853);
    if ((paramObject instanceof Enum))
    {
      i = ((Enum)paramObject).ordinal();
      AppMethodBeat.o(201853);
      return i;
    }
    if (paramObject == null)
    {
      AppMethodBeat.o(201853);
      return 0;
    }
    int i = paramObject.hashCode();
    AppMethodBeat.o(201853);
    return i;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(201871);
    if (this == paramObject)
    {
      AppMethodBeat.o(201871);
      return true;
    }
    if (!(paramObject instanceof ag))
    {
      AppMethodBeat.o(201871);
      return false;
    }
    paramObject = (ag)paramObject;
    if (!s.p(this.aol, paramObject.aol))
    {
      AppMethodBeat.o(201871);
      return false;
    }
    if (!s.p(this.aom, paramObject.aom))
    {
      AppMethodBeat.o(201871);
      return false;
    }
    AppMethodBeat.o(201871);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(201858);
    int i = M(this.aol);
    int j = M(this.aom);
    AppMethodBeat.o(201858);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(201864);
    String str = "JoinedKey(left=" + this.aol + ", right=" + this.aom + ')';
    AppMethodBeat.o(201864);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.compose.runtime.ag
 * JD-Core Version:    0.7.0.1
 */