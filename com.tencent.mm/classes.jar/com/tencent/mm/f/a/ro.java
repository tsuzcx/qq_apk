package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ro
  extends IEvent
{
  public a fQN;
  
  public ro()
  {
    this((byte)0);
  }
  
  private ro(byte paramByte)
  {
    AppMethodBeat.i(243528);
    this.fQN = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(243528);
  }
  
  public static final class a
  {
    public long msgId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.ro
 * JD-Core Version:    0.7.0.1
 */