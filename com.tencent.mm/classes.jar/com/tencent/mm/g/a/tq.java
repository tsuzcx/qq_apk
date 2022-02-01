package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class tq
  extends IEvent
{
  public a ead;
  
  public tq()
  {
    this((byte)0);
  }
  
  private tq(byte paramByte)
  {
    AppMethodBeat.i(148369);
    this.ead = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(148369);
  }
  
  public static final class a
  {
    public byte[] buf;
    public int len;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.a.tq
 * JD-Core Version:    0.7.0.1
 */