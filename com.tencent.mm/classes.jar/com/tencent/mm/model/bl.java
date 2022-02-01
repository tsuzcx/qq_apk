package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.k;

public final class bl
{
  public static a hpe = null;
  
  public static k a(k paramk)
  {
    AppMethodBeat.i(132251);
    if (hpe == null)
    {
      AppMethodBeat.o(132251);
      return paramk;
    }
    paramk = hpe.azg();
    AppMethodBeat.o(132251);
    return paramk;
  }
  
  public static int azf()
  {
    AppMethodBeat.i(132252);
    if (hpe != null)
    {
      int i = hpe.azf();
      AppMethodBeat.o(132252);
      return i;
    }
    AppMethodBeat.o(132252);
    return 0;
  }
  
  public static abstract interface a
  {
    public abstract int azf();
    
    public abstract k azg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.bl
 * JD-Core Version:    0.7.0.1
 */