package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class abo
  extends IEvent
{
  public a ifb;
  
  public abo()
  {
    this((byte)0);
  }
  
  private abo(byte paramByte)
  {
    AppMethodBeat.i(94801);
    this.ifb = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(94801);
  }
  
  public static final class a
  {
    public long ifc = -1L;
    public long ifd = -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.a.abo
 * JD-Core Version:    0.7.0.1
 */