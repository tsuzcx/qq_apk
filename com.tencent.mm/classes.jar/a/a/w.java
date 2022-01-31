package a.a;

import a.f.b.a.a;
import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.util.Map;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/collections/EmptyMap;", "", "", "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "entries", "", "", "getEntries", "()Ljava/util/Set;", "keys", "getKeys", "serialVersionUID", "", "size", "", "getSize", "()I", "values", "", "getValues", "()Ljava/util/Collection;", "containsKey", "", "key", "containsValue", "value", "equals", "other", "get", "hashCode", "isEmpty", "readResolve", "toString", "", "kotlin-stdlib"})
final class w
  implements a, Serializable, Map
{
  public static final w BMy;
  
  static
  {
    AppMethodBeat.i(56150);
    BMy = new w();
    AppMethodBeat.o(56150);
  }
  
  private final Object readResolve()
  {
    return BMy;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(56151);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(56151);
    throw localUnsupportedOperationException;
  }
  
  public final boolean containsKey(Object paramObject)
  {
    return false;
  }
  
  public final boolean containsValue(Object paramObject)
  {
    AppMethodBeat.i(56149);
    if (!(paramObject instanceof Void))
    {
      AppMethodBeat.o(56149);
      return false;
    }
    j.q((Void)paramObject, "value");
    AppMethodBeat.o(56149);
    return false;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(56148);
    if (((paramObject instanceof Map)) && (((Map)paramObject).isEmpty()))
    {
      AppMethodBeat.o(56148);
      return true;
    }
    AppMethodBeat.o(56148);
    return false;
  }
  
  public final int hashCode()
  {
    return 0;
  }
  
  public final boolean isEmpty()
  {
    return true;
  }
  
  public final void putAll(Map paramMap)
  {
    AppMethodBeat.i(56152);
    paramMap = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(56152);
    throw paramMap;
  }
  
  public final Object remove(Object paramObject)
  {
    AppMethodBeat.i(56153);
    paramObject = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(56153);
    throw paramObject;
  }
  
  public final String toString()
  {
    return "{}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.a.w
 * JD-Core Version:    0.7.0.1
 */