package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class hz
  extends IEvent
{
  public a dMB;
  
  public hz()
  {
    this((byte)0);
  }
  
  private hz(byte paramByte)
  {
    AppMethodBeat.i(208805);
    this.dMB = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(208805);
  }
  
  public static final class a
  {
    public long id;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.hz
 * JD-Core Version:    0.7.0.1
 */