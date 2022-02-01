package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class sx
  extends IEvent
{
  public a dZt;
  
  public sx()
  {
    this((byte)0);
  }
  
  private sx(byte paramByte)
  {
    AppMethodBeat.i(94800);
    this.dZt = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(94800);
  }
  
  public static final class a
  {
    public long msgId = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.sx
 * JD-Core Version:    0.7.0.1
 */