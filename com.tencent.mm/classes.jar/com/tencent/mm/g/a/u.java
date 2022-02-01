package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class u
  extends IEvent
{
  public a dCJ;
  
  public u()
  {
    this((byte)0);
  }
  
  private u(byte paramByte)
  {
    AppMethodBeat.i(104408);
    this.dCJ = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(104408);
  }
  
  public static final class a
  {
    public String dCK;
    public int percentage;
    public int status;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.u
 * JD-Core Version:    0.7.0.1
 */