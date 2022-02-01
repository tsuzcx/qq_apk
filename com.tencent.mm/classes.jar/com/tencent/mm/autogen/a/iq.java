package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class iq
  extends IEvent
{
  public a hKd;
  
  public iq()
  {
    this((byte)0);
  }
  
  private iq(byte paramByte)
  {
    AppMethodBeat.i(369413);
    this.hKd = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(369413);
  }
  
  public static final class a
  {
    public int hKe;
    public long localId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.autogen.a.iq
 * JD-Core Version:    0.7.0.1
 */