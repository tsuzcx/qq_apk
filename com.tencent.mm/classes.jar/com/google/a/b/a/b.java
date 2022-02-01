package com.google.a.b.a;

import com.google.a.b.c;
import com.google.a.b.h;
import com.google.a.c.a;
import com.google.a.f;
import com.google.a.s;
import com.google.a.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Type;
import java.util.Collection;

public final class b
  implements t
{
  private final c bMX;
  
  public b(c paramc)
  {
    this.bMX = paramc;
  }
  
  public final <T> s<T> a(f paramf, a<T> parama)
  {
    AppMethodBeat.i(108047);
    Type localType = parama.bPh;
    Class localClass = parama.bQy;
    if (!Collection.class.isAssignableFrom(localClass))
    {
      AppMethodBeat.o(108047);
      return null;
    }
    localType = com.google.a.b.b.a(localType, localClass);
    paramf = new a(paramf, localType, paramf.a(a.h(localType)), this.bMX.b(parama));
    AppMethodBeat.o(108047);
    return paramf;
  }
  
  static final class a<E>
    extends s<Collection<E>>
  {
    private final s<E> bOE;
    private final h<? extends Collection<E>> bOF;
    
    public a(f paramf, Type paramType, s<E> params, h<? extends Collection<E>> paramh)
    {
      AppMethodBeat.i(108076);
      this.bOE = new l(paramf, params, paramType);
      this.bOF = paramh;
      AppMethodBeat.o(108076);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.a.b.a.b
 * JD-Core Version:    0.7.0.1
 */