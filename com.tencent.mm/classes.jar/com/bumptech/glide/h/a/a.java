package com.bumptech.glide.h.a;

import android.support.v4.e.l.a;
import android.support.v4.e.l.b;
import android.support.v4.e.l.c;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class a
{
  private static final a.d<Object> aOh;
  
  static
  {
    AppMethodBeat.i(77794);
    aOh = new a.1();
    AppMethodBeat.o(77794);
  }
  
  public static <T extends c> l.a<T> a(int paramInt, a<T> parama)
  {
    AppMethodBeat.i(77790);
    parama = a(new l.c(paramInt), parama);
    AppMethodBeat.o(77790);
    return parama;
  }
  
  private static <T extends c> l.a<T> a(l.a<T> parama, a<T> parama1)
  {
    AppMethodBeat.i(77792);
    parama = a(parama, parama1, aOh);
    AppMethodBeat.o(77792);
    return parama;
  }
  
  private static <T> l.a<T> a(l.a<T> parama, a<T> parama1, a.d<T> paramd)
  {
    AppMethodBeat.i(77793);
    parama = new b(parama, parama1, paramd);
    AppMethodBeat.o(77793);
    return parama;
  }
  
  public static <T extends c> l.a<T> a(a<T> parama)
  {
    AppMethodBeat.i(77789);
    parama = a(new l.b(150), parama);
    AppMethodBeat.o(77789);
    return parama;
  }
  
  public static <T> l.a<List<T>> qv()
  {
    AppMethodBeat.i(77791);
    l.a locala = a(new l.c(20), new a()new a.3 {}, new a.3());
    AppMethodBeat.o(77791);
    return locala;
  }
  
  public static abstract interface a<T>
  {
    public abstract T oM();
  }
  
  static final class b<T>
    implements l.a<T>
  {
    private final l.a<T> aGr;
    private final a.a<T> aOi;
    private final a.d<T> aOj;
    
    b(l.a<T> parama, a.a<T> parama1, a.d<T> paramd)
    {
      this.aGr = parama;
      this.aOi = parama1;
      this.aOj = paramd;
    }
    
    public final T acquire()
    {
      AppMethodBeat.i(77787);
      Object localObject2 = this.aGr.acquire();
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = this.aOi.oM();
        localObject1 = localObject2;
        if (Log.isLoggable("FactoryPools", 2))
        {
          new StringBuilder("Created new ").append(localObject2.getClass());
          localObject1 = localObject2;
        }
      }
      if ((localObject1 instanceof a.c)) {
        ((a.c)localObject1).oE().aI(false);
      }
      AppMethodBeat.o(77787);
      return localObject1;
    }
    
    public final boolean release(T paramT)
    {
      AppMethodBeat.i(77788);
      if ((paramT instanceof a.c)) {
        ((a.c)paramT).oE().aI(true);
      }
      this.aOj.reset(paramT);
      boolean bool = this.aGr.release(paramT);
      AppMethodBeat.o(77788);
      return bool;
    }
  }
  
  public static abstract interface c
  {
    public abstract b oE();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.h.a.a
 * JD-Core Version:    0.7.0.1
 */