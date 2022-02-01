package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class rq
  extends IEvent
{
  public a dYj;
  
  public rq()
  {
    this((byte)0);
  }
  
  private rq(byte paramByte)
  {
    AppMethodBeat.i(125625);
    this.dYj = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125625);
  }
  
  public static final class a
  {
    public int state = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.rq
 * JD-Core Version:    0.7.0.1
 */