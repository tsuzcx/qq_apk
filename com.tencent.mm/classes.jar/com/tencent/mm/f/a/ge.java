package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.sdk.event.IEvent;

public final class ge
  extends IEvent
{
  public a fCj;
  public b fCk;
  
  public ge()
  {
    this((byte)0);
  }
  
  private ge(byte paramByte)
  {
    AppMethodBeat.i(116018);
    this.fCj = new a();
    this.fCk = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116018);
  }
  
  public static final class a
  {
    public String content;
    public String fCl;
    public int flags;
    public int type;
  }
  
  public static final class b
  {
    public q fCm;
    public long msgId = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.ge
 * JD-Core Version:    0.7.0.1
 */