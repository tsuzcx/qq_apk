package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ci
  extends IEvent
{
  public a hCs;
  
  public ci()
  {
    this((byte)0);
  }
  
  private ci(byte paramByte)
  {
    AppMethodBeat.i(114791);
    this.hCs = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(114791);
  }
  
  public static final class a
  {
    public boolean isStarted = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.autogen.a.ci
 * JD-Core Version:    0.7.0.1
 */