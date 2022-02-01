package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.k;

public final class bo
{
  public static a hKo = null;
  
  public static k a(k paramk)
  {
    AppMethodBeat.i(132251);
    if (hKo == null)
    {
      AppMethodBeat.o(132251);
      return paramk;
    }
    paramk = hKo.aCA();
    AppMethodBeat.o(132251);
    return paramk;
  }
  
  public static int aCz()
  {
    AppMethodBeat.i(132252);
    if (hKo != null)
    {
      int i = hKo.aCz();
      AppMethodBeat.o(132252);
      return i;
    }
    AppMethodBeat.o(132252);
    return 0;
  }
  
  public static abstract interface a
  {
    public abstract k aCA();
    
    public abstract int aCz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.bo
 * JD-Core Version:    0.7.0.1
 */