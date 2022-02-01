package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class nl
  extends IEvent
{
  public a dTC;
  
  public nl()
  {
    this((byte)0);
  }
  
  private nl(byte paramByte)
  {
    AppMethodBeat.i(116033);
    this.dTC = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116033);
  }
  
  public static final class a
  {
    public int dTD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.nl
 * JD-Core Version:    0.7.0.1
 */