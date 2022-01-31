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
  private final Set<Class<?>> beQ;
  private final Set<Class<?>> beR;
  private final b beS;
  
  public s(Iterable<f> paramIterable, b paramb)
  {
    AppMethodBeat.i(10632);
    HashSet localHashSet1 = new HashSet();
    HashSet localHashSet2 = new HashSet();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      f localf = (f)paramIterable.next();
      if (localf.rJ()) {
        localHashSet1.add(localf.beA);
      } else {
        localHashSet2.add(localf.beA);
      }
    }
    this.beQ = Collections.unmodifiableSet(localHashSet1);
    this.beR = Collections.unmodifiableSet(localHashSet2);
    this.beS = paramb;
    AppMethodBeat.o(10632);
  }
  
  public final <T> T m(Class<T> paramClass)
  {
    AppMethodBeat.i(10633);
    if (!this.beQ.contains(paramClass))
    {
      paramClass = new IllegalArgumentException(String.format("Requesting %s is not allowed.", new Object[] { paramClass }));
      AppMethodBeat.o(10633);
      throw paramClass;
    }
    paramClass = this.beS.m(paramClass);
    AppMethodBeat.o(10633);
    return paramClass;
  }
  
  public final <T> a<T> o(Class<T> paramClass)
  {
    AppMethodBeat.i(10634);
    if (!this.beR.contains(paramClass))
    {
      paramClass = new IllegalArgumentException(String.format("Requesting Provider<%s> is not allowed.", new Object[] { paramClass }));
      AppMethodBeat.o(10634);
      throw paramClass;
    }
    paramClass = this.beS.o(paramClass);
    AppMethodBeat.o(10634);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.firebase.components.s
 * JD-Core Version:    0.7.0.1
 */