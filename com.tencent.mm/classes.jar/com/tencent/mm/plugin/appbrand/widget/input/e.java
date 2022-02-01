package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.z.h;
import java.util.Collection;
import java.util.Iterator;

public final class e
{
  private static final h<com.tencent.mm.plugin.appbrand.page.aa, aa> mCD;
  
  static
  {
    AppMethodBeat.i(136329);
    mCD = new h();
    AppMethodBeat.o(136329);
  }
  
  public static aa a(com.tencent.mm.plugin.appbrand.page.aa paramaa, a parama)
  {
    AppMethodBeat.i(136328);
    if (paramaa == null)
    {
      AppMethodBeat.o(136328);
      return null;
    }
    paramaa = mCD.cC(paramaa);
    if (paramaa != null)
    {
      paramaa = paramaa.iterator();
      while (paramaa.hasNext())
      {
        aa localaa = (aa)paramaa.next();
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
  
  public static void a(com.tencent.mm.plugin.appbrand.page.aa paramaa, aa paramaa1)
  {
    AppMethodBeat.i(136326);
    mCD.h(paramaa, paramaa1);
    AppMethodBeat.o(136326);
  }
  
  public static void v(com.tencent.mm.plugin.appbrand.page.aa paramaa)
  {
    AppMethodBeat.i(136327);
    mCD.cD(paramaa);
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