package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class wv
  extends IEvent
{
  public a iap;
  
  public wv()
  {
    this((byte)0);
  }
  
  private wv(byte paramByte)
  {
    AppMethodBeat.i(369366);
    this.iap = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(369366);
  }
  
  public static final class a
  {
    public long iaq;
    public String sessionId;
    public int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.a.wv
 * JD-Core Version:    0.7.0.1
 */