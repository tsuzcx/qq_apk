package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ad
  extends IEvent
{
  public a dDb;
  
  public ad()
  {
    this((byte)0);
  }
  
  private ad(byte paramByte)
  {
    AppMethodBeat.i(155364);
    this.dDb = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(155364);
  }
  
  public static final class a
  {
    public boolean dDc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.ad
 * JD-Core Version:    0.7.0.1
 */