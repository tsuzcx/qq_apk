package com.google.android.gms.common.collect;

import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Sets
{
  public static <E> Set<E> difference(Set<? extends E> paramSet1, Set<? extends E> paramSet2)
  {
    AppMethodBeat.i(4541);
    Preconditions.checkNotNull(paramSet1);
    Preconditions.checkNotNull(paramSet2);
    HashSet localHashSet = new HashSet();
    paramSet1 = paramSet1.iterator();
    while (paramSet1.hasNext())
    {
      Object localObject = paramSet1.next();
      if (!paramSet2.contains(localObject)) {
        localHashSet.add(localObject);
      }
    }
    AppMethodBeat.o(4541);
    return localHashSet;
  }
  
  public static <E> Set<E> union(Iterable<Set<E>> paramIterable)
  {
    AppMethodBeat.i(4540);
    Preconditions.checkNotNull(paramIterable);
    HashSet localHashSet = new HashSet();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      localHashSet.addAll((Set)paramIterable.next());
    }
    AppMethodBeat.o(4540);
    return localHashSet;
  }
  
  public static <E> Set<E> union(Set<? extends E> paramSet1, Set<? extends E> paramSet2)
  {
    AppMethodBeat.i(4539);
    Preconditions.checkNotNull(paramSet1);
    Preconditions.checkNotNull(paramSet2);
    paramSet1 = new HashSet(paramSet1);
    paramSet1.addAll(paramSet2);
    AppMethodBeat.o(4539);
    return paramSet1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.collect.Sets
 * JD-Core Version:    0.7.0.1
 */