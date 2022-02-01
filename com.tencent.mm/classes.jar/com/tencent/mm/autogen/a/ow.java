package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ow
  extends IEvent
{
  public a hRM;
  
  public ow()
  {
    this((byte)0);
  }
  
  private ow(byte paramByte)
  {
    AppMethodBeat.i(369330);
    this.hRM = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(369330);
  }
  
  public static final class a
  {
    public int errCode;
    public String errMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.autogen.a.ow
 * JD-Core Version:    0.7.0.1
 */