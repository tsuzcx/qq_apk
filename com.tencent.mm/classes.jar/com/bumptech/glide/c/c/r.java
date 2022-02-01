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
  private static final c aHR;
  private static final n<Object, Object> aHS;
  private final l.a<List<Throwable>> aAp;
  private final List<b<?, ?>> aHT;
  private final c aHU;
  private final Set<b<?, ?>> aHV;
  
  static
  {
    AppMethodBeat.i(77294);
    aHR = new c();
    aHS = new a();
    AppMethodBeat.o(77294);
  }
  
  public r(l.a<List<Throwable>> parama)
  {
    this(parama, aHR);
  }
  
  private r(l.a<List<Throwable>> parama, c paramc)
  {
    AppMethodBeat.i(77288);
    this.aHT = new ArrayList();
    this.aHV = new HashSet();
    this.aAp = parama;
    this.aHU = paramc;
    AppMethodBeat.o(77288);
  }
  
  private <Model, Data> n<Model, Data> a(b<?, ?> paramb)
  {
    AppMethodBeat.i(77293);
    paramb = (n)i.checkNotNull(paramb.aHX.a(this), "Argument must not be null");
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
          Iterator localIterator = this.aHT.iterator();
          i = 0;
          if (!localIterator.hasNext()) {
            break;
          }
          b localb = (b)localIterator.next();
          if (this.aHV.contains(localb))
          {
            i = 1;
            continue;
          }
          if ((localb.s(paramClass)) && (localb.aEv.isAssignableFrom(paramClass1)))
          {
            j = 1;
            if (j == 0) {
              continue;
            }
            this.aHV.add(localb);
            localArrayList.add(a(localb));
            this.aHV.remove(localb);
            continue;
            paramClass = finally;
          }
        }
        catch (Throwable paramClass)
        {
          this.aHV.clear();
          AppMethodBeat.o(77292);
          throw paramClass;
        }
        int j = 0;
      }
      finally {}
    }
    if (localArrayList.size() > 1)
    {
      paramClass = new q(localArrayList, this.aAp);
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
        paramClass = aHS;
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
      this.aHT.add(this.aHT.size(), paramClass);
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
      Iterator localIterator = this.aHT.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if ((!localArrayList.contains(localb.aEv)) && (localb.s(paramClass))) {
          localArrayList.add(localb.aEv);
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
        Iterator localIterator = this.aHT.iterator();
        while (localIterator.hasNext())
        {
          b localb = (b)localIterator.next();
          if ((!this.aHV.contains(localb)) && (localb.s(paramClass)))
          {
            this.aHV.add(localb);
            localArrayList.add(a(localb));
            this.aHV.remove(localb);
            continue;
            paramClass = finally;
          }
        }
      }
      catch (Throwable paramClass)
      {
        this.aHV.clear();
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
    public final boolean U(Object paramObject)
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
    final Class<Data> aEv;
    private final Class<Model> aHW;
    final o<? extends Model, ? extends Data> aHX;
    
    public b(Class<Model> paramClass, Class<Data> paramClass1, o<? extends Model, ? extends Data> paramo)
    {
      this.aHW = paramClass;
      this.aEv = paramClass1;
      this.aHX = paramo;
    }
    
    public final boolean s(Class<?> paramClass)
    {
      AppMethodBeat.i(77287);
      boolean bool = this.aHW.isAssignableFrom(paramClass);
      AppMethodBeat.o(77287);
      return bool;
    }
  }
  
  static final class c {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.c.c.r
 * JD-Core Version:    0.7.0.1
 */