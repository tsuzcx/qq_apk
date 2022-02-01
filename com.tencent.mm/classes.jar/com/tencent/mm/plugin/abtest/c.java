package com.tencent.mm.plugin.abtest;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.c.d;
import com.tencent.mm.model.u;

public final class c
  extends u
{
  private static c jbc;
  
  private c()
  {
    super(d.class);
  }
  
  public static c aSn()
  {
    try
    {
      AppMethodBeat.i(153140);
      if (jbc == null) {
        jbc = new c();
      }
      c localc = jbc;
      AppMethodBeat.o(153140);
      return localc;
    }
    finally {}
  }
  
  public final void xK(String paramString)
  {
    AppMethodBeat.i(153141);
    super.xK(paramString);
    AppMethodBeat.o(153141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.abtest.c
 * JD-Core Version:    0.7.0.1
 */