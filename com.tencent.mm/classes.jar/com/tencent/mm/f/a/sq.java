package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class sq
  extends IEvent
{
  public a fSa;
  
  public sq()
  {
    this((byte)0);
  }
  
  private sq(byte paramByte)
  {
    AppMethodBeat.i(125625);
    this.fSa = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125625);
  }
  
  public static final class a
  {
    public int state = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.sq
 * JD-Core Version:    0.7.0.1
 */