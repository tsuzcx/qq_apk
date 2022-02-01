package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.k;

public final class bm
{
  public static a hHw = null;
  
  public static k a(k paramk)
  {
    AppMethodBeat.i(132251);
    if (hHw == null)
    {
      AppMethodBeat.o(132251);
      return paramk;
    }
    paramk = hHw.aCk();
    AppMethodBeat.o(132251);
    return paramk;
  }
  
  public static int aCj()
  {
    AppMethodBeat.i(132252);
    if (hHw != null)
    {
      int i = hHw.aCj();
      AppMethodBeat.o(132252);
      return i;
    }
    AppMethodBeat.o(132252);
    return 0;
  }
  
  public static abstract interface a
  {
    public abstract int aCj();
    
    public abstract k aCk();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.bm
 * JD-Core Version:    0.7.0.1
 */