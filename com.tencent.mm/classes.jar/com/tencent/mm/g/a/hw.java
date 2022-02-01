package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class hw
  extends IEvent
{
  public a dMx;
  
  public hw()
  {
    this((byte)0);
  }
  
  private hw(byte paramByte)
  {
    AppMethodBeat.i(196070);
    this.dMx = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(196070);
  }
  
  public static final class a
  {
    public boolean dCs;
    public String dDJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.hw
 * JD-Core Version:    0.7.0.1
 */