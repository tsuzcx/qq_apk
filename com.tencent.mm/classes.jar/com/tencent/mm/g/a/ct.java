package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ct
  extends IEvent
{
  public a dFT;
  
  public ct()
  {
    this((byte)0);
  }
  
  private ct(byte paramByte)
  {
    AppMethodBeat.i(127400);
    this.dFT = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(127400);
  }
  
  public static final class a
  {
    public long localId = -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.ct
 * JD-Core Version:    0.7.0.1
 */