package com.google.a.b.a;

import com.google.a.d.c;
import com.google.a.e;
import com.google.a.r;
import com.google.a.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class h
  extends r<Object>
{
  public static final s bMt;
  private final e bMJ;
  
  static
  {
    AppMethodBeat.i(107990);
    bMt = new s()
    {
      public final <T> r<T> a(e paramAnonymouse, com.google.a.c.a<T> paramAnonymousa)
      {
        AppMethodBeat.i(107996);
        if (paramAnonymousa.bOw == Object.class)
        {
          paramAnonymouse = new h(paramAnonymouse);
          AppMethodBeat.o(107996);
          return paramAnonymouse;
        }
        AppMethodBeat.o(107996);
        return null;
      }
    };
    AppMethodBeat.o(107990);
  }
  
  h(e parame)
  {
    this.bMJ = parame;
  }
  
  public final Object a(com.google.a.d.a parama)
  {
    AppMethodBeat.i(222795);
    Object localObject = parama.zw();
    switch (2.bMK[localObject.ordinal()])
    {
    default: 
      parama = new IllegalStateException();
      AppMethodBeat.o(222795);
      throw parama;
    case 1: 
      localObject = new ArrayList();
      parama.zs();
      while (parama.hasNext()) {
        ((List)localObject).add(a(parama));
      }
      parama.zt();
      AppMethodBeat.o(222795);
      return localObject;
    case 2: 
      localObject = new com.google.a.b.h();
      parama.zu();
      while (parama.hasNext()) {
        ((Map)localObject).put(parama.zx(), a(parama));
      }
      parama.zv();
      AppMethodBeat.o(222795);
      return localObject;
    case 3: 
      parama = parama.zy();
      AppMethodBeat.o(222795);
      return parama;
    case 4: 
      double d = parama.zB();
      AppMethodBeat.o(222795);
      return Double.valueOf(d);
    case 5: 
      boolean bool = parama.zz();
      AppMethodBeat.o(222795);
      return Boolean.valueOf(bool);
    }
    parama.zA();
    AppMethodBeat.o(222795);
    return null;
  }
  
  public final void a(c paramc, Object paramObject)
  {
    AppMethodBeat.i(107989);
    if (paramObject == null)
    {
      paramc.zK();
      AppMethodBeat.o(107989);
      return;
    }
    r localr = this.bMJ.q(paramObject.getClass());
    if ((localr instanceof h))
    {
      paramc.zI();
      paramc.zJ();
      AppMethodBeat.o(107989);
      return;
    }
    localr.a(paramc, paramObject);
    AppMethodBeat.o(107989);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.a.b.a.h
 * JD-Core Version:    0.7.0.1
 */