package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.event.IEvent;

public final class iq
  extends IEvent
{
  public a fFN;
  
  public iq()
  {
    this((byte)0);
  }
  
  private iq(byte paramByte)
  {
    AppMethodBeat.i(265657);
    this.fFN = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(265657);
  }
  
  public static final class a
  {
    public int fFO;
    public String fFP;
    public WXMediaMessage fvl;
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.iq
 * JD-Core Version:    0.7.0.1
 */