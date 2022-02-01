package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.m;

public final class bs
{
  public static a iFc = null;
  
  public static m a(m paramm)
  {
    AppMethodBeat.i(132251);
    if (iFc == null)
    {
      AppMethodBeat.o(132251);
      return paramm;
    }
    paramm = iFc.aVY();
    AppMethodBeat.o(132251);
    return paramm;
  }
  
  public static int aVX()
  {
    AppMethodBeat.i(132252);
    if (iFc != null)
    {
      int i = iFc.aVX();
      AppMethodBeat.o(132252);
      return i;
    }
    AppMethodBeat.o(132252);
    return 0;
  }
  
  public static abstract interface a
  {
    public abstract int aVX();
    
    public abstract m aVY();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.bs
 * JD-Core Version:    0.7.0.1
 */