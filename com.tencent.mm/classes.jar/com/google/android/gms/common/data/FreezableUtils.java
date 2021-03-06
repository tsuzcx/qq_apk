package com.google.android.gms.common.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

public final class FreezableUtils
{
  public static <T, E extends Freezable<T>> ArrayList<T> freeze(ArrayList<E> paramArrayList)
  {
    AppMethodBeat.i(11628);
    ArrayList localArrayList = new ArrayList(paramArrayList.size());
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      localArrayList.add(((Freezable)paramArrayList.get(i)).freeze());
      i += 1;
    }
    AppMethodBeat.o(11628);
    return localArrayList;
  }
  
  public static <T, E extends Freezable<T>> ArrayList<T> freeze(E[] paramArrayOfE)
  {
    AppMethodBeat.i(11629);
    ArrayList localArrayList = new ArrayList(paramArrayOfE.length);
    int i = 0;
    while (i < paramArrayOfE.length)
    {
      localArrayList.add(paramArrayOfE[i].freeze());
      i += 1;
    }
    AppMethodBeat.o(11629);
    return localArrayList;
  }
  
  public static <T, E extends Freezable<T>> ArrayList<T> freezeIterable(Iterable<E> paramIterable)
  {
    AppMethodBeat.i(11630);
    ArrayList localArrayList = new ArrayList();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      localArrayList.add(((Freezable)paramIterable.next()).freeze());
    }
    AppMethodBeat.o(11630);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.data.FreezableUtils
 * JD-Core Version:    0.7.0.1
 */