package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class hc
  extends IEvent
{
  public a fDF;
  
  public hc()
  {
    this((byte)0);
  }
  
  private hc(byte paramByte)
  {
    AppMethodBeat.i(133846);
    this.fDF = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(133846);
  }
  
  public static final class a
  {
    public String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.hc
 * JD-Core Version:    0.7.0.1
 */