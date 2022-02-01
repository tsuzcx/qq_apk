package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ac
  extends IEvent
{
  public a dDa;
  
  public ac()
  {
    this((byte)0);
  }
  
  private ac(byte paramByte)
  {
    AppMethodBeat.i(149850);
    this.dDa = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149850);
  }
  
  public static final class a
  {
    public String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.ac
 * JD-Core Version:    0.7.0.1
 */