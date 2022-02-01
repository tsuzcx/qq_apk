package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class tx
  extends IEvent
{
  public a hXN;
  
  public tx()
  {
    this((byte)0);
  }
  
  private tx(byte paramByte)
  {
    AppMethodBeat.i(114406);
    this.hXN = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(114406);
  }
  
  public static final class a
  {
    public int type = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.a.tx
 * JD-Core Version:    0.7.0.1
 */