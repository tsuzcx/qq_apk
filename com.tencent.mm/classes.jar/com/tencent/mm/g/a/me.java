package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class me
  extends IEvent
{
  public a dRE;
  
  public me()
  {
    this((byte)0);
  }
  
  private me(byte paramByte)
  {
    AppMethodBeat.i(149870);
    this.dRE = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149870);
  }
  
  public static final class a
  {
    public IEvent dRF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.me
 * JD-Core Version:    0.7.0.1
 */