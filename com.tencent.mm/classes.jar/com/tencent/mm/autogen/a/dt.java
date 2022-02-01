package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class dt
  extends IEvent
{
  public a hDF;
  
  public dt()
  {
    this((byte)0);
  }
  
  private dt(byte paramByte)
  {
    AppMethodBeat.i(369362);
    this.hDF = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(369362);
  }
  
  public static final class a
  {
    public int msgType;
    public String xml;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.dt
 * JD-Core Version:    0.7.0.1
 */