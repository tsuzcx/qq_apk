package com.google.a.b.a;

import com.google.a.d.c;
import com.google.a.e;
import com.google.a.r;
import com.google.a.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.List;

public final class a<E>
  extends r<Object>
{
  public static final s bMt;
  private final Class<E> bMu;
  private final r<E> bMv;
  
  static
  {
    AppMethodBeat.i(108089);
    bMt = new s()
    {
      public final <T> r<T> a(e paramAnonymouse, com.google.a.c.a<T> paramAnonymousa)
      {
        AppMethodBeat.i(108045);
        paramAnonymousa = paramAnonymousa.bNe;
        if ((!(paramAnonymousa instanceof GenericArrayType)) && ((!(paramAnonymousa instanceof Class)) || (!((Class)paramAnonymousa).isArray())))
        {
          AppMethodBeat.o(108045);
          return null;
        }
        paramAnonymousa = com.google.a.b.b.e(paramAnonymousa);
        paramAnonymouse = new a(paramAnonymouse, paramAnonymouse.a(com.google.a.c.a.h(paramAnonymousa)), com.google.a.b.b.c(paramAnonymousa));
        AppMethodBeat.o(108045);
        return paramAnonymouse;
      }
    };
    AppMethodBeat.o(108089);
  }
  
  public a(e parame, r<E> paramr, Class<E> paramClass)
  {
    AppMethodBeat.i(108087);
    this.bMv = new m(parame, paramr, paramClass);
    this.bMu = paramClass;
    AppMethodBeat.o(108087);
  }
  
  public final Object a(com.google.a.d.a parama)
  {
    AppMethodBeat.i(223459);
    if (parama.zw() == com.google.a.d.b.bOQ)
    {
      parama.zA();
      AppMethodBeat.o(223459);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    parama.zs();
    while (parama.hasNext()) {
      localArrayList.add(this.bMv.a(parama));
    }
    parama.zt();
    int j = localArrayList.size();
    parama = Array.newInstance(this.bMu, j);
    int i = 0;
    while (i < j)
    {
      Array.set(parama, i, localArrayList.get(i));
      i += 1;
    }
    AppMethodBeat.o(223459);
    return parama;
  }
  
  public final void a(c paramc, Object paramObject)
  {
    AppMethodBeat.i(108088);
    if (paramObject == null)
    {
      paramc.zK();
      AppMethodBeat.o(108088);
      return;
    }
    paramc.zG();
    int i = 0;
    int j = Array.getLength(paramObject);
    while (i < j)
    {
      Object localObject = Array.get(paramObject, i);
      this.bMv.a(paramc, localObject);
      i += 1;
    }
    paramc.zH();
    AppMethodBeat.o(108088);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.a.b.a.a
 * JD-Core Version:    0.7.0.1
 */