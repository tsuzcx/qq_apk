package com.tencent.e.g;

import com.tencent.e.g.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
{
  public static b LUN;
  
  public static b b(com.tencent.e.a parama)
  {
    AppMethodBeat.i(183339);
    if (parama.LSZ != null)
    {
      parama = parama.LSZ;
      AppMethodBeat.o(183339);
      return parama;
    }
    int i = Math.max(1, parama.LSW / 2);
    int j = Math.max(1, i / 3);
    switch (1.LUO[parama.LTa.ordinal()])
    {
    default: 
      parama = new d();
      AppMethodBeat.o(183339);
      return parama;
    case 1: 
      parama = new e(i, j);
      AppMethodBeat.o(183339);
      return parama;
    case 2: 
      parama = new c(i, j);
      AppMethodBeat.o(183339);
      return parama;
    case 3: 
      parama = new f(i, j);
      AppMethodBeat.o(183339);
      return parama;
    case 4: 
      parama = new i(i);
      AppMethodBeat.o(183339);
      return parama;
    }
    parama = new a(j, j);
    AppMethodBeat.o(183339);
    return parama;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(183338);
      LUP = new a("FS_POLICY", 0);
      LUQ = new a("LINEAR_POLICY", 1);
      LUR = new a("CONST_POLICY", 2);
      LUS = new a("THROW_POLICY", 3);
      LUT = new a("BLOCK_INVOKER_POLICY", 4);
      LUU = new a("DEFAULT", 5);
      LUV = new a[] { LUP, LUQ, LUR, LUS, LUT, LUU };
      AppMethodBeat.o(183338);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.g.h
 * JD-Core Version:    0.7.0.1
 */