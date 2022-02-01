package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class cq
  extends IEvent
{
  public a fyo;
  
  public cq()
  {
    this((byte)0);
  }
  
  private cq(byte paramByte)
  {
    AppMethodBeat.i(91202);
    this.fyo = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91202);
  }
  
  public static final class a
  {
    public int resultCode = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.a.cq
 * JD-Core Version:    0.7.0.1
 */