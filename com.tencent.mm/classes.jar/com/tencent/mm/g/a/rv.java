package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class rv
  extends IEvent
{
  public a dYq;
  
  public rv()
  {
    this((byte)0);
  }
  
  private rv(byte paramByte)
  {
    AppMethodBeat.i(19828);
    this.dYq = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19828);
  }
  
  public static final class a
  {
    public int scene = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.rv
 * JD-Core Version:    0.7.0.1
 */