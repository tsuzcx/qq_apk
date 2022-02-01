package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.j;
import com.tencent.mm.plugin.appbrand.page.ad;
import java.util.Collection;
import java.util.Iterator;

public final class e
{
  private static final j<ad, ae<?>> uFi;
  
  static
  {
    AppMethodBeat.i(136329);
    uFi = new j();
    AppMethodBeat.o(136329);
  }
  
  public static void C(ad paramad)
  {
    AppMethodBeat.i(136327);
    uFi.ek(paramad);
    AppMethodBeat.o(136327);
  }
  
  public static ae<?> a(ad paramad, a parama)
  {
    AppMethodBeat.i(136328);
    if (paramad == null)
    {
      AppMethodBeat.o(136328);
      return null;
    }
    paramad = uFi.ej(paramad);
    if (paramad != null)
    {
      paramad = paramad.iterator();
      while (paramad.hasNext())
      {
        ae localae = (ae)paramad.next();
        if ((localae != null) && (parama.a(localae)))
        {
          AppMethodBeat.o(136328);
          return localae;
        }
      }
    }
    AppMethodBeat.o(136328);
    return null;
  }
  
  public static void a(ad paramad, ae<?> paramae)
  {
    AppMethodBeat.i(136326);
    uFi.v(paramad, paramae);
    AppMethodBeat.o(136326);
  }
  
  public static abstract interface a
  {
    public abstract boolean a(ae<?> paramae);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.e
 * JD-Core Version:    0.7.0.1
 */