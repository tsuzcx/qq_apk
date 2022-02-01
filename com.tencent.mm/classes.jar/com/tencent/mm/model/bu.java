package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.network.m;

public final class bu
{
  public static a omB = null;
  
  public static m a(m paramm, p paramp)
  {
    AppMethodBeat.i(242007);
    if (omB == null)
    {
      AppMethodBeat.o(242007);
      return paramm;
    }
    paramm = omB.a(paramm, paramp);
    AppMethodBeat.o(242007);
    return paramm;
  }
  
  public static void a(a parama)
  {
    omB = parama;
  }
  
  public static int bCS()
  {
    AppMethodBeat.i(132252);
    if (omB != null)
    {
      int i = omB.bCS();
      AppMethodBeat.o(132252);
      return i;
    }
    AppMethodBeat.o(132252);
    return 0;
  }
  
  public static abstract interface a
  {
    public abstract m a(m paramm, p paramp);
    
    public abstract int bCS();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.bu
 * JD-Core Version:    0.7.0.1
 */