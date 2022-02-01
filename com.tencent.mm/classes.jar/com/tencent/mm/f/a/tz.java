package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class tz
  extends IEvent
{
  public a fTn;
  
  public tz()
  {
    this((byte)0);
  }
  
  private tz(byte paramByte)
  {
    AppMethodBeat.i(102633);
    this.fTn = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(102633);
  }
  
  public static final class a
  {
    public long msgId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.tz
 * JD-Core Version:    0.7.0.1
 */