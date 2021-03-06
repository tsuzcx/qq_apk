package com.google.firebase.components;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class n
  implements b
{
  private final List<a<?>> dCf;
  private final Map<Class<?>, p<?>> dCg;
  
  public n(Iterable<e> paramIterable, a<?>... paramVarArgs)
  {
    AppMethodBeat.i(4086);
    this.dCg = new HashMap();
    Object localObject1 = new ArrayList();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      ((List)localObject1).addAll(((e)paramIterable.next()).getComponents());
    }
    Collections.addAll((Collection)localObject1, paramVarArgs);
    paramIterable = new HashMap(((List)localObject1).size());
    Object localObject3;
    Object localObject4;
    do
    {
      paramVarArgs = ((List)localObject1).iterator();
      while (!((Iterator)localObject3).hasNext())
      {
        if (!paramVarArgs.hasNext()) {
          break;
        }
        localObject3 = (a)paramVarArgs.next();
        localObject2 = new o((a)localObject3);
        localObject3 = ((a)localObject3).dBW.iterator();
      }
      localObject4 = (Class)((Iterator)localObject3).next();
    } while (paramIterable.put(localObject4, localObject2) == null);
    paramIterable = new IllegalArgumentException(String.format("Multiple components provide %s.", new Object[] { localObject4 }));
    AppMethodBeat.o(4086);
    throw paramIterable;
    paramVarArgs = paramIterable.values().iterator();
    while (paramVarArgs.hasNext())
    {
      localObject2 = (o)paramVarArgs.next();
      localObject3 = ((o)localObject2).dCh.dBX.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (f)((Iterator)localObject3).next();
        if (((f)localObject4).Yf())
        {
          localObject4 = (o)paramIterable.get(((f)localObject4).dBZ);
          if (localObject4 != null)
          {
            ((o)localObject2).dCi.add(localObject4);
            ((o)localObject4).dCj.add(localObject2);
          }
        }
      }
    }
    paramIterable = new HashSet(paramIterable.values());
    paramVarArgs = new HashSet();
    Object localObject2 = paramIterable.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (o)((Iterator)localObject2).next();
      if (((o)localObject3).Yg()) {
        paramVarArgs.add(localObject3);
      }
    }
    localObject2 = new ArrayList();
    while (!paramVarArgs.isEmpty())
    {
      localObject3 = (o)paramVarArgs.iterator().next();
      paramVarArgs.remove(localObject3);
      ((List)localObject2).add(((o)localObject3).dCh);
      localObject4 = ((o)localObject3).dCi.iterator();
      while (((Iterator)localObject4).hasNext())
      {
        o localo = (o)((Iterator)localObject4).next();
        localo.dCj.remove(localObject3);
        if (localo.Yg()) {
          paramVarArgs.add(localo);
        }
      }
    }
    if (((List)localObject2).size() == ((List)localObject1).size())
    {
      Collections.reverse((List)localObject2);
      this.dCf = Collections.unmodifiableList((List)localObject2);
      paramIterable = this.dCf.iterator();
      while (paramIterable.hasNext())
      {
        localObject1 = (a)paramIterable.next();
        paramVarArgs = new p(((a)localObject1).dBY, new s(((a)localObject1).dBX, this));
        localObject1 = ((a)localObject1).dBW.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Class)((Iterator)localObject1).next();
          this.dCg.put(localObject2, paramVarArgs);
        }
      }
    }
    paramVarArgs = new ArrayList();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      localObject1 = (o)paramIterable.next();
      if ((!((o)localObject1).Yg()) && (!((o)localObject1).dCi.isEmpty())) {
        paramVarArgs.add(((o)localObject1).dCh);
      }
    }
    paramIterable = new g(paramVarArgs);
    AppMethodBeat.o(4086);
    throw paramIterable;
    paramIterable = this.dCf.iterator();
    if (paramIterable.hasNext())
    {
      paramVarArgs = (a)paramIterable.next();
      localObject1 = paramVarArgs.dBX.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (f)((Iterator)localObject1).next();
        if (((f)localObject2).dCa == 1) {}
        for (int i = 1; (i != 0) && (!this.dCg.containsKey(((f)localObject2).dBZ)); i = 0)
        {
          paramIterable = new i(String.format("Unsatisfied dependency for component %s: %s", new Object[] { paramVarArgs, ((f)localObject2).dBZ }));
          AppMethodBeat.o(4086);
          throw paramIterable;
        }
      }
    }
    AppMethodBeat.o(4086);
  }
  
  public final void bU(boolean paramBoolean)
  {
    AppMethodBeat.i(4088);
    Iterator localIterator = this.dCf.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if ((locala.Yc()) || ((locala.Yd()) && (paramBoolean))) {
        c.a(this, (Class)locala.dBW.iterator().next());
      }
    }
    AppMethodBeat.o(4088);
  }
  
  public final Object v(Class paramClass)
  {
    AppMethodBeat.i(4089);
    paramClass = c.a(this, paramClass);
    AppMethodBeat.o(4089);
    return paramClass;
  }
  
  public final <T> com.google.firebase.a.a<T> x(Class<T> paramClass)
  {
    AppMethodBeat.i(4087);
    r.zza(paramClass, "Null interface requested.");
    paramClass = (com.google.firebase.a.a)this.dCg.get(paramClass);
    AppMethodBeat.o(4087);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.firebase.components.n
 * JD-Core Version:    0.7.0.1
 */