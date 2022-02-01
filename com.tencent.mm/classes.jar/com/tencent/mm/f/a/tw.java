package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class tw
  extends IEvent
{
  public a fTh;
  
  public tw()
  {
    this((byte)0);
  }
  
  private tw(byte paramByte)
  {
    AppMethodBeat.i(255290);
    this.fTh = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(255290);
  }
  
  public static final class a
  {
    public long msgId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.tw
 * JD-Core Version:    0.7.0.1
 */