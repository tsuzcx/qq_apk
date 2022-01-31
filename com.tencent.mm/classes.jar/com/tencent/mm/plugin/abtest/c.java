package com.tencent.mm.plugin.abtest;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.q;

public final class c
  extends q
{
  private static c grR;
  
  private c()
  {
    super(com.tencent.mm.model.c.c.class);
  }
  
  public static c app()
  {
    try
    {
      AppMethodBeat.i(118192);
      if (grR == null) {
        grR = new c();
      }
      c localc = grR;
      AppMethodBeat.o(118192);
      return localc;
    }
    finally {}
  }
  
  public final void mE(String paramString)
  {
    AppMethodBeat.i(118193);
    super.mE(paramString);
    AppMethodBeat.o(118193);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.abtest.c
 * JD-Core Version:    0.7.0.1
 */