package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class xi
  extends IEvent
{
  public a edC;
  
  public xi()
  {
    this((byte)0);
  }
  
  private xi(byte paramByte)
  {
    AppMethodBeat.i(149890);
    this.edC = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149890);
  }
  
  public static final class a
  {
    public int dJY = 0;
    public String edD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.xi
 * JD-Core Version:    0.7.0.1
 */