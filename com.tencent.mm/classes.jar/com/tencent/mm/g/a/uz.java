package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class uz
  extends IEvent
{
  public a ebq;
  
  public uz()
  {
    this((byte)0);
  }
  
  private uz(byte paramByte)
  {
    AppMethodBeat.i(94813);
    this.ebq = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(94813);
  }
  
  public static final class a
  {
    public String ebr;
    public int state;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.uz
 * JD-Core Version:    0.7.0.1
 */