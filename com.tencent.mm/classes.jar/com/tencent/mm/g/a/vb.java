package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class vb
  extends IEvent
{
  public a ebt;
  
  public vb()
  {
    this((byte)0);
  }
  
  private vb(byte paramByte)
  {
    AppMethodBeat.i(125632);
    this.ebt = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125632);
  }
  
  public static final class a
  {
    public boolean isStart;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.vb
 * JD-Core Version:    0.7.0.1
 */