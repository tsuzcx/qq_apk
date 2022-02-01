package com.tencent.mm.plugin.abtest;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.newabtest.d;
import com.tencent.mm.model.y;

public final class c
  extends y
{
  private static c pNe;
  
  private c()
  {
    super(d.class);
  }
  
  public static c bVY()
  {
    try
    {
      AppMethodBeat.i(153140);
      if (pNe == null) {
        pNe = new c();
      }
      c localc = pNe;
      AppMethodBeat.o(153140);
      return localc;
    }
    finally {}
  }
  
  public final void FD(String paramString)
  {
    AppMethodBeat.i(153141);
    super.FD(paramString);
    AppMethodBeat.o(153141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.abtest.c
 * JD-Core Version:    0.7.0.1
 */