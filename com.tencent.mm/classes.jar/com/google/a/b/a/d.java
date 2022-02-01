package com.google.a.b.a;

import com.google.a.a.b;
import com.google.a.b.c;
import com.google.a.b.i;
import com.google.a.c.a;
import com.google.a.e;
import com.google.a.h;
import com.google.a.o;
import com.google.a.r;
import com.google.a.s;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  implements s
{
  private final c bKQ;
  
  public d(c paramc)
  {
    this.bKQ = paramc;
  }
  
  static r<?> a(c paramc, e parame, a<?> parama, b paramb)
  {
    AppMethodBeat.i(107992);
    Object localObject = paramc.b(a.z(paramb.gf())).zl();
    if ((localObject instanceof r)) {}
    for (paramc = (r)localObject;; paramc = ((s)localObject).a(parame, parama))
    {
      parame = paramc;
      if (paramc != null)
      {
        parame = paramc;
        if (paramb.zi()) {
          parame = paramc.zf();
        }
      }
      AppMethodBeat.o(107992);
      return parame;
      if (!(localObject instanceof s)) {
        break;
      }
    }
    if (((localObject instanceof o)) || ((localObject instanceof h)))
    {
      if ((localObject instanceof o))
      {
        paramc = (o)localObject;
        label122:
        if (!(localObject instanceof h)) {
          break label158;
        }
      }
      label158:
      for (localObject = (h)localObject;; localObject = null)
      {
        paramc = new l(paramc, (h)localObject, parame, parama);
        break;
        paramc = null;
        break label122;
      }
    }
    paramc = new IllegalArgumentException("Invalid attempt to bind an instance of " + localObject.getClass().getName() + " as a @JsonAdapter for " + parama.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
    AppMethodBeat.o(107992);
    throw paramc;
  }
  
  public final <T> r<T> a(e parame, a<T> parama)
  {
    AppMethodBeat.i(107991);
    b localb = (b)parama.bOw.getAnnotation(b.class);
    if (localb == null)
    {
      AppMethodBeat.o(107991);
      return null;
    }
    parame = a(this.bKQ, parame, parama, localb);
    AppMethodBeat.o(107991);
    return parame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.a.b.a.d
 * JD-Core Version:    0.7.0.1
 */