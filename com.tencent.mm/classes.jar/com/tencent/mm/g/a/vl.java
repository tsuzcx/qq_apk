package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class vl
  extends IEvent
{
  public a ebH;
  
  public vl()
  {
    this((byte)0);
  }
  
  private vl(byte paramByte)
  {
    AppMethodBeat.i(125635);
    this.ebH = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125635);
  }
  
  public static final class a
  {
    public long dNa = 0L;
    public boolean ebI = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.vl
 * JD-Core Version:    0.7.0.1
 */