package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class kq
  extends IEvent
{
  public a dPK;
  
  public kq()
  {
    this((byte)0);
  }
  
  private kq(byte paramByte)
  {
    AppMethodBeat.i(121033);
    this.dPK = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(121033);
  }
  
  public static final class a
  {
    public String dPI;
    public String sessionId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.a.kq
 * JD-Core Version:    0.7.0.1
 */