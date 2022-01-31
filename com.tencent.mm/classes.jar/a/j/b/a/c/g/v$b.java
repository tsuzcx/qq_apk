package a.j.b.a.c.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map.Entry;

final class v$b
  implements Comparable<v<K, V>.b>, Map.Entry<K, V>
{
  final K Cst;
  private V value;
  
  v$b(K paramK, V paramV)
  {
    this.Cst = paramV;
    Object localObject;
    this.value = localObject;
  }
  
  v$b(Map.Entry<K, V> paramEntry)
  {
    this(paramEntry, (Comparable)localObject.getKey(), localObject.getValue());
    AppMethodBeat.i(121626);
    AppMethodBeat.o(121626);
  }
  
  private static boolean equals(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(121631);
    if (paramObject1 == null)
    {
      if (paramObject2 == null)
      {
        AppMethodBeat.o(121631);
        return true;
      }
      AppMethodBeat.o(121631);
      return false;
    }
    boolean bool = paramObject1.equals(paramObject2);
    AppMethodBeat.o(121631);
    return bool;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(121628);
    if (paramObject == this)
    {
      AppMethodBeat.o(121628);
      return true;
    }
    if (!(paramObject instanceof Map.Entry))
    {
      AppMethodBeat.o(121628);
      return false;
    }
    paramObject = (Map.Entry)paramObject;
    if ((equals(this.Cst, paramObject.getKey())) && (equals(this.value, paramObject.getValue())))
    {
      AppMethodBeat.o(121628);
      return true;
    }
    AppMethodBeat.o(121628);
    return false;
  }
  
  public final V getValue()
  {
    return this.value;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(121629);
    int i;
    if (this.Cst == null)
    {
      i = 0;
      if (this.value != null) {
        break label43;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(121629);
      return i ^ j;
      i = this.Cst.hashCode();
      break;
      label43:
      j = this.value.hashCode();
    }
  }
  
  public final V setValue(V paramV)
  {
    AppMethodBeat.i(121627);
    v.a(this.Csu);
    Object localObject = this.value;
    this.value = paramV;
    AppMethodBeat.o(121627);
    return localObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(121630);
    String str1 = String.valueOf(String.valueOf(this.Cst));
    String str2 = String.valueOf(String.valueOf(this.value));
    str1 = str1.length() + 1 + str2.length() + str1 + "=" + str2;
    AppMethodBeat.o(121630);
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.g.v.b
 * JD-Core Version:    0.7.0.1
 */