package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class qv
  extends IEvent
{
  public a dXn;
  
  public qv()
  {
    this((byte)0);
  }
  
  private qv(byte paramByte)
  {
    AppMethodBeat.i(19825);
    this.dXn = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19825);
  }
  
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.qv
 * JD-Core Version:    0.7.0.1
 */