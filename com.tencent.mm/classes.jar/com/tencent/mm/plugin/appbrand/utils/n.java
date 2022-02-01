package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
{
  private long mON;
  private long mOO;
  private a mOP;
  
  public n() {}
  
  public n(long paramLong, a parama)
  {
    this.mON = paramLong;
    this.mOP = parama;
  }
  
  private boolean bBt()
  {
    AppMethodBeat.i(137914);
    if (System.currentTimeMillis() - this.mOO < this.mON)
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
    if (bBt())
    {
      AppMethodBeat.o(137915);
      return false;
    }
    if (this.mOP == null)
    {
      AppMethodBeat.o(137915);
      return false;
    }
    boolean bool = this.mOP.k(paramVarArgs);
    if (bool) {
      this.mOO = System.currentTimeMillis();
    }
    AppMethodBeat.o(137915);
    return bool;
  }
  
  public static abstract interface a
  {
    public abstract boolean k(Object... paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.n
 * JD-Core Version:    0.7.0.1
 */