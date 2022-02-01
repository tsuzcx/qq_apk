package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class g
  extends IEvent
{
  public a dBU;
  
  public g()
  {
    this((byte)0);
  }
  
  private g(byte paramByte)
  {
    AppMethodBeat.i(115968);
    this.dBU = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(115968);
  }
  
  public static final class a
  {
    public String dBV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.g
 * JD-Core Version:    0.7.0.1
 */