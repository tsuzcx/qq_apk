package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class em
  extends IEvent
{
  public a dHS;
  
  public em()
  {
    this((byte)0);
  }
  
  private em(byte paramByte)
  {
    AppMethodBeat.i(115996);
    this.dHS = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(115996);
  }
  
  public static final class a
  {
    public boolean dHT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.a.em
 * JD-Core Version:    0.7.0.1
 */