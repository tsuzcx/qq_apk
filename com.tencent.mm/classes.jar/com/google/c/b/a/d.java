package com.google.c.b.a;

import com.google.c.a.b;
import com.google.c.b.c;
import com.google.c.b.i;
import com.google.c.c.a;
import com.google.c.e;
import com.google.c.h;
import com.google.c.o;
import com.google.c.r;
import com.google.c.s;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  implements s
{
  private final c dEy;
  
  public d(c paramc)
  {
    this.dEy = paramc;
  }
  
  static r<?> a(c paramc, e parame, a<?> parama, b paramb)
  {
    AppMethodBeat.i(107992);
    Object localObject = paramc.b(a.I(paramb.Dr())).YW();
    if ((localObject instanceof r)) {}
    for (paramc = (r)localObject;; paramc = ((s)localObject).a(parame, parama))
    {
      parame = paramc;
      if (paramc != null)
      {
        parame = paramc;
        if (paramb.YT()) {
          parame = paramc.YQ();
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
    b localb = (b)parama.dIb.getAnnotation(b.class);
    if (localb == null)
    {
      AppMethodBeat.o(107991);
      return null;
    }
    parame = a(this.dEy, parame, parama, localb);
    AppMethodBeat.o(107991);
    return parame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.c.b.a.d
 * JD-Core Version:    0.7.0.1
 */