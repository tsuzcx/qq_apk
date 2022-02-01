package com.google.a.b.a;

import com.google.a.b.c;
import com.google.a.b.i;
import com.google.a.c.a;
import com.google.a.e;
import com.google.a.r;
import com.google.a.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Type;
import java.util.Collection;

public final class b
  implements s
{
  private final c bKQ;
  
  public b(c paramc)
  {
    this.bKQ = paramc;
  }
  
  public final <T> r<T> a(e parame, a<T> parama)
  {
    AppMethodBeat.i(108047);
    Type localType = parama.bNe;
    Class localClass = parama.bOw;
    if (!Collection.class.isAssignableFrom(localClass))
    {
      AppMethodBeat.o(108047);
      return null;
    }
    localType = com.google.a.b.b.a(localType, localClass);
    parame = new a(parame, localType, parame.a(a.h(localType)), this.bKQ.b(parama));
    AppMethodBeat.o(108047);
    return parame;
  }
  
  static final class a<E>
    extends r<Collection<E>>
  {
    private final r<E> bMw;
    private final i<? extends Collection<E>> bMx;
    
    public a(e parame, Type paramType, r<E> paramr, i<? extends Collection<E>> parami)
    {
      AppMethodBeat.i(108076);
      this.bMw = new m(parame, paramr, paramType);
      this.bMx = parami;
      AppMethodBeat.o(108076);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.a.b.a.b
 * JD-Core Version:    0.7.0.1
 */