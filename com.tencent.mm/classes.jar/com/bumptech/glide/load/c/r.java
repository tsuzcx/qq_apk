package com.bumptech.glide.load.c;

import android.support.v4.e.l.a;
import com.bumptech.glide.g.j;
import com.bumptech.glide.h.c;
import com.bumptech.glide.load.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class r
{
  private static final c aKq;
  private static final n<Object, Object> aKr;
  private final l.a<List<Throwable>> aDa;
  private final List<b<?, ?>> aKs;
  private final c aKt;
  private final Set<b<?, ?>> aKu;
  
  static
  {
    AppMethodBeat.i(77294);
    aKq = new c();
    aKr = new a();
    AppMethodBeat.o(77294);
  }
  
  public r(l.a<List<Throwable>> parama)
  {
    this(parama, aKq);
  }
  
  private r(l.a<List<Throwable>> parama, c paramc)
  {
    AppMethodBeat.i(77288);
    this.aKs = new ArrayList();
    this.aKu = new HashSet();
    this.aDa = parama;
    this.aKt = paramc;
    AppMethodBeat.o(77288);
  }
  
  private <Model, Data> n<Model, Data> a(b<?, ?> paramb)
  {
    AppMethodBeat.i(77293);
    paramb = (n)j.checkNotNull(paramb.aKw.a(this), "Argument must not be null");
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
          Iterator localIterator = this.aKs.iterator();
          i = 0;
          if (!localIterator.hasNext()) {
            break;
          }
          b localb = (b)localIterator.next();
          if (this.aKu.contains(localb))
          {
            i = 1;
            continue;
          }
          if ((localb.u(paramClass)) && (localb.aGU.isAssignableFrom(paramClass1)))
          {
            j = 1;
            if (j == 0) {
              continue;
            }
            this.aKu.add(localb);
            localArrayList.add(a(localb));
            this.aKu.remove(localb);
            continue;
            paramClass = finally;
          }
        }
        catch (Throwable paramClass)
        {
          this.aKu.clear();
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
        paramClass = aKr;
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
      this.aKs.add(this.aKs.size(), paramClass);
      AppMethodBeat.o(77289);
      return;
    }
    finally
    {
      paramClass = finally;
      throw paramClass;
    }
  }
  
  final List<Class<?>> r(Class<?> paramClass)
  {
    ArrayList localArrayList;
    try
    {
      AppMethodBeat.i(77291);
      localArrayList = new ArrayList();
      Iterator localIterator = this.aKs.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if ((!localArrayList.contains(localb.aGU)) && (localb.u(paramClass))) {
          localArrayList.add(localb.aGU);
        }
      }
      AppMethodBeat.o(77291);
    }
    finally {}
    return localArrayList;
  }
  
  final <Model> List<n<Model, ?>> t(Class<Model> paramClass)
  {
    ArrayList localArrayList;
    try
    {
      AppMethodBeat.i(77290);
      try
      {
        localArrayList = new ArrayList();
        Iterator localIterator = this.aKs.iterator();
        while (localIterator.hasNext())
        {
          b localb = (b)localIterator.next();
          if ((!this.aKu.contains(localb)) && (localb.u(paramClass)))
          {
            this.aKu.add(localb);
            localArrayList.add(a(localb));
            this.aKu.remove(localb);
            continue;
            paramClass = finally;
          }
        }
      }
      catch (Throwable paramClass)
      {
        this.aKu.clear();
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
    
    public final n.a<Object> b(Object paramObject, int paramInt1, int paramInt2, i parami)
    {
      return null;
    }
  }
  
  static final class b<Model, Data>
  {
    final Class<Data> aGU;
    private final Class<Model> aKv;
    final o<? extends Model, ? extends Data> aKw;
    
    public b(Class<Model> paramClass, Class<Data> paramClass1, o<? extends Model, ? extends Data> paramo)
    {
      this.aKv = paramClass;
      this.aGU = paramClass1;
      this.aKw = paramo;
    }
    
    public final boolean u(Class<?> paramClass)
    {
      AppMethodBeat.i(77287);
      boolean bool = this.aKv.isAssignableFrom(paramClass);
      AppMethodBeat.o(77287);
      return bool;
    }
  }
  
  static final class c {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.c.r
 * JD-Core Version:    0.7.0.1
 */