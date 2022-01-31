package a.j.b.a.c.n;

import a.a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class a
{
  public static final <K, V> HashMap<K, V> VX(int paramInt)
  {
    AppMethodBeat.i(122916);
    HashMap localHashMap = new HashMap(VZ(paramInt));
    AppMethodBeat.o(122916);
    return localHashMap;
  }
  
  public static final <E> HashSet<E> VY(int paramInt)
  {
    AppMethodBeat.i(122917);
    HashSet localHashSet = new HashSet(VZ(paramInt));
    AppMethodBeat.o(122917);
    return localHashSet;
  }
  
  public static final int VZ(int paramInt)
  {
    if (paramInt < 3) {
      return 3;
    }
    return paramInt / 3 + paramInt + 1;
  }
  
  public static final <T> List<T> av(ArrayList<T> paramArrayList)
  {
    AppMethodBeat.i(122918);
    a.f.b.j.q(paramArrayList, "receiver$0");
    switch (paramArrayList.size())
    {
    default: 
      paramArrayList.trimToSize();
      paramArrayList = (List)paramArrayList;
      AppMethodBeat.o(122918);
      return paramArrayList;
    case 0: 
      paramArrayList = (List)v.BMx;
      AppMethodBeat.o(122918);
      return paramArrayList;
    }
    paramArrayList = a.a.j.listOf(a.a.j.fQ((List)paramArrayList));
    AppMethodBeat.o(122918);
    return paramArrayList;
  }
  
  public static final <T> void b(Collection<T> paramCollection, T paramT)
  {
    AppMethodBeat.i(122915);
    a.f.b.j.q(paramCollection, "receiver$0");
    if (paramT != null) {
      paramCollection.add(paramT);
    }
    AppMethodBeat.o(122915);
  }
  
  public static final <K> Map<K, Integer> y(Iterable<? extends K> paramIterable)
  {
    AppMethodBeat.i(122914);
    a.f.b.j.q(paramIterable, "receiver$0");
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    paramIterable = paramIterable.iterator();
    int i = 0;
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      ((Map)localLinkedHashMap).put(localObject, Integer.valueOf(i));
      i += 1;
    }
    paramIterable = (Map)localLinkedHashMap;
    AppMethodBeat.o(122914);
    return paramIterable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.c.n.a
 * JD-Core Version:    0.7.0.1
 */