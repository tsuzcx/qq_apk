package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class mt
  extends IEvent
{
  public a fKR;
  
  public mt()
  {
    this((byte)0);
  }
  
  private mt(byte paramByte)
  {
    AppMethodBeat.i(19817);
    this.fKR = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19817);
  }
  
  public static final class a
  {
    public int opType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.a.mt
 * JD-Core Version:    0.7.0.1
 */