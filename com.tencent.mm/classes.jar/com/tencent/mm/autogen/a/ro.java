package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ro
  extends IEvent
{
  public a hUF;
  
  public ro()
  {
    this((byte)0);
  }
  
  private ro(byte paramByte)
  {
    AppMethodBeat.i(369418);
    this.hUF = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(369418);
  }
  
  public static final class a
  {
    public int reason = 0;
    public int status = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.autogen.a.ro
 * JD-Core Version:    0.7.0.1
 */