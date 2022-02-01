package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class on
  extends IEvent
{
  public a hRj;
  
  public on()
  {
    this((byte)0);
  }
  
  private on(byte paramByte)
  {
    AppMethodBeat.i(149872);
    this.hRj = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149872);
  }
  
  public static final class a
  {
    public String hRk;
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.on
 * JD-Core Version:    0.7.0.1
 */