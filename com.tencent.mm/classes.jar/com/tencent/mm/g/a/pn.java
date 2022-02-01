package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class pn
  extends IEvent
{
  public a dVF;
  
  public pn()
  {
    this((byte)0);
  }
  
  private pn(byte paramByte)
  {
    AppMethodBeat.i(91037);
    this.dVF = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91037);
  }
  
  public static final class a
  {
    public int action = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.pn
 * JD-Core Version:    0.7.0.1
 */