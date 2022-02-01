package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class xf
  extends IEvent
{
  public a edz;
  
  public xf()
  {
    this((byte)0);
  }
  
  private xf(byte paramByte)
  {
    AppMethodBeat.i(104421);
    this.edz = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(104421);
  }
  
  public static final class a
  {
    public String productId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.xf
 * JD-Core Version:    0.7.0.1
 */