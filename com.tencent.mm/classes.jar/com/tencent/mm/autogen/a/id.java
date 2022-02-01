package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class id
  extends IEvent
{
  public a hJz;
  
  public id()
  {
    this((byte)0);
  }
  
  private id(byte paramByte)
  {
    AppMethodBeat.i(369431);
    this.hJz = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(369431);
  }
  
  public static final class a
  {
    public long feedId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.autogen.a.id
 * JD-Core Version:    0.7.0.1
 */