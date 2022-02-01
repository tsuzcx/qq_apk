package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class dh
  extends IEvent
{
  public a dGr;
  
  public dh()
  {
    this((byte)0);
  }
  
  private dh(byte paramByte)
  {
    AppMethodBeat.i(104410);
    this.dGr = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(104410);
  }
  
  public static final class a
  {
    public int subType = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.dh
 * JD-Core Version:    0.7.0.1
 */