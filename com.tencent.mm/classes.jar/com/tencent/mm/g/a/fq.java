package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class fq
  extends IEvent
{
  public a dIO;
  
  public fq()
  {
    this((byte)0);
  }
  
  private fq(byte paramByte)
  {
    AppMethodBeat.i(116015);
    this.dIO = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116015);
  }
  
  public static final class a
  {
    public int op;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.fq
 * JD-Core Version:    0.7.0.1
 */