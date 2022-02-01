package androidx.compose.runtime.b.a.a.a.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.g.b.a.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/MapEntry;", "K", "V", "", "key", "value", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getValue", "equals", "", "other", "", "hashCode", "", "toString", "", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public class b<K, V>
  implements Map.Entry<K, V>, a
{
  private final K key;
  private final V value;
  
  public b(K paramK, V paramV)
  {
    this.key = paramK;
    this.value = paramV;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(202811);
    if ((paramObject instanceof Map.Entry)) {}
    for (paramObject = (Map.Entry)paramObject; paramObject == null; paramObject = null)
    {
      AppMethodBeat.o(202811);
      return false;
    }
    if ((s.p(paramObject.getKey(), getKey())) && (s.p(paramObject.getValue(), getValue())))
    {
      AppMethodBeat.o(202811);
      return true;
    }
    AppMethodBeat.o(202811);
    return false;
  }
  
  public K getKey()
  {
    return this.key;
  }
  
  public V getValue()
  {
    return this.value;
  }
  
  public int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(202804);
    Object localObject = getKey();
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = getValue();
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(202804);
      return i ^ j;
    }
  }
  
  public V setValue(V paramV)
  {
    AppMethodBeat.i(202827);
    paramV = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(202827);
    throw paramV;
  }
  
  public String toString()
  {
    AppMethodBeat.i(202818);
    String str = getKey() + '=' + getValue();
    AppMethodBeat.o(202818);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.compose.runtime.b.a.a.a.a.b.b
 * JD-Core Version:    0.7.0.1
 */