package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aen
  extends IEvent
{
  public a ijf;
  
  public aen()
  {
    this((byte)0);
  }
  
  private aen(byte paramByte)
  {
    AppMethodBeat.i(149896);
    this.ijf = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149896);
  }
  
  public static final class a
  {
    public boolean success = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.autogen.a.aen
 * JD-Core Version:    0.7.0.1
 */