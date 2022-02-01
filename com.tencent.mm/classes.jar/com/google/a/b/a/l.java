package com.google.a.b.a;

import com.google.a.f;
import com.google.a.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

final class l<T>
  extends s<T>
{
  private final s<T> bNs;
  private final f bPg;
  private final Type bPh;
  
  l(f paramf, s<T> params, Type paramType)
  {
    this.bPg = paramf;
    this.bNs = params;
    this.bPh = paramType;
  }
  
  public final void a(com.google.a.d.a parama, T paramT)
  {
    AppMethodBeat.i(108002);
    s locals = this.bNs;
    Type localType = this.bPh;
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
    if (localObject != this.bPh)
    {
      locals = this.bPg.a(com.google.a.c.a.h((Type)localObject));
      localObject = locals;
      if ((locals instanceof h.a))
      {
        localObject = locals;
        if ((this.bNs instanceof h.a)) {}
      }
    }
    for (localObject = this.bNs;; localObject = locals)
    {
      ((s)localObject).a(parama, paramT);
      AppMethodBeat.o(108002);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.a.b.a.l
 * JD-Core Version:    0.7.0.1
 */