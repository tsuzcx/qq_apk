package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class qe
  extends IEvent
{
  public a hTo;
  
  public qe()
  {
    this((byte)0);
  }
  
  private qe(byte paramByte)
  {
    AppMethodBeat.i(42654);
    this.hTo = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(42654);
  }
  
  public static final class a
  {
    public String nickName;
    public int type;
    public String userName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.qe
 * JD-Core Version:    0.7.0.1
 */