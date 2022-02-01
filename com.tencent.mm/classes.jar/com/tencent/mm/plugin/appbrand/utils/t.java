package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class t
{
  private long uqQ;
  private long uqR;
  private a uqS;
  
  public t() {}
  
  public t(long paramLong, a parama)
  {
    this.uqQ = paramLong;
    this.uqS = parama;
  }
  
  private boolean cNB()
  {
    AppMethodBeat.i(137914);
    if (System.currentTimeMillis() - this.uqR < this.uqQ)
    {
      AppMethodBeat.o(137914);
      return true;
    }
    AppMethodBeat.o(137914);
    return false;
  }
  
  public final boolean m(Object... paramVarArgs)
  {
    AppMethodBeat.i(137915);
    if (cNB())
    {
      AppMethodBeat.o(137915);
      return false;
    }
    if (this.uqS == null)
    {
      AppMethodBeat.o(137915);
      return false;
    }
    boolean bool = this.uqS.k(paramVarArgs);
    if (bool) {
      this.uqR = System.currentTimeMillis();
    }
    AppMethodBeat.o(137915);
    return bool;
  }
  
  public static abstract interface a
  {
    public abstract boolean k(Object... paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.t
 * JD-Core Version:    0.7.0.1
 */