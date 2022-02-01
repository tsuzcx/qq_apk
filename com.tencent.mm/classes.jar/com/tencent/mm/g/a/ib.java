package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.event.IEvent;

public final class ib
  extends IEvent
{
  public a dMF;
  
  public ib()
  {
    this((byte)0);
  }
  
  private ib(byte paramByte)
  {
    AppMethodBeat.i(208807);
    this.dMF = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(208807);
  }
  
  public static final class a
  {
    public WXMediaMessage dCE;
    public int dMG;
    public String dMH;
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.ib
 * JD-Core Version:    0.7.0.1
 */