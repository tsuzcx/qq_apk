package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class rd
  extends IEvent
{
  public a dXT;
  
  public rd()
  {
    this((byte)0);
  }
  
  private rd(byte paramByte)
  {
    AppMethodBeat.i(149882);
    this.dXT = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149882);
  }
  
  public static final class a
  {
    public int state = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.rd
 * JD-Core Version:    0.7.0.1
 */