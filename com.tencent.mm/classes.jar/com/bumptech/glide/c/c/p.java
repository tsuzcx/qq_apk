package com.bumptech.glide.c.c;

import android.support.v4.e.l.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class p
{
  private final r aHJ;
  private final p.a aHK;
  
  public p(l.a<List<Throwable>> parama)
  {
    this(new r(parama));
    AppMethodBeat.i(77270);
    AppMethodBeat.o(77270);
  }
  
  private p(r paramr)
  {
    AppMethodBeat.i(77271);
    this.aHK = new p.a();
    this.aHJ = paramr;
    AppMethodBeat.o(77271);
  }
  
  public final <A> List<n<A, ?>> M(A paramA)
  {
    Object localObject2;
    Object localObject1;
    int j;
    int i;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(77273);
        localObject2 = paramA.getClass();
        localObject1 = (a.a)this.aHK.aHL.get(localObject2);
        if (localObject1 == null)
        {
          localObject1 = null;
          if (localObject1 != null) {
            break;
          }
          localObject1 = Collections.unmodifiableList(this.aHJ.r((Class)localObject2));
          if ((a.a)this.aHK.aHL.put(localObject2, new a.a((List)localObject1)) == null) {
            break label203;
          }
          paramA = new IllegalStateException("Already cached loaders for model: ".concat(String.valueOf(localObject2)));
          AppMethodBeat.o(77273);
          throw paramA;
        }
      }
      finally {}
      localObject1 = ((a.a)localObject1).aHM;
      continue;
      j = ((List)localObject1).size();
      localObject2 = new ArrayList(j);
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        n localn = (n)((List)localObject1).get(i);
        if (localn.U(paramA)) {
          ((List)localObject2).add(localn);
        }
      }
      else
      {
        AppMethodBeat.o(77273);
        return localObject2;
        break;
        label203:
        break;
      }
      i += 1;
    }
  }
  
  public final <Model, Data> void b(Class<Model> paramClass, Class<Data> paramClass1, o<? extends Model, ? extends Data> paramo)
  {
    try
    {
      AppMethodBeat.i(77272);
      this.aHJ.b(paramClass, paramClass1, paramo);
      this.aHK.aHL.clear();
      AppMethodBeat.o(77272);
      return;
    }
    finally
    {
      paramClass = finally;
      throw paramClass;
    }
  }
  
  public final List<Class<?>> q(Class<?> paramClass)
  {
    try
    {
      AppMethodBeat.i(77274);
      paramClass = this.aHJ.q(paramClass);
      AppMethodBeat.o(77274);
      return paramClass;
    }
    finally
    {
      paramClass = finally;
      throw paramClass;
    }
  }
  
  static final class a$a<Model>
  {
    final List<n<Model, ?>> aHM;
    
    public a$a(List<n<Model, ?>> paramList)
    {
      this.aHM = paramList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.c.c.p
 * JD-Core Version:    0.7.0.1
 */