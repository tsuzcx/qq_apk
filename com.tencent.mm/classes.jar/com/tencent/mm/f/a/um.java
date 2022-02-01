package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class um
  extends IEvent
{
  public a fTO;
  
  public um()
  {
    this((byte)0);
  }
  
  private um(byte paramByte)
  {
    AppMethodBeat.i(91040);
    this.fTO = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91040);
  }
  
  public static final class a
  {
    public int cUP = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.f.a.um
 * JD-Core Version:    0.7.0.1
 */