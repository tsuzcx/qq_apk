package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class pq
  extends IEvent
{
  public a dVG;
  
  public pq()
  {
    this((byte)0);
  }
  
  private pq(byte paramByte)
  {
    AppMethodBeat.i(149878);
    this.dVG = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149878);
  }
  
  public static final class a
  {
    public byte[] content;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.pq
 * JD-Core Version:    0.7.0.1
 */