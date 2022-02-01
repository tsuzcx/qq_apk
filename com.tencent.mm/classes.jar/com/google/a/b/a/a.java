package com.google.a.b.a;

import com.google.a.b.b;
import com.google.a.f;
import com.google.a.s;
import com.google.a.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;

public final class a<E>
  extends s<Object>
{
  public static final t bEn;
  private final Class<E> bEo;
  private final s<E> bEp;
  
  static
  {
    AppMethodBeat.i(108089);
    bEn = new t()
    {
      public final <T> s<T> a(f paramAnonymousf, com.google.a.c.a<T> paramAnonymousa)
      {
        AppMethodBeat.i(108045);
        paramAnonymousa = paramAnonymousa.bET;
        if ((!(paramAnonymousa instanceof GenericArrayType)) && ((!(paramAnonymousa instanceof Class)) || (!((Class)paramAnonymousa).isArray())))
        {
          AppMethodBeat.o(108045);
          return null;
        }
        paramAnonymousa = b.e(paramAnonymousa);
        paramAnonymousf = new a(paramAnonymousf, paramAnonymousf.a(com.google.a.c.a.h(paramAnonymousa)), b.c(paramAnonymousa));
        AppMethodBeat.o(108045);
        return paramAnonymousf;
      }
    };
    AppMethodBeat.o(108089);
  }
  
  public a(f paramf, s<E> params, Class<E> paramClass)
  {
    AppMethodBeat.i(108087);
    this.bEp = new l(paramf, params, paramClass);
    this.bEo = paramClass;
    AppMethodBeat.o(108087);
  }
  
  public final void a(com.google.a.d.a parama, Object paramObject)
  {
    AppMethodBeat.i(108088);
    if (paramObject == null)
    {
      parama.xv();
      AppMethodBeat.o(108088);
      return;
    }
    parama.xr();
    int i = 0;
    int j = Array.getLength(paramObject);
    while (i < j)
    {
      Object localObject = Array.get(paramObject, i);
      this.bEp.a(parama, localObject);
      i += 1;
    }
    parama.xs();
    AppMethodBeat.o(108088);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.a.b.a.a
 * JD-Core Version:    0.7.0.1
 */