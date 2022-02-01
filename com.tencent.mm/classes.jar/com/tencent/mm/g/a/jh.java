package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class jh
  extends IEvent
{
  public a dOa;
  
  public jh()
  {
    this((byte)0);
  }
  
  private jh(byte paramByte)
  {
    AppMethodBeat.i(149862);
    this.dOa = new a();
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
 * Qualified Name:     com.tencent.mm.g.a.jh
 * JD-Core Version:    0.7.0.1
 */