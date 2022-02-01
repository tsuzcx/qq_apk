package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ln
  extends IEvent
{
  public a dQQ;
  
  public ln()
  {
    this((byte)0);
  }
  
  private ln(byte paramByte)
  {
    AppMethodBeat.i(224141);
    this.dQQ = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(224141);
  }
  
  public static final class a
  {
    public String content;
    public long dQR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.ln
 * JD-Core Version:    0.7.0.1
 */