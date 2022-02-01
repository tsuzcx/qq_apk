package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ce;
import com.tencent.mm.sdk.event.IEvent;

public final class ib
  extends IEvent
{
  public a fFf;
  
  public ib()
  {
    this((byte)0);
  }
  
  private ib(byte paramByte)
  {
    AppMethodBeat.i(168881);
    this.fFf = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(168881);
  }
  
  public static final class a
  {
    public long commentId = 0L;
    public long fFg = 0L;
    public ce fFh;
    public long feedId;
    public int opType = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.ib
 * JD-Core Version:    0.7.0.1
 */