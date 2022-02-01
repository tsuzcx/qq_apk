package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class r
  extends IEvent
{
  public a hzs;
  
  public r()
  {
    this((byte)0);
  }
  
  private r(byte paramByte)
  {
    AppMethodBeat.i(369393);
    this.hzs = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(369393);
  }
  
  public static final class a
  {
    public String appId;
    public boolean hzt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.a.r
 * JD-Core Version:    0.7.0.1
 */