package com.google.c.b.a;

import com.google.c.d.c;
import com.google.c.e;
import com.google.c.r;
import com.google.c.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.List;

public final class a<E>
  extends r<Object>
{
  public static final s dFZ;
  private final Class<E> dGa;
  private final r<E> dGb;
  
  static
  {
    AppMethodBeat.i(108089);
    dFZ = new s()
    {
      public final <T> r<T> a(e paramAnonymouse, com.google.c.c.a<T> paramAnonymousa)
      {
        AppMethodBeat.i(108045);
        paramAnonymousa = paramAnonymousa.dGJ;
        if ((!(paramAnonymousa instanceof GenericArrayType)) && ((!(paramAnonymousa instanceof Class)) || (!((Class)paramAnonymousa).isArray())))
        {
          AppMethodBeat.o(108045);
          return null;
        }
        paramAnonymousa = com.google.c.b.b.e(paramAnonymousa);
        paramAnonymouse = new a(paramAnonymouse, paramAnonymouse.a(com.google.c.c.a.h(paramAnonymousa)), com.google.c.b.b.c(paramAnonymousa));
        AppMethodBeat.o(108045);
        return paramAnonymouse;
      }
    };
    AppMethodBeat.o(108089);
  }
  
  public a(e parame, r<E> paramr, Class<E> paramClass)
  {
    AppMethodBeat.i(108087);
    this.dGb = new m(parame, paramr, paramClass);
    this.dGa = paramClass;
    AppMethodBeat.o(108087);
  }
  
  public final Object a(com.google.c.d.a parama)
  {
    AppMethodBeat.i(208886);
    if (parama.Zh() == com.google.c.d.b.dIv)
    {
      parama.Zl();
      AppMethodBeat.o(208886);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    parama.Zd();
    while (parama.hasNext()) {
      localArrayList.add(this.dGb.a(parama));
    }
    parama.Ze();
    int j = localArrayList.size();
    parama = Array.newInstance(this.dGa, j);
    int i = 0;
    while (i < j)
    {
      Array.set(parama, i, localArrayList.get(i));
      i += 1;
    }
    AppMethodBeat.o(208886);
    return parama;
  }
  
  public final void a(c paramc, Object paramObject)
  {
    AppMethodBeat.i(108088);
    if (paramObject == null)
    {
      paramc.Zv();
      AppMethodBeat.o(108088);
      return;
    }
    paramc.Zr();
    int i = 0;
    int j = Array.getLength(paramObject);
    while (i < j)
    {
      Object localObject = Array.get(paramObject, i);
      this.dGb.a(paramc, localObject);
      i += 1;
    }
    paramc.Zs();
    AppMethodBeat.o(108088);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.c.b.a.a
 * JD-Core Version:    0.7.0.1
 */