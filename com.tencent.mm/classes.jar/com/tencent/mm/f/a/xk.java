package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class xk
  extends IEvent
{
  public a fWr;
  
  public xk()
  {
    this((byte)0);
  }
  
  private xk(byte paramByte)
  {
    AppMethodBeat.i(131794);
    this.fWr = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(131794);
  }
  
  public static final class a
  {
    public int sourceType = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.xk
 * JD-Core Version:    0.7.0.1
 */