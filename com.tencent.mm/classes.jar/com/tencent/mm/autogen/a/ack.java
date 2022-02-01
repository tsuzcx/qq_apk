package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ack
  extends IEvent
{
  public a ifO;
  
  public ack()
  {
    this((byte)0);
  }
  
  private ack(byte paramByte)
  {
    AppMethodBeat.i(125334);
    this.ifO = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125334);
  }
  
  public static final class a
  {
    public int hId = 0;
    public byte[] ifP;
    public int ifQ = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.autogen.a.ack
 * JD-Core Version:    0.7.0.1
 */