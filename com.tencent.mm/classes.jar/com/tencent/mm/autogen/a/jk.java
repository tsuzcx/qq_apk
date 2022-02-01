package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.event.IEvent;

public final class jk
  extends IEvent
{
  public a hKY;
  
  public jk()
  {
    this((byte)0);
  }
  
  private jk(byte paramByte)
  {
    AppMethodBeat.i(369471);
    this.hKY = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(369471);
  }
  
  public static final class a
  {
    public int hKZ;
    public String hLa;
    public WXMediaMessage hzF;
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.jk
 * JD-Core Version:    0.7.0.1
 */