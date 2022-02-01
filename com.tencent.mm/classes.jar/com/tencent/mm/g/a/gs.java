package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class gs
  extends IEvent
{
  public a dKL;
  public b dKM;
  
  public gs()
  {
    this((byte)0);
  }
  
  private gs(byte paramByte)
  {
    AppMethodBeat.i(116028);
    this.dKL = new a();
    this.dKM = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116028);
  }
  
  public static final class a
  {
    public int state = -1;
  }
  
  public static final class b
  {
    public boolean dFE = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.a.gs
 * JD-Core Version:    0.7.0.1
 */