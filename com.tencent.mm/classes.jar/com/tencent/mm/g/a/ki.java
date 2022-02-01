package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ki
  extends IEvent
{
  public a dPs;
  
  public ki()
  {
    this((byte)0);
  }
  
  private ki(byte paramByte)
  {
    AppMethodBeat.i(104418);
    this.dPs = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(104418);
  }
  
  public static final class a
  {
    public int errorCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.ki
 * JD-Core Version:    0.7.0.1
 */