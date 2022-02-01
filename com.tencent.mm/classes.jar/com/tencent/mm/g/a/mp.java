package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class mp
  extends IEvent
{
  public a dSe;
  
  public mp()
  {
    this((byte)0);
  }
  
  private mp(byte paramByte)
  {
    AppMethodBeat.i(149872);
    this.dSe = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149872);
  }
  
  public static final class a
  {
    public String dSf;
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.mp
 * JD-Core Version:    0.7.0.1
 */