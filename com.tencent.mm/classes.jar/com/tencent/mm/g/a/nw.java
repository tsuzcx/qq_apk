package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class nw
  extends IEvent
{
  public a dTY;
  
  public nw()
  {
    this((byte)0);
  }
  
  private nw(byte paramByte)
  {
    AppMethodBeat.i(200243);
    this.dTY = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(200243);
  }
  
  public static final class a
  {
    public boolean isVisible;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.nw
 * JD-Core Version:    0.7.0.1
 */