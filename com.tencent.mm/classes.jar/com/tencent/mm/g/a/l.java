package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class l
  extends IEvent
{
  public a dCi;
  
  public l()
  {
    this((byte)0);
  }
  
  private l(byte paramByte)
  {
    AppMethodBeat.i(42650);
    this.dCi = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(42650);
  }
  
  public static final class a
  {
    public boolean isActive;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.l
 * JD-Core Version:    0.7.0.1
 */