package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class td
  extends IEvent
{
  public a hWK;
  
  public td()
  {
    this((byte)0);
  }
  
  private td(byte paramByte)
  {
    AppMethodBeat.i(369390);
    this.hWK = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(369390);
  }
  
  public static final class a
  {
    public long msgId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.td
 * JD-Core Version:    0.7.0.1
 */