package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ic
  extends IEvent
{
  public a dMI;
  
  public ic()
  {
    this((byte)0);
  }
  
  private ic(byte paramByte)
  {
    AppMethodBeat.i(208808);
    this.dMI = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(208808);
  }
  
  public static final class a
  {
    public long key;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.ic
 * JD-Core Version:    0.7.0.1
 */