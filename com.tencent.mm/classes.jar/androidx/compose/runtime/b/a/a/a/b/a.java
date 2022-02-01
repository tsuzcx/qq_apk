package androidx.compose.runtime.b.a.a.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/DeltaCounter;", "", "count", "", "(I)V", "getCount", "()I", "setCount", "component1", "copy", "equals", "", "other", "hashCode", "plusAssign", "", "that", "toString", "", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public int count = 0;
  
  public final void co(int paramInt)
  {
    this.count += paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof a)) {
        return false;
      }
      paramObject = (a)paramObject;
    } while (this.count == paramObject.count);
    return false;
  }
  
  public final int hashCode()
  {
    return this.count;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(202733);
    String str = "DeltaCounter(count=" + this.count + ')';
    AppMethodBeat.o(202733);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.compose.runtime.b.a.a.a.b.a
 * JD-Core Version:    0.7.0.1
 */