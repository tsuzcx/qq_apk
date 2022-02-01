package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class uy
  extends IEvent
{
  public a ebn;
  
  public uy()
  {
    this((byte)0);
  }
  
  private uy(byte paramByte)
  {
    AppMethodBeat.i(201819);
    this.ebn = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(201819);
  }
  
  public static final class a
  {
    public int ebo = 0;
    public int ebp = 0;
    public int scrollX = 0;
    public int scrollY = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.uy
 * JD-Core Version:    0.7.0.1
 */