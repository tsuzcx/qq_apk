package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.as;

public final class mq
  extends IEvent
{
  public a dSg;
  
  public mq()
  {
    this((byte)0);
  }
  
  private mq(byte paramByte)
  {
    AppMethodBeat.i(42653);
    this.dSg = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(42653);
  }
  
  public static final class a
  {
    public as dSh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.mq
 * JD-Core Version:    0.7.0.1
 */