package com.tencent.f.g;

import com.tencent.f.g.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
{
  public static b RUe;
  
  public static b b(com.tencent.f.a parama)
  {
    AppMethodBeat.i(183339);
    if (parama.RSt != null)
    {
      parama = parama.RSt;
      AppMethodBeat.o(183339);
      return parama;
    }
    int i = Math.max(1, parama.RSq / 2);
    int j = Math.max(1, i / 3);
    switch (1.RUf[parama.RSu.ordinal()])
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
      RUg = new a("FS_POLICY", 0);
      RUh = new a("LINEAR_POLICY", 1);
      RUi = new a("CONST_POLICY", 2);
      RUj = new a("THROW_POLICY", 3);
      RUk = new a("BLOCK_INVOKER_POLICY", 4);
      RUl = new a("DEFAULT", 5);
      RUm = new a[] { RUg, RUh, RUi, RUj, RUk, RUl };
      AppMethodBeat.o(183338);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.f.g.h
 * JD-Core Version:    0.7.0.1
 */