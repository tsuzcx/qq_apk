package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.ca;

public final class sw
  extends IEvent
{
  public a dZp;
  
  public sw()
  {
    this((byte)0);
  }
  
  private sw(byte paramByte)
  {
    AppMethodBeat.i(94799);
    this.dZp = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(94799);
  }
  
  public static final class a
  {
    public ca dTX;
    public String dZq;
    public ca dZr;
    public long dZs = 0L;
    public long msgId = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.sw
 * JD-Core Version:    0.7.0.1
 */