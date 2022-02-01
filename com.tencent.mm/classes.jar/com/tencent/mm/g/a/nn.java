package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class nn
  extends IEvent
{
  public a dTH;
  
  public nn()
  {
    this((byte)0);
  }
  
  private nn(byte paramByte)
  {
    AppMethodBeat.i(116035);
    this.dTH = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116035);
  }
  
  public static final class a
  {
    public int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.a.nn
 * JD-Core Version:    0.7.0.1
 */