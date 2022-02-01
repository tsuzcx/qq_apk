package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class pi
  extends IEvent
{
  public a hSy;
  
  public pi()
  {
    this((byte)0);
  }
  
  private pi(byte paramByte)
  {
    AppMethodBeat.i(149875);
    this.hSy = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149875);
  }
  
  public static final class a
  {
    public int errCode = 0;
    public String errMsg;
    public int errType = 0;
    public IEvent hSz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.pi
 * JD-Core Version:    0.7.0.1
 */