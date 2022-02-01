package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class oz
  extends IEvent
{
  public a hRQ;
  
  public oz()
  {
    this((byte)0);
  }
  
  private oz(byte paramByte)
  {
    AppMethodBeat.i(149874);
    this.hRQ = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149874);
  }
  
  public static final class a
  {
    public String businessType;
    public int errCode;
    public String hRR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.oz
 * JD-Core Version:    0.7.0.1
 */