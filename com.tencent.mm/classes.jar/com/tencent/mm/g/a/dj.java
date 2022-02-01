package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class dj
  extends IEvent
{
  public a dGu;
  
  public dj()
  {
    this((byte)0);
  }
  
  private dj(byte paramByte)
  {
    AppMethodBeat.i(104412);
    this.dGu = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(104412);
  }
  
  public static final class a
  {
    public int state = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.dj
 * JD-Core Version:    0.7.0.1
 */