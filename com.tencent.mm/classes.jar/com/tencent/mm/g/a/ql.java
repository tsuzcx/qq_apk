package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ql
  extends IEvent
{
  public a dWU;
  
  public ql()
  {
    this((byte)0);
  }
  
  private ql(byte paramByte)
  {
    AppMethodBeat.i(104420);
    this.dWU = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(104420);
  }
  
  public static final class a
  {
    public String productId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.ql
 * JD-Core Version:    0.7.0.1
 */