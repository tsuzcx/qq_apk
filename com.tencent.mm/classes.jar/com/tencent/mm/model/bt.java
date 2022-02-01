package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.m;

public final class bt
{
  public static a lve = null;
  
  public static m a(m paramm)
  {
    AppMethodBeat.i(132251);
    if (lve == null)
    {
      AppMethodBeat.o(132251);
      return paramm;
    }
    paramm = lve.bfb();
    AppMethodBeat.o(132251);
    return paramm;
  }
  
  public static int bfa()
  {
    AppMethodBeat.i(132252);
    if (lve != null)
    {
      int i = lve.bfa();
      AppMethodBeat.o(132252);
      return i;
    }
    AppMethodBeat.o(132252);
    return 0;
  }
  
  public static abstract interface a
  {
    public abstract int bfa();
    
    public abstract m bfb();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.model.bt
 * JD-Core Version:    0.7.0.1
 */