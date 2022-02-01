package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class w
  extends IEvent
{
  public a hzH;
  
  public w()
  {
    this((byte)0);
  }
  
  private w(byte paramByte)
  {
    AppMethodBeat.i(369398);
    this.hzH = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(369398);
  }
  
  public static final class a
  {
    public String appId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.w
 * JD-Core Version:    0.7.0.1
 */