package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class cu
  extends IEvent
{
  public a dFU;
  public b dFV;
  
  public cu()
  {
    this((byte)0);
  }
  
  private cu(byte paramByte)
  {
    AppMethodBeat.i(127401);
    this.dFU = new a();
    this.dFV = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(127401);
  }
  
  public static final class a
  {
    public long dFW = 0L;
  }
  
  public static final class b
  {
    public boolean dFE = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.cu
 * JD-Core Version:    0.7.0.1
 */