package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ov
  extends IEvent
{
  public a fNC;
  
  public ov()
  {
    this((byte)0);
  }
  
  private ov(byte paramByte)
  {
    AppMethodBeat.i(184010);
    this.fNC = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(184010);
  }
  
  public static final class a
  {
    public String fND;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.ov
 * JD-Core Version:    0.7.0.1
 */