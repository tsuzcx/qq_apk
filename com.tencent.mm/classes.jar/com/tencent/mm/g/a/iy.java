package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class iy
  extends IEvent
{
  public a dNC;
  
  public iy()
  {
    this((byte)0);
  }
  
  private iy(byte paramByte)
  {
    AppMethodBeat.i(89644);
    this.dNC = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(89644);
  }
  
  public static final class a
  {
    public String event;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.iy
 * JD-Core Version:    0.7.0.1
 */