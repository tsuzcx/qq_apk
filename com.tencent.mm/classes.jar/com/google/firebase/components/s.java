package com.google.firebase.components;

import com.google.firebase.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class s
  implements b
{
  private final Set<Class<?>> dCp;
  private final Set<Class<?>> dCq;
  private final b dCr;
  
  public s(Iterable<f> paramIterable, b paramb)
  {
    AppMethodBeat.i(4099);
    HashSet localHashSet1 = new HashSet();
    HashSet localHashSet2 = new HashSet();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      f localf = (f)paramIterable.next();
      if (localf.Yf()) {
        localHashSet1.add(localf.dBZ);
      } else {
        localHashSet2.add(localf.dBZ);
      }
    }
    this.dCp = Collections.unmodifiableSet(localHashSet1);
    this.dCq = Collections.unmodifiableSet(localHashSet2);
    this.dCr = paramb;
    AppMethodBeat.o(4099);
  }
  
  public final <T> T v(Class<T> paramClass)
  {
    AppMethodBeat.i(4100);
    if (!this.dCp.contains(paramClass))
    {
      paramClass = new IllegalArgumentException(String.format("Requesting %s is not allowed.", new Object[] { paramClass }));
      AppMethodBeat.o(4100);
      throw paramClass;
    }
    paramClass = this.dCr.v(paramClass);
    AppMethodBeat.o(4100);
    return paramClass;
  }
  
  public final <T> a<T> x(Class<T> paramClass)
  {
    AppMethodBeat.i(4101);
    if (!this.dCq.contains(paramClass))
    {
      paramClass = new IllegalArgumentException(String.format("Requesting Provider<%s> is not allowed.", new Object[] { paramClass }));
      AppMethodBeat.o(4101);
      throw paramClass;
    }
    paramClass = this.dCr.x(paramClass);
    AppMethodBeat.o(4101);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.firebase.components.s
 * JD-Core Version:    0.7.0.1
 */