package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
{
  private long mol;
  private long mom;
  private a mon;
  
  public n() {}
  
  public n(long paramLong, a parama)
  {
    this.mol = paramLong;
    this.mon = parama;
  }
  
  private boolean bxp()
  {
    AppMethodBeat.i(137914);
    if (System.currentTimeMillis() - this.mom < this.mol)
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
    if (bxp())
    {
      AppMethodBeat.o(137915);
      return false;
    }
    if (this.mon == null)
    {
      AppMethodBeat.o(137915);
      return false;
    }
    boolean bool = this.mon.k(paramVarArgs);
    if (bool) {
      this.mom = System.currentTimeMillis();
    }
    AppMethodBeat.o(137915);
    return bool;
  }
  
  public static abstract interface a
  {
    public abstract boolean k(Object... paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.n
 * JD-Core Version:    0.7.0.1
 */