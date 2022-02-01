package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class cb
  extends IEvent
{
  public a dFh;
  
  public cb()
  {
    this((byte)0);
  }
  
  private cb(byte paramByte)
  {
    AppMethodBeat.i(149858);
    this.dFh = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149858);
  }
  
  public static final class a
  {
    public long dFi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.cb
 * JD-Core Version:    0.7.0.1
 */