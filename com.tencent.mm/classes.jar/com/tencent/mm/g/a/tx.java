package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.ca;

public final class tx
  extends IEvent
{
  public a ear;
  
  public tx()
  {
    this((byte)0);
  }
  
  private tx(byte paramByte)
  {
    AppMethodBeat.i(42657);
    this.ear = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(42657);
  }
  
  public static final class a
  {
    public ca dCM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.tx
 * JD-Core Version:    0.7.0.1
 */