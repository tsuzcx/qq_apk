package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class kr
  extends IEvent
{
  public a dPL;
  
  public kr()
  {
    this((byte)0);
  }
  
  private kr(byte paramByte)
  {
    AppMethodBeat.i(121034);
    this.dPL = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(121034);
  }
  
  public static final class a
  {
    public String dPI;
    public String dPM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.a.kr
 * JD-Core Version:    0.7.0.1
 */