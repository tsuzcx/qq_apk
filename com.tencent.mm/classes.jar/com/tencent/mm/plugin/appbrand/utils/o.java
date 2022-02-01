package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o
{
  private long mTS;
  private long mTT;
  private a mTU;
  
  public o() {}
  
  public o(long paramLong, a parama)
  {
    this.mTS = paramLong;
    this.mTU = parama;
  }
  
  private boolean bCn()
  {
    AppMethodBeat.i(137914);
    if (System.currentTimeMillis() - this.mTT < this.mTS)
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
    if (bCn())
    {
      AppMethodBeat.o(137915);
      return false;
    }
    if (this.mTU == null)
    {
      AppMethodBeat.o(137915);
      return false;
    }
    boolean bool = this.mTU.j(paramVarArgs);
    if (bool) {
      this.mTT = System.currentTimeMillis();
    }
    AppMethodBeat.o(137915);
    return bool;
  }
  
  public static abstract interface a
  {
    public abstract boolean j(Object... paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.o
 * JD-Core Version:    0.7.0.1
 */