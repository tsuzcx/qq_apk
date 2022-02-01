package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ta
  extends IEvent
{
  public a fSs;
  
  public ta()
  {
    this((byte)0);
  }
  
  private ta(byte paramByte)
  {
    AppMethodBeat.i(257659);
    this.fSs = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(257659);
  }
  
  public static final class a
  {
    public byte[] buffer;
    public String fSt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.ta
 * JD-Core Version:    0.7.0.1
 */