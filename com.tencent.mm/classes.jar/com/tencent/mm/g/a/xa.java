package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class xa
  extends IEvent
{
  public a edt;
  
  public xa()
  {
    this((byte)0);
  }
  
  private xa(byte paramByte)
  {
    AppMethodBeat.i(19839);
    this.edt = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19839);
  }
  
  public static final class a
  {
    public boolean edu = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.a.xa
 * JD-Core Version:    0.7.0.1
 */