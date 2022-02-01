package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class sy
  extends IEvent
{
  public a dZu;
  
  public sy()
  {
    this((byte)0);
  }
  
  private sy(byte paramByte)
  {
    AppMethodBeat.i(102633);
    this.dZu = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(102633);
  }
  
  public static final class a
  {
    public long msgId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.sy
 * JD-Core Version:    0.7.0.1
 */