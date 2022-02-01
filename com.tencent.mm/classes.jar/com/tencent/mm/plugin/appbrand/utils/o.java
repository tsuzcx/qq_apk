package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o
{
  private long ogT;
  private long ogU;
  private a ogV;
  
  public o() {}
  
  public o(long paramLong, a parama)
  {
    this.ogT = paramLong;
    this.ogV = parama;
  }
  
  private boolean bZr()
  {
    AppMethodBeat.i(137914);
    if (System.currentTimeMillis() - this.ogU < this.ogT)
    {
      AppMethodBeat.o(137914);
      return true;
    }
    AppMethodBeat.o(137914);
    return false;
  }
  
  public final boolean l(Object... paramVarArgs)
  {
    AppMethodBeat.i(137915);
    if (bZr())
    {
      AppMethodBeat.o(137915);
      return false;
    }
    if (this.ogV == null)
    {
      AppMethodBeat.o(137915);
      return false;
    }
    boolean bool = this.ogV.j(paramVarArgs);
    if (bool) {
      this.ogU = System.currentTimeMillis();
    }
    AppMethodBeat.o(137915);
    return bool;
  }
  
  public static abstract interface a
  {
    public abstract boolean j(Object... paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.o
 * JD-Core Version:    0.7.0.1
 */