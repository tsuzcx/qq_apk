package com.google.a.b.a;

import com.google.a.c.a;
import com.google.a.f;
import com.google.a.s;
import com.google.a.t;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class m$24
  implements t
{
  public final <T> s<T> a(f paramf, a<T> parama)
  {
    AppMethodBeat.i(108027);
    parama = parama.bIC;
    if ((!Enum.class.isAssignableFrom(parama)) || (parama == Enum.class))
    {
      AppMethodBeat.o(108027);
      return null;
    }
    paramf = parama;
    if (!parama.isEnum()) {
      paramf = parama.getSuperclass();
    }
    paramf = new m.a(paramf);
    AppMethodBeat.o(108027);
    return paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.a.b.a.m.24
 * JD-Core Version:    0.7.0.1
 */