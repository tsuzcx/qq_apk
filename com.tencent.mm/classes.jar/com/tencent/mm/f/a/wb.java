package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class wb
  extends IEvent
{
  public a fVj;
  
  public wb()
  {
    this((byte)0);
  }
  
  private wb(byte paramByte)
  {
    AppMethodBeat.i(19836);
    this.fVj = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19836);
  }
  
  public static final class a
  {
    public byte[] data;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.wb
 * JD-Core Version:    0.7.0.1
 */