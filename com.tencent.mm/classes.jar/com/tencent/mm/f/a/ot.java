package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ot
  extends IEvent
{
  public a fNA;
  
  public ot()
  {
    this((byte)0);
  }
  
  private ot(byte paramByte)
  {
    AppMethodBeat.i(247889);
    this.fNA = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(247889);
  }
  
  public static final class a
  {
    public boolean isVisible;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.a.ot
 * JD-Core Version:    0.7.0.1
 */