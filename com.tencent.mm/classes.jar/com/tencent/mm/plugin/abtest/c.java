package com.tencent.mm.plugin.abtest;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.c.d;
import com.tencent.mm.model.t;

public final class c
  extends t
{
  private static c iYj;
  
  private c()
  {
    super(d.class);
  }
  
  public static c aRO()
  {
    try
    {
      AppMethodBeat.i(153140);
      if (iYj == null) {
        iYj = new c();
      }
      c localc = iYj;
      AppMethodBeat.o(153140);
      return localc;
    }
    finally {}
  }
  
  public final void xb(String paramString)
  {
    AppMethodBeat.i(153141);
    super.xb(paramString);
    AppMethodBeat.o(153141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.abtest.c
 * JD-Core Version:    0.7.0.1
 */