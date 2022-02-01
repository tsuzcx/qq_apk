package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.sdk.event.IEvent;

public final class fx
  extends IEvent
{
  public a dJu;
  public b dJv;
  
  public fx()
  {
    this((byte)0);
  }
  
  private fx(byte paramByte)
  {
    AppMethodBeat.i(116018);
    this.dJu = new a();
    this.dJv = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116018);
  }
  
  public static final class a
  {
    public String content;
    public String dJw;
    public int flags;
    public int type;
  }
  
  public static final class b
  {
    public q dJx;
    public long msgId = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.fx
 * JD-Core Version:    0.7.0.1
 */