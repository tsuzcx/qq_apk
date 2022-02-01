package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class j
  extends IEvent
{
  public a dCb;
  
  public j()
  {
    this((byte)0);
  }
  
  private j(byte paramByte)
  {
    AppMethodBeat.i(155363);
    this.dCb = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(155363);
  }
  
  public static final class a
  {
    public int scene = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.j
 * JD-Core Version:    0.7.0.1
 */