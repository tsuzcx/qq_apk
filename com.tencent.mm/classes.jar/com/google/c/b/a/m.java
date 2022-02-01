package com.google.c.b.a;

import com.google.c.d.c;
import com.google.c.e;
import com.google.c.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

final class m<T>
  extends r<T>
{
  private final r<T> dET;
  private final e dGI;
  private final Type dGJ;
  
  m(e parame, r<T> paramr, Type paramType)
  {
    this.dGI = parame;
    this.dET = paramr;
    this.dGJ = paramType;
  }
  
  public final T a(com.google.c.d.a parama)
  {
    AppMethodBeat.i(208893);
    parama = this.dET.a(parama);
    AppMethodBeat.o(208893);
    return parama;
  }
  
  public final void a(c paramc, T paramT)
  {
    AppMethodBeat.i(108002);
    r localr = this.dET;
    Type localType = this.dGJ;
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
    if (localObject != this.dGJ)
    {
      localr = this.dGI.a(com.google.c.c.a.h((Type)localObject));
      localObject = localr;
      if ((localr instanceof i.a))
      {
        localObject = localr;
        if ((this.dET instanceof i.a)) {}
      }
    }
    for (localObject = this.dET;; localObject = localr)
    {
      ((r)localObject).a(paramc, paramT);
      AppMethodBeat.o(108002);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.c.b.a.m
 * JD-Core Version:    0.7.0.1
 */