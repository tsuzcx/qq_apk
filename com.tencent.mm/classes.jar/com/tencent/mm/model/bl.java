package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.k;

public final class bl
{
  public static a gOE = null;
  
  public static k a(k paramk)
  {
    AppMethodBeat.i(132251);
    if (gOE == null)
    {
      AppMethodBeat.o(132251);
      return paramk;
    }
    paramk = gOE.asp();
    AppMethodBeat.o(132251);
    return paramk;
  }
  
  public static int aso()
  {
    AppMethodBeat.i(132252);
    if (gOE != null)
    {
      int i = gOE.aso();
      AppMethodBeat.o(132252);
      return i;
    }
    AppMethodBeat.o(132252);
    return 0;
  }
  
  public static abstract interface a
  {
    public abstract int aso();
    
    public abstract k asp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.bl
 * JD-Core Version:    0.7.0.1
 */