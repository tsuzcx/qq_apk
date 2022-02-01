package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class tc
  extends IEvent
{
  public a fSw;
  
  public tc()
  {
    this((byte)0);
  }
  
  private tc(byte paramByte)
  {
    AppMethodBeat.i(257705);
    this.fSw = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(257705);
  }
  
  public static final class a
  {
    public byte[] buffer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.tc
 * JD-Core Version:    0.7.0.1
 */