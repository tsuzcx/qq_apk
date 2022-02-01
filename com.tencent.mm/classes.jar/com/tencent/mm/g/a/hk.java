package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class hk
  extends IEvent
{
  public a dLT;
  
  public hk()
  {
    this((byte)0);
  }
  
  private hk(byte paramByte)
  {
    AppMethodBeat.i(168879);
    this.dLT = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(168879);
  }
  
  public static final class a
  {
    public long localId;
    public int progress;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.hk
 * JD-Core Version:    0.7.0.1
 */