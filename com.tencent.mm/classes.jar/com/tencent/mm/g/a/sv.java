package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class sv
  extends IEvent
{
  public a dZo;
  
  public sv()
  {
    this((byte)0);
  }
  
  private sv(byte paramByte)
  {
    AppMethodBeat.i(187890);
    this.dZo = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(187890);
  }
  
  public static final class a
  {
    public long msgId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.sv
 * JD-Core Version:    0.7.0.1
 */