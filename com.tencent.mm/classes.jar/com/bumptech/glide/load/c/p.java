package com.bumptech.glide.load.c;

import android.support.v4.e.l.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class p
{
  private final r aKi;
  private final a aKj;
  
  public p(l.a<List<Throwable>> parama)
  {
    this(new r(parama));
    AppMethodBeat.i(77270);
    AppMethodBeat.o(77270);
  }
  
  private p(r paramr)
  {
    AppMethodBeat.i(77271);
    this.aKj = new a();
    this.aKi = paramr;
    AppMethodBeat.o(77271);
  }
  
  public final <Model, Data> void b(Class<Model> paramClass, Class<Data> paramClass1, o<? extends Model, ? extends Data> paramo)
  {
    try
    {
      AppMethodBeat.i(77272);
      this.aKi.b(paramClass, paramClass1, paramo);
      this.aKj.aKk.clear();
      AppMethodBeat.o(77272);
      return;
    }
    finally
    {
      paramClass = finally;
      throw paramClass;
    }
  }
  
  public final List<Class<?>> r(Class<?> paramClass)
  {
    try
    {
      AppMethodBeat.i(77274);
      paramClass = this.aKi.r(paramClass);
      AppMethodBeat.o(77274);
      return paramClass;
    }
    finally
    {
      paramClass = finally;
      throw paramClass;
    }
  }
  
  public final <A> List<n<A, ?>> s(Class<A> paramClass)
  {
    Object localObject2;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(204479);
        localObject1 = (p.a.a)this.aKj.aKk.get(paramClass);
        if (localObject1 == null)
        {
          localObject1 = null;
          localObject2 = localObject1;
          if (localObject1 != null) {
            break;
          }
          localObject2 = Collections.unmodifiableList(this.aKi.t(paramClass));
          if ((p.a.a)this.aKj.aKk.put(paramClass, new p.a.a((List)localObject2)) == null) {
            break label121;
          }
          paramClass = new IllegalStateException("Already cached loaders for model: ".concat(String.valueOf(paramClass)));
          AppMethodBeat.o(204479);
          throw paramClass;
        }
      }
      finally {}
      Object localObject1 = ((p.a.a)localObject1).aKl;
    }
    label121:
    for (;;)
    {
      AppMethodBeat.o(204479);
      return localObject2;
    }
  }
  
  static final class a
  {
    final Map<Class<?>, a<?>> aKk;
    
    a()
    {
      AppMethodBeat.i(77269);
      this.aKk = new HashMap();
      AppMethodBeat.o(77269);
    }
    
    static final class a<Model>
    {
      final List<n<Model, ?>> aKl;
      
      public a(List<n<Model, ?>> paramList)
      {
        this.aKl = paramList;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.c.p
 * JD-Core Version:    0.7.0.1
 */