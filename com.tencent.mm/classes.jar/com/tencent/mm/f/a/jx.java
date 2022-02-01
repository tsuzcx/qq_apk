package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class jx
  extends IEvent
{
  public a fHl;
  
  public jx()
  {
    this((byte)0);
  }
  
  private jx(byte paramByte)
  {
    AppMethodBeat.i(149862);
    this.fHl = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149862);
  }
  
  public static final class a
  {
    public String appId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.jx
 * JD-Core Version:    0.7.0.1
 */