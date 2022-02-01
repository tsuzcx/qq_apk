package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class bh
  extends IEvent
{
  public a dEw;
  
  public bh()
  {
    this((byte)0);
  }
  
  private bh(byte paramByte)
  {
    AppMethodBeat.i(155365);
    this.dEw = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(155365);
  }
  
  public static final class a
  {
    public boolean result = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.bh
 * JD-Core Version:    0.7.0.1
 */