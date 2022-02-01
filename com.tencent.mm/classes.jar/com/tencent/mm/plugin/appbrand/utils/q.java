package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q
{
  private long riG;
  private long riH;
  private a riI;
  
  public q() {}
  
  public q(long paramLong, a parama)
  {
    this.riG = paramLong;
    this.riI = parama;
  }
  
  private boolean cmh()
  {
    AppMethodBeat.i(137914);
    if (System.currentTimeMillis() - this.riH < this.riG)
    {
      AppMethodBeat.o(137914);
      return true;
    }
    AppMethodBeat.o(137914);
    return false;
  }
  
  public final boolean k(Object... paramVarArgs)
  {
    AppMethodBeat.i(137915);
    if (cmh())
    {
      AppMethodBeat.o(137915);
      return false;
    }
    if (this.riI == null)
    {
      AppMethodBeat.o(137915);
      return false;
    }
    boolean bool = this.riI.i(paramVarArgs);
    if (bool) {
      this.riH = System.currentTimeMillis();
    }
    AppMethodBeat.o(137915);
    return bool;
  }
  
  public static abstract interface a
  {
    public abstract boolean i(Object... paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.q
 * JD-Core Version:    0.7.0.1
 */