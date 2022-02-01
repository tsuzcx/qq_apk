package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class mw
  extends IEvent
{
  public a fLd;
  
  public mw()
  {
    this((byte)0);
  }
  
  private mw(byte paramByte)
  {
    AppMethodBeat.i(149870);
    this.fLd = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149870);
  }
  
  public static final class a
  {
    public IEvent fLe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.mw
 * JD-Core Version:    0.7.0.1
 */