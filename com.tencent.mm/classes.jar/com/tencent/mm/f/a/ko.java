package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ko
  extends IEvent
{
  public a fIc;
  
  public ko()
  {
    this((byte)0);
  }
  
  private ko(byte paramByte)
  {
    AppMethodBeat.i(184504);
    this.fIc = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(184504);
  }
  
  public static final class a
  {
    public int fId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.a.ko
 * JD-Core Version:    0.7.0.1
 */