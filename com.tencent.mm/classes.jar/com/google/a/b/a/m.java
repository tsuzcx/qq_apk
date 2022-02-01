package com.google.a.b.a;

import com.google.a.d.c;
import com.google.a.e;
import com.google.a.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

final class m<T>
  extends r<T>
{
  private final r<T> bLl;
  private final e bNd;
  private final Type bNe;
  
  m(e parame, r<T> paramr, Type paramType)
  {
    this.bNd = parame;
    this.bLl = paramr;
    this.bNe = paramType;
  }
  
  public final T a(com.google.a.d.a parama)
  {
    AppMethodBeat.i(222865);
    parama = this.bLl.a(parama);
    AppMethodBeat.o(222865);
    return parama;
  }
  
  public final void a(c paramc, T paramT)
  {
    AppMethodBeat.i(108002);
    r localr = this.bLl;
    Type localType = this.bNe;
    Object localObject = localType;
    if (paramT != null) {
      if ((localType != Object.class) && (!(localType instanceof TypeVariable)))
      {
        localObject = localType;
        if (!(localType instanceof Class)) {}
      }
      else
      {
        localObject = paramT.getClass();
      }
    }
    if (localObject != this.bNe)
    {
      localr = this.bNd.a(com.google.a.c.a.h((Type)localObject));
      localObject = localr;
      if ((localr instanceof i.a))
      {
        localObject = localr;
        if ((this.bLl instanceof i.a)) {}
      }
    }
    for (localObject = this.bLl;; localObject = localr)
    {
      ((r)localObject).a(paramc, paramT);
      AppMethodBeat.o(108002);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.a.b.a.m
 * JD-Core Version:    0.7.0.1
 */