package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class qo
  extends IEvent
{
  public a dXb;
  
  public qo()
  {
    this((byte)0);
  }
  
  private qo(byte paramByte)
  {
    AppMethodBeat.i(231467);
    this.dXb = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(231467);
  }
  
  public static final class a
  {
    public long msgId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.qo
 * JD-Core Version:    0.7.0.1
 */