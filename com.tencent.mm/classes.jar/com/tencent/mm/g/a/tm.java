package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class tm
  extends IEvent
{
  public a dZV;
  
  public tm()
  {
    this((byte)0);
  }
  
  private tm(byte paramByte)
  {
    AppMethodBeat.i(149888);
    this.dZV = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149888);
  }
  
  public static final class a
  {
    public String dZW;
    public int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.tm
 * JD-Core Version:    0.7.0.1
 */