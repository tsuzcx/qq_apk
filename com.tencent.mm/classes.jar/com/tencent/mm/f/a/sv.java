package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class sv
  extends IEvent
{
  public a fSh;
  
  public sv()
  {
    this((byte)0);
  }
  
  private sv(byte paramByte)
  {
    AppMethodBeat.i(19828);
    this.fSh = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19828);
  }
  
  public static final class a
  {
    public int scene = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.sv
 * JD-Core Version:    0.7.0.1
 */