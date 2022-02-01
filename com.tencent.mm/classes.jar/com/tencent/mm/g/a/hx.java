package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class hx
  extends IEvent
{
  public a dMy;
  
  public hx()
  {
    this((byte)0);
  }
  
  private hx(byte paramByte)
  {
    AppMethodBeat.i(223485);
    this.dMy = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(223485);
  }
  
  public static final class a
  {
    public boolean dMz;
    public boolean isStart;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.hx
 * JD-Core Version:    0.7.0.1
 */