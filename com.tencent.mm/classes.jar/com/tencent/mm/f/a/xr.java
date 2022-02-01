package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class xr
  extends IEvent
{
  public a fWB;
  
  public xr()
  {
    this((byte)0);
  }
  
  private xr(byte paramByte)
  {
    AppMethodBeat.i(125649);
    this.fWB = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125649);
  }
  
  public static final class a
  {
    public String id;
    public int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.xr
 * JD-Core Version:    0.7.0.1
 */