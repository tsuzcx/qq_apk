package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class pm
  extends IEvent
{
  public a dVE;
  
  public pm()
  {
    this((byte)0);
  }
  
  private pm(byte paramByte)
  {
    AppMethodBeat.i(148770);
    this.dVE = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(148770);
  }
  
  public static final class a
  {
    public int dDe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.a.pm
 * JD-Core Version:    0.7.0.1
 */