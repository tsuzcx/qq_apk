package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ta
  extends IEvent
{
  public a hWD;
  
  public ta()
  {
    this((byte)0);
  }
  
  private ta(byte paramByte)
  {
    AppMethodBeat.i(104420);
    this.hWD = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(104420);
  }
  
  public static final class a
  {
    public String productId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.a.ta
 * JD-Core Version:    0.7.0.1
 */