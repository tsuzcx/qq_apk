package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class et
  extends IEvent
{
  public a dIb;
  
  public et()
  {
    this((byte)0);
  }
  
  private et(byte paramByte)
  {
    AppMethodBeat.i(116003);
    this.dIb = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116003);
  }
  
  public static final class a
  {
    public boolean dGW = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.et
 * JD-Core Version:    0.7.0.1
 */