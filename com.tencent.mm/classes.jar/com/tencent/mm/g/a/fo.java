package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class fo
  extends IEvent
{
  public a dIN;
  
  public fo()
  {
    this((byte)0);
  }
  
  private fo(byte paramByte)
  {
    AppMethodBeat.i(55661);
    this.dIN = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(55661);
  }
  
  public static final class a
  {
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.fo
 * JD-Core Version:    0.7.0.1
 */