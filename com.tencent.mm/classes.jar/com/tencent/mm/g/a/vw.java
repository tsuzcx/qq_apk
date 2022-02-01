package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class vw
  extends IEvent
{
  public a ebW;
  
  public vw()
  {
    this((byte)0);
  }
  
  private vw(byte paramByte)
  {
    AppMethodBeat.i(201824);
    this.ebW = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(201824);
  }
  
  public static final class a
  {
    public String dkU;
    public String mediaId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.vw
 * JD-Core Version:    0.7.0.1
 */