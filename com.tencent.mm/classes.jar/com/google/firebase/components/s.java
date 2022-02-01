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
  private final Set<Class<?>> bKM;
  private final Set<Class<?>> bKN;
  private final b bKO;
  
  public s(Iterable<f> paramIterable, b paramb)
  {
    AppMethodBeat.i(4099);
    HashSet localHashSet1 = new HashSet();
    HashSet localHashSet2 = new HashSet();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      f localf = (f)paramIterable.next();
      if (localf.xS()) {
        localHashSet1.add(localf.bKw);
      } else {
        localHashSet2.add(localf.bKw);
      }
    }
    this.bKM = Collections.unmodifiableSet(localHashSet1);
    this.bKN = Collections.unmodifiableSet(localHashSet2);
    this.bKO = paramb;
    AppMethodBeat.o(4099);
  }
  
  public final <T> T w(Class<T> paramClass)
  {
    AppMethodBeat.i(4100);
    if (!this.bKM.contains(paramClass))
    {
      paramClass = new IllegalArgumentException(String.format("Requesting %s is not allowed.", new Object[] { paramClass }));
      AppMethodBeat.o(4100);
      throw paramClass;
    }
    paramClass = this.bKO.w(paramClass);
    AppMethodBeat.o(4100);
    return paramClass;
  }
  
  public final <T> a<T> y(Class<T> paramClass)
  {
    AppMethodBeat.i(4101);
    if (!this.bKN.contains(paramClass))
    {
      paramClass = new IllegalArgumentException(String.format("Requesting Provider<%s> is not allowed.", new Object[] { paramClass }));
      AppMethodBeat.o(4101);
      throw paramClass;
    }
    paramClass = this.bKO.y(paramClass);
    AppMethodBeat.o(4101);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.firebase.components.s
 * JD-Core Version:    0.7.0.1
 */