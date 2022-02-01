package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class lh
  extends IEvent
{
  public a dQy;
  
  public lh()
  {
    this((byte)0);
  }
  
  private lh(byte paramByte)
  {
    AppMethodBeat.i(194249);
    this.dQy = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(194249);
  }
  
  public static final class a
  {
    public int action;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.lh
 * JD-Core Version:    0.7.0.1
 */