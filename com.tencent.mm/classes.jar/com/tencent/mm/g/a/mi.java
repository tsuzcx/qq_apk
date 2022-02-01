package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class mi
  extends IEvent
{
  public a dRI;
  
  public mi()
  {
    this((byte)0);
  }
  
  private mi(byte paramByte)
  {
    AppMethodBeat.i(131791);
    this.dRI = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(131791);
  }
  
  public static final class a
  {
    public boolean result;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.mi
 * JD-Core Version:    0.7.0.1
 */