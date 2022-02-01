package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.event.IEvent;

public final class u
  extends IEvent
{
  public a hzE;
  
  public u()
  {
    this((byte)0);
  }
  
  private u(byte paramByte)
  {
    AppMethodBeat.i(369399);
    this.hzE = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(369399);
  }
  
  public static final class a
  {
    public WXMediaMessage hzF;
    public String toUser;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.u
 * JD-Core Version:    0.7.0.1
 */