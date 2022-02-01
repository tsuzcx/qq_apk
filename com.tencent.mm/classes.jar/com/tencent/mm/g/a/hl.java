package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class hl
  extends IEvent
{
  public a dLU;
  
  public hl()
  {
    this((byte)0);
  }
  
  private hl(byte paramByte)
  {
    AppMethodBeat.i(241573);
    this.dLU = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(241573);
  }
  
  public static final class a
  {
    public long feedId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.hl
 * JD-Core Version:    0.7.0.1
 */