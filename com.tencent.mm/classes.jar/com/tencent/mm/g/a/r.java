package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.event.IEvent;

public final class r
  extends IEvent
{
  public a dCD;
  
  public r()
  {
    this((byte)0);
  }
  
  private r(byte paramByte)
  {
    AppMethodBeat.i(226034);
    this.dCD = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(226034);
  }
  
  public static final class a
  {
    public WXMediaMessage dCE;
    public String toUser;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.r
 * JD-Core Version:    0.7.0.1
 */