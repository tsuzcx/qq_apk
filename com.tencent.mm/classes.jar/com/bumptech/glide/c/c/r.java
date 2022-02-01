package com.bumptech.glide.c.c;

import android.support.v4.e.l.a;
import com.bumptech.glide.c.j;
import com.bumptech.glide.h.c;
import com.bumptech.glide.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class r
{
  private static final c aKy;
  private static final n<Object, Object> aKz;
  private final l.a<List<Throwable>> aDa;
  private final List<b<?, ?>> aKA;
  private final c aKB;
  private final Set<b<?, ?>> aKC;
  
  static
  {
    AppMethodBeat.i(77294);
    aKy = new c();
    aKz = new a();
    AppMethodBeat.o(77294);
  }
  
  public r(l.a<List<Throwable>> parama)
  {
    this(parama, aKy);
  }
  
  private r(l.a<List<Throwable>> parama, c paramc)
  {
    AppMethodBeat.i(77288);
    this.aKA = new ArrayList();
    this.aKC = new HashSet();
    this.aDa = parama;
    this.aKB = paramc;
    AppMethodBeat.o(77288);
  }
  
  private <Model, Data> n<Model, Data> a(b<?, ?> paramb)
  {
    AppMethodBeat.i(77293);
    paramb = (n)i.checkNotNull(paramb.aKE.a(this), "Argument must not be null");
    AppMethodBeat.o(77293);
    return paramb;
  }
  
  public final <Model, Data> n<Model, Data> b(Class<Model> paramClass, Class<Data> paramClass1)
  {
    ArrayList localArrayList;
    int i;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(77292);
        try
        {
          localArrayList = new ArrayList();
          Iterator localIterator = this.aKA.iterator();
          i = 0;
          if (!localIterator.hasNext()) {
            break;
          }
          b localb = (b)localIterator.next();
          if (this.aKC.contains(localb))
          {
            i = 1;
            continue;
          }
          if ((localb.s(paramClass)) && (localb.aHc.isAssignableFrom(paramClass1)))
          {
            j = 1;
            if (j == 0) {
              continue;
            }
            this.aKC.add(localb);
            localArrayList.add(a(localb));
            this.aKC.remove(localb);
            continue;
            paramClass = finally;
          }
        }
        catch (Throwable paramClass)
        {
          this.aKC.clear();
          AppMethodBeat.o(77292);
          throw paramClass;
        }
        int j = 0;
      }
      finally {}
    }
    if (localArrayList.size() > 1)
    {
      paramClass = new q(localArrayList, this.aDa);
      AppMethodBeat.o(77292);
    }
    for (;;)
    {
      return paramClass;
      if (localArrayList.size() == 1)
      {
        paramClass = (n)localArrayList.get(0);
        AppMethodBeat.o(77292);
      }
      else
      {
        if (i == 0) {
          break;
        }
        paramClass = aKz;
        AppMethodBeat.o(77292);
      }
    }
    paramClass = new h.c(paramClass, paramClass1);
    AppMethodBeat.o(77292);
    throw paramClass;
  }
  
  final <Model, Data> void b(Class<Model> paramClass, Class<Data> paramClass1, o<? extends Model, ? extends Data> paramo)
  {
    try
    {
      AppMethodBeat.i(77289);
      paramClass = new b(paramClass, paramClass1, paramo);
      this.aKA.add(this.aKA.size(), paramClass);
      AppMethodBeat.o(77289);
      return;
    }
    finally
    {
      paramClass = finally;
      throw paramClass;
    }
  }
  
  final List<Class<?>> q(Class<?> paramClass)
  {
    ArrayList localArrayList;
    try
    {
      AppMethodBeat.i(77291);
      localArrayList = new ArrayList();
      Iterator localIterator = this.aKA.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if ((!localArrayList.contains(localb.aHc)) && (localb.s(paramClass))) {
          localArrayList.add(localb.aHc);
        }
      }
      AppMethodBeat.o(77291);
    }
    finally {}
    return localArrayList;
  }
  
  final <Model> List<n<Model, ?>> r(Class<Model> paramClass)
  {
    ArrayList localArrayList;
    try
    {
      AppMethodBeat.i(77290);
      try
      {
        localArrayList = new ArrayList();
        Iterator localIterator = this.aKA.iterator();
        while (localIterator.hasNext())
        {
          b localb = (b)localIterator.next();
          if ((!this.aKC.contains(localb)) && (localb.s(paramClass)))
          {
            this.aKC.add(localb);
            localArrayList.add(a(localb));
            this.aKC.remove(localb);
            continue;
            paramClass = finally;
          }
        }
      }
      catch (Throwable paramClass)
      {
        this.aKC.clear();
        AppMethodBeat.o(77290);
        throw paramClass;
      }
      AppMethodBeat.o(77290);
    }
    finally {}
    return localArrayList;
  }
  
  static final class a
    implements n<Object, Object>
  {
    public final boolean X(Object paramObject)
    {
      return false;
    }
    
    public final n.a<Object> b(Object paramObject, int paramInt1, int paramInt2, j paramj)
    {
      return null;
    }
  }
  
  static final class b<Model, Data>
  {
    final Class<Data> aHc;
    private final Class<Model> aKD;
    final o<? extends Model, ? extends Data> aKE;
    
    public b(Class<Model> paramClass, Class<Data> paramClass1, o<? extends Model, ? extends Data> paramo)
    {
      this.aKD = paramClass;
      this.aHc = paramClass1;
      this.aKE = paramo;
    }
    
    public final boolean s(Class<?> paramClass)
    {
      AppMethodBeat.i(77287);
      boolean bool = this.aKD.isAssignableFrom(paramClass);
      AppMethodBeat.o(77287);
      return bool;
    }
  }
  
  static final class c {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.c.r
 * JD-Core Version:    0.7.0.1
 */