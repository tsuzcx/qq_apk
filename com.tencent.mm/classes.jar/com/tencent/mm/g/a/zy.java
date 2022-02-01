package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class zy
  extends IEvent
{
  public a egE;
  
  public zy()
  {
    this((byte)0);
  }
  
  private zy(byte paramByte)
  {
    AppMethodBeat.i(91225);
    this.egE = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91225);
  }
  
  public static final class a
  {
    public String egF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.zy
 * JD-Core Version:    0.7.0.1
 */