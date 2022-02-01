package com.bumptech.glide.g.a;

import android.support.v4.e.l.a;
import android.support.v4.e.l.c;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class a
{
  private static final d<Object> aOa;
  
  static
  {
    AppMethodBeat.i(77794);
    aOa = new d()
    {
      public final void reset(Object paramAnonymousObject) {}
    };
    AppMethodBeat.o(77794);
  }
  
  public static <T extends c> l.a<T> a(int paramInt, a<T> parama)
  {
    AppMethodBeat.i(77790);
    parama = a(new l.c(paramInt), parama, aOa);
    AppMethodBeat.o(77790);
    return parama;
  }
  
  private static <T> l.a<T> a(l.a<T> parama, a<T> parama1, d<T> paramd)
  {
    AppMethodBeat.i(77793);
    parama = new b(parama, parama1, paramd);
    AppMethodBeat.o(77793);
    return parama;
  }
  
  public static <T> l.a<List<T>> qy()
  {
    AppMethodBeat.i(77791);
    l.a locala = a(new l.c(20), new a()new d {}, new d() {});
    AppMethodBeat.o(77791);
    return locala;
  }
  
  public static abstract interface a<T>
  {
    public abstract T oR();
  }
  
  static final class b<T>
    implements l.a<T>
  {
    private final l.a<T> aGj;
    private final a.a<T> aOb;
    private final a.d<T> aOc;
    
    b(l.a<T> parama, a.a<T> parama1, a.d<T> paramd)
    {
      this.aGj = parama;
      this.aOb = parama1;
      this.aOc = paramd;
    }
    
    public final T acquire()
    {
      AppMethodBeat.i(77787);
      Object localObject2 = this.aGj.acquire();
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = this.aOb.oR();
        localObject1 = localObject2;
        if (Log.isLoggable("FactoryPools", 2))
        {
          new StringBuilder("Created new ").append(localObject2.getClass());
          localObject1 = localObject2;
        }
      }
      if ((localObject1 instanceof a.c)) {
        ((a.c)localObject1).oK().aH(false);
      }
      AppMethodBeat.o(77787);
      return localObject1;
    }
    
    public final boolean release(T paramT)
    {
      AppMethodBeat.i(77788);
      if ((paramT instanceof a.c)) {
        ((a.c)paramT).oK().aH(true);
      }
      this.aOc.reset(paramT);
      boolean bool = this.aGj.release(paramT);
      AppMethodBeat.o(77788);
      return bool;
    }
  }
  
  public static abstract interface c
  {
    public abstract b oK();
  }
  
  public static abstract interface d<T>
  {
    public abstract void reset(T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.g.a.a
 * JD-Core Version:    0.7.0.1
 */