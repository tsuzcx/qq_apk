package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ack
  extends IEvent
{
  public a gcI;
  
  public ack()
  {
    this((byte)0);
  }
  
  private ack(byte paramByte)
  {
    AppMethodBeat.i(43444);
    this.gcI = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(43444);
  }
  
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.ack
 * JD-Core Version:    0.7.0.1
 */