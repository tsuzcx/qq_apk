package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class cm
  extends IEvent
{
  public a dFH;
  
  public cm()
  {
    this((byte)0);
  }
  
  private cm(byte paramByte)
  {
    AppMethodBeat.i(91202);
    this.dFH = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91202);
  }
  
  public static final class a
  {
    public int resultCode = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.cm
 * JD-Core Version:    0.7.0.1
 */