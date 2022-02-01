package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class tt
  extends IEvent
{
  public a fTc;
  
  public tt()
  {
    this((byte)0);
  }
  
  private tt(byte paramByte)
  {
    AppMethodBeat.i(55665);
    this.fTc = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(55665);
  }
  
  public static final class a
  {
    public boolean active;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.tt
 * JD-Core Version:    0.7.0.1
 */