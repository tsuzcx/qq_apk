package androidx.compose.runtime;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/OpaqueKey;", "", "key", "", "(Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ap
{
  private final String key;
  
  public ap(String paramString)
  {
    AppMethodBeat.i(201872);
    this.key = paramString;
    AppMethodBeat.o(201872);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(201893);
    if (this == paramObject)
    {
      AppMethodBeat.o(201893);
      return true;
    }
    if (!(paramObject instanceof ap))
    {
      AppMethodBeat.o(201893);
      return false;
    }
    paramObject = (ap)paramObject;
    if (!s.p(this.key, paramObject.key))
    {
      AppMethodBeat.o(201893);
      return false;
    }
    AppMethodBeat.o(201893);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(201886);
    int i = this.key.hashCode();
    AppMethodBeat.o(201886);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(201880);
    String str = "OpaqueKey(key=" + this.key + ')';
    AppMethodBeat.o(201880);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.compose.runtime.ap
 * JD-Core Version:    0.7.0.1
 */