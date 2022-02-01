package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class rh
  extends IEvent
{
  public a dXY;
  
  public rh()
  {
    this((byte)0);
  }
  
  private rh(byte paramByte)
  {
    AppMethodBeat.i(114406);
    this.dXY = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(114406);
  }
  
  public static final class a
  {
    public int type = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.a.rh
 * JD-Core Version:    0.7.0.1
 */