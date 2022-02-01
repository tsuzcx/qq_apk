package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class pq
  extends IEvent
{
  public a fOp;
  
  public pq()
  {
    this((byte)0);
  }
  
  private pq(byte paramByte)
  {
    AppMethodBeat.i(19823);
    this.fOp = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19823);
  }
  
  public static final class a
  {
    public String talker;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.pq
 * JD-Core Version:    0.7.0.1
 */