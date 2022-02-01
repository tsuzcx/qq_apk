package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class mc
  extends IEvent
{
  public a dRB;
  
  public mc()
  {
    this((byte)0);
  }
  
  private mc(byte paramByte)
  {
    AppMethodBeat.i(19817);
    this.dRB = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19817);
  }
  
  public static final class a
  {
    public int opType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.a.mc
 * JD-Core Version:    0.7.0.1
 */