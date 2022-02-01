package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aq
  extends IEvent
{
  public a fwb;
  
  public aq()
  {
    this((byte)0);
  }
  
  private aq(byte paramByte)
  {
    AppMethodBeat.i(5531);
    this.fwb = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(5531);
  }
  
  public static final class a
  {
    public String userName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.aq
 * JD-Core Version:    0.7.0.1
 */