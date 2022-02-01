package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class an
  extends IEvent
{
  public a dDr;
  
  public an()
  {
    this((byte)0);
  }
  
  private an(byte paramByte)
  {
    AppMethodBeat.i(5530);
    this.dDr = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(5530);
  }
  
  public static final class a
  {
    public String userName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.an
 * JD-Core Version:    0.7.0.1
 */