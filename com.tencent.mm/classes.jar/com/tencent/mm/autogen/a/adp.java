package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class adp
  extends IEvent
{
  public a ihM;
  
  public adp()
  {
    this((byte)0);
  }
  
  private adp(byte paramByte)
  {
    AppMethodBeat.i(369465);
    this.ihM = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(369465);
  }
  
  public static final class a
  {
    public String hfG;
    public long ihN;
    public int ihO;
    public int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.a.adp
 * JD-Core Version:    0.7.0.1
 */