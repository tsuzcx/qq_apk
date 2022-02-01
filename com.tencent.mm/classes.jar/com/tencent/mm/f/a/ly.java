package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ly
  extends IEvent
{
  public a fJO;
  
  public ly()
  {
    this((byte)0);
  }
  
  private ly(byte paramByte)
  {
    AppMethodBeat.i(262497);
    this.fJO = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(262497);
  }
  
  public static final class a
  {
    public int action;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.f.a.ly
 * JD-Core Version:    0.7.0.1
 */