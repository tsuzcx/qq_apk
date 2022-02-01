package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class jx
  extends IEvent
{
  public a dOQ;
  
  public jx()
  {
    this((byte)0);
  }
  
  private jx(byte paramByte)
  {
    AppMethodBeat.i(155369);
    this.dOQ = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(155369);
  }
  
  public static final class a
  {
    public int scene = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.jx
 * JD-Core Version:    0.7.0.1
 */