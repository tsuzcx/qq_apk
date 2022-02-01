package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class av
  extends IEvent
{
  public a dDS;
  
  public av()
  {
    this((byte)0);
  }
  
  private av(byte paramByte)
  {
    AppMethodBeat.i(91196);
    this.dDS = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91196);
  }
  
  public static final class a
  {
    public String dDT;
    public String dDU;
    public int dDV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.av
 * JD-Core Version:    0.7.0.1
 */