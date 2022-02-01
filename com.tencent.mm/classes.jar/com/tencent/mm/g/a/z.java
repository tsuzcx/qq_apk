package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class z
  extends IEvent
{
  public a dCX;
  
  public z()
  {
    this((byte)0);
  }
  
  private z(byte paramByte)
  {
    AppMethodBeat.i(149849);
    this.dCX = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149849);
  }
  
  public static final class a
  {
    public int mode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.z
 * JD-Core Version:    0.7.0.1
 */