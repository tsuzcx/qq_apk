package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class bu
  extends IEvent
{
  public a dEZ;
  
  public bu()
  {
    this((byte)0);
  }
  
  private bu(byte paramByte)
  {
    AppMethodBeat.i(114791);
    this.dEZ = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(114791);
  }
  
  public static final class a
  {
    public boolean isStarted = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.bu
 * JD-Core Version:    0.7.0.1
 */