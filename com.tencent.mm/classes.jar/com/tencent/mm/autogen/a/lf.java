package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class lf
  extends IEvent
{
  public a hMX;
  
  public lf()
  {
    this((byte)0);
  }
  
  private lf(byte paramByte)
  {
    AppMethodBeat.i(369405);
    this.hMX = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(369405);
  }
  
  public static final class a
  {
    public int channelId = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.a.lf
 * JD-Core Version:    0.7.0.1
 */