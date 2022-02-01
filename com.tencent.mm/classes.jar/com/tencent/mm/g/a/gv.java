package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class gv
  extends IEvent
{
  public a dKQ;
  
  public gv()
  {
    this((byte)0);
  }
  
  private gv(byte paramByte)
  {
    AppMethodBeat.i(133846);
    this.dKQ = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(133846);
  }
  
  public static final class a
  {
    public String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.gv
 * JD-Core Version:    0.7.0.1
 */