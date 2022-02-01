package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class sd
  extends IEvent
{
  public a fRK;
  
  public sd()
  {
    this((byte)0);
  }
  
  private sd(byte paramByte)
  {
    AppMethodBeat.i(149882);
    this.fRK = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149882);
  }
  
  public static final class a
  {
    public int state = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.sd
 * JD-Core Version:    0.7.0.1
 */