package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.event.IEvent;

public final class s
  extends IEvent
{
  public a fvk;
  
  public s()
  {
    this((byte)0);
  }
  
  private s(byte paramByte)
  {
    AppMethodBeat.i(281685);
    this.fvk = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(281685);
  }
  
  public static final class a
  {
    public WXMediaMessage fvl;
    public String toUser;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.s
 * JD-Core Version:    0.7.0.1
 */