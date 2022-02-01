package com.tencent.mm.plugin.abtest;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.c.d;
import com.tencent.mm.model.y;

public final class c
  extends y
{
  private static c jZf;
  
  private c()
  {
    super(d.class);
  }
  
  public static c bna()
  {
    try
    {
      AppMethodBeat.i(153140);
      if (jZf == null) {
        jZf = new c();
      }
      c localc = jZf;
      AppMethodBeat.o(153140);
      return localc;
    }
    finally {}
  }
  
  public final void FU(String paramString)
  {
    AppMethodBeat.i(153141);
    super.FU(paramString);
    AppMethodBeat.o(153141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.abtest.c
 * JD-Core Version:    0.7.0.1
 */