package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class rr
  extends IEvent
{
  public a hUK;
  
  public rr()
  {
    this((byte)0);
  }
  
  private rr(byte paramByte)
  {
    AppMethodBeat.i(149877);
    this.hUK = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149877);
  }
  
  public static final class a
  {
    public boolean pause;
    public String talker;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.rr
 * JD-Core Version:    0.7.0.1
 */