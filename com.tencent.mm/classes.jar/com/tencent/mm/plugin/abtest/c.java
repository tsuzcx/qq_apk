package com.tencent.mm.plugin.abtest;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.c.d;
import com.tencent.mm.model.t;

public final class c
  extends t
{
  private static c iFa;
  
  private c()
  {
    super(d.class);
  }
  
  public static c aOC()
  {
    try
    {
      AppMethodBeat.i(153140);
      if (iFa == null) {
        iFa = new c();
      }
      c localc = iFa;
      AppMethodBeat.o(153140);
      return localc;
    }
    finally {}
  }
  
  public final void ul(String paramString)
  {
    AppMethodBeat.i(153141);
    super.ul(paramString);
    AppMethodBeat.o(153141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.abtest.c
 * JD-Core Version:    0.7.0.1
 */