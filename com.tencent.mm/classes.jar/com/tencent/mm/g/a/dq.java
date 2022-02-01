package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class dq
  extends IEvent
{
  public a dGE;
  
  public dq()
  {
    this((byte)0);
  }
  
  private dq(byte paramByte)
  {
    AppMethodBeat.i(115974);
    this.dGE = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(115974);
  }
  
  public static final class a
  {
    public boolean enable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.dq
 * JD-Core Version:    0.7.0.1
 */