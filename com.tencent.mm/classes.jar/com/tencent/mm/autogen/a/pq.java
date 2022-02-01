package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class pq
  extends IEvent
{
  public a hSP;
  
  public pq()
  {
    this((byte)0);
  }
  
  private pq(byte paramByte)
  {
    AppMethodBeat.i(116034);
    this.hSP = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116034);
  }
  
  public static final class a
  {
    public boolean hSQ;
    public boolean hSR;
    public int hzj;
    public String talker;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.pq
 * JD-Core Version:    0.7.0.1
 */