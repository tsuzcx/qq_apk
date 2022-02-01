package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class qx
  extends IEvent
{
  public a hTW;
  
  public qx()
  {
    this((byte)0);
  }
  
  private qx(byte paramByte)
  {
    AppMethodBeat.i(130780);
    this.hTW = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(130780);
  }
  
  public static final class a
  {
    public int errCode = 0;
    public String errMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.a.qx
 * JD-Core Version:    0.7.0.1
 */