package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aav
  extends IEvent
{
  public a ehL;
  
  public aav()
  {
    this((byte)0);
  }
  
  private aav(byte paramByte)
  {
    AppMethodBeat.i(91236);
    this.ehL = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91236);
  }
  
  public static final class a
  {
    public String dvn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.aav
 * JD-Core Version:    0.7.0.1
 */