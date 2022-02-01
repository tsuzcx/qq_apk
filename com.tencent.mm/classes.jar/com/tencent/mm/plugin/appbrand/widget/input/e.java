package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.h;
import com.tencent.mm.plugin.appbrand.page.ac;
import java.util.Collection;
import java.util.Iterator;

public final class e
{
  private static final h<ac, aa> orU;
  
  static
  {
    AppMethodBeat.i(136329);
    orU = new h();
    AppMethodBeat.o(136329);
  }
  
  public static void B(ac paramac)
  {
    AppMethodBeat.i(136327);
    orU.cN(paramac);
    AppMethodBeat.o(136327);
  }
  
  public static aa a(ac paramac, a parama)
  {
    AppMethodBeat.i(136328);
    if (paramac == null)
    {
      AppMethodBeat.o(136328);
      return null;
    }
    paramac = orU.cM(paramac);
    if (paramac != null)
    {
      paramac = paramac.iterator();
      while (paramac.hasNext())
      {
        aa localaa = (aa)paramac.next();
        if ((localaa != null) && (parama.a(localaa)))
        {
          AppMethodBeat.o(136328);
          return localaa;
        }
      }
    }
    AppMethodBeat.o(136328);
    return null;
  }
  
  public static void a(ac paramac, aa paramaa)
  {
    AppMethodBeat.i(136326);
    orU.r(paramac, paramaa);
    AppMethodBeat.o(136326);
  }
  
  public static abstract interface a
  {
    public abstract boolean a(aa paramaa);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.e
 * JD-Core Version:    0.7.0.1
 */