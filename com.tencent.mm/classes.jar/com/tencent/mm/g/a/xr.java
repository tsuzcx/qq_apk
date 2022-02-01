package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class xr
  extends IEvent
{
  public a edW;
  
  public xr()
  {
    this((byte)0);
  }
  
  private xr(byte paramByte)
  {
    AppMethodBeat.i(149892);
    this.edW = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149892);
  }
  
  public static final class a
  {
    public boolean edX = false;
    public boolean edY = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.xr
 * JD-Core Version:    0.7.0.1
 */