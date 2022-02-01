package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class mq
  extends IEvent
{
  public a hOM;
  
  public mq()
  {
    this((byte)0);
  }
  
  private mq(byte paramByte)
  {
    AppMethodBeat.i(369364);
    this.hOM = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(369364);
  }
  
  public static final class a
  {
    public int currentIndex;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.a.mq
 * JD-Core Version:    0.7.0.1
 */