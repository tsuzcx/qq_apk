package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ym
  extends IEvent
{
  public a fXI;
  
  public ym()
  {
    this((byte)0);
  }
  
  private ym(byte paramByte)
  {
    AppMethodBeat.i(104421);
    this.fXI = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(104421);
  }
  
  public static final class a
  {
    public String productId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.ym
 * JD-Core Version:    0.7.0.1
 */