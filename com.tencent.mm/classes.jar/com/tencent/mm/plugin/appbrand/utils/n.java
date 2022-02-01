package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
{
  private long lMo;
  private long lMp;
  private a lMq;
  
  public n() {}
  
  public n(long paramLong, a parama)
  {
    this.lMo = paramLong;
    this.lMq = parama;
  }
  
  private boolean bqr()
  {
    AppMethodBeat.i(137914);
    if (System.currentTimeMillis() - this.lMp < this.lMo)
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
    if (bqr())
    {
      AppMethodBeat.o(137915);
      return false;
    }
    if (this.lMq == null)
    {
      AppMethodBeat.o(137915);
      return false;
    }
    boolean bool = this.lMq.j(paramVarArgs);
    if (bool) {
      this.lMp = System.currentTimeMillis();
    }
    AppMethodBeat.o(137915);
    return bool;
  }
  
  public static abstract interface a
  {
    public abstract boolean j(Object... paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.n
 * JD-Core Version:    0.7.0.1
 */