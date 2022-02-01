package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class rg
  extends IEvent
{
  public a dXW;
  
  public rg()
  {
    this((byte)0);
  }
  
  private rg(byte paramByte)
  {
    AppMethodBeat.i(168780);
    this.dXW = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(168780);
  }
  
  public static final class a
  {
    public boolean dXX = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.rg
 * JD-Core Version:    0.7.0.1
 */