package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class tl
  extends IEvent
{
  public a dZU;
  
  public tl()
  {
    this((byte)0);
  }
  
  private tl(byte paramByte)
  {
    AppMethodBeat.i(91040);
    this.dZU = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91040);
  }
  
  public static final class a
  {
    public int cSx = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.tl
 * JD-Core Version:    0.7.0.1
 */