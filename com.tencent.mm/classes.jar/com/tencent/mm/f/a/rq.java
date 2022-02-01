package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class rq
  extends IEvent
{
  public a fQQ;
  
  public rq()
  {
    this((byte)0);
  }
  
  private rq(byte paramByte)
  {
    AppMethodBeat.i(91213);
    this.fQQ = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91213);
  }
  
  public static final class a
  {
    public String content;
    public String fLi;
    public String fQR;
    public String toUser;
    public int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.rq
 * JD-Core Version:    0.7.0.1
 */