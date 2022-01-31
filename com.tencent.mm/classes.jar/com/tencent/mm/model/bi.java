package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.k;

public final class bi
{
  public static a fnc = null;
  
  public static k a(k paramk)
  {
    AppMethodBeat.i(58107);
    if (fnc == null)
    {
      AppMethodBeat.o(58107);
      return paramk;
    }
    paramk = fnc.aaT();
    AppMethodBeat.o(58107);
    return paramk;
  }
  
  public static int aaS()
  {
    AppMethodBeat.i(58108);
    if (fnc != null)
    {
      int i = fnc.aaS();
      AppMethodBeat.o(58108);
      return i;
    }
    AppMethodBeat.o(58108);
    return 0;
  }
  
  public static abstract interface a
  {
    public abstract int aaS();
    
    public abstract k aaT();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.bi
 * JD-Core Version:    0.7.0.1
 */