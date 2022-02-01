package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.y.h;
import java.util.Collection;
import java.util.Iterator;

public final class e
{
  private static final h<z, aa> nim;
  
  static
  {
    AppMethodBeat.i(136329);
    nim = new h();
    AppMethodBeat.o(136329);
  }
  
  public static aa a(z paramz, a parama)
  {
    AppMethodBeat.i(136328);
    if (paramz == null)
    {
      AppMethodBeat.o(136328);
      return null;
    }
    paramz = nim.cF(paramz);
    if (paramz != null)
    {
      paramz = paramz.iterator();
      while (paramz.hasNext())
      {
        aa localaa = (aa)paramz.next();
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
  
  public static void a(z paramz, aa paramaa)
  {
    AppMethodBeat.i(136326);
    nim.j(paramz, paramaa);
    AppMethodBeat.o(136326);
  }
  
  public static void w(z paramz)
  {
    AppMethodBeat.i(136327);
    nim.cG(paramz);
    AppMethodBeat.o(136327);
  }
  
  public static abstract interface a
  {
    public abstract boolean a(aa paramaa);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.e
 * JD-Core Version:    0.7.0.1
 */