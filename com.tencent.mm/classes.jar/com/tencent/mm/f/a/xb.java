package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class xb
  extends IEvent
{
  public a fVY;
  
  public xb()
  {
    this((byte)0);
  }
  
  private xb(byte paramByte)
  {
    AppMethodBeat.i(202959);
    this.fVY = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(202959);
  }
  
  public static final class a
  {
    public String fcC;
    public String mediaId;
    public int requestType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.xb
 * JD-Core Version:    0.7.0.1
 */