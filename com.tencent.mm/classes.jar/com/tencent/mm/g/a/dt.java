package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class dt
  extends IEvent
{
  public a dGM;
  
  public dt()
  {
    this((byte)0);
  }
  
  private dt(byte paramByte)
  {
    AppMethodBeat.i(115977);
    this.dGM = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(115977);
  }
  
  public static final class a
  {
    public boolean dor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.dt
 * JD-Core Version:    0.7.0.1
 */