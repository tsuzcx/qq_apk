package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cd;
import com.tencent.mm.sdk.event.IEvent;

public final class hs
  extends IEvent
{
  public a dMm;
  
  public hs()
  {
    this((byte)0);
  }
  
  private hs(byte paramByte)
  {
    AppMethodBeat.i(168881);
    this.dMm = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(168881);
  }
  
  public static final class a
  {
    public long commentId = 0L;
    public long dMn = 0L;
    public cd dMo;
    public long feedId;
    public int opType = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.hs
 * JD-Core Version:    0.7.0.1
 */