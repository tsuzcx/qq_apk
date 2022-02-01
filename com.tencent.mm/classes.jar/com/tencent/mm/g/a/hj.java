package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class hj
  extends IEvent
{
  public a dLP;
  
  public hj()
  {
    this((byte)0);
  }
  
  private hj(byte paramByte)
  {
    AppMethodBeat.i(241572);
    this.dLP = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(241572);
  }
  
  public static final class a
  {
    public boolean dLD;
    public boolean dLQ;
    public boolean dLR;
    public int dLS;
    public long feedId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.hj
 * JD-Core Version:    0.7.0.1
 */