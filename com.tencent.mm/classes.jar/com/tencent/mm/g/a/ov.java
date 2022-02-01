package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ov
  extends IEvent
{
  public a dUP;
  
  public ov()
  {
    this((byte)0);
  }
  
  private ov(byte paramByte)
  {
    AppMethodBeat.i(130928);
    this.dUP = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(130928);
  }
  
  public static final class a
  {
    public int retCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.ov
 * JD-Core Version:    0.7.0.1
 */