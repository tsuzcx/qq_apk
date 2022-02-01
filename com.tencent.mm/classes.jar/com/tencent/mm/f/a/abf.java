package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class abf
  extends IEvent
{
  public a gaU;
  
  public abf()
  {
    this((byte)0);
  }
  
  private abf(byte paramByte)
  {
    AppMethodBeat.i(91225);
    this.gaU = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91225);
  }
  
  public static final class a
  {
    public String gaV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.a.abf
 * JD-Core Version:    0.7.0.1
 */