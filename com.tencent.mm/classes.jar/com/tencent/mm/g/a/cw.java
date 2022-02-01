package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class cw
  extends IEvent
{
  public a dFY;
  
  public cw()
  {
    this((byte)0);
  }
  
  private cw(byte paramByte)
  {
    AppMethodBeat.i(149860);
    this.dFY = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149860);
  }
  
  public static final class a
  {
    public int packageType = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.cw
 * JD-Core Version:    0.7.0.1
 */