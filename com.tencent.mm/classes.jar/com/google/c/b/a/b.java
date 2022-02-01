package com.google.c.b.a;

import com.google.c.b.c;
import com.google.c.b.i;
import com.google.c.c.a;
import com.google.c.e;
import com.google.c.r;
import com.google.c.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Type;
import java.util.Collection;

public final class b
  implements s
{
  private final c dEy;
  
  public b(c paramc)
  {
    this.dEy = paramc;
  }
  
  public final <T> r<T> a(e parame, a<T> parama)
  {
    AppMethodBeat.i(108047);
    Type localType = parama.dGJ;
    Class localClass = parama.dIb;
    if (!Collection.class.isAssignableFrom(localClass))
    {
      AppMethodBeat.o(108047);
      return null;
    }
    localType = com.google.c.b.b.a(localType, localClass);
    parame = new a(parame, localType, parame.a(a.h(localType)), this.dEy.b(parama));
    AppMethodBeat.o(108047);
    return parame;
  }
  
  static final class a<E>
    extends r<Collection<E>>
  {
    private final r<E> dGc;
    private final i<? extends Collection<E>> dGd;
    
    public a(e parame, Type paramType, r<E> paramr, i<? extends Collection<E>> parami)
    {
      AppMethodBeat.i(108076);
      this.dGc = new m(parame, paramr, paramType);
      this.dGd = parami;
      AppMethodBeat.o(108076);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.c.b.a.b
 * JD-Core Version:    0.7.0.1
 */