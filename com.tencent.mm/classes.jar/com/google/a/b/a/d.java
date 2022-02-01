package com.google.a.b.a;

import com.google.a.a.b;
import com.google.a.b.c;
import com.google.a.b.h;
import com.google.a.c.a;
import com.google.a.f;
import com.google.a.j;
import com.google.a.q;
import com.google.a.s;
import com.google.a.t;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  implements t
{
  private final c bFb;
  
  public d(c paramc)
  {
    this.bFb = paramc;
  }
  
  static s<?> a(c paramc, f paramf, a<?> parama, b paramb)
  {
    AppMethodBeat.i(107992);
    Object localObject = paramc.b(a.J(paramb.value())).xx();
    if ((localObject instanceof s)) {}
    for (paramc = (s)localObject;; paramc = ((t)localObject).a(paramf, parama))
    {
      paramf = paramc;
      if (paramc != null)
      {
        paramf = paramc;
        if (paramb.xu()) {
          paramf = paramc.xr();
        }
      }
      AppMethodBeat.o(107992);
      return paramf;
      if (!(localObject instanceof t)) {
        break;
      }
    }
    if (((localObject instanceof q)) || ((localObject instanceof j)))
    {
      if ((localObject instanceof q))
      {
        paramc = (q)localObject;
        label122:
        if (!(localObject instanceof j)) {
          break label158;
        }
      }
      label158:
      for (localObject = (j)localObject;; localObject = null)
      {
        paramc = new k(paramc, (j)localObject, paramf, parama);
        break;
        paramc = null;
        break label122;
      }
    }
    paramc = new IllegalArgumentException("Invalid attempt to bind an instance of " + localObject.getClass().getName() + " as a @JsonAdapter for " + parama.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
    AppMethodBeat.o(107992);
    throw paramc;
  }
  
  public final <T> s<T> a(f paramf, a<T> parama)
  {
    AppMethodBeat.i(107991);
    b localb = (b)parama.bIC.getAnnotation(b.class);
    if (localb == null)
    {
      AppMethodBeat.o(107991);
      return null;
    }
    paramf = a(this.bFb, paramf, parama, localb);
    AppMethodBeat.o(107991);
    return paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.a.b.a.d
 * JD-Core Version:    0.7.0.1
 */