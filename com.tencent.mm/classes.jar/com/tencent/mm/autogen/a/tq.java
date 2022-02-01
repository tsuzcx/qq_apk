package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class tq
  extends IEvent
{
  public a hXs;
  
  public tq()
  {
    this((byte)0);
  }
  
  private tq(byte paramByte)
  {
    AppMethodBeat.i(369380);
    this.hXs = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(369380);
  }
  
  public static final class a
  {
    public String errMsg;
    public boolean hPw = false;
    public long msgId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.tq
 * JD-Core Version:    0.7.0.1
 */