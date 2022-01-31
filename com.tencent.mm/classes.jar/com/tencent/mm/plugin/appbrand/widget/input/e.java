package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.s.i;
import java.util.Collection;
import java.util.Iterator;

public final class e
{
  private static final i<v, aa> jkP;
  
  static
  {
    AppMethodBeat.i(123598);
    jkP = new i();
    AppMethodBeat.o(123598);
  }
  
  public static aa a(v paramv, e.a parama)
  {
    AppMethodBeat.i(123597);
    if (paramv == null)
    {
      AppMethodBeat.o(123597);
      return null;
    }
    paramv = jkP.br(paramv);
    if (paramv != null)
    {
      paramv = paramv.iterator();
      while (paramv.hasNext())
      {
        aa localaa = (aa)paramv.next();
        if ((localaa != null) && (parama.a(localaa)))
        {
          AppMethodBeat.o(123597);
          return localaa;
        }
      }
    }
    AppMethodBeat.o(123597);
    return null;
  }
  
  public static void a(v paramv, aa paramaa)
  {
    AppMethodBeat.i(123595);
    jkP.s(paramv, paramaa);
    AppMethodBeat.o(123595);
  }
  
  public static void o(v paramv)
  {
    AppMethodBeat.i(123596);
    jkP.bs(paramv);
    AppMethodBeat.o(123596);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.e
 * JD-Core Version:    0.7.0.1
 */