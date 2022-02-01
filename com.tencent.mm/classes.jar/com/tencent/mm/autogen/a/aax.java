package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aax
  extends IEvent
{
  public a iey;
  
  public aax()
  {
    this((byte)0);
  }
  
  private aax(byte paramByte)
  {
    AppMethodBeat.i(94819);
    this.iey = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(94819);
  }
  
  public static final class a
  {
    public long delay = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.a.aax
 * JD-Core Version:    0.7.0.1
 */