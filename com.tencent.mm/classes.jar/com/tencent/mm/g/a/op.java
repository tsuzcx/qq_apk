package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class op
  extends IEvent
{
  public a dUD;
  
  public op()
  {
    this((byte)0);
  }
  
  private op(byte paramByte)
  {
    AppMethodBeat.i(121051);
    this.dUD = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(121051);
  }
  
  public static final class a
  {
    public String dCl;
    public int dUE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.op
 * JD-Core Version:    0.7.0.1
 */