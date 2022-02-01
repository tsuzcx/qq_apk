package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class d
  extends IEvent
{
  public a hyI;
  
  public d()
  {
    this((byte)0);
  }
  
  private d(byte paramByte)
  {
    AppMethodBeat.i(131787);
    this.hyI = new a();
    this.order = true;
    this.callback = null;
    AppMethodBeat.o(131787);
  }
  
  public static final class a
  {
    public int errCode;
    public String errMsg;
    public int errType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.d
 * JD-Core Version:    0.7.0.1
 */