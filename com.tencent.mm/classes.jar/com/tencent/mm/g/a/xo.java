package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class xo
  extends IEvent
{
  public a edO;
  
  public xo()
  {
    this((byte)0);
  }
  
  private xo(byte paramByte)
  {
    AppMethodBeat.i(162263);
    this.edO = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(162263);
  }
  
  public static final class a
  {
    public String viewId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.xo
 * JD-Core Version:    0.7.0.1
 */