package com.google.android.gms.common.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

public final class FreezableUtils
{
  public static <T, E extends Freezable<T>> ArrayList<T> freeze(ArrayList<E> paramArrayList)
  {
    AppMethodBeat.i(61136);
    ArrayList localArrayList = new ArrayList(paramArrayList.size());
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      localArrayList.add(((Freezable)paramArrayList.get(i)).freeze());
      i += 1;
    }
    AppMethodBeat.o(61136);
    return localArrayList;
  }
  
  public static <T, E extends Freezable<T>> ArrayList<T> freeze(E[] paramArrayOfE)
  {
    AppMethodBeat.i(61137);
    ArrayList localArrayList = new ArrayList(paramArrayOfE.length);
    int i = 0;
    while (i < paramArrayOfE.length)
    {
      localArrayList.add(paramArrayOfE[i].freeze());
      i += 1;
    }
    AppMethodBeat.o(61137);
    return localArrayList;
  }
  
  public static <T, E extends Freezable<T>> ArrayList<T> freezeIterable(Iterable<E> paramIterable)
  {
    AppMethodBeat.i(61138);
    ArrayList localArrayList = new ArrayList();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      localArrayList.add(((Freezable)paramIterable.next()).freeze());
    }
    AppMethodBeat.o(61138);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.common.data.FreezableUtils
 * JD-Core Version:    0.7.0.1
 */