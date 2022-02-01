package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class po
  extends IEvent
{
  public a hSN;
  
  public po()
  {
    this((byte)0);
  }
  
  private po(byte paramByte)
  {
    AppMethodBeat.i(369325);
    this.hSN = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(369325);
  }
  
  public static final class a
  {
    public long hSK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.a.po
 * JD-Core Version:    0.7.0.1
 */