package com.bumptech.glide.load.a;

import com.bumptech.glide.g.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class f
{
  private static final e.a<?> aFd;
  private final Map<Class<?>, e.a<?>> aFc;
  
  static
  {
    AppMethodBeat.i(76878);
    aFd = new e.a()
    {
      public final e<Object> T(Object paramAnonymousObject)
      {
        AppMethodBeat.i(76873);
        paramAnonymousObject = new f.a(paramAnonymousObject);
        AppMethodBeat.o(76873);
        return paramAnonymousObject;
      }
      
      public final Class<Object> os()
      {
        AppMethodBeat.i(76874);
        UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Not implemented");
        AppMethodBeat.o(76874);
        throw localUnsupportedOperationException;
      }
    };
    AppMethodBeat.o(76878);
  }
  
  public f()
  {
    AppMethodBeat.i(76875);
    this.aFc = new HashMap();
    AppMethodBeat.o(76875);
  }
  
  public final <T> e<T> T(T paramT)
  {
    try
    {
      AppMethodBeat.i(76877);
      j.checkNotNull(paramT, "Argument must not be null");
      Object localObject2 = (e.a)this.aFc.get(paramT.getClass());
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        Iterator localIterator = this.aFc.values().iterator();
        do
        {
          localObject1 = localObject2;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject1 = (e.a)localIterator.next();
        } while (!((e.a)localObject1).os().isAssignableFrom(paramT.getClass()));
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = aFd;
      }
      paramT = ((e.a)localObject2).T(paramT);
      AppMethodBeat.o(76877);
      return paramT;
    }
    finally {}
  }
  
  public final void b(e.a<?> parama)
  {
    try
    {
      AppMethodBeat.i(76876);
      this.aFc.put(parama.os(), parama);
      AppMethodBeat.o(76876);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  static final class a
    implements e<Object>
  {
    private final Object data;
    
    a(Object paramObject)
    {
      this.data = paramObject;
    }
    
    public final void cleanup() {}
    
    public final Object ov()
    {
      return this.data;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.a.f
 * JD-Core Version:    0.7.0.1
 */