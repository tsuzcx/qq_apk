package com.tencent.e.g;

import com.tencent.e.g.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
{
  public static b KaQ;
  
  public static b b(com.tencent.e.a parama)
  {
    AppMethodBeat.i(183339);
    if (parama.JZe != null)
    {
      parama = parama.JZe;
      AppMethodBeat.o(183339);
      return parama;
    }
    int i = Math.max(1, parama.JZb / 2);
    int j = Math.max(1, i / 3);
    switch (1.KaR[parama.JZf.ordinal()])
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
      KaS = new a("FS_POLICY", 0);
      KaT = new a("LINEAR_POLICY", 1);
      KaU = new a("CONST_POLICY", 2);
      KaV = new a("THROW_POLICY", 3);
      KaW = new a("BLOCK_INVOKER_POLICY", 4);
      KaX = new a("DEFAULT", 5);
      KaY = new a[] { KaS, KaT, KaU, KaV, KaW, KaX };
      AppMethodBeat.o(183338);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.g.h
 * JD-Core Version:    0.7.0.1
 */