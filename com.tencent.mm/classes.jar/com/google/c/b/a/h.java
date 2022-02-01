package com.google.c.b.a;

import com.google.c.d.c;
import com.google.c.e;
import com.google.c.r;
import com.google.c.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class h
  extends r<Object>
{
  public static final s dFZ;
  private final e dGo;
  
  static
  {
    AppMethodBeat.i(107990);
    dFZ = new s()
    {
      public final <T> r<T> a(e paramAnonymouse, com.google.c.c.a<T> paramAnonymousa)
      {
        AppMethodBeat.i(107996);
        if (paramAnonymousa.dIb == Object.class)
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
    this.dGo = parame;
  }
  
  public final Object a(com.google.c.d.a parama)
  {
    AppMethodBeat.i(208895);
    Object localObject = parama.Zh();
    switch (2.dGp[localObject.ordinal()])
    {
    default: 
      parama = new IllegalStateException();
      AppMethodBeat.o(208895);
      throw parama;
    case 1: 
      localObject = new ArrayList();
      parama.Zd();
      while (parama.hasNext()) {
        ((List)localObject).add(a(parama));
      }
      parama.Ze();
      AppMethodBeat.o(208895);
      return localObject;
    case 2: 
      localObject = new com.google.c.b.h();
      parama.Zf();
      while (parama.hasNext()) {
        ((Map)localObject).put(parama.Zi(), a(parama));
      }
      parama.Zg();
      AppMethodBeat.o(208895);
      return localObject;
    case 3: 
      parama = parama.Zj();
      AppMethodBeat.o(208895);
      return parama;
    case 4: 
      double d = parama.Zm();
      AppMethodBeat.o(208895);
      return Double.valueOf(d);
    case 5: 
      boolean bool = parama.Zk();
      AppMethodBeat.o(208895);
      return Boolean.valueOf(bool);
    }
    parama.Zl();
    AppMethodBeat.o(208895);
    return null;
  }
  
  public final void a(c paramc, Object paramObject)
  {
    AppMethodBeat.i(107989);
    if (paramObject == null)
    {
      paramc.Zv();
      AppMethodBeat.o(107989);
      return;
    }
    r localr = this.dGo.z(paramObject.getClass());
    if ((localr instanceof h))
    {
      paramc.Zt();
      paramc.Zu();
      AppMethodBeat.o(107989);
      return;
    }
    localr.a(paramc, paramObject);
    AppMethodBeat.o(107989);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.c.b.a.h
 * JD-Core Version:    0.7.0.1
 */